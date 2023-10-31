package com.thehome.api.resources;
import com.thehome.api.dto.request.TaskRequestDTO;
import com.thehome.api.dto.response.TaskResponseDTO;
import com.thehome.api.model.Task;
import com.thehome.api.service.TaskService;
import com.thehome.api.utils.ResponseMapperUtils;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.RestResponse;
import java.util.Optional;

//TODO Essa anotação poderia ficar na interface. Porém parece há um problema com herança de anotações no fluxo de execução SecurityIdentity (Avaliar)
@RolesAllowed("crud")
public class TaskResource implements TaskResourceAPI {

    @Inject
    TaskService taskService;

    @Override
    public Response findAll() {
        return Response.ok(taskService.toResponsesFromEntities(Task.list("order by id"))).build();
    }

    @Override
    public Response findById(Long id) {
        Optional<Task> task = Task.findByIdOptional(id);
        Response response;
        if (task.isPresent()) {
            response = Response.ok(taskService.toResponseFromEntity(task.get())).build();
        } else {
            response = ResponseMapperUtils.notFound();
        }
        return response;
    }

    @Override
    public Response create(TaskRequestDTO requestDTO) {
        Task task = taskService.createEntityFromRequest(requestDTO);
        TaskResponseDTO taskResponseDTO = taskService.toResponseFromEntity(task);
        return Response.status(RestResponse.Status.CREATED).entity(taskResponseDTO).build();
    }

    @Override
    public Response update(Long id, TaskRequestDTO requestDTO) {
        Optional<Task> task = Task.findByIdOptional(id);
        Response response;
        if (task.isPresent()) {
            taskService.updateEntityFromRequest(id, requestDTO);
            response = Response.ok().build();
        } else {
            response = ResponseMapperUtils.badRequest("01", "Task not found");
        }
        return response;
    }

    @Override
    public Response delete(Long id) {
        Optional<Task> task = Task.findByIdOptional(id);
        Response response;
        if (task.isPresent()) {
            taskService.deleteById(task.get().getId());
            response = ResponseMapperUtils.noContent();
        } else {
            response = ResponseMapperUtils.notFound();
        }
        return response;
    }
}
