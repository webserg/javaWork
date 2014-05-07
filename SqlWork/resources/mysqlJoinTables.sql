CREATE TABLE department
(
 DepartmentID INT,
 DepartmentName VARCHAR(20)
);
 
CREATE TABLE employee
(
 LastName VARCHAR(20),
 DepartmentID INT
);
 
INSERT INTO department(DepartmentID, DepartmentName) VALUES(31, 'Sales');
INSERT INTO department(DepartmentID, DepartmentName) VALUES(33, 'Engineering');
INSERT INTO department(DepartmentID, DepartmentName) VALUES(34, 'Clerical');
INSERT INTO department(DepartmentID, DepartmentName) VALUES(35, 'Marketing');
 
INSERT INTO employee(LastName, DepartmentID) VALUES('Rafferty', 31);
INSERT INTO employee(LastName, DepartmentID) VALUES('Jones', 33);
INSERT INTO employee(LastName, DepartmentID) VALUES('Heisenberg', 33);
INSERT INTO employee(LastName, DepartmentID) VALUES('Robinson', 34);
INSERT INTO employee(LastName, DepartmentID) VALUES('Smith', 34);
INSERT INTO employee(LastName, DepartmentID) VALUES('John', NULL);

CREATE TABLE salary
(
  name VARCHAR(20), 
  salary INT
);

INSERT INTO salary(name, salary) VALUES('Smith', 300);
INSERT INTO salary(name, salary) VALUES('Joe', 400);
INSERT INTO salary(name, salary) VALUES('Raf', 300);
INSERT INTO salary(name, salary) VALUES('Smith', 300);
INSERT INTO salary(name, salary) VALUES('Smith', 300);
INSERT INTO salary(name, salary) VALUES('Smith', 300);
INSERT INTO salary(name, salary) VALUES('Smith', 300);

select name,count(*) as c from salary group by name,salary having c > 1;