-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3308
-- Generation Time: Mar 11, 2020 at 06:37 AM
-- Server version: 5.7.21
-- PHP Version: 5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `attendance`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `id` varchar(255) NOT NULL,
  `department` varchar(255) NOT NULL,
  `minutiae` varchar(536) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `department`, `minutiae`, `name`, `password`) VALUES
('supravo', 'C.S.E.', 'pFbtXTGHMrFJAbeUkaLB+bAqnhMpQ/At0yQ0+dzUeZKos1xvwRkIKQgez5XVloN0UeKBdeTNh5TFNCd72eIYp4LWcmLvPsC9abm6HjaZYUuOjBY2ahejrYWvaDr/yD2duDXDPxj0qngTz18qw+Dk9vj7h2awpXNKkkgP+fFxE2Uf2x7fxeM47F228lnkOx75gAxj3HzjZDQR9uVVOdc0G6zs5jZ+4ghnh4npcViBf/XUWt2B3BZPtXRELuQHMf0FcdxLT3wbFVM28JZ6waZlV0cxcjblDHCzC0vt0bHGkrZFpTmK4/f2R2yZcfXtDkq4GctIFejj2RBkk2YaKgRlRhstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fA==', 'Supravo Sengupta', 'FeKw08M4keuw8e9gnsQZQgwg4yDOlMZfvIwzEkSOsiU=');

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
CREATE TABLE IF NOT EXISTS `course` (
  `id` varchar(255) NOT NULL,
  `department` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `sem` int(11) NOT NULL,
  `total_classes` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`id`, `department`, `name`, `sem`, `total_classes`) VALUES
