/*package com.lti.model;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class QuestionSet {
@Id
private int questionset_id;
//@JoinColumn(name="Question_qs")
@OneToMany(cascade=CascadeType.ALL,mappedBy="questionSet")
private List<Question> questions;

private String Topic;

private int  lev;

 private int noofQuestions;

public List<Question> getQuestions() {
	return questions;
}
public void setQuestions(List<Question> questions) {
	this.questions = questions;
}
public int getLevel() {
	return lev;
}
public void setLevel(int level) {
	this.lev = level;
}
public QuestionSet() {
	super();
}
public int getQuestionset_id() {
	return questionset_id;
}

public void setQuestionset_id(int questionset_id) {
	this.questionset_id = questionset_id;
}
public String getTopic() {
	return Topic;
}
public void setTopic(String topic) {
	Topic = topic;
}

public int getNoofQuestions() {
	return noofQuestions;
}
public void setNoofQuestions(int noofQuestions) {
	this.noofQuestions = noofQuestions;
}
@Override
public String toString() {
	return "QuestionSet [questionset_id=" + questionset_id + ", questions=" + questions + ", Topic=" + Topic
			+ ", level=" + lev + ", noofQuestions=" + noofQuestions + "]";
}

}
*/