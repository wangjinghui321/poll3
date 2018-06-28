package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Questionnaire;
import com.briup.apps.poll.bean.QuestionnaireExample;
import com.briup.apps.poll.bean.extend.QuestionnaireVM;
import com.briup.apps.poll.dao.QuestionnaireMapper;
import com.briup.apps.poll.dao.extend.QuestionnaireVMMapper;
import com.briup.apps.poll.service.IQuestionnaireService;

@Service("questionnaireService")
public class QuestionnaireServiceImpl implements IQuestionnaireService {
	@Autowired
	private QuestionnaireMapper questionnaireMapperr;
	@Autowired
	private QuestionnaireVMMapper questionnaireVMMapper;

	@Override
	public List<Questionnaire> findAll() throws Exception {
		QuestionnaireExample example = new QuestionnaireExample();
		return questionnaireMapperr.selectByExampleWithBLOBs(example);
	}

	@Override
	public Questionnaire findById(long id) throws Exception {
		return questionnaireMapperr.selectByPrimaryKey(id);
	}

	@Override
	public void deleteById(long id) throws Exception {
		questionnaireMapperr.deleteByPrimaryKey(id);

	}

	@Override
	public void saveOrUpdate(Questionnaire questionnaire) throws Exception {
		if (questionnaire.getId() != null) {
			questionnaireMapperr.updateByPrimaryKey(questionnaire);
		} else {
			questionnaireMapperr.insert(questionnaire);
		}

	}

	@Override
	public List<Questionnaire> query(String keywords) throws Exception {
		QuestionnaireExample example = new QuestionnaireExample();
		example.createCriteria().andNameLike(keywords);
		return questionnaireMapperr.selectByExampleWithBLOBs(example);
	}

	@Override
	public QuestionnaireVM findQuestionnaireById(long id) throws Exception {
		
		return questionnaireVMMapper.selectById(id);
	}

}
