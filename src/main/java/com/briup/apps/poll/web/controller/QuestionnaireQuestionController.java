package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.QuestionnaireQuestion;
import com.briup.apps.poll.bean.extend.QuestionnaireQuestionVM;
import com.briup.apps.poll.service.IQuestionnaireQuestionService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="问题单相关接口")
@RestController
@RequestMapping("/QQ")
public class QuestionnaireQuestionController {

	@Autowired
	private IQuestionnaireQuestionService questionnaireQuestionService;

	@ApiOperation("查找问题单信息")
	@GetMapping("findAllQQ")
	public MsgResponse findAllQQ(){
		try {
			List<QuestionnaireQuestion> list =questionnaireQuestionService.findAll();
			//返回成功信息
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			//返回失败信息
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="查询所有问题",notes="问题中包含该问题所有的属性信息")
	@GetMapping("findAllQuestionnaireQuestionVM")
	public MsgResponse findAllQuestionnaireQuestionVM() {
		try {
			List<QuestionnaireQuestionVM> list = questionnaireQuestionService.findAllQuestionnaireQuestionVM();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation("添加或修改桥表信息")
	@PostMapping("saveOrUpdateQuestionnaireQuestion")
	public MsgResponse saveOrUpdateQuestionnaireQuestion(QuestionnaireQuestion questionnaireQuestion){
		try {
			questionnaireQuestionService.saveOrUpdateQuestionnaireQuestion(questionnaireQuestion);
			return MsgResponse.success("success", questionnaireQuestion);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation("通过ID删除桥表信息")
	@GetMapping("deleteById")
	public MsgResponse deleteById(@RequestParam long id){
		try {
			questionnaireQuestionService.deleteById(id);
			return MsgResponse.success("success", id);
		} catch (Exception e) {		
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
}
