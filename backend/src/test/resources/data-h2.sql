delete from offer;
delete from contact;
delete from localization;

INSERT INTO contact (id, email, name, phone_number, hash_value)
VALUES (1, 'test1@mail.com', 'Test1', 1234, 11111);
INSERT INTO contact (id, email, name, phone_number, hash_value)
VALUES (2, 'test2@mail.com', 'Test2', 1234, 99598723);
INSERT INTO contact (id, email, name, phone_number, hash_value)
VALUES (3, 'test3@mail.com', 'Test3', 1234, 33333);

INSERT INTO localization (id, country, localization_name, region, zip_code,
                          hash_value)
VALUES (1, 'country1', 'localization1', 'region1', '58-120', 44444);
INSERT INTO localization (id, country, localization_name, region, zip_code,
                          hash_value)
VALUES (2, 'country2', 'localization2', 'region2', '58-120', 55555);
INSERT INTO localization (id, country, localization_name, region, zip_code,
                          hash_value)
VALUES (3, 'country3', 'localization3', 'region3', '58-120', 66666);

INSERT INTO offer (id, content, is_active, title, contact_id, localization_id,
                   hash_value)
VALUES (1, 'sprzedam sprzedam', true, 'Sprzedam 1', 1, 1, 11119);
INSERT INTO offer (id, content, is_active, title, contact_id, localization_id,
                   hash_value)
VALUES (2, 'sprzedam szybko', true, 'Sprzedam szybki test', 1, 3, 11118);
INSERT INTO offer (id, content, is_active, title, contact_id, localization_id,
                   hash_value)
VALUES (3, 'sprzedam test', true, 'Sprzedam sprzedam tytuł', 2, 1, 11117);
INSERT INTO offer (id, content, is_active, title, contact_id, localization_id,
                   hash_value)
VALUES (4, 'Sell test', true, 'Sprzedam 4', 3, 3, 11116);
INSERT INTO offer (id, content, is_active, title, contact_id, localization_id,
                   hash_value)
VALUES (5, 'Sprzedam auto', true, 'Sprzedam auto za darmo', 1, 2, 11115);
INSERT INTO offer (id, content, is_active, title, contact_id, localization_id,
                   hash_value)
VALUES (6, 'Kupię psa', false, 'Kupiłem', 1, 2, 11114);
INSERT INTO offer (id, content, is_active, title, contact_id, localization_id,
                   hash_value)
VALUES (7, 'Wynajmę mieszkanie', false, 'Wynajęte mieszkanie', 2, 1, 11113);
commit;
alter sequence ID_SEQ restart with 10;
