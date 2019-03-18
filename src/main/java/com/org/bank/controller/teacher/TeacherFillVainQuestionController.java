package com.org.bank.controller.teacher;

import com.org.bank.common.DataUtil;
import com.org.bank.common.ExecuteResult;
import com.org.bank.common.WrapMapper;
import com.org.bank.common.Wrapper;
import com.org.bank.config.spring.security.UserSecurityContextHolder;
import com.org.bank.domain.FillVainQuestionDTO;
import com.org.bank.service.FillVainQuestionService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

/**
 * 教师角色可访问的填空题控制类
 */
@RestController
@RequestMapping("/teacher/fillVainQuestion")
@Api(description = "教师角色拥有的填空题控制类")
public class TeacherFillVainQuestionController {
    @Autowired
    private FillVainQuestionService fillVainQuestionService;
    @RequestMapping(value = "/deleteByPrimaryKey",method={RequestMethod.POST})
    public Wrapper<?> deleteByPrimaryKey(@RequestBody FillVainQuestionDTO record){
        ExecuteResult<Integer> executeResult = fillVainQuestionService.deleteByPrimaryKey(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping(value = "/insert",method={RequestMethod.POST})
    public Wrapper<?> insert(@RequestBody FillVainQuestionDTO record, HttpServletRequest httpServletRequest){
        record.setExaminerId(UserSecurityContextHolder.getUserId(httpServletRequest));
        record.setExaminerType(UserSecurityContextHolder.getUserRoleType());
        ExecuteResult<Integer> executeResult = fillVainQuestionService.insert(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping(value = "/insertSelective",method={RequestMethod.POST})
    public Wrapper<?> insertSelective(@RequestBody FillVainQuestionDTO record, HttpServletRequest httpServletRequest){
        record.setExaminerId(UserSecurityContextHolder.getUserId(httpServletRequest));
        record.setExaminerType(UserSecurityContextHolder.getUserRoleType());
        ExecuteResult<Integer> executeResult = fillVainQuestionService.insertSelective(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping(value = "/selectByPrimaryKey",method={RequestMethod.POST})
    public Wrapper<?> selectByPrimaryKey(@RequestBody FillVainQuestionDTO record,HttpServletRequest httpServletRequest){
        record.setExaminerId(UserSecurityContextHolder.getUserId(httpServletRequest));
        record.setExaminerType(UserSecurityContextHolder.getUserRoleType());
        ExecuteResult<FillVainQuestionDTO> executeResult = fillVainQuestionService.selectByPrimaryKey(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping(value = "/selectList",method={RequestMethod.POST})
    public Wrapper<?> selectList(@RequestBody FillVainQuestionDTO record,HttpServletRequest httpServletRequest){
        record.setExaminerId(UserSecurityContextHolder.getUserId(httpServletRequest));
        record.setExaminerType(UserSecurityContextHolder.getUserRoleType());
        record.setLanguageClassificationStatus(1);

        ExecuteResult<DataUtil<FillVainQuestionDTO>> executeResult = fillVainQuestionService.selectList(record,record.getPager());
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping(value = "/updateByPrimaryKeySelective",method={RequestMethod.POST})
    public Wrapper<?> updateByPrimaryKeySelective(@RequestBody FillVainQuestionDTO record){
        ExecuteResult<Integer> executeResult = fillVainQuestionService.updateByPrimaryKeySelective(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping(value = "/updateByPrimaryKey",method={RequestMethod.POST})
    public Wrapper<?> updateByPrimaryKey(@RequestBody FillVainQuestionDTO record){
        ExecuteResult<Integer> executeResult = fillVainQuestionService.updateByPrimaryKey(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    public static void main(String[] args){
        BigDecimal total = new BigDecimal(548.1);
        BigDecimal proportion = new BigDecimal(0.02);
        System.out.println(total.multiply(proportion));
        System.out.println(total.multiply(proportion).setScale(2,BigDecimal.ROUND_DOWN));
        System.out.println(total.multiply(proportion).setScale(2,BigDecimal.ROUND_HALF_UP));

        System.out.println(new BigDecimal(25.32522).setScale(2,BigDecimal.ROUND_DOWN));
        System.out.println(new BigDecimal(1.12345).setScale(2,BigDecimal.ROUND_DOWN));
        System.out.println(new BigDecimal(1.0000000000000000022).setScale(2,BigDecimal.ROUND_DOWN));
        System.out.println(new BigDecimal(1.015555).setScale(2,BigDecimal.ROUND_DOWN));


    }
}
