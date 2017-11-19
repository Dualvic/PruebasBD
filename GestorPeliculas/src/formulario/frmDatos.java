package formulario;

import conector.Conectar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class frmDatos extends JFrame {

    // Declaracion de todos los elementos del panel
    private JLabel titulo;
    private JTextField tituloText;
    private JLabel pelicula;
    private JTextField peliculaText;
    private JButton testConnect;
    private JButton aceptar;
    private JButton cancelar;
    // Declaracion de la conexion para poder trabajar con ella
    Conectar con = new Conectar();
    Connection cn = con.getConnection();

    public frmDatos(){
        // Caracteristicas Layout del panel
        setTitle("Peliculas");
        setResizable(false);
        setSize(390, 180);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Asignacion de texto de los paneles
        titulo = new JLabel("titulo");
        tituloText = new JTextField(10);
        pelicula = new JLabel("Pelicula");
        peliculaText = new JTextField(15);
        aceptar = new JButton("Aceptar");
        cancelar = new JButton("Cancelar");
        testConnect = new JButton("Test Connection");

        // Añadir cada elemento
        add(titulo);
        add(tituloText);
        add(pelicula);
        add(peliculaText);
        add(aceptar);
        add(cancelar);
        add(testConnect);

        // Ubicamos cada elemento dentro del panel
        titulo.reshape(20,20, 100, 20);
        pelicula.reshape(20,50,100,20);
        tituloText.reshape(80,20,100,20);
        peliculaText.reshape(80,50,100,20);
        aceptar.reshape(20,75,100,20);
        cancelar.reshape(20,100,100,20);
        testConnect.reshape(150,100,150,20);

        // Evento para insertar datos en la tabla
        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    PreparedStatement insert = cn.prepareStatement("INSERT INTO infograma(titulo,director) VALUES (?,?)");
                    insert.setString(1, tituloText.getText());
                    insert.setString(2,peliculaText.getText());
                    insert.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Datos guardados.");
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        // Evento para probar la conexion
        testConnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                con = new Conectar();
                Connection req = con.getConnection();
            }
        });
    }


}
