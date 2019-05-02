
create database if not exists jdbc_parcial2;

use jdbc_parcial2;

/*
 private int Id;
    private String Name;
    private String ImageURL;
    private double Price;

*/

create 
	table if not exists jdbc_parcial2.persona (
		id int auto_increment primary key,
		name varchar(100) not null,
		lastname varchar(200) not null,
		email varchar(100) not null,
		programming_language varchar(50) not null,
		hobbies varchar(1000) not null
);

/*
Product product2 = new Product(2, "Queso Campesino Alpina", "https://images.rappi.com/products/599875-1534181942.png?d=150x150&e=webp", 5850);
Product product3 = new Product(3, "Jamon de Cerdo Pietran", "https://images.rappi.com/products/342208-1532483068.png?d=150x150&e=webp", 7050);
*/

insert into jdbc_parcial2.persona (name, lastname, email, programming_language, hobbies) 
values ( "Roberto", "Batty", "rober19@vsce.com", "JAVASCRIPT", "PROGRAMAR;TRABAJAR;MONTAR BICICLETA;CORRER"
);
 
 
 
 select * from jdbc_parcial2.persona;

