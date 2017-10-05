create database if not exists dbKBank;
use dbKBank;
create table tableCustomer(customerID int not null primary key auto_increment, firstName varchar(20) not null, lastName varchar(20) not null, gender char(1) not null, dateOfBirth date not null, address varchar(50) not null, telephone varchar(13) );
create table tableAccount(accountNumber int(8) zerofill not null primary key auto_increment, customerID int not null, dateOfAccountCreation timestamp not null default CURRENT_TIMESTAMP, currentBalance decimal(13,2) not null default 0.00);