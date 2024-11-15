/*drop database comprayventa;*/
create database comprayventa;
use comprayventa;
create table tipoEstado(
id_Estado int primary key not null auto_increment,
estado nvarchar(12)
);
insert into tipoEstado(estado) values('comprado'),('vendido');

CREATE TABLE tipoDocumento (
    idDocumento INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nombre NVARCHAR(500)
);
insert into tipoDocumento values(1,"CC");

CREATE TABLE tipoTransaccion (
    idTransaccion INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    tipoTransaccion NVARCHAR(500)
);
insert into tipoTransaccion values(1,"Compra");
insert into tipoTransaccion values(2,"Venta");
CREATE TABLE cargo (
    idCargo INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nombre NVARCHAR(500)
);
create table marcas(
idMarcas int primary key not null auto_increment,
nombre nvarchar(500) not null
);
insert into marcas(nombre)values('NISSAN');
insert into marcas (nombre)values('Toyota'),
('Ford'),('Chevrolet'),('Volkswagen'),('Honda'),('Nissan'),('BMW'),('Mercedes-Benz'),
('Audi'),('Hyundai'),('Jeep'),('Volvo'),('Lexus'),('Subaru'),('Mazda'),('Kia'),('Porsche'),
('Tesla'),('Fiat'),('Land Rover'),('Mitsubishi'),('Jaguar'),('Dodge'),('Cadillac'),('Buick'),
('GMC'),('Chrysler'),('Peugeot'),('Renault'),('Citroën'),('Opel'),('Mini'),('Alfa Romeo'),('Rolls-Royce'),
('Bentley'),('Aston Martin'),('Ferrari'),('Lamborghini'),('Maserati'),('Bugatti'),('McLaren'),('Infiniti'),
('Acura'),('Lincoln'),('Suzuki'),('Saab'),('Dacia'),('Lada'),('Tata'),('SsangYong'),('Mahindra'),('Proton'),
('Geely'),('Chery'),('Great Wall'),('BYD'),('Brilliance'),('ZAZ'),('Skoda'),('SEAT'),('Lancia'),('Daewoo'),
('Isuzu'),('Scion'),('Plymouth'),('Pontiac'),('Oldsmobile'),('Saturn'),('Hummer'),('Mercury'),('MG'),('Rover'),
('Borgward'),('NSU'),('Wartburg'),('Trabant'),('Jensen'),('DeLorean'),('Tucker'),('Packard'),('Studebaker'),('Willys'),
('Hudson'),('Nash'),('Rambler'),('Datsun'),('AMC'),('Kaiser'),('DeSoto'),('Edsel'),('Plymouth'),('Imperial'),('Eagle'),
('Hudson'),('Willys'),('NSU'),('Rover'),('Tucker'),('Borgward'),('DeLorean');

create table modelo(
id_modelo int primary key not null auto_increment,
modelo int not null
);
insert into modelo(modelo)values(2000);

insert into cargo values(1,"Admin");
insert into cargo values(2,"vendedor");
CREATE TABLE cliente (
    idCliente INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    documentoIdentidad NVARCHAR(12) not null unique,
    primerNombre NVARCHAR(500) NOT NULL,
    segundoNombre NVARCHAR(500) NOT NULL,
    primerApellido NVARCHAR(500) NOT NULL,
    segundoApellido NVARCHAR(500) NOT NULL,
    telefono NVARCHAR(15) NOT NULL,
    email NVARCHAR(500) NOT NULL
);
CREATE TABLE empleado (
    idEmpleado INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    documento VARCHAR(50) NOT NULL UNIQUE,
    primerNombre NVARCHAR(500) NOT NULL,
    segundoNombre NVARCHAR(500) NOT NULL,
    primerApellido NVARCHAR(500) NOT NULL,
    segundoApellido NVARCHAR(500) NOT NULL,
    telefono NVARCHAR(15) NOT NULL,
    email NVARCHAR(500) NOT NULL,
    cargoFK INT,
    CONSTRAINT FOREIGN KEY (cargoFK)
        REFERENCES comprayventa.cargo (idCargo),
    estado BOOLEAN NOT NULL
);
insert into empleado(documento,
    primerNombre,segundoNombre,primerApellido,segundoApellido,telefono,email,cargoFK,estado)
    values(1082832536,"juan","sebastian","sanchez","arnedo",3054590280,"jssa309@gmail.com",1,true);
    insert into empleado(documento,
    primerNombre,segundoNombre,primerApellido,segundoApellido,telefono,email,cargoFK,estado)values(12,"juan","sebastian","sanchez","arnedo",3054590280,"jssa309@gmail.com",2,true);
CREATE TABLE login (
    idLogin INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    username NVARCHAR(500) NOT NULL,
    psw NVARCHAR(500) NOT NULL,
    cargoFk INT,
    CONSTRAINT FOREIGN KEY (cargoFk)
        REFERENCES comprayventa.cargo (idCargo),
    empleadoFK INT,
    CONSTRAINT FOREIGN KEY (empleadoFK)
        REFERENCES comprayventa.empleado (idEmpleado)
);
insert into login values(1,"juan",10,1,1);
insert into login values(2,"juan",11,2,2);
CREATE TABLE Productos (
    id_producto INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    marca VARCHAR(100) NOT NULL,
    modelo VARCHAR(200) NOT NULL,
    placa NVARCHAR(6)not null unique,
    descripcion TEXT,
    precioCompra double NOT NULL,
    precioVenta double,
    estado INT,
    CONSTRAINT FOREIGN KEY (estado)
        REFERENCES comprayventa.tipoEstado (id_Estado)
);
CREATE TABLE Detalles_factura (
    id_detalle INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    id_empleado INT NOT NULL,
    fechaMoviento DATE NOT NULL,
    id_producto INT NOT NULL,
    cantidad INT NOT NULL,
    tipoTransaccion INT NOT NULL,
    clienteFK INT NOT NULL,
    CONSTRAINT FOREIGN KEY (tipoTransaccion)
        REFERENCES comprayventa.tipoTransaccion (idTransaccion),
    FOREIGN KEY (id_producto)
        REFERENCES Productos (id_producto),
    FOREIGN KEY (id_empleado)
        REFERENCES empleado (idEmpleado),
    CONSTRAINT FOREIGN KEY (clienteFK)
        REFERENCES comprayventa.cliente (idCliente)
);
