package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.User;
import com.briup.apps.poll.service.IUserService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="用户相关的接口")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;
	
	@ApiOperation(value="查找所有用户信息 ")
	@GetMapping("findAllUser")
	public MsgResponse findAllUser(){
		try {
			List<User> list = userService.findAll();
			return MsgResponse.success("success",list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="通过ID查找用户信息")
	@GetMapping("findUserById")
	public MsgResponse findById(long id){
		try {
			User user = userService.findById(id);
			return MsgResponse.success("sucdess", user);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="通过关键字查找用户信息",notes="需要输入完整name")
	@GetMapping("query")
	public MsgResponse query(String keywords){
		try {
			List<User> list = userService.query(keywords);
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="保存或更新用户信息",notes="保存时不需要输入ID，更新时需要输入ID")
	@PostMapping("saveOrUpdate")
	public MsgResponse saveOrUpdate(User user){
		try {
			userService.saveOrUpdate(user);
			return MsgResponse.success("success",user);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="通过ID删除用户")
	@GetMapping("deleteById")
	public MsgResponse deleteById(long id){
		try {
			userService.deleteById(id);
			return MsgResponse.success("success", id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="通过一组ID批量删除用户")
	@GetMapping("batchDelete")
	public MsgResponse batchDelete(Long[] ids){
		try {
			userService.batchDelete(ids);
			return MsgResponse.success("success", ids);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
			// TODO: handle exception
		}
	}
}
