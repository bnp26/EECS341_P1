SELECT `M`.`movieTitle`, `M`.`movieYear`, `M`.`studioName`
FROM (SELECT `movieTitle`, `movieYear`, `studioName` 
    FROM `Movies` where `length` = (
	SELECT `studioName`, MAX(`length`) from `Movies` GROUP BY `studioName` DESC)
) `M` GROUP BY `studioName`, `movieTitle`, `movieYear`;
