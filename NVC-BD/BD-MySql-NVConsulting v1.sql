create database NVConsulting;

USE nvconsulting;
CREATE TABLE CARGO
(
	ID_CARGO             INTEGER NOT NULL auto_increment,
	NOMBRE               varchar(50) NULL,
    ESTADO               TINYINT(1) NOT NULL,
	PRIMARY KEY (ID_CARGO)
);



CREATE UNIQUE INDEX XPKCARGO ON CARGO
(
	ID_CARGO
);



CREATE TABLE EMPLEADOS
(
	ID_EMPLEADOS         INTEGER NOT NULL auto_increment,
	NOMBRES              varchar(50) NULL,
	APELLIDOS            varchar(50) NULL,
	DNI                  char(8) NULL,
	CORREO               varchar(50) NULL,
	TELEFONO             char(9) NULL,
	DIRECCION            varchar(50) NULL,
    ESTADO               TINYINT(1) NOT NULL,
	ID_CARGO             INTEGER NOT NULL,
	PRIMARY KEY (ID_EMPLEADOS),
	FOREIGN KEY (ID_CARGO) REFERENCES CARGO (ID_CARGO)
);



CREATE UNIQUE INDEX XPKPROFESORES ON EMPLEADOS
(
	ID_EMPLEADOS
);



CREATE INDEX XIF1PROFESORES ON EMPLEADOS
(
	ID_CARGO
);



CREATE TABLE CURSOS
(
	ID_CURSOS            INTEGER NOT NULL auto_increment,
	NOMBRE               varchar(50) NULL,
	NRO_HORAS            INTEGER NULL,
	FECHA_INICIO         datetime NULL,
	PRECIO_CURSO         decimal(10,2) NULL,
	FECHA_FIN            datetime NULL,
    ESTADO               TINYINT(1) NOT NULL,
	ID_EMPLEADOS         INTEGER NOT NULL,
	PRIMARY KEY (ID_CURSOS),
	FOREIGN KEY (ID_EMPLEADOS) REFERENCES EMPLEADOS (ID_EMPLEADOS)
);



CREATE UNIQUE INDEX XPKCURSOS ON CURSOS
(
	ID_CURSOS
);



CREATE INDEX XIF1CURSOS ON CURSOS
(
	ID_EMPLEADOS
);



CREATE TABLE ALUMNOS
(
	ID_ALUMNO            INTEGER NOT NULL auto_increment,
	NOMBRES              varchar(50) NULL,
	APELLIDOS            varchar(50) NULL,
	DNI                  char(8) NULL,
	CORREO               varchar(50) NULL,
	TELEFONO             char(9) NULL,
	DIRECCION            varchar(50) NULL,
    ESTADO               TINYINT(1) NOT NULL,
	PRIMARY KEY (ID_ALUMNO)
);



CREATE UNIQUE INDEX XPKALUMNOS ON ALUMNOS
(
	ID_ALUMNO
);



CREATE TABLE ALUMNO_CURSOS
(
	ID_ALUMNO_CURSOS     INTEGER NOT NULL auto_increment,
	ID_CURSOS            INTEGER NOT NULL,
	ID_ALUMNO            INTEGER NOT NULL,
    ESTADO               TINYINT(1) NOT NULL,
	PRIMARY KEY (ID_ALUMNO_CURSOS),
	FOREIGN KEY (ID_CURSOS) REFERENCES CURSOS (ID_CURSOS),
	FOREIGN KEY (ID_ALUMNO) REFERENCES ALUMNOS (ID_ALUMNO)
);



CREATE UNIQUE INDEX XPKALUMNO_CURSOS ON ALUMNO_CURSOS
(
	ID_ALUMNO_CURSOS
);



CREATE INDEX XIF1ALUMNO_CURSOS ON ALUMNO_CURSOS
(
	ID_CURSOS
);



CREATE INDEX XIF2ALUMNO_CURSOS ON ALUMNO_CURSOS
(
	ID_ALUMNO
);



CREATE TABLE PAGO
(
	ID_PAGO              INTEGER NOT NULL auto_increment,
	FORMA_PAGO           varchar(50) NULL,
	ENTIDAD_FINANCIERA   varchar(50) NULL,
	FECHA                datetime NULL,
	HORA                 datetime NULL,
	ESTADO               TINYINT(1) NOT NULL,
	ID_CURSOS            INTEGER NOT NULL,
	OBSERVACION          varchar(50) NULL,
	ID_ALUMNO            INTEGER NOT NULL,
	PRIMARY KEY (ID_PAGO),
	FOREIGN KEY (ID_CURSOS) REFERENCES CURSOS (ID_CURSOS),
	FOREIGN KEY R_12 (ID_ALUMNO) REFERENCES ALUMNOS (ID_ALUMNO)
);



CREATE UNIQUE INDEX XPKPAGO ON PAGO
(
	ID_PAGO
);



CREATE INDEX XIF1PAGO ON PAGO
(
	ID_CURSOS
);



CREATE INDEX XIF2PAGO ON PAGO
(
	ID_ALUMNO
);



CREATE TABLE ROL
(
	ID_ROL               INTEGER NOT NULL auto_increment,
	NOMBRE               varchar(50) NULL,	
    ESTADO               TINYINT(1) NOT NULL,
	PRIMARY KEY (ID_ROL)
);



CREATE UNIQUE INDEX XPKROL ON ROL
(
	ID_ROL
);

CREATE TABLE USUARIOS
(
	ID_USUARIOS          INTEGER NOT NULL auto_increment,
	OBSERVACION          VARCHAR(50) NULL,
    ESTADO               TINYINT(1) NOT NULL,
    PASSWORD			 VARCHAR(50) NOT NULL,
    CONFIRMPASSWORD		 VARCHAR(50) NOT NULL,
	ID_EMPLEADOS         INTEGER NOT NULL,
	ID_ALUMNO            INTEGER NOT NULL,
	ID_ROL               INTEGER NULL,
	PRIMARY KEY (ID_USUARIOS),
	FOREIGN KEY (ID_EMPLEADOS) REFERENCES EMPLEADOS (ID_EMPLEADOS),
	FOREIGN KEY (ID_ALUMNO) REFERENCES ALUMNOS (ID_ALUMNO),
	FOREIGN KEY R_14 (ID_ROL) REFERENCES ROL (ID_ROL)
);



CREATE UNIQUE INDEX XPKUSUARIOS ON USUARIOS
(
	ID_USUARIOS
);



CREATE INDEX XIF1USUARIOS ON USUARIOS
(
	ID_EMPLEADOS
);



CREATE INDEX XIF2USUARIOS ON USUARIOS
(
	ID_ALUMNO
);



CREATE INDEX XIF3USUARIOS ON USUARIOS
(
	ID_ROL
);

CREATE TABLE USUARIOS_ROL
(
	ID_USUARIOS_ROL      INTEGER NOT NULL auto_increment,
	ID_USUARIOS          INTEGER NULL,	
    ID_ROL               INTEGER NULL,
	PRIMARY KEY (ID_USUARIOS_ROL),
    FOREIGN KEY (ID_USUARIOS) REFERENCES USUARIOS (ID_USUARIOS),
    FOREIGN KEY (ID_ROL) REFERENCES ROL (ID_ROL)
);



CREATE UNIQUE INDEX XPKROL ON USUARIOS_ROL
(
	ID_USUARIOS_ROL
);

#ALTER TABLE usuarios ADD PASSWORD VARCHAR(50) NOT NULL;
#ALTER TABLE usuarios ADD CONFIRMPASSWORD VARCHAR(50) NOT NULL;


