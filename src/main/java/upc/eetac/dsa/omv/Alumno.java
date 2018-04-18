package upc.eetac.dsa.omv;

import java.util.ArrayList;

public class Alumno {
    private String nombre;
    private String dni;
    private String instituto;
    private ArrayList<String> operacionesHechas;

    public Alumno(){
        this.operacionesHechas = new ArrayList<String>();
    }

    public Alumno(String nombre, String dni, String instituto) {
        this.nombre = nombre;
        this.dni = dni;
        this.instituto = instituto;
        this.operacionesHechas = new ArrayList<String>();
    }

    public String getInstituto() {
        return instituto;
    }

    public void setInstituto(String instituto) {
        this.instituto = instituto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<String> getOperacionesHechas() {
        return operacionesHechas;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setOperacionesHechas(ArrayList<String> operacionesHechas) {
        this.operacionesHechas = operacionesHechas;
    }
}
