package upc.eetac.dsa.omv;

public class Operacion {

    private String operacion;
    private String dniAlumno;

    public Operacion(String operacion, String dniAlumno) {
        this.operacion = operacion;
        this.dniAlumno = dniAlumno;
    }

    public Operacion() {
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String getDniAlumno() {
        return dniAlumno;
    }

    public void setDniAlumno(String dniAlumno) {
        this.dniAlumno = dniAlumno;
    }
}
