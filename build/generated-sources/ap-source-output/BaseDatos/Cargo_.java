package BaseDatos;

import BaseDatos.Empleado;
import BaseDatos.Login;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-04-17T21:17:19")
@StaticMetamodel(Cargo.class)
public class Cargo_ { 

    public static volatile SingularAttribute<Cargo, Integer> idCargo;
    public static volatile CollectionAttribute<Cargo, Empleado> empleadoCollection;
    public static volatile CollectionAttribute<Cargo, Login> loginCollection;
    public static volatile SingularAttribute<Cargo, String> nombre;

}