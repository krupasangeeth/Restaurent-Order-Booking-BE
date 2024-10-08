INSERT INTO menu_item (menu_item_id,price,category,name) values (10001,250,'VEG','Veg Biryani');
INSERT INTO menu_item (menu_item_id,price,category,name) values (10002,250,'VEG','Veg Pulav');
INSERT INTO menu_item (menu_item_id,price,category,name) values (3,350,'NON_VEG','Chicken Biryani');
INSERT INTO menu_item (menu_item_id,price,category,name) values (4,450,'NON_VEG','Mutton Biryani');
INSERT INTO menu_item (menu_item_id,price,category,name) values (5,550,'NON_VEG','Prwans Biryani');
INSERT INTO menu_item (menu_item_id,price,category,name) values (6,250,'NON_VEG','Fish Biryani');
INSERT INTO menu_item (menu_item_id,price,category,name) values (7,850,'NON_VEG','Crab Biryani');
INSERT INTO menu_item (menu_item_id,price,category,name) values (8,50,'NON_VEG','Dog Biryani');

INSERT INTO USER_ROLE (ROLE_ID,ROLE) Values (10001,'ADMIN')
INSERT INTO USER_ROLE (ROLE_ID,ROLE) Values (10002,'USER')

insert into users (user_id,mobile, role_id) values (20999 ,8499858395, 10001)
