package API;

import DTO.ImageDTO;
import Repository.ImageRepository;
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
@Path("/image")
public class ImageAPI {
    private static final ImageRepository IMAGE_REPOSITORY = new ImageRepository();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ImageDTO> get() {
        return IMAGE_REPOSITORY.all();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ImageDTO getById(@PathParam("id") int id) {
        return IMAGE_REPOSITORY.getImage(id);
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(ImageDTO o) {
        try {
            IMAGE_REPOSITORY.addImage(o);
            return Response.status(Response.Status.CREATED).entity(o).build();
        } catch(Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        } 
    }
    
    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response put(@PathParam("id") int id, ImageDTO o)
    {
        ImageDTO a = IMAGE_REPOSITORY.getImage(id);
        if(a == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        
        try {
            o.setId(id);
            IMAGE_REPOSITORY.updateImage(o);
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
        ImageDTO o = IMAGE_REPOSITORY.getImage(id);
        if (o == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        
        try {
            IMAGE_REPOSITORY.removeImage(id);
            return Response.status(Response.Status.OK).build();
        } catch(Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        } 
    }
}