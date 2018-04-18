package upc.eetac.dsa.omv;

import java.util.ArrayList;

public interface MathManager {

    public boolean realizarOperacion(Operacion operacion);
    public int procesarOperacion();
    public ArrayList<String> listadoOperacionesInstituto(String instituto);
    public ArrayList<String> listadoOperacionesAlumno(String alumno);
    public ArrayList<Instituto> listadoInstitutos();

}
