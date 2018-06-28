package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Question;
import com.briup.apps.poll.bean.extend.QuestionVM;

public interface IQuestionService {
	/**
	 * 查询所有
	 * 
	 * @return
	 * @throws Exception
	 */
	List<Question> findAll() throws Exception;
	/**
	 * 查询所有，携带题目信息
	 * @return
	 * @throws Exception
	 */
	List<QuestionVM> findAllQuestion() throws Exception;

	/**
	 * 通过id查询
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */

	Question findById(long id) throws Exception;

	/**
	 * 通过关键字查询
	 * 
	 * @param keywords
	 * @return
	 * @throws Exception
	 */

	List<Question> query(String keywords) throws Exception;

	/**
	 * 保存或者更新
	 * 
	 * @param course
	 * @throws Exception
	 */

	void saveOrUpdate(Question course) throws Exception;
	/**
	 * 保存或修改（包含选项）
	 * @param course
	 * @throws Exception
	 */
	void saveOrUpdateQuestionVM(QuestionVM questionVM) throws Exception;

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

	void batchDatele(List<Long> ids) throws Exception;
}
