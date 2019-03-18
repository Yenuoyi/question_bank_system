package com.org.bank.controller.admin;

import com.org.bank.common.DataUtil;
import com.org.bank.common.ExecuteResult;
import com.org.bank.common.WrapMapper;
import com.org.bank.common.Wrapper;
import com.org.bank.common.encrypt.Md5Util;
import com.org.bank.config.spring.security.UserSecurityContextHolder;
import com.org.bank.domain.TeacherInfoDTO;
import com.org.bank.service.TeacherInfoService;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 教师控制器
 */
@RestController
@RequestMapping("/admin/teacher")
public class AdminTeacherInfoController {
    private Logger logger = Logger.getLogger(this.getClass());
    @Resource
    private TeacherInfoService teacherInfoService;
    @RequestMapping("/deleteByPrimaryKey")
    public Wrapper<?> deleteByPrimaryKey(@RequestBody TeacherInfoDTO record){
        ExecuteResult<Integer> executeResult = teacherInfoService.deleteByPrimaryKey(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/insert")
    public Wrapper<?> insert(@RequestBody TeacherInfoDTO record){
        TeacherInfoDTO teacherInfoDTO = new TeacherInfoDTO();
        teacherInfoDTO.setTeacherEmail(record.getTeacherEmail());
        /* 添加教师账号默认启用状态 */
        teacherInfoDTO.setStatus(1);

        ExecuteResult<DataUtil<TeacherInfoDTO>> dataUtilExecuteResult = teacherInfoService.selectList(teacherInfoDTO, null);
        if(dataUtilExecuteResult.getResult().getList() != null && dataUtilExecuteResult.getResult().getList().size() > 0){
            return WrapMapper.error().result("请勿重复注册！");
        }
        ExecuteResult<Integer> executeResult = teacherInfoService.insert(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/insertSelective")
    public Wrapper<?> insertSelective(@RequestBody TeacherInfoDTO record){
        TeacherInfoDTO teacherInfoDTO = new TeacherInfoDTO();
        teacherInfoDTO.setTeacherEmail(record.getTeacherEmail());
        /* 添加教师账号默认启用状态 */
        teacherInfoDTO.setStatus(1);

        ExecuteResult<DataUtil<TeacherInfoDTO>> dataUtilExecuteResult = teacherInfoService.selectList(teacherInfoDTO, null);
        if(dataUtilExecuteResult.getResult().getList() != null && dataUtilExecuteResult.getResult().getList().size() > 0){
            return WrapMapper.error().result("请勿重复注册！");
        }
        ExecuteResult<Integer> executeResult = teacherInfoService.insertSelective(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/selectByPrimaryKey")
    public Wrapper<?> selectByPrimaryKey(@RequestBody TeacherInfoDTO record){
        ExecuteResult<TeacherInfoDTO> executeResult = teacherInfoService.selectByPrimaryKey(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/selectList")
    public Wrapper<?> selectList(@RequestBody TeacherInfoDTO record){
        ExecuteResult<DataUtil<TeacherInfoDTO>> executeResult = teacherInfoService.selectList(record,record.getPager());
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/updateByPrimaryKeySelective")
    public Wrapper<?> updateByPrimaryKeySelective(@RequestBody TeacherInfoDTO record){
        ExecuteResult<Integer> executeResult = teacherInfoService.updateByPrimaryKeySelective(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/updateByPrimaryKey")
    public Wrapper<?> updateByPrimaryKey(@RequestBody TeacherInfoDTO record){
        ExecuteResult<Integer> executeResult = teacherInfoService.updateByPrimaryKey(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }
}
