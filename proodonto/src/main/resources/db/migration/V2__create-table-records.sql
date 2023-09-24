create table records(

    id bigint not null,
    record_number varchar(5) not null,
    advisor_id bigint not null,
    operator_id bigint not null,
    semester tinyint not null,
    care_unit varchar(20) not null,
    initial_exam varchar(50) not null,
    primary key(id)
);
