-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Host: db
-- Generation Time: Mar 05, 2022 at 04:13 AM
-- Server version: 8.0.28
-- PHP Version: 8.0.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ecommerce`
--

-- --------------------------------------------------------

--
-- Table structure for table `address`
--

CREATE TABLE `address` (
  `id` int NOT NULL,
  `id_users` int NOT NULL,
  `address` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `address`
--

INSERT INTO `address` (`id`, `id_users`, `address`) VALUES
(1, 3, '8755 Dawn Junction'),
(2, 23, '58275 Darwin Crossing'),
(3, 27, '590 Forster Crossing'),
(4, 2, '57147 Eagan Way'),
(5, 3, '6519 Magdeline Court'),
(6, 28, '80801 Manufacturers Parkway'),
(7, 14, '64 Hooker Circle'),
(8, 7, '9 Summit Plaza'),
(9, 12, '773 Manley Alley'),
(10, 9, '1340 Susan Drive'),
(11, 17, '80 Chive Drive'),
(12, 21, '7 Algoma Park'),
(13, 12, '397 Miller Hill'),
(14, 3, '817 Evergreen Avenue'),
(15, 23, '0 Main Crossing'),
(16, 19, '59 Sage Road'),
(17, 7, '6 Maywood Park'),
(18, 8, '3139 Crescent Oaks Circle'),
(19, 13, '59610 Hermina Way'),
(20, 29, '810 Nobel Junction'),
(21, 8, '9 Oneill Parkway'),
(22, 19, '1303 Rockefeller Circle'),
(23, 8, '54 Manufacturers Way'),
(24, 26, '07806 Hoepker Place'),
(25, 21, '0355 Marcy Center'),
(26, 4, '9 Sherman Circle'),
(27, 14, '91289 Scott Center'),
(28, 17, '45 Kim Center'),
(29, 13, '06386 7th Center'),
(30, 14, '9378 Victoria Drive'),
(31, 19, '889 Sheridan Point'),
(32, 21, '1 Roxbury Avenue'),
(33, 29, '36855 Mosinee Trail'),
(34, 14, '88 Logan Park'),
(35, 29, '9316 Paget Parkway'),
(36, 26, '5 Melrose Park'),
(37, 25, '4 Northfield Plaza'),
(38, 11, '41466 Waubesa Crossing'),
(39, 10, '553 Crowley Junction'),
(40, 10, '52 Kinsman Road'),
(41, 24, '9275 Mccormick Road'),
(42, 24, '1 Debs Point'),
(43, 4, '2840 Montana Alley'),
(44, 9, '70 Kim Avenue'),
(45, 21, '1284 Moland Hill'),
(46, 22, '248 Westport Trail'),
(47, 9, '3 Sachs Point'),
(48, 13, '208 Village Green Lane'),
(49, 16, '497 Florence Terrace'),
(50, 8, '19 Miller Road');

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

CREATE TABLE `cart` (
  `id` int NOT NULL,
  `id_users` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `cart`
--

INSERT INTO `cart` (`id`, `id_users`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10),
(11, 11),
(12, 12),
(13, 13),
(14, 14),
(15, 15),
(16, 16),
(17, 17),
(18, 18),
(19, 19),
(20, 20),
(21, 21),
(22, 22),
(23, 23),
(24, 24),
(25, 25),
(26, 26),
(27, 27),
(28, 28),
(29, 29),
(30, 30);

-- --------------------------------------------------------

--
-- Table structure for table `cart_product`
--

CREATE TABLE `cart_product` (
  `id_cart` int NOT NULL,
  `id_product` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `cart_product`
--

INSERT INTO `cart_product` (`id_cart`, `id_product`) VALUES
(8, 2),
(24, 18),
(22, 47),
(9, 55),
(17, 62),
(8, 89),
(27, 89),
(5, 103),
(17, 105),
(4, 110),
(9, 112),
(18, 116),
(8, 119),
(10, 119),
(1, 120),
(25, 124),
(26, 126),
(15, 133),
(4, 134),
(17, 139),
(16, 146),
(4, 149);

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `id` int NOT NULL,
  `name` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `name`) VALUES
(1, 'men clothes'),
(2, 'women clothes'),
(3, 'mobile & gadgets'),
(4, 'electronics'),
(5, 'computers'),
(6, 'cameras'),
(7, 'watches'),
(8, 'men shoes'),
(9, 'home appliances'),
(10, 'sport & outdoor'),
(11, 'automotive'),
(12, 'moms, kids & babies'),
(13, 'home & living'),
(14, 'beauty'),
(15, 'health'),
(16, 'women shoes'),
(17, 'women bags'),
(18, 'fashion accessories'),
(19, 'grocery'),
(20, 'books');

-- --------------------------------------------------------

--
-- Table structure for table `country`
--

CREATE TABLE `country` (
  `id` int NOT NULL,
  `name` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `country`
--

INSERT INTO `country` (`id`, `name`) VALUES
(1, 'China'),
(2, 'Jordan'),
(3, 'Russia'),
(4, 'Poland'),
(5, 'Brazil'),
(6, 'Croatia'),
(7, 'Germany'),
(8, 'Tanzania'),
(9, 'Syria'),
(10, 'Palestinian Territory'),
(11, 'France'),
(12, 'Philippines'),
(13, 'Peru'),
(15, 'Ivory Coast'),
(16, 'Czech Republic'),
(17, 'Colombia'),
(18, 'Australia'),
(20, 'Indonesia'),
(21, 'Sweden'),
(22, 'Madagascar'),
(23, 'Israel'),
(24, 'Macedonia'),
(25, 'Japan'),
(26, 'Estonia'),
(29, 'Lithuania'),
(32, 'Spain'),
(33, 'Portugal'),
(34, 'Guatemala'),
(35, 'Argentina'),
(36, 'Malaysia'),
(40, 'South Africa'),
(41, 'United States'),
(42, 'Kyrgyzstan'),
(43, 'Venezuela'),
(44, 'Papua New Guinea'),
(46, 'Vietnam'),
(47, 'Zimbabwe'),
(48, 'Mexico');

-- --------------------------------------------------------

--
-- Table structure for table `discuss`
--

CREATE TABLE `discuss` (
  `id` int NOT NULL,
  `id_users` int NOT NULL,
  `id_product` int NOT NULL,
  `discuss` text NOT NULL,
  `create_at` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `discuss`
--

INSERT INTO `discuss` (`id`, `id_users`, `id_product`, `discuss`, `create_at`) VALUES
(105, 15, 137, 'Grass-roots non-volatile interface', '2021-11-01'),
(107, 12, 116, 'Exclusive coherent complexity', '2021-12-05'),
(109, 17, 133, 'Adaptive asymmetric product', '2021-08-16'),
(111, 17, 61, 'Object-based clear-thinking firmware', '2021-11-03'),
(113, 30, 149, 'Ameliorated mission-critical workforce', '2020-05-06'),
(114, 10, 113, 'Proactive system-worthy database', '2021-03-13'),
(118, 2, 149, 'Up-sized multimedia neural-net', '2021-06-19'),
(119, 26, 125, 'Ergonomic exuding customer loyalty', '2020-03-11'),
(122, 29, 139, 'Sharable local architecture', '2021-07-25'),
(124, 13, 153, 'Triple-buffered real-time analyzer', '2021-06-05'),
(125, 4, 137, 'Exclusive 24 hour local area network', '2020-11-24'),
(127, 4, 110, 'Reduced client-server moratorium', '2021-01-04'),
(128, 3, 130, 'Digitized fresh-thinking approach', '2020-12-18'),
(130, 7, 62, 'Sharable asynchronous info-mediaries', '2021-03-07'),
(132, 24, 145, 'Open-architected object-oriented support', '2021-01-16'),
(134, 8, 141, 'Extended upward-trending paradigm', '2021-03-14'),
(137, 30, 61, 'Intuitive multi-tasking projection', '2021-10-17'),
(139, 12, 105, 'User-centric even-keeled migration', '2020-09-03'),
(141, 23, 123, 'Enhanced asynchronous implementation', '2020-05-07'),
(142, 4, 87, 'Balanced didactic matrices', '2021-09-05'),
(146, 26, 146, 'Self-enabling multimedia intranet', '2021-12-02'),
(147, 22, 129, 'Open-architected tertiary capability', '2021-12-09'),
(149, 5, 89, 'Enterprise-wide attitude-oriented parallelism', '2020-05-07'),
(152, 18, 144, 'Multi-channelled user-facing pricing structure', '2022-02-21'),
(154, 11, 74, 'Ameliorated value-added software', '2022-01-30'),
(155, 6, 141, 'Object-based encompassing utilisation', '2021-06-04'),
(160, 11, 143, 'Decentralized dynamic success', '2020-10-09'),
(161, 26, 131, 'Stand-alone encompassing circuit', '2020-08-20'),
(163, 16, 89, 'Polarised web-enabled success', '2021-10-23'),
(168, 6, 6, 'Reduced intangible help-desk', '2020-12-27'),
(169, 30, 113, 'Progressive multimedia info-mediaries', '2021-09-26'),
(170, 10, 2, 'Virtual 4th generation policy', '2021-08-10'),
(174, 26, 153, 'Implemented contextually-based algorithm', '2020-11-13'),
(177, 19, 18, 'Innovative non-volatile attitude', '2021-08-05'),
(180, 27, 151, 'Reactive even-keeled Graphical User Interface', '2020-05-01'),
(183, 22, 149, 'Synergistic didactic open system', '2020-09-12'),
(184, 13, 89, 'Phased systemic migration', '2020-05-21'),
(185, 8, 145, 'Reactive analyzing success', '2020-11-24'),
(186, 21, 72, 'Open-source high-level strategy', '2020-10-04'),
(189, 20, 124, 'Intuitive static attitude', '2020-04-01'),
(193, 24, 130, 'Business-focused even-keeled service-desk', '2021-10-26'),
(195, 11, 105, 'Organic leading edge frame', '2022-01-27'),
(199, 9, 56, 'Implemented cohesive help-desk', '2020-12-22');

-- --------------------------------------------------------

--
-- Table structure for table `manufacturer`
--

CREATE TABLE `manufacturer` (
  `id` int NOT NULL,
  `name` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `manufacturer`
--

INSERT INTO `manufacturer` (`id`, `name`) VALUES
(1, 'Tekfly'),
(2, 'Agivu'),
(3, 'Bluejam'),
(4, 'Tagfeed'),
(5, 'Cogibox'),
(6, 'Aibox'),
(7, 'Browsezoom'),
(8, 'Eayo'),
(9, 'Ooba'),
(10, 'Roodel'),
(11, 'Oozz'),
(12, 'Kaymbo'),
(13, 'Teklist'),
(14, 'Realblab'),
(15, 'Nlounge'),
(16, 'Quatz'),
(17, 'Photojam'),
(18, 'Roombo'),
(19, 'Photobug');

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `id` int NOT NULL,
  `id_users` int NOT NULL,
  `date` date DEFAULT NULL,
  `payment_method` enum('debit/credit','cod') NOT NULL,
  `status` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`id`, `id_users`, `date`, `payment_method`, `status`) VALUES
(1, 17, '2020-12-04', 'debit/credit', 'completed'),
(2, 29, '2020-07-05', 'debit/credit', 'cancelled'),
(3, 13, '2021-07-13', 'cod', 'paid'),
(4, 27, '2020-05-31', 'cod', 'completed'),
(5, 3, '2022-01-09', 'cod', 'pending'),
(6, 7, '2022-03-01', 'debit/credit', 'cancelled'),
(7, 25, '2021-05-24', 'cod', 'cancelled'),
(8, 24, '2020-09-18', 'debit/credit', 'pending'),
(9, 13, '2021-11-11', 'debit/credit', 'on delivery'),
(10, 19, '2020-04-23', 'debit/credit', 'pending'),
(11, 10, '2022-02-24', 'cod', 'confirmed'),
(12, 12, '2021-03-23', 'debit/credit', 'pending'),
(13, 2, '2020-07-28', 'debit/credit', 'cancelled'),
(14, 18, '2020-08-14', 'cod', 'pending'),
(15, 25, '2020-11-06', 'debit/credit', 'on delivery'),
(16, 17, '2021-07-16', 'cod', 'cancelled'),
(17, 3, '2021-12-11', 'cod', 'completed'),
(18, 8, '2021-07-16', 'cod', 'pending'),
(19, 27, '2020-09-23', 'debit/credit', 'pending'),
(20, 12, '2020-07-30', 'cod', 'completed'),
(21, 7, '2021-05-17', 'cod', 'cancelled'),
(22, 4, '2020-05-13', 'debit/credit', 'completed'),
(23, 24, '2020-04-21', 'cod', 'paid'),
(24, 10, '2021-06-25', 'debit/credit', 'on delivery'),
(25, 17, '2020-04-13', 'cod', 'paid'),
(26, 26, '2021-08-27', 'debit/credit', 'pending'),
(27, 22, '2021-03-04', 'debit/credit', 'cancelled'),
(28, 9, '2021-07-12', 'debit/credit', 'paid'),
(29, 14, '2021-04-21', 'cod', 'completed'),
(30, 17, '2020-03-08', 'debit/credit', 'pending'),
(31, 28, '2021-06-24', 'cod', 'completed'),
(32, 15, '2020-08-27', 'debit/credit', 'on delivery'),
(33, 15, '2020-07-11', 'debit/credit', 'on delivery'),
(34, 23, '2021-04-20', 'cod', 'completed'),
(35, 17, '2021-10-16', 'debit/credit', 'confirmed'),
(36, 16, '2021-11-05', 'cod', 'confirmed'),
(37, 8, '2020-03-26', 'cod', 'cancelled'),
(38, 21, '2020-03-31', 'debit/credit', 'paid'),
(39, 21, '2021-06-23', 'debit/credit', 'completed'),
(40, 15, '2021-10-01', 'debit/credit', 'pending'),
(41, 20, '2020-11-20', 'debit/credit', 'on delivery'),
(42, 15, '2021-02-01', 'debit/credit', 'cancelled'),
(43, 12, '2021-07-08', 'cod', 'on delivery'),
(44, 21, '2021-08-19', 'debit/credit', 'pending'),
(45, 12, '2021-04-26', 'cod', 'paid'),
(46, 25, '2020-10-29', 'cod', 'pending'),
(47, 30, '2020-03-15', 'debit/credit', 'on delivery'),
(48, 11, '2020-10-12', 'debit/credit', 'pending'),
(49, 5, '2020-04-13', 'debit/credit', 'cancelled'),
(50, 7, '2021-08-03', 'cod', 'paid');

-- --------------------------------------------------------

--
-- Table structure for table `orders_shipper`
--

CREATE TABLE `orders_shipper` (
  `id_orders` int NOT NULL,
  `id_shipper` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `orders_shipper`
--

INSERT INTO `orders_shipper` (`id_orders`, `id_shipper`) VALUES
(25, 1),
(41, 1),
(18, 2),
(20, 2),
(25, 2),
(26, 2),
(29, 2),
(30, 2),
(41, 2),
(48, 2),
(2, 3),
(4, 3),
(10, 3),
(40, 3),
(1, 4),
(9, 4),
(14, 4),
(39, 4),
(40, 4),
(49, 4),
(4, 5),
(13, 5),
(24, 5),
(27, 5),
(45, 5),
(7, 6),
(17, 6),
(5, 7),
(12, 7),
(28, 7),
(33, 7),
(42, 7),
(49, 7),
(9, 8),
(25, 8),
(27, 8),
(42, 8),
(46, 8),
(47, 8),
(4, 9),
(13, 9),
(15, 9),
(22, 9),
(36, 9),
(38, 9),
(14, 10),
(23, 10),
(34, 10),
(37, 10),
(41, 10);

-- --------------------------------------------------------

--
-- Table structure for table `orders_voucher`
--

CREATE TABLE `orders_voucher` (
  `id_orders` int NOT NULL,
  `id_voucher` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `orders_voucher`
--

INSERT INTO `orders_voucher` (`id_orders`, `id_voucher`) VALUES
(43, 2),
(40, 3),
(15, 4),
(18, 4),
(40, 4),
(21, 5),
(14, 6),
(15, 6),
(19, 8),
(25, 9),
(38, 9),
(49, 9),
(45, 10),
(31, 13),
(30, 14),
(35, 16),
(38, 19),
(3, 20),
(35, 20),
(1, 22),
(7, 22),
(45, 22),
(30, 23),
(27, 24),
(29, 24),
(30, 24),
(41, 24),
(36, 27),
(46, 27),
(12, 28);

-- --------------------------------------------------------

--
-- Table structure for table `price`
--

CREATE TABLE `price` (
  `id` int NOT NULL,
  `id_product` int DEFAULT NULL,
  `price` bigint NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `price`
--

INSERT INTO `price` (`id`, `id_product`, `price`, `start_date`, `end_date`) VALUES
(1, 12, 42342657, '2021-06-12', '2020-12-31'),
(2, 12, 21099243, '2019-09-30', '2021-10-29'),
(7, 2, 9321058, '2020-03-07', '2020-06-20'),
(35, 18, 11415889, '2020-01-16', '2020-03-21'),
(43, 6, 3150327, '2020-02-10', '2021-10-07'),
(44, 12, 3643544, '2019-07-01', '2021-02-19'),
(46, 2, 47148913, '2021-09-12', '2020-05-10'),
(51, 18, 15137462, '2019-12-03', '2021-04-10'),
(62, 18, 10232936, '2021-07-17', '2022-02-14'),
(75, 47, 47215433, '2020-03-08', '2021-05-01'),
(82, 2, 20864211, '2021-10-08', '2020-11-06'),
(84, 56, 3238702, '2019-08-23', '2020-05-20'),
(104, 141, 42203442, '2021-08-12', '2020-11-14'),
(105, 2, 6453492, '2019-06-23', '2021-12-29'),
(109, 151, 44103321, '2021-02-16', '2020-06-03'),
(114, 137, 4843633, '2020-02-25', '2021-03-11'),
(119, 123, 5342951, '2021-10-16', '2021-12-19'),
(122, 148, 46142694, '2020-07-30', '2021-08-03'),
(124, 113, 31532618, '2019-12-24', '2021-05-18'),
(125, 12, 38128828, '2020-02-08', '2020-05-31'),
(128, 9, 23602475, '2019-04-13', '2021-08-20'),
(129, 91, 16223360, '2021-12-20', '2020-11-25'),
(132, 107, 5134033, '2021-11-06', '2021-01-21'),
(133, 116, 45145180, '2019-11-01', '2020-05-18'),
(134, 128, 35846068, '2019-05-07', '2021-09-22'),
(135, 87, 6949849, '2021-08-07', '2020-07-29'),
(148, 150, 46279426, '2019-06-15', '2022-02-27'),
(149, 144, 16815593, '2021-03-01', '2020-12-13'),
(150, 2, 10396592, '2019-03-26', '2020-12-21'),
(152, 122, 43073946, '2019-11-07', '2021-10-11'),
(153, 145, 19298174, '2021-04-26', '2021-07-10'),
(154, 91, 41912929, '2020-07-06', '2021-10-08'),
(156, 151, 34920277, '2020-04-20', '2020-07-15'),
(157, 109, 15772323, '2019-12-25', '2022-01-03'),
(159, 89, 49106200, '2020-12-11', '2020-07-10'),
(165, 130, 29683095, '2021-12-13', '2022-01-08'),
(172, 113, 7181290, '2020-07-11', '2022-01-03'),
(184, 142, 19529010, '2019-12-28', '2020-07-24'),
(186, 119, 10396615, '2019-03-06', '2021-04-15'),
(188, 47, 15391358, '2019-11-06', '2021-01-06'),
(189, 149, 49715583, '2021-08-29', '2021-07-17'),
(190, 137, 42659882, '2020-10-20', '2020-08-11'),
(192, 139, 25869043, '2019-12-17', '2020-03-31'),
(193, 18, 12250199, '2019-06-26', '2020-10-15'),
(199, 89, 26278270, '2021-06-21', '2021-07-19'),
(200, 91, 41071686, '2021-07-02', '2021-07-08'),
(202, 72, 27269030, '2020-08-16', '2020-06-04');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` int NOT NULL,
  `name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `description` text NOT NULL,
  `quantity` bigint DEFAULT NULL,
  `sold_quantity` bigint NOT NULL,
  `id_shop` int NOT NULL,
  `id_category` int NOT NULL,
  `id_manufacturer` int NOT NULL,
  `id_country` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `name`, `description`, `quantity`, `sold_quantity`, `id_shop`, `id_category`, `id_manufacturer`, `id_country`) VALUES
(2, 'AILANTHUS GLANDULOSUS', 'BLBMdRwqQ6W5DsD9frjX8bFDoJMfccoNAnBLFUYRhLvgQaKnu4h', 2137, 7123, 1, 11, 7, 6),
(6, 'clindamycin phosphate', 'BLWFhe6hNuP9LCejW5noZBpJuvoHBKd5SacvukFcSaQXA2bW45E', 5235, 5288, 8, 16, 5, 6),
(9, 'pramipexole dihydrochloride', 'BM9bt7YV1tj1wR5Md7BAPwmymsPcEETPBFfTcaQXn6JhHnjBkV8', 6069, 8996, 4, 1, 11, 5),
(12, 'TRICLOSAN', 'BLPpisLqEKrJGyQWBSd4f3XdGXoctVLWcvtoA6CFLdCzUhSrfrL', 6594, 8466, 5, 5, 12, 13),
(18, 'Dextromethorphan Hydrobromide Guaifenesin', 'BL9jJTguc6YvqQNhJTkgAXt3tmdTFSgkk4bbdNoisHnR22fgkah', 4281, 4097, 5, 5, 8, 16),
(47, 'Acetaminophen and Codeine Phosphate', 'BL4pT4ZrmmDP7bGYcgfwEeweu8wJLYDzWWWeqY4Y5TYdwgdFthi', 6553, 8119, 3, 19, 2, 4),
(55, 'MELOXICAM', 'BLx8zqXJ44FZb8nHtVCbyvsMd3rCaykK1VwVi2Hgs6BUbNdSML9', 5147, 5412, 2, 18, 15, 9),
(56, 'Doxycycline Hyclate', 'BLwTE279LT45ri4aeGkZXxj72wyo1YUEn1opWqLs1kPbTyMSpsQ', 6036, 3383, 2, 7, 16, 4),
(61, 'Carelessweed', 'BKxQwHcXCyy3uhf9Y1AVuj6S7vQjP8jimCP8CcneMNBVcRQgQEp', 9404, 4261, 4, 15, 10, 18),
(62, 'ketorolac tromethamine', 'BKrynZMNVzTAFYmMgu7zWCivPLPwzvyNPPYTB9esBTcNuBnZvXN', 446, 6666, 4, 17, 12, 2),
(72, 'menthol', 'BLHU67ovtvc9jrnwfK1YypFZtj6RWJMYLTE9CdjkwpUSFhJ3vf1', 5380, 3191, 2, 12, 15, 2),
(74, 'Simethicone', 'BMRt9vJRqmGEyDPmfTGzHHwwqe3f62iFPCyztjfP7EsGwVwxUBZ', 2127, 2021, 3, 5, 19, 7),
(76, 'pneumococcal vaccine polyvalent', 'BMEMEmXitBVWVQ9Tw7qrY3eJuPbxuz6WyKutBdhsEsbs8B7vjY4', 6432, 922, 9, 7, 8, 17),
(87, 'TRICLOSAN', 'BLoPRTijofuh7mZSrBo12AB9bWCvFJwoDiaVK7BeqcUtR58JT9Q', 7068, 2791, 7, 4, 12, 13),
(89, 'Methyl Salicylate', 'BMGHGcf9K3vwcFVeNJMeDHgymz1gQaduXPLC4q8ecrHqTQoy84a', 8341, 5867, 5, 3, 10, 9),
(91, 'Acetaminophen, Diphenhydramine Hydrochloride, Phenylephrine Hydrochloride', 'BKsYdiHzwsRAqKHknv3EkPXXg4aYh8hg4ZBumkQ5mG1iHK9vSwr', 450, 5109, 9, 3, 15, 3),
(103, 'Aluminum Zirconium Tetrachlorohydrex GLY', 'BMWeeJYvo5VNvk6hybHRmmv6dYCUrpScFnMWq8Faj55sFzvWwAm', 6557, 1869, 6, 11, 13, 35),
(104, 'Verapamil hydrochloride', 'BLx88D5sFsUVy5QM5HCY9amWsEueBw2DG6Grp53LWgzFZrXNgEy', 9519, 390, 7, 19, 3, 8),
(105, 'Piroxicam', 'BM4EDyjFYYrYZrVo2L7ND3awy2WLSb93a5CXCve3wn4ozcdtkjw', 8348, 1433, 9, 9, 8, 1),
(106, 'Titanium Dioxide, Zince Oxide', 'BLf361h6SVZJd3X61S3bEUrNoTXd2VzgMaPQpkpdBWC64ZYfR2E', 8787, 319, 8, 7, 6, 4),
(107, 'Ibuprofen', 'BKs4BCzywoDAeCv71R9qz76wxXfRskh8mBjzuvHXc3DqnM4d4v4', 1138, 1617, 8, 1, 1, 32),
(108, 'Zinc oxide', 'BLQ8PBueAQ1tNppWw8k2fPsEqxrMxjDQWAfbYSVKUHLq4pnJdbp', 3393, 1528, 3, 15, 2, 29),
(109, 'Amitriptyline Hydrochloride', 'BKshH55mr1PVnoz8QcT4NqEwCrjo1c2yyfDHXh5y2kSantUF8Av', 5118, 8236, 6, 13, 6, 4),
(110, 'clomiPHENE citrate', 'BMTTFAHwt5nmuKD5ruDLegWBWyeFJNFQU6YQxEMkPuxnzK9B6Sa', 8972, 320, 7, 14, 14, 7),
(112, 'Aluminum Chlorohydrate', 'BLcqhf8KvzpmFadZuF6g97MErcxLrPcQK1kbVTJBJUD8e5wmP3Z', 6746, 796, 5, 19, 9, 13),
(113, 'Acetaminophen, Caffeine and Pyrilamine maleate', 'BMDS5T9Z5k6oxa1G9hTip8142Rct5U7UxjyC8KDYVH4UYD5Fkqb', 7216, 1737, 4, 10, 18, 2),
(114, 'bupropion hydrochloride', 'BLzM93Y1zhrRnbrTw4JzpKyf7PSGnKoEMyVWGYxxAP5YtKE4sL7', 362, 8643, 9, 9, 11, 36),
(116, 'Estradiol', 'BLXGGH9qc7sJArJDFj61NLDfDb2U2wH6mi6TmKvVo5HAjJ55AZe', 9878, 6580, 5, 3, 11, 22),
(117, 'Lidocaine Hydrochloride and Epinephrine Bitartrate', 'BL8GGn6GEXMQhik8DXSqTUhEbJHP7VU3xu8S7oS3XMGVpJDEzRe', 8980, 4786, 2, 9, 8, 8),
(118, 'Pigweed Mixture', 'BL9KPSNypgHkhQnBcBBGGotrDq8rzTnK7nTEyL7hfgsca9QDbDR', 43, 5584, 7, 6, 7, 6),
(119, 'Technetium Tc-99m Generator', 'BLsNrn3dVtWwdF117fAPYfmVQtgb9oTEGVQLhj4WhRR5L7h4rvA', 5207, 5485, 2, 3, 11, 24),
(120, 'Kali phos, Mag phos, Nat sulphuricum', 'BLea7Qb6389gRqeQ1K8MjLmMrDDYZicac4xLMre6TDtaNUeHoVY', 9111, 2156, 5, 10, 5, 17),
(122, 'Avobenzone, Octinoxate, Octisalate, Octocrylene', 'BLJs9nVMV3iBcJSWH5x72B92j5HwYFaymqFYfaUodEwf5Bausm7', 655, 2957, 4, 20, 13, 34),
(123, 'ARNICA MONTANA ROOT and ATROPA BELLADONNA and CALENDULA OFFICINALIS FLOWERING TOP and MATRICARIA RECUTITA and ACHILLEA MILLEFOLIUM and CALCIUM SULFIDE and COMFREY ROOT and ACONITUM NAPELLUS and BELLIS', 'BMJvpw1d4PRaekRFdqaoJiNwuHjGBdCK2vEyWuLTHWSQmp3m5nz', 1365, 2770, 8, 14, 3, 13),
(124, 'MORPHINE SULFATE', 'BMX9a5VFN3wfQ8RC9JuBbJcvgbd2HCB6Cx6aVvVkocZshvtmDV9', 3769, 9075, 9, 14, 1, 17),
(125, 'DIPHENHYDRAMINE HYDROCHLORIDE', 'BLELJ1oZvqZXy2nYwafJwFYGuC5rbhH6Ad8tx3wtbdz4n59oeAi', 1729, 3556, 8, 8, 3, 29),
(126, 'SALICYLIC ACID', 'BLsCnGQN7DZS7VrbSJ6LsrHs4qKrv8YTu664UhiTemMhtTYQKpD', 3892, 4910, 7, 16, 18, 35),
(128, 'Diphenhydramine HCl', 'BLszK9DxH2bFHjWy9h4fXzf3o1CrfoKFfyZNvubZQFFf8SHWgoG', 5851, 2589, 2, 20, 15, 26),
(129, 'AVOBENZONE, OCTISALATE, OCTOCRYLENE', 'BLv8YySu4cqaarM64ZPBoQVJNwPZCQjpgpceiMsTPAs8642DyuK', 6962, 4709, 1, 15, 14, 1),
(130, 'Aluminum Hydroxide, Magnesium Hydroxide, Dimethicone', 'BMaxhB5vjusYTsXvVFk6bLXGcKHtBQxMgpFbg1McoQuFfYQbhWR', 5236, 1966, 4, 11, 14, 5),
(131, 'Lidocaine', 'BMM3sc1BL2Wjo2zWLP2L4vFGnx2qpGJMWhkRj4ArfkgQrcQUW2R', 7336, 2130, 6, 1, 11, 34),
(133, 'Bupropion Hydrochloride', 'BKozDPrQHfhExTF7xqPfVb419PTrx6N4bxLNrTf2TtDGjtnUa37', 4220, 922, 5, 6, 12, 6),
(134, 'AIR COMPRESSED', 'BLH1814ivXR7RfNqXS7xB7GwMSVuQD7Bobv1EHdiNw4yNVXGa4G', 6041, 796, 3, 10, 9, 20),
(135, 'norethindrone and ethinyl estradiol', 'BM3Wr7JbsCPNRGdzzggFHvEw968dAd5JteGgiUaogB1AxkDBoyn', 5179, 4655, 9, 9, 12, 8),
(136, 'Glimepiride', 'BM3G5mwPNbRa2RfB69v96veqJRrAkBThTdgN4uuQsEY5mu3vKcy', 7269, 3349, 1, 8, 5, 23),
(137, 'Acetaminophen, Dextromethorphan Hydrobromide, Phenylephrine Hydrochloride', 'BL9E9CNpRMs8vLJeU82hmJn9cxJDRe7Z1zv3KU8JrESpU6VDTZo', 2091, 3893, 6, 6, 7, 10),
(138, 'clobazam', 'BMRPJbiqiD9x3DWS1XyCh24p4swHKEQjdMkqkkDAdS65bqj4DQJ', 1247, 7467, 6, 12, 10, 8),
(139, 'Tacrolimus', 'BLABzCunVJXc121QfJvL8DinQwpZV4pQzn4eusi136djsBA2oWT', 8566, 4969, 5, 9, 4, 4),
(141, 'ERYTHROMYCIN', 'BLW88gT9gZEDs3afNDb7Yz2GCXFENuZs5zrZLWAnYdHyPpZjvei', 8595, 422, 7, 17, 15, 7),
(142, 'TITANIUM DIOXIDE, ZINC OXIDE', 'BLKMPqmmUa2ucjYpNudSg7zv7Eyx31suKd4ZKNjsSfbYs9NEba4', 4460, 1149, 3, 17, 10, 22),
(143, 'Phenylephrine Hydrochloride', 'BLqENrD6Y2CnVUucKXdzjjpXSahJ3wDLwwn1BjjTBmQ8xQmsPJj', 9267, 4104, 7, 19, 2, 4),
(144, 'Famotidine', 'BL731Qf1yrnKnZSmPiimGgTnvsspjxqvejo9LM6dhXiWmbpJZdA', 9418, 7657, 5, 5, 15, 21),
(145, 'DIMETHICONE', 'BMMnefn2bhPj5raYzFaxUjEj2VSLPVaMJr7Tg3tvFbSLQUBxzsg', 4211, 6997, 9, 12, 16, 33),
(146, 'carboxymethylcellulose sodium', 'BL2RgEsrriEhZK5nyGaJ3KucR8Maezxq3W7JdqtvvCi4r35XS2S', 1836, 4969, 7, 5, 19, 24),
(148, 'Octinoxate, Octisalate, Avobenzone', 'BMb4sTZrFNe4JopDh5wWEFPNe823BG9ibBNbdVk2aUQ14s9CbeP', 8505, 8749, 8, 16, 3, 8),
(149, 'FLUOROURACIL', 'BLoYwkoB5nqskL1Bfrs5PXXGH3gHh27uBgRoWkt6gRYkTAMEVhG', 3885, 1999, 3, 12, 7, 18),
(150, 'Fluoxetine', 'BLCSQhvCyQw66VJkeLpNasRLzTQ4KkdG5GbYsJTsk98BtP6Kp8R', 2008, 892, 4, 15, 1, 34),
(151, 'CEFEPIME HYDROCHLORIDE', 'BLkwC9fyrC1dYnSVoCUgjMMHihNAAzp24g2ZYcyf6SiL2EfzRV8', 5568, 2385, 3, 1, 10, 3),
(153, 'Titanium Dioxide and Zinc Oxide', 'BL2k9LLgoFy2exSzdxPhfUoceyiYYYy2WJH9R8nz2nXxNcKadZ5', 2871, 7822, 8, 15, 10, 23);

-- --------------------------------------------------------

--
-- Table structure for table `product_orders`
--

CREATE TABLE `product_orders` (
  `id_product` int NOT NULL,
  `id_orders` int NOT NULL,
  `quantity` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `product_orders`
--

INSERT INTO `product_orders` (`id_product`, `id_orders`, `quantity`) VALUES
(6, 45, 1),
(18, 30, 3),
(47, 3, 13),
(61, 42, 17),
(72, 47, 12),
(74, 48, 5),
(76, 14, 19),
(76, 25, 2),
(106, 3, 11),
(106, 46, 20),
(109, 17, 13),
(110, 11, 18),
(116, 11, 11),
(116, 25, 4),
(117, 34, 18),
(118, 45, 17),
(119, 42, 15),
(119, 44, 8),
(123, 47, 2),
(124, 50, 14),
(126, 4, 15),
(128, 40, 17),
(133, 5, 17),
(133, 39, 13),
(134, 12, 18),
(134, 46, 3),
(135, 24, 1),
(136, 38, 11),
(139, 1, 3),
(141, 29, 4),
(142, 23, 18),
(144, 11, 15),
(146, 29, 5),
(146, 49, 18),
(148, 31, 6),
(148, 39, 9);

-- --------------------------------------------------------

--
-- Table structure for table `product_tag`
--

CREATE TABLE `product_tag` (
  `id_product` int NOT NULL,
  `id_tag` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `product_tag`
--

INSERT INTO `product_tag` (`id_product`, `id_tag`) VALUES
(61, 1),
(136, 1),
(153, 1),
(74, 2),
(108, 2),
(89, 3),
(116, 3),
(122, 3),
(47, 4),
(151, 4),
(47, 5),
(61, 6),
(89, 6),
(105, 6),
(145, 6),
(103, 7),
(104, 7),
(108, 7),
(141, 7),
(151, 7),
(153, 7),
(61, 8),
(123, 8),
(136, 8),
(138, 8),
(2, 9),
(103, 9),
(139, 9),
(153, 9),
(6, 10),
(62, 10),
(119, 10),
(128, 10),
(134, 10),
(136, 10),
(122, 11),
(135, 11),
(139, 11),
(143, 11),
(144, 11),
(2, 12),
(47, 12),
(61, 12),
(114, 12),
(126, 12),
(76, 13),
(105, 13),
(145, 13),
(151, 13),
(9, 14),
(56, 14),
(89, 14),
(105, 14),
(112, 14),
(113, 14),
(114, 14),
(136, 14),
(142, 14),
(56, 15),
(61, 15),
(91, 15),
(106, 15),
(122, 15),
(126, 15),
(137, 15),
(151, 16),
(2, 17),
(12, 17),
(56, 17),
(120, 17),
(123, 17),
(9, 18),
(72, 18),
(89, 18),
(47, 19),
(62, 19),
(126, 19),
(139, 19),
(61, 20),
(110, 20),
(112, 20),
(142, 20);

-- --------------------------------------------------------

--
-- Table structure for table `rating`
--

CREATE TABLE `rating` (
  `id` int NOT NULL,
  `id_users` int NOT NULL,
  `id_product` int NOT NULL,
  `rating` int NOT NULL,
  `create_at` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `rating`
--

INSERT INTO `rating` (`id`, `id_users`, `id_product`, `rating`, `create_at`) VALUES
(5, 4, 72, 5, '2021-09-19'),
(12, 23, 137, 5, '2020-09-17'),
(14, 1, 131, 5, '2020-03-14'),
(17, 20, 125, 1, '2020-03-17'),
(22, 14, 150, 1, '2022-02-27'),
(25, 13, 124, 4, '2020-09-15'),
(26, 28, 105, 5, '2021-01-10'),
(29, 2, 144, 3, '2021-04-30'),
(32, 3, 135, 2, '2021-01-22'),
(34, 20, 145, 5, '2020-07-11'),
(37, 17, 47, 2, '2020-03-31'),
(40, 26, 142, 3, '2022-01-25'),
(41, 28, 76, 1, '2022-01-31'),
(48, 17, 89, 4, '2020-09-29'),
(49, 14, 113, 2, '2020-08-03'),
(51, 4, 110, 3, '2020-04-11');

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id` int NOT NULL,
  `role` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `role`) VALUES
