package com.org.bank.controller.all;

import com.org.bank.common.DataUtil;
import com.org.bank.common.ExecuteResult;
import com.org.bank.common.WrapMapper;
import com.org.bank.common.Wrapper;
import com.org.bank.domain.FillVainQuestionDTO;
import com.org.bank.service.FillVainQuestionService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 所有人可访问的填空题控制类
 */
@RestController
@RequestMapping("/all/fillVainQuestion")
@Api(description = "学生角色拥有的填空题控制类")
public class FillVainQuestionController {
    @Autowired
    private FillVainQuestionService fillVainQuestionService;

    @RequestMapping(value = "/selectByPrimaryKey",method={RequestMethod.POST})
    public Wrapper<?> selectByPrimaryKey(@RequestBody FillVainQuestionDTO record){
        ExecuteResult<FillVainQuestionDTO> executeResult = fillVainQuestionService.selectByPrimaryKey(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping(value = "/selectList",method={RequestMethod.POST})
    public Wrapper<?> selectList(@RequestBody FillVainQuestionDTO record){
        record.setLanguageClassificationStatus(1);
        ExecuteResult<DataUtil<FillVainQuestionDTO>> executeResult = fillVainQuestionService.selectList(record,record.getPager());
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

}
