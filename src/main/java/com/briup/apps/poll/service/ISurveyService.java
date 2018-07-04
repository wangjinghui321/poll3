package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Survey;
import com.briup.apps.poll.bean.extend.SurveyVM;

public interface ISurveyService {
	List<Survey> findAllSurvey() throws Exception;
	
	Survey findSurveyById(long id) throws Exception;
	
	List<Survey> querySurvey(String keywords) throws Exception;
	
	void saveOrupdate(Survey survey) throws Exception;
	
	void deleteSurveyById(long id) throws Exception;
	
	void batchSurveyDelete(List<Long> ids) throws Exception;
	
	//查找课调信息 以及相关的 课程、班级、教师、问卷信息
	List<SurveyVM> selectAllSurvey() throws Exception;
	
	//保存或更新课调及相关、课程、班级、教师、问卷信息
	void saveOrupdateSurveyVM(Survey survey) throws Exception;
	
	//通过ID查找课调信息 以及相关的 课程、班级、教师、问卷信息
	SurveyVM selectById(long id) throws Exception;
	
	List<SurveyVM> findByClazzIdAndCheckPass(long id) throws Exception;

}
