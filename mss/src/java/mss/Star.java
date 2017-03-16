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
public class Star {
    private MoviePK movie;
    private MovieStar star;
    
    public Star() {
        movie = null;
        star = null;
    }
    
    public Star(MoviePK movie, MovieStar star) {
        this.movie = movie;
        this.star = star;
    }
    
    public MoviePK getMovie() {
        return movie;
    }
    
    public void setMovie(MoviePK movie) {
        this.movie = movie;
    }
    
    public MovieStar getStar() {
        return star;
    }
    
    public void setStar(MovieStar star) {
        this.star = star;
    }
    
    
}
