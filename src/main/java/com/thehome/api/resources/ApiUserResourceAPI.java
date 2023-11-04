package com.thehome.api.resources;
import com.thehome.api.dto.request.ApiUserRequestDTO;
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

@Path("/v1/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "User Resources", description = "Route used to manipulate user data.")
public interface ApiUserResourceAPI {

    @Operation(
            description = "Return all users.",
            operationId = "apiUserResourceAPI.findAll",
            summary = "Return all users."
    )
    @APIResponse(
            name = "OK",
            responseCode = "200",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(
                            ref = "ApiUserResponseDTO"
                    )
            ),
            description = "Request executed successfully. Successfully obtained users."
    )
    @APIResponse(responseCode = "400", ref = "illegalRequest")
    @APIResponse(responseCode = "401", ref = "unauthorized")
    @APIResponse(responseCode = "403", ref = "forbiden")
    @APIResponse(responseCode = "404", ref = "notFound")
    @APIResponse(responseCode = "500", ref = "internalError")
    @GET
    Response findAll();

    @Operation(
            description = "Return user by User Name.",
            operationId = "apiUserResourceAPI.findByUserName",
            summary = "Return user by User Name."
    )
    @APIResponse(
            name = "OK",
            responseCode = "200",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(
                            ref = "ApiUserResponseDTO"
                    )
            ),
            description = "Request executed successfully. User successfully obtained."
    )
    @Path("/{userName}")
    @APIResponse(responseCode = "400", ref = "illegalRequest")
    @APIResponse(responseCode = "401", ref = "unauthorized")
    @APIResponse(responseCode = "403", ref = "forbiden")
    @APIResponse(responseCode = "404", ref = "notFound")
    @APIResponse(responseCode = "500", ref = "internalError")
    @GET
    Response findByUserName(@PathParam("userName") String userName);

    @Operation(
            description = "Create user",
            operationId = "apiUserResourceAPI.create",
            summary = "Create user"
    )
    @APIResponse(
            name = "OK",
            responseCode = "200",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(
                            ref = "ApiUserResponseDTO"
                    )
            ),
            description = "Request executed successfully. Created user."
    )
    @POST
    @APIResponse(responseCode = "400", ref = "illegalRequest")
    @APIResponse(responseCode = "401", ref = "unauthorized")
    @APIResponse(responseCode = "403", ref = "forbiden")
    @APIResponse(responseCode = "500", ref = "internalError")
    Response create(@Valid ApiUserRequestDTO requestDTO);

    @PUT
    @Path("/{id}")
    @Transactional
    @Operation(
            description = "Update user.",
            operationId = "apiUserResourceAPI.update",
            summary = "Update user."
    )
    @APIResponse(
            name = "OK",
            responseCode = "200",
            description = "Request executed successfully. Updated user."
    )
    @APIResponse(responseCode = "400", ref = "illegalRequest")
    @APIResponse(responseCode = "401", ref = "unauthorized")
    @APIResponse(responseCode = "403", ref = "forbiden")
    @APIResponse(responseCode = "404", ref = "notFound")
    @APIResponse(responseCode = "500", ref = "internalError")
    Response update(@PathParam("id") Long id, @Valid ApiUserRequestDTO requestDTO);

    @DELETE
    @Path("/{id}")
    @Operation(
            description = "Delete user.",
            operationId = "apiUserResourceAPI.delete",
            summary = "Delete user."
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
