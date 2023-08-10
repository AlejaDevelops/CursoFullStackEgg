/*
  * METODOS DE LA CLASE PADRE QUE PERMITEN ACCEDER Y MANIPULAR LA BASE DE DATOS
*/


package Tienda.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author AlejaDevelops
 */
public abstract class TiendaDAO {

    protected Connection conexion = null;
    protected ResultSet resultado = null;
    protected Statement sentencia = null;

    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DATABASE = "tienda";
    private final String DRIVER = "com.mysql.jdbc.Driver"; //OJO VERIFICAR

    //Métodos...    
    //1. CONECTAR LA BASE DE DATOS
    protected void conectarBase() throws ClassNotFoundException, SQLException {
        try {
            Class.forName(DRIVER);
            String urlBaseDeDatos = "jdbc:mysql://localhost:3306/" + DATABASE + "?useSSL=false";
            conexion = DriverManager.getConnection(urlBaseDeDatos, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            throw ex;
        }
    }

    //2. DESCONECTAR LA BASE DE DATOS
    protected void desconectarBase() throws Exception {
        try {
            if (resultado != null) {
                resultado.close();
            }
            if (sentencia != null) {
                sentencia.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        } catch (SQLException e) {
            throw e;
        }
    }

    //3. INSERTAR MODIFICAR ELIMINAR REGISTROS DE LA BASE DE DATOS
    protected void insertarModificarEliminar(String sql) throws Exception {
        try {
            conectarBase();
            sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);
        } catch (SQLException | ClassNotFoundException ex) {
            throw ex;
        } finally {
            desconectarBase();
        }
    }

    //4. CONSULTAR BASE DE DATOS
    protected void consultarBase(String sql) throws Exception {
        try {
            conectarBase();
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sql);
        } catch (SQLException | ClassNotFoundException ex) {
            throw ex;
        }
    }
    
    
    
    
}
