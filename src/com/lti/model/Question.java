package com.lti.model;



import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
@Entity
@Table(name="Question")
public class Question implements Serializable {
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
private int question_id;
	
	
	private int questionset;
	public String topic;
	public int  lev;
	@NotEmpty(message = "Question cannot be empty!")
private String question;
	
	/*@OneToOne(cascade=CascadeType.ALL,mappedBy="question")
private Answer answer;*/
	private String option1;
	private String option2;
	 private String option3;
	 private String option4;
	 private int rightanswer;
     private int rightanswer1;
     
  /* @ManyToOne(cascade=CascadeType.ALL)
     @JoinColumn(name="exam_id",nullable=false)
     private Exam examdetails;*/
   /*  @OneToOne
   private User user;*/
    // @JoinColumn(name="Question_qs")
    /* @ManyToOne(cascade=CascadeType.ALL)
     private QuestionSet questionSet;*/
     
     
   /*@ManyToOne(cascade=CascadeType.ALL,mapped by="question")
private QuestionSet questionset;
   */
public Question() {
	super();
}



public Question(int question_id, int questionset, String topic, int lev, String question, String option1,
			String option2, String option3, String option4, int rightanswer, int rightanswer1) {
		super();
		this.question_id = question_id;
		this.questionset = questionset;
		this.topic = topic;
		this.lev = lev;
		this.question = question;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.rightanswer = rightanswer;
		this.rightanswer1 = rightanswer1;
	}
public int getQuestion_id() {
	return question_id;
}

public void setQuestion_id(int question_id) {
	this.question_id = question_id;
}

public String getQuestion() {
	return question;
}

public void setQuestion(String question) {
	this.question = question;
}



public Question(String question) {
	super();

	this.question = question;
	
}

public String getOption1() {
	return option1;
}



public void setOption1(String option1) {
	this.option1 = option1;
}



public String getOption2() {
	return option2;
}



public void setOption2(String option2) {
	this.option2 = option2;
}



public String getOption3() {
	return option3;
}



public void setOption3(String option3) {
	this.option3 = option3;
}



public String getOption4() {
	return option4;
}



public void setOption4(String option4) {
	this.option4 = option4;
}



public int getRightanswer() {
	return rightanswer;
}



public void setRightanswer(int rightanswer) {
	this.rightanswer = rightanswer;
}

public int getRightanswer1() {
	return rightanswer1;
}

public void setRightanswer1(int rightanswer1) {
	this.rightanswer1 = rightanswer1;
}

public int getQuestionset_id() {
	return questionset;
}

public void setQuestionset_id(int questionset_id) {
	this.questionset = questionset_id;
}
public String getTopic() {
	return topic;
}
public void setTopic(String topic) {
	this.topic = topic;
}

public int getLev() {
	return lev;
}

public void setLev(int lev) {
	this.lev = lev;
}



@Override
public String toString() {
	return "Question [question_id=" + question_id + ", questionset=" + questionset + ", topic=" + topic + ", lev=" + lev
			+ ", question=" + question + ", option1=" + option1 + ", option2=" + option2 + ", option3=" + option3
			+ ", option4=" + option4 + ", rightanswer=" + rightanswer + ", rightanswer1=" + rightanswer1 + "]";
}













}
