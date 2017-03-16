/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mss;

/**
 *
 * @author bnp26
 */
public class Studio {
    private String studioName;
    private String address;
    private MovieExec president;
    public Studio() {
        
    }

    public Studio(String studioName) {
        this.studioName = studioName;
    }

    public Studio(String studioName, String address, MovieExec pres) {
        this.studioName = studioName;
        this.address = address;
        this.president = pres;
    }

    public String getStudioioName() {
        return studioName;
    }

    public void setStudioioName(String studioName) {
        this.studioName = studioName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public MovieExec getPresident() {
        return president;
    }

    public void setPresident(MovieExec pres) {
        this.president = pres;
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
        if (!(object instanceof Studio)) {
            return false;
        }
        Studio other = (Studio) object;
        if ((this.studioName == null && other.studioName != null) || (this.studioName != null && !this.studioName.equals(other.studioName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mss.Studio[ studioName=" + studioName + " ]";
    }   
}
