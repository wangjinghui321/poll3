package com.briup.apps.poll.bean.extend;


import com.briup.apps.poll.bean.Question;
import com.briup.apps.poll.bean.Questionnaire;

public class QuestionnaireQuestionVM {

	private Long id;
	private Questionnaire questionnaire;
	private Question question;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}
	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	
	
}
