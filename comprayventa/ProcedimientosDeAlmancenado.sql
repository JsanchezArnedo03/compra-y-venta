/*PROCEDIMIENTOS DE ALMACENADO*/
delimiter //
//
/*INGRESO Y VALIDACION AL SISTEMA*/
create procedure login(Pusername nvarchar(500),Ppsw nvarchar(500))
begin
select l.username,l.psw,l.cargoFK,e.idEmpleado from login l 
inner join empleado e on l.empleadoFK = e.idEmpleado where l.username = Pusername and l.psw =Ppsw;
end;//
//
call login('juan',10);
create procedure CargarComboCargo()
begin
SELECT nombre FROM comprayventa.cargo;
end;
//
create procedure comboTipoDocumento()
begin
SELECT nombre FROM comprayventa.tipodocumento;
end;//
create procedure ComboMarcas()
begin
SELECT nombre FROM comprayventa.marcas;
end;
//create procedure ComboModelo()
begin
SELECT modelo FROM comprayventa.modelo;
end;//
create procedure listado_tipo_transaccion()
begin
SELECT tipoTransaccion FROM tipoTransaccion;
end;//
/*PROCEDIMIENTO PARA CREAR EMPLEADOS*/
create procedure crearEmpleado(documento VARCHAR(50),
    primerNombre NVARCHAR(500) ,
    segundoNombre NVARCHAR(500),
    primerApellido NVARCHAR(500),
    segundoApellido NVARCHAR(500),
    telefono NVARCHAR(15),
    email NVARCHAR(500),
    cargoFK INT,
    estado BOOLEAN)
begin
insert into empleado(documento, primerNombre, segundoNombre, primerApellido, segundoApellido, telefono, email, cargoFK, estado) 
values(documento, primerNombre, segundoNombre, primerApellido, segundoApellido, telefono, email, cargoFK, estado);
end;
//
call crearEmpleado('154','as','as','as','as','314555','jssas',2,true);
//
/*PROCEDIMIENTO PARA CREAR CLIENTES*/
create procedure crearCliente(documento VARCHAR(50),
    primerNombre NVARCHAR(500) ,
    segundoNombre NVARCHAR(500),
    primerApellido NVARCHAR(500),
    segundoApellido NVARCHAR(500),
    telefono NVARCHAR(15),
    email NVARCHAR(500))
begin
insert into cliente(documentoIdentidad, primerNombre, segundoNombre, primerApellido, segundoApellido, telefono, email) 
values(documento, primerNombre, segundoNombre, primerApellido, segundoApellido, telefono, email);
end;
//
/*PROCEDIMIENTO PARA CREAR LA FACTURA DE VENTA*/
create procedure crearFacturaVenta (id_empleado int,fechaMoviento date, id_producto int, cantidad int, tipoTransaccion int, clienteFK int)
begin
insert into Detalles_factura (id_empleado, fechaMoviento, id_producto, cantidad, tipoTransaccion, clienteFK)
values(id_empleado, fechaMoviento, id_producto, cantidad, tipoTransaccion, clienteFK);
end;//
/*PROCEDIMIENTO PARA CREAR FACTURA DE COMPRA*/
create procedure crearFacturaCompra (id_empleado int,fechaMoviento date, id_producto int,cantidad int, tipoTransaccion int,cliente int)
begin
insert into Detalles_factura (id_empleado, fechaMoviento, id_producto, cantidad, tipoTransaccion, clienteFK)
values(id_empleado, fechaMoviento, id_producto, cantidad, tipoTransaccion,clienteFK);
end;//
//
create procedure detalle_factura(P_id_empleado int, P_fechaMoviento date, P_id_producto int, P_cantidad int, P_tipoTransaccion int, P_clienteFK int)
begin
insert into Detalles_factura (id_empleado, fechaMoviento, id_producto, cantidad, tipoTransaccion, clienteFK) 
values(P_id_empleado , P_fechaMoviento , P_id_producto , P_cantidad , P_tipoTransaccion , P_clienteFK );

end;//
//

/*PROCEDIMIENTO SOLAMENTE PARA BUSCAR POR VENDEDOR (VENTA)*/
create procedure informeXVendedor(docVendedor nvarchar(20))
begin
select CONCAT(e.primerNombre,e.segundoNombre,e.primerApellido,e.segundoApellido),
p.marca,p.modelo,p.precioVenta,df.fechaMoviento from detalles_factura df inner join productos p on df.id_producto = p.id_producto
inner join empleado e on df.id_empleado = e.idEmpleado where e.documento = docVendedor;
end;
//

