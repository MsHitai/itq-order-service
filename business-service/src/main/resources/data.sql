insert into orders (client_name, address, amount, created)
values ('Ivan Ivanov', 'Nizhny Novgorod', '1', current_timestamp),
       ('Petya Petrov', 'Moscow', '4', current_timestamp);

insert into details (serial_number, name, quantity, order_id)
values ('123239832983', 'table', 1, 1),
       ('23982938932832', 'chair', 4, 2);