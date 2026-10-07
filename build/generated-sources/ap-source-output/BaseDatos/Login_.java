package BaseDatos;

import BaseDatos.Cargo;
import BaseDatos.Empleado;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-04-17T21:17:19")
@StaticMetamodel(Login.class)
public class Login_ { 

    public static volatile SingularAttribute<Login, Empleado> empleadoFK;
    public static volatile SingularAttribute<Login, Cargo> cargoFk;
    public static volatile SingularAttribute<Login, String> psw;
    public static volatile SingularAttribute<Login, Integer> idLogin;
    public static volatile SingularAttribute<Login, String> username;

}