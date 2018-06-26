package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Course;
import com.briup.apps.poll.bean.CourseExample;
import com.briup.apps.poll.dao.CourseMapper;
import com.briup.apps.poll.service.ICourseService;

@Service
public class CourseServiceImpl implements ICourseService{
	@Autowired
	private CourseMapper coursemapper;

	@Override
	public List<Course> findAllCourse() throws Exception {
		CourseExample example=new CourseExample();
		
		// TODO Auto-generated method stub
		return coursemapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public Course findById(long id) throws Exception {
		// TODO Auto-generated method stub
		return coursemapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Course> query(String keywords) throws Exception {
		// TODO Auto-generated method stub
		CourseExample example=new CourseExample();
		example.createCriteria().andNameLike(keywords);
		return coursemapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public void saveOrupdate(Course course) throws Exception {
		// TODO Auto-generated method stub
		if(course.getId()!=null ){
			coursemapper.updateByPrimaryKeySelective(course);
		}else{
			coursemapper.insert(course);
		}
	}

	@Override
	public void deleteById(long id) throws Exception {
		// TODO Auto-generated method stub
		coursemapper.deleteByPrimaryKey(id);
	}
	public void batchDelete(List<Long> ids) throws Exception{
		for(long id : ids){
			coursemapper.deleteByPrimaryKey(id);
		}
	}

}
