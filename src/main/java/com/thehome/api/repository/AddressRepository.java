package com.thehome.api.repository;
import com.thehome.api.model.Address;
import com.thehome.api.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {
}