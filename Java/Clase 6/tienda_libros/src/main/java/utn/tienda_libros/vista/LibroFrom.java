package utn.tienda_libros.vista;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import utn.tienda_libros.modelo.Libro;
import utn.tienda_libros.servicio.LibroServicio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

@Component
public class LibroFrom extends JFrame {
    LibroServicio libroServicio;
    private JPanel panel;
    private JTable tablaLibros;
    private JTextField libroTexto;
    private JLabel Autor;
    private JTextField autorTexto;
    private JTextField precioText;
    private JTextField existenciasTexto;
    private JButton agregarButton;
    private JButton modificarButton;
    private JButton eliminarButton;
    private DefaultTableModel tableModeloLibros;

    @Autowired
    public LibroFrom(LibroServicio libroServicio) {
        this.libroServicio = libroServicio;
        iniciarForma();
        agregarButton.addActionListener(e -> agregarLibro());
    }

    private void iniciarForma() {
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(900, 700);
        // Para obtener las dimenciones de la ventana
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension tamanioPantalla = toolkit.getScreenSize();
        int x = (tamanioPantalla.width - getWidth() / 2);
        int y = (tamanioPantalla.height - getHeight() / 2);
        setLocation(x, y);
    }

    private void agregarLibro() {
        //Leer los valores del formulario
        if (libroTexto.getText().equals("")) {
            mostrarMensaje("Ingresa el nombre del libro");
            libroTexto.requestFocusInWindow();
            return;
        }
        var nombreLibro = libroTexto.getText();
        var autor = autorTexto.getText();
        var precio = Double.parseDouble(precioText.getText());
        var existencias = Integer.parseInt(existenciasTexto.getText());
        // Creamos el objeto libro
        var libro = new Libro(null, nombreLibro, autor, precio, existencias);
        // libro.setNombreLibro(nombreLibro);
        // libro.setAutor(autor);
        // libro.setPrecio(precio);
        // libro.setExistencias(existencias);
        this.libroServicio.guardarLibro(libro);
        mostrarMensaje("Se agrego el libro");
        limpiarFormulario();
        listarLibros();
    }
    private void limpiarFormulario(){
        libroTexto.setText("");
        autorTexto.setText("");
        precioText.setText("");
        existenciasTexto.setText("");
    }

    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    private void createUIComponents() {
        this.tableModeloLibros = new DefaultTableModel(0, 5);
        String[] cabecera = {"ID", "Libro", "Autor", "Precio", "Existncias"};
        this.tableModeloLibros.setColumnIdentifiers(cabecera);
        // Instanciar el el objeto de Jtable
        this.tablaLibros = new JTable(tableModeloLibros);
        listarLibros();
    }

    private void listarLibros() {
        // limpiar la tabla
        tableModeloLibros.setRowCount(0);
        // Obtener los libros de la BD
        var libros = libroServicio.listarLibros();
        // Iteramos cada libro
        libros.forEach((libro) -> { // Función Lambda
            // Creamos cada registro para agregarlos a la tabla
            Object[] renglonLibro = {
                    libro.getIdLibro(),
                    libro.getNombreLibro(),
                    libro.getAutor(),
                    libro.getPrecio(),
                    libro.getExistencias()
            };
            this.tableModeloLibros.addRow(renglonLibro);
        });
    }
}
