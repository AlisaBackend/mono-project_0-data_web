-- create table userstest
-- (
-- 	id int, -- первое поле id
-- 	name varchar(128), -- второе поле с типом varchar и размер 128 
-- 	email VARCHAR(128)
-- );

-- INSERT INTO userstest (id, name, email, password, role)
-- VALUES (1, 'java core', 'qwet@mail.ru', '1111', 'ROLE_USER'),
-- 	   (2, 'java enterprise', 'qwewt@mail.ru', '1111', 'ROLE_USER'),
-- 	   (3, 'java', 'qwlet@mail.ru', '1111', 'ROLE_USER'),
-- 	   (4, 'java developer', 'q2wet@mail.ru', '1111', 'ROLE_USER'),
-- 	   (5, 'javav', 'qwemt@mail.ru', '1111', 'ROLE_USER');


-- ALTER TABLE userstest
--     ADD COLUMN IF NOT EXISTS password VARCHAR(30);

-- ALTER TABLE userstest
--     ADD COLUMN IF NOT EXISTS role VARCHAR(30) DEFAULT 'ROLE_USER';

-- UPDATE userstest SET password = '1111' WHERE id = 1;
-- UPDATE userstest SET password = '1111' WHERE id = 2;
-- UPDATE userstest SET password = '1111' WHERE id = 3;
-- UPDATE userstest SET password = '1111' WHERE id = 4;
-- UPDATE userstest SET password = '1111' WHERE id = 5;

-- DELETE FROM userstest
-- WHERE id IN (1, 2, 4);