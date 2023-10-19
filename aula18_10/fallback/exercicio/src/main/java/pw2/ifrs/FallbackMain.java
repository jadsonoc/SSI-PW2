package pw2.ifrs;

import java.text.ParseException;

import org.eclipse.microprofile.faulttolerance.Fallback;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/fallback")
public class FallbackMain {

    @GET
    @Path("/name/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    @Fallback(fallbackMethod = "recover") 
    public String getName(@PathParam("name") String name) {
        throw new RuntimeException();
    }


    @GET
    @Path("/age/{age}")
    @Produces(MediaType.TEXT_PLAIN)
    @Fallback(fallbackMethod = "recover") 
    public String getRequisicao(@PathParam("age") String age) {
        try {
            return "Minha requisição idade OK " + Integer.parseInt(age);
        } catch (NumberFormatException e) {
            throw e;
        }
    }

    public String recover(String texto) {
        return "Mensagem de Fallback " + texto;
    }

}
