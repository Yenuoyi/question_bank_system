package com.org.bank.dao;

import com.org.bank.common.Pager;
import com.org.bank.domain.AdminInfoDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminInfoDTOMapper {
    int deleteByPrimaryKey(Integer adminId);

    int insert(AdminInfoDTO record);

    int insertSelective(AdminInfoDTO record);

    AdminInfoDTO selectByPrimaryKey(Integer id);

    AdminInfoDTO selectPasswordByPrimaryKey(Integer id);

    List<AdminInfoDTO> selectList(@Param("record") AdminInfoDTO record, @Param("pager") Pager pager);

    Long countTotal(AdminInfoDTO record);

    int updateByPrimaryKeySelective(AdminInfoDTO record);

    int updateByPrimaryKey(AdminInfoDTO record);

    int updatePasswordByPrimaryKey(AdminInfoDTO record);
}