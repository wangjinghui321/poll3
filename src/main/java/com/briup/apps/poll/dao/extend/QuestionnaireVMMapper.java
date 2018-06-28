package com.briup.apps.poll.dao.extend;

import com.briup.apps.poll.bean.extend.QuestionnaireVM;

public interface QuestionnaireVMMapper {
	/**
	 * 通过id查询问卷信息（包括题目和选项）
	 * @return
	 */
	QuestionnaireVM selectById(long id);
}
