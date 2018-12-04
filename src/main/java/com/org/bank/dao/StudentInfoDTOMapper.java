package com.org.bank.dao;

import com.org.bank.common.Pager;
import com.org.bank.domain.StudentInfoDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentInfoDTOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StudentInfoDTO record);

    int insertSelective(StudentInfoDTO record);

    StudentInfoDTO selectByPrimaryKey(Integer id);

    List<StudentInfoDTO> selectList(@Param("record")StudentInfoDTO studentInfoDTO, @Param("pager") Pager pager);

    Integer countTotal(StudentInfoDTO record);

    int updateByPrimaryKeySelective(StudentInfoDTO record);

    int updateByPrimaryKey(StudentInfoDTO record);
}