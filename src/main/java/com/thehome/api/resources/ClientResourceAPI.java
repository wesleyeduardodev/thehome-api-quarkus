package com.thehome.api.resources;
import com.thehome.api.dto.request.ClientRequestDTO;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/v1/clients")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "Client Resources", description = "Route used to manipulate client data.")
public interface ClientResourceAPI {

    @Operation(
            description = "Return all clients.",
            operationId = "clientResourceAPI.findAllClients",
            summary = "Return all clients."
    )
    @APIResponse(
            name = "OK",
            responseCode = "200",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(
                            ref = "ClientResponseDTO"
                    )
            ),
            description = "Request executed successfully. Successfully obtained clients."
    )
    @APIResponse(responseCode = "400", ref = "illegalRequest")
    @APIResponse(responseCode = "401", ref = "unauthorized")
    @APIResponse(responseCode = "403", ref = "forbiden")
    @APIResponse(responseCode = "404", ref = "notFound")
    @APIResponse(responseCode = "500", ref = "internalError")
    @GET
    Response findAllClients();

    @Operation(
            description = "Return client by Id.",
            operationId = "clientResourceAPI.findClientById",
            summary = "Return client by Id."
    )
    @APIResponse(
            name = "OK",
            responseCode = "200",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(
                            ref = "ClientResponseDTO"
                    )
            ),
            description = "Request executed successfully. Client successfully obtained."
    )
    @Path("/{id}")
    @APIResponse(responseCode = "400", ref = "illegalRequest")
    @APIResponse(responseCode = "401", ref = "unauthorized")
    @APIResponse(responseCode = "403", ref = "forbiden")
    @APIResponse(responseCode = "404", ref = "notFound")
    @APIResponse(responseCode = "500", ref = "internalError")
    @GET
    Response findClientById(@PathParam("id") Long id);

    @Operation(
            description = "Create client",
            operationId = "clientResourceAPI.createClient",
            summary = "Create client"
    )
    @APIResponse(
            name = "OK",
            responseCode = "200",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(
                            ref = "ClientResponseDTO"
                    )
            ),
            description = "Request executed successfully. Created client."
    )
    @POST
    @APIResponse(responseCode = "400", ref = "illegalRequest")
    @APIResponse(responseCode = "401", ref = "unauthorized")
    @APIResponse(responseCode = "403", ref = "forbiden")
    @APIResponse(responseCode = "500", ref = "internalError")
    Response createClient(@Valid ClientRequestDTO clientRequestDTO);

    @PUT
    @Path("/{id}")
    @Transactional
    @Operation(
            description = "Update client.",
            operationId = "clientResourceAPI.updateClient",
            summary = "Update client."
    )
    @APIResponse(
            name = "OK",
            responseCode = "200",
            description = "Request executed successfully. Updated client."
    )
    @APIResponse(responseCode = "400", ref = "illegalRequest")
    @APIResponse(responseCode = "401", ref = "unauthorized")
    @APIResponse(responseCode = "403", ref = "forbiden")
    @APIResponse(responseCode = "404", ref = "notFound")
    @APIResponse(responseCode = "500", ref = "internalError")
    Response updateClient(@PathParam("id") Long id, @Valid ClientRequestDTO clientRequestDTO);

    @DELETE
    @Path("/{id}")
    @Operation(
            description = "Delete client.",
            operationId = "clientResourceAPI.deleteClient",
            summary = "Delete client."
    )
    @APIResponse(
            name = "OK",
            responseCode = "204",
            description = "Request executed successfully."
    )
    @APIResponse(responseCode = "400", ref = "illegalRequest")
    @APIResponse(responseCode = "401", ref = "unauthorized")
    @APIResponse(responseCode = "403", ref = "forbiden")
    @APIResponse(responseCode = "404", ref = "notFound")
    @APIResponse(responseCode = "500", ref = "internalError")
    Response deleteClient(@PathParam("id") Long id);
}
