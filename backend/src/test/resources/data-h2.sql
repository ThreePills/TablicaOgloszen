delete from offer;
delete from contact;
delete from localization;

INSERT INTO contact (id, email, name, phone_number) VALUES (1, 'test1@mail.com', 'Test1', 1234);
INSERT INTO contact (id, email, name, phone_number) VALUES (2, 'test2@mail.com', 'Test2', 1234);
INSERT INTO contact (id, email, name, phone_number) VALUES (3, 'test3@mail.com', 'Test3', 1234);

INSERT INTO localization (id, country, localization_name, region, zip_code) VALUES (1, 'country1', 'localization1', 'region1', '58-120');
INSERT INTO localization (id, country, localization_name, region, zip_code) VALUES (2, 'country2', 'localization2', 'region2', '58-120');
INSERT INTO localization (id, country, localization_name, region, zip_code) VALUES (3, 'country3', 'localization3', 'region3', '58-120');

INSERT INTO offer (id, content, is_active, title, contact_id, localization_id) VALUES (1, 'sprzedam sprzedam', true, 'Sprzedam 1', 1, 1);
INSERT INTO offer (id, content, is_active, title, contact_id, localization_id) VALUES (2, 'sprzedam szybko', true, 'Sprzedam szybki test', 1, 3);
INSERT INTO offer (id, content, is_active, title, contact_id, localization_id) VALUES (3, 'sprzedam test', true, 'Sprzedam sprzedam tytuł', 2, 1);
INSERT INTO offer (id, content, is_active, title, contact_id, localization_id) VALUES (4, 'Sell test', true, 'Sprzedam 4', 3,3);
INSERT INTO offer (id, content, is_active, title, contact_id, localization_id) VALUES (5, 'Sprzedam auto', true, 'Sprzedam auto za darmo', 1, 2);
INSERT INTO offer (id, content, is_active, title, contact_id, localization_id) VALUES (6, 'Kupię psa', false, 'Kupiłem', 1, 2);
INSERT INTO offer (id, content, is_active, title, contact_id, localization_id) VALUES (7, 'Wynajmę mieszkanie', false, 'Wynajęte mieszkanie', 2, 1);
commit;
alter sequence contact_seq restart with 4;
alter sequence offer_seq restart with 8;
