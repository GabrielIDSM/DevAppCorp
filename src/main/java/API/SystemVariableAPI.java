package API;

import DTO.SystemVariableDTO;
import Repository.SystemVariableRepository;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Gabriel Inácio <gabrielinacio@id.uff.br>
 */
@Path("/sysvar")
public class SystemVariableAPI {
    private static final SystemVariableRepository SYSVAR_REPOSITORY = new SystemVariableRepository();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<SystemVariableDTO> get() {
        return SYSVAR_REPOSITORY.all();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public SystemVariableDTO getById(@PathParam("id") int id) {
        return SYSVAR_REPOSITORY.getSystemVariable(id);
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(SystemVariableDTO o) {
        try {
            SYSVAR_REPOSITORY.addSystemVariable(o);
            return Response.status(Response.Status.CREATED).entity(o).build();
        } catch(Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        } 
    }
    
    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response put(@PathParam("id") int id, SystemVariableDTO o)
    {
        SystemVariableDTO a = SYSVAR_REPOSITORY.getSystemVariable(id);
        if(a == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        
        try {
            o.setId(id);
            SYSVAR_REPOSITORY.updateSystemVariable(o);
            return Response.status(Response.Status.OK).entity(o).build();
        } catch(Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        } 
    }
    
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") int id)
    {
        SystemVariableDTO o = SYSVAR_REPOSITORY.getSystemVariable(id);
        if (o == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        
        try {
            SYSVAR_REPOSITORY.removeSystemVariable(id);
            return Response.status(Response.Status.OK).build();
        } catch(Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        } 
    }
}