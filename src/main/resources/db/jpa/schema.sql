drop table if exists vehicle;
drop table if exists driver;

create table driver (
  id identity,
  name varchar(25) not null
);
	
create table vehicle (
  id identity,
  year int,
  model varchar(25), 
  make varchar(25), 
  plate varchar(25) 
);