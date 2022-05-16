package API;

import DTO.SystemVariableTypeDTO;
import Repository.SystemVariableTypeRepository;
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
@Path("/sysvartype")
public class SystemVariableTypeAPI {
    private static final SystemVariableTypeRepository SYSVARTYPE_REPOSITORY = new SystemVariableTypeRepository();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<SystemVariableTypeDTO> get() {
        return SYSVARTYPE_REPOSITORY.all();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public SystemVariableTypeDTO getById(@PathParam("id") int id) {
        return SYSVARTYPE_REPOSITORY.getSystemVariableType(id);
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(SystemVariableTypeDTO o) {
        try {
            SYSVARTYPE_REPOSITORY.addSystemVariableType(o);
            return Response.status(Response.Status.CREATED).entity(o).build();
        } catch(Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        } 
    }
    
    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response put(@PathParam("id") int id, SystemVariableTypeDTO o)
    {
        SystemVariableTypeDTO a = SYSVARTYPE_REPOSITORY.getSystemVariableType(id);
        if(a == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        
        try {
            o.setId(id);
            SYSVARTYPE_REPOSITORY.updateSystemVariableType(o);
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
        SystemVariableTypeDTO o = SYSVARTYPE_REPOSITORY.getSystemVariableType(id);
        if (o == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        
        try {
            SYSVARTYPE_REPOSITORY.removeSystemVariableType(id);
            return Response.status(Response.Status.OK).build();
        } catch(Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        } 
    }
}