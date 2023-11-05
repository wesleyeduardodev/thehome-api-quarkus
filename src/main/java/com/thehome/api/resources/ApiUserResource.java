package com.thehome.api.resources;
import com.thehome.api.dto.request.ApiUserRequestDTO;
import com.thehome.api.dto.response.ApiUserResponseDTO;
import com.thehome.api.model.APIUser;
import com.thehome.api.service.ApiUserService;
import com.thehome.api.utils.ResponseMapperUtils;
import jakarta.annotation.security.DenyAll;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.RestResponse;
import java.util.Optional;

public class ApiUserResource implements ApiUserResourceAPI {

    @Inject
    ApiUserService apiUserService;

    @DenyAll
    @Override
    public Response findAll() {
        return Response.ok(apiUserService.toResponsesFromEntities(APIUser.list("order by id"))).build();
    }

    @DenyAll
    @Override
    public Response findByUserName(String userName) {
        Optional<APIUser> apiUser = APIUser.find("userName", userName).firstResultOptional();
        Response response;
        if (apiUser.isPresent()) {
            response = Response.ok(apiUserService.toResponseFromEntity(apiUser.get())).build();
        } else {
            response = ResponseMapperUtils.notFound();
        }
        return response;
    }

    @DenyAll
    @Override
    public Response create(ApiUserRequestDTO requestDTO) {
        APIUser apiUser = apiUserService.createEntityFromRequest(requestDTO);
        ApiUserResponseDTO apiUserResponseDTO = apiUserService.toResponseFromEntity(apiUser);
        return Response.status(RestResponse.Status.CREATED).entity(apiUserResponseDTO).build();
    }

    @DenyAll
    @Override
    public Response update(Long id, ApiUserRequestDTO requestDTO) {
        Optional<APIUser> apiUser = APIUser.findByIdOptional(id);
        Response response;
        if (apiUser.isPresent()) {
            apiUserService.updateEntityFromRequest(id, requestDTO);
            response = Response.ok().build();
        } else {
            response = ResponseMapperUtils.badRequest("01", "User not found");
        }
        return response;
    }

    @DenyAll
    @Override
    public Response delete(Long id) {
        Optional<APIUser> apiUser = APIUser.findByIdOptional(id);
        Response response;
        if (apiUser.isPresent()) {
            apiUserService.deleteById(apiUser.get().getId());
            response = ResponseMapperUtils.noContent();
        } else {
            response = ResponseMapperUtils.notFound();
        }
        return response;
    }
}
