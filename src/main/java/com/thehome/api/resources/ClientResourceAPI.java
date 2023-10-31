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
import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;
import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirements;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/v1/clients")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "Client Resources", description = "Route used to manipulate client data.")
@SecurityRequirements(value = {@SecurityRequirement(name = "basicAuth")})
public interface ClientResourceAPI {

    @Operation(
            description = "Return all clients.",
            operationId = "clientResourceAPI.findAll",
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
    Response findAll();

    @Operation(
            description = "Return client by Id.",
            operationId = "clientResourceAPI.findById",
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
    Response findById(@PathParam("id") Long id);

    @Operation(
            description = "Create client",
            operationId = "clientResourceAPI.create",
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
    Response create(@Valid ClientRequestDTO requestDTO);

    @PUT
    @Path("/{id}")
    @Transactional
    @Operation(
            description = "Update client.",
            operationId = "clientResourceAPI.update",
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
    Response update(@PathParam("id") Long id, @Valid ClientRequestDTO requestDTO);

    @DELETE
    @Path("/{id}")
    @Operation(
            description = "Delete client.",
            operationId = "clientResourceAPI.delete",
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
    Response delete(@PathParam("id") Long id);
}
