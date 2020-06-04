create table resume_builder.user
(
    id         uuid         not null primary key,
    username   varchar(100) not null,
    first_name varchar(100),
    last_name  varchar(100),
    email      varchar(100),
    password   varchar(256) not null
);