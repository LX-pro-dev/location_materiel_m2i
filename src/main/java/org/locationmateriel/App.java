package org.locationmateriel;

import org.locationmateriel.models.AdresseEntity;
import org.locationmateriel.models.ClientEntity;
import org.locationmateriel.models.FicheLocationEntity;
import org.locationmateriel.models.MaterielEntity;
import org.locationmateriel.repositories.AdresseRepository;
import org.locationmateriel.repositories.ClientRepository;
import org.locationmateriel.repositories.FicheLocationRepository;
import org.locationmateriel.repositories.MaterielRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class App {
    public static void main(String[] args) {
        //AdresseRepository adresseRepository = new AdresseRepository();
        //AdresseEntity adresse = adresseRepository.get(1,AdresseEntity.class);
//        AdresseEntity adresseEntity = new AdresseEntity();
//        adresseEntity.setNumRue(10);
//        adresseEntity.setNomRue("Tabaga");
//        adresseEntity.setCodePostale("60200");
//        adresseEntity.setNomVille("Compiègne");
//        adresseRepository.save(adresseEntity);
//       AdresseEntity adresse = adresseRepository.get(2, AdresseEntity.class);
//        adresse.getClients().forEach(client -> {
//            System.out.println(client.getNom());
//        });
       ClientRepository clientRepository = new ClientRepository();
        ClientEntity client = clientRepository.get(1,ClientEntity.class);
        System.out.println(client);
//        client.setNom("Momo");
//        client.setTelephone("0750701518");
//        client.setType(1);
//        client.setAdresse(adresse);
//        clientRepository.save(client);

//        clientRepository.delete(client);

//        MaterielRepository materielRepository = new MaterielRepository();
//        MaterielEntity materielEntity = new MaterielEntity();
//        materielEntity.setCategorie("MI");
//        materielEntity.setDesigantion("Presse numérique");
      Date dateLocation = null;
      Date dateRetour = null;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        String dateLoc = "20/06/2021";
        String dateRet = "28/06/2021";

        try {
            dateLocation = simpleDateFormat.parse(dateLoc);
            dateRetour = simpleDateFormat.parse(dateRet);

        } catch (ParseException e) {
            e.printStackTrace();
        }
//        materielEntity.setDateAchat(date);
//
//        materielEntity.setPrixLocationJournalier(1000000);
//
//        materielRepository.save(materielEntity);

        FicheLocationRepository ficheLocationRepository = new FicheLocationRepository();
        FicheLocationEntity ficheLocationEntity = new FicheLocationEntity();
        ficheLocationEntity.setDateLocation(dateLocation);
        ficheLocationEntity.setDateRetour(dateRetour);
        ficheLocationEntity.setDureeEnJours(9);
        ficheLocationEntity.setClient(client);

        ficheLocationRepository.save(ficheLocationEntity);





    }
}
