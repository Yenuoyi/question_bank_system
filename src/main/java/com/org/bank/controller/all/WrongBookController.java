package com.org.bank.controller.all;

import com.org.bank.common.DataUtil;
import com.org.bank.common.ExecuteResult;
import com.org.bank.common.WrapMapper;
import com.org.bank.common.Wrapper;
import com.org.bank.config.spring.security.UserSecurityContextHolder;
import com.org.bank.domain.WrongBookDTO;
import com.org.bank.service.WrongBookService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 所有人可访问的错题本控制类
 */
@RestController
@RequestMapping("/all/wrongBook")
@Api(description = "学生角色拥有的错题本控制类")
public class WrongBookController {
    @Autowired
    private WrongBookService wrongBookService;
    @RequestMapping(value = "/deleteByPrimaryKey",method={RequestMethod.POST})
    public Wrapper<?> deleteByPrimaryKey(@RequestBody WrongBookDTO record){
        ExecuteResult<Integer> executeResult = wrongBookService.deleteByPrimaryKey(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping(value = "insert",method={RequestMethod.POST})
    public Wrapper<?> insert(@RequestBody WrongBookDTO record){
        ExecuteResult<Integer> executeResult = wrongBookService.insert(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping(value = "insertSelective",method={RequestMethod.POST})
    public Wrapper<?> insertSelective(@RequestBody WrongBookDTO record){
        ExecuteResult<Integer> executeResult = wrongBookService.insertSelective(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping(value = "/selectByPrimaryKey",method={RequestMethod.POST})
    public Wrapper<?> selectByPrimaryKey(@RequestBody WrongBookDTO record){
        ExecuteResult<WrongBookDTO> executeResult = wrongBookService.selectByPrimaryKey(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping(value = "/selectList",method={RequestMethod.POST})
    public Wrapper<?> selectList(@RequestBody WrongBookDTO record, HttpServletRequest httpServletRequest){
        int userId = UserSecurityContextHolder.getUserId(httpServletRequest);
        int userType = UserSecurityContextHolder.getUserRoleType();
        record.setUserId(userId);
        record.setUserType(userType);
        ExecuteResult<DataUtil<WrongBookDTO>> executeResult = wrongBookService.selectList(record,record.getPager());
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping(value = "/updateByPrimaryKeySelective",method={RequestMethod.POST})
    public Wrapper<?> updateByPrimaryKeySelective(@RequestBody WrongBookDTO record){
        ExecuteResult<Integer> executeResult = wrongBookService.updateByPrimaryKeySelective(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping(value = "/updateByPrimaryKey",method={RequestMethod.POST})
    public Wrapper<?> updateByPrimaryKey(@RequestBody WrongBookDTO record){
        ExecuteResult<Integer> executeResult = wrongBookService.updateByPrimaryKey(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }
}
