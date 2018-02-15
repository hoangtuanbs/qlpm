-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jan 08, 2011 at 05:10 AM
-- Server version: 5.5.8
-- PHP Version: 5.3.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `clinic`
--

--
-- Dumping data for table `booking_ticket`
--

INSERT INTO `booking_ticket` (`booking_id`, `ticket_id`, `booking_date`, `booking_status`, `note`) VALUES
(4, 2, '2011-01-08 10:01:20', 1, ''),
(5, 2, '2011-01-09 10:16:23', 1, 'Mài cùi'),
(7, 2, '2011-01-14 10:47:12', 1, NULL),
(8, 4, '2011-01-08 14:48:29', 1, NULL),
(9, 4, '2011-01-14 19:15:39', 0, NULL);

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`user_id`, `fullname`, `age`, `address`, `phone`, `identity`, `birthday`, `gender`, `note`, `date_create`) VALUES
(5, 'Trần Thị Tâm', 51, '73 Hoàng Văn Thụ', '123456789', NULL, 1962, 0, NULL, 28112010),
(6, 'Vũ Tuấn Điều', 35, '73 Hoàng Văn Thụ', '456789', NULL, 1976, 0, NULL, 28112010),
(7, 'Nguyễn Văn Nhàn', NULL, '66 Kapakolong', '1234567894', NULL, 1987, 1, NULL, 28112010),
(8, 'Mai Văn Sáng', NULL, 'Ngọc Hồi', '6985855', NULL, 1983, 1, NULL, 28112010),
(9, 'Vũ Thị Thanh', NULL, '66 Kpakolong', '98765423', NULL, 1983, 0, NULL, 28112010),
(10, 'Mai An Tiêm', 24, NULL, NULL, NULL, 1987, 1, NULL, 29112010),
(12, 'Mai Anh', 14, NULL, NULL, NULL, 1997, 1, NULL, 29112010),
(20, 'Nguyễn Lê Bảo Nguyên', 19, 'Hoàng Văn Thụ', NULL, NULL, 1992, 1, NULL, 4012011),
(21, 'Trần Thị Huệ', 22, 'Cao Bá Quát', NULL, NULL, 1989, 0, NULL, 4012011),
(22, 'Hoàng Hoa Thám', 60, NULL, NULL, NULL, 1951, 1, NULL, 4012011),
(23, 'Trần Huy Hoàng', 29, NULL, NULL, NULL, 1982, 1, NULL, 4012011),
(24, 'Nguyễn Huệ', 21, NULL, NULL, NULL, 1990, 1, 'Bệnh nhân chưa trả tiền', 4012011);

--
-- Dumping data for table `operation`
--


--
-- Dumping data for table `operation_service`
--


--
-- Dumping data for table `operation_ticket`
--

INSERT INTO `operation_ticket` (`ot_id`, `operation_name`, `operation_target`, `user_id`, `day_create`, `note`, `ticket_id`) VALUES
(1, 'T2', 'R12', 1, '2011-01-06 17:18:54', NULL, 2),
(2, 'R2', 'R12', 5, '2011-01-06 17:19:35', NULL, 2),
(3, 'Mài cùi', 'R33', 5, '2011-01-06 17:23:36', NULL, 2),
(4, 'VR', 'H', 1, '2011-01-06 17:54:06', NULL, 3),
(5, 'T2', 'R12', 3, '2011-01-07 14:46:05', NULL, 4);

--
-- Dumping data for table `operation_type`
--


--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`payment_id`, `user_charge`, `amount`, `date_create`, `last_modified`, `ticket_id`, `note`) VALUES
(1, 1, 100000, '2011-01-06 22:51:54', '2011-01-06 22:51:54', 2, NULL),
(2, 1, 1550000, '2011-01-06 22:57:17', '2011-01-06 22:57:17', 2, NULL),
(5, 5, 300000, '2011-01-07 14:53:00', '2011-01-07 14:53:00', 4, NULL);

--
-- Dumping data for table `prediction`
--

INSERT INTO `prediction` (`prediction_id`, `alias`, `name`) VALUES
(1, 'S2', 'Sâu ngà nông 2'),
(2, 'S3', 'Sâu ngà nông 3'),
(3, 'T1', 'Viêm tủy nhẹ'),
(4, 'T2', 'Viêm tủy 2'),
(5, 'T3', 'Viêm tủy nặng'),
(6, 'NC', 'Nha chu');

--
-- Dumping data for table `service`
--

