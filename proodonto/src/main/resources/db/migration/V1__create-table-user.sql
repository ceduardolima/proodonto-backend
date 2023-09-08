create table users(

    id bigint not null auto_increment,
    name varchar(100) not null,
    email varchar(100) not null unique,
    cpf varchar(11) not null unique,
    skin_color varchar(20) not null,
    marital_status varchar(20),
    user_type varchar(20) not null,
    birthday varchar(8) not null,
    phone_number varchar(11) not null,
    nationality varchar(20),
    place_of_birth varchar(20),
    issuing_agency varchar(25) not null,
    street varchar(100) not null,
    neighborhood varchar(100) not null,
    CEP varchar(9) not null,
    state char(2) not null,
    city varchar(100) not null,

    primary key(id)

);
