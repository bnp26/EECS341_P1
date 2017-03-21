--AUTHOR BENJAMIN POREH
--EMAIL: bnp26@case.edu
--ID: bnp26

--Query #1 Dynamic See methods for the full queries.
MovieStar meryl = connector.findMovieStar("Meryl Streep");
ArrayList<Movie> merylMovies = connector.findMoviesViaMovieStar(meryl);

--Query #2
SELECT `M`.`movieTitle`, `M`.`movieYear`, `M`.`studioName`
FROM (SELECT `movieTitle`, `movieYear`, `studioName` 
FROM `Movies` where `length` = (
SELECT `studioName`, MAX(`length`) from `Movies` GROUP BY `studioName` DESC)
) `M` GROUP BY `studioName`, `movieTitle`, `movieYear`;

--Query #3 Dynamic, see methods for full queries.
query3(MySQLConnector connector, String studioName){
Studio studio = connector.findStudio(studioName);
MovieExec richestProducer = connector.findTheRichestProducer(studio);
...
--Query #4
SELECT DISTINCT `ms`.`starName`, `ms`.`address`, `s2`.`address`, `s2`.`studioName`
FROM `MovieStar` `ms`, `Movies` `m`, `Stars` `s1`, `Stud` `s2`
WHERE `ms`.`starName` = `s1`.`starName`
AND `s1`.`movieTitle` = `m`.`movieTitle`
AND `s1`.`movieYear` = `m`.`movieYear`
AND `m`.`studioName` = `s2`.`studioName`
AND `ms`.`address` = `s2`.`address`

--Query #5
SELECT  `ms`.`starName`
    FROM  `MovieStar`  `ms`
    WHERE NOT EXISTS(
        SELECT *
	FROM  `Movies`  `m`
        WHERE `m`.`studioName` = 'MGM'
        AND NOT EXISTS(
            SELECT *
            FROM `Stars` `s`
            WHERE `s`.`movieTitle` = `m`.`movieTitle`
            AND `s`.`movieYear` =  `m`.`movieYear`
            AND `s`.`starName` =  `ms`.`starName`))
       

