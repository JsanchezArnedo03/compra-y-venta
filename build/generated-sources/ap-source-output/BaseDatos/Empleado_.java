package BaseDatos;

import BaseDatos.Cargo;
import BaseDatos.Login;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-04-17T21:17:19")
@StaticMetamodel(Empleado.class)
public class Empleado_ { 

    public static volatile SingularAttribute<Empleado, String> segundoNombre;
    public static volatile SingularAttribute<Empleado, String> primerNombre;
    public static volatile SingularAttribute<Empleado, String> primerApellido;
    public static volatile SingularAttribute<Empleado, Cargo> cargoFK;
    public static volatile SingularAttribute<Empleado, Integer> idEmpleado;
    public static volatile SingularAttribute<Empleado, String> segundoApellido;
    public static volatile CollectionAttribute<Empleado, Login> loginCollection;
    public static volatile SingularAttribute<Empleado, String> telefono;
    public static volatile SingularAttribute<Empleado, String> email;

}