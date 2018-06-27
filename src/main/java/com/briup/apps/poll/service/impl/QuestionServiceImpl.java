package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Question;
import com.briup.apps.poll.bean.QuestionExample;
import com.briup.apps.poll.bean.extend.QuestionVM;
import com.briup.apps.poll.dao.QuestionMapper;
import com.briup.apps.poll.dao.extend.QuestionVMMapper;
import com.briup.apps.poll.service.IQuestionService;

@Service("questionService")
public class QuestionServiceImpl implements IQuestionService {
	@Autowired
	private QuestionMapper questionMapper;
	@Autowired
	private QuestionVMMapper questionVMMapper;

	public List<Question> findAll() throws Exception {
		QuestionExample example = new QuestionExample();
		return questionMapper.selectByExample(example);
	}

	public Question findById(long id) throws Exception {
		return questionMapper.selectByPrimaryKey(id);
	}

	public List<Question> query(String keywords) throws Exception {
		QuestionExample example = new QuestionExample();
		// 添加了一个条件，name属性中包含Keywords
		example.createCriteria().andNameLike(keywords);
		return questionMapper.selectByExample(example);
	}

	public void saveOrUpdate(Question question) throws Exception {
		if (question.getId() != null) {
			// 更新
			questionMapper.updateByPrimaryKey(question);
		} else {
			// 新增
			questionMapper.insert(question);
		}
	}

	public void deleteById(long id) throws Exception {
		questionMapper.deleteByPrimaryKey(id);

	}

	public void batchDatele(List<Long> ids) throws Exception {
		for (long id : ids) {
			questionMapper.deleteByPrimaryKey(id);
		}

	}

	@Override
	public List<QuestionVM> findAllQuestion() throws Exception {
		
		return questionVMMapper.selectAll();
	}

}
