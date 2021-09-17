package com.cognizant.QuizAttemptDetail.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.QuizAttemptDetail.Model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
