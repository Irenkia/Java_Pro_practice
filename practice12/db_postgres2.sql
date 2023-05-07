CREATE TABLE user(
                      user_id SERIAL primary key,
                      name varchar(10) NOT NULL,
                      surname varchar(20) NOT NULL,
                      phone varchar(25),
                      gender varchar(10) NOT NULL
);

CREATE TABLE device(
                        device_id SERIAL PRIMARY KEY,
                        user_id int,
                        CONSTRAINT fk_user
                            FOREIGN KEY(user_id)
                                REFERENCES users(user_id),
                        name varchar(20) NOT NULL,
                        macaddr varchar(20) NOT NULL unique
);

INSERT INTO user
VALUES(1,'Иван','Иванов','(+38)-063-111-1232','male'),
      (2,'Пётр','Петров','(+38)-093-221-2234','male'),
      (3,'Ольга','Ткач','(+38)-099-321-5235','female'),
      (4,'Дмитрий','Сидоров','(+48)-793-221-234','male'),
      (5,'Елена','Полякова','(+38)-066-341-7231','female'),
      (6,'Нина','Новикова','(+48)-566-541-723','female'),
      (7,'Иван','Попов','(+38)-099-221-3234','male');


INSERT INTO device (device_id, user_id, name, macaddr)
VALUES
(1,7,'Nokia 3310','00-00-0c-60-8b-41'),
(2,1,'Motorola RAZR V3','00-60-97-4b-bf-4c'),
(3,6,'Nokia 2600','00-10-4b-49-94-e1'),
(4,5,'iPhone 5','00-80-5f-d8-a4-8b'),
(5,7,'Nokia 1200','00-a0-d1-02-a4-cf'),
(6,4,'Samsung E1100','00-60-08-75-0d-07a'),
(7,3,'iPhone 7','00-10-4b-44-e4-73'),
(8,4,'Nokia 6600R','00-10-4b-44-d6-33'),
(9,1,'iPhone XR','00-10-4b-4e-67-6a'),
(10,2,'iPhone 11','00-60-97-4b-c4-53');

SELECT * FROM user;
SELECT * FROM device;

SELECT * FROM user ORDER BY name ASC;
SELECT * FROM user WHERE name='Иван';

-- INSERT INTO user
-- VALUES(100,'Маргарита','Алиева','(+38)-063-144-1631','female'),
--       (101,'Светлана','Алтухова','(+38)-066-534-7651','female');


-- SELECT * FROM user WHERE user_id BETWEEN 0 AND 100;
-- SELECT * FROM user WHERE phone LIKE '(+38)%';
-- SELECT MAX(user_id) FROM users;

-- DELETE FROM user WHERE (user_id)>=100;
-- SELECT * FROM user;
--
-- SELECT * FROM device ORDER BY user_id asc;

-- UPDATE device SET macaddr = '00-60-08-75-0d-07' WHERE device_id = 6;
-- SELECT * FROM device;

-- SELECT
-- user.user_id AS id,
-- user.name as user_name,
-- user.surname as sur,
-- user.phone as phon_numb,
-- user.gender as gender,
-- device.name as phone_name,
-- device.macaddr as macaddress
-- FROM
-- user
-- JOIN
-- device
-- ON user.user_id = device.user_id
-- ORDER BY user.surname;

-- INSERT INTO device (device_id, user_id, name, macaddr)
-- VALUES
-- (11,7,'iPhone XS','00-10-4b-44-eb-ae'),
-- (12,4,'iPhone XS Max','00-10-4b-49-7b-7f'),
-- (13,4,'Nokia 6600','00-00-f8-21-7a-7f'),
-- (14,4,'iPhone 5','00-00-20-88-82-57'),
-- (15,5,'Nokia 5230','08-80-5f-88-d0-55');

-- SELECT * FROM device;
-- SELECT * FROM device ORDER BY user_id asc;

-- SELECT
-- user.user_id AS id,
-- user.name as user_name,
-- user.surname as sur,
-- user.phone as phon_numb,
-- user.gender as gender,
-- device.name as phone_name,
-- device.macaddr as macaddress
-- FROM
-- user
-- JOIN
-- device
-- ON user.user_id = devices.user_id
-- ORDER BY user.name;











