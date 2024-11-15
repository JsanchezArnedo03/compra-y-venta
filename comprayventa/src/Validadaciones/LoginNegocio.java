package Validadaciones;

import Persistencia.LoginCRUD;
import Vistas.FrmLogin;
import Vistas.FrmPrincipal;
import entidades.Login;

import javax.swing.JFrame;

/**
 *
 * @author jssa3
 */
public class LoginNegocio {

    LoginCRUD lcrud = new LoginCRUD();

    public JFrame ValidarIngreso(String username, String psw) {
        Login login = lcrud.validarIngreso(username, psw);
        JFrame pantallaPrincipal = null;
        if (login != null) {
            if (login.getCargo() == 1) {
                pantallaPrincipal = new FrmPrincipal(login.getCargo());
                pantallaPrincipal.setVisible(true);
                pantallaPrincipal.setLocationRelativeTo(null);
            } else if (login.getCargo() == 2) {
                pantallaPrincipal = new FrmPrincipal(login.getCargo());
                pantallaPrincipal.setVisible(true);
                pantallaPrincipal.setLocationRelativeTo(null);
            }
        }
        return pantallaPrincipal;
    }
}
