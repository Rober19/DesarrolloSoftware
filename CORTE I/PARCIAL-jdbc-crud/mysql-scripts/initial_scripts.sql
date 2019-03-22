
create database if not exists jsp_react_project;

use jsp_react_project;

/*
 private int Id;
    private String Name;
    private String ImageURL;
    private double Price;

*/

create 
	table if not exists jsp_react_project.products (
		id int auto_increment primary key,
		Name varchar(100) not null,
		imageurl varchar(2000) not null,
		price double not null
);

/*
Product product2 = new Product(2, "Queso Campesino Alpina", "https://images.rappi.com/products/599875-1534181942.png?d=150x150&e=webp", 5850);
Product product3 = new Product(3, "Jamon de Cerdo Pietran", "https://images.rappi.com/products/342208-1532483068.png?d=150x150&e=webp", 7050);
*/

insert into jsp_react_project.products (Name, imageurl, price) 
values (
"Cocacola sin azucar", "https://images.rappi.com/products/185260-1531771841.png?d=150x150&e=webp", 1750);
 
 
 
 select * from products;

