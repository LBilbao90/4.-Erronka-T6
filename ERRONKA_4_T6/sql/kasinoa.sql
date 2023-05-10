-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-05-2023 a las 19:51:10
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `kasinoa`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `apostua`
--

CREATE TABLE `apostua` (
  `id_apostu` int(11) NOT NULL,
  `NAN` varchar(9) DEFAULT NULL,
  `id_joko` int(11) DEFAULT NULL,
  `apostu_kantitatea` int(11) NOT NULL,
  `apostu_emaitza` enum('Irabazi','Berdin','Galdu') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `apostu_emaitza`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `apostu_emaitza` (
`erabiltzaile_izena` varchar(50)
,`JokoIzena` varchar(50)
,`apostu_kantitatea` int(11)
,`apostu_emaitza` enum('Irabazi','Berdin','Galdu')
);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `erabiltzaile_kontua`
--

CREATE TABLE `erabiltzaile_kontua` (
  `NAN` varchar(10) NOT NULL,
  `id_maila` int(10) UNSIGNED DEFAULT NULL,
  `diru_kopuru_historikoa` double UNSIGNED NOT NULL,
  `diru_kopuru_momentukoa` double UNSIGNED NOT NULL,
  `tlf_zenbakia` char(9) NOT NULL,
  `posta_Kodea` int(10) UNSIGNED NOT NULL,
  `herrialdea` varchar(100) NOT NULL,
  `probintzia` varchar(100) NOT NULL,
  `herria` varchar(50) NOT NULL,
  `jaiotze_data` date NOT NULL,
  `abizena` varchar(50) NOT NULL,
  `erabiltzaile_izena` varchar(50) NOT NULL,
  `pasahitza` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `erabiltzaile_kontua`
--

INSERT INTO `erabiltzaile_kontua` (`NAN`, `id_maila`, `diru_kopuru_historikoa`, `diru_kopuru_momentukoa`, `tlf_zenbakia`, `posta_Kodea`, `herrialdea`, `probintzia`, `herria`, `jaiotze_data`, `abizena`, `erabiltzaile_izena`, `pasahitza`) VALUES
('03418239W', 4, 1000, 1000, '663311341', 20870, 'Euskadi', 'Bizkaia', 'Bilbo', '1991-04-20', 'Sainz', 'Max', 'Elorrieta00'),
('34567890V', 3, 1000, 1000, '612456493', 48830, 'Euskadi', 'Bizkaia', 'Sodupe', '2002-12-31', 'Siranaula', 'Aingeru Daniel', 'Elorrieta00'),
('41376983Y', 3, 1000, 1000, '701704730', 20870, 'Euskadi', 'Gipuzkoa', 'Elgoibar', '2000-01-01', 'Gil', 'Xabier', 'Elorrieta00'),
('72323409R', 5, 1000, 1000, '636993814', 48009, 'Euskadi', 'Bizkaia', 'Bilbo', '1991-01-10', 'Zabaleta', 'Aito', 'Elorrieta00'),
('73813259A', 4, 1000, 1000, '694919686', 48970, 'Euskadi', 'Bizkaia', 'Basauri', '2002-07-21', 'Pelea', 'Aimar', 'Elorrieta00'),
('92549706Y', 5, 1000, 1000, '624076334', 48970, 'Euskadi', 'Bizkaia', 'Basauri', '1992-09-20', 'Verstappen', 'Niko', 'Elorrieta00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jokoak`
--

CREATE TABLE `jokoak` (
  `id_joko` int(11) NOT NULL,
  `id_Kasino` int(11) NOT NULL,
  `JokoIzena` varchar(50) NOT NULL,
  `MaxApostu` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `jokoak`
--

INSERT INTO `jokoak` (`id_joko`, `id_Kasino`, `JokoIzena`, `MaxApostu`) VALUES
(1, 1, 'Ruleta', 10000),
(2, 1, 'Blackjack', 1000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `kasino`
--

CREATE TABLE `kasino` (
  `id_Kasino` int(11) NOT NULL,
  `Izena` varchar(70) NOT NULL,
  `Helbidea` varchar(50) NOT NULL,
  `Telefonoa` char(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `kasino`
--

INSERT INTO `kasino` (`id_Kasino`, `Izena`, `Helbidea`, `Telefonoa`) VALUES
(1, 'Elorrieta Kasinoa', 'Karmen Kalea 35', '606408012'),
(2, 'Bilbo Kasinoa', 'Abando 2', '640284212');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `kasino_erabiltzaile`
--

CREATE TABLE `kasino_erabiltzaile` (
  `id_Kasino` int(11) DEFAULT NULL,
  `NAN` varchar(9) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `kasino_erabiltzaile`
--

INSERT INTO `kasino_erabiltzaile` (`id_Kasino`, `NAN`) VALUES
(1, '34567890V'),
(1, '03418239W'),
(1, '72323409R'),
(2, '92549706Y'),
(2, '73813259A'),
(2, '41376983Y');

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `kasino_jokoak`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `kasino_jokoak` (
`Izena` varchar(70)
,`JokoIzena` varchar(50)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `langile_info`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `langile_info` (
`NAN` varchar(9)
,`Izena` varchar(20)
,`Abizena` varchar(50)
,`Kargu` varchar(50)
,`Soldata` double unsigned
,`Kasinoren Izena` varchar(70)
);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `langile_kontua`
--

CREATE TABLE `langile_kontua` (
  `id_Langile` int(11) NOT NULL,
  `id_Kasino` int(11) DEFAULT NULL,
  `NAN` varchar(9) DEFAULT NULL,
  `Izena` varchar(20) NOT NULL,
  `Abizena` varchar(50) NOT NULL,
  `Jaiotze_data` date NOT NULL,
  `Herrialdea` varchar(100) NOT NULL,
  `Probintzia` varchar(100) NOT NULL,
  `Herria` varchar(50) NOT NULL,
  `Posta_Kodea` int(10) UNSIGNED NOT NULL,
  `Posta_elektronikoa` varchar(100) NOT NULL,
  `tlf_zenbakia` char(9) NOT NULL,
  `Kargu` varchar(50) NOT NULL,
  `Soldata` double UNSIGNED NOT NULL,
  `Pasahitza` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `langile_kontua`
--

INSERT INTO `langile_kontua` (`id_Langile`, `id_Kasino`, `NAN`, `Izena`, `Abizena`, `Jaiotze_data`, `Herrialdea`, `Probintzia`, `Herria`, `Posta_Kodea`, `Posta_elektronikoa`, `tlf_zenbakia`, `Kargu`, `Soldata`, `Pasahitza`) VALUES
(1, 1, '73264894A', 'Unax', 'Zulaika', '2001-01-01', 'Euskadi', 'Gipuzkoa', 'Elgoibar', 20870, 'unax.zulaikafu@elorrieta-errekamari.com', '606407364', 'Manager', 50000, 'Admin00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `maila`
--

CREATE TABLE `maila` (
  `id_maila` int(10) UNSIGNED NOT NULL,
  `izena` varchar(70) NOT NULL,
  `apostua_max` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `maila`
--

INSERT INTO `maila` (`id_maila`, `izena`, `apostua_max`) VALUES
(1, 'Blokeatuta', 0),
(2, 'Baja', 0),
(3, 'Brontze', 1000),
(4, 'Zilarra', 5000),
(5, 'Urrea', 10000);

-- --------------------------------------------------------

--
-- Estructura para la vista `apostu_emaitza`
--
DROP TABLE IF EXISTS `apostu_emaitza`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `apostu_emaitza`  AS SELECT `erabiltzaile_kontua`.`erabiltzaile_izena` AS `erabiltzaile_izena`, `jokoak`.`JokoIzena` AS `JokoIzena`, `apostua`.`apostu_kantitatea` AS `apostu_kantitatea`, `apostua`.`apostu_emaitza` AS `apostu_emaitza` FROM ((`erabiltzaile_kontua` join `apostua` on(`erabiltzaile_kontua`.`NAN` = `apostua`.`NAN`)) join `jokoak` on(`apostua`.`id_joko` = `jokoak`.`id_joko`))  ;

-- --------------------------------------------------------

--
-- Estructura para la vista `kasino_jokoak`
--
DROP TABLE IF EXISTS `kasino_jokoak`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `kasino_jokoak`  AS SELECT `kasino`.`Izena` AS `Izena`, `jokoak`.`JokoIzena` AS `JokoIzena` FROM (`kasino` join `jokoak` on(`kasino`.`id_Kasino` = `jokoak`.`id_Kasino`))  ;

-- --------------------------------------------------------

--
-- Estructura para la vista `langile_info`
--
DROP TABLE IF EXISTS `langile_info`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `langile_info`  AS SELECT `lk`.`NAN` AS `NAN`, `lk`.`Izena` AS `Izena`, `lk`.`Abizena` AS `Abizena`, `lk`.`Kargu` AS `Kargu`, `lk`.`Soldata` AS `Soldata`, `k`.`Izena` AS `Kasinoren Izena` FROM (`langile_kontua` `lk` join `kasino` `k` on(`lk`.`id_Kasino` = `k`.`id_Kasino`))  ;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `apostua`
--
ALTER TABLE `apostua`
  ADD PRIMARY KEY (`id_apostu`),
  ADD KEY `fk_erabiltzaile_kontua` (`NAN`),
  ADD KEY `fk_jokua` (`id_joko`);

--
-- Indices de la tabla `erabiltzaile_kontua`
--
ALTER TABLE `erabiltzaile_kontua`
  ADD PRIMARY KEY (`NAN`),
  ADD KEY `erabiltzaile_kontua_ibfk_1` (`id_maila`);

--
-- Indices de la tabla `jokoak`
--
ALTER TABLE `jokoak`
  ADD PRIMARY KEY (`id_joko`),
  ADD KEY `id_Kasino` (`id_Kasino`);

--
-- Indices de la tabla `kasino`
--
ALTER TABLE `kasino`
  ADD PRIMARY KEY (`id_Kasino`);

--
-- Indices de la tabla `kasino_erabiltzaile`
--
ALTER TABLE `kasino_erabiltzaile`
  ADD KEY `fk_Id_Kasino_kasino_erabiltzailea` (`id_Kasino`),
  ADD KEY `fk_NAN_kasino_erabiltzailea` (`NAN`);

--
-- Indices de la tabla `langile_kontua`
--
ALTER TABLE `langile_kontua`
  ADD PRIMARY KEY (`id_Langile`),
  ADD UNIQUE KEY `Posta_elektronikoa` (`Posta_elektronikoa`),
  ADD KEY `fk_Id_Kasino` (`id_Kasino`);

--
-- Indices de la tabla `maila`
--
ALTER TABLE `maila`
  ADD PRIMARY KEY (`id_maila`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `apostua`
--
ALTER TABLE `apostua`
  MODIFY `id_apostu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;

--
-- AUTO_INCREMENT de la tabla `jokoak`
--
ALTER TABLE `jokoak`
  MODIFY `id_joko` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `kasino`
--
ALTER TABLE `kasino`
  MODIFY `id_Kasino` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `langile_kontua`
--
ALTER TABLE `langile_kontua`
  MODIFY `id_Langile` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `maila`
--
ALTER TABLE `maila`
  MODIFY `id_maila` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `apostua`
--
ALTER TABLE `apostua`
  ADD CONSTRAINT `fk_erabiltzaile_kontua` FOREIGN KEY (`NAN`) REFERENCES `erabiltzaile_kontua` (`NAN`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_jokua` FOREIGN KEY (`id_joko`) REFERENCES `jokoak` (`id_joko`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `erabiltzaile_kontua`
--
ALTER TABLE `erabiltzaile_kontua`
  ADD CONSTRAINT `erabiltzaile_kontua_ibfk_1` FOREIGN KEY (`id_maila`) REFERENCES `maila` (`id_maila`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `jokoak`
--
ALTER TABLE `jokoak`
  ADD CONSTRAINT `jokoak_ibfk_1` FOREIGN KEY (`id_Kasino`) REFERENCES `kasino` (`id_Kasino`);

--
-- Filtros para la tabla `kasino_erabiltzaile`
--
ALTER TABLE `kasino_erabiltzaile`
  ADD CONSTRAINT `fk_Id_Kasino_kasino_erabiltzailea` FOREIGN KEY (`id_Kasino`) REFERENCES `kasino` (`id_Kasino`) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_NAN_kasino_erabiltzailea` FOREIGN KEY (`NAN`) REFERENCES `erabiltzaile_kontua` (`NAN`) ON DELETE CASCADE;

--
-- Filtros para la tabla `langile_kontua`
--
ALTER TABLE `langile_kontua`
  ADD CONSTRAINT `fk_Id_Kasino` FOREIGN KEY (`id_Kasino`) REFERENCES `kasino` (`id_Kasino`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
