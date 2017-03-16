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
public class MoviePK {
    private String movieName;
    private int movieYear;
    
    public MoviePK(String name, int year) {
        movieName = name;
        movieYear = year;
    }
    
    public String getName() {
        return movieName;
    }
    
    public int getYear() {
        return movieYear;
    }
}
