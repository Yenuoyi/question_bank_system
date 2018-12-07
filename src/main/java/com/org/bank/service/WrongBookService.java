package com.org.bank.service;


import com.org.bank.common.DataUtil;
import com.org.bank.common.ExecuteResult;
import com.org.bank.common.Pager;
import com.org.bank.domain.WrongBookDTO;

import java.util.List;

public interface WrongBookService {
    ExecuteResult<Integer> deleteByPrimaryKey(WrongBookDTO record);

    ExecuteResult<Integer> insert(WrongBookDTO record);

    ExecuteResult<Integer> insertSelective(WrongBookDTO record);

    ExecuteResult<WrongBookDTO> selectByPrimaryKey(WrongBookDTO record);

    ExecuteResult<DataUtil<WrongBookDTO>> selectList(WrongBookDTO record, Pager pager);

    ExecuteResult<DataUtil<WrongBookDTO>> randomSelectWrongBookList(Pager pager);

    ExecuteResult<DataUtil<WrongBookDTO>> selectByPrimaryKeyList(List<Integer> keys);

    ExecuteResult<Integer> updateByPrimaryKeySelective(WrongBookDTO record);

    ExecuteResult<Integer> updateByPrimaryKey(WrongBookDTO record);
}