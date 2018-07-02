package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Answers;
import com.briup.apps.poll.bean.AnswersExample;
import com.briup.apps.poll.bean.extend.AnswersVM;
import com.briup.apps.poll.dao.AnswersMapper;
import com.briup.apps.poll.dao.extend.AnswersVMMapper;
import com.briup.apps.poll.service.IAnswersService;

@Service("answersService")
public class AnswersServiceImpl implements IAnswersService {
	@Autowired
	private AnswersMapper answersMapper;
	@Autowired
	private AnswersVMMapper answersVMMapper;

	@Override
	public List<Answers> findAll() throws Exception {
		AnswersExample example = new AnswersExample();
		return answersMapper.selectByExample(example);
	}

	@Override
	public Answers findById(long id) throws Exception {
		return answersMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Answers> query(String keywords) throws Exception {
		AnswersExample example=new AnswersExample();
		return answersMapper.selectByExample(example);
	}

	@Override
	public void deleteById(long id) throws Exception {
		answersMapper.deleteByPrimaryKey(id);

	}

	

	@Override
	public void saveOrUpdate(Answers answers) throws Exception {
		if(answers.getId()!=null){
			answersMapper.updateByPrimaryKey(answers);
		}else{
			answersMapper.insert(answers);
		}

	}

	@Override
	public void batchDatele(List<Long> ids) throws Exception {
		for(long id:ids){
			answersMapper.deleteByPrimaryKey(id);
		}
		
	}

	@Override
	public List<AnswersVM> findAllAnswers() throws Exception {
		return answersVMMapper.selectAll();
	}

	@Override
	public List<Answers> findAnswersBySurveyId(long id) throws Exception {
		
			AnswersExample example = new AnswersExample();
			example.createCriteria().andSurveyIdEqualTo(id);
			return answersMapper.selectByExample(example);
	}
	

	
	

}
