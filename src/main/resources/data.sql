-- Country
insert into country(country_id, name)
values(1,'Ukraine');

insert into country(country_id, name)
values(2,'Russia');

insert into country(country_id, name)
values(3,'Belarus');

-- Guest
insert into guest(guest_id, first_name, middle_name, second_name, address, phone, country_id)
values(1, 'Ivan', 'Ivanovich', 'Ivanov', 'ul. Kosmonavtov 35-1', '+380635044213', 1);

insert into guest(guest_id, first_name, middle_name, second_name, address, phone, country_id)
values(2, 'Petr', 'Petrovich', 'Petrov', 'ul. Lesnaya 12-21', '+380635044214', 2);

insert into guest(guest_id, first_name, middle_name, second_name, address, phone, country_id)
values(3, 'Oleksandr', 'Oleksandrovich', 'Ivanov', 'ul. Lenina 12-7', '+380635044215', 3);

-- Room type
insert into room_type(room_type_id, name)
values(1, 'Single');

insert into room_type(room_type_id, name)
values(2, 'Double');

insert into room_type(room_type_id, name)
values(3, 'Triple');

insert into room_type(room_type_id, name)
values(4, 'Queen');

-- Room
insert  into room(room_id, floor, price_per_night, room_type_id)
values(21, 2, 800.00, 1);

insert  into room(room_id, floor, price_per_night, room_type_id)
values(22, 2, 800.00, 1);

insert  into room(room_id, floor, price_per_night, room_type_id)
values(23, 2, 800.00, 1);

insert  into room(room_id, floor, price_per_night, room_type_id)
values(31, 3, 1700.00, 2);

insert  into room(room_id, floor, price_per_night, room_type_id)
values(32, 3, 1700.00, 2);

insert  into room(room_id, floor, price_per_night, room_type_id)
values(33, 3, 1700.00, 2);

insert  into room(room_id, floor, price_per_night, room_type_id)
values(41, 4, 2500.00, 3);

insert  into room(room_id, floor, price_per_night, room_type_id)
values(42, 4, 2500.00, 3);

insert  into room(room_id, floor, price_per_night, room_type_id)
values(43, 4, 2500.00, 3);

insert  into room(room_id, floor, price_per_night, room_type_id)
values(51, 5, 4000.00, 4);

-- Room status
insert into room_status(room_status_id, name)
values(0, 'FREE');

insert into room_status(room_status_id, name)
values(1, 'BOOKED');

insert into room_status(room_status_id, name)
values(2, 'CHECKED_IN');

-- Reception
insert into reception (reception_id, period_from, period_to, room_status_id, guest_id, room_id)
values(1, TO_DATE ('2018-09-17 00:00:00.00','yyyy-MM-dd hh:mm:ss.S'), TO_DATE ('2018-09-30 23:59:59.69','yyyy-MM-dd hh:mm:ss.S'), 1, 1, 21);

insert into reception (reception_id, period_from, period_to, room_status_id, guest_id, room_id)
values(2, TO_DATE ('2018-09-22 00:00:00.00','yyyy-MM-dd hh:mm:ss.S'), TO_DATE ('2018-09-25 23:59:59.69','yyyy-MM-dd hh:mm:ss.S'), 1, 2, 32);

insert into reception (reception_id, period_from, period_to, room_status_id, guest_id, room_id)
values(3, TO_DATE ('2018-09-01 00:00:00.00','yyyy-MM-dd hh:mm:ss.S'), TO_DATE ('2018-09-02 23:59:59.69','yyyy-MM-dd hh:mm:ss.S'), 1, 3, 22);

insert into reception (reception_id, period_from, period_to, room_status_id, guest_id, room_id)
values(4, TO_DATE ('2018-04-17 00:00:00.00','yyyy-MM-dd hh:mm:ss.S'), TO_DATE ('2018-04-25 23:59:59.69','yyyy-MM-dd hh:mm:ss.S'), 2, 1, 51);

insert into reception (reception_id, period_from, period_to, room_status_id, guest_id, room_id)
values(5, TO_DATE ('2018-05-17 00:00:00.00','yyyy-MM-dd hh:mm:ss.S'), TO_DATE ('2018-05-18 23:59:59.69','yyyy-MM-dd hh:mm:ss.S'), 2, 2, 43);