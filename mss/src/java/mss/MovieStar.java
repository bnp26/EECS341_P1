/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mss;

import java.util.Date;

/**
 *
 * @author bnp26
 */
public class MovieStar {
    
    private String starName;
    private String address;
    private String gender;
    private Date birthdate;
    
    public MovieStar() {
    }

    public MovieStar(String starName) {
        this.starName = starName;
    }

    public MovieStar(String starName, String address, String gender, Date birthdate) {
        this.starName = starName;
        this.address = address;
        this.gender = gender;
        this.birthdate = birthdate;
    }

    public String getStarName() {
        return starName;
    }

    public void setStarName(String starName) {
        this.starName = starName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthdate() {
        return birthdate;
    }
    
    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (starName != null ? starName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MovieStar)) {
            return false;
        }
        MovieStar other = (MovieStar) object;
        if ((this.starName == null && other.starName != null) || (this.starName != null && !this.starName.equals(other.starName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mss.MovieStar[ starName=" + starName + " ]";
    }
}
