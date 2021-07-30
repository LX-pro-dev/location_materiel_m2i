package org.locationmateriel.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="materiel", schema = "location_materiel")
public class MaterielEntity {

    /////////
    // ATTRIBUTS
    /////////
    private int id;
    private String desigantion;
    @Column(name = "date_achat")
    private Date dateAchat;
    @Column(name = "prix_location_journalier")
    private int prixLocationJournalier;
    private String categorie;
    private List<FicheLocationEntity> fiches;

    /////////
    // GETTERS SETTERS
    /////////
    @Id
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getDesigantion() { return desigantion; }
    public void setDesigantion(String designation) { this.desigantion = designation; }

    @Column(name ="date_achat")
    public Date getDateAchat() { return dateAchat; }
    public void setDateAchat(Date date_achat) { this.dateAchat = date_achat; }

    @Column(name ="prix_location_journalier")
    public int getPrixLocationJournalier() { return prixLocationJournalier; }
    public void setPrixLocationJournalier(int prixLocationJournalier) { this.prixLocationJournalier = prixLocationJournalier; }

    public String getCategorie() { return categorie; }
    public void setCategorie(String categorie) { this.categorie = categorie; }

    @ManyToMany(mappedBy="materiels")
    public List<FicheLocationEntity> getFiches() { return fiches; }
    public void setFiches(List<FicheLocationEntity> fiches) { this.fiches = fiches; }
}
