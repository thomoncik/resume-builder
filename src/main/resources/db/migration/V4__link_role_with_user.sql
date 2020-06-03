create table resume_builder.user_role
(
    user_id uuid not null,
    role_id uuid not null,

    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES resume_builder.user (id),
    FOREIGN KEY (role_id) REFERENCES resume_builder.role (id)
);