(1, 1),
(2, 2),
(3, 3);

-- --------------------------------------------------------

--
-- Table structure for table `shipper`
--

CREATE TABLE `shipper` (
  `id` int NOT NULL,
  `name` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `shipper`
--

INSERT INTO `shipper` (`id`, `name`) VALUES
(1, 'Lubowitz, Beatty and Roberts'),
(2, 'McClure Group'),
(3, 'Cole LLC'),
(4, 'Davis Group'),
(5, 'Collins, Bailey and Schamberger'),
(6, 'Senger, Langosh and Stiedemann'),
(7, 'Jaskolski-Morar'),
(8, 'Witting Inc'),
(9, 'Haley-Heathcote'),
(10, 'Morar Inc');

-- --------------------------------------------------------

--
-- Table structure for table `shop`
--

CREATE TABLE `shop` (
  `id` int NOT NULL,
  `id_owner` int NOT NULL,
  `name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `create_at` date DEFAULT NULL,
  `status` enum('normal','locked') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `address` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `shop`
--

INSERT INTO `shop` (`id`, `id_owner`, `name`, `create_at`, `status`, `address`) VALUES
(1, 20, 'Satterfield, Friesen and Kuhlman', '2020-03-13', 'normal', '0 Melody Lane'),
(2, 8, 'Morar and Sons', '2021-02-21', 'locked', '6816 Rowland Plaza'),
(3, 23, 'Reinger-Simonis', '2020-12-26', 'normal', '1698 Autumn Leaf Center'),
(4, 10, 'Prosacco, Schuppe and Powlowski', '2020-09-01', 'locked', '2826 Fuller Avenue'),
(5, 12, 'Aufderhar, Toy and Herman', '2021-01-13', 'normal', '608 Barnett Park'),
(6, 2, 'Jacobi, Kuhn and Gerhold', '2020-06-17', 'locked', '68554 Mosinee Trail'),
(7, 14, 'Von LLC', '2021-11-18', 'normal', '58236 Texas Center'),
(8, 13, 'Spencer Group', '2020-03-26', 'locked', '27 Vernon Plaza'),
(9, 27, 'Fisher Group', '2021-07-07', 'normal', '0 Packers Way');

-- --------------------------------------------------------

--
-- Table structure for table `tag`
--

CREATE TABLE `tag` (
  `id` int NOT NULL,
  `name` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `tag`
--

INSERT INTO `tag` (`id`, `name`) VALUES
(1, 'architecture'),
(2, 'paradigm'),
(3, 'well-modulated'),
(4, 'human-resource'),
(5, '3rd generation'),
(6, 'product'),
(7, 'full-range'),
(8, 'Multi-lateral'),
(9, 'Total'),
(10, 'Adaptive'),
(11, 'capacity'),
(12, 'multi-state'),
(13, 'Universal'),
(14, 'bottom-line'),
(15, 'Streamlined'),
(16, 'Up-sized'),
(17, 'actuating'),
(18, 'Down-sized'),
(19, 'Phased'),
(20, 'cohesive');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int NOT NULL,
  `username` text NOT NULL,
  `email` text,
  `mobile` text,
  `password` text NOT NULL,
  `full_name` text NOT NULL,
  `gender` enum('male','female') DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `create_at` date DEFAULT NULL,
  `status` enum('normal','locked') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `email`, `mobile`, `password`, `full_name`, `gender`, `dob`, `create_at`, `status`) VALUES
(1, 'adurtnal0', 'adurtnal0@google.com.br', '254-636-7296', 'U0C30n8', 'Alvy Durtnal', 'female', '1980-02-09', '2020-07-20', 'normal'),
(2, 'acolson1', 'acolson1@wix.com', '462-202-6167', 'ZXkNL2ssd', 'Alane Colson', 'female', '1972-06-23', '2021-10-24', 'normal'),
(3, 'rtuley2', 'rtuley2@mozilla.com', '935-797-7429', 'FBUXnI5Hlsg7', 'Reinald Tuley', 'male', '1951-05-10', '2021-12-30', 'normal'),
(4, 'rbonnick3', 'rbonnick3@japanpost.jp', '771-286-6277', 'C7NI9J885', 'Rodi Bonnick', 'male', '1995-12-17', '2021-04-27', 'normal'),
(5, 'sjorcke4', 'sjorcke4@paypal.com', '108-737-1928', 'WGrf7dVSk', 'Sharity Jorcke', 'female', '2001-12-19', '2020-06-23', 'normal'),
(6, 'stomkys5', 'stomkys5@economist.com', '401-792-5084', 'Th6veHpLno6Y', 'Stevana Tomkys', 'male', '1975-04-03', '2021-02-26', 'locked'),
(7, 'tcogin6', 'tcogin6@free.fr', '588-356-3676', '79HASLs', 'Tressa Cogin', 'female', '2003-12-05', '2022-01-19', 'normal'),
(8, 'plearmouth7', 'plearmouth7@dyndns.org', '559-528-6025', 'i17WAo', 'Peyter Learmouth', 'male', '1967-08-02', '2020-10-26', 'locked'),
(9, 'agodfree8', 'agodfree8@samsung.com', '780-113-2795', 'u3RaEJJa1msZ', 'Andie Godfree', 'male', '2000-11-27', '2021-02-05', 'locked'),
(10, 'sclayworth9', 'sclayworth9@ycombinator.com', '337-572-1693', '1BBYIwbF3aQA', 'Sebastian Clayworth', 'female', '1974-05-01', '2021-12-11', 'normal'),
(11, 'ldenslowa', 'ldenslowa@usa.gov', '130-577-2665', 'uBxADXgD', 'Lazare Denslow', 'male', '1964-02-22', '2020-06-15', 'normal'),
(12, 'xlatheyb', 'xlatheyb@myspace.com', '567-416-4025', 'REnMmIxuI', 'Xylia Lathey', 'female', '1979-10-23', '2020-10-17', 'normal'),
(13, 'stapporc', 'stapporc@ezinearticles.com', '583-822-2990', 'BV1jnip4oO', 'Shurlocke Tappor', 'female', '1974-09-05', '2021-02-27', 'normal'),
(14, 'elaughnand', 'elaughnand@amazon.de', '585-755-8605', 'td8Xe1', 'Emili Laughnan', 'male', '1985-03-12', '2020-06-23', 'normal'),
(15, 'bpindere', 'bpindere@csmonitor.com', '544-441-8144', '4trw1nnkI', 'Barrie Pinder', 'female', '1973-11-17', '2020-05-27', 'locked'),
(16, 'fmouncherf', 'fmouncherf@sitemeter.com', '733-664-7922', '9pezvsRe7sr', 'Fidelia Mouncher', 'male', '1960-03-18', '2020-11-14', 'locked'),
(17, 'wbernardotteg', 'wbernardotteg@nhs.uk', '479-102-7764', 'TMywpM1Ay', 'Waverley Bernardotte', 'female', '1959-10-08', '2021-02-10', 'normal'),
(18, 'ddunkh', 'ddunkh@amazon.de', '613-159-3061', 'LlbywuWw', 'Dalston Dunk', 'male', '2003-02-16', '2021-10-30', 'normal'),
(19, 'udelacourti', 'udelacourti@marketwatch.com', '120-956-5786', 'waIysU1hfTJ', 'Ula Delacourt', 'female', '1952-11-20', '2021-07-27', 'locked'),
(20, 'smarquesj', 'smarquesj@phoca.cz', '894-441-9578', '7pl83wJk', 'Sterne Marques', 'male', '1969-12-02', '2020-12-02', 'locked'),
(21, 'nweetchk', 'nweetchk@ycombinator.com', '958-799-0928', 'hUr9JdIG', 'Noellyn Weetch', 'female', '1969-09-18', '2020-10-03', 'locked'),
(22, 'rjaraml', 'rjaraml@amazon.com', '539-816-9455', 'J1yW5r', 'Roger Jaram', 'male', '1963-01-23', '2021-11-03', 'normal'),
(23, 'lfaircliffem', 'lfaircliffem@wired.com', '269-432-3496', 'oLKRck3tU', 'Lorne Faircliffe', 'female', '1955-12-17', '2021-07-15', 'locked'),
(24, 'rmytonn', 'rmytonn@domainmarket.com', '626-716-1006', '7f653xwrgq', 'Rosemonde Myton', 'male', '1981-09-09', '2020-04-16', 'locked'),
(25, 'jclevelando', 'jclevelando@upenn.edu', '374-889-5209', 'cTzlk2wDKyOM', 'Jere Cleveland', 'male', '1952-09-10', '2020-11-22', 'normal'),
(26, 'dhickfordp', 'dhickfordp@yale.edu', '844-471-4691', 'Qb783Gv', 'Den Hickford', 'female', '1976-09-01', '2020-03-06', 'locked'),
(27, 'mboathq', 'mboathq@themeforest.net', '556-256-7286', 'VQfHHnDtTyf0', 'Morissa Boath', 'female', '1977-10-21', '2020-07-12', 'normal'),
(28, 'srahlr', 'srahlr@webeden.co.uk', '286-561-3743', '6FcgwBlXZ', 'Silvia Rahl', 'female', '1974-06-06', '2022-03-04', 'normal'),
(29, 'ndyoss', 'ndyoss@youtu.be', '367-494-1167', 'ty4YqEuA', 'Nessa Dyos', 'male', '1972-06-30', '2020-11-04', 'normal'),
(30, 'pdreighert', 'pdreighert@chronoengine.com', '936-745-0951', 'iSYwKLN0', 'Paulina Dreigher', 'female', '1964-08-04', '2020-09-21', 'normal');

-- --------------------------------------------------------

--
-- Table structure for table `users_role`
--

CREATE TABLE `users_role` (
  `id_users` int NOT NULL,
  `id_role` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `users_role`
--

INSERT INTO `users_role` (`id_users`, `id_role`) VALUES
(1, 1),
(1, 2),
(2, 2),
(3, 2),
(4, 2),
(5, 2),
(6, 2),
(7, 2),
(8, 2),
(9, 2),
(10, 2),
(11, 2),
(12, 2),
(13, 2),
(14, 2),
(15, 2),
(16, 2),
(17, 2),
(18, 2),
(19, 2),
(20, 2),
(21, 2),
(22, 2),
(23, 2),
(24, 2),
(25, 2),
(26, 2),
(27, 2),
(28, 2),
(29, 2),
(30, 2),
(2, 3),
(8, 3),
(10, 3),
(12, 3),
(13, 3),
(14, 3),
(20, 3),
(23, 3),
(27, 3);

-- --------------------------------------------------------

--
-- Table structure for table `voucher`
--

CREATE TABLE `voucher` (
  `id` int NOT NULL,
  `percent` int NOT NULL,
  `min_price` bigint DEFAULT NULL,
  `start_date` date NOT NULL,
  `end_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `voucher`
--

INSERT INTO `voucher` (`id`, `percent`, `min_price`, `start_date`, `end_date`) VALUES
(1, 4, 69024, '2020-03-16', '2021-12-14'),
(2, 79, 35917, '2022-02-12', '2021-02-08'),
(3, 94, 91303, '2020-09-20', '2021-03-07'),
(4, 38, 118315, '2020-12-19', '2021-09-02'),
(5, 39, 396168, '2020-04-08', '2020-11-16'),
(6, 23, 113570, '2022-02-11', '2020-08-08'),
(7, 61, 443723, '2021-11-01', '2021-08-05'),
(8, 64, 301215, '2022-02-01', '2021-12-14'),
(9, 52, 151808, '2020-11-20', '2020-11-09'),
(10, 73, 74334, '2020-03-21', '2021-05-17'),
(11, 58, 350748, '2021-01-15', '2021-09-18'),
(12, 79, 118768, '2022-01-11', '2020-11-11'),
(13, 51, 455900, '2020-03-22', '2021-11-10'),
(14, 50, 172969, '2021-08-03', '2020-07-30'),
(15, 25, 353417, '2021-01-02', '2021-03-12'),
(16, 13, 31497, '2020-11-04', '2021-12-04'),
(17, 80, 185889, '2021-04-22', '2021-05-23'),
(18, 7, 424161, '2020-05-28', '2021-09-25'),
(19, 94, 264550, '2020-09-05', '2022-02-22'),
(20, 90, 256314, '2021-02-03', '2020-10-17'),
(21, 6, 470181, '2020-03-12', '2020-06-03'),
(22, 50, 494306, '2021-03-13', '2021-10-26'),
(23, 81, 330316, '2020-12-17', '2021-12-11'),
(24, 90, 497237, '2020-04-13', '2021-03-25'),
(25, 62, 173477, '2021-09-01', '2020-10-09'),
(26, 31, 363674, '2021-09-08', '2021-03-03'),
(27, 48, 219510, '2021-03-02', '2021-11-19'),
(28, 90, 327443, '2021-09-26', '2021-09-22'),
(29, 42, 115104, '2020-05-12', '2021-03-30'),
(30, 26, 413692, '2020-10-17', '2021-04-06');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_users` (`id_users`);

--
-- Indexes for table `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_users` (`id_users`);

--
-- Indexes for table `cart_product`
--
ALTER TABLE `cart_product`
  ADD PRIMARY KEY (`id_cart`,`id_product`),
  ADD KEY `id_product` (`id_product`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `country`
--
ALTER TABLE `country`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `discuss`
--
ALTER TABLE `discuss`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_users` (`id_users`),
  ADD KEY `id_product` (`id_product`);

--
-- Indexes for table `manufacturer`
--
ALTER TABLE `manufacturer`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_users` (`id_users`);

--
-- Indexes for table `orders_shipper`
--
ALTER TABLE `orders_shipper`
  ADD PRIMARY KEY (`id_orders`,`id_shipper`),
  ADD KEY `id_shipper` (`id_shipper`);

--
-- Indexes for table `orders_voucher`
--
ALTER TABLE `orders_voucher`
  ADD PRIMARY KEY (`id_orders`,`id_voucher`),
  ADD KEY `id_voucher` (`id_voucher`);

--
-- Indexes for table `price`
--
ALTER TABLE `price`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_product` (`id_product`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_shop` (`id_shop`),
  ADD KEY `id_category` (`id_category`),
  ADD KEY `id_manufacturer` (`id_manufacturer`),
  ADD KEY `id_country` (`id_country`);

--
-- Indexes for table `product_orders`
--
ALTER TABLE `product_orders`
  ADD PRIMARY KEY (`id_product`,`id_orders`),
  ADD KEY `id_orders` (`id_orders`);

--
-- Indexes for table `product_tag`
--
ALTER TABLE `product_tag`
  ADD PRIMARY KEY (`id_product`,`id_tag`),
  ADD KEY `id_tag` (`id_tag`);

--
-- Indexes for table `rating`
--
ALTER TABLE `rating`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_users` (`id_users`),
  ADD KEY `id_product` (`id_product`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `shipper`
--
ALTER TABLE `shipper`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `shop`
--
ALTER TABLE `shop`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_owner` (`id_owner`);

--
-- Indexes for table `tag`
--
ALTER TABLE `tag`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users_role`
--
ALTER TABLE `users_role`
  ADD PRIMARY KEY (`id_users`,`id_role`),
  ADD KEY `id_role` (`id_role`);

--
-- Indexes for table `voucher`
--
ALTER TABLE `voucher`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `address`
--
ALTER TABLE `address`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;

--
-- AUTO_INCREMENT for table `cart`
--
ALTER TABLE `cart`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `country`
--
ALTER TABLE `country`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

--
-- AUTO_INCREMENT for table `discuss`
--
ALTER TABLE `discuss`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=205;

--
-- AUTO_INCREMENT for table `manufacturer`
--
ALTER TABLE `manufacturer`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;

--
-- AUTO_INCREMENT for table `price`
--
ALTER TABLE `price`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=205;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=154;

--
-- AUTO_INCREMENT for table `rating`
--
ALTER TABLE `rating`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=52;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `shipper`
--
ALTER TABLE `shipper`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `shop`
--
ALTER TABLE `shop`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `tag`
--
ALTER TABLE `tag`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT for table `voucher`
--
ALTER TABLE `voucher`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `address`
--
ALTER TABLE `address`
  ADD CONSTRAINT `address_ibfk_1` FOREIGN KEY (`id_users`) REFERENCES `users` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `cart`
--
ALTER TABLE `cart`
  ADD CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`id_users`) REFERENCES `users` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `cart_product`
--
ALTER TABLE `cart_product`
  ADD CONSTRAINT `cart_product_ibfk_1` FOREIGN KEY (`id_cart`) REFERENCES `cart` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `cart_product_ibfk_2` FOREIGN KEY (`id_product`) REFERENCES `product` (`id`);

--
-- Constraints for table `discuss`
--
ALTER TABLE `discuss`
  ADD CONSTRAINT `discuss_ibfk_1` FOREIGN KEY (`id_users`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `discuss_ibfk_2` FOREIGN KEY (`id_product`) REFERENCES `product` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`id_users`) REFERENCES `users` (`id`);

--
-- Constraints for table `orders_shipper`
--
ALTER TABLE `orders_shipper`
  ADD CONSTRAINT `orders_shipper_ibfk_1` FOREIGN KEY (`id_orders`) REFERENCES `orders` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `orders_shipper_ibfk_2` FOREIGN KEY (`id_shipper`) REFERENCES `shipper` (`id`);

--
-- Constraints for table `orders_voucher`
--
ALTER TABLE `orders_voucher`
  ADD CONSTRAINT `orders_voucher_ibfk_1` FOREIGN KEY (`id_orders`) REFERENCES `orders` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `orders_voucher_ibfk_2` FOREIGN KEY (`id_voucher`) REFERENCES `voucher` (`id`);

--
-- Constraints for table `price`
--
ALTER TABLE `price`
  ADD CONSTRAINT `price_ibfk_1` FOREIGN KEY (`id_product`) REFERENCES `product` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `product_ibfk_1` FOREIGN KEY (`id_shop`) REFERENCES `shop` (`id`),
  ADD CONSTRAINT `product_ibfk_2` FOREIGN KEY (`id_category`) REFERENCES `category` (`id`),
  ADD CONSTRAINT `product_ibfk_3` FOREIGN KEY (`id_manufacturer`) REFERENCES `manufacturer` (`id`),
  ADD CONSTRAINT `product_ibfk_4` FOREIGN KEY (`id_country`) REFERENCES `country` (`id`);

--
-- Constraints for table `product_orders`
--
ALTER TABLE `product_orders`
  ADD CONSTRAINT `product_orders_ibfk_1` FOREIGN KEY (`id_product`) REFERENCES `product` (`id`),
  ADD CONSTRAINT `product_orders_ibfk_2` FOREIGN KEY (`id_orders`) REFERENCES `orders` (`id`);

--
-- Constraints for table `product_tag`
--
ALTER TABLE `product_tag`
  ADD CONSTRAINT `product_tag_ibfk_1` FOREIGN KEY (`id_product`) REFERENCES `product` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `product_tag_ibfk_2` FOREIGN KEY (`id_tag`) REFERENCES `tag` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `rating`
--
ALTER TABLE `rating`
  ADD CONSTRAINT `rating_ibfk_1` FOREIGN KEY (`id_users`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `rating_ibfk_2` FOREIGN KEY (`id_product`) REFERENCES `product` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `shop`
--
ALTER TABLE `shop`
  ADD CONSTRAINT `shop_ibfk_1` FOREIGN KEY (`id_owner`) REFERENCES `users` (`id`);

--
-- Constraints for table `users_role`
--
ALTER TABLE `users_role`
  ADD CONSTRAINT `users_role_ibfk_1` FOREIGN KEY (`id_users`) REFERENCES `users` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `users_role_ibfk_2` FOREIGN KEY (`id_role`) REFERENCES `role` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
