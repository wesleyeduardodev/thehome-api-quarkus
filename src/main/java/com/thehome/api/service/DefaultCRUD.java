package com.thehome.api.service;
import java.util.List;

public interface DefaultCRUD<Entity, Request, Response> {

    Entity createFromEntity(Entity entity);

    Entity createEntityFromRequest(Request request);

    void deleteById(Long id);

    void updateEntityFromRequest(Long id, Request request);

    List<Response> toResponsesFromEntities(List<Entity> entities);

    Response toResponseFromEntity(Entity entity);

    Entity toEntityFromRequest(Request request);
}