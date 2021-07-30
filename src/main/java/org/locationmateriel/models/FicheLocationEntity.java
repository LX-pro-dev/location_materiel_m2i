package org.locationmateriel.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="fiche_location", schema="location_materiel")
public class FicheLocationEntity {
    /////////
    // ATTRIBUTS
    /////////
    @Id
    @Column(name = "num_unique")
    private int numUnique;

    @Column(name = "date_location")
    private Date dateLocation;

    @Column(name = "date_retour")
    private Date dateRetour;

    @Column(name = "duree_en_jours")
    private int dureeEnJours;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientEntity client;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<MaterielEntity> materiels;

    /////////
    // GETTERS SETTERS
    /////////
    public int getNumUnique() { return numUnique; }
    public void setNumUnique(int numUnique) { this.numUnique = numUnique; }

    public Date getDateLocation() { return dateLocation; }
    public void setDateLocation(Date date_location) { this.dateLocation = date_location; }

    public int getDureeEnJours() { return dureeEnJours; }
    public void setDureeEnJours(int dureeEnJours) { this.dureeEnJours = dureeEnJours; }

    public Date getDateRetour() { return dateRetour; }
    public void setDateRetour(Date dateRetour) { this.dateRetour = dateRetour; }


    public ClientEntity getClient() { return client; }
    public void setClient(ClientEntity client) { this.client = client; }

    public List<MaterielEntity> getMateriels() { return materiels; }
    public void setMateriels(List<MaterielEntity> materiels) {this.materiels = materiels; }
}
