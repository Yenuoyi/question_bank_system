package com.org.bank.service;

import com.org.bank.common.DataUtil;
import com.org.bank.common.ExecuteResult;
import com.org.bank.common.Pager;
import com.org.bank.domain.TeacherInfoDTO;
import org.apache.ibatis.annotations.Param;

public interface TeacherInfoService {
    ExecuteResult<Integer> deleteByPrimaryKey(TeacherInfoDTO record);

    ExecuteResult<Integer> insert(TeacherInfoDTO record);

    ExecuteResult<Integer> insertSelective(TeacherInfoDTO record);

    ExecuteResult<TeacherInfoDTO> selectByPrimaryKey(TeacherInfoDTO record);

    ExecuteResult<DataUtil<TeacherInfoDTO>> selectList(@Param("record")TeacherInfoDTO teacherInfoDTO, @Param("pager") Pager pager);

    ExecuteResult<Integer> updateByPrimaryKeySelective(TeacherInfoDTO record);

    ExecuteResult<Integer> updateByPrimaryKey(TeacherInfoDTO record);
}
