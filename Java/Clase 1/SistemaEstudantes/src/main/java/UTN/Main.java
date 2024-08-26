package UTN;

import UTN.datos.EstudianteDAO;
import UTN.conexion.Conexion;
import UTN.dominio.Estudiante;


import javax.swing.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var conexion = Conexion.getConnection();
        if (conexion!=null)
            System.out.println("Conexión exitosa: "+conexion);
        else
            System.out.println("Error al conectarse");
        menu();
    }//Fin main

    public static void menu(){
        String[] opciones = {
                "Listar estudiantes",
                "Buscar Estudiantes",
                "Agregar estudiante",
                "Modificar estudiante",
                "Eliminar estudiante",
                "Salir" };
        String seleccion = "";
        do {
            // ? Mostrar el cuadro de diálogo con el menú desplegable
            seleccion = (String) JOptionPane.showInputDialog(null, "Elige una opción", "Menú",
                    JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
            switch (seleccion){
                case "Listar estudiantes":
                    Listar();
                    break;
                case "Buscar Estudiantes":
            }
        } while (seleccion != "Salir");
    }
    public static void Listar(){
        EstudianteDAO estudiantesDao = new EstudianteDAO();
        List<Estudiante> estudiantes = estudiantesDao.listarEstudiantes();

        // TODO creamos el metodo builder para
        StringBuilder mensaje = new StringBuilder();

        for (Estudiante estudiante : estudiantes) {
            mensaje.append(estudiante.toString()).append("\n");
        }

        JOptionPane.showMessageDialog(null, mensaje.toString(), "Lista de Estudiantes", JOptionPane.INFORMATION_MESSAGE);

    }
}// Fin clase