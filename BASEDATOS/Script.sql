
CREATE DATABASE `gestionmedica` 
/*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

-- gestionmedica.admin definition

CREATE TABLE `admin` (
  `IdAdmin` int NOT NULL AUTO_INCREMENT,
  `Identificacion` int NOT NULL,
  `Nombre` varchar(80) NOT NULL,
  `Contraseña` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`IdAdmin`),
  UNIQUE KEY `Identificacion` (`Identificacion`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- gestionmedica.citas definition

CREATE TABLE `citas` (
  `IdCitas` int NOT NULL AUTO_INCREMENT,
  `Id_Paciente` int NOT NULL,
  `Id_Medico` int NOT NULL,
  `Fecha` date NOT NULL,
  `Hora` time NOT NULL,
  PRIMARY KEY (`IdCitas`),
  KEY `Id_Paciente` (`Id_Paciente`),
  KEY `Id_Medico` (`Id_Medico`),
  CONSTRAINT `citas_ibfk_1` FOREIGN KEY (`Id_Paciente`) REFERENCES `pacientes` (`IdPaciente`),
  CONSTRAINT `citas_ibfk_2` FOREIGN KEY (`Id_Medico`) REFERENCES `medicos` (`IdMedico`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- gestionmedica.medicamentos definition

CREATE TABLE `medicamentos` (
  `idMedicamento` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(200) NOT NULL,
  PRIMARY KEY (`idMedicamento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- gestionmedica.medicos definition

CREATE TABLE `medicos` (
  `IdMedico` int NOT NULL AUTO_INCREMENT,
  `Identificacion` int NOT NULL,
  `Nombre` varchar(80) NOT NULL,
  `Contraseña` varchar(50) DEFAULT NULL,
  `Consultorio` int NOT NULL,
  PRIMARY KEY (`IdMedico`),
  UNIQUE KEY `Identificacion` (`Identificacion`),
  UNIQUE KEY `Consultorio` (`Consultorio`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- gestionmedica.pacientes definition

CREATE TABLE `pacientes` (
  `IdPaciente` int NOT NULL AUTO_INCREMENT,
  `Identificacion` int NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `FechaNacimiento` date DEFAULT NULL,
  `Sexo` char(1) DEFAULT NULL,
  `Contraseña` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`IdPaciente`),
  UNIQUE KEY `Identificacion` (`Identificacion`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- gestionmedica.tratamientos definition

CREATE TABLE `tratamientos` (
  `IdTratamiento` int NOT NULL AUTO_INCREMENT,
  `Id_Medicamento` int NOT NULL,
  `FechaInicio` date DEFAULT NULL,
  `FechaFin` date DEFAULT NULL,
  `Observaciones` varchar(500) DEFAULT NULL,
  `Id_Paciente` int NOT NULL,
  PRIMARY KEY (`IdTratamiento`),
  KEY `Id_Medicamento` (`Id_Medicamento`),
  KEY `Id_Paciente` (`Id_Paciente`),
  CONSTRAINT `tratamientos_ibfk_1` FOREIGN KEY (`Id_Medicamento`) REFERENCES `medicamentos` (`idMedicamento`),
  CONSTRAINT `tratamientos_ibfk_2` FOREIGN KEY (`Id_Paciente`) REFERENCES `pacientes` (`IdPaciente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

