package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Options;
import com.briup.apps.poll.service.IOptionsService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(description = "题目选项相关接口")
@RestController
@RequestMapping("/options")

public class OptionsController {
	
	@Autowired
	private IOptionsService optionsService;
	
	@ApiOperation(value = "查询所有题目选项")
	@GetMapping("findAllOptions")
	public MsgResponse findAllOptions(){
		try {
			List<Options> list = optionsService.findAll();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value = "通过id查询")
	@GetMapping("findById")
	public MsgResponse findById(@RequestParam long id){
		try {
			Options options = optionsService.findById(id);
			return MsgResponse.success("success", options);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value = "通过关键字查询")
	@GetMapping("query")
	public MsgResponse query(String keywords){
		try {
			List<Options> list = optionsService.query(keywords);
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value = "保存或更新")
	@PostMapping("saveOrUpdate")
	public MsgResponse saveOrUpdate(Options options){
		try {
			optionsService.saveOrUpdate(options);
			return MsgResponse.success("success", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value = "通过id删除")
	@GetMapping("deleteById")
	public MsgResponse deleteById(@RequestParam long id){
		try {
			optionsService.deleteById(id);
			return MsgResponse.success("success", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value = "批量删除")
	@GetMapping("batchDatele")
	public MsgResponse batchDatele(@RequestParam List<Long> ids){
		try {
			optionsService.batchDatele(ids);
			return MsgResponse.success("success", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

}
