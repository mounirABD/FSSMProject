package models;
// Generated 4 juin 2016 14:39:34 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Etatdossier generated by hbm2java
 */
public class Etatdossier  implements java.io.Serializable {


     private Integer idEtat;
     private int idDeplacement;
     private Integer etat;
     private String motif;
     private String rmq;
     private String observation;
     private Date dateEtat;

    public Etatdossier() {
    }

	
    public Etatdossier(int idDeplacement) {
        this.idDeplacement = idDeplacement;
    }
    public Etatdossier(int idDeplacement, Integer etat, String motif, String rmq, String observation, Date dateEtat) {
       this.idDeplacement = idDeplacement;
       this.etat = etat;
       this.motif = motif;
       this.rmq = rmq;
       this.observation = observation;
       this.dateEtat = dateEtat;
    }
   
    public Integer getIdEtat() {
        return this.idEtat;
    }
    
    public void setIdEtat(Integer idEtat) {
        this.idEtat = idEtat;
    }
    public int getIdDeplacement() {
        return this.idDeplacement;
    }
    
    public void setIdDeplacement(int idDeplacement) {
        this.idDeplacement = idDeplacement;
    }
    public Integer getEtat() {
        return this.etat;
    }
    
    public void setEtat(Integer etat) {
        this.etat = etat;
    }
    public String getMotif() {
        return this.motif;
    }
    
    public void setMotif(String motif) {
        this.motif = motif;
    }
    public String getRmq() {
        return this.rmq;
    }
    
    public void setRmq(String rmq) {
        this.rmq = rmq;
    }
    public String getObservation() {
        return this.observation;
    }
    
    public void setObservation(String observation) {
        this.observation = observation;
    }
    public Date getDateEtat() {
        return this.dateEtat;
    }
    
    public void setDateEtat(Date dateEtat) {
        this.dateEtat = dateEtat;
    }




}


