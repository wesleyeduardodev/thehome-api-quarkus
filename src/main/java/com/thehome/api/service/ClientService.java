package com.thehome.api.service;
import com.thehome.api.dto.request.ClientRequestDTO;
import com.thehome.api.dto.response.ClientResponseDTO;
import com.thehome.api.model.Client;
import com.thehome.api.repository.ClientRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ClientService {

    @Inject
    ClientRepository clientRepository;

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public Client createClient(ClientRequestDTO clientRequestDTO) {
        return clientRepository.save(toClientEntity(clientRequestDTO));
    }

    public void deleteClient(Long id) {
        Client.deleteById(id);
    }

    public void updateClient(Long id, ClientRequestDTO clientRequestDTO) {
        Client client = Client.findById(id);
        client.setName(clientRequestDTO.getName());
        client.setCpf(clientRequestDTO.getCpf());
        client.setCnpj(clientRequestDTO.getCnpj());
        client.setTelephone(clientRequestDTO.getTelephone());
        client.setAddress(clientRequestDTO.getAddress());
        client.setEmail(clientRequestDTO.getEmail());
        client.setAddress(clientRequestDTO.getAddress());
        clientRepository.save(client);
    }

    public List<ClientResponseDTO> toClientsResponseDTO(List<Client> clients) {
        List<ClientResponseDTO> clientResponse = new ArrayList<>();
        clients.forEach(client -> clientResponse.add(toClientResponseDTO(client)));
        return clientResponse;
    }

    public ClientResponseDTO toClientResponseDTO(Client client) {
        return ClientResponseDTO.builder()
                .id(client.getId())
                .name(client.getName())
                .cpf(client.getCpf())
                .cnpj(client.getCnpj())
                .telephone(client.getTelephone())
                .email(client.getEmail())
                .address(client.getAddress())
                .build();
    }

    public Client toClientEntity(ClientRequestDTO clientRequestDTO) {
        return Client
                .builder()
                .name(clientRequestDTO.getName())
                .cpf(clientRequestDTO.getCpf())
                .cnpj(clientRequestDTO.getCnpj())
                .telephone(clientRequestDTO.getTelephone())
                .email(clientRequestDTO.getEmail())
                .address(clientRequestDTO.getAddress())
                .build();
    }
}
