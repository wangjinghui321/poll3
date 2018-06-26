package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Clazz;
import com.briup.apps.poll.service.IClazzService;
import com.briup.apps.poll.util.MsgResponse;

@RestController
@RequestMapping
public class ClazzController {
	@Autowired
	private IClazzService clazzService;
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
	@GetMapping("saveOrupdate")
	public void savaOrupdate(Clazz clazz){
		try {
			clazzService.saveOrupdate(clazz);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	@GetMapping("deletes")
	public void deletes(Long[] ids){
		try {
			clazzService.deletes(ids);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	@GetMapping("delete")
	public void delete(long id){
		try {
			clazzService.deleteById(id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
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
	

}
