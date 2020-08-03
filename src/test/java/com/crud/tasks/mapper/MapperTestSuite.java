package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapperTestSuite {

    @Test
    public void testTaskMapping() {
        //Given
        TaskMapper taskMapper = new TaskMapper();

        Task task = new Task(1L, "test_title1", "test_content1");
        TaskDto taskDto = new TaskDto(2L, "test_title2", "test_content2");
        List<Task> taskList = new ArrayList<>();
        taskList.add(task);

        //When
        TaskDto resultDto = taskMapper.mapToTaskDto(task);
        Task result = taskMapper.mapToTask(taskDto);
        List<TaskDto> resultList = taskMapper.mapToTaskDtoList(taskList);

        //Then
        assertEquals("test_title1", resultDto.getTitle());
        assertEquals("test_title2", result.getTitle());
        assertEquals("test_title1", resultList.get(0).getTitle());
    }
}
