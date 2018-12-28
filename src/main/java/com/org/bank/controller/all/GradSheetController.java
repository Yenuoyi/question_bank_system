package com.org.bank.controller.all;

import com.org.bank.common.DataUtil;
import com.org.bank.common.ExecuteResult;
import com.org.bank.common.WrapMapper;
import com.org.bank.common.Wrapper;
import com.org.bank.config.spring.security.UserSecurityContextHolder;
import com.org.bank.domain.GradSheetDTO;
import com.org.bank.service.GradSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 所有人可访问的成绩控制类
 */
@RestController
@RequestMapping("/all/gradSheet")
public class GradSheetController {
    @Autowired
    private GradSheetService gradSheetService;

    @RequestMapping("/selectByPrimaryKey")
    public Wrapper<?> selectByPrimaryKey(@RequestBody GradSheetDTO record){
        ExecuteResult<GradSheetDTO> executeResult = gradSheetService.selectByPrimaryKey(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/selectList")
    public Wrapper<?> selectList(@RequestBody GradSheetDTO record, HttpServletRequest httpServletRequest){
        record.setAnswererId(UserSecurityContextHolder.getUserId(httpServletRequest));
        record.setAnswererType(1);
        ExecuteResult<DataUtil<GradSheetDTO>> executeResult = gradSheetService.selectList(record,record.getPager());
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

}
