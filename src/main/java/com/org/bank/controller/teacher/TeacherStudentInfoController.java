package com.org.bank.controller.teacher;

import com.org.bank.common.DataUtil;
import com.org.bank.common.ExecuteResult;
import com.org.bank.common.WrapMapper;
import com.org.bank.common.Wrapper;
import com.org.bank.common.encrypt.Md5Util;
import com.org.bank.config.spring.security.UserSecurityContextHolder;
import com.org.bank.domain.ClassDTO;
import com.org.bank.domain.StudentInfoDTO;
import com.org.bank.service.ClassService;
import com.org.bank.service.StudentInfoService;
import io.swagger.annotations.Api;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 教师角色可访问的学生角色控制类
 */
@RestController
@RequestMapping("/teacher/student")
@Api(description = "教师角色拥有的学生角色控制类")
public class TeacherStudentInfoController {
    private Logger logger = Logger.getLogger(this.getClass());
    @Resource
    private ClassService classService;
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

    @RequestMapping(value = "insert",method={RequestMethod.POST})
    public Wrapper<?> insert(@RequestBody StudentInfoDTO record){
        StudentInfoDTO studentInfoDTO = new StudentInfoDTO();
        studentInfoDTO.setStudentEmail(record.getStudentEmail());
        ExecuteResult<DataUtil<StudentInfoDTO>> dataUtilExecuteResult = studentInfoService.selectList(studentInfoDTO, null);
        if(dataUtilExecuteResult.getResult().getList() != null && dataUtilExecuteResult.getResult().getList().size() > 0){
            return WrapMapper.error().result("请勿重复注册！");
        }
        record.setStudentPassword(Md5Util.encode(record.getStudentPassword()));
        ExecuteResult<Integer> executeResult = studentInfoService.insert(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping(value = "insertSelective",method={RequestMethod.POST})
    public Wrapper<?> insertSelective(@RequestBody StudentInfoDTO record){
        StudentInfoDTO studentInfoDTO = new StudentInfoDTO();
        studentInfoDTO.setStudentEmail(record.getStudentEmail());
        ExecuteResult<DataUtil<StudentInfoDTO>> dataUtilExecuteResult = studentInfoService.selectList(studentInfoDTO, null);
        if(dataUtilExecuteResult.getResult().getList() != null && dataUtilExecuteResult.getResult().getList().size() > 0){
            return WrapMapper.error().result("请勿重复注册！");
        }
        record.setStudentPassword(Md5Util.encode(record.getStudentPassword()));
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
