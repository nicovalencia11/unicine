--insert usuarios
insert into usuario values (1,"nicovalencia11","nico123",1);
insert into usuario values (2,"juan","juan123",1);
insert into usuario values (3,"camilo","cami123",1);
insert into usuario values (4,"pepe","pepe123",1);
insert into usuario values (5,"oscar","oscar123",1);
insert into usuario values (6, "esteban", "esteban123", 2);
insert into usuario values (7, "daniel", "daniel123", 2);
insert into usuario values (8, "sandra", "sandra123", 2);
insert into usuario values (9, "martha", "martha123", 2);


--insert clientes
insert into cliente values (1,"1094970200","nicolasvalenciamadrid@gmail.com", 1,"ruta","Nicolas valencia madrid",1);
insert into cliente values (2,"123","juan@gmail.com", 1,"ruta","juan",2);
insert into cliente values (3,"1234","camilo@gmail.com", 1,"ruta","camilo",3);
insert into cliente values (4,"12345","pepe@gmail.com", 1,"ruta","pepe",4);
insert into cliente values (5,"123456","oscar@gmail.com", 1,"ruta","oscar",5);

-- insert empleados
insert into empleado values (1, "101011857", "estola2010@hotmail.com", "Esteban", 6);
insert into empleado values (2, "113445577", "correoprueba1@gmail.com", "Daniel", 7);
insert into empleado values (3, "55555", "correoprueba2@gmail.com", "Sandra", 8);
insert into empleado values (4, "54544646", "correpureba3@gmail.com", "Martha", 9);




--insert ciudades
insert into ciudad values (1, "Armenia");
insert into ciudad values (2, "Pereira");
insert into ciudad values (3, "Manizales");
insert into ciudad values (4, "Cali");
insert into ciudad values (5, "Bogota");


--insert teatros
insert into teatro values (1, "centro comercial unicentro piso 3", "unicentro armenia" , "22151224",1);
insert into teatro values (2, "centro comercial unicentro piso 2", "unicentro pereira" , "22151224",2);
insert into teatro values (3, "centro comercial unicentro piso 3", "unicentro manizales" , "22151224",3);
insert into teatro values (4, "centro comercial unicentro piso 4", "unicentro cali" , "22151224",4);
insert into teatro values (5, "centro comercial unicentro piso 5", "unicentro bogota" , "22151224",5);


--insert sala
insert into sala values (1, "SALA 1", "{}" ,1);
insert into sala values (2, "SALA 2", "{}" ,1);
insert into sala values (3, "SALA 3", "{}",1);
insert into sala values (4, "SALA 4", "{}" , 1);
insert into sala values (5, "SALA 5", "{}" ,1);


-- insert peliculas
insert into pelicula values (1, 0, 0, 2, "RUTAIMAGEN", "HARRY POTTER", "lorem lorem lorem ", "lorem lorem lorem ", "RUTATRAILER");
insert into pelicula values (2, 0, 0, 2, "RUTAIMAGEN", "RAPIDOS Y FURIOSOS", "lorem lorem lorem ", "lorem lorem lorem ", "RUTATRAILER");
insert into pelicula values (3, 0, 0, 2, "RUTAIMAGEN", "EL CONJURO", "lorem lorem lorem ", "lorem lorem lorem ", "RUTATRAILER");
insert into pelicula values (4, 0, 0, 2, "RUTAIMAGEN", "LA MONJA", "lorem lorem lorem ", "lorem lorem lorem ", "RUTATRAILER");
insert into pelicula values (5, 0, 0, 2, "RUTAIMAGEN", "LA CARRERA DE LA MUERTE", "lorem lorem lorem ", "lorem lorem lorem ", "RUTATRAILER");


-- insert generospeliduclas
insert into pelicula_generos values (1,1);
insert into pelicula_generos values (2,1);
insert into pelicula_generos values (3,1);
insert into pelicula_generos values (4,1);
insert into pelicula_generos values (5,1);


