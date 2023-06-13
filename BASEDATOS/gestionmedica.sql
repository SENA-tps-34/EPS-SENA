create database gestionmedica;
use gestionmedica;
-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-06-2023 a las 15:43:28
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `gestionmedica`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `admin`
--

CREATE TABLE `admin` (
 `tipoDocumento` varchar(50) NOT NULL,
  `AdminId` int(11) NOT NULL,
  `AdminName` varchar(50) NOT NULL,
  `AdminLastN` varchar(50) NOT NULL,
  `AdminPass` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4




--
-- Volcado de datos para la tabla `admin`
--

INSERT INTO `admin` (`AdminId`, `AdminName`, `AdminLastN`, `AdminPass`) VALUES
(10101010, 'Laura', 'Patricia', 'admin123');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `citas`
--

CREATE TABLE `citas` (
  `CitNumero` int(11) NOT NULL,
  `CitFecha` date NOT NULL,
  `CitHora` time NOT NULL,
  `CitPaciente` int(11) NOT NULL,
  `CitMedico` int(11) NOT NULL,
  `CitConsultorio` int(11) NOT NULL,
  `CitEstado` varchar(20) DEFAULT NULL,
  `CitObservaciones` varchar(200) DEFAULT NULL,
  PRIMARY KEY (CitNumero),
  FOREIGN KEY (CitPaciente) REFERENCES pacientes(PacIdentificasion),
  FOREIGN KEY (CitMedico) REFERENCES medicos(MedIdentificacion),
  FOREIGN KEY (CitConsultorio) REFERENCES consultorios(ConNumero)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `citas`
--

INSERT INTO `citas` (`CitNumero`, `CitFecha`, `CitHora`, `CitPaciente`, `CitMedico`, `CitConsultorio`, `CitEstado`, `CitObservaciones`) VALUES
(3, '2023-05-30', '10:29:00', 1044214678, 3333, 13, 'Pendiente', 'Ninguna');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `consultorios`
--

CREATE TABLE `consultorios` (
  `ConNumero` int(11) NOT NULL,
  `ConNombre` varchar(50) NOT NULL,
  PRIMARY KEY (ConNumero)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `consultorios`
--

INSERT INTO `consultorios` (`ConNumero`, `ConNombre`) VALUES
(13, 'Consultorio1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medicos`
--

CREATE TABLE `medicos` (
  `tipoDocumento` varchar(50) NOT NULL,
  `MedIdentificacion` int(11) NOT NULL,
  `MedNombre` varchar(50) NOT NULL,
  `MedApellidos` varchar(50) NOT NULL,
  `MedPassword` varchar(50) DEFAULT NULL,
  PRIMARY KEY (MedIdentificacion)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `medicos`
--

INSERT INTO `medicos` (`MedIdentificacion`, `MedNombre`, `MedApellidos`, `MedPassword`) VALUES
(3333, 'Ivan', 'Ulloque', 'abc12345');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pacientes`
--

CREATE TABLE `pacientes` (
  `tipoDocumento` varchar(50) NOT NULL,
  `PacIdentificacion` int(11) NOT NULL,
  `PacNombre` varchar(50) NOT NULL,
  `PacApellidos` varchar(50) NOT NULL,
  `PacFechaNacimiento` date DEFAULT NULL,
  `PacSexo` char(1) DEFAULT NULL,
  `PacPassword` varchar(50) DEFAULT NULL,
  PRIMARY KEY (PacIdentificasion)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pacientes`
--

INSERT INTO `pacientes` (`PacIdentificacion`, `PacNombre`, `PacApellidos`, `PacFechaNacimiento`, `PacSexo`, `PacPassword`) VALUES
(1044214677, 'daa', 'asd', '2006-08-16', 'M', 'cba123'),
(1044214678, 'Juan', 'Montoya', '2006-08-15', 'M', 'cba321'),
(1234416784, 'Cristian', 'Mancilla', '1988-01-01', 'F', 'abc321');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tratamientos`
--

CREATE TABLE `tratamientos` (
  `TraNumero` int(11) NOT NULL,
  `TraFechaAsignado` date NOT NULL,
  `TraDescripcion` varchar(200) DEFAULT NULL,
  `TraFechaInicio` date DEFAULT NULL,
  `TraFechaFin` date DEFAULT NULL,
  `TraObservaciones` varchar(200) DEFAULT NULL,
  `TraPaciente` int(11) NOT NULL,
  PRIMARY KEY (TraNumero),
  FOREIGN KEY (TraPaciente) REFERENCES pacientes(PacIdentificasion)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`AdminId`);

--
-- Indices de la tabla `citas`
--
ALTER TABLE `citas`
  ADD PRIMARY KEY (`CitNumero`),
  ADD KEY `CitPaciente` (`CitPaciente`),
  ADD KEY `CitMedico` (`CitMedico`),
  ADD KEY `CitConsultorio` (`CitConsultorio`);

--
-- Indices de la tabla `consultorios`
--
ALTER TABLE `consultorios`
  ADD PRIMARY KEY (`ConNumero`);

--
-- Indices de la tabla `medicos`
--
ALTER TABLE `medicos`
  ADD PRIMARY KEY (`MedIdentificacion`);

--
-- Indices de la tabla `pacientes`
--
ALTER TABLE `pacientes`
  ADD PRIMARY KEY (`PacIdentificacion`);

--
-- Indices de la tabla `tratamientos`
--
ALTER TABLE `tratamientos`
  ADD PRIMARY KEY (`TraNumero`),
  ADD KEY `TraPaciente` (`TraPaciente`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `citas`
--
ALTER TABLE `citas`
  MODIFY `CitNumero` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `consultorios`
--
ALTER TABLE `consultorios`
  MODIFY `ConNumero` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `tratamientos`
--
ALTER TABLE `tratamientos`
  MODIFY `TraNumero` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `citas`
--
ALTER TABLE `citas`
  ADD CONSTRAINT `citas_ibfk_1` FOREIGN KEY (`CitPaciente`) REFERENCES `pacientes` (`PacIdentificacion`),
  ADD CONSTRAINT `citas_ibfk_2` FOREIGN KEY (`CitMedico`) REFERENCES `medicos` (`MedIdentificacion`),
  ADD CONSTRAINT `citas_ibfk_3` FOREIGN KEY (`CitConsultorio`) REFERENCES `consultorios` (`ConNumero`);

--
-- Filtros para la tabla `tratamientos`
--
ALTER TABLE `tratamientos`
  ADD CONSTRAINT `tratamientos_ibfk_1` FOREIGN KEY (`TraPaciente`) REFERENCES `pacientes` (`PacIdentificacion`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

ALTER TABLE pacientes
modify PacTipoDocumento varchar (20) not null;
ALTER TABLE admin
modify AdminTipoDocumento varchar  (20)not null;
ALTER TABLE medicos 
modify MedTipoDocumento varchar (20)not null;

INSERT INTO `pacientes` (`PacTipoDocumento`) VALUES
('T.identidad'),
('T.identidad'),
('Cedula');
