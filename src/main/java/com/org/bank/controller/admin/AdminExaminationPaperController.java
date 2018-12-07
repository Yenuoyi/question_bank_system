package com.org.bank.controller.admin;

import com.org.bank.common.DataUtil;
import com.org.bank.common.ExecuteResult;
import com.org.bank.common.WrapMapper;
import com.org.bank.common.Wrapper;
import com.org.bank.domain.ExaminationPaperDTO;
import com.org.bank.service.ExaminationPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 试卷库控制器
 */
@RestController
@RequestMapping("/admin/examinationPaper")
public class AdminExaminationPaperController {
    @Autowired
    private ExaminationPaperService examinationPaperService;
    @RequestMapping("/deleteByPrimaryKey")
    public Wrapper<?> deleteByPrimaryKey(@RequestBody ExaminationPaperDTO record){
        ExecuteResult<Integer> executeResult = examinationPaperService.deleteByPrimaryKey(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("insert")
    public Wrapper<?> insert(@RequestBody ExaminationPaperDTO record){
        ExecuteResult<Integer> executeResult = examinationPaperService.insert(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("insertSelective")
    public Wrapper<?> insertSelective(@RequestBody ExaminationPaperDTO record){
        ExecuteResult<Integer> executeResult = examinationPaperService.insertSelective(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/selectByPrimaryKey")
    public Wrapper<?> selectByPrimaryKey(@RequestBody ExaminationPaperDTO record){
        ExecuteResult<ExaminationPaperDTO> executeResult = examinationPaperService.selectByPrimaryKey(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/selectList")
    public Wrapper<?> selectList(@RequestBody ExaminationPaperDTO record){
        ExecuteResult<DataUtil<ExaminationPaperDTO>> executeResult = examinationPaperService.selectList(record,record.getPager());
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/updateByPrimaryKeySelective")
    public Wrapper<?> updateByPrimaryKeySelective(@RequestBody ExaminationPaperDTO record){
        ExecuteResult<Integer> executeResult = examinationPaperService.updateByPrimaryKeySelective(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/updateByPrimaryKey")
    public Wrapper<?> updateByPrimaryKey(@RequestBody ExaminationPaperDTO record){
        ExecuteResult<Integer> executeResult = examinationPaperService.updateByPrimaryKey(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }
}
