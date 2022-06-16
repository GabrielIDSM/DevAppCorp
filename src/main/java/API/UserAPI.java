package API;

import DTO.UserDTO;
import Repository.UserRepository;
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
@Path("/user")
public class UserAPI {
    private static final UserRepository USER_REPOSITORY = new UserRepository();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserDTO> get() {
        return USER_REPOSITORY.all();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserDTO getById(@PathParam("id") int id) {
        return USER_REPOSITORY.getUser(id);
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(UserDTO o) {
        try {
            USER_REPOSITORY.addUser(o);
            return Response.status(Response.Status.CREATED).entity(o).build();
        } catch(Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        } 
    }
    
    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public UserDTO login(UserDTO o) {
        return USER_REPOSITORY.login(o.getUsername(), o.getPassword());
    }
    
    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response put(@PathParam("id") int id, UserDTO o)
    {
        UserDTO a = USER_REPOSITORY.getUser(id);
        if(a == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        
        try {
            o.setId(id);
            USER_REPOSITORY.updateUser(o);
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
        UserDTO o = USER_REPOSITORY.getUser(id);
        if (o == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        
        try {
            USER_REPOSITORY.removeUser(id);
            return Response.status(Response.Status.OK).build();
        } catch(Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        } 
    }
}