package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Grade;
import com.briup.apps.poll.service.IGradeService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="年级相关接口")
@RestController
@RequestMapping("/grade")
public class GradeController {
	@Autowired
	private IGradeService gradeService;
	@ApiOperation("查找所有年级信息")
	@GetMapping("findAllGrade")
	public MsgResponse findAllGrade(){
		try {
			List<Grade> list=gradeService.findAllGrade();
			
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation("通过ID查找年级信息")
	@GetMapping("findById")
	public MsgResponse findById(@RequestParam long id){
		try {
			Grade list=gradeService.findById(id);
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation("通过班级名查找年级信息")
	@GetMapping("query")
	public MsgResponse query(String keywords){
		try {
			List<Grade> list=gradeService.query(keywords);
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation("添加或修改年级信息")
	@PostMapping("saveOrupdate")
	public MsgResponse saveOrupdate(Grade grade){
		try {
			gradeService.saveOrupdate(grade);
			return MsgResponse.success("success", grade);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation("通过ID删除年级信息")
	@GetMapping("deleteById")
	public MsgResponse deleteById(@RequestParam long id){
		try {
			gradeService.deleteById(id);
			return MsgResponse.success("success", id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation("批量删除年级信息")
	@GetMapping("batchDelete")
	public MsgResponse batchDelete(@RequestParam List<Long> ids){
		try {
			gradeService.batchDelete(ids);
			return MsgResponse.success("success", ids);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
			// TODO: handle exception
		}
	}

}
