package org.locationmateriel.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="client", schema="location_materiel" )
public class ClientEntity {
    /////////
    // ATTRIBUTS
    /////////
    @Id
    private int id;
    private String nom;
    private int type;
    private String telephone;
    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private List<FicheLocationEntity> fiches;
    @ManyToOne
    @JoinColumn(name="adresse_id")
    private AdresseEntity adresse;

    /////////
    // GETTERS SETTERS
    /////////
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public int getType() { return type; }
    public void setType(int type) { this.type = type; }

    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    public List<FicheLocationEntity> getFiches() { return fiches; }
    public void setFiches(List<FicheLocationEntity> fiches) { this.fiches = fiches; }

    public AdresseEntity getAdresse() { return adresse; }
    public void setAdresse(AdresseEntity adresse) { this.adresse = adresse; }
}
