package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Survey;
import com.briup.apps.poll.service.ISurveyService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="课调相关接口")
@RestController
@RequestMapping("/survey")
public class SurveyController {
	@Autowired
	private ISurveyService surveyService;
	@ApiOperation("查找所有课调信息")
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
	@ApiOperation("通过课调编号查找课程信息")
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
	
	@ApiOperation("添加或修改课调信息")
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
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation("批量删除课调信息")
	@GetMapping("batchSurveyDelete")
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

}
