package com.briup.apps.poll.dao.extend;

import java.util.List;

import com.briup.apps.poll.bean.extend.AnswersVM;

public interface AnswersVMMapper {
	/**
	 * 查询所有，携带survey的信息
	 * @return
	 */
	List<AnswersVM> selectAll();

}
