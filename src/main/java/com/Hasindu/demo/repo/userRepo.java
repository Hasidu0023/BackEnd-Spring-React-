package com.Hasindu.demo.repo;

import com.Hasindu.demo.model.User;  // ← Fixed import path
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepo extends JpaRepository<User, Integer> {

}