package org.locationmateriel.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="adresse", schema="location_materiel")
public class AdresseEntity {
    /////////
    // ATTRIBUTS
    /////////
    @Id
    private int id;
    private int numRue;
    private String nomRue;
    private String codePostale;
    private String nomVille;
    @OneToMany(mappedBy = "adresse", fetch = FetchType.EAGER)
    private List<ClientEntity> clients;
    /////////
    // GETTERS SETTERS
    /////////
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    @Column(name = "num_rue")
    public int getNumRue() { return numRue; }
    public void setNumRue(int numRue) { this.numRue = numRue; }

    @Column(name = "nom_rue")
    public String getNomRue() { return nomRue; }
    public void setNomRue(String nomRue) { this.nomRue = nomRue; }

    @Column(name = "code_postale")
    public String getCodePostale() { return codePostale; }
    public void setCodePostale(String codePostale) { this.codePostale = codePostale; }

    @Column(name = "nom_ville")
    public String getNomVille() { return nomVille; }
    public void setNomVille(String nomVille) { this.nomVille = nomVille; }

    public List<ClientEntity> getClients() { return clients; }
    public void setClients(List<ClientEntity> clients) { this.clients = clients; }
}
