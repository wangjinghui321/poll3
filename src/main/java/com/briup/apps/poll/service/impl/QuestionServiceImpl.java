package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Options;
import com.briup.apps.poll.bean.OptionsExample;
import com.briup.apps.poll.bean.Question;
import com.briup.apps.poll.bean.QuestionExample;
import com.briup.apps.poll.bean.extend.QuestionVM;
import com.briup.apps.poll.dao.OptionsMapper;
import com.briup.apps.poll.dao.QuestionMapper;
import com.briup.apps.poll.dao.extend.QuestionVMMapper;
import com.briup.apps.poll.service.IQuestionService;

@Service("questionService")
public class QuestionServiceImpl implements IQuestionService {
	@Autowired
	private QuestionMapper questionMapper;
	@Autowired
	private QuestionVMMapper questionVMMapper;
	@Autowired
	private OptionsMapper optionsMapper;

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
				/**
				 * 保存或修改问题
				 */
	@Override
	public void saveOrUpdateQuestionVM(QuestionVM questionVM) throws Exception {
		//1. 先分离questionVM，从中获取Question和Options
		List<Options> options=questionVM.getOptions();
		Question question=new Question();
		question.setId(questionVM.getId());
		question.setName(questionVM.getName());
		question.setQuestiontype(questionVM.getQuestionType());
		//question对象  options所有问题的选项
		
		//2. 判断保存还是修改
		if(question.getId() == null){
			//2.1 保存
			if(question.getQuestiontype().equals("简答题")){
				//2.1.1 保存简答题，只需要保存题目相关信息
				questionMapper.insert(question);
			}else{
				//2.1.2 保存单选和多选时，先保存题目相关信息再保存选项信息
				questionMapper.insert(question);
				    long questionId = question.getId();
					for(Options option : options){
						//为每个option设置question_id
						option.setQuestionId(questionId);
						//保存选项
						optionsMapper.insert(option);
				      }
			}
		}else{
			//2.2 修改
			//2.2.1 修改题目信息
			questionMapper.updateByPrimaryKey(question);
			//2.2.2 修改选项信息（添加新的选项，删除旧的选项，对原有选项修改）
			//1.删除题目原有的选项
			OptionsExample example = new OptionsExample();
			example.createCriteria().andQuestionIdEqualTo(question.getId());
			optionsMapper.deleteByExample(example);
			//2.重新添加选项
			long questionId = question.getId();
			for(Options option : options){
				//为每个option设置question_id
				option.setQuestionId(questionId);
				//保存选项
				optionsMapper.insert(option);
		        }
		}
		
	}

}
