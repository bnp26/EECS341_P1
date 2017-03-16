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
public class Movie {
    
    private MoviePK moviePK;
    private int length;
    private String genre;
    private MovieExec producer;
    private Studio studio;

    public Movie() {
        this.moviePK = null;
        this.genre = null;
        this.length = 0;
        this.producer = null;
        this.studio = null;
    }
    
    public Movie(String title, int year, String genre, int length, MovieExec producer, Studio studio) {
        this.moviePK = new MoviePK(title, year);
        this.genre = genre;
        this.length = length;
        this.producer = producer;
        this.studio = studio;
    }

    public Movie(String title, int year) {
        this.moviePK = new MoviePK(title, year);
    }

    public MoviePK getMoviePK() {
        return moviePK;
    }

    public void setMoviePK(MoviePK moviePK) {
        this.moviePK = moviePK;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Studio getStudio() {
        return studio;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }

    public MovieExec getProducer() {
        return producer;
    }

    public void setProducer(MovieExec producer) {
        this.producer = producer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (moviePK != null ? moviePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movie)) {
            return false;
        }
        Movie other = (Movie) object;
        if ((this.moviePK == null && other.moviePK != null) || (this.moviePK != null && !this.moviePK.equals(other.moviePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mss.Movies[ moviePK=" + moviePK + " ]";
    }
    
    
}
