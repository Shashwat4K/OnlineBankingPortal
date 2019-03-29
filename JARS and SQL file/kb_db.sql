-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 16, 2018 at 03:51 PM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kb_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `activation_kit`
--

CREATE TABLE `activation_kit` (
  `KIT` int(11) NOT NULL,
  `ACCOUNT_NUMBER` bigint(20) NOT NULL,
  `USER_NAME` varchar(255) NOT NULL,
  `PASSWORD` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `activation_kit`
--

INSERT INTO `activation_kit` (`KIT`, `ACCOUNT_NUMBER`, `USER_NAME`, `PASSWORD`) VALUES
(1234, 9874563210, 'jp', 'jp123');

-- --------------------------------------------------------

--
-- Table structure for table `kb1111111`
--

CREATE TABLE `kb1111111` (
  `TRANSACTION_ID` int(11) NOT NULL,
  `INSTANT` datetime DEFAULT NULL,
  `PEER` varchar(255) DEFAULT NULL,
  `PEER_ACC` bigint(20) DEFAULT NULL,
  `EVENT` int(11) DEFAULT NULL,
  `TRANSFER` int(11) DEFAULT NULL,
  `BALANCE` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kb1111111`
--

INSERT INTO `kb1111111` (`TRANSACTION_ID`, `INSTANT`, `PEER`, `PEER_ACC`, `EVENT`, `TRANSFER`, `BALANCE`) VALUES
(121452, '2018-04-15 18:39:45', 'vibhav', 7777777, 1, 500, 134475),
(27216, '2018-04-16 01:19:21', 'vibhav', 7777777, 1, 101, 134576),
(40428, '2018-04-16 01:29:52', 'vibhav', 7777777, 1, 101, 134677),
(2630, '2018-04-16 18:25:30', 'vibhav', 7777777, 1, 500, 135177);

-- --------------------------------------------------------

--
-- Table structure for table `kb7777777`
--

CREATE TABLE `kb7777777` (
  `TRANSACTION_ID` int(11) NOT NULL,
  `INSTANT` datetime DEFAULT NULL,
  `PEER` varchar(255) DEFAULT NULL,
  `PEER_ACC` bigint(20) DEFAULT NULL,
  `EVENT` int(11) DEFAULT NULL,
  `TRANSFER` int(11) DEFAULT NULL,
  `BALANCE` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kb7777777`
--

INSERT INTO `kb7777777` (`TRANSACTION_ID`, `INSTANT`, `PEER`, `PEER_ACC`, `EVENT`, `TRANSFER`, `BALANCE`) VALUES
(541741, '2018-04-15 18:39:45', 'shashwat', 1111111, -1, 500, 452441),
(546125, '2018-04-15 20:55:38', 'avinash', 5555555, -1, 100, 452341),
(27216, '2018-04-16 01:19:21', 'shashwat', 1111111, -1, 101, 452240),
(40428, '2018-04-16 01:29:52', 'shashwat', 1111111, -1, 101, 452139),
(2630, '2018-04-16 18:25:30', 'shashwat', 1111111, -1, 500, 451639),
(76504, '2018-04-16 18:45:42', 'kbd_online_shopping', 5555555, -1, 1200, 448039);

-- --------------------------------------------------------

--
-- Table structure for table `kb1234567890`
--

CREATE TABLE `kb1234567890` (
  `TRANSACTION_ID` int(11) NOT NULL,
  `INSTANT` datetime NOT NULL,
  `PEER` varchar(255) NOT NULL,
  `PEER_ACC` bigint(20) NOT NULL,
  `EVENT` int(11) NOT NULL,
  `TRANSFER` int(11) NOT NULL,
  `BALANCE` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `kb9874563210`
--

CREATE TABLE `kb9874563210` (
  `TRANSACTION_ID` int(11) NOT NULL,
  `INSTANT` datetime NOT NULL,
  `PEER` varchar(255) NOT NULL,
  `PEER_ACC` bigint(20) NOT NULL,
  `EVENT` int(11) NOT NULL,
  `TRANSFER` int(11) NOT NULL,
  `BALANCE` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `other_banks`
--

CREATE TABLE `other_banks` (
  `BANK_NAME` varchar(255) NOT NULL,
  `ACCOUNT_NUMBER` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `other_banks`
--

INSERT INTO `other_banks` (`BANK_NAME`, `ACCOUNT_NUMBER`) VALUES
('Bank of India', 4444444),
('State Bank of India', 3333333),
('ICICI Bank', 2222222),
('AXIS Bank', 5555555);

-- --------------------------------------------------------

--
-- Table structure for table `registration`
--

CREATE TABLE `registration` (
  `id` int(11) NOT NULL,
  `first` varchar(255) DEFAULT NULL,
  `last` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user_info`
--

CREATE TABLE `user_info` (
  `USER_NAME` varchar(255) NOT NULL,
  `PASSWORD` varchar(255) NOT NULL,
  `NAME` varchar(255) NOT NULL,
  `ACCOUNT_NUMBER` bigint(20) NOT NULL,
  `EMAIL` varchar(255) NOT NULL,
  `PHONE` varchar(10) NOT NULL,
  `BALANCE` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_info`
--

INSERT INTO `user_info` (`USER_NAME`, `PASSWORD`, `NAME`, `ACCOUNT_NUMBER`, `EMAIL`, `PHONE`, `BALANCE`) VALUES
('shash', 'shash123', 'shashwat', 1111111, 'shashwatkdm@gmail.com', '9632587410', 135177),
('vib', 'vib111', 'vibhav', 7777777, 'vibshades77@gmail.com', '123456789', 448039),
('pry', 'prasad123', 'prasad', 1234567890, 'prasad17y@gmail.com', '9604438318', 52005),
('', '', 'JEEVANT', 9874563210, 'lexluthorgonemad@gmail.com', '9874563210', 100);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `registration`
--
ALTER TABLE `registration`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_info`
--
ALTER TABLE `user_info`
  ADD PRIMARY KEY (`ACCOUNT_NUMBER`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
