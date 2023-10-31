package com.thehome.api.resources;
import com.thehome.api.dto.request.ClientRequestDTO;
import com.thehome.api.dto.response.ClientResponseDTO;
import com.thehome.api.model.Client;
import com.thehome.api.service.ClientService;
import com.thehome.api.utils.ResponseMapperUtils;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.RestResponse;
import java.util.Optional;

//TODO Essa anotação poderia ficar na interface. Porém parece há um problema com herança de anotações no fluxo de execução SecurityIdentity (Avaliar)
@RolesAllowed("admin")
public class ClientResource implements ClientResourceAPI {

    @Inject
    ClientService clientService;

    @Override
    public Response findAll() {
        return Response.ok(clientService.toResponsesFromEntities(Client.list("order by id"))).build();
    }

    @Override
    public Response findById(Long id) {
        Optional<Client> client = Client.findByIdOptional(id);
        Response response;
        if (client.isPresent()) {
            response = Response.ok(clientService.toResponseFromEntity(client.get())).build();
        } else {
            response = ResponseMapperUtils.notFound();
        }
        return response;
    }

    @Override
    public Response create(ClientRequestDTO requestDTO) {
        Client client = clientService.createEntityFromRequest(requestDTO);
        ClientResponseDTO clientResponseDTO = clientService.toResponseFromEntity(client);
        return Response.status(RestResponse.Status.CREATED).entity(clientResponseDTO).build();
    }

    @Override
    public Response update(Long id, ClientRequestDTO requestDTO) {
        Optional<Client> client = Client.findByIdOptional(id);
        Response response;
        if (client.isPresent()) {
            clientService.updateEntityFromRequest(id, requestDTO);
            response = Response.ok().build();
        } else {
            response = ResponseMapperUtils.badRequest("01", "Client not found");
        }
        return response;
    }

    @Override
    public Response delete(Long id) {
        Optional<Client> client = Client.findByIdOptional(id);
        Response response;
        if (client.isPresent()) {
            clientService.deleteById(client.get().getId());
            response = ResponseMapperUtils.noContent();
        } else {
            response = ResponseMapperUtils.notFound();
        }
        return response;
    }
}
