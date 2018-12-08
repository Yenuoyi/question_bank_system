package com.org.bank.controller.all;

import com.org.bank.common.*;
import com.org.bank.domain.*;
import com.org.bank.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
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

    @RequestMapping("/proportionExercise")
    public Wrapper<?> proportionExercise(@RequestBody ExerciseNumberDTO record){
        int total = 40;
        int fillVainNumber = total * record.getFillVainProportion();
        if((total * record.getFillVainProportion()) >= 0.5){
            ++fillVainNumber;
        }
        int multiPleChoice = total * record.getMultipleChoiceProportion();
        if((total * record.getMultipleChoiceProportion()) >= 0.5){
            ++multiPleChoice;
        }
        int shortAnswer = total * record.getShortAnswerProportion();
        if((total * record.getShortAnswerProportion()) >= 0.5){
            ++shortAnswer;
        }
        int singleChoice = total * record.getSingleChoiceProportion();
        if((total * record.getSingleChoiceProportion()) >= 0.5){
            ++singleChoice;
        }
        int trueFalse = total * record.getTrueFalseProportion();
        if((total * record.getTrueFalseProportion()) >= 0.5){
            ++trueFalse;
        }
        int realTotal = fillVainNumber + multiPleChoice +shortAnswer +singleChoice + trueFalse;
        if(realTotal > total){
            int margin = realTotal - total;
            int[] array = {fillVainNumber,multiPleChoice,shortAnswer,singleChoice,trueFalse};
            Arrays.sort(array);
            if(array[4] == fillVainNumber){
                --fillVainNumber;
            }else
            if(array[4] == multiPleChoice){
                --multiPleChoice;
            }else
            if(array[4] == shortAnswer){
                --shortAnswer;
            }else
            if(array[4] == singleChoice){
                --singleChoice;
            }else
            if(array[4] == trueFalse){
                --trueFalse;
            }

        }
        record.setFillVainNumber(fillVainNumber);
        record.setMultipleChoiceNumber(multiPleChoice);
        record.setShortAnswerNumber(shortAnswer);
        record.setSingleChoiceNumber(singleChoice);
        record.setTrueFalseNumber(trueFalse);

        Pager pager = new Pager();
        pager.setRows(record.getFillVainNumber());
        List<FillVainQuestionDTO> fillVainQuestionDTOS = (List<FillVainQuestionDTO>) fillVainQuestionService.randomSelectFillVainQuestionList(pager).getResult().getList();
        record.setFillVainQuestionDTOS(fillVainQuestionDTOS);

        pager.setRows(record.getMultipleChoiceNumber());
        List<MultipleChoiceQuestionDTO> multipleChoiceQuestionDTOS = (List<MultipleChoiceQuestionDTO>) multipleChoiceQuestionService.randomSelectMultipleChoiceQuestionList(pager).getResult().getList();
        record.setMultipleChoiceQuestionDTOS(multipleChoiceQuestionDTOS);

        pager.setRows(record.getShortAnswerNumber());
        List<ShortAnswerQuestionDTO> shortAnswerQuestionDTOS= (List<ShortAnswerQuestionDTO>) shortAnswerQuestionService.randomSelectShortAnswerQuestionList(pager).getResult().getList();
        record.setShortAnswerQuestionDTOS(shortAnswerQuestionDTOS);

        pager.setRows(record.getSingleChoiceNumber());
        List<SingleChoiceQuestionDTO> singleChoiceQuestionDTOS = (List<SingleChoiceQuestionDTO>) singleChoiceQuestionService.randomSelectSingleChoiceQuestionList(pager).getResult().getList();
        record.setSingleChoiceQuestionDTOS(singleChoiceQuestionDTOS);

        pager.setRows(record.getTrueFalseNumber());
        List<TrueFalseQuestionDTO> trueFalseQuestionDTOS = (List<TrueFalseQuestionDTO>) trueFalseQuestionService.randomSelectTrueFalseQuestionList(pager).getResult().getList();
        record.setTrueFalseQuestionDTOS(trueFalseQuestionDTOS);
        return WrapMapper.ok().result(record);
    }

    @RequestMapping("/numberExercise")
    public Wrapper<?> numberExercise(@RequestBody ExerciseNumberDTO record){
        Pager pager = new Pager();
        pager.setRows(record.getFillVainNumber());
        List<FillVainQuestionDTO> fillVainQuestionDTOS = (List<FillVainQuestionDTO>) fillVainQuestionService.randomSelectFillVainQuestionList(pager).getResult().getList();
        record.setFillVainQuestionDTOS(fillVainQuestionDTOS);

        pager.setRows(record.getMultipleChoiceNumber());
        List<MultipleChoiceQuestionDTO> multipleChoiceQuestionDTOS = (List<MultipleChoiceQuestionDTO>) multipleChoiceQuestionService.randomSelectMultipleChoiceQuestionList(pager).getResult().getList();
        record.setMultipleChoiceQuestionDTOS(multipleChoiceQuestionDTOS);

        pager.setRows(record.getShortAnswerNumber());
        List<ShortAnswerQuestionDTO> shortAnswerQuestionDTOS= (List<ShortAnswerQuestionDTO>) shortAnswerQuestionService.randomSelectShortAnswerQuestionList(pager).getResult().getList();
        record.setShortAnswerQuestionDTOS(shortAnswerQuestionDTOS);

        pager.setRows(record.getSingleChoiceNumber());
        List<SingleChoiceQuestionDTO> singleChoiceQuestionDTOS = (List<SingleChoiceQuestionDTO>) singleChoiceQuestionService.randomSelectSingleChoiceQuestionList(pager).getResult().getList();
        record.setSingleChoiceQuestionDTOS(singleChoiceQuestionDTOS);

        pager.setRows(record.getTrueFalseNumber());
        List<TrueFalseQuestionDTO> trueFalseQuestionDTOS = (List<TrueFalseQuestionDTO>) trueFalseQuestionService.randomSelectTrueFalseQuestionList(pager).getResult().getList();
        record.setTrueFalseQuestionDTOS(trueFalseQuestionDTOS);

        return WrapMapper.ok().result(record);
    }

    @RequestMapping("/exerciseCheck")
    public Wrapper<?> numberExerciseCheck(@RequestBody ExerciseNumberDTO record){
        List<Integer> fillVainQuestionKeys = new ArrayList<>();
        for(int i=0;i<record.getFillVainQuestionDTOS().size();i++){
            fillVainQuestionKeys.add(record.getFillVainQuestionDTOS().get(i).getId());
        }
        List<FillVainQuestionDTO> fillVainQuestionDTOS = (List<FillVainQuestionDTO>) fillVainQuestionService.selectByPrimaryKeyList(fillVainQuestionKeys).getResult().getList();
        record.setFillVainQuestionDTOS(fillVainQuestionDTOS);

        List<MultipleChoiceQuestionDTO> multipleChoiceQuestionDTOS = (List<MultipleChoiceQuestionDTO>) multipleChoiceQuestionService.checkExercise(record.getMultipleChoiceQuestionDTOS()).getResult().getList();
        record.setMultipleChoiceQuestionDTOS(multipleChoiceQuestionDTOS);

        List<Integer> shortAnswerQuestionKeys = new ArrayList<>();
        for(int i=0;i<record.getShortAnswerQuestionDTOS().size();i++){
            shortAnswerQuestionKeys.add(record.getShortAnswerQuestionDTOS().get(i).getId());
        }
        List<ShortAnswerQuestionDTO> shortAnswerQuestionDTOS= (List<ShortAnswerQuestionDTO>) shortAnswerQuestionService.selectByPrimaryKeyList(shortAnswerQuestionKeys).getResult().getList();
        record.setShortAnswerQuestionDTOS(shortAnswerQuestionDTOS);

        List<SingleChoiceQuestionDTO> singleChoiceQuestionDTOS = (List<SingleChoiceQuestionDTO>) singleChoiceQuestionService.checkExercize(record.getSingleChoiceQuestionDTOS()).getResult().getList();
        record.setSingleChoiceQuestionDTOS(singleChoiceQuestionDTOS);

        List<TrueFalseQuestionDTO> trueFalseQuestionDTOS = (List<TrueFalseQuestionDTO>) trueFalseQuestionService.checkExercise(record.getTrueFalseQuestionDTOS()).getResult().getList();
        record.setTrueFalseQuestionDTOS(trueFalseQuestionDTOS);

        return WrapMapper.ok().result(record);
    }
}
