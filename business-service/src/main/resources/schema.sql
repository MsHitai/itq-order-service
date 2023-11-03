drop table if exists orders;
drop table if exists details;

create table if not exists orders
(
    id          bigint       not null generated always as identity,
    client_name varchar(100) not null,
    address     varchar(1000),
    amount      decimal(10, 2),
    created     timestamp without time zone,
    constraint orders_pk primary key (id)
);

create table if not exists details
(
    id            bigint       not null generated always as identity,
    serial_number varchar(100),
    name          varchar(100) not null,
    quantity      bigint       not null,
    order_id      bigint       not null,
    constraint details_pk primary key (id),
    constraint details_to_orders foreign key (order_id) references orders (id)
);