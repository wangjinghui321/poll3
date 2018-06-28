package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Answers;

import com.briup.apps.poll.bean.extend.AnswersVM;

import com.briup.apps.poll.service.IAnswersService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "答題卡相关接口")
@RestController
@RequestMapping("/answers")
public class AnswersController {
	@Autowired
private IAnswersService answersService;
	@ApiOperation(value = "查询所有")
	@GetMapping("findAllAnswers")
	public MsgResponse findAllAnswers() {
		try {
			List<Answers> list = answersService.findAll();
			// 返回统一格式的信息 返回成功信息
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			// 返回失败信息
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value = "查询所有",notes="携带survey信息")
	@GetMapping("findAllVM")
	public MsgResponse findAllVM() {
		try {
			List<AnswersVM> list = answersService.findAllAnswers();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@ApiOperation(value = "通过id查询")
	@GetMapping("findById")
	public MsgResponse findById(long id) {
		try {
			Answers answers = answersService.findById(id);
			return MsgResponse.success("success", answers);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@ApiOperation(value = "通过关键字查询")

	@GetMapping("query")
	public MsgResponse query(String keywords) {
		try {
			List<Answers> list = answersService.query(keywords);
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@ApiOperation(value = "保存或更新")
	@PostMapping("saveOrUpdate")
	public MsgResponse saveOrUpdate(Answers answers) {
		try {
			answersService.saveOrUpdate(answers);
			return MsgResponse.success("success", answers);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@ApiOperation(value = "通过id删除")
	@GetMapping("deleteById")
	public MsgResponse deleteById(@RequestParam long id) {
		try {
			answersService.deleteById(id);
			return MsgResponse.success("success", id);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@ApiOperation(value = "批量删除")
	@GetMapping("batchDelete")
	public MsgResponse batchDelete(@RequestParam List<Long> ids) {
		try {
			answersService.batchDatele(ids);
			return MsgResponse.success("success", ids);

		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());

		}
	}
}