-- insert funciones
insert into funcion values (1, 9000, 1,1);
insert into funcion values (2, 9000, 2,2);
insert into funcion values (3, 9000, 3,3);
insert into funcion values (4, 9000, 4,4);
insert into funcion values (5, 9000, 5,5);


-- insert horario_funcion
insert into horario_funcion values (1, "{}", '2022-10-10 17:30:00', 1);
insert into horario_funcion values (2, "{}", '2022-10-10 17:30:00', 2);
insert into horario_funcion values (3, "{}", '2022-10-10 17:30:00', 3);
insert into horario_funcion values (4, "{}", '2022-10-10 17:30:00', 4);
insert into horario_funcion values (5, "{}", '2022-10-10 17:30:00', 5);


-- insert cupon
insert into cupon values (1, "cupon descuento 1", "20% de descuento para nuevo clientes", 0.2, 0, '2022-10-31');
insert into cupon values (2, "cupon descuento 2", "10% de descuento para empleados edeq", 0.1, 0, '2022-10-31');
insert into cupon values (3, "cupon descuento 3", "15% de descuento para ni??os menores de edad", 0.15, 0, '2022-10-31');
insert into cupon values (4, "cupon descuento 4", "30% de descuento para adultos mayores de 50", 0.3, 0, '2022-10-31');
insert into cupon values (5, "cupon descuento 6", "10% de descuento para clientes antiguos", 0.1, 0, '2022-10-31');


-- insert cupon clientes
insert into cupon_clientes values (1, 1);
insert into cupon_clientes values (1, 2);
insert into cupon_clientes values (1, 3);
insert into cupon_clientes values (1, 4);
insert into cupon_clientes values (1, 5);


-- insert venta
insert into venta values (1, '2022-10-10 17:30:00', 1, 50000, 1, 1, 1);
insert into venta values (2, '2022-10-10 17:30:00', 1, 50000, 2, 2, 2);
insert into venta values (3, '2022-10-10 17:30:00', 1, 50000, 3, 3, 3);
insert into venta values (4, '2022-10-10 17:30:00', 1, 50000, 4, 4, 4);
insert into venta values (5, '2022-10-10 17:30:00', 1, 50000, 5, 5, 5);


-- insert confiteria
insert into confiteria values (1, 0, 0, "combo de cripetas peque??a con gaseosa peque??a", "RUTAIMAGEN", "COMBO 1", 25000);
insert into confiteria values (2, 0, 0, "combo de cripetas pequ??a con gaseosa peque??a y perro", "RUTAIMAGEN", "COMBO 2", 29000);
insert into confiteria values (3, 0, 0, "combo de perro con gaseosa peque??a", "RUTAIMAGEN", "COMBO 3", 20000);
insert into confiteria values (4, 0, 0, "combo de cripetas mediana con gaseosa mediana", "RUTAIMAGEN", "COMBO 4", 35000);
insert into confiteria values (5, 0, 0, "combo de cripetas grande con gaseosa grande", "RUTAIMAGEN", "COMBO 5", 40000);


-- insert venta confiteria
insert into detalle_venta_confiteria values (1, 2, 1, 1);
insert into detalle_venta_confiteria values (2, 1, 2, 1);
insert into detalle_venta_confiteria values (3, 3, 2, 2);
insert into detalle_venta_confiteria values (4, 1, 3, 3);
insert into detalle_venta_confiteria values (5, 1, 4, 4);


-- insert entradas
insert into entrada values (1, 3, 9, 1);
insert into entrada values (2, 3, 10, 1);
insert into entrada values (3, 3, 11, 1);
insert into entrada values (4, 5, 9, 2);
insert into entrada values (5, 5, 10, 2);
insert into entrada values (6, 5, 11, 2);
insert into entrada values (7, 3, 9, 3);
insert into entrada values (8, 3, 10, 3);
insert into entrada values (9, 3, 11, 3);
