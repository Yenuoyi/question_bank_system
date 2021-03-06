package com.org.bank.controller.admin;

import com.org.bank.common.DataUtil;
import com.org.bank.common.ExecuteResult;
import com.org.bank.common.WrapMapper;
import com.org.bank.common.Wrapper;
import com.org.bank.common.encrypt.Md5Util;
import com.org.bank.domain.StudentInfoDTO;
import com.org.bank.service.StudentInfoService;
import io.swagger.annotations.Api;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 学生控制器
 */
@RestController
@RequestMapping("/admin/student")
@Api(description = "管理员角色拥有的学生控制器")
public class AdminStudentInfoController {
    private Logger logger = Logger.getLogger(this.getClass());
    @Resource
    private StudentInfoService studentInfoService;
    @RequestMapping(value = "/deleteByPrimaryKey",method={RequestMethod.POST})
    public Wrapper<?> deleteByPrimaryKey(@RequestBody StudentInfoDTO record){
        ExecuteResult<Integer> executeResult = studentInfoService.deleteByPrimaryKey(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping(value = "/insert",method={RequestMethod.POST})
    public Wrapper<?> insert(@RequestBody StudentInfoDTO record){
        StudentInfoDTO studentInfoDTO = new StudentInfoDTO();
        studentInfoDTO.setStudentEmail(record.getStudentEmail());
        ExecuteResult<DataUtil<StudentInfoDTO>> dataUtilExecuteResult = studentInfoService.selectList(studentInfoDTO, null);
        if(dataUtilExecuteResult.getResult().getList() != null && dataUtilExecuteResult.getResult().getList().size() > 0){
            return WrapMapper.error().result("请勿重复注册！");
        }
        ExecuteResult<Integer> executeResult = studentInfoService.insert(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping(value = "/insertSelective",method={RequestMethod.POST})
    public Wrapper<?> insertSelective(@RequestBody StudentInfoDTO record){
        StudentInfoDTO studentInfoDTO = new StudentInfoDTO();
        studentInfoDTO.setStudentEmail(record.getStudentEmail());
        ExecuteResult<DataUtil<StudentInfoDTO>> dataUtilExecuteResult = studentInfoService.selectList(studentInfoDTO, null);
        if(dataUtilExecuteResult.getResult().getList() != null && dataUtilExecuteResult.getResult().getList().size() > 0){
            return WrapMapper.error().result("请勿重复注册！");
        }
        ExecuteResult<Integer> executeResult = studentInfoService.insertSelective(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping(value = "/selectByPrimaryKey",method={RequestMethod.POST})
    public Wrapper<?> selectByPrimaryKey(@RequestBody StudentInfoDTO record){
        ExecuteResult<StudentInfoDTO> executeResult = studentInfoService.selectByPrimaryKey(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping(value = "/selectList",method={RequestMethod.POST})
    public Wrapper<?> selectList(@RequestBody StudentInfoDTO record){
        ExecuteResult<DataUtil<StudentInfoDTO>> executeResult = studentInfoService.selectList(record,record.getPager());
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping(value = "/updateByPrimaryKeySelective",method={RequestMethod.POST})
    public Wrapper<?> updateByPrimaryKeySelective(@RequestBody StudentInfoDTO record){
        ExecuteResult<Integer> executeResult = studentInfoService.updateByPrimaryKeySelective(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping(value = "/updateByPrimaryKey",method={RequestMethod.POST})
    public Wrapper<?> updateByPrimaryKey(@RequestBody StudentInfoDTO record){
        ExecuteResult<Integer> executeResult = studentInfoService.updateByPrimaryKey(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }
}