create procedure informeXfechas(documento_vendedor varchar(50),P_tipo_transaccion int,fecha1 date,fecha2 date)
begin
select 
concat(e.primerNombre,' ',e.segundoNombre,' ',e.primerApellido,' ',e.segundoApellido)'vendedor',
concat(c.primerNombre,' ',c.segundoNombre,' ',c.primerApellido,' ',c.segundoApellido)'cliente',
p.marca,p.modelo,tp.tipoTransaccion,p.precioCompra,p.precioVenta,df.fechaMoviento
from detalles_factura df
inner join empleado e on df.id_empleado = e.idEmpleado 
inner join cliente c on df.clienteFK = c.idCliente
inner join productos p on df.id_producto = p.id_producto
inner join tipoTransaccion tp on df.tipoTransaccion = tp.idTransaccion 
where df.fechaMoviento between fecha1 and fecha2 and e.documento = documento_vendedor and df.tipoTransaccion = P_tipo_transaccion;
end//
call informeXfechas('1082832536',1,'2024-03-01','2024-05-30');
//create procedure crearVehiculo(P_marca VARCHAR(100),P_modelo varchar(200),P_placa varchar(6),P_descripcion TEXT,P_precio float,P_precioVenta float,P_estado int)
begin
insert into Productos (marca,modelo,placa,descripcion,precioCompra,precioVenta,estado) values(P_marca,P_modelo,P_placa,P_descripcion,P_precio,P_precioVenta,P_estado);
end;//
//create procedure validarExistencia(P_documento nvarchar(15))
begin
SELECT idCliente,documentoIdentidad,concat(primerNombre," ",segundoNombre," ",primerApellido," ",segundoApellido),
email,telefono 
FROM cliente where documentoIdentidad = P_documento;
end;//
create procedure cargarListados()
begin
SELECT documentoIdentidad,CONCAT(primerNombre," ",segundoNombre," ",primerApellido," ",segundoApellido),email,telefono FROM CLIENTE;
end;//
//

//
create procedure ganancia_general(id_empleado int)
begin
select (p.precioVenta-p.precioCompra)'Ganancia_general'
 from detalles_factura df inner join productos p on df.id_producto = p.id_producto
 inner join empleado e on e.idEmpleado = df.id_empleado
inner join tipoTransaccion tpt on df.tipoTransaccion = tpt.idTransaccion 
where tpt.idTransaccion = 2 and e.idEmpleado = id_empleado;
end;//

create procedure informe_transaccional_vendedor(id_empleado int,fecha1 date,fecha2 date)
begin
SELECT 
concat(e.primerNombre," ",e.segundoNombre," ",e.primerApellido," ",e.segundoApellido)'empleado',
concat(c.primerNombre," ",c.segundoNombre," ",c.primerApellido," ",c.segundoApellido)'cliente',
p.marca,p.modelo,tpt.tipoTransaccion,p.precioCompra,p.precioVenta,df.fechaMoviento from detalles_factura df 
inner join empleado e on df.id_empleado = e.idEmpleado
inner join cliente c on df.clienteFK = c.idCliente
inner join productos p on df.id_producto = p.id_producto
inner join tipotransaccion tpt on df.tipoTransaccion = tpt.idTransaccion where e.idEmpleado = id_empleado and df.tipoTransaccion = tipo_transaccion 
and df.fechaMoviento between fecha1 and fecha2;
end;//
//
create procedure listado_vehiculos()
begin
SELECT * FROM PRODUCTOS where estado !=2;
end;//
call listado_vehiculos();
//
create procedure validar_existencia_vehiculo(placa varchar(6))
begin
select id_producto from productos where placa = placa;
end;//
//
create procedure informeGeneral()
begin
SELECT 
concat(e.primerNombre," ",e.segundoNombre," ",e.primerApellido," ",e.segundoApellido)'empleado',
concat(c.primerNombre," ",c.segundoNombre," ",c.primerApellido," ",c.segundoApellido)'cliente',
p.marca,p.modelo,tpt.tipoTransaccion,p.precioCompra,p.precioVenta,df.fechaMoviento from detalles_factura df 
inner join empleado e on df.id_empleado = e.idEmpleado
inner join cliente c on df.clienteFK = c.idCliente
inner join productos p on df.id_producto = p.id_producto
inner join tipotransaccion tpt on df.tipoTransaccion = tpt.idTransaccion;
end;
//
drop trigger credenciales;
//
create trigger credenciales after insert on empleado
for each row begin
insert into login(username, psw,cargoFk,empleadoFK) values 
(new.documento,new.documento,new.cargoFK,new.idEmpleado);
end;
//
