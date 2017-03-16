/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mss;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bnp26
 */
@Entity
@Table(name = "Stud")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stud.findAll", query = "SELECT s FROM Stud s")
    , @NamedQuery(name = "Stud.findByStudioName", query = "SELECT s FROM Stud s WHERE s.studioName = :studioName")
    , @NamedQuery(name = "Stud.findByAddress", query = "SELECT s FROM Stud s WHERE s.address = :address")
    , @NamedQuery(name = "Stud.findByPresC", query = "SELECT s FROM Stud s WHERE s.presC = :presC")})
public class Stud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "studioName")
    private String studioName;
    @Basic(optional = false)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @Column(name = "presC#")
    private int presC;

    public Stud() {
    }

    public Stud(String studioName) {
        this.studioName = studioName;
    }

    public Stud(String studioName, String address, int presC) {
        this.studioName = studioName;
        this.address = address;
        this.presC = presC;
    }

    public String getStudioName() {
        return studioName;
    }

    public void setStudioName(String studioName) {
        this.studioName = studioName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPresC() {
        return presC;
    }

    public void setPresC(int presC) {
        this.presC = presC;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studioName != null ? studioName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stud)) {
            return false;
        }
        Stud other = (Stud) object;
        if ((this.studioName == null && other.studioName != null) || (this.studioName != null && !this.studioName.equals(other.studioName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mss.Stud[ studioName=" + studioName + " ]";
    }
    
}
