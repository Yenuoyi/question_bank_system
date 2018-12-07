package com.org.bank.controller.all;

import com.org.bank.common.DataUtil;
import com.org.bank.common.ExecuteResult;
import com.org.bank.common.WrapMapper;
import com.org.bank.common.Wrapper;
import com.org.bank.domain.*;
import com.org.bank.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 随机出习题控制器
 */
@RestController
@RequestMapping("/all/exercise")
public class ExerciseController {
    @Autowired
    private FillVainQuestionService fillVainQuestionService;
    @Autowired
    private MultipleChoiceQuestionService multipleChoiceQuestionService;
    @Autowired
    private ShortAnswerQuestionService shortAnswerQuestionService;
    @Autowired
    private SingleChoiceQuestionService singleChoiceQuestionService;
    @Autowired
    private TrueFalseQuestionService trueFalseQuestionService;

    @RequestMapping("/randomSelectTrueFalseQuestionList")
    public Wrapper<?> randomSelectTrueFalseQuestionList(@RequestBody TrueFalseQuestionDTO record){
        ExecuteResult<DataUtil<TrueFalseQuestionDTO>> executeResult = trueFalseQuestionService.randomSelectTrueFalseQuestionList(record.getPager());
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/trueFalseQuestionCheck")
    public Wrapper<?> trueFalseQuestionCheck(@RequestBody List<TrueFalseQuestionDTO> record){
        ExecuteResult<DataUtil<TrueFalseQuestionDTO>> executeResult = trueFalseQuestionService.checkExercise(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/randomSelectSingleChoiceQuestionList")
    public Wrapper<?> randomSelectSingleChoiceQuestionList(@RequestBody SingleChoiceQuestionDTO record){
        ExecuteResult<DataUtil<SingleChoiceQuestionDTO>> executeResult = singleChoiceQuestionService.randomSelectSingleChoiceQuestionList(record.getPager());
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/singleChoiceQuestionCheck")
    public Wrapper<?> singleChoiceQuestionCheck(@RequestBody List<SingleChoiceQuestionDTO> record){
        ExecuteResult<DataUtil<SingleChoiceQuestionDTO>> executeResult = singleChoiceQuestionService.checkExercize(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/randomSelectShortAnswerQuestionList")
    public Wrapper<?> randomSelectShortAnswerQuestionList(@RequestBody ShortAnswerQuestionDTO record){
        ExecuteResult<DataUtil<ShortAnswerQuestionDTO>> executeResult = shortAnswerQuestionService.randomSelectShortAnswerQuestionList(record.getPager());
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/selectShortAnswerQuestionList")
    public Wrapper<?> selectShortAnswerQuestionList(@RequestBody List<ShortAnswerQuestionDTO> record){
        int recordSize = record.size();
        List<Integer> keys = new ArrayList<>();
        for(int i=0;i < recordSize;i++){
            keys.add(record.get(i).getId());
        }
        ExecuteResult<DataUtil<ShortAnswerQuestionDTO>> executeResult = shortAnswerQuestionService.selectByPrimaryKeyList(keys);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/randomSelectMultipleChoiceQuestionList")
    public Wrapper<?> randomSelectMultipleChoiceQuestionList(@RequestBody MultipleChoiceQuestionDTO record){
        ExecuteResult<DataUtil<MultipleChoiceQuestionDTO>> executeResult = multipleChoiceQuestionService.randomSelectMultipleChoiceQuestionList(record.getPager());
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/multipleChoiceQuestionCheck")
    public Wrapper<?> multipleChoiceQuestionCheck(@RequestBody List<MultipleChoiceQuestionDTO> record){
        ExecuteResult<DataUtil<MultipleChoiceQuestionDTO>> executeResult = multipleChoiceQuestionService.checkExercise(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/randomSelectFillVainQuestionList")
    public Wrapper<?> randomSelectFillVainQuestionList(@RequestBody FillVainQuestionDTO record){
        ExecuteResult<DataUtil<FillVainQuestionDTO>> executeResult = fillVainQuestionService.randomSelectFillVainQuestionList(record.getPager());
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/selectFillVainQuestionList")
    public Wrapper<?> selectFillVainQuestionList(@RequestBody List<FillVainQuestionDTO> record){
        int recordSize = record.size();
        List<Integer> keys = new ArrayList<>();
        for(int i=0;i < recordSize;i++){
            keys.add(record.get(i).getId());
        }
        ExecuteResult<DataUtil<FillVainQuestionDTO>> executeResult = fillVainQuestionService.selectByPrimaryKeyList(keys);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }
}
