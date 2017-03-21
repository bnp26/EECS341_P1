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

import java.sql.*;

import java.util.Properties;
import java.util.ArrayList;

public class MySQLConnector {
    private static final String dbClassName = "com.mysql.jdbc.Driver";
    
    private static final String url = "jdbc:mysql://localhost:3306/MSS";
    // First asked for movies in descending order on length
    // Then grouped by Studio Name.
    public static final String query2 = "SELECT `movieTitle`, `movieYear`, `studioName`"
            + " FROM `Movies` where `length` in"
            + "(SELECT `len` FROM "
            + "(SELECT `studioName`, MAX(`length`) as `len` from `Movies` GROUP BY `studioName`)"
            + "`len`)";
    
    public static final String query4 = "SELECT DISTINCT `ms`.`starName`, `ms`.`address`, `s2`.`address`, `s2`.`studioName` " +
"FROM `MovieStar` `ms`, `Movies` `m`, `Stars` `s1`, `Stud` `s2`\n" +
"WHERE `ms`.`starName` = `s1`.`starName` " +
"AND `s1`.`movieTitle` = `m`.`movieTitle` " +
"AND `s1`.`movieYear` = `m`.`movieYear` " +
"AND `m`.`studioName` = `s2`.`studioName` " +
"AND `ms`.`address` = `s2`.`address`";
    
    public static final String query5 = "SELECT  `ms`.`starName`"
    + "FROM  `MovieStar`  `ms`"
    + "WHERE NOT EXISTS("
        + "SELECT *"
	+ "FROM  `Movies`  `m`"
        + "WHERE `m`.`studioName` = 'MGM'"
        + "AND NOT EXISTS("
            + "SELECT *"
            + "FROM `Stars` `s`"
            + "WHERE `s`.`movieTitle` = `m`.`movieTitle` "
            + "AND `s`.`movieYear` =  `m`.`movieYear` "
            + "AND `s`.`starName` =  `ms`.`starName`))";
    private Connection connection;
    
    public MySQLConnector() throws ClassNotFoundException, SQLException {
        
        Class.forName(dbClassName);
        
        connection = null;
           
        String user = "root";
        String password = "123456";
            
        Properties info = new Properties();
        info.put("user", user);
        info.put("password", password);
            
        connection = DriverManager.getConnection(url, info);
    }
    
    public Connection getConnection() {
        return connection;
    }
    
    public ResultSet callQuery(String str) throws SQLException{
        Statement stmt = connection.createStatement();
        return stmt.executeQuery(str);
    }
    
    public Movie findMovie(MoviePK moviePK) throws SQLException {
        String sql = "SELECT * FROM Movies WHERE movieName = " + moviePK.getName() + "AND movieYear = " + String.valueOf(moviePK.getYear());
        Statement stmt = connection.createStatement();
        ResultSet results = stmt.executeQuery(sql);
        Movie movie = new Movie();
        MovieExec movieExec = new MovieExec();
        Studio studio = new Studio();
        if(results.getFetchSize() > 1){
            System.out.println("Found more than 1 query for a movie's private key.");
            return null;
        }
        
        movie.setMoviePK(new MoviePK(results.getString("movieName"), results.getInt("movieYear")));
        movie.setLength(results.getInt("length"));
        movie.setGenre(results.getString("genre"));
        
        return movie;
    }
    
    public MovieStar findMovieStar(String starName) throws SQLException {
        String sql = "SELECT * FROM `MovieStar` WHERE `starName` = '" + starName + "'";
        Statement stmt = connection.createStatement();
        ResultSet results = stmt.executeQuery(sql);
        if(results.getFetchSize() > 1){
            System.out.println("Found more than 1 MovieStar from this query. This should not happen.");
            return null;
        }
        results.next();
        MovieStar movieStar = new MovieStar();
        movieStar.setStarName(results.getString("starName"));
        movieStar.setAddress(results.getString("address"));
        movieStar.setGender(results.getString("gender"));
        movieStar.setBirthdate(results.getObject("birthdate", Date.class));
        stmt.close();
        
        return movieStar;
    }
    
