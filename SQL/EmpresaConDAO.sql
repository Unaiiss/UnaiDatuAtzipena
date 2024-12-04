drop database if exists ariketa2;
create database if not exists ariketa2;
use ariketa2;

CREATE TABLE if not exists departamentos (
 dept_no  TINYINT(2) NOT NULL PRIMARY KEY,
 dnombre  VARCHAR(15), 
 loc      VARCHAR(15)
) ENGINE=InnoDB;

INSERT INTO departamentos VALUES (10,'CONTABILIDAD','SEVILLA');
INSERT INTO departamentos VALUES (20,'INVESTIGACION','MADRID');
INSERT INTO departamentos VALUES (30,'VENTAS','BARCELONA');
INSERT INTO departamentos VALUES (40,'PRODUCCION','BILBAO');
COMMIT;

CREATE TABLE if not exists  empleados (
 emp_no    SMALLINT(4)  NOT NULL PRIMARY KEY,
 apellido  VARCHAR(10),
 oficio    VARCHAR(10),
 dir       SMALLINT,
 fecha_alt DATE      ,
 salario   FLOAT(6,2),
 comision  FLOAT(6,2),
 dept_no   TINYINT(2) NOT NULL,
 CONSTRAINT FK_DEP FOREIGN KEY (dept_no ) REFERENCES departamentos(dept_no)

) ENGINE=InnoDB;

INSERT INTO empleados VALUES (7369,'SANCHEZ','EMPLEADO',7902,'1990/12/17',
                        1040,NULL,20);				
INSERT INTO empleados VALUES (7499,'ARROYO','VENDEDOR',7698,'1990/02/20',
                        1500,390,30);
INSERT INTO empleados VALUES (7521,'SALA','VENDEDOR',7698,'1991/02/22',
                        1625,650,30);
INSERT INTO empleados VALUES (7566,'JIMENEZ','DIRECTOR',7839,'1991/04/02',
                        2900,NULL,20);
INSERT INTO empleados VALUES (7654,'MARTIN','VENDEDOR',7698,'1991/09/29',
                        1600,1020,30);
INSERT INTO empleados VALUES (7698,'NEGRO','DIRECTOR',7839,'1991/05/01',
                        3005,NULL,30);
INSERT INTO empleados VALUES (7782,'CEREZO','DIRECTOR',7839,'1991/06/09',
                        2885,NULL,10);
INSERT INTO empleados VALUES (7788,'GIL','ANALISTA',7566,'1991/11/09',
                        3000,NULL,20);
INSERT INTO empleados VALUES (7839,'REY','PRESIDENTE',NULL,'1991/11/17',
                        4100,NULL,10);
INSERT INTO empleados VALUES (7844,'TOVAR','VENDEDOR',7698,'1991/09/08',
                        1350,0,30);
INSERT INTO empleados VALUES (7876,'ALONSO','EMPLEADO',7788,'1991/09/23',
                        1430,NULL,20);
INSERT INTO empleados VALUES (7900,'JIMENO','EMPLEADO',7698,'1991/12/03',
                        1335,NULL,30);
INSERT INTO empleados VALUES (7902,'FERNANDEZ','ANALISTA',7566,'1991/12/03',
                        3000,NULL,20);
INSERT INTO empleados VALUES (7934,'MUNOZ','EMPLEADO',7782,'1992/01/23',
                        1690,NULL,10);
DELIMITER //
CREATE PROCEDURE DepartamentuakAtera()
BEGIN
	SELECT * 
    FROM departamentos;
END;

CREATE PROCEDURE Depar10Langileak(in depar int)
BEGIN
	SELECT e.apellido, e.oficio, e.salario 
    FROM empleados e JOIN departamentos d USING(dept_no) 
    WHERE d.dept_no = depar;
END;

CREATE PROCEDURE SoldataAltuenaLang()
BEGIN
	SELECT e.apellido, e.oficio, e.salario
    FROM empleados e
    ORDER BY e.salario
    DESC LIMIT 1;
END;

Create procedure añadir_dept_marketing()
begin
	INSERT INTO departamentos VALUES (50, 'MARKETING', 'VALENCIA');
    
    INSERT INTO empleados VALUES (8000,'PEREZ','ANALISTA',NULL,'2024/01/01',
                        3200,0,50);
	INSERT INTO empleados VALUES (8001,'LOPEZ','EMPLEADO',8000,'2024/01/15',
                        1500,200,50);	
end;

Create procedure actualizar_salarios_marketing(
	IN salario_nuevo float
)
begin
	UPDATE empleados 
	SET salario = salario_nuevo
	WHERE dept_no IN (
		SELECT dept_no 
		FROM departamentos 
		WHERE loc = 'Valencia'
	);
end;

Create procedure eliminar_dept_marketing()
begin
    -- Eliminar empleados del departamento de Valencia
    DELETE FROM empleados
    WHERE dept_no IN (
        SELECT dept_no 
        FROM departamentos 
        WHERE loc = 'Valencia'
    );

    -- Eliminar el departamento Valencia
    DELETE FROM departamentos
    WHERE loc = 'Valencia';
end;

//
COMMIT;