/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "graddiplome")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Graddiplome.findAll", query = "SELECT g FROM Graddiplome g"),
    @NamedQuery(name = "Graddiplome.findByIdGrade", query = "SELECT g FROM Graddiplome g WHERE g.idGrade = :idGrade"),
    @NamedQuery(name = "Graddiplome.findByIntituleGrade", query = "SELECT g FROM Graddiplome g WHERE g.intituleGrade = :intituleGrade"),
    @NamedQuery(name = "Graddiplome.findByTaux", query = "SELECT g FROM Graddiplome g WHERE g.taux = :taux")})
public class Graddiplome implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idGrade")
    private Integer idGrade;
    @Size(max = 254)
    @Column(name = "intituleGrade")
    private String intituleGrade;
    @Column(name = "taux")
    private Integer taux;
    @OneToMany(mappedBy = "idGrade", fetch = FetchType.EAGER)
    private List<Dossiervacataire> dossiervacataireList;
    @OneToMany(mappedBy = "idGrade", fetch = FetchType.EAGER)
    private List<Dossierhsupp> dossierhsuppList;
    @OneToMany(mappedBy = "idGrade", fetch = FetchType.EAGER)
    private List<Dossierprovisoir> dossierprovisoirList;

    public Graddiplome() {
    }

    public Graddiplome(Integer idGrade) {
        this.idGrade = idGrade;
    }

    public Integer getIdGrade() {
        return idGrade;
    }

    public void setIdGrade(Integer idGrade) {
        this.idGrade = idGrade;
    }

    public String getIntituleGrade() {
        return intituleGrade;
    }

    public void setIntituleGrade(String intituleGrade) {
        this.intituleGrade = intituleGrade;
    }

    public Integer getTaux() {
        return taux;
    }

    public void setTaux(Integer taux) {
        this.taux = taux;
    }

    @XmlTransient
    public List<Dossiervacataire> getDossiervacataireList() {
        return dossiervacataireList;
    }

    public void setDossiervacataireList(List<Dossiervacataire> dossiervacataireList) {
        this.dossiervacataireList = dossiervacataireList;
    }

    @XmlTransient
    public List<Dossierhsupp> getDossierhsuppList() {
        return dossierhsuppList;
    }

    public void setDossierhsuppList(List<Dossierhsupp> dossierhsuppList) {
        this.dossierhsuppList = dossierhsuppList;
    }

    @XmlTransient
    public List<Dossierprovisoir> getDossierprovisoirList() {
        return dossierprovisoirList;
    }

    public void setDossierprovisoirList(List<Dossierprovisoir> dossierprovisoirList) {
        this.dossierprovisoirList = dossierprovisoirList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGrade != null ? idGrade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Graddiplome)) {
            return false;
        }
        Graddiplome other = (Graddiplome) object;
        if ((this.idGrade == null && other.idGrade != null) || (this.idGrade != null && !this.idGrade.equals(other.idGrade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Graddiplome[ idGrade=" + idGrade + " ]";
    }
    
}
