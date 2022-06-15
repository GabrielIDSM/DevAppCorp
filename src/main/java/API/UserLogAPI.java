package API;

import DTO.UserLogDTO;
import Repository.UserLogRepository;
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
@Path("/userlog")
public class UserLogAPI {
    private static final UserLogRepository USER_LOG_REPOSITORY = new UserLogRepository();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserLogDTO> get() {
        return USER_LOG_REPOSITORY.all();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserLogDTO getById(@PathParam("id") int id) {
        return USER_LOG_REPOSITORY.getUserLog(id);
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(UserLogDTO o) {
        try {
            USER_LOG_REPOSITORY.addUserLog(o);
            return Response.status(Response.Status.CREATED).entity(o).build();
        } catch(Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        } 
    }
    
    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response put(@PathParam("id") int id, UserLogDTO o)
    {
        UserLogDTO a = USER_LOG_REPOSITORY.getUserLog(id);
        if(a == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        
        try {
            o.setId(id);
            USER_LOG_REPOSITORY.updateUserLog(o);
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
        UserLogDTO o = USER_LOG_REPOSITORY.getUserLog(id);
        if (o == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        
        try {
            USER_LOG_REPOSITORY.removeUserLog(id);
            return Response.status(Response.Status.OK).build();
        } catch(Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        } 
    }
}