-----Name: Pinal Soni-----
---Database for Banking Project-----

--create Role Model
drop table bank_role;

create table bank_role(
roleId serial primary key,
role varchar not null unique
);

/*add records in Role table*/

insert into bank_role values(default,'Admin');
insert into bank_role values(default,'Employee');
insert into bank_role values(default,'Standard');
insert into bank_role values(default,'Premium');
 select * from bank_role;



--create user model
--drop table user;
--drop table bank_user ;
create table bank_user(
userID serial primary key,
username varchar not null unique,
upassword varchar not null,
ufirstName varchar not null,
ulastName varchar not null,
uemail varchar not null,
urole integer references bank_role(roleId)
);

commit;

/*Add records in bank user table*/
insert into bank_user values(default,'psoni','soni123','Pinal','Soni','sonipinal@gmail.com',1 );
insert into bank_user values(default,'shree','shree123','Shreya','Shah','shahshreya@gmail.com',2 );

insert into bank_user values(default,'hina11','hina123','Hina','Patel','patelhina@gmail.com',3 );
insert into bank_user values(default,'parth','parth123','Parth','Seth','parth@gmail.com',4 );

select * from bank_user;



delete from bank_user where userid =0;
select * from bank_user where userId = 1;
select * from bank_user where userid =3;

select * from bank_user a ,bank_role  b where a.urole =b.roleid ;
select * from bank_user where urole in(1,2);

select * from bank_user inner join bank_role on bank_user.urole =bank_role.roleid where userId =3;
select * from bank_user inner join bank_role on bank_user.urole =bank_role.roleid where userName ='psoni';



select * from bank_user inner join bank_role on bank_user.urole =bank_role.roleid

--select bank_user.username, bank_role.urol from bank_user left join bank_role where bank_user .urole= role.roleid ;

--delete all the records from bank_user table
delete from bank_user where userid = 9;

--Create AccountStatus model
drop table accountStatus;
create table accountStatus(statusId serial primary key,
status varchar not null unique
);
commit;
select * from account;

/*add records into Account Status table. */
--Pending, Open, or Closed, or Denied

insert into accountstatus values(default,'Pending');
insert into accountstatus values(default,'Open');
insert into accountstatus values(default,'Closed');
insert into accountstatus values(default,'Denied');

select * from accountstatus ;


--create AccounType model
drop table accountType;
create table accountType
(
typeId serial primary key,
type varchar not null unique
);


--add records into Account type table
--Checking or Savings
insert into accounttype values(default,'Checking');
insert into accounttype values(default,'Savings');


select * from accountType ;

-- create Account model
drop table account;
create table account(
accountId serial primary key,
balance numeric not null CHECK (balance > 0),
accountStatus integer references accountStatus(statusId),
accountType integer references accountType(typeId)
);
update account set balance= balance + ? where accountId = ?

/*add records into Account table*/
--Pending, Open, or Closed, or Denied
--Checking or Savings
insert into account values(default,3000.00,2,2);
insert into account values(default,1000.00,1,1);
insert into account values(default,2343.56,2,2);
insert into account values(default,000.78,3,1);
insert into account values(default,6541.65,2,2);
insert into account values(default,8989.09,2,2);


select * from account;
--update account set balance =(balance + 1000) where accountid =2;
--crete another table for find the accountByuser

create table user_account(
	userid integer references bank_user(userId),
	accountid integer references account (accountId),
	primary key(userid, accountid)
);

insert into user_account values(2,1);
insert into user_account values(3,2);
insert into user_account values(6,3);

select * from user_account;
select * from account inner join user_account on account.accountId = user_account.accountid inner join bank_user on bank_user.userId = user_account.userid where bank_user. userId =6;
select u.userId ,a.accountId,a.balance,a.accountStatus ,a.accountType,u.username,u.upassword,u.ufirstname,u.uemail,u.urole  from account a inner join user_account ua on a.accountId = ua.accountId inner join bank_user u on u.userId=ua.userId where u.userId =3;

--select accountId,balance,accountstatus,accounttype,userid,username,upassword,ufirstname,ulastname,email,urole from account inner join user_account on account.accountId = user_account.accountid inner join bank_user on bank_user.userId = user_account.userid where bank_user. userId =2;
--select * from user_account where userid=(select * from bank_user where userId=(where select * ))

select * from account  inner join  accountstatus  on account.accountstatus =accountstatus.statusId inner join accounttype on account.accountType = accountType .typeId  where accountId =6;
select * from account  inner join  accountstatus  on account.accountstatus =accountstatus.statusId inner join accounttype on account.accountType = accountType .typeId  where status ='Open';

