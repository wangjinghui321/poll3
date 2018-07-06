package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Answers;
import com.briup.apps.poll.bean.Survey;
import com.briup.apps.poll.bean.extend.SurveyVM;
import com.briup.apps.poll.service.IAnswersService;
import com.briup.apps.poll.service.ISurveyService;
import com.briup.apps.poll.util.MsgResponse;
import com.briup.apps.poll.vm.SurveyAndAnswersVM;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="课调相关接口")
@RestController
@RequestMapping("/survey")
public class SurveyController {
	@Autowired
	private ISurveyService surveyService;
	@Autowired
	private IAnswersService answersService;
	
	
	@ApiOperation(value="根据班级ID查询出该班级下所有的已审核的课调", 
			notes="")
	@GetMapping("findSurveyByClazzId")
	public MsgResponse findSurveyByClazzId(long id){
		try {
			List<SurveyVM> list = surveyService.findByClazzIdAndCheckPass(id);
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	
	
	@ApiOperation(value="预览课调", 
			notes="只有当课调状态为审核通过的时候才能预览课调")
	@GetMapping("previewSurvey")
	public MsgResponse previewSurvey(long id){
		try {
			//1. 课调的信息（课程，班级，讲师，问卷，平均分） SurveyVM
			SurveyVM surveyVM = surveyService.selectById(id);
			if(surveyVM!=null && 
					surveyVM.getStatus().equals(Survey.STATUS_CHECK_PASS)){
				//2. 课调的结果 主观题列表 Answers
				List<Answers> answers = answersService.findAnswersBySurveyId(id);
				//3. 将课调信息和课调答卷信息封装到一个对象中
				SurveyAndAnswersVM savm = new SurveyAndAnswersVM();
				savm.setSurveyVM(surveyVM);
				savm.setAnswers(answers);
				return MsgResponse.success("success", savm);
			} else {
				return MsgResponse.error("课调状态不合法");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	
	@ApiOperation(value="审核课调", 
			notes="只有当前课调的状态为未审核的时候才能被审核，"
					+ "参数id表示课调编号，参数status的取值只能为0/1,"
					+ "如果是0表示审核不通过，如果是1表示审核通过")
	@GetMapping("checkSurvey")
	public MsgResponse checkSurvey(long id,int status){
		try {
			//1. 通过id找课调
			Survey survey = surveyService.findSurveyById(id);
			//2. 判断当前课调的状态是否为未审核状态
			if(survey!=null && survey.getStatus().equals(Survey.STATUS_CHECK_UN)){
				if(status == 0){
					//2.1 审核不通过
					survey.setStatus(Survey.STATUS_CHECK_NOPASS);
				} else {
					//2.0 审核通过
					survey.setStatus(Survey.STATUS_CHECK_PASS);
				}
				surveyService.saveOrupdate(survey);
				return MsgResponse.success("审核完成！", null);
			} else {
				return MsgResponse.error("课调状态不合法");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
}
	
	
	/*
	 * 
	 */
	@ApiOperation(value="去审核课调", notes="返回课调信息及答卷信息")
	@GetMapping("toCheckSurvey")
	public MsgResponse toCheckSurvey(long id){
		try {
			SurveyVM surveyVM=surveyService.selectById(id);
			if(surveyVM.getStatus().equals(Survey.STATUS_CHECK_UN)){
				//surveyVM.setStatus(Survey.STATUS_CHECK_PASS);
				List<Answers> list = answersService.findAnswersBySurveyId(id);
				double total=0;
				for(Answers answers : list){
					String[] arr=answers.getSelections().split("[|]");
					double singleTotal =0;
					for(String a: arr){
						singleTotal +=Integer.parseInt(a);
					}
					double singleAverage=singleTotal/arr.length;
					total+=singleAverage;
				}
				double average = total/list.size();
				surveyVM.setAverage(average);
				//将平均分保存到数据库中
				Survey survey = surveyService.findSurveyById(id);
				//如果数据库中的平均分没有设定，我们再进行设定，否则不做操作
				if(survey.getAverage()== null){
					survey.setAverage(average);
					surveyService.saveOrupdate(survey);
				}
				
				//如何将surveyVM 和list 返回,封装到一个对象中
				SurveyAndAnswersVM savm = new SurveyAndAnswersVM();
				savm.setSurveyVM(surveyVM);
				savm.setAnswers(list);
                 return MsgResponse.success("success", savm);
				
			}else{
				return MsgResponse.error("课调状态不合法");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		
	}
	
	@ApiOperation(value="关闭课调", 
			notes="只有在课调状态为开启的时候才能关闭课调")
	@GetMapping("stopSurvey")
	public MsgResponse stopSurvey(long id){
		try {
			//1. 通过id查询出课调
			Survey survey = surveyService.findSurveyById(id);
			if(survey!=null && survey.getStatus().equals(Survey.STATUS_BEGIN)){
				survey.setStatus(Survey.STATUS_CHECK_UN);
				surveyService.saveOrupdate(survey);
				return MsgResponse.success("关闭课调成功",null);
			} else {
				return MsgResponse.error("当前课调状态必须为未开启状态");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
}
	
	@ApiOperation(value="开启课调", notes="只有在未开启状态下才能开启")
	@GetMapping("beginSurvey")
	public MsgResponse beginSurvey(long id){
		try {
			Survey survey=surveyService.findSurveyById(id);
			
			if(survey.getStatus().equals(Survey.STATUS_INIT)){
				survey.setStatus(Survey.STATUS_BEGIN);
				survey.setCode(survey.getId().toString());
				surveyService.saveOrupdate(survey);
				return MsgResponse.success("开启成功", null);
			}else{
				return MsgResponse.error("当前状态必须为未开启状态");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		
	}
	
	
	@ApiOperation(value="保存或修改课调信息",
			notes="如果参数中包含ID表示修改操作，否则表示保存操作")
    //@PostMapping("saveOrUpdateSurveyVM")
    public MsgResponse saveOrUpdateSurveyVM(Survey survey){
	      try {
			surveyService.saveOrupdateSurveyVM(survey);
			return MsgResponse.success("success", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	
	
	@ApiOperation(value="级联查询所有课调信息及相关信息", notes="包括班级、教师、问卷、课程信息")
	@GetMapping("selectAllSurvey")
	public MsgResponse selectAllSurvey(){
		try {
			List<SurveyVM> list= surveyService.selectAllSurvey();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation(value="查找所有课调信息")
	@GetMapping("findAllSurvey")
	public MsgResponse findAllSurvey(){
		try {
			List<Survey> list=surveyService.findAllSurvey();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation("通过ID查找课调信息")
	@GetMapping("findSurveyById")
	public MsgResponse findSurveyById(@RequestParam long id){
		try {
			Survey list=surveyService.findSurveyById(id);
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation("通过课调编号查找课调信息")
	@GetMapping("querysurvey")
	public MsgResponse querySurvey(String keywords){
		try {
			List<Survey> list=surveyService.querySurvey(keywords);
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	/*
	 * 
	 * 
	 * 
	 * 
	 */
	@ApiOperation(value="保存或修改课调信息",notes="如果参数中包含ID表示修改操作，否则表示保存操作，"
			+ "只需录入clazz_id,course_id,user_id,questionnaire_id")
    @PostMapping("saveOrupdate")
	public MsgResponse saveOrupdate(Survey survey){
		try {
			surveyService.saveOrupdate(survey);
			return MsgResponse.success("success", survey);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation("通过ID删除课调信息")
	@GetMapping("deleteSurveyById")
	public MsgResponse deleteSurveyById(@RequestParam long id){
		try {
			surveyService.deleteSurveyById(id);
			return MsgResponse.success("success", id);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation("批量删除课调信息")
	@PostMapping("batchSurveyDelete")
	public MsgResponse batchSurveyDelete(@RequestParam List<Long> ids){
		try {
			surveyService.batchSurveyDelete(ids);
			return MsgResponse.success("success", ids);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
			// TODO: handle exception
		}
	}
	
	
	@ApiOperation(value="通过ID级联查找课调信息" ,notes="包括班级、教师、问卷、课程信息")
	@GetMapping("selectById")
	public MsgResponse selectById(@RequestParam long id){
		try {
			SurveyVM list=surveyService.selectById(id);
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	

}
