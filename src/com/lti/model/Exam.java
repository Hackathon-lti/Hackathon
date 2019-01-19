package com.lti.model
;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Exam {

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int exam_id;
private int user_choice;
@OneToOne
	@JoinColumn(name="userId")
	private User user_details;
	
	
	public Exam() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getExam_id() {
		return exam_id;
	}

	public void setExam_id(int exam_id) {
		this.exam_id = exam_id;
	}

	public int getUser_choice() {
		return user_choice;
	}

	public void setUser_choice(int user_choice) {
		this.user_choice = user_choice;
	}


public User getUser_details() {
		return user_details;
	}

	public void setUser_details(User user_details) {
		this.user_details = user_details;
	}
public Exam(int exam_id, int user_choice, int user_choice1, User user_details, List<Question> listQuestion) {
		super();
		this.exam_id = exam_id;
		this.user_choice = user_choice;

		this.user_details = user_details;
		
	}

	@Override
	public String toString() {
		return "Exam [exam_id=" + exam_id + ", user_choice=" + user_choice + 
				 ", user_details=" + user_details + " ]";
	}
}
