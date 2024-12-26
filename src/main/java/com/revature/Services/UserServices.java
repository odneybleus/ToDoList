package com.revature.Services;

import com.revature.DAO.TaskDAO;
import com.revature.DAO.UserDAO;
import com.revature.Models.Task;
import com.revature.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServices {
    private final UserDAO userDAO;
    private final TaskDAO taskDAO;

    @Autowired
    public UserServices(UserDAO userDAO, TaskDAO taskDAO) {
        this.userDAO = userDAO;
        this.taskDAO = taskDAO;
    }



    //TODO create User
    public User createUser(User user){
        return userDAO.save(user);
    }

    //TODO get all customers

    public List<User> getAllUsers(){
        return userDAO.findAll();
    }

    //TODO Get User by id
    public Optional<User> getUserById(int userID){
        return userDAO.findById(userID);
    }

    //TODO Get user by username
    public Optional<User> getUserByUsername(String username){
        Optional<User> possibleUser = userDAO.getUserByUsername(username);
        return  possibleUser;
    }

    //TODO Delete User
    public void deleteUser(User user){
        userDAO.delete(user);
    }

    //TODO Update User
    public User updateUser(User user){
        return userDAO.save(user);
    }

    //TODO LOGIN USER
    public User loginUser(String userName, String password){
        Optional<User> possibleUser = userDAO.getUserByUsername(userName);
        if(possibleUser.isEmpty()){
            return null;
        }
        User actualUser = possibleUser.get();

        if(actualUser.getUserPassword().equals(password)){
            return actualUser;
        }
        return null;
    }

    //TODO ADD Task TO User
    public User addTaskToUser(String username, int taskID){
        Optional<User> possibleUser = userDAO.getUserByUsername(username);
        Optional<Task> possibleTask = taskDAO.findById(taskID);
        if (possibleUser.isEmpty() || possibleTask.isEmpty()){
            return null;
        }
        User actualUser = possibleUser.get();
        Task actualTask = possibleTask.get();

        Set<Task> taskItems =actualUser.getTasks();
        taskItems.add(actualTask);
        actualUser.setTasks(taskItems);
        return userDAO.save(actualUser);
    }

    //TODO REMOVE TASK
    public User removeTaskToUser(String username, int taskID){
        Optional<User> possibleUser = userDAO.getUserByUsername(username);
        Optional<Task> possibleTask = taskDAO.findById(taskID);
        if (possibleUser.isEmpty() || possibleTask.isEmpty()){
            return null;
        }
        User actualUser = possibleUser.get();
        Task actualTask = possibleTask.get();

        if(!actualUser.getTasks().contains(actualTask)){
            return null;
        }
        Set<Task> taskItems =actualUser.getTasks();
        taskItems.remove(actualTask);
        actualUser.setTasks(taskItems);
        return userDAO.save(actualUser);
    }

}
