create table bbsTBL(
	user_seq integer auto_increment unique not null,
	user_name varchar(20) not null,
	user_id varchar(20) primary key,
	user_pwd varchar(20) not null,
	user_email varchar(30) not null,
	join_date timestamp default now()
)default character set utf8 collate utf8_general_ci;


create table postTBL(
	user_seq integer auto_increment unique not null,
	user_id varchar(20) not null,
	bbsTitle varchar(20) not null,
	bbsPost varchar(100) not null,
	post_time timestamp default now(),
    foreign key (user_id) references bbsTBL(user_id)
)default character set utf8 collate utf8_general_ci;


create table guestTBL(
	user_seq integer auto_increment primary key,
	post_time timestamp default now(),
	guestTitle varchar(20) not null,
	guestPost varchar(100) not null
)default character set utf8 collate utf8_general_ci;

select * from bbstbl;
select * from posttbl;
select * from guesttbl;
drop table bbsTBL;
drop table postTBL;
drop table guestTBL;