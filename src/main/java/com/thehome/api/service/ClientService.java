package com.thehome.api.service;
import com.thehome.api.dto.request.ClientRequestDTO;
import com.thehome.api.dto.response.ClientResponseDTO;
import com.thehome.api.model.Client;
import com.thehome.api.repository.ClientRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ClientService implements DefaultCRUD<Client, ClientRequestDTO, ClientResponseDTO> {

    @Inject
    ClientRepository clientRepository;

    @Override
    public Client createFromEntity(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client createEntityFromRequest(ClientRequestDTO clientRequestDTO) {
        Client client = toEntityFromRequest(clientRequestDTO);
        client.setCreatedAt(LocalDateTime.now());
        return clientRepository.save(client);
    }

    @Override
    public void deleteById(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public void updateEntityFromRequest(Long id, ClientRequestDTO clientRequestDTO) {
        Client client = Client.findById(id);
        client.setName(clientRequestDTO.getName());
        client.setCpfCnpj(clientRequestDTO.getCpfCnpj());
        client.setTelephone(clientRequestDTO.getTelephone());
        client.setEmail(clientRequestDTO.getEmail());
        clientRepository.save(client);
    }

    @Override
    public List<ClientResponseDTO> toResponsesFromEntities(List<Client> clients) {
        List<ClientResponseDTO> clientResponse = new ArrayList<>();
        clients.forEach(client -> clientResponse.add(toResponseFromEntity(client)));
        return clientResponse;
    }

    @Override
    public ClientResponseDTO toResponseFromEntity(Client entity) {
        return ClientResponseDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .cpfCnpj(entity.getCpfCnpj())
                .telephone(entity.getTelephone())
                .email(entity.getEmail())
                .build();
    }

    @Override
    public Client toEntityFromRequest(ClientRequestDTO request) {
        return Client
                .builder()
                .name(request.getName())
                .cpfCnpj(request.getCpfCnpj())
                .telephone(request.getTelephone())
                .email(request.getEmail())
                .build();
    }
}
