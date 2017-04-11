-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 11, 2017 at 08:07 AM
-- Server version: 5.6.20
-- PHP Version: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `call_doctor`
--

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

CREATE TABLE IF NOT EXISTS `doctor` (
`id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `phone` varchar(30) NOT NULL,
  `latitude` varchar(100) NOT NULL,
  `longitude` varchar(100) NOT NULL,
  `degree` text NOT NULL,
  `specialists` text NOT NULL,
  `address` text NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=27 ;

--
-- Dumping data for table `doctor`
--

INSERT INTO `doctor` (`id`, `name`, `phone`, `latitude`, `longitude`, `degree`, `specialists`, `address`) VALUES
(1, 'Dr. Chayan', '01734811761', '22.808007', '89.565459', 'MBBS', 'Urology, Orthopaedics', 'PTI, Khulna'),
(2, 'Dr. Raju Halder', '01833770044', '22.806026', '89.565505', 'MBBS, FCPS', 'Eye, Dental', 'Miyapara, Khulna'),
(3, 'Dr. Parag', '01833770044', '22.802338', '89.540708', 'MBBS, MS', 'Dermatology, Endocrinology', 'Circuit House, Khulna'),
(4, 'Dr. Zaman', '01734811761', '22.830303', '89.540162', 'MBBS', 'Hematology, Orthopaedics', 'khulna university, khulna'),
(5, 'Dr. kamal', '00555545', '22.802141', '89.533958', 'MBBS, FCPS, MS', 'Urology, ENT', 'khulna university, khulna'),
(6, 'Dr. Mizan', '0298765456', '22.900515', '89.502356', 'MBBS, MS', 'Urology, Hematology', 'KUET, Khulna'),
(7, 'Dr. Raesh', '086868', '22.834954', '89.532968', 'MBBS, FCPS', 'Respiratory', 'Boyra, Khulna'),
(8, 'Dr. Faisal', '01710369809', '22.777522', '89.585086', 'MBBS', 'Gynaecology, Cardiology', 'Rupsha Bridge, Khulna'),
(9, 'Dr. Shilpee', '01982549491', '22.816421', '89.562616', 'MBBS, FCPS, MS', 'Gynaecology', 'Dakbangla Mor, Khulna'),
(10, 'Dr. Naznin', '017155335', '22.824383', '89.551277', 'MBBS', 'Gynaecology, Paediatrics, Cardiology', 'New market, Khulna'),
(11, 'Dr. Rajib', '01711567890', '22.812778', '89.574078', 'MBBS, MS', 'Skin, Dental', 'Zilla school, Khulna'),
(20, 'Dr. Eity Rani', '01711000000', '22.824781', '89.537969', 'MBBS, FCPS', 'Gynaecology', 'Sonadanga, Khulna'),
(21, 'Dr. Prokash Roy', '01700567890', '22.532326', '89.592060', 'MBBS', 'Paediatrics, ENT', 'Mongla, Bagerhat'),
(22, 'Dr. Sudip Bala', '01700111222', '22.532326', '89.592060', 'MBBS, BCS', 'Respiratory, Dental', 'Digraj, Mongla - 9351'),
(25, 'Dr Fahim', '017113692852', '22.52', '52.36', 'MBBS,FCPS,MS', 'Eye, Psychiatry, Skin, Hepatology, Oncology', 'khulna'),
(26, 'Dr.minu', '0151243424', '22.810115', '89.571791', 'mbbs', 'Eye, Dermatology, Endocrinology', 'khulna');

-- --------------------------------------------------------

--
-- Table structure for table `specialist`
--

CREATE TABLE IF NOT EXISTS `specialist` (
`id` int(11) NOT NULL,
  `Urology` int(11) NOT NULL DEFAULT '0',
  `Hematology` int(11) NOT NULL DEFAULT '0',
  `Orthopaedics` int(11) NOT NULL DEFAULT '0',
  `Gynaecology` int(11) NOT NULL DEFAULT '0',
  `Respiratory` int(11) NOT NULL DEFAULT '0',
  `Paediatrics` int(11) NOT NULL DEFAULT '0',
  `Cardiology` int(11) NOT NULL DEFAULT '0',
  `ENT` int(11) NOT NULL DEFAULT '0',
  `Neurology` int(11) NOT NULL DEFAULT '0',
  `Gastroenterology` int(11) NOT NULL DEFAULT '0',
  `Eye` int(11) NOT NULL DEFAULT '0',
  `Psychiatry` int(11) NOT NULL DEFAULT '0',
  `Skin` int(11) NOT NULL DEFAULT '0',
  `Hepatology` int(11) NOT NULL DEFAULT '0',
  `Dental` int(11) NOT NULL DEFAULT '0',
  `Oncology` int(11) NOT NULL DEFAULT '0',
  `Rheumatology` int(11) NOT NULL DEFAULT '0',
  `Nutritionist` int(11) NOT NULL DEFAULT '0',
  `Dermatology` int(11) NOT NULL DEFAULT '0',
  `Endocrinology` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=27 ;

--
-- Dumping data for table `specialist`
--

INSERT INTO `specialist` (`id`, `Urology`, `Hematology`, `Orthopaedics`, `Gynaecology`, `Respiratory`, `Paediatrics`, `Cardiology`, `ENT`, `Neurology`, `Gastroenterology`, `Eye`, `Psychiatry`, `Skin`, `Hepatology`, `Dental`, `Oncology`, `Rheumatology`, `Nutritionist`, `Dermatology`, `Endocrinology`) VALUES
(1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0),
(3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1),
(4, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(5, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(6, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(7, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(8, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(9, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(10, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0),
(20, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(21, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(22, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0),
(25, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0),
(26, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `doctor`
--
ALTER TABLE `doctor`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `specialist`
--
ALTER TABLE `specialist`
 ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `doctor`
--
ALTER TABLE `doctor`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=27;
--
-- AUTO_INCREMENT for table `specialist`
--
ALTER TABLE `specialist`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=27;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
