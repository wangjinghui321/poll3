package com.briup.apps.poll.bean.extend;

import java.io.Serializable;
import java.util.List;

import com.briup.apps.poll.bean.Answers;
import com.briup.apps.poll.bean.Course;
import com.briup.apps.poll.bean.User;

public class SurveyVM implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Double average;
	private String status;
	private String code;
	private String surveyDate;
	private Course course;
	private User user;
	private ClazzVM clazzVM;
	private QuestionnaireVM questionnaireVM;
	
	private List<Answers> answers;
	
	
	
	public ClazzVM getClazzVM() {
		return clazzVM;
	}
	public void setClazzVM(ClazzVM clazzVM) {
		this.clazzVM = clazzVM;
	}
	
	public QuestionnaireVM getQuestionnaireVM() {
		return questionnaireVM;
	}
	public void setQuestionnaireVM(QuestionnaireVM questionnaireVM) {
		this.questionnaireVM = questionnaireVM;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getSurveyDate() {
		return surveyDate;
	}
	public void setSurveyDate(String surveyDate) {
		this.surveyDate = surveyDate;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public List<Answers> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answers> answers) {
		this.answers = answers;
	}
	public Double getAverage() {
		return average;
	}
	public void setAverage(Double average) {
		this.average = average;
	}
	
	
	

}
