package utn.estudiantes.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utn.estudiantes.modelo.Estudiante;
import utn.estudiantes.repositorio.EstudianteRepositorio;

import java.util.List;

// Introduce las dependcias que necesitamos
@Service
public class EstudianteServicio implements IEstudianteServicio{
    @Autowired
    private EstudianteRepositorio estudianteRepositorio;

    // TODO esto no es sobreescritura es implementación
    @Override
    public List<Estudiante> listarEstudiantes() { //Devolvemos la lista completa de los estudiantes
        List<Estudiante> estudiantes = estudianteRepositorio.findAll();
        return estudiantes;
    }

    @Override
    public Estudiante buscarEstudiantePorId(Integer idEstudiante) {// devuelve el id o null
        Estudiante estudiante = estudianteRepositorio.findById(idEstudiante).orElse(null);
        return estudiante;
    }

    @Override
    public void guardarEstudiante(Estudiante estudiante) {
        estudianteRepositorio.save(estudiante);
    }

    @Override
    public void eliminarEstudiante(Estudiante estudiante) {
        estudianteRepositorio.delete(estudiante);
    }
}
