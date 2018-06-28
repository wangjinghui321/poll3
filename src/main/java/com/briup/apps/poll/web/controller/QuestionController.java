package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Question;
import com.briup.apps.poll.bean.extend.QuestionVM;
import com.briup.apps.poll.service.IQuestionService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "问题相关接口")
@RestController
@RequestMapping("/question")
public class QuestionController {
	@Autowired
	private IQuestionService questionService;
	
	@ApiOperation(value = "保存或修改问题",notes="当id不为空表示修改，否则表示新增，保存或更新时要提交选项的内容")
	@PostMapping("saveOrUpdateQuestion")
	public MsgResponse saveOrUpdateQuestion(QuestionVM questionVM){
		try {
			questionService.saveOrUpdateQuestionVM(questionVM);
			return MsgResponse.success("success", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation(value = "查询所有信息")
	@GetMapping("findAllQuestion")
	public MsgResponse findAllQuestion() {
		try {
			List<Question> list = questionService.findAll();
			//返回统一格式的信息 返回成功信息
			return MsgResponse.success("question", list);
		} catch (Exception e) {
			e.printStackTrace();
			//返回失败信息
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value = "查询所有信息", notes="携带题目信息")
	@GetMapping("findAllVM")
	public MsgResponse findAllVM() {
		try {
		List<QuestionVM> list=questionService.findAllQuestion();
			//返回统一格式的信息 返回成功信息
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			//返回失败信息
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation(value = "通过ID查询信息")
	@GetMapping("findById")
	public MsgResponse findById(long id) {
		try {
			Question question = questionService.findById(id);
			return MsgResponse.success("success", question);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	
	@ApiOperation(value = "通过关键字查询信息")
	@GetMapping("findByKeywords")
	public MsgResponse query(String keywords){
		try {
			List<Question> question = questionService.query(keywords);
			return MsgResponse.success("success", question);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation(value = "通过id删除")
	@GetMapping("deleteById")
	public MsgResponse deleteById(@RequestParam long id) {
		try {
			questionService.deleteById(id);
			return MsgResponse.success("success", id);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation(value = "批量删除")
	@GetMapping("batchDatele")
	public MsgResponse batchDatele(@RequestParam List<Long> ids){
		try {
			questionService.batchDatele(ids);
			return MsgResponse.success("success", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@ApiOperation(value = "保存或更新")
	@PostMapping("saveOrUpdate")
	public MsgResponse saveOrUpdate(Question question) {
		try {
			questionService.saveOrUpdate(question);

			return MsgResponse.success("success", question);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}

