insert into productcategory (description, name) values ('movies full of action', 'actionmovies'); /
insert into product (currency, name, price, category_id) values ('USD', 'Rambo 6', 167, (select id from productcategory where name = 'actionmovies')); /
insert into product (currency, name, price, category_id) values ('USD', 'Rambo 7', 168, (select id from productcategory where name = 'actionmovies')); /
