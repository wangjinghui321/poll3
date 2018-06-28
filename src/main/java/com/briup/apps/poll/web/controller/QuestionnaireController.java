package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Questionnaire;
import com.briup.apps.poll.bean.extend.QuestionnaireVM;
import com.briup.apps.poll.service.IQuestionnaireService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "问卷相关接口")
@RestController
@RequestMapping("/questionnaire")
public class QuestionnaireController {
	@Autowired
	private IQuestionnaireService questionnaireService;

	@ApiOperation(value = "查询所有")
	@GetMapping("findAll")
	public MsgResponse findAll() {
		try {
			List<Questionnaire> list = questionnaireService.findAll();
			return MsgResponse.success("succss", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation(value = "通过id查询问卷",notes="包含问题和选项")
	@GetMapping("findQuestionnaireVMById")
	public MsgResponse findQuestionnaireVMById(@RequestParam long id) {
		try {
			QuestionnaireVM qnVM = questionnaireService.findQuestionnaireById(id);
			return MsgResponse.success("succss", qnVM);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@ApiOperation(value = "通过id查询")
	@GetMapping("findById")
	public MsgResponse findById(@RequestParam long id) {
		try {
			Questionnaire questionnaire = questionnaireService.findById(id);
			return MsgResponse.success("success", questionnaire);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@ApiOperation(value = "通过关键字查询")
	@GetMapping("query")
	public MsgResponse query(String keywords) {
		try {
			List<Questionnaire> list = questionnaireService.query(keywords);
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@ApiOperation(value = "通过id删除")
	@GetMapping("deleteById")
	public MsgResponse deleteById(@RequestParam long id) {
		try {
			questionnaireService.deleteById(id);
			return MsgResponse.success("success", id);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@ApiOperation(value = "保存或更新")
	@PostMapping("saveOrUpdate")
	public MsgResponse saveOrUpdate(Questionnaire questionnaire) {
		try {
			questionnaireService.saveOrUpdate(questionnaire);
			return MsgResponse.success("success", questionnaire);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

}
