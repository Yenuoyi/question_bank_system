package com.org.bank.controller.admin;

import com.org.bank.common.DataUtil;
import com.org.bank.common.ExecuteResult;
import com.org.bank.common.WrapMapper;
import com.org.bank.common.Wrapper;
import com.org.bank.domain.LanguageClassificationDTO;
import com.org.bank.service.LanguageClassificationService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 管理员角色拥有的程序语言分类控制器
 */
@RestController
@RequestMapping("/admin/languageClassificationController")
public class LanguageClassificationController {
    @Resource
    private LanguageClassificationService languageClassificationService;
    @RequestMapping("/deleteByPrimaryKey")
    public Wrapper<?> deleteByPrimaryKey(@RequestBody LanguageClassificationDTO record){
        ExecuteResult<Integer> executeResult = languageClassificationService.deleteByPrimaryKey(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/insert")
    public Wrapper<?> insert(@RequestBody LanguageClassificationDTO record){
        ExecuteResult<Integer> executeResult = languageClassificationService.insert(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    /**
     * @param httpServletRequest
     * @return
     */
    @RequestMapping("/insertSelective")
    public Wrapper<?> insertSelective(@RequestBody LanguageClassificationDTO record,HttpServletRequest httpServletRequest){
        ExecuteResult<Integer> executeResult = languageClassificationService.insertSelective(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/selectByPrimaryKey")
    public Wrapper<?> selectByPrimaryKey(@RequestBody LanguageClassificationDTO record){
        ExecuteResult<LanguageClassificationDTO> executeResult = languageClassificationService.selectByPrimaryKey(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/selectList")
    public Wrapper<?> selectList(@RequestBody LanguageClassificationDTO record){
        ExecuteResult<DataUtil<LanguageClassificationDTO>> executeResult = languageClassificationService.selectList(record,record.getPager());
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }


    @RequestMapping("/updateByPrimaryKeySelective")
    public Wrapper<?> updateByPrimaryKeySelective(@RequestBody LanguageClassificationDTO record){
        ExecuteResult<Integer> executeResult = languageClassificationService.updateByPrimaryKeySelective(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/updateByPrimaryKey")
    public Wrapper<?> updateByPrimaryKey(@RequestBody LanguageClassificationDTO record){
        ExecuteResult<Integer> executeResult = languageClassificationService.updateByPrimaryKey(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }
}
