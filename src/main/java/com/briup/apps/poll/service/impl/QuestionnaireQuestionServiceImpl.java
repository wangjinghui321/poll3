package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.briup.apps.poll.bean.QuestionnaireQuestion;
import com.briup.apps.poll.bean.QuestionnaireQuestionExample;
import com.briup.apps.poll.bean.extend.QuestionnaireQuestionVM;
import com.briup.apps.poll.dao.QuestionnaireQuestionMapper;
import com.briup.apps.poll.dao.extend.QuestionnaireQuestionVMMapper;
import com.briup.apps.poll.service.IQuestionnaireQuestionService;

@Service
public class QuestionnaireQuestionServiceImpl  implements IQuestionnaireQuestionService{

	@Autowired
	private QuestionnaireQuestionMapper questionnaireQuestionMapper;
	@Autowired
	private QuestionnaireQuestionVMMapper questionnaireQuestionVMMapper;
	@Override
	public List<QuestionnaireQuestion> findAll() throws Exception {
		QuestionnaireQuestionExample example = new QuestionnaireQuestionExample();
		return questionnaireQuestionMapper.selectByExample(example);
	}

	@Override
	public List<QuestionnaireQuestionVM> findAllQuestionnaireQuestionVM() throws Exception {

		return questionnaireQuestionVMMapper.selectAll();
	}

	@Override
	public void saveOrUpdateQuestionnaireQuestion(QuestionnaireQuestion questionnaireQuestion) throws Exception {
		if(questionnaireQuestion.getId()!=null){
			questionnaireQuestionMapper.updateByPrimaryKeySelective(questionnaireQuestion);
		}else {
			questionnaireQuestionMapper.insert(questionnaireQuestion);
		}
		
	}

	@Override
	public void deleteById(long id) throws Exception {
		questionnaireQuestionMapper.deleteByPrimaryKey(id);
		
	}



}
