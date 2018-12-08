package com.org.bank.controller.all;

import com.org.bank.common.DataUtil;
import com.org.bank.common.ExecuteResult;
import com.org.bank.common.WrapMapper;
import com.org.bank.common.Wrapper;
import com.org.bank.config.spring.security.UserSecurityContextHolder;
import com.org.bank.domain.StudentInfoDTO;
import com.org.bank.service.StudentInfoService;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 所有人可访问的学生控制类
 */
@RestController
@RequestMapping("/all/student")
public class StudentInfoController {
    private Logger logger = Logger.getLogger(this.getClass());
    @Resource
    private StudentInfoService studentInfoService;

    @RequestMapping("insert")
    public Wrapper<?> insert(@RequestBody StudentInfoDTO record){
        ExecuteResult<Integer> executeResult = studentInfoService.insert(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("insertSelective")
    public Wrapper<?> insertSelective(@RequestBody StudentInfoDTO record){
        ExecuteResult<Integer> executeResult = studentInfoService.insertSelective(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/selectByPrimaryKey")
    public Wrapper<?> selectByPrimaryKey(){
        int studentId = Integer.parseInt(UserSecurityContextHolder.getUsername());
        StudentInfoDTO record = new StudentInfoDTO();
        record.setId(studentId);
        ExecuteResult<StudentInfoDTO> executeResult = studentInfoService.selectByPrimaryKey(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }


    @RequestMapping("/updateByPrimaryKeySelective")
    public Wrapper<?> updateByPrimaryKeySelective(@RequestBody StudentInfoDTO record){
        int id = Integer.parseInt(UserSecurityContextHolder.getUsername());
        record.setId(id);
        ExecuteResult<Integer> executeResult = studentInfoService.updateByPrimaryKeySelective(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/updateByPrimaryKey")
    public Wrapper<?> updateByPrimaryKey(@RequestBody StudentInfoDTO record){
        int id = Integer.parseInt(UserSecurityContextHolder.getUsername());
        record.setId(id);
        ExecuteResult<Integer> executeResult = studentInfoService.updateByPrimaryKey(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/updatePasswordByPrimaryKey")
    public Wrapper<?> updatePasswordByPrimaryKey(@RequestBody StudentInfoDTO record){
        int id = Integer.parseInt(UserSecurityContextHolder.getUsername());
        record.setId(id);
        ExecuteResult<Integer> executeResult = studentInfoService.updatePasswordByPrimaryKey(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }
}
