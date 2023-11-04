package com.thehome.api.service;
import com.thehome.api.dto.request.ApiUserRequestDTO;
import com.thehome.api.dto.response.ApiUserResponseDTO;
import com.thehome.api.model.APIUser;
import com.thehome.api.repository.ApiUserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ApiUserService implements DefaultCRUD<APIUser, ApiUserRequestDTO, ApiUserResponseDTO> {

    @Inject
    ApiUserRepository apiUserRepository;

    @Override
    public APIUser createFromEntity(APIUser apiUser) {
        return apiUserRepository.save(apiUser);
    }

    @Override
    public APIUser createEntityFromRequest(ApiUserRequestDTO apiUserRequestDTO) {
        APIUser apiUser = toEntityFromRequest(apiUserRequestDTO);
        apiUser.setCreatedAt(LocalDateTime.now());
        return apiUserRepository.save(apiUser);
    }

    @Override
    public void deleteById(Long id) {
        apiUserRepository.deleteById(id);
    }

    @Override
    public void updateEntityFromRequest(Long id, ApiUserRequestDTO apiUserRequestDTO) {
        APIUser apiUser = APIUser.findById(id);
        apiUser.setUserName(apiUserRequestDTO.getUserName());
        apiUser.setPassword(apiUserRequestDTO.getPassword());
        apiUser.setRole(apiUserRequestDTO.getRole());
        apiUser.setUpdatedAt(LocalDateTime.now());
        apiUserRepository.save(apiUser);
    }

    @Override
    public List<ApiUserResponseDTO> toResponsesFromEntities(List<APIUser> apiUsers) {
        List<ApiUserResponseDTO> apiUserResponseDTOS = new ArrayList<>();
        apiUsers.forEach(apiUser -> apiUserResponseDTOS.add(toResponseFromEntity(apiUser)));
        return apiUserResponseDTOS;
    }

    @Override
    public ApiUserResponseDTO toResponseFromEntity(APIUser apiUser) {
        return ApiUserResponseDTO.builder()
                .id(apiUser.getId())
                .userName(apiUser.getUserName())
                .password(apiUser.getPassword())
                .role(apiUser.getRole())
                .build();
    }

    @Override
    public APIUser toEntityFromRequest(ApiUserRequestDTO apiUserRequestDTO) {
        return APIUser
                .builder()
                .userName(apiUserRequestDTO.getUserName())
                .password(apiUserRequestDTO.getPassword())
                .role(apiUserRequestDTO.getRole())
                .build();
    }
}
