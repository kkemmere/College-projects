UNLOCK TABLES;
CREATE DATABASE IF NOT EXISTS lab1;
USE lab1;

Drop TABLE IF EXISTS timeslot;
CREATE TABLE timeslot (time_slot_id varchar(4) NOT NULL, day varchar(1)NOT NULL,
start_time time NOT NULL,
end_timetime time DEFAULT NULL,
PRIMARY KEY (time_slot_id,day,start_time));

LOCK TABLES timeslot WRITE;

INSERT INTO timeslot VALUES ('A','F','08:00:00','08:50:00'),('A','M','08:00:00','08:50:00');


LOCK TABLES instructor WRITE;
Drop TABLE IF EXISTS instructor;
Drop TABLE IF EXISTS section;
Drop TABLE IF EXISTS course;
Drop TABLE IF EXISTS classroom;
Drop TABLE IF EXISTS department;

CREATE TABLE classroom (building varchar(15), 
room_number varchar(7), 
capacity numeric (4,0), 
primary key (building, room_number));

CREATE TABLE department (dept_name varchar (20),
building varchar(15),
budget numeric (12,2) check (budget > 0),
primary key (dept_name));

CREATE TABLE course (course_id varchar(8),
title varchar(50), dept_name varchar(20),
credits numeric (2,0) check (credits > 0), 
primary key (course_id),
foreign key (dept_name) references department(dept_name) on delete set null);

CREATE TABLE instructor (ID varchar (5), 
name varchar (20) not null, dept_name varchar(20),
salary numeric (8,2) check (salary > 29000), 
primary key (ID), foreign key (dept_name) references 
department(dept_name) on delete set null);

CREATE TABLE section (course_id varchar(8), sec_id varchar(8),
semester varchar(6) check (semester in ("Fall", "Winter","Spring","Summer")),
year numeric (4,0) check (year > 1701 and year < 2100),
building varchar (15), room_number varchar (7), time_slot_id varchar (4),
primary key (course_id, sec_id, semester, year),
foreign key (course_id) references course(course_id) on delete cascade,
foreign key (building, room_number) references classroom(building, room_number) on delete set null);

INSERT INTO classroom (building, room_number, capacity) VALUES ("Packard", "101", "500");
INSERT INTO classroom (building, room_number, capacity) VALUES ("Painter", "514", "10");
INSERT INTO classroom (building, room_number, capacity) VALUES ("Taylor", "3128", "70");
INSERT INTO classroom (building, room_number, capacity) VALUES ("Watson", "100", "30");
INSERT INTO classroom (building, room_number, capacity) VALUES ("Watson", "120", "50");

INSERT INTO department (dept_name, building, budget)  VALUES ("Biology", "Watson", "90000");


UNLOCK TABLES;