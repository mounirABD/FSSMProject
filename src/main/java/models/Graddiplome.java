package models;
// Generated 4 juin 2016 14:39:34 by Hibernate Tools 4.3.1



/**
 * Graddiplome generated by hbm2java
 */
public class Graddiplome  implements java.io.Serializable {


     private Integer idGrade;
     private String intituleGrade;
     private Integer taux;

    public Graddiplome() {
    }

    public Graddiplome(String intituleGrade, Integer taux) {
       this.intituleGrade = intituleGrade;
       this.taux = taux;
    }
   
    public Integer getIdGrade() {
        return this.idGrade;
    }
    
    public void setIdGrade(Integer idGrade) {
        this.idGrade = idGrade;
    }
    public String getIntituleGrade() {
        return this.intituleGrade;
    }
    
    public void setIntituleGrade(String intituleGrade) {
        this.intituleGrade = intituleGrade;
    }
    public Integer getTaux() {
        return this.taux;
    }
    
    public void setTaux(Integer taux) {
        this.taux = taux;
    }




}


