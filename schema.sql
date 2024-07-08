create table users
(
    id                serial8,
    role              int2    not null,
    login             varchar not null,
    password          varchar not null,
    name              varchar not null,
    surname           varchar not null,
    registration_date date    not null,
    primary key (id)
);



create table products
(
    id    serial8,
    name  varchar not null,
    price int4    not null,
    primary key (id)
);

create table orders
(
    id         serial8,
    user_id    int8    not null,
    status     int2    not null,
    address    varchar not null,
    order_date date    not null,
    primary key (id),
    foreign key (user_id) references users (id)
);

create table orders_products
(
    id         serial8,
    order_id   int8 not null,
    product_id int8 not null,
    number     int2 not null,
    primary key (id),
    foreign key (order_id) references orders (id),
    foreign key (product_id) references products (id)
);

create table file_info
(
    id            serial8,
    name          varchar not null,
    size          int8    not null,
    key           varchar not null,
    creation_date date    not null
);