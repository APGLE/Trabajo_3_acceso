-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-10-2023 a las 00:02:11
-- Versión del servidor: 10.4.25-MariaDB
-- Versión de PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

-- Base de datos: `tiendamuebles`
USE tiendamuebles;

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inventario`
--

CREATE TABLE `inventario` (
  `transaccion` varchar(50) NOT NULL,
  `fechahora` bigint(50) NOT NULL,
  `id` varchar(50) NOT NULL,
  `cif` varchar(50) NOT NULL,
  `operacion` varchar(50) NOT NULL,
  `cantidad` int(100) NOT NULL,
  `saldo` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `id` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `imagen` varchar(50) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `categoria` varchar(50) NOT NULL,
  `precio` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id`, `nombre`, `imagen`, `descripcion`, `categoria`, `precio`) VALUES
('PR123456', 'Escritorio nordico', '', 'Mesa blanca escritorio', 'Mesas', '25.00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `provee`
--

CREATE TABLE `provee` (
  `cif` varchar(50) NOT NULL,
  `producto` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE `proveedor` (
  `cif` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `telefono` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`cif`, `nombre`, `direccion`, `telefono`) VALUES
('C321234', 'Juan Palomo', 'Madrid', '956056129'),
('P324567', 'Mariquita Perez', 'Barcelona', '600546789');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` varchar(50) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `rol` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `usuario`, `password`, `rol`) VALUES
('U456789', 'JoseP3r32', 'otorrino', '');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `inventario`
--
ALTER TABLE `inventario`
  ADD PRIMARY KEY (`transaccion`),
  ADD KEY `nombre` (`cif`),
  ADD KEY `id` (`id`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `provee`
--
ALTER TABLE `provee`
  ADD KEY `producto` (`producto`),
  ADD KEY `cif` (`cif`);

--
-- Indices de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`cif`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `inventario`
--
ALTER TABLE `inventario`
  ADD CONSTRAINT `inventario_ibfk_1` FOREIGN KEY (`id`) REFERENCES `producto` (`id`),
  ADD CONSTRAINT `inventario_ibfk_2` FOREIGN KEY (`cif`) REFERENCES `proveedor` (`cif`);

--
-- Filtros para la tabla `provee`
--
ALTER TABLE `provee`
  ADD CONSTRAINT `provee_ibfk_1` FOREIGN KEY (`producto`) REFERENCES `producto` (`id`),
  ADD CONSTRAINT `provee_ibfk_2` FOREIGN KEY (`cif`) REFERENCES `proveedor` (`cif`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
