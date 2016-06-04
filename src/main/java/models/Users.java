package models;
// Generated 4 juin 2016 14:39:34 by Hibernate Tools 4.3.1



/**
 * Users generated by hbm2java
 */
public class Users  implements java.io.Serializable {


     private Integer idUser;
     private String login;
     private String password;
     private String nom;
     private String prenom;
     private String telephone;
     private String email;
     private String img;

    public Users() {
    }

    public Users(String login, String password, String nom, String prenom, String telephone, String email, String img) {
       this.login = login;
       this.password = password;
       this.nom = nom;
       this.prenom = prenom;
       this.telephone = telephone;
       this.email = email;
       this.img = img;
    }
   
    public Integer getIdUser() {
        return this.idUser;
    }
    
    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }
    public String getLogin() {
        return this.login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getNom() {
        return this.nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return this.prenom;
    }
    
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getTelephone() {
        return this.telephone;
    }
    
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getImg() {
        return this.img;
    }
    
    public void setImg(String img) {
        this.img = img;
    }




}


