package com.cognizant.QuizAttemptDetail.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.QuizAttemptDetail.Model.Question;
@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

}
