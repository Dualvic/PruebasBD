package conector;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conectar {

    private static Connection conn;
    private static final String driver  = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String password = "";
    private static final String url = "jdbc:mysql://localhost:3306/peliculas";

    // Realiza la conexion, devuelve el error en caso de no haber sido satisfactoria
    public Conectar() {
        conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                System.out.println("Conexion establecida..");
            }
        } catch (Exception e) {
                System.out.println("Error en conexion.." + e);
        }
    }
    // Devuelve el estado de la conexion
    public Connection getConnection(){
        return conn;
    }

    // Posible implementacion
    public void desconectar() {
        conn = null;
        if(conn == null) {
            System.out.println("Conexion terminada..");
        }
    }


}
