package org.locationmateriel.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class SessionHibernate {
    // on crée notre thread dans lequel va se trouver notre session
    public static final ThreadLocal<Session> threadSession = new ThreadLocal<Session>();
    // on utilise un factory pour créer la session
    public static SessionFactory sessionFactory;
    // StandartServiceregistry permet de personnaliser la façon dont les services vont être récupérés
    private static StandardServiceRegistry serviceRegistry;

    static {
        try {
            System.out.println(new Date() + "initialisation de la session");

            // récupérer la config d’hibernate du fichier hibernate.cfg.xml
            Configuration configuration = new Configuration().configure();
            // setter le ServiceRegistry
            serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
            // On instancie notre sessionFactory
            // Créer des sessions
            sessionFactory  = configuration.buildSessionFactory(serviceRegistry);
        }catch (Throwable e) {
            e.printStackTrace();
        }
    }

    /**
     * méthode static pour récupérer une session
     * @return Session
     */
    public static Session currentSession() {
        // Je récupère la session du Thread en cours
        Session session = (Session) threadSession.get();
        // si je n'ai pas de session (!= du thread session plus haut)
        if( session == null) {
            System.out.println("Je n'ai pas de session active");

            // j'ouvre une session avec mon objet SessionFactory
            session = sessionFactory.openSession();
            System.out.println("J'ouvre une nouvelle session");

            // Je l'injecte dans le thread en cours
            threadSession.set(session);
            System.out.println("J'injecte ma session dans le thread en cours");
        }
        System.out.println("J'ai bien récupèré la session");

        return session;
    }

    /**
     * Méthode static pour fermer une session
     */
    public static void closeSession() {
        // Je récupère la session du Thread en cours
        Session session = (Session) threadSession.get();
        // si j'ai  une session (!= du thread session plus haut)
        if (session != null) session.close();
        threadSession.set(null);
        System.out.println("J'ai bien fermé la session");

    }
}
