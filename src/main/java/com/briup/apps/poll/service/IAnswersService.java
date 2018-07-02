package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Answers;
import com.briup.apps.poll.bean.extend.AnswersVM;

public interface IAnswersService {
	
	/*
	 * 通过survey_id查询 answers信息
	 */
	List<Answers> findAnswersBySurveyId(long id) throws Exception;		
	/**
	 * 查询所有
	 * 
	 * @return
	 * @throws Exception
	 */
	List<Answers> findAll() throws Exception;
	/**
	 * 查询所有，携带survey信息
	 * @return
	 * @throws Exception
	 */
	List<AnswersVM> findAllAnswers() throws Exception;

	/**
	 * 通过id查询
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */

	Answers findById(long id) throws Exception;

	/**
	 * 通过关键字查询
	 * 
	 * @param keywords
	 * @return
	 * @throws Exception
	 */
	List<Answers> query(String keywords) throws Exception;

	/**
	 * 通过id删除
	 * 
	 * @param id
	 * @throws Exception
	 */
	void deleteById(long id) throws Exception;

	/**
	 * 批量删除
	 * 
	 * @param ids
	 * @throws Exception
	 */
	void batchDatele(List<Long> ids)throws Exception;

	/**
	 * 保存或者更新
	 * 
	 * @param answers
	 * @throws Exception
	 */
	void saveOrUpdate(Answers answers) throws Exception;

	
}
