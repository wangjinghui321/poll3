package com.briup.apps.poll.dao.extend;

import java.util.List;

import com.briup.apps.poll.bean.extend.SurveyVM;

public interface SurveyVMMapper {
	
	List<SurveyVM> selectAllSurvey();
	
	void saveOrupdateSurveyVM(SurveyVM surveyVM);
	
	SurveyVM selectById(long id) ;
	
	List<SurveyVM> selectByClazzIdAndCheckPass(long id);

}
