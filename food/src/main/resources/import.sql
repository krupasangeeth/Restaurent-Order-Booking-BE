INSERT INTO menu_item (menu_item_id,price,category,name) values (10001,250,'veg','Veg Biryani');
INSERT INTO menu_item (menu_item_id,price,category,name) values (10002,250,'veg','Veg Pulav');
INSERT INTO menu_item (menu_item_id,price,category,name) values (3,350,'non-veg','Chicken Biryani');
INSERT INTO menu_item (menu_item_id,price,category,name) values (4,450,'non-veg','Mutton Biryani');
INSERT INTO menu_item (menu_item_id,price,category,name) values (5,550,'non-veg','Prwans Biryani');
INSERT INTO menu_item (menu_item_id,price,category,name) values (6,250,'non-veg','Fish Biryani');
INSERT INTO menu_item (menu_item_id,price,category,name) values (7,850,'non-veg','Crab Biryani');
INSERT INTO menu_item (menu_item_id,price,category,name) values (8,50,'non-veg','Dog Biryani');

INSERT INTO USER_ROLE (ROLE_ID,ROLE) Values (10001,'ADMIN')
INSERT INTO USER_ROLE (ROLE_ID,ROLE) Values (10002,'USER')

insert into users (mobile, role_id) values (8499858395, 10001)
