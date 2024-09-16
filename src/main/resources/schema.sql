CREATE TABLE IF NOT EXISTS place(
    id bigint AUTO_INCREMENT primary key,
    name varchar(255) not null,
    slug varchar(255) not null,
    state varchar(225) not null,
    created_at timestamp not null,
    updated_at timestamp not null
);