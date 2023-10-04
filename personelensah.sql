-- phpMyAdmin SQL Dump
-- version 5.1.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jan 07, 2023 at 05:43 PM
-- Server version: 5.7.24
-- PHP Version: 8.0.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `personelensah`
--

-- --------------------------------------------------------

--
-- Table structure for table `actualite`
--

CREATE TABLE `actualite` (
  `idA` int(11) NOT NULL,
  `titre` varchar(200) NOT NULL,
  `text` text NOT NULL,
  `idP` int(11) NOT NULL,
  `datePub` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `actualite`
--

INSERT INTO `actualite` (`idA`, `titre`, `text`, `idP`, `datePub`) VALUES
(1, 'AVIS CONCOURS :', 'bonjour', 2, '21/12/2022 17:04:22'),
(3, 'AVIS - ENSEIGNANTS VACATAIRES :', 'Il est porté à la connaissance des étudiants admis au concour de passerelle de la filière Génie énergétique et énergies renouvelables (G2E), que l\'inscription est ouverte à partir du 18 octobre.', 2, '21/12/2022 17:07:39'),
(4, 'avis aux professeurs', 'la date limite pour rendre les notes est demain', 2, '21/12/2022 17:35:11'),
(5, 'AVIS AUX ETUDIANTS 5 eme ANNEE', 'le PFE sera le 01/07', 2, '21/12/2022 17:57:09');

-- --------------------------------------------------------

--
-- Table structure for table `document`
--

CREATE TABLE `document` (
  `idDoc` int(11) NOT NULL,
  `titre` varchar(20) NOT NULL,
  `type` varchar(20) NOT NULL,
  `path` varchar(1000) NOT NULL,
  `idP` int(11) NOT NULL,
  `filiere` varchar(50) NOT NULL,
  `niveau` varchar(50) NOT NULL,
  `module` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `document`
--

INSERT INTO `document` (`idDoc`, `titre`, `type`, `path`, `idP`, `filiere`, `niveau`, `module`) VALUES
(1, 'Collection', 'Tp', 'C:\\Users\\Home\\Desktop\\Gi2\\S3\\Java\\Chap6-Collections.pdf', 1, 'null', '2', 'GI2-S3-Programmation Java Avancée'),
(2, 'Thread', 'Cours', 'C:\\Users\\Home\\Desktop\\Gi2\\S3\\Java\\Les Threads.pdf', 1, 'Genie Informatique', '2', 'GI2-S3-Programmation Java Avancée');

-- --------------------------------------------------------

--
-- Table structure for table `etudiant`
--

CREATE TABLE `etudiant` (
  `idE` int(11) NOT NULL,
  `nom` varchar(20) NOT NULL,
  `prenom` varchar(20) NOT NULL,
  `emailA` varchar(50) NOT NULL,
  `emailP` varchar(50) NOT NULL,
  `CNE` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `etudiant`
--

INSERT INTO `etudiant` (`idE`, `nom`, `prenom`, `emailA`, `emailP`, `CNE`) VALUES
(1, 'berada', 'fatiha', 'fatiha200@gmail.com', 'fatiha.berada@etu.uae.ac.ma', 'N45394326'),
(2, 'afif', 'ikram', 'ikramafif.123@gmail.com', 'afif.ikram@etu.uae.ac.ma', 'S4335467'),
(3, 'adili', 'fatima', 'fatima2@gmail.com', 'adili.fatima@etu.uae.ac.ma', 'S492345');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `idL` int(11) NOT NULL,
  `userName` varchar(50) NOT NULL,
  `password` varchar(30) NOT NULL,
  `idP` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`idL`, `userName`, `password`, `idP`) VALUES
(1, 'prof', 'youssra123', 1),
(2, 'admin', 'ahlam123', 2),
(4, 'fatiha.ouaaali@etu.uae.ac.ma', '2016', 4);

-- --------------------------------------------------------

--
-- Table structure for table `personnel`
--

CREATE TABLE `personnel` (
  `idP` int(11) NOT NULL,
  `nom` varchar(20) NOT NULL,
  `prenom` varchar(20) NOT NULL,
  `cin` varchar(20) NOT NULL,
  `emailAcademique` varchar(50) NOT NULL,
  `emailPersonnel` varchar(50) NOT NULL,
  `ville` varchar(10) NOT NULL,
  `tele` int(20) NOT NULL,
  `dateNaissance` date NOT NULL,
  `dateEmploye` date NOT NULL,
  `adresse` varchar(50) NOT NULL,
  `sexe` varchar(20) NOT NULL,
  `PPR` varchar(20) NOT NULL,
  `status` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `personnel`
--

INSERT INTO `personnel` (`idP`, `nom`, `prenom`, `cin`, `emailAcademique`, `emailPersonnel`, `ville`, `tele`, `dateNaissance`, `dateEmploye`, `adresse`, `sexe`, `PPR`, `status`) VALUES
(1, 'Badda', 'youssra', 'CD670780', 'youssra.badda@etu.uae.ac.ma', 'youssra.badda200@gmail', 'fes', 660873333, '2001-06-06', '2024-12-12', 'hay el merja fes 4 numero20,wed fes', 'femme', 'G35311', 1),
(2, 'el bahry', 'ahlame', 'S123432', 'ahlam.elbahry@etu.uae.ac.ma', 'noveauemail@gmail.com', 'el jadida', 623456479, '2001-01-22', '2023-01-20', 'hay rahma 20,numero 5', 'femme', '765766', 0),
(4, 'ouaaali', 'fatiha', 'yyy88', 'fatiha.ouaaali@etu.uae.ac.ma', 'fatiha@gmaik.com', 'agadir', 976543, '2022-02-02', '2040-05-06', 'hy hjkl', 'feme', '889', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `actualite`
--
ALTER TABLE `actualite`
  ADD PRIMARY KEY (`idA`),
  ADD KEY `idP` (`idP`);

--
-- Indexes for table `document`
--
ALTER TABLE `document`
  ADD PRIMARY KEY (`idDoc`),
  ADD KEY `idP` (`idP`);

--
-- Indexes for table `etudiant`
--
ALTER TABLE `etudiant`
  ADD PRIMARY KEY (`idE`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`idL`),
  ADD KEY `idP` (`idP`);

--
-- Indexes for table `personnel`
--
ALTER TABLE `personnel`
  ADD PRIMARY KEY (`idP`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `actualite`
--
ALTER TABLE `actualite`
  MODIFY `idA` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `document`
--
ALTER TABLE `document`
  MODIFY `idDoc` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `etudiant`
--
ALTER TABLE `etudiant`
  MODIFY `idE` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `idL` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `personnel`
--
ALTER TABLE `personnel`
  MODIFY `idP` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `actualite`
--
ALTER TABLE `actualite`
  ADD CONSTRAINT `actualite_ibfk_1` FOREIGN KEY (`idP`) REFERENCES `personnel` (`idP`);

--
-- Constraints for table `document`
--
ALTER TABLE `document`
  ADD CONSTRAINT `document_ibfk_1` FOREIGN KEY (`idP`) REFERENCES `personnel` (`idP`);

--
-- Constraints for table `login`
--
ALTER TABLE `login`
  ADD CONSTRAINT `login_ibfk_1` FOREIGN KEY (`idP`) REFERENCES `personnel` (`idP`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
