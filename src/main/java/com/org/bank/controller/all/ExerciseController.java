package com.org.bank.controller.all;

import com.alibaba.fastjson.JSONObject;
import com.org.bank.common.*;
import com.org.bank.domain.*;
import com.org.bank.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
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
        record.setLanguageClassificationStatus(1);
        ExecuteResult<DataUtil<TrueFalseQuestionDTO>> executeResult = trueFalseQuestionService.randomSelectTrueFalseQuestionList(record.getPager());
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/trueFalseQuestionCheck")
    public Wrapper<?> trueFalseQuestionCheck(@RequestBody List<TrueFalseQuestionDTO> record, HttpServletRequest httpServletRequest){
        ExecuteResult<DataUtil<TrueFalseQuestionDTO>> executeResult = trueFalseQuestionService.checkExercise(record,httpServletRequest);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/randomSelectSingleChoiceQuestionList")
    public Wrapper<?> randomSelectSingleChoiceQuestionList(@RequestBody SingleChoiceQuestionDTO record){
        record.setLanguageClassificationStatus(1);
        ExecuteResult<DataUtil<SingleChoiceQuestionDTO>> executeResult = singleChoiceQuestionService.randomSelectSingleChoiceQuestionList(record.getPager());
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/singleChoiceQuestionCheck")
    public Wrapper<?> singleChoiceQuestionCheck(@RequestBody List<SingleChoiceQuestionDTO> record, HttpServletRequest httpServletRequest){
        ExecuteResult<DataUtil<SingleChoiceQuestionDTO>> executeResult = singleChoiceQuestionService.checkExercise(record,httpServletRequest);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/randomSelectShortAnswerQuestionList")
    public Wrapper<?> randomSelectShortAnswerQuestionList(@RequestBody ShortAnswerQuestionDTO record){
        record.setLanguageClassificationStatus(1);
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
        record.setLanguageClassificationStatus(1);
        ExecuteResult<DataUtil<MultipleChoiceQuestionDTO>> executeResult = multipleChoiceQuestionService.randomSelectMultipleChoiceQuestionList(record.getPager());
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/multipleChoiceQuestionCheck")
    public Wrapper<?> multipleChoiceQuestionCheck(@RequestBody List<MultipleChoiceQuestionDTO> record, HttpServletRequest httpServletRequest){
        ExecuteResult<DataUtil<MultipleChoiceQuestionDTO>> executeResult = multipleChoiceQuestionService.checkExercise(record,httpServletRequest);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/randomSelectFillVainQuestionList")
    public Wrapper<?> randomSelectFillVainQuestionList(@RequestBody FillVainQuestionDTO record){
        record.setLanguageClassificationStatus(1);
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

    /**
     * 按比例出题
     * @param record
     * @return
     */
    @RequestMapping("/proportionExercise")
    public Wrapper<?> proportionExercise(@RequestBody ExerciseNumberDTO record){
        /* 计算预计出题数量 */
        int total = 40;
        int fillVainNumber = new Double(total * record.getFillVainProportion()).intValue();
        int multiPleChoice = new Double(total * record.getMultipleChoiceProportion()).intValue();
        int shortAnswer = new Double(total * record.getShortAnswerProportion()).intValue();
        int singleChoice = new Double(total * record.getSingleChoiceProportion()).intValue();
        int trueFalse = new Double(total * record.getTrueFalseProportion()).intValue();

        /* 筛选实际出题数*/
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
        if(record.getFillVainNumber() > 0){
            pager.setRows(record.getFillVainNumber());
            List<FillVainQuestionDTO> fillVainQuestionDTOS = (List<FillVainQuestionDTO>) fillVainQuestionService.randomSelectFillVainQuestionList(pager).getResult().getList();
            record.setFillVainQuestionDTOS(fillVainQuestionDTOS);
        }else{
            List<FillVainQuestionDTO> fillVainQuestionDTOS = new ArrayList<>();
            record.setFillVainQuestionDTOS(fillVainQuestionDTOS);
        }

        if(record.getMultipleChoiceNumber() > 0){
            pager.setRows(record.getMultipleChoiceNumber());
            List<MultipleChoiceQuestionDTO> multipleChoiceQuestionDTOS = (List<MultipleChoiceQuestionDTO>) multipleChoiceQuestionService.randomSelectMultipleChoiceQuestionList(pager).getResult().getList();
            record.setMultipleChoiceQuestionDTOS(multipleChoiceQuestionDTOS);
        }else{
            List<MultipleChoiceQuestionDTO> multipleChoiceQuestionDTOS = new ArrayList<>();
            record.setMultipleChoiceQuestionDTOS(multipleChoiceQuestionDTOS);
        }

        if(record.getShortAnswerNumber() > 0){
            pager.setRows(record.getShortAnswerNumber());
            List<ShortAnswerQuestionDTO> shortAnswerQuestionDTOS= (List<ShortAnswerQuestionDTO>) shortAnswerQuestionService.randomSelectShortAnswerQuestionList(pager).getResult().getList();
            record.setShortAnswerQuestionDTOS(shortAnswerQuestionDTOS);
        }else{
            List<ShortAnswerQuestionDTO> shortAnswerQuestionDTOS = new ArrayList<>();
            record.setShortAnswerQuestionDTOS(shortAnswerQuestionDTOS);
        }

        if(record.getSingleChoiceNumber() > 0){
            pager.setRows(record.getSingleChoiceNumber());
            List<SingleChoiceQuestionDTO> singleChoiceQuestionDTOS = (List<SingleChoiceQuestionDTO>) singleChoiceQuestionService.randomSelectSingleChoiceQuestionList(pager).getResult().getList();
            record.setSingleChoiceQuestionDTOS(singleChoiceQuestionDTOS);
        }else{
            List<SingleChoiceQuestionDTO> singleChoiceQuestionDTOS = new ArrayList<>();
            record.setSingleChoiceQuestionDTOS(singleChoiceQuestionDTOS);
        }

        if(record.getTrueFalseNumber() > 0){
            pager.setRows(record.getTrueFalseNumber());
            List<TrueFalseQuestionDTO> trueFalseQuestionDTOS = (List<TrueFalseQuestionDTO>) trueFalseQuestionService.randomSelectTrueFalseQuestionList(pager).getResult().getList();
            record.setTrueFalseQuestionDTOS(trueFalseQuestionDTOS);
        }else{
            List<TrueFalseQuestionDTO> trueFalseQuestionDTOS = new ArrayList<>();
            record.setTrueFalseQuestionDTOS(trueFalseQuestionDTOS);
        }
        return WrapMapper.ok().result(record);
    }

    /**
     * 按数量出题
     * @param record
     * @return
     */
    @RequestMapping("/numberExercise")
    public Wrapper<?> numberExercise(@RequestBody ExerciseNumberDTO record){
        Pager pager = new Pager();
        if(record.getFillVainNumber() > 0){
            pager.setRows(record.getFillVainNumber());
            List<FillVainQuestionDTO> fillVainQuestionDTOS = (List<FillVainQuestionDTO>) fillVainQuestionService.randomSelectFillVainQuestionList(pager).getResult().getList();
            record.setFillVainQuestionDTOS(fillVainQuestionDTOS);
        }else{
            List<FillVainQuestionDTO> fillVainQuestionDTOS = new ArrayList<>();
            record.setFillVainQuestionDTOS(fillVainQuestionDTOS);
        }

        if(record.getMultipleChoiceNumber() > 0){
            pager.setRows(record.getMultipleChoiceNumber());
            List<MultipleChoiceQuestionDTO> multipleChoiceQuestionDTOS = (List<MultipleChoiceQuestionDTO>) multipleChoiceQuestionService.randomSelectMultipleChoiceQuestionList(pager).getResult().getList();
            record.setMultipleChoiceQuestionDTOS(multipleChoiceQuestionDTOS);
        }else{
            List<MultipleChoiceQuestionDTO> multipleChoiceQuestionDTOS = new ArrayList<>();
            record.setMultipleChoiceQuestionDTOS(multipleChoiceQuestionDTOS);
        }

        if(record.getShortAnswerNumber() > 0){
            pager.setRows(record.getShortAnswerNumber());
            List<ShortAnswerQuestionDTO> shortAnswerQuestionDTOS= (List<ShortAnswerQuestionDTO>) shortAnswerQuestionService.randomSelectShortAnswerQuestionList(pager).getResult().getList();
            record.setShortAnswerQuestionDTOS(shortAnswerQuestionDTOS);
        }else{
            List<ShortAnswerQuestionDTO> shortAnswerQuestionDTOS = new ArrayList<>();
            record.setShortAnswerQuestionDTOS(shortAnswerQuestionDTOS);
        }

        if(record.getSingleChoiceNumber() > 0){
            pager.setRows(record.getSingleChoiceNumber());
            List<SingleChoiceQuestionDTO> singleChoiceQuestionDTOS = (List<SingleChoiceQuestionDTO>) singleChoiceQuestionService.randomSelectSingleChoiceQuestionList(pager).getResult().getList();
            record.setSingleChoiceQuestionDTOS(singleChoiceQuestionDTOS);
        }else{
            List<SingleChoiceQuestionDTO> singleChoiceQuestionDTOS = new ArrayList<>();
            record.setSingleChoiceQuestionDTOS(singleChoiceQuestionDTOS);
        }

        if(record.getTrueFalseNumber() > 0){
            pager.setRows(record.getTrueFalseNumber());
            List<TrueFalseQuestionDTO> trueFalseQuestionDTOS = (List<TrueFalseQuestionDTO>) trueFalseQuestionService.randomSelectTrueFalseQuestionList(pager).getResult().getList();
            record.setTrueFalseQuestionDTOS(trueFalseQuestionDTOS);
        }else{
            List<TrueFalseQuestionDTO> trueFalseQuestionDTOS = new ArrayList<>();
            record.setTrueFalseQuestionDTOS(trueFalseQuestionDTOS);
        }
        return WrapMapper.ok().result(record);
    }

    /**
     * 检查按数量和按比例出题
     * @param record
     * @param httpServletRequest
     * @return
     */
    @RequestMapping("/exerciseCheck")
    public Wrapper<?> numberExerciseCheck(@RequestBody ExerciseNumberDTO record, HttpServletRequest httpServletRequest){
        List<Integer> fillVainQuestionKeys = new ArrayList<>();
        for(int i=0;i<record.getFillVainQuestionDTOS().size();i++){
            fillVainQuestionKeys.add(record.getFillVainQuestionDTOS().get(i).getId());
        }
        List<FillVainQuestionDTO> fillVainQuestionDTOS = (List<FillVainQuestionDTO>) fillVainQuestionService.selectByPrimaryKeyList(fillVainQuestionKeys).getResult().getList();
        record.setFillVainQuestionDTOS(fillVainQuestionDTOS);

        List<MultipleChoiceQuestionDTO> multipleChoiceQuestionDTOS = (List<MultipleChoiceQuestionDTO>) multipleChoiceQuestionService.checkExercise(record.getMultipleChoiceQuestionDTOS(),httpServletRequest).getResult().getList();
        record.setMultipleChoiceQuestionDTOS(multipleChoiceQuestionDTOS);

        List<Integer> shortAnswerQuestionKeys = new ArrayList<>();
        for(int i=0;i<record.getShortAnswerQuestionDTOS().size();i++){
            shortAnswerQuestionKeys.add(record.getShortAnswerQuestionDTOS().get(i).getId());
        }
        List<ShortAnswerQuestionDTO> shortAnswerQuestionDTOS= (List<ShortAnswerQuestionDTO>) shortAnswerQuestionService.selectByPrimaryKeyList(shortAnswerQuestionKeys).getResult().getList();
        record.setShortAnswerQuestionDTOS(shortAnswerQuestionDTOS);

        List<SingleChoiceQuestionDTO> singleChoiceQuestionDTOS = (List<SingleChoiceQuestionDTO>) singleChoiceQuestionService.checkExercise(record.getSingleChoiceQuestionDTOS(),httpServletRequest).getResult().getList();
        record.setSingleChoiceQuestionDTOS(singleChoiceQuestionDTOS);

        List<TrueFalseQuestionDTO> trueFalseQuestionDTOS = (List<TrueFalseQuestionDTO>) trueFalseQuestionService.checkExercise(record.getTrueFalseQuestionDTOS(),httpServletRequest).getResult().getList();
        record.setTrueFalseQuestionDTOS(trueFalseQuestionDTOS);

        return WrapMapper.ok().result(record);
    }
}
