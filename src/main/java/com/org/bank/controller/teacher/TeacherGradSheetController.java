package com.org.bank.controller.teacher;

import com.org.bank.common.DataUtil;
import com.org.bank.common.ExecuteResult;
import com.org.bank.common.WrapMapper;
import com.org.bank.common.Wrapper;
import com.org.bank.domain.GradSheetDTO;
import com.org.bank.service.GradSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 教师角色可访问的成绩表控制类
 */
@RestController
@RequestMapping("/teacher/gradSheet")
public class TeacherGradSheetController {
    @Autowired
    private GradSheetService gradSheetService;
    @RequestMapping("/deleteByPrimaryKey")
    public Wrapper<?> deleteByPrimaryKey(@RequestBody GradSheetDTO record){
        ExecuteResult<Integer> executeResult = gradSheetService.deleteByPrimaryKey(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("insert")
    public Wrapper<?> insert(@RequestBody GradSheetDTO record){
        ExecuteResult<Integer> executeResult = gradSheetService.insert(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("insertSelective")
    public Wrapper<?> insertSelective(@RequestBody GradSheetDTO record){
        ExecuteResult<Integer> executeResult = gradSheetService.insertSelective(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/selectByPrimaryKey")
    public Wrapper<?> selectByPrimaryKey(@RequestBody GradSheetDTO record){
        ExecuteResult<GradSheetDTO> executeResult = gradSheetService.selectByPrimaryKey(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/selectList")
    public Wrapper<?> selectList(@RequestBody GradSheetDTO record){
        ExecuteResult<DataUtil<GradSheetDTO>> executeResult = gradSheetService.selectList(record,record.getPager());
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/updateByPrimaryKeySelective")
    public Wrapper<?> updateByPrimaryKeySelective(@RequestBody GradSheetDTO record){
        ExecuteResult<Integer> executeResult = gradSheetService.updateByPrimaryKeySelective(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/updateByPrimaryKey")
    public Wrapper<?> updateByPrimaryKey(@RequestBody GradSheetDTO record){
        ExecuteResult<Integer> executeResult = gradSheetService.updateByPrimaryKey(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }
}
