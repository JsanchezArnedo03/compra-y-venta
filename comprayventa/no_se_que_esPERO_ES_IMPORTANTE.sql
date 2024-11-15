delimiter &&
create procedure informe_venta_ganancia(documento_empleado varchar(25),tipo_transaccion int)
begin
declare ganancia double;
if tipo_transaccion = 1 then
SELECT p.marca, 
       p.precioCompra AS precio_compra,
       COUNT(df.cantidad) AS cantidad_productos, 
       tpt.tipoTransaccion
FROM Detalles_factura df 
INNER JOIN productos p ON df.id_producto = p.id_producto 
INNER JOIN tipoTransaccion tpt ON df.tipoTransaccion = tpt.idTransaccion 
WHERE tpt.idTransaccion = tipo_transaccion
GROUP BY p.marca, p.precioCompra, tpt.tipoTransaccion;

end if ;
if tipo_transaccion = 2 then
SELECT p.marca, 
       p.precioCompra AS precio_compra,
       p.precioVenta as precio_venta,
       COUNT(df.cantidad) AS cantidad_productos
FROM Detalles_factura df 
INNER JOIN productos p ON df.id_producto = p.id_producto 
INNER JOIN tipoTransaccion tpt ON df.tipoTransaccion = tpt.idTransaccion 
WHERE tpt.idTransaccion = tipo_transaccion
GROUP BY p.marca, p.precioCompra,p.precioVenta;

select (p.precioVenta-p.precioCompra)'Ganancia' from detalles_factura df inner join productos p on df.id_producto = p.id_producto 
inner join empleado e on df.id_empleado = e.idEmpleado where e.documento = documento_empleado and df.tipoTransaccion=tipo_transaccion;

end if;
end;&&

create procedure ganancia(P_documento varchar(50),tipo_transaccion int)
begin
declare ganancia int;
if tipo_transaccion !=2 then
set ganancia = 0;
end if;
if tipo_transaccion =2  then
select (p.precioVenta-p.precioCompra)'Ganancia' from detalles_factura df inner join productos p on df.id_producto = p.id_producto 
inner join empleado e on df.id_empleado = e.idEmpleado where e.documento = P_documento and df.tipoTransaccion=tipo_transaccion;
end if;
end;
&&

call informe_venta_ganancia(1082832536,2);