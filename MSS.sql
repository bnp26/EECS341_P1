-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 17, 2017 at 06:44 PM
-- Server version: 5.5.54-0ubuntu0.14.04.1
-- PHP Version: 5.5.9-1ubuntu4.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `MSS`
--

-- --------------------------------------------------------

--
-- Table structure for table `MovieExec`
--

CREATE TABLE IF NOT EXISTS `MovieExec` (
  `name` varchar(120) NOT NULL,
  `cert#` int(8) NOT NULL,
  `address` varchar(120) NOT NULL,
  `networth` float NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `MovieExec`
--

INSERT INTO `MovieExec` (`name`, `cert#`, `address`, `networth`) VALUES
('Alfonso Cuarón', 65434813, '90210', 20000000),
('Barbara Broccoli', 32661147, 'W1V 9FH', 150000000),
('Ben Affleck', 32651021, '91505', 75000000),
('Ben Stiller', 32831161, '90036', 120000000),
('Brad Grey', 32777255, '90210', 29000000),
('Brad Pitt', 32867166, '90265', 240000000),
('Carole Eastman', 32699718, 'N/A', 8000000),
('Christopher Nolan', 67104114, '90024', 145000000),
('Danny DeVito', 32681708, '90067', 70000000),
('Gary Barber', 32669718, '92037', 8000000),
('Gary Kurtz', 32751243, '90210', 10000000),
('George Clooney', 32671792, '90024', 180000000),
('James Cameron', 32679711, '91504', 700000000),
('James Franco', 32701899, '90210', 20000000),
('Jason Segel', 32905982, '90036', 30000000),
('John Davis', 32697122, '90049', 1700000000),
('Karen Irwin', 32807112, '91602', 66000000),
('Kevin Tsujihara', 32841151, '91021', 90000000),
('Laurence Mark', 76971171, '90232', 9000000),
('Lawrence Bender', 77297801, '90210', 26000000),
('Marc Evans', 32691267, '90038', 937500000),
('Matt Damon', 32690490, '91505', 120000000),
('Peter Cramer', 32679159, '91608', 20000000),
('Ridley Scott', 82433499, '90069', 140000000),
('Ryan Gosling', 32711111, '90232', 30000000),
('Ryan Reynolds', 32821011, '90209', 45000000),
('Sanford Panitch', 83445068, '90405', 42000000),
('Sidonie Dumas', 83105426, '92200', 9000000),
('Stacey Snider', 32839412, '90212', 22000000),
('Tom Hanks', 32729719, '90067', 350000000),
('Will Ferrell', 32701011, '90046', 80000000),
('William MacDonald', 32780670, 'Unknown', 2000000),
('Zanne Devine', 32681102, '90272', 6000000);

-- --------------------------------------------------------

--
-- Table structure for table `Movies`
--

CREATE TABLE IF NOT EXISTS `Movies` (
  `movieTitle` varchar(120) CHARACTER SET latin1 NOT NULL,
  `movieYear` int(4) NOT NULL,
  `length` int(11) NOT NULL,
  `genre` varchar(60) CHARACTER SET latin1 NOT NULL,
  `studioName` varchar(120) CHARACTER SET latin1 NOT NULL,
  `producerC#` int(8) NOT NULL,
  PRIMARY KEY (`movieTitle`,`movieYear`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii COLLATE=ascii_bin;

--
-- Dumping data for table `Movies`
--

INSERT INTO `Movies` (`movieTitle`, `movieYear`, `length`, `genre`, `studioName`, `producerC#`) VALUES
('Argo', 2012, 120, 'Biography, Drama, History', 'Warner Bros.', 32651021),
('Avatar', 2009, 161, 'Action, Adventure, Fantasy', '20th Century Fox', 32679711),
('Casino Royale', 2006, 144, 'Action, Adventure, Thriller', 'MGM', 32661147),
('Deadpool', 2016, 108, 'Action, Adventure, Comedy', '20th Century Fox', 32821011),
('Forgetting Sarah Marshall', 2008, 111, 'Comedy, Drama, Romance', 'Universal Pictures', 32905982),
('Good Will Hunting', 1997, 126, 'Drama', 'Miramax', 77297801),
('Gravity', 2013, 91, 'Adventure, Drama, Sci-Fi', 'Warner Bros.', 65434813),
('Hoffa', 1992, 140, ' Biography, Crime, Drama', '20th Century Fox', 32681708),
('Inception', 2010, 148, 'Action, Adventure, Sci-Fi', 'Warner Bros.', 67104114),
('Interstellar', 2014, 169, 'Adventure, Drama, Sci-Fi', 'Warner Bros.', 67104114),
('Julie & Julia', 2009, 123, 'Biography, Drama, Romance', 'Columbia Pictures', 76971171),
('Ma Ma Mia!', 2008, 111, 'Comedy, Family, Musical', 'Universal Pictures', 32729719),
('Man Trouble', 1992, 100, 'Comedy, Romance ', '20th Century Fox', 32699718),
('Only God Forgives', 2013, 90, 'Crime, Drama', 'Gaumont', 32711111),
('Quantum of Solace', 2008, 106, 'Action, Adventure ', 'MGM', 32661147),
('Skyfall', 2012, 143, 'Action, Adventure, Thriller', 'MGM', 32661147),
('Spectre', 2015, 148, 'Action, Adventure, Thriller', 'MGM', 32661147),
('Star Wars: Episode IV – A New Hope', 1977, 121, 'Action, Adventure, Fantasy', '20th Century Fox', 32751243),
('The Dark Knight', 2008, 152, 'Action, Crime, Drama', 'Warner Bros.', 67104114),
('The Departed', 2006, 151, 'Crime, Drama, Thriller', 'Warner Bros.', 32867166),
('The Martian', 2015, 141, 'Adventure, Drama, Sci-Fi', '20th Century Fox', 82433499),
('The Saint', 1997, 116, 'Action, Adventure, Romance', 'Paramount Pictures', 32780670),
('The Thing Called Love', 1993, 116, 'Comedy, Drama, Music', 'Paramount Pictures', 32697122),
('World War Z', 2013, 116, 'Action, Adventure, Horror', 'Paramount Pictures', 32867166);

-- --------------------------------------------------------

--
-- Table structure for table `MovieStar`
--

CREATE TABLE IF NOT EXISTS `MovieStar` (
  `starName` varchar(120) NOT NULL,
  `address` varchar(240) NOT NULL,
  `gender` varchar(20) NOT NULL,
  `birthdate` date NOT NULL,
  PRIMARY KEY (`starName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `MovieStar`
--

INSERT INTO `MovieStar` (`starName`, `address`, `gender`, `birthdate`) VALUES
('Aaron Eckhart', '90067', 'Male', '1968-03-12'),
('Amanda Seyfried', '18104', 'Female ', '1985-12-03'),
('Amy Adams', '90212', 'Female ', '1974-08-20'),
('Anne Hathaway', '90210', 'Female ', '1982-11-12'),
('Ben Affleck', '91505', 'Male', '1972-08-15'),
('Brad Pitt', '90212', 'Male', '1963-12-18'),
('Carrie Fisher', '91606', 'Female ', '1956-10-21'),
('Chris Messina', '90210', 'Male', '1974-08-11'),
('Christian Bale', '90210', 'Male', '1974-01-30'),
('Christoph Waltz', '10178 Berlin', 'Male', '1956-10-04'),
('Daniel Craig', 'W1T 2RH', 'Male', '1968-03-02'),
('Daniella Kertesz', '90210', 'Female ', '1989-03-11'),
('Dermot Mulroney', '90210', 'Male', '1963-10-31'),
('Elisabeth Shue', '90038', 'Female', '1963-10-06'),
('Ellen Barkin', '90212', 'Female', '1954-04-16'),
('Ellen Page', '90069', 'Female ', '1987-02-21'),
('Eva Green', '75002 Paris', 'Female', '1980-07-06'),
('George Clooney', '90024', 'Male', '1961-05-06'),
('Harrison Ford', '90049', 'Male', '1942-07-13'),
('Harry Dean Stanton', '90077', 'Male', '1926-07-14'),
('Heath Ledger', '10002', 'Male', '1979-04-04'),
('Jack Nicholson', '90064', 'Male', '1937-04-22'),
('Jason Segel', '90036', 'Male', '1980-01-18'),
('Javier Bardem', '90210', 'Male', '1969-03-01'),
('Jessica Chastain', '90069', 'Female ', '1977-03-24'),
('Jill Hennessy', '90210', 'Female', '1968-11-25'),
('Jonathan Pryce', 'W1F 7TG', 'Male', '1947-06-01'),
('Joseph Gordon/Levitt', '90211', 'Male', '1981-02-17'),
('Judi Dench', 'W1F 7TG', 'Female', '1934-09-12'),
('Kristen Bell', '90028', 'Female ', '1980-07-18'),
('Kristin Scott Thomas', 'TR15', 'Female ', '1960-05-24'),
('Léa Seydoux', '75002 Paris', 'Female ', '1985-07-01'),
('Leonardo DiCaprio', '90069', 'Male', '1974-11-11'),
('Mark Hamill', '48480', 'Male', '1951-09-25'),
('Mathieu Amalric', '75002 Paris', 'Male', '1965-10-25'),
('Matt Damon', '91505', 'Male', '1970-10-08'),
('Matthew McConaughey', '70791', 'Male', '1969-11-04'),
('Meryl Streep', '10036', 'Female ', '1949-06-22'),
('Mireille Enos', '90036', 'Female ', '1975-09-22'),
('Morena Baccarin', '90211', 'Female ', '1979-06-02'),
('Naomie Harris', '90212', 'Female', '0000-00-00'),
('Olga Kurylenko', 'W1S 2YN', 'Female', '1979-11-14'),
('Paul Rudd', '90212', 'Male', '1969-04-06'),
('Pierce Brosnan', '90265', 'Male', '1953-05-16'),
('River Phoenix', 'N/A', 'Male', '1970-08-23'),
('Robin Williams', 'N/A', 'Male', '1951-07-21'),
('Ryan Gosling', '90232', 'Male', '1980-11-12'),
('Ryan Reynolds', '90209', 'Male', '1976-10-23'),
('Sam Worthington', 'NSW 2010', 'Male', '1976-08-02'),
('Samantha Mathis', '90210', 'Female', '1970-05-12'),
('Sandra Bullock', '90069', 'Female ', '1964-07-26'),
('Sigourney Weaver', '10150', 'Female ', '1949-10-08'),
('T.J. Miller', '90212', 'Male', '1981-06-04'),
('Val Kilmer', '90046', 'Male', '1959-12-31'),
('Vithaya Pansringarm', 'N/A', 'Male', '1959-08-11'),
('William Sylvester', 'N/A', 'Male', '1922-01-31'),
('Zoe Saldana', '90067', 'Female ', '1978-06-19');

-- --------------------------------------------------------

--
-- Table structure for table `Stars`
--

CREATE TABLE IF NOT EXISTS `Stars` (
  `movieTitle` varchar(120) NOT NULL,
  `movieYear` int(4) NOT NULL,
  `starName` varchar(280) NOT NULL,
  PRIMARY KEY (`movieTitle`,`movieYear`,`starName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Stars`
--

INSERT INTO `Stars` (`movieTitle`, `movieYear`, `starName`) VALUES
('Argo', 2012, 'Ben Affleck'),
('Avatar', 2009, 'Sam Worthington'),
('Avatar', 2009, 'Sigourney Weaver'),
('Avatar', 2009, 'Zoe Saldana'),
('Casino Royale', 2006, 'Daniel Craig'),
('Casino Royale', 2006, 'Eva Green'),
('Casino Royale', 2006, 'Judi Dench'),
('Deadpool', 2016, 'Morena Baccarin'),
('Deadpool', 2016, 'Ryan Reynolds'),
('Deadpool', 2016, 'T.J. Miller'),
('Forgetting Sarah Marshall', 2008, 'Jason Segel'),
('Forgetting Sarah Marshall', 2008, 'Kristen Bell'),
('Forgetting Sarah Marshall', 2008, 'Paul Rudd'),
('Good Will Hunting', 1997, 'Ben Affleck'),
('Good Will Hunting', 1997, 'Matt Damon'),
('Good Will Hunting', 1997, 'Robin Williams'),
('Gravity', 2013, 'Goerge Clooney'),
('Gravity', 2013, 'Sandra Bullock'),
('Hoffa', 1992, 'Danny Devito'),
('Hoffa', 1992, 'Jack Nicholson'),
('Inception', 2010, 'Ellen Page'),
('Inception', 2010, 'Joseph Gordon-Levitt'),
('Inception', 2010, 'Leonardo DiCaprio'),
('Interstellar', 2014, 'Anne Hathaway'),
('Interstellar', 2014, 'Matthew McConaughey'),
('Julie & Julia', 2009, 'Amy Adams'),
('Julie & Julia', 2009, 'Chris Messina'),
('Julie & Julia', 2009, 'Meryl Streep'),
('Ma Ma Mia!', 2008, 'Amanda Seyfried'),
('Ma Ma Mia!', 2008, 'Meryl Streep'),
('Ma Ma Mia!', 2008, 'Pierce Brosnan'),
('Man Trouble', 1992, 'Ellen Barkin'),
('Man Trouble', 1992, 'Harry Dean Stanton'),
('Man Trouble', 1992, 'Jack Nicholson'),
('Only God Forgives', 2013, 'Kristin Scott Thomas'),
('Only God Forgives', 2013, 'Ryan Gosling'),
('Only God Forgives', 2013, 'Vithaya Pansringarm'),
('Quantum of Solace', 2008, 'Daniel Craig'),
('Quantum of Solace', 2008, 'Mathieu Amalric'),
('Quantum of Solace', 2008, 'Olga Kurylenko'),
('Skyfall', 2012, 'Daniel Craig'),
('Skyfall', 2012, 'Javier Bardem'),
('Skyfall', 2012, 'Naomie Harris'),
('Spectre', 2015, 'Christoph Waltz'),
('Spectre', 2015, 'Daniel Craig'),
('Spectre', 2015, 'Léa Seydoux'),
('Star Wars: Episode IV – A New Hope', 1977, 'Carrie Fisher'),
('Star Wars: Episode IV – A New Hope', 1977, 'Harrison Ford'),
('Star Wars: Episode IV – A New Hope', 1977, 'Mark Hamill'),
('The Dark Knight', 2008, 'Aaron Eckhart'),
('The Dark Knight', 2008, 'Christian Bale'),
('The Dark Knight', 2008, 'Heath Ledger'),
('The Departed', 2006, 'Jack Nicholson'),
('The Departed', 2006, 'Leonardo DiCaprio'),
('The Departed', 2006, 'Matt Damon'),
('The Martian', 2015, 'Jessica Chastain'),
('The Martian', 2015, 'Matt Damon'),
('The Saint', 1997, 'Elisabeth Shue'),
('The Saint', 1997, 'Val Kilmer'),
('The Thing Called Love', 1993, 'Dermot Mulroney'),
('The Thing Called Love', 1993, 'River Phoenix'),
('The Thing Called Love', 1993, 'Samantha Mathis'),
('The Thing Called Love', 1993, 'Sandra Bullock'),
('World War Z', 2013, 'Brad Pitt'),
('World War Z', 2013, 'Daniella Kertesz'),
('World War Z', 2013, 'Mireille Enos');

-- --------------------------------------------------------

--
-- Table structure for table `Stud`
--

CREATE TABLE IF NOT EXISTS `Stud` (
  `studioName` varchar(120) NOT NULL,
  `address` varchar(280) NOT NULL,
  `presC#` int(11) NOT NULL,
  PRIMARY KEY (`studioName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Stud`
--

INSERT INTO `Stud` (`studioName`, `address`, `presC#`) VALUES
('20th Century Fox', '90064', 32839412),
('Columbia Pictures', '90232', 83445068),
('Gaumont', '90069', 83105426),
('MGM', '90067', 32669718),
('Miramax', '90404', 32681102),
('Paramount Pictures', '90038', 32691267),
('Universal Pictures', '91608', 32679159),
('Warner Bros.', '91522', 32841151);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
