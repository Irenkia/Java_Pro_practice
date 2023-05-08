CREATE TABLE users(
                      user_id Integer primary key,
                      name varchar(10) NOT NULL,
                      surname varchar(20) NOT NULL,
                      phone varchar(25),
                      gender varchar(10) NOT NULL
);

CREATE TABLE devices(
                        device_id Integer primary key,
                        user_id int PRIMARY KEY,
                        CONSTRAINT fk_user
                            FOREIGN KEY(id)
                                REFERENCES user(id),
                        name varchar(20) NOT NULL,
                        macaddr varchar(20) NOT NULL unique
);

INSERT INTO users (id, name, surname, phone, gender)
VALUES(1,'Иван','Иванов','(+38)-063-111-1232','male'),
      (2,'Пётр','Петров','(+38)-093-221-2234','male'),
      (3,'Ольга','Ткач','(+38)-099-321-5235','female'),
      (4,'Дмитрий','Сидоров','(+48)-793-221-234','male'),
      (5,'Елена','Полякова','(+38)-066-341-7231','female'),
      (6,'Нина','Новикова','(+48)-566-541-723','female'),
      (7,'Иван','Попов','(+38)-099-221-3234','male');


INSERT INTO public.devices (id,device_id, name, macaddr)
VALUES
    (1,6,'iPhone XR','00-10-4b-4e-67-6a'),
    (2,1,'Motorola RAZR V3','00-60-97-4b-bf-4c'),
    (3,7,'iPhone 7','00-10-4b-44-e4-73'),
    (4,2,'Nokia 6600R','00-10-4b-44-d6-33'),
    (5,4,'iPhone 5','00-80-5f-d8-a4-8b'),
    (6,3,'Nokia 2600','00-10-4b-49-94-e1'),
    (7,5,'Nokia 1200','00-a0-d1-02-a4-cf');










INSERT INTO devices (device_id, user_id, name, macaddr)
VALUES
(8,7,'iPhone XS','00-10-4b-44-eb-ae'),
(9,4,'Nokia 3310','00-00-0c-60-8b-41'),
(4,7,'Samsung E1100','00-60-08-75-0d-7a'),
(10,1,'iPhone XS Max','00-10-4b-49-7b-7f'),
(11,7,'Nokia 6600','00-00-f8-21-7a-7f'),
(12,2,'iPhone 5','00-00-20-88-82-57'),
(13,1,'Nokia 5230','08-80-5f-88-d0-55');








