use tiy6; 


create table major (
  id int primary key auto_increment,
  name varchar(50),
  req_sat_score int,
  CHECK (req_sat_score > 399 AND req_sat_score < 1601)
);

insert major (name,req_sat_score) values ('General Business',800);
insert major (name,req_sat_score) values ('Accounting',1000);
insert major (name,req_sat_score) values ('Finance',1100);
insert major (name,req_sat_score) values ('Math',1300);
insert major (name,req_sat_score) values ('Engineering',1350);
insert major (name,req_sat_score) values ('Education',900);
insert major (name,req_sat_score) values ('General Studies',500);

create table instructor (
  id int primary key auto_increment,
  first_name varchar(30),
  last_name varchar(30),
  major_id int,
  foreign key (major_id) references major(id),
  years_of_experience int,
  CHECK (years_of_experience > 0),
  is_tenured tinyint
);

create table class (
  id int primary key auto_increment,
  name varchar(30),
  course_number int,
  instructor_id int,
  foreign key (instructor_id) references instructor(id)
);


create table major_class_relationship (
  id int primary key auto_increment,
  major_id int NOT NULL,
  foreign key (major_id) references major(id),
  class_id int NOT NULL,
  foreign key (class_id) references class(id)
);

create table student_class_relationship (
  id int primary key auto_increment,
  student_id int NOT NULL,
  foreign key (student_id) references student(id),
  class_id int NOT NULL,
  foreign key (class_id) references class(id)
);

alter table student
 add gpa decimal(5,1),
 add sat int,
 add major_id int,
 add constraint foreign key (major_id) references major(id),
 drop years_of_experience;

 alter table assignment
 add class_id int,
 add constraint foreign key (class_id) references class(id);



