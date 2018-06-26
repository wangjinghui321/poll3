package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.User;


public interface IUserService {
	/**
	 * 查询所有
	 * */
	List<User> findAll() throws Exception;
	
	/**
	 * 通过ID查询
	 * */
	User findById(long id) throws Exception;
	/**
	 * 关键字查询
	 * */
	List<User> query(String keywords) throws Exception;
	/**
	 * 保存或更新
	 * */
	void saveOrUpdate(User user) throws Exception;
	/**
	 * 通过ID删除
	 * */
	void deleteById(long id) throws Exception;
	/**
	 * 批量删除
	 * */
	void batchDelete(Long[] ids) throws Exception;
}
