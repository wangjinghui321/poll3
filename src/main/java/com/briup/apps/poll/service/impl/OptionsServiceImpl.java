package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Options;
import com.briup.apps.poll.bean.OptionsExample;
import com.briup.apps.poll.dao.OptionsMapper;
import com.briup.apps.poll.service.IOptionsService;

@Service("optionsService")
public class OptionsServiceImpl implements IOptionsService {
 
	@Autowired
	private OptionsMapper optionsMapper;

	@Override
	public List<Options> findAll() throws Exception {
		// TODO Auto-generated method stub
		OptionsExample example = new OptionsExample();
		return optionsMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public Options findById(long id) throws Exception {
		// TODO Auto-generated method stub
		return optionsMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Options> query(String keywords) throws Exception {
		// TODO Auto-generated method stub
		OptionsExample example = new OptionsExample();
		example.createCriteria().andLabelLike(keywords);
		return optionsMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public void saveOrUpdate(Options options) throws Exception {
		// TODO Auto-generated method stub
		if (options.getId() != null) {
			// 更新
			optionsMapper.updateByPrimaryKey(options);
		} else {
			// 保存
			optionsMapper.insert(options);
		}

	}

	@Override
	public void deleteById(long id) throws Exception {
		// TODO Auto-generated method stub
		optionsMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void batchDatele(List<Long> ids) throws Exception {
		// TODO Auto-generated method stub
		for(long id:ids){
			optionsMapper.deleteByPrimaryKey(id);
		}

	}

}
