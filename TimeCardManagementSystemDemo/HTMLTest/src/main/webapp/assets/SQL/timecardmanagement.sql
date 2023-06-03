-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 03, 2023 at 02:43 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `timecardmanagement`
--

-- --------------------------------------------------------

--
-- Table structure for table `shop_department`
--

CREATE TABLE `shop_department` (
  `department_id` int(11) NOT NULL,
  `department_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `shop_department`
--

INSERT INTO `shop_department` (`department_id`, `department_name`) VALUES
(1, '?X??'),
(2, '???X??'),
(3, '?z?[??'),
(4, '?L?b?`??');

-- --------------------------------------------------------

--
-- Table structure for table `shop_user`
--

CREATE TABLE `shop_user` (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `user_tel` varchar(20) NOT NULL,
  `department_id` int(11) DEFAULT NULL,
  `user_address` char(255) NOT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `hire_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `shop_user`
--

INSERT INTO `shop_user` (`user_id`, `user_name`, `user_tel`, `department_id`, `user_address`, `remark`, `hire_date`) VALUES
(1, '?R?c', '080111111', 1, '??????1-3-11', 'Good', '2010-09-11'),
(2, '????', '080111112', 2, '?????c??33-22-1', 'Good', '2012-03-01'),
(3, '??????', '080111113', 3, '?t?????s1-2-1', 'Good', '2020-08-23'),
(4, '???}?j??', '080111114', 4, '?k?? 1-3-11', 'Bad', '2015-02-14'),
(5, '?یˏ͉?', '080111115', 3, '?????s 3-6', 'Good', '2023-01-03'),
(6, '?O?', '080111116', 4, '??????1-3-4', 'Bad', '2019-02-20'),
(7, '?ۈ??I', '080111117', 3, '???c?? 1-4-6', 'Good', '2018-09-19'),
(8, '???????D', '080111118', 4, '?哇?? 3-8', 'Good', '2017-09-01'),
(9, '?t?R??', '080111119', 4, '?????s 1-5', 'Bad', '2020-02-12'),
(10, '?????闢', '080111120', 2, '?????? 1-1-5', 'Good', '2016-12-01');

-- --------------------------------------------------------

--
-- Table structure for table `shop_user_time`
--

CREATE TABLE `shop_user_time` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `date` date NOT NULL,
  `start_time` time NOT NULL,
  `end_time` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `shop_user_time`
--

INSERT INTO `shop_user_time` (`id`, `user_id`, `date`, `start_time`, `end_time`) VALUES
(1, 1, '2023-05-01', '09:00:00', '17:00:00'),
(2, 1, '2023-05-02', '09:00:00', '17:00:00'),
(3, 1, '2023-05-03', '09:00:00', '17:00:00'),
(4, 1, '2023-05-04', '09:00:00', '17:00:00'),
(5, 1, '2023-05-05', '09:00:00', '17:00:00'),
(6, 2, '2023-05-02', '09:00:00', '17:00:00'),
(7, 2, '2023-05-03', '09:00:00', '17:00:00'),
(8, 2, '2023-05-04', '09:00:00', '17:00:00'),
(9, 3, '2023-05-05', '09:00:00', '17:00:00'),
(10, 3, '2023-05-06', '09:00:00', '17:00:00'),
(11, 3, '2023-05-07', '09:00:00', '17:00:00'),
(12, 3, '2023-05-08', '09:00:00', '17:00:00'),
(13, 3, '2023-05-09', '09:00:00', '17:00:00'),
(14, 3, '2023-05-10', '09:00:00', '17:00:00'),
(15, 3, '2023-05-11', '09:00:00', '17:00:00');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `shop_department`
--
ALTER TABLE `shop_department`
  ADD PRIMARY KEY (`department_id`);

--
-- Indexes for table `shop_user`
--
ALTER TABLE `shop_user`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `shop_user_time`
--
ALTER TABLE `shop_user_time`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `shop_user`
--
ALTER TABLE `shop_user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `shop_user_time`
--
ALTER TABLE `shop_user_time`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
