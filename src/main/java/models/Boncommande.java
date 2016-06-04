package models;
// Generated 4 juin 2016 14:39:34 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Boncommande generated by hbm2java
 */
public class Boncommande  implements java.io.Serializable {


     private Integer idBc;
     private int idFournisseur;
     private int idUser;
     private int idDotation;
     private Date dateCommande;
     private Integer tva;
     private Date dateReception;
     private String etat;
     private Integer montant;
     private String type;

    public Boncommande() {
    }

	
    public Boncommande(int idFournisseur, int idUser, int idDotation) {
        this.idFournisseur = idFournisseur;
        this.idUser = idUser;
        this.idDotation = idDotation;
    }
    public Boncommande(int idFournisseur, int idUser, int idDotation, Date dateCommande, Integer tva, Date dateReception, String etat, Integer montant, String type) {
       this.idFournisseur = idFournisseur;
       this.idUser = idUser;
       this.idDotation = idDotation;
       this.dateCommande = dateCommande;
       this.tva = tva;
       this.dateReception = dateReception;
       this.etat = etat;
       this.montant = montant;
       this.type = type;
    }
   
    public Integer getIdBc() {
        return this.idBc;
    }
    
    public void setIdBc(Integer idBc) {
        this.idBc = idBc;
    }
    public int getIdFournisseur() {
        return this.idFournisseur;
    }
    
    public void setIdFournisseur(int idFournisseur) {
        this.idFournisseur = idFournisseur;
    }
    public int getIdUser() {
        return this.idUser;
    }
    
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    public int getIdDotation() {
        return this.idDotation;
    }
    
    public void setIdDotation(int idDotation) {
        this.idDotation = idDotation;
    }
    public Date getDateCommande() {
        return this.dateCommande;
    }
    
    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }
    public Integer getTva() {
        return this.tva;
    }
    
    public void setTva(Integer tva) {
        this.tva = tva;
    }
    public Date getDateReception() {
        return this.dateReception;
    }
    
    public void setDateReception(Date dateReception) {
        this.dateReception = dateReception;
    }
    public String getEtat() {
        return this.etat;
    }
    
    public void setEtat(String etat) {
        this.etat = etat;
    }
    public Integer getMontant() {
        return this.montant;
    }
    
    public void setMontant(Integer montant) {
        this.montant = montant;
    }
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }




}


