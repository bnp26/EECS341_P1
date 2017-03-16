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
import mss.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class Main {
    public static void main(String str[])
    {
        try{
            MySQLConnector connector = new MySQLConnector();
            
            //Query #1
            MovieStar meryl = connector.findMovieStar("Meryl Streep");
            ArrayList<Movie> merylMovies = connector.findMoviesViaMovieStar(meryl);
            System.out.println("QUERY #1");
            System.out.format("|%-25s|%-10s|%-13s|\n", "Movie Title", "Movie Year", "Movie Star");
            System.out.println("-----------------------------------------------------------");
            for(Movie movie:merylMovies) {
                System.out.format("|%-25s|%-10s|%-13s|\n", movie.getMoviePK().getName(), String.valueOf(movie.getMoviePK().getYear()), meryl.getStarName());
            }
            
            //Query #2
            System.out.println("\n\nQUERY #2");
            ResultSet result = connector.callQuery(MySQLConnector.query2);
            System.out.format("|%-25s|%-25s|%-10s|\n", "Studio Name", "Movie Title", "Movie Year");
            System.out.println("----------------------------------------------------------------");
            while(result.next()) {
                String studioName = result.getString("studioName");
                String movieTitle = result.getString("movieTitle");
                String movieYear = String.valueOf(result.getInt("movieYear"));
                System.out.format("|%-25s|%-25s|%-10s|\n", studioName, movieTitle,movieYear);
            }
            
            //Query#2 With Length
            query2WithLength(connector);
            
            //Query#3
            System.out.println("Query #3 with MGM");
            query3(connector, "MGM");
            
            //Query#3 example with 20th Century Fox (for your convenience) 
            System.out.println("Query #3 with 20th Century Fox");
            query3(connector, "20th Century Fox");
            
            System.out.println("Query #4");
            query4(connector);
            
            System.out.println("Query #5");
            query5(connector);
            
        }catch(Exception ex) {
            System.out.println(ex.toString());
        }
    }
    //This method is just for showing correctness.
    public static void query2WithLength(MySQLConnector connector) throws SQLException{
        //Query #2 With Length
            System.out.println("\n\nQUERY #2 With Length");
            ResultSet result = connector.callQuery(MySQLConnector.query2);
            System.out.format("|%-25s|%-25s|%-10s|%-10s|\n", "Studio Name", "Movie Title", "Movie Year", "length");
            System.out.println("----------------------------------------------------------------------------");
            while(result.next()) {
                String studioName = result.getString("studioName");
                String movieTitle = result.getString("movieTitle");
                String movieYear = String.valueOf(result.getInt("movieYear"));
                String length = String.valueOf(result.getInt("length"));
                System.out.format("|%-25s|%-25s|%-10s|%-10s|\n", studioName, movieTitle,movieYear,length);
            }
    }
    
    public static void query3(MySQLConnector connector, String studioName) throws SQLException {
        Studio studio = connector.findStudio(studioName);
        MovieExec richestProducer = connector.findTheRichestProducer(studio);
        System.out.format("|%-20s|%-17s|\n", "Producer Name", "Studio Name");
        System.out.println("----------------------------------------");
        System.out.format("|%-20s|%-17s|\n", richestProducer.getName(), studio.getStudioioName());
    }
    
    public static void query4(MySQLConnector connector) throws SQLException {
        ResultSet query4Results = connector.callQuery(MySQLConnector.query4);

        System.out.format("|%-20s|%-7s|%-15s|\n", "Movie Star", "Address", "Studio Name");
        System.out.println("------------------------------------------------------------------");
        while(query4Results.next()) {
            String movieStar = query4Results.getString("starName");
            String address = query4Results.getString("address");
            String studioName = query4Results.getString("studioName");
            
            System.out.format("|%-20s|%-7s|%-15s|\n", movieStar, address, studioName);
        }
    }
    
    public static void query5(MySQLConnector connector) throws SQLException {
        ResultSet query5Results = connector.callQuery(MySQLConnector.query5);
        
        System.out.format("|%-20s|%-15s|\n", "Movie Star", "Studio Name");
        System.out.println("--------------------------------------");
        while(query5Results.next()) {
            String movieStar = query5Results.getString("starName");
            String studioName = "MGM";
            
            System.out.format("|%-20s|%-15s|\n", movieStar, studioName);
        }
    }
}
