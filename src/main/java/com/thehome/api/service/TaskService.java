package com.thehome.api.service;
import com.thehome.api.dto.request.TaskRequestDTO;
import com.thehome.api.dto.response.TaskResponseDTO;
import com.thehome.api.model.Task;
import com.thehome.api.repository.TaskRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class TaskService implements DefaultCRUD<Task, TaskRequestDTO, TaskResponseDTO> {

    @Inject
    TaskRepository taskRepository;

    @Override
    public Task createFromEntity(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task createEntityFromRequest(TaskRequestDTO taskRequestDTO) {
        Task task = toEntityFromRequest(taskRequestDTO);
        return taskRepository.save(task);
    }

    @Override
    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public void updateEntityFromRequest(Long id, TaskRequestDTO taskRequestDTO) {
        Task task = Task.findById(id);
        task.setName(taskRequestDTO.getName());
        taskRepository.save(task);
    }

    @Override
    public List<TaskResponseDTO> toResponsesFromEntities(List<Task> tasks) {
        List<TaskResponseDTO> taskResponseDTOS = new ArrayList<>();
        tasks.forEach(task -> taskResponseDTOS.add(toResponseFromEntity(task)));
        return taskResponseDTOS;
    }

    @Override
    public TaskResponseDTO toResponseFromEntity(Task task) {
        return TaskResponseDTO.builder()
                .id(task.getId())
                .name(task.getName())
                .build();
    }

    @Override
    public Task toEntityFromRequest(TaskRequestDTO request) {
        return Task
                .builder()
                .name(request.getName())
                .build();
    }
}
