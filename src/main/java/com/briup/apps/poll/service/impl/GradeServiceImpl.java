package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Grade;
import com.briup.apps.poll.bean.GradeExample;
import com.briup.apps.poll.dao.GradeMapper;
import com.briup.apps.poll.service.IGradeService;
@Service
public class GradeServiceImpl implements IGradeService{
	@Autowired
	private GradeMapper grademapper;
	@Override
	public List<Grade> findAllGrade() throws Exception {
		GradeExample example=new GradeExample();
		return grademapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public Grade findById(long id) throws Exception {
		return grademapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Grade> query(String keywords) throws Exception {
		GradeExample example=new GradeExample();
		example.createCriteria().andNameLike(keywords);
		return grademapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public void saveOrupdate(Grade grade) throws Exception {
		if(grade.getId()!=null){
			grademapper.updateByPrimaryKeySelective(grade);
		}else{
			grademapper.insert(grade);
		}
		
	}

	@Override
	public void deleteById(long id) throws Exception {
		grademapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public void batchDelete(List<Long> ids) throws Exception {
		for(long id:ids){
			grademapper.deleteByPrimaryKey(id);
		}
		
	}

}
