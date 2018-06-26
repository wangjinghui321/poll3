package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.briup.apps.poll.bean.QuestionnaireQuestion;
import com.briup.apps.poll.service.IQuestionnaireQuestionService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="QQ相关接口")
@RestController
@RequestMapping("/QQ")
public class QuestionnaireQuestionController {

	@Autowired
	private IQuestionnaireQuestionService questionnaireQuestionService;

	@ApiOperation(value="查询信息",notes="查询课程信息的时候输入ID")
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
	@ApiOperation(value="删除信息",notes="删除信息的时候输入ID")
	@GetMapping("deleteQQByID")
	public MsgResponse deleteQQByID(@RequestParam long id){
		try {
			questionnaireQuestionService.deleteById(id);
			//返回成功信息
			return MsgResponse.success("success", id);
		} catch (Exception e) {
			e.printStackTrace();
			//返回失败信息
			return MsgResponse.error(e.getMessage());
		}
	}
	
	 @ApiOperation(value="保存信息",notes="保存课程信息的时候无需输入ID")
	    @PostMapping("insertQQ")
	    public String insert(QuestionnaireQuestion qq){
	    	
	    	try {
	    		questionnaireQuestionService.insert(qq);
				return "保存成功";
			} catch (Exception e) {
				e.printStackTrace();
				return "保存失败"+e.getMessage();
			}
	    }
}
