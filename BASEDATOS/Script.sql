
CREATE DATABASE `gestionmedica` 
/*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

-- gestionmedica.admin definition
--  --  -- 

-- TABLA ROLES 
use gestionmedica;
CREATE TABLE roles (
IdRoles int NOT NULL AUTO_INCREMENT,
Cargo  varchar (50) NOT NULL,
PRIMARY KEY (IdRoles)
)ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- TABLA USUARIOS 
CREATE TABLE usuarios (
TipoDocumento varchar (30) not null,
Identificacion int NOT NULL,
Nombre varchar(200) NOT NULL,
Fecha_Nacimiento  date DEFAULT NULL,
Sexo char(1) DEFAULT NULL,
Contraseña varchar(50) NOT NULL,
Consultorio_Medico int DEFAULT NULL,
IdRoles int NOT NULL,
PRIMARY KEY (Identificacion), 
FOREIGN KEY (IdRoles) references roles (IdRoles)
)ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



-- TABLA CITAS
use gestionmedica;
CREATE TABLE citas (
  IdCita int NOT NULL AUTO_INCREMENT,
  Usuario_Paciente int NOT NULL,
  Usuario_Medico int NOT NULL,
  Fecha date NOT NULL,
  Hora time NOT NULL,
  Estado VARCHAR (50)NOT NULL,
  Observaciones VARCHAR (100) DEFAULT NULL,
  PRIMARY KEY (IdCita),
  FOREIGN KEY (Usuario_Paciente) references Usuarios (Identificacion),
  FOREIGN KEY (Usuario_Medico) references Usuarios (Identificacion)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- TABLA MEDICAMENTOS
use gestionmedica;
CREATE TABLE medicamentos (
  
  IdMedicamento int NOT NULL AUTO_INCREMENT,
  Nombre varchar(200) NOT NULL,
  Descripcion varchar (200) DEFAULT NULL,
  PRIMARY KEY (`idMedicamento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



-- TABLA TRATAMIENTOS 
use gestionmedica;
CREATE TABLE tratamientos (
  IdTratamiento int NOT NULL AUTO_INCREMENT,
  IdMedicamento int NOT NULL,
  Usuario_Paciente int NOT NULL,
  FechaAsiganda date NOT NULL,
  FechaInicio date NOT NULL,
  FechaFin date DEFAULT NULL,
  Observaciones varchar(500) DEFAULT NULL,
  PRIMARY KEY (IdTratamiento),
  FOREIGN KEY (IdMedicamento) references medicamentos (IdMedicamento),
  FOREIGN KEY (Usuario_Paciente) references Usuarios (Identificacion)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

