drop table if exists board CASCADE;
create table boards
(
    id bigint generated by default as identity,
    type varchar(255),
    name varchar(255),
    primary key(id)
);