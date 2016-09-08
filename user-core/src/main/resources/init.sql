use i_maven_plugin_sql;
create table if not exists t_user(
  id int(10) auto_increment primary key,
  username varchar(20),
  password varchar(20)
);
create table if not exists t_user_test(
  id int(10) auto_increment primary key,
  username varchar(20),
  password varchar(20)
);