package com.org.bank.dao;

import com.org.bank.common.Pager;
import com.org.bank.domain.GradSheetDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradSheetDTOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GradSheetDTO record);

    int insertSelective(GradSheetDTO record);

    GradSheetDTO selectByPrimaryKey(Integer id);

    List<GradSheetDTO> selectList(@Param("record") GradSheetDTO record, @Param("pager") Pager pager);

    Long countTotal(GradSheetDTO record);

    int updateByPrimaryKeySelective(GradSheetDTO record);

    int updateByPrimaryKey(GradSheetDTO record);
}