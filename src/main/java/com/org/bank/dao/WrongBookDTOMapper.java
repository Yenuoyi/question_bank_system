package com.org.bank.dao;

import com.org.bank.common.Pager;
import com.org.bank.domain.DoubtDTO;
import com.org.bank.domain.WrongBookDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WrongBookDTOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WrongBookDTO record);

    int insertSelective(WrongBookDTO record);

    WrongBookDTO selectByPrimaryKey(Integer id);

    List<WrongBookDTO> selectList(@Param("record") WrongBookDTO record, @Param("pager") Pager pager);

    Integer countTotal(WrongBookDTO record);

    int updateByPrimaryKeySelective(WrongBookDTO record);

    int updateByPrimaryKey(WrongBookDTO record);
}