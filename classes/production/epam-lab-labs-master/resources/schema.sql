create table if not exists country (
  id        identity unique,
  name      varchar(255) unique,
  code_name varchar(255) unique
);