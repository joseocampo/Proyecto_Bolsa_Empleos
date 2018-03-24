package GestorBD;

import Modelo.Administrador;
import modelo.dao.GestorBaseDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GestorAdministradores {

    private GestorAdministradores() throws
            InstantiationException,
            ClassNotFoundException,
            IllegalAccessException {
        bd = GestorBaseDatos.obtenerGestorBD(
                GestorBaseDatos.GBD.MYSQL_SERVER,
                GestorBaseDatos.SERVIDOR_POR_DEFECTO);
    }

    public static GestorAdministradores obtenerInstancia() throws
            InstantiationException,
            ClassNotFoundException,
            IllegalAccessException {
        if (instancia == null) {
            instancia = new GestorAdministradores();
        }
        return instancia;
    }

    // (C)reate
    public boolean agregar(Administrador calibracion) {
        boolean exito = false;

        try {
            try (Connection cnx = bd.obtenerConexion(BASE_DATOS, USUARIO, CLAVE);
                    PreparedStatement stm = cnx.prepareStatement(CMD_AGREGAR)) {
                stm.clearParameters();

                int r = stm.executeUpdate();
                exito = (r == 1);
            }
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n",
                    ex.getMessage());
        }
        return exito;
    }

    // (R)etrieve
    public Administrador recuperar(int id) {
        Administrador r = null;
        try {
            try (Connection cnx = bd.obtenerConexion(BASE_DATOS, USUARIO, CLAVE);
                    PreparedStatement stm = cnx.prepareStatement(CMD_RECUPERAR)) {
                stm.clearParameters();
                stm.setInt(1, id);

                try (ResultSet rs = stm.executeQuery()) {
                    if (rs.next()) {

                    }
                }
            }
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n",
                    ex.getMessage());
        }
        return r;
    }

    // (U)pdate
    public boolean actualizar(Administrador cali) {
        boolean exito = false;
        try {
            try (Connection cnx = bd.obtenerConexion(BASE_DATOS, USUARIO, CLAVE);
                    PreparedStatement stm = cnx.prepareStatement(CMD_ACTUALIZAR)) {

                int r = stm.executeUpdate();
                exito = (r == 1);
            }
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n",
                    ex.getMessage());
        }
        return exito;
    }

    // (D)elete
    public boolean eliminar(String idAdministrador) {
        boolean exito = false;
        try {
            try (Connection cnx = bd.obtenerConexion(BASE_DATOS, USUARIO, CLAVE);
                    PreparedStatement stm = cnx.prepareStatement(CMD_ELIMINAR)) {
                stm.clearParameters();
                stm.setString(1, idAdministrador);

                int r = stm.executeUpdate();
                exito = (r == 1);
            }
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n",
                    ex.getMessage());
        }
        return exito;
    }

    public List<Administrador> listaAdministradores() {
        List<Administrador> r = new ArrayList<>();
        Administrador administrador;
        try {
            try (Connection cnx = bd.obtenerConexion(BASE_DATOS, USUARIO, CLAVE);
                    Statement stm = cnx.createStatement();
                    ResultSet rs = stm.executeQuery(CMD_LISTAR)) {

                while (rs.next()) {

                }

                System.out.print(r);

            }
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n",
                    ex.getMessage());
        }

        return r;
    }

//    public Object[][] obtenerTabla() {
//        List<Administrador> administradores = listaAdministradores();
//        Object[][] r = new Object[administradores.size()][4];
//        int i = 0;
//        for (Administrador e : administradores) {
//
//        }
//           return r;
//    }

    @Override
    public String toString() {
        StringBuilder r = new StringBuilder("[");
        boolean f = false;
        for (Administrador e : listaAdministradores()) {
            if (f) {
                r.append(", ");
            }
            r.append(String.format("\n\t%s", e));
            f = true;
        }
        r.append("\n]");
        return r.toString();
    }

    private static final String BASE_DATOS = "crjobs";
    private static final String USUARIO = "root";
    private static final String CLAVE = "";

    private static final String CMD_LISTAR = "SELECT numCalibracion,instrumento,fecha,mediciones FROM calibraciones ORDER BY numCalibracion;";

    private static final String CMD_AGREGAR = "INSERT INTO calibraciones  (fecha,instrumento,mediciones) VALUES (?, ?,0);";
    private static final String CMD_RECUPERAR = "SELECT numCalibracion,instrumento,fecha,medidas FROM calibraciones WHERE numCalibracion=?; ";
    private static final String CMD_ACTUALIZAR = "UPDATE calibraciones SET numCalibracion=?, instrumento=?, fecha=? ,medidas=? WHERE numCalibracion=?;";
    private static final String CMD_ELIMINAR = "DELETE FROM calibraciones WHERE numCalibracion=?; ";

    private static GestorAdministradores instancia = null;
    private final GestorBaseDatos bd;
}
