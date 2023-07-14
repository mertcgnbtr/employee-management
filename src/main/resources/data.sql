create table if not exists mt_employee
(
    id            varchar(36)  PRIMARY KEY,
    address       varchar(255) not null,
    date_of_birth date         not null,
    gender        int2         not null,
    name          varchar(50)
);


TRUNCATE TABLE public.mt_employee;

INSERT INTO public.mt_employee (id,address, date_of_birth, gender, name) VALUES ('3d296852-2236-11ee-be56-0242ac120002','Hollanda', '2023-07-12 14:21:47.429000', 1, 'Çınar');
INSERT INTO public.mt_employee (id,address, date_of_birth, gender, name) VALUES ('43696046-2236-11ee-be56-0242ac120002','123 Main St', '2023-07-12 12:12:13.064000', 1, 'John Doe');
INSERT INTO public.mt_employee (id,address, date_of_birth, gender, name) VALUES ('47ad46d6-2236-11ee-be56-0242ac120002','456 Elm St', '2023-07-12 12:12:13.064000', 2, 'Jane Smith');
INSERT INTO public.mt_employee (id,address, date_of_birth, gender, name) VALUES ('4baec0e8-2236-11ee-be56-0242ac120002','789 Oak St', '2023-07-12 12:12:13.064000', 1, 'Michael Johnson');
INSERT INTO public.mt_employee (id,address, date_of_birth, gender, name) VALUES ('4f67d8aa-2236-11ee-be56-0242ac120002','789 Oak St', '2023-07-12 15:17:47.000000', 2, 'İlknur Günbo');
INSERT INTO public.mt_employee (id,address, date_of_birth, gender, name) VALUES ('5650f37c-2236-11ee-be56-0242ac120002','789 Oak St', '2023-07-12 15:18:09.000000', 1, 'Halit Günbo');
