create table if not exists country (
  id        identity unique,
  name      varchar(255) unique,
  code_name varchar(255) unique
);

create table if not exists user (
  id        identity unique,
  first_name      varchar(255),
  last_name varchar(255)
);