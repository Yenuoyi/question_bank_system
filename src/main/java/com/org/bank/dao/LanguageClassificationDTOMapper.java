package com.org.bank.dao;

import com.org.bank.common.Pager;
import com.org.bank.domain.LanguageClassificationDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LanguageClassificationDTOMapper {
    Integer deleteByPrimaryKey(Integer languageClassificationId);

    Integer insert(LanguageClassificationDTO record);

    Integer insertSelective(LanguageClassificationDTO record);

    LanguageClassificationDTO selectByPrimaryKey(Integer languageClassificationId);

    List<LanguageClassificationDTO> selectList(@Param("record")LanguageClassificationDTO record, @Param("pager")Pager pager);

    Long countTotal(@Param("record")LanguageClassificationDTO record);

    Integer updateByPrimaryKeySelective(LanguageClassificationDTO record);

    Integer updateByPrimaryKey(LanguageClassificationDTO record);
}