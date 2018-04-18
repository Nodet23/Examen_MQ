package upc.eetac.dsa.omv;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Instituto {

    private String nombre;
    private ArrayList<Alumno> alumnos;
    private ArrayList<String> operacionesInstituto;

    public Instituto(){
        this.alumnos = new ArrayList<Alumno>();
        this.operacionesInstituto = new ArrayList<String>();
    }

    public Instituto(String nombre) {
        this.nombre = nombre;
        this.alumnos = new ArrayList<Alumno>();
        this.operacionesInstituto = new ArrayList<String>();
    }

    public ArrayList<String> getOperacionesInstituto() {
        return operacionesInstituto;
    }

    public void setOperacionesInstituto(ArrayList<String> operacionesInstituto) {
        this.operacionesInstituto = operacionesInstituto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(ArrayList<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
}
