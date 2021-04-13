
CREATE DATABASE IF NOT EXISTS persitentdb;

use persitentdb;

CREATE TABLE IF NOT EXISTS persistent_logins ( 
  username varchar(100) not null, 
  series varchar(64) primary key, 
  token varchar(64) not null, 
  last_used timestamp not null 
);

CREATE TABLE IF NOT EXISTS usermodel ( 
  username varchar(100) not null primary key, 
  password varchar(255) not null,
  role varchar(255) 
);
