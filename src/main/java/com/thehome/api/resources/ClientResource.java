package com.thehome.api.resources;
import com.thehome.api.dto.request.ClientRequestDTO;
import com.thehome.api.dto.response.ClientResponseDTO;
import com.thehome.api.model.Client;
import com.thehome.api.service.ClientService;
import com.thehome.api.utils.ResponseMapperUtils;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.RestResponse;
import java.util.Optional;

public class ClientResource implements ClientResourceAPI {

    @Inject
    ClientService clientService;

    @Override
    public Response findAllClients() {
        return Response.ok(clientService.toClientsResponseDTO(Client.listAll())).build();
    }

    @Override
    public Response findClientById(Long id) {
        Optional<Client> client = Client.findByIdOptional(id);
        Response response;
        if (client.isPresent()) {
            response = Response.ok(clientService.toClientResponseDTO(client.get())).build();
        } else {
            response = ResponseMapperUtils.notFound();
        }
        return response;
    }

    @Override
    public Response createClient(ClientRequestDTO clientRequestDTO) {
        Client client = clientService.createClient(clientRequestDTO);
        ClientResponseDTO clientResponseDTO = clientService.toClientResponseDTO(client);
        return Response.status(RestResponse.Status.CREATED).entity(clientResponseDTO).build();
    }

    @Override
    public Response updateClient(Long id, ClientRequestDTO clientRequestDTO) {
        Optional<Client> client = Client.findByIdOptional(id);
        Response response;
        if (client.isPresent()) {
            clientService.updateClient(id, clientRequestDTO);
            response = Response.ok().build();
        } else {
            response = ResponseMapperUtils.badRequest("01", "Client not found");
        }
        return response;
    }

    @Override
    public Response deleteClient(Long id) {
        Optional<Client> client = Client.findByIdOptional(id);
        Response response;
        if (client.isPresent()) {
            clientService.deleteClient(client.get().getId());
            response = ResponseMapperUtils.noContent();
        } else {
            response = ResponseMapperUtils.notFound();
        }
        return response;
    }
}
