drop table if exists board CASCADE;
create table comment
(
    id bigint generated by default as identity,
    post_id  integer,
    content varchar(255),
    created_at timestamp,
    updated_at timestamp,
    primary key(id)
);