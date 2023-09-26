alter table records add active tinyint;
update records set active = 1;
alter table records modify active tinyint not null;
