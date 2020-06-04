create table resume_builder.user
(
    id            uuid         not null primary key,
    first_name    varchar(100) not null,
    last_name     varchar(100) not null,
    email_name    varchar(100) not null unique,
    password      varchar(256) not null,
    enabled       boolean      not null,
    token_expired boolean      not null
);