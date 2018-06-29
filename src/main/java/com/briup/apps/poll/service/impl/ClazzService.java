package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Clazz;
import com.briup.apps.poll.bean.ClazzExample;
import com.briup.apps.poll.bean.extend.ClazzVM;
import com.briup.apps.poll.dao.ClazzMapper;
import com.briup.apps.poll.dao.extend.ClazzVMMapper;
import com.briup.apps.poll.service.IClazzService;

@Service
public class ClazzService implements IClazzService{
    @Autowired
    private ClazzMapper clazzMapper;
    @Autowired
    private ClazzVMMapper clazzVMMapper;
	@Override
	public List<Clazz> findAllClazz() throws Exception {
		// TODO Auto-generated method stub
		ClazzExample example=new ClazzExample();
		return clazzMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public void saveOrupdate(Clazz clazz) throws Exception {
		// TODO Auto-generated method stub
		if(clazz.getId()!=null){
			clazzMapper.updateByPrimaryKeySelective(clazz);
		}else{
			clazzMapper.insert(clazz);
		}	
	}

	@Override
	public void deletes(Long[] ids) throws Exception {
		// TODO Auto-generated method stub
		for(long id:ids){
			clazzMapper.deleteByPrimaryKey(id);
		}
		
	}

	@Override
	public List<Clazz> query(String keywords) throws Exception {
		ClazzExample example=new ClazzExample();
		example.createCriteria().andNameLike(keywords);
		return clazzMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public void deleteById(long id) throws Exception {
		// TODO Auto-generated method stub
		clazzMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public List<ClazzVM> findAll() throws Exception {
		// TODO Auto-generated method stub
		return clazzVMMapper.selectAll();
	}

	@Override
	public ClazzVM selectById(long id) throws Exception {
		return clazzVMMapper.selectById(id);
	}
}
