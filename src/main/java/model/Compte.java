/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mounir
 */
@Entity
@Table(name = "compte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Compte.findAll", query = "SELECT c FROM Compte c"),
    @NamedQuery(name = "Compte.findByIdCompte", query = "SELECT c FROM Compte c WHERE c.idCompte = :idCompte"),
    @NamedQuery(name = "Compte.findByIntitule", query = "SELECT c FROM Compte c WHERE c.intitule = :intitule"),
    @NamedQuery(name = "Compte.findByRap", query = "SELECT c FROM Compte c WHERE c.rap = :rap")})
public class Compte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCompte")
    private Integer idCompte;
    @Size(max = 254)
    @Column(name = "intitule")
    private String intitule;
    @Column(name = "rap")
    private Integer rap;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compte", fetch = FetchType.EAGER)
    private List<Budget> budgetList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCompte", fetch = FetchType.EAGER)
    private List<Dotationsecteur> dotationsecteurList;

    public Compte() {
    }

    public Compte(Integer idCompte) {
        this.idCompte = idCompte;
    }

    public Integer getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(Integer idCompte) {
        this.idCompte = idCompte;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Integer getRap() {
        return rap;
    }

    public void setRap(Integer rap) {
        this.rap = rap;
    }

    @XmlTransient
    public List<Budget> getBudgetList() {
        return budgetList;
    }

    public void setBudgetList(List<Budget> budgetList) {
        this.budgetList = budgetList;
    }

    @XmlTransient
    public List<Dotationsecteur> getDotationsecteurList() {
        return dotationsecteurList;
    }

    public void setDotationsecteurList(List<Dotationsecteur> dotationsecteurList) {
        this.dotationsecteurList = dotationsecteurList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCompte != null ? idCompte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compte)) {
            return false;
        }
        Compte other = (Compte) object;
        if ((this.idCompte == null && other.idCompte != null) || (this.idCompte != null && !this.idCompte.equals(other.idCompte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Compte[ idCompte=" + idCompte + " ]";
    }
    
}