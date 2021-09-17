package com.cognizant.QuizAttemptDetail.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Options {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "option_id")
	private int option_id;
	@Column(name = "options")
	private String option;
	@Column(name = "value")
	private boolean value;
	@Column(name = "option_score")
	private double optionScore;

	public Options() {
		super();
	}

	public Options(String option, boolean value, double optionScore) {
		super();
		this.option = option;
		this.value = value;
		this.optionScore = optionScore;
	}

	public int getOption_id() {
		return option_id;
	}

	public void setOption_id(int option_id) {
		this.option_id = option_id;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public boolean isValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Options [option_id=" + option_id + ", option=" + option + ", value=" + value + "]";
	}

	public double getOptionScore() {
		return optionScore;
	}

	public void setOptionScore(double optionScore) {
		this.optionScore = optionScore;
	}

}