('1', 'C.S.E.', 'right', 7, 10),
('2', 'C.S.E.', 'right', 7, 20);

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
CREATE TABLE IF NOT EXISTS `student` (
  `reg_no` varchar(255) NOT NULL,
  `department` varchar(255) NOT NULL,
  `minutiae` varchar(536) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`reg_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`reg_no`, `department`, `minutiae`, `name`) VALUES
('1', 'C.S.E.', 'LoyB52V68/3fl7Aekgo/FHRFDneyAvgMupwVnWZamwwd0HqptjVObcfD4JqoZDlATSLxgBfKU+ZAh/ulGIJH6G5wZxH3Ba3Zy4gYqCPHsfKZOQH36qeJoctbLpk3IWp9ULub4RJPGWcS5psely7qexiZe3gvUrVdk7vT1GfIJfzeLpSeodJEnxAd30kkGctwTQ5RQhzNdKN++j9YcIZau2QSunTAAVAUG9T7lGinUe8SBM1ge0aCtcnw3FAHlG1DanGXnydi2QKieoGNbq6Tfqp4jsRp15MYR1oLvuqjnzDt0VoNZ1dC+TY/3faWw2nM/zV05r/GVqBC3WS3mgrXSW5Gg5QEkJTi9E6GXMxlZvSek8VizmeJ99dy15sTsUQGGy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fA==', 'Supravo Sengupta LT'),
('10', 'C.S.E.', 'xljFmPwjDEJLXfuPVyxm9kKq0W8hk5sULRUDnAiY9Q/0vg7VUPf3QPfBnjuyUXTi9tOZdkCQUYZI883P6ZX/BG5PFshOsird7CZHPu11AtdeioiV0TJI1mwptBX28Tgvr1czLUlEZspCZQLdcT5W6aroBKNnYsxxuZhy8g7QVANltuZ2aDrAbL+I8f58vxVfvK5tjEeHXTyOVppvrrise4itQW4/6SH/kJCxclpj0KaEIF5zqiVNvGDwmArj/tIvwwU5lPmoEm1+h2aN8Po+0TFFyP64uG+iSHSedvfFnnd961DwXVxLh7RqhIihjIoG9+VZUNdwILi3nFP0oh6NkBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fA==', 'Supravo Sengupta RL'),
('11', 'C.S.E', 'fxyRehoI7O9RCqHxLItGp9tVMgT6ogqqPK74/NLb0Y8375jGclbkVvsqOvMtChDdjXEO6gh+/7zoeuSIHu6ta7q4yJnyKmH+pXVJsnTaA3OT0mtmLwRaH1HHHFOqfW1MmGp99OAs7GsXc6wcgF9uAWf+dTGRUIFItKyu5Awm9yysgOSiMS8M4Ki3m8OMXJwRpdYljfZDhhwL4vsaYIk1tFYLD07/cDBGyoHTh5ekGWhGKbeyLbV24riy4eCla69hGy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fA==', 'Sumon Nath RT'),
('12', 'C.S.E', 'dmpY9SEu3Nhod2+yo9dXfapWAmR5IOlhU4u6/6IqAMThGbW2KvNxRjvqzQCoIg3xbl5uWysh+o5Zp9D4SxaAuVD7AaE7VQuJ7ItOcPCZ4VxHsmSZk+bOzQmctWUfvbZMgqOM3ONTaYgFgs27PW2x0yPl/V7VVNaf/S7ab2RN3fKi0w24mjTg+0Sk7GKzj8ZI6PJ3mAZS2BkFsuBH5ojGipW95gOzLMRJra1HWuqXu5lWtSKfuaVAD3EjvuZEqYEqSEOY/8ufua8zoh6Qw1xwnRstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fA==', 'Aritra Saha RT'),
('15', 'C.S.E.', 'Mmv8ot+IzEGCwMyTz/s0yJLXDSWWUjc+jCyKg3PxK4Z8VUIf8ugLKaZwSbpKk+J67bKbo6UZ8PmDBXntA/jHHSxmCyLuWhSs1nodNVqDCCscpA6tJYKr6rJGVGZPo0vDCIgpM7tt6MYKyQIZXq25SRKkY6a89OCD58bnaqLMnbGSNvYotKm9ebzrim9AxS9u3pmjqlTXaBfLXu8Jl5ntrkRFWbxQjBMxpbLh7FlVW+lZJMSR8tFIr6RuAJ7UfI9WGy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fA==', 'Sampurna RI'),
('16', 'C.S.E.', 'iAdezK4Vy+aQsbW6F39/3NtVMgT6ogqqPK74/NLb0Y+e5OgmIjfMBSgevnHmTPlRWFXf3806jN1o1bCE00NtpqJzkfOzRYZQbC9MWqUOcoYYgQqh3h25syCEE/sqI8+CRch4ErJzVDAGsU2WMa4MUe4Ur4/GSwREHbIaR6PzLI5V1Gh20V1vk7Q9O6+SjdOFATrv9y/dAlLP1ccYT4Yo0azJNyghI8Y69rljbeZxY6Z4MN5frqxoTfxlwZyXqqJXEucGTn6TmGLhg68/yDIogxstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fA==', 'Arkaduti RT'),
('17', 'CSE', 'W/gjDRGqcz+OKMHHnJsDmp+poySrqc9XAUfkEfC3r/v/bb0xuy8oEk/krt59Szg9JJcHYWBfJbER9k5+hnWym6AhgH2ez/H6MC5TsiDFR3AWgpMepHaOMhPHxVipGHcuHQiWGXdMS4TURYe9sfTCJHBiP4lr8rmNwH5x9DnlT6LsrfW337dt7qAxpN/szrOWBJuYwoEEDJOWsiKBYefe3GTszZTzet2JglUOMpk2KdeNVIxN4sDM5ZyMCoo5eZtD64i0asRg7s/wBfK+ncr/09MtpKyfIcvbNG0pFx28srIbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fA==', 'Aritra Saha RI'),
('18', 'CSE', 'NHgn8jLDt+udiLCwIF5CCASr9bQby1c2O3NsaEg3y2xJ9XhDTYIgRLWsNocQ0382nq86GPzGRAJiNO5qTuWnWKoP9gu3Nbj5L39jsEvxSMNuE2++6HC6HOj7T6G2CNy4MwkBy3HDyERgHLNfmhLBbl53h5Annt0kgXHRjRzofv7DmEvpoW+DQNxhIJwJMr0SLyC01B3PZEeUdHzTmsM9ZYboGttef36K/e82ra0kTuhXo8E4dfzwc12r+PYkAPOr2Mq/L9z+IyZoqZtz4eod8LKm0AA6LDAg7x6fW4ACuaGU88JZdVNIz/w4sid6oilQdd5jRvNQpVIq9Zek1gKCMg57pJ56pKeUlvOP45QoH6QbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fA==', 'Aprajita Das LT'),
('19', 'CSE', 'TzshY9ZPUloZhb4zMCLE1NtVMgT6ogqqPK74/NLb0Y9azLQ7hskPKIEACc8jdKHuTS3+x5GhgHVzzv0yYQ/szWK1sY1V6u2xzWy0CSvdc6B5Ye6HV+vMEufeuqBGobgm4gYicRkjb35ZiUfu0YaC8wxoD+bVMdJRHn5Noe8GvUepOzcbOcBbdmU3IKCQA0wtddPRu71WXu1Dt3RNW9qXs1u7GMgC/RlAfKsBx9DbMjVJ6iM9wSbKM752oMdON1c4g3F7FAm2HLilBkKvKtLp0sH+mDWWw1C1yho+xd+2gbIbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fA==', 'Aritra Saha RM'),
('2', 'C.S.E.', '+KK4891BbGwB0G6v0s52Bjvnsrrj1/egGD4+Eyma6ut3xIvZeX0lMxSa92XshfjdGAnXjdNpymMHxJ2pS/jscXoLeaa5DvLuQAEKciiTUy3EtuPwKBD4CTSGGpqRyRlAOlfgl2q6AiHQzd8n4Q9uxPsd/ktJtqJAT6r9z/IDf0QZfUphNIZ/3FmMpRoPSqxJCSs4hxfl7+w2upZ6d5taTehEwuQxTanDEajpB5VDH45gT0c8Zb7ySADauMuINSaEVKZxgOaceIPwyO38qrh2Ut8j9DnSIMLoK/4QWn6f4orKbVlH6OP3qiMMVVNRoRquFaurBUiAt1bP1+1FaFauNRc+U9ihS+xxHrQjU8MMV2dTP9mmwm14II+zfiZA/5A5wwAgQ3QgO/1357ZpQS8fthstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fA==', 'Supravo Sengupta LI'),
('20', 'CSE', 'qY/NVlb9bKDoud5u8eact2J9/MH8RxiokSHTx/8XbnGFxPd87sqdrsINv+5pYzuDoLXxH+GV9k+l/b9gvP0yYMkl17u3TghA+kc6sNHDPaNBiCCi+Z0YD0f1C5Lq8XnXFobW/Xiez6D9K/5V917UtxNDnz2dZM43wNQR5DXPooOW6ASE/1P64qm9GJYAP7tBI6uEGTtHVY6OS/evkByc49c0hJgrWYl9klONbS+Og1SG9QwR9+LQOa0Bm4Hy2AZNNgNEHk2rmyQC6OaZDJkr4RstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fA==', 'Aritra Saha RR'),
('21', 'CSE', '61z8ETvgvampH/9IuA/5hM4ildlpPuVu8BwmzExP2f4ttVAWQYgjxI5PYPfNRQ7ZR+B7/HaaD9ZoREZqxHyDxxJIMdM//AhMKAzT/kZIUu/wujwLuDdQVcqxLTQJgVc0x1eC7TshNzNBz8ndBIC7C3iFSwrWhYZ9KxQkemgDvHuCWt9aPpg5r0lZRpzDXe0+LF3jdkaGEbO3AYJ27PeBkTgT0Y+6rKP8pP1HZYoNhc4bLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fA==', 'Aritra Saha RL'),
('22', 'CSE', 'ZyJDVBKz+8I2FbM8qG1sKAGGjnj2JHI9//SfbufnKXGy7YWLwV/AenES77JU8QJ6tuxbkIBy1JU3qN4KK8QBryrGzSNiCzUkyKo2jYgbL69a9Hu7Lx/4W/sygjURg8e4eeq2YDG027MPK0924GVSMO6jfV8lognnyydVrwhtvJySEFHM5nUCAbFfGbbo1qhSFXPYVhvEiy3chJP086A+PI367J9SIo9aygmq6sMTviQq6dDjb8wve6BnzfFDh7GkMuNj9wLwdbrmmFCirGdgLTcleNy4HDuJgxP4ngevGk5ATbosKAvuTEfuf7DJOMCgLUWLZ9UY1dPLDBnwqxtTDhstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fA==', 'Aritra Saha LT'),
('23', 'CSE', '7YAlv97HQMeWaaZQS5ViE/71VfTJk6MAJbxpUOOQdbIOgvExbYBwyMZY3V2ik5oN5ZQJjQUJP36jWQcHyyjPkRzw30odqoeJwKga6B75ImUvNvDbILaEZ64diYWEbAapJWfS+hu04dD4lF7ckMh/5JdwSqeIvqamJL8Ud1bRM3cXjICnCgKTH6cRh37m2LfdGT8NDwIrU9F3ZPz242mu/BstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fA==', 'Aritra Saha LI'),
('24', 'CSE', '9mBUFE6eVl7LL7oNesD6XpYj7z/bm9dOQLkf0Iw6ytMxGSWd4dKzm1YsgS6lk0GQhPbbP8gu+MVm2Qc8f6pYMtbgu2Ue+v9nrpayizJA8kkhJnW2iStTeur9rCbFOroeem8bDK1vQ4s1WYiF7PsQcZwJcgQI0ZX7npLWIA1ODmGRgF4vB3xvIXUo7jp76IU8Z0XCUQ/RHmfujRjPN0tHYP41S39uJ6Rj/5aANjSKnLyaiEB+c8e5RdFDW2qz9xPsMtkukSjBMs7/h3oDaTt5IJLFktKmoEjalgOVL6z7RV6r9JDAaWGBx9tbfnrm/fZHGy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fA==', 'Aritra Saha LM'),
('25', 'CSE', 'PdqPlfesq+Gr39YKhIL0UQhcSiejvLOMuOOfz7RwQ9sCkOffNDdoWhASN2bdOIHopYHtmvsuUokycjFwTUGUUWMrXMLZns8u70ISw7ZP7cKJe+agPQiYjpkcGnKLH+TB8AANhy5cHdNTxWa2GBk7k6V3x8mYoBUjOfeM98klwwQzlR+xh1wKcU2VmHpORv8Phed+gFKT1+wF1lSBQyRAK6+y/pATwPXMSKf4GbLwuHqhuDZp4KR/S0K6UWeXHjbNVl7/uCaN23XWkb0+tcFYjUHQScflAKM9InCC3KWNgQ9Hvo/xaYLCfO/tD+VPk7zfmDg87zZ6Um0/+CDLJm5Pt8PQRO1VWJ+RP/w2hc6n+1IbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fA==', 'Aritra Saha LR'),
('26', 'CSE', 'Jic61mucjtpIaopRm156MgCvOr3iMCqCi/y37kyVMGVYHzeBWZXe4HHHTnrYOtX2wmkdm3DG2pc8RzAskIt9E1CVajjdFGKV64bXH87ynlTyRbcBo3vCNUS7aqmnW99IGEm6Xgc9r7I/V8+tzhtBQzA0HmQUMlE2XyP21DpOsB9+jYQSPiwdOjED0QVnmCk22X+eXT8p31vrTKSFS+J2m1aVYSC4TFK+rp2XHyGycOwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fA==', 'Aritra Saha LL'),
('3', 'C.S.E.', '45RBMJK0u9b3VuHerwbul3IY2xbtOSqwdhJOVpYhKm4ev8F7uXnkDg7wE5kD3maPv9iHj/GrftV3dapZbvBt1VYZxrp6JqEraCLXunyZJu77sdOViYTNgmsOPtmD69RMx9pXMEQgij+JyhBriny7CQpI4fWwEm5PZF0PklLEa5zIU/P4JzIKh6qGdNf1aPDTUDc/aJ9XyhKJVWGA1rhJboq5Onbt9tbJaa+nnyjXIrqY0GEDyy28w7OkRKq3NEdKW0lnb6pdDTGIwzDMpVdb1xJQ/abMpwZiIhqLuzry486cLM9HYloUdpxv/AoE1UterHc9w6/Z0p+REN8a0yBPFyYHZd79cCg3KdMy2piiSoKMxhVBwY0xWsHqgUqgQ0YIHDy9OULF2X8J7RkXxbicSBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fA==', 'Supravo Sengupta LM'),
('4', 'C.S.E.', 'rck4nwCH8qbkqkVHnCxTWrarEP31NfE3m9FyENdQqxCzjhUPoBf2fKwbHXbDDSLevlM2/TjP3z6ygd9YVgjc53GK3xpGPnFdbNfT81Dp9ZIf2zij6uu0T098Ch+v+fJ7DS5V2uglnFX+nUIsQ21+IKE6dN6BNhGRIZ2aNXkWS8Pwqin9oG/ry2bbW3EhekewknPv59FXR+uRGotJUASlPoTvFBUrjnhqJ7ql6twLQjoPZ3HdiQWhE3HfeN+AhnK/ElO/Zw6v7It+xqpMNmBo4B4K2eXcYLSJhbhFxKPEMlgbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fA==', 'Supravo Sengupta LR'),
('5', 'C.S.E.', 'CdtbxxLRrc+DYU6PrnXZIz4ejf31Rg52zZxlsOmFBiYRwMJ5QCOGRc2PWfkqlz0ehaKWqhUYDAKVK2MYsnnjsHKGZEuZ77QamU+gvWNNp8ybpsYEw3g+zjgPKc+buzvzTfMm234Kf1CdE03yF+3HvjNegGICwk6nBpAqT/jUKgqCQpbbmB+u+bzgNnqpmRpgjyWJQROV/BfCcFJw0ENvRIwy5+Qpjgr+Pp2xwc1CT3Cu2jLPBaF+ve6T49LeK+nG2f3oVYdfAj4eqnxXuoxALyA7E1sE6W60if7w47xfrh4y2xdgzTn0fOvINO7Kw+HrdJ8QZkwkJw1oFZwoxQW9tRstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fA==', 'Supravo Sengupta LL'),
('6', 'C.S.E.', '8CKkVvFIrGdiUqc6muamKbAqnhMpQ/At0yQ0+dzUeZIFc3ITZxPYoT5WZBBvXh0nXiH21VhN4wuXVRfLZGd/3dwGdbw34PkanfyHTdL/33CyXyvFnf9tGO8drUla8dTj6NddFEe758Q6ggENZyEVFjBsRyi/VG3ldNQH2jPOg84+zgncjiKK3vNfXYeMZIZ3sM/buOSn+A4GNCmtPTPRZPzPhgY8XdjIy9uDS70XLqoKSSykg9tR7dctSqVbjqLqhHaLM+wPEaX+u4y1IWaZd8P2zl0kDzt+8ueSfIxAraoBLNSCbGAibfUgiHl9qbjJzKpwbx2lXHzsKGobheWohuxjncLT8TmUk/aN6zGKYpDN/dBNRueSwvUlASMz0GQEGy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fA==', 'Supravo Sengupta RT'),
('7', 'C.S.E.', 'AZSwae9IcfWj0518HpV2crWOm8ChsLhixtEvZ3Vy0WcR+2VYrjipKF/tF11FJSZ68bdf4+M6qW8g2kPBmtlf2Hx+Q8KLTaoaTyvuUAK8N8j+elgVAwetteiKFEBQhgORk1R/S61KTs842Ovc8Bf0xLh0sttf0Du+FYCw4MLnLaZScrqoRl0/zKKYdwhDbV0Yk+AlCM+ToAOyaTZ2KHTs8fVEBKQpzbqcrDA+pMMCAhCq2OkWjEzoRcRdp9lmQpM49yEK/XYdVEyRrsVsTpgO2BstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fA==', 'Supravo Sengupta RI'),
('8', 'C.S.E.', 'c1PjIunhcnCwJhzoTlhVvteMGDlzRTKWEe9Nf+Uk7KQqBqcxKd10or4W1uHOr3IAZMXtXsTJCdP2tH4LahbHPotkFsTQ4V9gpSWw2/wP7BJehAniMgsPjyg9RPwU/iyS7SmcHoUfUeWf8WXSdpTRz8L9uT5M1o0yZeutXgYRQNN1NGmYO2k3HsBJdbIsPqLH33uWWtFP00RNnpzDDjrjcKjIz7y2tPH15m4rMrnVy+rip1IdYnEiDHJdEB9hmWZp7+OAF2NZzt9NOQNCullgwBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fA==', 'Supravo Sengupta RM'),
('9', 'C.S.E.', 's2FAKRP7l/XYgTkGdlKJAnr7wiSrqCUuZXF7f6PnLIXJfJcvVsgdEXJwlvlpDjVkzxgvs74C3ij7qtGKvA2m3WHRpSER638Qv9U4vhBF8+gRYLmzw331AzLGd0GIlO7Nj0Raco+8JEjswvYGtxIrEVbbimVl8BGng1wNlAVfRu2aTG+yjeir7VUhobw9lRmZxBSeF7YrWvKf6SAsYBApXMX4fcHDvWe1njHCyeX+fL0FkyavLyF68DYdRqAKCANz5NZe65Je8kXtLj5mPiJ1/ISFtHMKOmkkK01+79V5F6HATETAoTh73nya8AOsiORipTfh90QrFBJ62qZ8YLr9AfK2MOqUBpiPKj1lB06tX6WacwUNWYC2iXGXJmwIPFPeQ3aFr//aYIfwi7fC7uZs2BstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fBstyeuvDV9gKmT/R/Bs+XwbLcnrrw1fYCpk/0fwbPl8Gy3J668NX2AqZP9H8Gz5fA==', 'Supravo Sengupta RR');

-- --------------------------------------------------------

--
-- Table structure for table `student_course`
--

DROP TABLE IF EXISTS `student_course`;
CREATE TABLE IF NOT EXISTS `student_course` (
  `course_id` varchar(255) NOT NULL,
  `student_reg_no` varchar(255) NOT NULL,
  `attendance_count` int(11) NOT NULL,
  PRIMARY KEY (`course_id`,`student_reg_no`),
  KEY `IDX8eu2c4tg0i8amuwx6n6d4i8h0` (`course_id`),
  KEY `FKskq5791g3vys6u2m7jeq9qold` (`student_reg_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student_course`
--

INSERT INTO `student_course` (`course_id`, `student_reg_no`, `attendance_count`) VALUES
('1', '1', 0),
('1', '2', 0),
('1', '3', 0),
('1', '4', 0),
('1', '5', 0),
('2', '10', 0),
('2', '6', 0),
('2', '7', 0),
('2', '8', 0),
('2', '9', 0);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `student_course`
--
ALTER TABLE `student_course`
  ADD CONSTRAINT `FKejrkh4gv8iqgmspsanaji90ws` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`),
  ADD CONSTRAINT `FKskq5791g3vys6u2m7jeq9qold` FOREIGN KEY (`student_reg_no`) REFERENCES `student` (`reg_no`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
