package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Clazz;
import com.briup.apps.poll.bean.extend.ClazzVM;
import com.briup.apps.poll.service.IClazzService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="班级相关接口")
@RestController
@RequestMapping
public class ClazzController {
	@Autowired
	private IClazzService clazzService;
	@ApiOperation("查询所有班级信息")
	@GetMapping("find")
	public MsgResponse find(){
		try {
			List<Clazz> list=clazzService.findAllClazz();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
		@ApiOperation(value="查询所有班级信息",notes="班级中携带年级和班主任信息")
		@GetMapping("findAllVM")
		public MsgResponse findAllVM(){
			try {
				List<ClazzVM> list=clazzService.findAll();
				return MsgResponse.success("success", list);
			} catch (Exception e) {
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
		}
	@ApiOperation("保存或修改班级信息")
	@GetMapping("saveOrupdate")
	public void savaOrupdate(Clazz clazz){
		try {
			clazzService.saveOrupdate(clazz);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	@ApiOperation("批量删除班级信息")
	@GetMapping("deletes")
	public void deletes(Long[] ids){
		try {
			clazzService.deletes(ids);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	@ApiOperation("通过id删除班级信息")
	@GetMapping("delete")
	public void delete(long id){
		try {
			clazzService.deleteById(id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	@ApiOperation("通过关键字查询班级信息")
	@GetMapping("findkey")
	public MsgResponse findKey(String keywords){
		try {
		   List<Clazz> list=clazzService.query(keywords);
		   return MsgResponse.success("success", list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="通过ID查询所有班级信息",notes="班级中携带年级和班主任信息")
	@GetMapping("selectById")
	public MsgResponse selectById(@RequestParam long id){
		try {
			ClazzVM list=clazzService.selectById(id);
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	

}
