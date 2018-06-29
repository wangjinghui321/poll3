package com.briup.apps.poll.dao.extend;

import java.util.List;

import com.briup.apps.poll.bean.extend.ClazzVM;

public interface ClazzVMMapper {
	/**
	 * 查询所有
	 * @return
	 */
  List<ClazzVM> selectAll();
  
  ClazzVM selectById(long id);
  
}
