package com.org.bank.controller.teacher;

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
 * 教师角色可访问的答疑控制类
 */
@RestController
@RequestMapping("/teacher/doubt")
public class TeacherDoubtController {
    @Autowired
    private DoubtService doubtService;
    @RequestMapping("/deleteByPrimaryKey")
    public Wrapper<?> deleteByPrimaryKey(@RequestBody DoubtDTO record){
        ExecuteResult<Integer> executeResult = doubtService.deleteByPrimaryKey(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/insert")
    public Wrapper<?> insert(@RequestBody DoubtDTO record){
        ExecuteResult<Integer> executeResult = doubtService.insert(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/insertSelective")
    public Wrapper<?> insertSelective(@RequestBody DoubtDTO record){
        ExecuteResult<Integer> executeResult = doubtService.insertSelective(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/selectByPrimaryKey")
    public Wrapper<?> selectByPrimaryKey(@RequestBody DoubtDTO record){
        ExecuteResult<DoubtDTO> executeResult = doubtService.selectByPrimaryKey(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/selectList")
    public Wrapper<?> selectList(@RequestBody DoubtDTO record, HttpServletRequest httpServletRequest){
        record.setRespondentId(UserSecurityContextHolder.getUserId(httpServletRequest));
        ExecuteResult<DataUtil<DoubtDTO>> executeResult = doubtService.selectList(record,record.getPager());
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    /**
     * 更新疑问
     * @param record
     * @param httpServletRequest
     * @return
     */
    @RequestMapping("/updateByPrimaryKeySelective")
    public Wrapper<?> updateByPrimaryKeySelective(@RequestBody DoubtDTO record,HttpServletRequest httpServletRequest){
        int userId = UserSecurityContextHolder.getUserId(httpServletRequest);
        String username = UserSecurityContextHolder.getUsername();
        record.setRespondentId(userId);
        record.setRespondentName(username);
        ExecuteResult<Integer> executeResult = doubtService.updateByPrimaryKeySelective(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/updateByPrimaryKey")
    public Wrapper<?> updateByPrimaryKey(@RequestBody DoubtDTO record){
        ExecuteResult<Integer> executeResult = doubtService.updateByPrimaryKey(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }
}
