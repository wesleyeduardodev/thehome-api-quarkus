package com.thehome.api.repository;
import com.thehome.api.model.APIUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiUserRepository extends CrudRepository<APIUser, Long> {
}