INSERT INTO `service` (`service_id`, `service_name`, `alias`, `description`, `upper_price`, `lower_price`, `unit`) VALUES
(1, 'Nhổ răng thuốc tê xịt, răng sữa', 'NRSX', 'Nhổ răng sữa với thuốc tê xịt', 20000, 20000, 1),
(2, 'Nhổ răng thuốc tê tiêm, răng sữa', 'NRST', 'Nhổ răng sữa với thuốc tê tiêm', 40000, 40000, 0),
(3, 'Cắt lợi chùm 1 chân', 'LC1C', 'Nhổ răng 1 chân', 150000, 150000, 1),
(4, 'Cắt lợi chùm 2 -3 chân', 'LC23C', 'Nhổ răng 2 - 3 chân', 300000, 200000, 1),
(5, 'Nhổ răng số 1-2', 'NR12', 'Nhổ răng số 1, số 2', 120000, 100000, 1),
(6, 'Nhổ răng số 3-5', 'NR345', 'Nhổ răng số 3, 4, 5', 150000, 120000, 1),
(7, 'Nhổ răng số 6-7', 'NR67', 'Nhổ răng 6, 7', 180000, 150000, 0),
(8, 'Nhổ răng 8', 'NR8', 'Nhổ răng số 8', 250000, 300000, 1),
(9, 'Nhổ răng 8 khó', 'NR8K', 'Nhổ răng số 8 kèm theo các xử lý phức tạp', 450000, 400000, 1),
(10, 'Trám răng S2', 'S2', 'Trám răng sâu ngà nông', 100000, 100000, 1),
(11, 'Trám răng S3', 'S3', 'Trám răng sâu ngà sâu', 150000, 120000, 1),
(12, 'Trám răng T1', 'T1', 'Trám răng viêm tủy nhẹ có phục hồi', 150000, 120000, 1),
(13, 'Trám răng vĩnh viễn', 'VV', 'Trám răng vĩnh viễn', 200000, 150000, 1),
(14, 'Lấy tủy + trám răng 1-3', 'T2', 'Lấy tủy + trám răng số 1, 2, 3 T2', 300000, 300000, 1),
(15, 'Lấy tủy + trám răng 1-3 VCQ', 'T3', 'Trám tủy', 350000, 300000, 1),
(16, 'Lấy tủy + trám răng 2-3 chân', 'T3S', 'Trám tủy 2,3 chân', 350000, 300000, 1),
(17, 'Trám tủy + trám thẩm mỹ răng 2-3 chân', 'T3TM', 'Trám tủy + trám răng thẩm mỹ', 350000, 300000, 1),
(18, 'Lấy vôi răng', 'VR', 'Lấy cao răng', 100000, 100000, 2),
(19, 'Thổi cát', 'VRTC', 'Thổi cát làm trắng', 30000, 30000, 2),
(20, 'Nạo lợi ', 'NL', NULL, 400000, 400000, 2),
(21, 'Răng chụp nhựa', 'RCN', NULL, 250000, 250000, 1),
(22, 'Cầu sứ kim loại Chrom Niken', 'SKL', 'Cầu sứ KL Chrom Niken', 700000, 700000, 1),
(23, 'Cầu sứ kim loại Titan', 'SKLT', 'Cầu sứ kim loại Titan', 1200000, 1200000, 1),
(24, 'Cầu sứ kim loại Zicona', 'SKLZ', 'Cầu sứ Zicona', 3500000, 3500000, 1),
(25, 'Răng tháo lắp Việt nam', 'RLTVN', 'Răng giả Vn', 150000, 100000, 1),
(26, 'Răng tháo lắp ngoại', 'RTLN', 'Răng giả ngoại', 200000, 150000, 1),
(27, 'Răng nhựa mềm Biosoft', 'RNMB', 'Răng nhựa mềm Biosoft - răng sứ', 700000, 700000, 1),
(28, 'Hàm khung kim loại Chrome - Niken', 'KKL', NULL, 1500000, 1500000, 3),
(29, 'Hàm khung kim loại Titan', 'KKLT', NULL, 3000000, 3000000, 3),
(30, 'Chỉnh hàm', 'CH', NULL, 200000, 200000, 4);

--
-- Dumping data for table `service_ticket`
--

INSERT INTO `service_ticket` (`st_id`, `service_id`, `ticket_id`, `price`, `target_id`, `service_log`, `target_log`, `note`) VALUES
(1, NULL, 2, 100000, NULL, 'Lấy vôi răng', 'R13', NULL),
(2, NULL, 2, 150000, NULL, 'Nhổ răng số 6-7', 'Hàm', NULL),
(4, NULL, 2, 700000, NULL, 'Cầu sứ kim loại Chrom Niken', 'R12-14', NULL),
(5, NULL, 3, 100000, NULL, 'Lấy vôi răng', 'R13', NULL),
(6, NULL, 2, 700000, NULL, 'Cầu sứ kim loại Chrom Niken', 'R23', NULL),
(7, NULL, 4, 300000, NULL, 'Lấy tủy + trám răng 1-3 VCQ', 'R11', NULL);

--
-- Dumping data for table `target`
--


--
-- Dumping data for table `ticket`
--

INSERT INTO `ticket` (`ticket_id`, `date_start`, `ticket_user_id`, `last_access`, `notice`, `total_payment`) VALUES
(2, 4012011, 21, 7012011, NULL, 1650000),
(3, 6012011, 22, 6012011, NULL, NULL),
(4, 7012011, 5, 7012011, NULL, 300000),
(5, 7012011, 6, 7012011, NULL, 0);

--
-- Dumping data for table `ticket_prediction`
--

INSERT INTO `ticket_prediction` (`tp_id`, `prediction_id`, `ticket_id`, `date_create`, `user_create`, `target_id`, `target_log`, `prediction_log`) VALUES
(2, NULL, 2, 6012011, 3, NULL, 'R11', 'T2'),
(3, NULL, 3, 6012011, 1, NULL, 'R12', 'T3'),
(4, NULL, 4, 7012011, 1, NULL, 'R11', 'T3');

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `user_name`, `user_role`) VALUES
(1, 'Vinh', 1),
(3, 'Điều', 2),
(4, 'Tâm', 2),
(5, 'Mai', 2);
