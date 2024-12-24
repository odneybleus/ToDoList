package com.revature.DAO;

import com.revature.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO  extends JpaRepository<User, Integer> {

}
