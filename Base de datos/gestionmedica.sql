
--
-- Base de datos: `gestionmedica`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE `roles` (
  `IdRoles` int(11) NOT NULL PRIMARY KEY,
  `Cargo` varchar(50) NOT NULL
)

--
-- Volcado de datos para la tabla `roles`
--

INSERT INTO `roles` (`IdRoles`, `Cargo`) VALUES
(1, 'admin'),
(2, 'medico'),
(3, 'paciente');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `TipoDocumento` varchar(30) NOT NULL,
  `Identificacion` int(11) NOT NULL PRIMARY KEY,
  `Nombre` varchar(200) NOT NULL,
  `Fecha_Nacimiento` date DEFAULT NULL,
  `Sexo` char(1) DEFAULT NULL,
  `Contraseña` varchar(50) DEFAULT NULL,
  `Consultorio_Medico` int(11) DEFAULT NULL,
  `IdRoles` int(11) NOT NULL
  FOREIGN KEY (Identificacion) REFERENCES roles (IdRoles)
)

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medicamentos`
--

CREATE TABLE `medicamentos` (
  `Id` int(11) NOT NULL PRIMARY KEY,
  `Nombre` varchar(50) NOT NULL,
  `Descripcion` text NOT NULL
)

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `citas`
--

CREATE TABLE `citas` (
  `Numero` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `Observacion` text NOT NULL,
  `Fecha` date NOT NULL,
  `Hora` varchar(20) NOT NULL,
  `Estado` varchar(30) NOT NULL,
  `Medico` int(11) DEFAULT NULL,
  `Paciente` int(11) DEFAULT NULL,
  FOREIGN KEY (`Medico`) REFERENCES `usuarios` (`Identificacion`),
  FOREIGN KEY (`Paciente`) REFERENCES `usuarios` (`Identificacion`);
)

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tratamientos`
--

CREATE TABLE `tratamientos` (
  `Id` int(11) NOT NULL,
  `Fecha_asignada` date NOT NULL,
  `Fecha_inicio` date NOT NULL,
  `Fecha_fin` date NOT NULL,
  `Observaciones` text,
  `Paciente` int(11) DEFAULT NULL,
  `Medicamento` int(11) DEFAULT NULL,
  FOREIGN KEY (`Paciente`) REFERENCES `usuarios` (`Identificacion`),
  FOREIGN KEY (`Medicamento`) REFERENCES `medicamentos` (`Id`);
)
