package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Questionnaire;
import com.briup.apps.poll.bean.extend.QuestionnaireVM;

public interface IQuestionnaireService {
	/**
	 * 查询所有
	 * 
	 * @return
	 * @throws Exception
	 */
	List<Questionnaire> findAll() throws Exception;
	/**
	 * 查询所有问卷（包含题目和选项）
	 * @return
	 * @throws Exception
	 */
	QuestionnaireVM findQuestionnaireById(long id) throws Exception;

	/**
	 * 通过id查询
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Questionnaire findById(long id) throws Exception;

	/**
	 * 通过关键字查询
	 * 
	 * @param keywords
	 * @return
	 * @throws Exception
	 */

	List<Questionnaire> query(String keywords) throws Exception;

	/**
	 * 通过id删除
	 * 
	 * @param id
	 * @throws Exception
	 */
	void deleteById(long id) throws Exception;

	/**
	 * 保存或更新
	 * 
	 * @param questionnaire
	 * @throws Exception
	 */
	void saveOrUpdate(Questionnaire questionnaire) throws Exception;
}
