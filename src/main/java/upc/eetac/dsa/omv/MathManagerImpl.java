package upc.eetac.dsa.omv;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.*;

public class MathManagerImpl implements MathManager {

    HashMap<String, Alumno> mapaAlumnos;
    HashMap<String, Instituto> mapaInstitutos;
    Queue<Operacion> colaOperaciones;

    private static final Logger logger = LogManager.getLogger(MathManagerImpl.class.getName());
    static MathManagerImpl instance;


    public MathManagerImpl(){
        mapaAlumnos = new HashMap<String, Alumno>();
        mapaInstitutos = new HashMap<String, Instituto>();
        colaOperaciones = new LinkedList<Operacion>();

        Alumno Bruno = new Alumno("Bruno", "dniBruno", "Insituto1");
        Alumno Juan = new Alumno("Juan", "dniJuan", "Insituto1");
        Alumno Alvaro = new Alumno("Alvaro", "dniAlvaro", "Insituto2");
        Alumno Rober = new Alumno("Rober", "dniRober", "Insituto2");
        Alumno Vic = new Alumno("Vic", "dniVic", "Insituto3");
        Alumno Pau = new Alumno("Pau", "dniPau", "Insituto3");

        mapaAlumnos.put(Bruno.getDni(),Bruno);
        mapaAlumnos.put(Juan.getDni(),Juan);
        mapaAlumnos.put(Alvaro.getDni(),Alvaro);
        mapaAlumnos.put(Rober.getDni(),Rober);
        mapaAlumnos.put(Vic.getDni(),Vic);
        mapaAlumnos.put(Pau.getDni(),Pau);

        Operacion operacion1 = new Operacion("2+2*2-2", "dniBruno");
        colaOperaciones.add(operacion1);




        Instituto instituto1 = new Instituto("Insituto1");
        Instituto instituto2 = new Instituto("Insituto2");
        Instituto instituto3 = new Instituto("Insituto3");

        mapaInstitutos.put(instituto1.getNombre(),instituto1);
        mapaInstitutos.put(instituto2.getNombre(),instituto2);
        mapaInstitutos.put(instituto3.getNombre(),instituto3);

        instituto1.getOperacionesInstituto().add(operacion1.getOperacion());
        Bruno.getOperacionesHechas().add(operacion1.getOperacion());
        instituto3.getOperacionesInstituto().add(operacion1.getOperacion());
        Vic.getOperacionesHechas().add(operacion1.getOperacion());
        instituto3.getOperacionesInstituto().add(operacion1.getOperacion());
        Pau.getOperacionesHechas().add(operacion1.getOperacion());


        instituto1.getAlumnos().add(Bruno);
        instituto1.getAlumnos().add(Juan);
        instituto2.getAlumnos().add(Alvaro);
        instituto2.getAlumnos().add(Rober);
        instituto3.getAlumnos().add(Vic);
        instituto3.getAlumnos().add(Pau);

    }

    static public MathManagerImpl getInstance()
    {
        if(instance==null) {
            instance = new MathManagerImpl();
        }
        return instance;
    }

    public boolean realizarOperacion(Operacion operacion){
        //añadir comprobaciones
        logger.info("Operacion: "+ operacion.getOperacion() + " - Dni: "+ operacion.getDniAlumno());
        colaOperaciones.add(operacion);

        //if algo fue mal return false
        return true;
    }

    public int procesarOperacion() {
        //Añadir comprobaciones
        if (colaOperaciones.size() == 0){
            logger.error("No hay operaciones listas para procesar");
            return -99999;
        }


        Operacion operacion = colaOperaciones.remove();
        //Operacion operacion = new Operacion("2+2*2-2", "dniBruno");
        Alumno alumno = mapaAlumnos.get(operacion.getDniAlumno());
        alumno.getOperacionesHechas().add(operacion.getOperacion());
        mapaInstitutos.get(alumno.getInstituto()).getOperacionesInstituto().add(operacion.getOperacion());
        //Procesar la operacion con la operacion   esa y obtener un resultado :D

        Random random = new Random();
        int resultadoOperacion = random.nextInt(10-1+1); //Esto seria igual al resultado, ahora devuelve aleatorio entre 1 y 10 para fingir
        return resultadoOperacion; //Se devolveria el resultado


    }

    public ArrayList<String> listadoOperacionesInstituto(String instituto) {
        /*ArrayList<String> listaOperaciones = new ArrayList<String>();
        for (int x=0; x<instituto.getAlumnos().size(); x++){
            for (int y=0; y< instituto.getAlumnos().get(x).getOperacionesHechas().size();y++)
                listaOperaciones.add(instituto.getAlumnos().get(x).getOperacionesHechas().get(y));
        }
        return listaOperaciones;*/

        Instituto insti = mapaInstitutos.get(instituto);
        return insti.getOperacionesInstituto();
    }

    public ArrayList<String> listadoOperacionesAlumno(String alumno) {
        Alumno alum = mapaAlumnos.get(alumno);
        return alum.getOperacionesHechas();
    }

    public ArrayList<Instituto> listadoInstitutos() {
        ArrayList<Instituto> listaInstitutos = new ArrayList<Instituto>(mapaInstitutos.values());

        Collections.sort(listaInstitutos, new Comparator<Instituto>() {
            public int compare(Instituto o1, Instituto o2) {
                return -(int)(o1.getOperacionesInstituto().size()-o2.getOperacionesInstituto().size());
            }
        });
        return listaInstitutos;
    }

    public void setDown()
    {
        instance = null;
    }
}
