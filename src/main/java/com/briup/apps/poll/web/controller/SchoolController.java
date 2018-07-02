package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.School;
import com.briup.apps.poll.service.ISchoolService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(description = "学校相关接口")
@RestController
@RequestMapping("/school")
public class SchoolController {
	
	@Autowired
	private ISchoolService schoolService;
	
	@ApiOperation(value = "查询所有学校信息")
	@GetMapping("findAllSchool")
	public MsgResponse findAllSchool(){
		try {
			List<School> list = schoolService.findAll();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value = "通过id查询学校信息")
	@GetMapping("findById")
	public MsgResponse findById(long id){
		try {
			School school = schoolService.findById(id);
			return MsgResponse.success("success", school);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation(value = "通过关键字查询学校信息")
	@GetMapping("findByKeywords")
	public MsgResponse query(String keywords){
		try {
			List<School> school = schoolService.query(keywords);
			return MsgResponse.success("success", school);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value = "更新或保存学校信息")
	@PostMapping("insertOrupdate")
	public MsgResponse insertOrupdate(School school){
		try {
			schoolService.insertOrupdate(school);
			return MsgResponse.success("success", school);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	
	@ApiOperation(value = "通过id删除学校信息")
	@GetMapping("deleteById")
	public MsgResponse deleteById(long id){
		try {
			schoolService.deleteByPrimaryKey(id);
			return MsgResponse.success("success", id); 
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value = "批量删除学校信息")
	@GetMapping("batchDelete")
	public MsgResponse batchDelete(@RequestParam List<Long> ids){
		try {
			schoolService.batchDelete(ids);
			return MsgResponse.success("success", ids);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

}







