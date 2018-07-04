package com.briup.apps.poll.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Survey;
import com.briup.apps.poll.bean.SurveyExample;
import com.briup.apps.poll.bean.extend.SurveyVM;
import com.briup.apps.poll.dao.SurveyMapper;
import com.briup.apps.poll.dao.extend.SurveyVMMapper;
import com.briup.apps.poll.service.ISurveyService;

@Service
public class SurveyServiceImpl implements ISurveyService{
	@Autowired
    private SurveyMapper surveymapper; 
	@Autowired
	private SurveyVMMapper svmMapper;
	
	
	@Override        //查询课调及相关信息
	public List<SurveyVM> selectAllSurvey() throws Exception {
		// TODO Auto-generated method stub
		return svmMapper.selectAllSurvey();
	}
	@Override
	public List<Survey> findAllSurvey() throws Exception {
		// TODO Auto-generated method stub
		SurveyExample example=new SurveyExample();
		return surveymapper.selectByExample(example);
	}

	@Override
	public Survey findSurveyById(long id) throws Exception {
		// TODO Auto-generated method stub
		return surveymapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Survey> querySurvey(String keywords) throws Exception {
		// TODO Auto-generated method stub
		SurveyExample example=new SurveyExample();
		example.createCriteria().andCodeLike(keywords);
		return surveymapper.selectByExample(example);
	}

	@Override
	public void saveOrupdate(Survey survey) throws Exception {
		// TODO Auto-generated method stub
		if(survey.getId()!=null){
			surveymapper.updateByPrimaryKeySelective(survey);
		}else{
			survey.setStatus(Survey.STATUS_INIT);
			survey.setCode("");
			
			Date now =new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String surveydate=sdf.format(now);
			survey.setSurveydate(surveydate);
			surveymapper.insert(survey);
		}
	}

	@Override
	public void deleteSurveyById(long id) throws Exception {
		// TODO Auto-generated method stub
		surveymapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public void batchSurveyDelete(List<Long> ids) throws Exception {
		// TODO Auto-generated method stub
		for(long id : ids){
			surveymapper.deleteByPrimaryKey(id);
		}
	}
	@Override
	public void saveOrupdateSurveyVM(Survey survey) throws Exception {
		// TODO Auto-generated method stub
		if(survey.getId()!=null){
	        surveymapper.updateByPrimaryKeySelective(survey);
		}else{
			surveymapper.insert(survey);
		}
	}
	@Override
	public SurveyVM selectById(long id) throws Exception {
		return svmMapper.selectById(id);
	}
	@Override
	public List<SurveyVM> findByClazzIdAndCheckPass(long id) throws Exception {
		// TODO Auto-generated method stub
		return svmMapper.selectByClazzIdAndCheckPass(id);
	}

	

}
