package upc.eetac.dsa.omv;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.reflect.Array;
import java.text.CollationElementIterator;
import java.util.*;
import com.google.gson.Gson;

@Path("/")
public class Rest {

    MathManagerImpl db;

    public Rest(){
        this.db = MathManagerImpl.getInstance();
    }


    @POST
    @Path("/addOperacion")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addOp(Operacion operacion)
    {
        db.realizarOperacion(operacion);
        return Response.status(201).entity("{\"result\":\"Añadir Operacion\"}").type(MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/procesarOp")
    @Produces(MediaType.APPLICATION_JSON)
    public String procOp(){
        return new Gson().toJson(db.procesarOperacion());
    }


    @GET
    @Path("/listadoOpInsti/{insti}")
    @Produces(MediaType.APPLICATION_JSON)
    public String showOpInst(@PathParam("insti") String insti){
        return new Gson().toJson(db.listadoOperacionesInstituto(insti));
    }

    @GET
    @Path("/listadoOpAlum/{alum}")
    @Produces(MediaType.APPLICATION_JSON)
    public String showOpAlum(@PathParam("alum") String alum){
        return new Gson().toJson(db.listadoOperacionesAlumno(alum));
    }

    @GET
    @Path("/listadoInstitutosOr")
    @Produces(MediaType.APPLICATION_JSON)
    public String showOpAlum(){
        return new Gson().toJson(db.listadoInstitutos());
    }

}
