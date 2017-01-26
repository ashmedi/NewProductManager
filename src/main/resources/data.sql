insert into productcategory (description, name) values ('movies full of action', 'movies'); /
insert into productcategory (description, name) values ('food for geeks', 'games'); /
insert into product (currency, name, price, category_id) values ('USD', 'Scary Movie 66', 13, (select id from productcategory where name = 'actionmovies')); /
insert into product (currency, name, price, category_id) values ('USD', 'Rambo 7', 10, (select id from productcategory where name = 'movies')); /
insert into product (currency, name, price, category_id) values ('EUR', 'Terminator 18', 66, (select id from productcategory where name = 'movies')); /
insert into product (currency, name, price, category_id) values ('PLN', 'Tomb Raider', 333, (select id from productcategory where name = 'games')); /
insert into product (currency, name, price, category_id) values ('PLN', 'Snake 4D', 250, (select id from productcategory where name = 'games')); /
insert into product (currency, name, price, category_id) values ('PLN', 'Tapeworms', 19, (select id from productcategory where name = 'games')); /