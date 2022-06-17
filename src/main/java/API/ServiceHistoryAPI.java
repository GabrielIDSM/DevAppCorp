package API;

import DTO.ServiceHistoryDTO;
import Repository.ServiceHistoryRepository;
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
@Path("/servicehistory")
public class ServiceHistoryAPI {
    private static final ServiceHistoryRepository SERVICE_HISTORY_REPOSITORY = new ServiceHistoryRepository();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ServiceHistoryDTO> get() {
        return SERVICE_HISTORY_REPOSITORY.all();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ServiceHistoryDTO getById(@PathParam("id") int id) {
        return SERVICE_HISTORY_REPOSITORY.getServiceHistory(id);
    }

    @GET
    @Path("/last")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ServiceHistoryDTO> getLast() {
        return SERVICE_HISTORY_REPOSITORY.last();
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(ServiceHistoryDTO o) {
        try {
            SERVICE_HISTORY_REPOSITORY.addServiceHistory(o);
            return Response.status(Response.Status.CREATED).entity(o).build();
        } catch(Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        } 
    }
    
    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response put(@PathParam("id") int id, ServiceHistoryDTO o)
    {
        ServiceHistoryDTO a = SERVICE_HISTORY_REPOSITORY.getServiceHistory(id);
        if(a == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        
        try {
            o.setId(id);
            SERVICE_HISTORY_REPOSITORY.updateServiceHistory(o);
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
        ServiceHistoryDTO o = SERVICE_HISTORY_REPOSITORY.getServiceHistory(id);
        if (o == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        
        try {
            SERVICE_HISTORY_REPOSITORY.removeServiceHistory(id);
            return Response.status(Response.Status.OK).build();
        } catch(Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        } 
    }
}