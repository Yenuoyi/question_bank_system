package com.org.bank.dao;

import com.org.bank.common.DataUtil;
import com.org.bank.common.ExecuteResult;
import com.org.bank.common.Pager;
import com.org.bank.domain.DoubtDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoubtDTOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DoubtDTO record);

    int insertSelective(DoubtDTO record);

    DoubtDTO selectByPrimaryKey(Integer id);

    List<DoubtDTO> selectList(@Param("record") DoubtDTO record, @Param("pager") Pager pager);

    List<DoubtDTO> randomSelectDoubtList(@Param("pager") Pager pager);

    List<DoubtDTO> selectByPrimaryKeyList(@Param("keys") List<Integer> keys);

    Long countTotal(DoubtDTO record);

    int updateByPrimaryKeySelective(DoubtDTO record);

    int updateByPrimaryKey(DoubtDTO record);
}