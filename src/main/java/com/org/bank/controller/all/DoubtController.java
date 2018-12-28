package com.org.bank.controller.all;

import com.org.bank.common.DataUtil;
import com.org.bank.common.ExecuteResult;
import com.org.bank.common.WrapMapper;
import com.org.bank.common.Wrapper;
import com.org.bank.config.spring.security.UserSecurityContextHolder;
import com.org.bank.domain.DoubtDTO;
import com.org.bank.service.DoubtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 所有人可访问的答疑控制类
 */
@RestController
@RequestMapping("/all/doubt")
public class DoubtController {
    @Autowired
    private DoubtService doubtService;


    @RequestMapping("/selectByPrimaryKey")
    public Wrapper<?> selectByPrimaryKey(@RequestBody DoubtDTO record,HttpServletRequest httpServletRequest){
        record.setQuestionerId(UserSecurityContextHolder.getUserId(httpServletRequest));
        ExecuteResult<DoubtDTO> executeResult = doubtService.selectByPrimaryKey(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/selectList")
    public Wrapper<?> selectList(@RequestBody DoubtDTO record, HttpServletRequest httpServletRequest){
        record.setQuestionerId(UserSecurityContextHolder.getUserId(httpServletRequest));
        ExecuteResult<DataUtil<DoubtDTO>> executeResult = doubtService.selectList(record,record.getPager());
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

}
