package com.org.bank.controller.all;

import com.org.bank.common.DataUtil;
import com.org.bank.common.ExecuteResult;
import com.org.bank.common.WrapMapper;
import com.org.bank.common.Wrapper;
import com.org.bank.config.spring.security.UserSecurityContextHolder;
import com.org.bank.domain.DoubtDTO;
import com.org.bank.service.DoubtService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 所有人可访问的答疑控制类
 */
@RestController
@RequestMapping("/all/doubt")
@Api(description = "学生角色拥有的答疑控制类")
public class DoubtController {
    @Autowired
    private DoubtService doubtService;


    @RequestMapping(value = "/selectByPrimaryKey",method={RequestMethod.POST})
    public Wrapper<?> selectByPrimaryKey(@RequestBody DoubtDTO record,HttpServletRequest httpServletRequest){
        record.setQuestionerId(UserSecurityContextHolder.getUserId(httpServletRequest));
        ExecuteResult<DoubtDTO> executeResult = doubtService.selectByPrimaryKey(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping(value = "/selectList",method={RequestMethod.POST})
    public Wrapper<?> selectList(@RequestBody DoubtDTO record, HttpServletRequest httpServletRequest){
        record.setQuestionerId(UserSecurityContextHolder.getUserId(httpServletRequest));
        ExecuteResult<DataUtil<DoubtDTO>> executeResult = doubtService.selectList(record,record.getPager());
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    /**
     * 学生提问
     * @param record
     * @param httpServletRequest
     * @return
     */
    @RequestMapping(value = "/insertSelective",method={RequestMethod.POST})
    public Wrapper<?> insertSelective(@RequestBody DoubtDTO record,HttpServletRequest httpServletRequest){
        int userId = UserSecurityContextHolder.getUserId(httpServletRequest);
        String username = UserSecurityContextHolder.getUsername();
        record.setQuestionerId(userId);
        record.setQuestionerName(username);
        ExecuteResult<Integer> executeResult = doubtService.insertSelective(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

}
