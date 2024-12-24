package com.revature.Services;

import com.revature.DAO.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices {
    private final UserDAO userDAO;

    @Autowired
    public UserServices(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    //TODO Register User

    //TODO LOGIN USER

    //TODO FIND USER BY USER ID

    //TODO UPDATE USER (EMAIL OR PASSWORD)


}
