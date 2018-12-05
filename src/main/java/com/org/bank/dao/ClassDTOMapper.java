package com.org.bank.dao;


import com.org.bank.common.Pager;
import com.org.bank.domain.ClassDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassDTOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ClassDTO record);

    int insertSelective(ClassDTO record);

    ClassDTO selectByPrimaryKey(Integer id);

    List<ClassDTO> selectList(@Param("record") ClassDTO record, @Param("pager")Pager pager);

    Long countTotal(ClassDTO record);

    int updateByPrimaryKeySelective(ClassDTO record);

    int updateByPrimaryKey(ClassDTO record);
}