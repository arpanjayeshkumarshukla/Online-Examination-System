-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 03, 2017 at 11:17 AM
-- Server version: 5.7.14
-- PHP Version: 7.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `oap`
--

-- --------------------------------------------------------

--
-- Table structure for table `oapstudents`
--

CREATE TABLE `oapstudents` (
  `StudentID` varchar(12) NOT NULL,
  `Password` tinytext NOT NULL,
  `StudentName` tinytext NOT NULL,
  `EmailAddress` tinytext NOT NULL,
  `Status` char(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `qabank`
--

CREATE TABLE `qabank` (
  `TestID` varchar(25) NOT NULL,
  `QuestionID` smallint(5) UNSIGNED NOT NULL,
  `Question` text NOT NULL,
  `OptionA` text NOT NULL,
  `OptionB` text NOT NULL,
  `OptionC` text NOT NULL,
  `OptionD` text NOT NULL,
  `Answer` char(1) NOT NULL,
  `Marks` tinyint(4) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `sessions`
--

CREATE TABLE `sessions` (
  `TestID` smallint(6) NOT NULL,
  `StudentID` varchar(12) NOT NULL,
  `SetNo` tinyint(4) NOT NULL,
  `DurationRemaining` smallint(6) NOT NULL,
  `ResponseString` tinytext NOT NULL,
  `SessionExpiryTimestamp` timestamp NULL DEFAULT NULL,
  `SessionStatus` tinytext NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `sets`
--

CREATE TABLE `sets` (
  `TestID` varchar(25) NOT NULL,
  `QuestionID` smallint(5) NOT NULL,
  `Set1` tinyint(4) NOT NULL,
  `Set2` tinyint(4) NOT NULL,
  `Set3` tinyint(4) NOT NULL,
  `Set4` tinyint(4) NOT NULL,
  `Set5` tinyint(4) NOT NULL,
  `Set6` tinyint(4) NOT NULL,
  `Set7` tinyint(4) NOT NULL,
  `Set8` tinyint(4) NOT NULL,
  `Set9` tinyint(4) NOT NULL,
  `Set10` tinyint(4) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `staffaccounts`
--

CREATE TABLE `staffaccounts` (
  `UserID` varchar(25) NOT NULL,
  `Password` tinytext NOT NULL,
  `StaffName` tinytext NOT NULL,
  `Designation` tinytext NOT NULL,
  `EmailAddress` tinytext NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `studentstestsreports`
--

CREATE TABLE `studentstestsreports` (
  `StudentID` varchar(12) NOT NULL,
  `TestID` varchar(25) NOT NULL,
  `SetNo` tinyint(4) NOT NULL,
  `TestDateTime` datetime NOT NULL,
  `Score` float DEFAULT NULL,
  `ResponseString` tinytext
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tests`
--

CREATE TABLE `tests` (
  `TestID` smallint(6) NOT NULL,
  `TestName` tinytext NOT NULL,
  `TestCoordinator` varchar(25) NOT NULL,
  `TestDate` date NOT NULL,
  `StartTime` time NOT NULL,
  `Duration` smallint(6) NOT NULL,
  `Status` char(1) NOT NULL,
  `NoOfSets` tinyint(4) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `testsenrolreq`
--

CREATE TABLE `testsenrolreq` (
  `StudentID` varchar(12) NOT NULL,
  `TestID` smallint(6) NOT NULL,
  `Status` char(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `oapstudents`
--
ALTER TABLE `oapstudents`
  ADD PRIMARY KEY (`StudentID`);

--
-- Indexes for table `qabank`
--
ALTER TABLE `qabank`
  ADD PRIMARY KEY (`TestID`,`QuestionID`);

--
-- Indexes for table `sessions`
--
ALTER TABLE `sessions`
  ADD PRIMARY KEY (`TestID`,`StudentID`);

--
-- Indexes for table `sets`
--
ALTER TABLE `sets`
  ADD PRIMARY KEY (`TestID`,`QuestionID`);

--
-- Indexes for table `staffaccounts`
--
ALTER TABLE `staffaccounts`
  ADD PRIMARY KEY (`UserID`);

--
-- Indexes for table `studentstestsreports`
--
ALTER TABLE `studentstestsreports`
  ADD PRIMARY KEY (`StudentID`,`TestID`);

--
-- Indexes for table `tests`
--
ALTER TABLE `tests`
  ADD PRIMARY KEY (`TestID`);

--
-- Indexes for table `testsenrolreq`
--
ALTER TABLE `testsenrolreq`
  ADD PRIMARY KEY (`StudentID`,`TestID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tests`
--
ALTER TABLE `tests`
  MODIFY `TestID` smallint(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
