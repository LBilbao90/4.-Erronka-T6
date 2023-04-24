-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-04-2023 a las 11:03:34
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
  `NAN` varchar(9) DEFAULT NULL CHECK (`NAN` like '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][A-Z]'),
  `Id_joko` int(11) DEFAULT NULL,
  `apostu_kantitatea` int(11) NOT NULL,
  `apostu_emaitza` enum('zuenza','okerra') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `erabiltzaile_kontua`
--

CREATE TABLE `erabiltzaile_kontua` (
  `NAN` varchar(9) NOT NULL CHECK (`NAN` like '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][A-Z]'),
  `diru_kopuru_historikoa` double UNSIGNED NOT NULL,
  `diru_kopuru_momentukoa` double UNSIGNED NOT NULL,
  `tlf_zenbakia` char(9) NOT NULL,
  `posta_Kodea` int(10) UNSIGNED NOT NULL,
  `herialdea` varchar(100) NOT NULL,
  `probintzia` varchar(100) NOT NULL,
  `herria` varchar(50) NOT NULL,
  `jaiotze_data` timestamp NOT NULL DEFAULT current_timestamp(),
  `abizena` varchar(50) NOT NULL,
  `erabiltzaile_izena` varchar(50) NOT NULL,
  `pasahitza` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jokoak`
--

CREATE TABLE `jokoak` (
  `Id_joko` int(11) NOT NULL,
  `Id_Kasino` int(11) NOT NULL,
  `JokoIzena` varchar(50) NOT NULL,
  `MaxApostu` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `kasino`
--

CREATE TABLE `kasino` (
  `Id_Kasino` int(11) NOT NULL,
  `Izena` varchar(70) NOT NULL,
  `Helbidea` varchar(50) NOT NULL,
  `Telefonoa` char(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `langile_kontua`
--

CREATE TABLE `langile_kontua` (
  `Id_Langile` int(11) NOT NULL,
  `Id_Kasino` int(11) DEFAULT NULL,
  `NAN` varchar(9) NOT NULL CHECK (`NAN` like '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][A-Z]'),
  `Izena` varchar(20) NOT NULL,
  `Abizena` varchar(50) NOT NULL,
  `Jaiotze_data` timestamp NOT NULL DEFAULT current_timestamp(),
  `Herrialdea` varchar(100) NOT NULL,
  `Probintzia` varchar(100) NOT NULL,
  `Herria` varchar(50) NOT NULL,
  `Posta_Kodea` int(10) UNSIGNED NOT NULL,
  `Posta_elektronikoa` varchar(100) NOT NULL,
  `tlf_zenbakia` char(9) NOT NULL,
  `Kargu` varchar(50) NOT NULL,
  `Soldata` double UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `maila`
--

CREATE TABLE `maila` (
  `id_maila` int(10) UNSIGNED NOT NULL,
  `izena` varchar(70) NOT NULL,
  `NAN` varchar(9) NOT NULL CHECK (`NAN` like '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][A-Z]'),
  `kopurua` int(11) NOT NULL,
  `apostua_max` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `apostua`
--
ALTER TABLE `apostua`
  ADD PRIMARY KEY (`id_apostu`),
  ADD KEY `idx_apostua_id_joko` (`Id_joko`),
  ADD KEY `idx_apostua_NAN` (`NAN`),
  ADD KEY `idx_apostua_id_joko_emaitza` (`Id_joko`,`apostu_emaitza`);

--
-- Indices de la tabla `erabiltzaile_kontua`
--
ALTER TABLE `erabiltzaile_kontua`
  ADD PRIMARY KEY (`NAN`),
  ADD KEY `tlf_zenbakia_idx` (`tlf_zenbakia`),
  ADD KEY `posta_Kodea_idx` (`posta_Kodea`),
  ADD KEY `herialdea_idx` (`herialdea`),
  ADD KEY `probintzia_idx` (`probintzia`),
  ADD KEY `herria_idx` (`herria`),
  ADD KEY `jaiotze_data_idx` (`jaiotze_data`),
  ADD KEY `abizena_idx` (`abizena`),
  ADD KEY `erabiltzaile_izena_idx` (`erabiltzaile_izena`);

--
-- Indices de la tabla `jokoak`
--
ALTER TABLE `jokoak`
  ADD PRIMARY KEY (`Id_joko`),
  ADD KEY `idx_jokoak_id_kasino` (`Id_Kasino`),
  ADD KEY `idx_jokoak_jokoizena` (`JokoIzena`),
  ADD KEY `idx_jokoak_maxapostu` (`MaxApostu`);

--
-- Indices de la tabla `kasino`
--
ALTER TABLE `kasino`
  ADD PRIMARY KEY (`Id_Kasino`),
  ADD KEY `idx_kasino_basik` (`Izena`),
  ADD KEY `idx_kasino_basiko` (`Izena`);

--
-- Indices de la tabla `langile_kontua`
--
ALTER TABLE `langile_kontua`
  ADD PRIMARY KEY (`Id_Langile`),
  ADD UNIQUE KEY `Posta_elektronikoa` (`Posta_elektronikoa`),
  ADD KEY `fk_Id_Kasino` (`Id_Kasino`),
  ADD KEY `idx_langile_kontua_basik` (`NAN`,`Izena`,`Abizena`,`Jaiotze_data`,`Kargu`,`Soldata`,`Probintzia`);

--
-- Indices de la tabla `maila`
--
ALTER TABLE `maila`
  ADD PRIMARY KEY (`id_maila`),
  ADD KEY `izena_idx` (`izena`),
  ADD KEY `NAN_idx` (`NAN`),
  ADD KEY `kopurua_idx` (`kopurua`),
  ADD KEY `apostua_max_idx` (`apostua_max`),
  ADD KEY `fk_erabiltzaile_kontua_idx` (`NAN`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `apostua`
--
ALTER TABLE `apostua`
  MODIFY `id_apostu` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `jokoak`
--
ALTER TABLE `jokoak`
  MODIFY `Id_joko` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `kasino`
--
ALTER TABLE `kasino`
  MODIFY `Id_Kasino` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `langile_kontua`
--
ALTER TABLE `langile_kontua`
  MODIFY `Id_Langile` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `maila`
--
ALTER TABLE `maila`
  MODIFY `id_maila` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `apostua`
--
ALTER TABLE `apostua`
  ADD CONSTRAINT `fk_erabiltzaile_kontua_apostua` FOREIGN KEY (`NAN`) REFERENCES `erabiltzaile_kontua` (`NAN`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_jokua` FOREIGN KEY (`Id_joko`) REFERENCES `jokoak` (`Id_joko`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `jokoak`
--
ALTER TABLE `jokoak`
  ADD CONSTRAINT `jokoak_ibfk_1` FOREIGN KEY (`Id_Kasino`) REFERENCES `kasino` (`Id_Kasino`);

--
-- Filtros para la tabla `langile_kontua`
--
ALTER TABLE `langile_kontua`
  ADD CONSTRAINT `fk_Id_Kasino` FOREIGN KEY (`Id_Kasino`) REFERENCES `kasino` (`Id_Kasino`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `maila`
--
ALTER TABLE `maila`
  ADD CONSTRAINT `fk_erabiltzaile_kontua` FOREIGN KEY (`NAN`) REFERENCES `erabiltzaile_kontua` (`NAN`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
