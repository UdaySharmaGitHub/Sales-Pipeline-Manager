# Creating a database 
create database sales_pipline_manaagement;

# using the database 
use sales_pipline_manaagement;

#  Creating a user table which is help in login and other;
create table user(
user_id int primary key auto_increment,
    username varchar(50) not null,
  email varchar(100) not null,
    password varchar(20) not null,
    contact_no varchar(20) not null
);

#Getting the Description of the user tables
desc user;

# Inserting the values in the tables
insert into user(username,email,password,contact_no)
values("Uday Sharma","udaysharma4600@gmail.com","12345678","9876543210"),("Anshul Lakher","anshullakher123@gmail.com","123456","7418529630");
select * from user;
select * from user where username="Uday Sharma" and email="udaysharma4600@gmail.com" and password="12345678";

# Create the Sales table
create table sales(
leadid int  primary key auto_increment,
leadname varchar(50) not null,
leadcontact varchar(15) not null,
salesstatus varchar(50) not null
);

# Inserting the values in the tables
insert into sales(leadname, leadcontact, salesstatus) values("Ram","9876544560","Progress");
select * from sales;
desc sales;
select * from sales;
update sales set  leadname="Bajaj Ramdev" , leadcontact="9456783210" , salesstatus="Processed" where leadid=4;

# Creating Progress table
create table progress(
progressid int primary key auto_increment,
progressleadname varchar(50) not null,
progressleadcontact varchar(15) not null,
progressstatus varchar(50) not null
);

# Inserting the values in the tables
insert into progress(progressleadname,progressleadcontact,progressstatus) 
values("Tushar TP","9996532148","Prospecting"),
("Manik Sharma","9887526431","Proposal"),
("Vanshaj Saini","8975642341","Negotiation");

# Creating Progress table
create table processed(
processedid int primary key auto_increment,
processedleadname varchar(50) not null,
processedleadcontact varchar(15) not null,
processedstatus varchar(50) not null
);

# Inserting the values in the tables
insert into processed(processedleadname,processedleadcontact,processedstatus) 
values("Vatsalya","9978932148","Closing"),
("Avish Tyagi","9887521231","Retention"),
("Uday Punia","8945642341","Disqualified");

select * from progress where progressstatus='Negotiation' ;
select * from progress where progressstatus='Prospecting' ;
select * from progress where progressstatus='Proposal' ;

select * from processed where processedstatus='Closing' ;
select * from processed where processedstatus='Retention' ;
select * from processed where processedstatus='Disqualified' ;

