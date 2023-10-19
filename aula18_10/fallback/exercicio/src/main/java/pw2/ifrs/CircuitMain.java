package pw2.ifrs;


import java.util.logging.Level;
import java.util.logging.Logger;


import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/circuit")
public class CircuitMain {

    private Long counter = 0L;

    ClasseTestCircuit classeTestCircuit = new ClasseTestCircuit();

    Logger LOGGER = Logger.getLogger(ClasseTestCircuit.class.getName());

    @GET
    @Path("/{id}/number")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public Response number(@PathParam("id") int id) {

        final Long invocationNumber = counter++;

        int magicNumber = classeTestCircuit.getMagicNumber();

        if (id > magicNumber) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        try {
            if (id != magicNumber) {
                LOGGER.log(Level.INFO, () -> "Sucesso: " +  invocationNumber);
                return Response.ok(id).build();
            } else {
                LOGGER.log(Level.SEVERE, () -> "Falha, mandou 4: " + invocationNumber);
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                            .entity("Mandou o nro 4")
                            .type(MediaType.TEXT_PLAIN_TYPE)
                            .build();

            }
        } catch (RuntimeException e) {
            String message = String.format("%s: %s", e.getClass().getSimpleName(), e.getMessage());
            LOGGER.log(Level.SEVERE, () -> "Falha: " + invocationNumber);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(message)
                    .type(MediaType.TEXT_PLAIN_TYPE)
                    .build();
        }

        
    }
}
