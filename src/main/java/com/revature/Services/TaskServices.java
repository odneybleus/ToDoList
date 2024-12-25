package com.revature.Services;

import com.revature.DAO.TaskDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServices {

    private final TaskDAO taskDAO;

    @Autowired
    public TaskServices(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    //TODO createTask(TaskDto taskDto, String username)

    //TODO getAllTasks(String username)

    //TODO getTaskById(Long taskId, String username)

    //TODO updateTask(Long taskId, TaskDto updatedTask, String username)

    //TODO deleteTask(Long taskId, String username)

    //TODO markTaskAsComplete(Long taskId, String username)

    //TODO getTasksByStatus(String username, Boolean isCompleted)
}