    public ArrayList<Movie> findMoviesViaMovieStar(MovieStar star) throws SQLException {
        String sql = "SELECT DISTINCT `Movies`.*"
                    +"FROM `Movies`, `Stars`, `MovieStar`"
                    +"WHERE `Stars`.`starName` = '" + star.getStarName() + "' "
                    +"AND `Movies`.`movieTitle` = `Stars`.`movieTitle`"
                    +"AND `Movies`.`movieYear` = `Stars`.`movieYear`";
        
        Statement stmt = connection.createStatement();
        ResultSet results = stmt.executeQuery(sql);
        ArrayList<Movie> movies = new ArrayList<Movie>();
        while(results.next())
        {
            Movie current = new Movie();
            MoviePK moviePK = new MoviePK(results.getString("movieTitle"), results.getInt("movieYear"));
            current.setMoviePK(moviePK);
            current.setLength(results.getInt("length"));
            current.setGenre(results.getString("genre"));
            
            String studioSql = "SELECT `Stud`.* FROM `Stud` "
                    + "WHERE `Stud`.`studioName` = '" + results.getString("studioName") + "'";
            Statement studStmt = connection.createStatement();
            ResultSet studioResults = studStmt.executeQuery(studioSql);
            studioResults.next();
            
            Statement presStmt = connection.createStatement();
            String presidentSql = "SELECT `MovieExec`.* FROM `MovieExec` "
                    + "WHERE `MovieExec`.`cert#` = '" + String.valueOf(studioResults.getInt("presC#")) + "'";
            ResultSet presidentResults = presStmt.executeQuery(presidentSql);
            
            Statement producerStmt = connection.createStatement();
            String producerSql = "SELECT `MovieExec`.* FROM `MovieExec` "
                    + "WHERE `MovieExec`.`cert#` = '" + String.valueOf(results.getInt("producerC#")) + "'";
            ResultSet producerResults = producerStmt.executeQuery(producerSql);
            
            MovieExec president = new MovieExec();
            MovieExec producer = new MovieExec();
            
            presidentResults.next();
            president.setName(presidentResults.getString("name"));
            president.setCert(presidentResults.getInt("cert#"));
            president.setAddress(presidentResults.getString("address"));
            president.setNetworth(presidentResults.getFloat("networth"));
            producerResults.next();
            producer.setName(producerResults.getString("name"));
            producer.setCert(producerResults.getInt("cert#"));
            producer.setAddress(producerResults.getString("address"));
            producer.setNetworth(producerResults.getFloat("networth"));
            
            Studio studio = new Studio();
            studio.setStudioName(studioResults.getString("studioName"));
            studio.setStudioName(studioResults.getString("address"));
            studio.setPresident(president);
            
            current.setProducer(producer);
            current.setStudio(studio);
            
            studStmt.close();
            presStmt.close();
            producerStmt.close();
            
            movies.add(current);
        }
        
        stmt.close();
        return movies;
    }
    
    public Studio findStudio(String studioName) throws SQLException{
        Statement studioStmt = connection.createStatement();
        Statement presidentStmt = connection.createStatement();
        
        String studioSql = "SELECT * FROM `Stud` WHERE `studioName`='" + studioName + "'";
        ResultSet studioResults = studioStmt.executeQuery(studioSql);
        studioResults.next();
        if(studioResults.getFetchSize() > 1){
            System.out.println("Found more than 1 Studio returned from this query. This should not happen.");
            return null;
        }
        
        String presidentSql = "SELECT * FROM `MovieExec` WHERE `cert#`='" + studioResults.getInt("presC#") + "'";
        
        ResultSet presidentResults = presidentStmt.executeQuery(presidentSql);
        presidentResults.next();
        if(presidentResults.getFetchSize() > 1){
            System.out.println("Found more than 1 MovieExec returned from this query. This should not happen.");
            return null;
        }
        
        Studio studio = new Studio();
        studio.setStudioName(studioResults.getString("studioName"));
        studio.setAddress(studioResults.getString("address"));
        
        MovieExec president = new MovieExec();
        president.setName(presidentResults.getString("name"));
        president.setCert(presidentResults.getInt("cert#"));
        president.setAddress(presidentResults.getString("address"));
        president.setNetworth(presidentResults.getInt("networth"));
        
        studio.setPresident(president);
        
        studioStmt.close();
        presidentStmt.close();
        
        return studio;
    }
    
    public MovieExec findTheRichestProducer(Studio studio) throws SQLException
    {
        //instead of returning the correct query, I'm returning the correct resulint
        //so I can populate the class with all the correct data.
        String sql = "SELECT `me`.*"
            + " FROM `MovieExec` `me`, `Movies` `m`"
            + " where `m`.`studioName` = '" + studio.getStudioName()+"'"
            + " AND `me`.`cert#` = `m`.`producerC#`;";
        
        Statement stmt = connection.createStatement();
        ResultSet result = stmt.executeQuery(sql);
        
        if(result.getFetchSize() > 1){
            System.out.println("Found more than 1 MovieExec returned from this query. This should not happen.");
            return null;
        }
        
        MovieExec richestProducer = new MovieExec();
        result.next();
        String producerName = result.getString("name");
        richestProducer.setName(producerName);
        int producerCert = result.getInt("cert#");
        richestProducer.setCert(producerCert);
        richestProducer.setAddress(result.getString("address"));
        richestProducer.setNetworth(result.getInt("networth"));
        
        stmt.close();
        
        return richestProducer;
        
    }
}
