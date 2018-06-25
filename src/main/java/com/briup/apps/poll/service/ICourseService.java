package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Course;

public interface ICourseService {
	/**
	 * 查询所有
	 * @return
	 * @throws Exception
	 */
List<Course> findAll() throws Exception;
/**
 * 通过id查询
 * @param id
 * @return
 * @throws Exception
 */

Course findById(long id) throws Exception;

List<Course> query(String keywords) throws Exception;

void saveOrUpdate(Course course) throws Exception;

void delete(long id) throws Exception;
void batchDatele(List<Long> ids)throws Exception;
}
