package com.cognizant.QuizAttemptDetail.Model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
public class Attempt {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "attempt_id")
	private int attemptId;
	@Temporal(TemporalType.DATE)
	@Column(name = "attemptDate")
	private Date attemptDate;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToMany
	@JoinTable(name = "attempt_question", joinColumns = {@JoinColumn(name = "attempt_id")}, inverseJoinColumns = {@JoinColumn(name = "ques_id")})
	private Set<Question> questionSet;
	
	@ManyToMany
	@JoinTable(name = "attempt_option", joinColumns = {@JoinColumn(name = "attempt_id")}, inverseJoinColumns = {@JoinColumn(name = "option_id")})
	private Set<Options> optionSet;

	public Attempt(Date attemptDate) {
		super();
		this.attemptDate = attemptDate;
	}

	public Attempt() {
		super();
	}

	public int getAttemptId() {
		return attemptId;
	}

	public void setAttemptId(int attemptId) {
		this.attemptId = attemptId;
	}

	public Date getAttemptDate() {
		return attemptDate;
	}

	public void setAttemptDate(Date attemptDate) {
		this.attemptDate = attemptDate;
	}

	@Override
	public String toString() {
		return "Attempt [attemptId=" + attemptId + ", attemptDate=" + attemptDate + "]";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Question> getQuestionSet() {
		return questionSet;
	}

	public void setQuestionSet(Set<Question> questionSet) {
		this.questionSet = questionSet;
	}

	public Set<Options> getOptionSet() {
		return optionSet;
	}

	public void setOptionSet(Set<Options> optionSet) {
		this.optionSet = optionSet;
	}

}
