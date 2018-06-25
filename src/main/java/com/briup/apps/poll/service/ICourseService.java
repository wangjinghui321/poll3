package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Course;

public interface ICourseService {
	/**
	 * 查询所有
	 * 
	 * @return
	 * @throws Exception
	 */
	List<Course> findAll() throws Exception;

	/**
	 * 通过id查询
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */

	Course findById(long id) throws Exception;

	/**
	 * 通过关键字查询
	 * 
	 * @param keywords
	 * @return
	 * @throws Exception
	 */

	List<Course> query(String keywords) throws Exception;

	/**
	 * 保存或者更新
	 * 
	 * @param course
	 * @throws Exception
	 */

	void saveOrUpdate(Course course) throws Exception;

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
