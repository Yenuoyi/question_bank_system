package com.org.bank.domain;

import com.alibaba.fastjson.JSONObject;
import com.org.bank.common.Pager;
import org.springframework.security.core.parameters.P;

import java.io.Serializable;

public class SingleChoiceQuestionDTO implements Serializable {
    /** 自增id */
    private Integer id;

    /** 问题 */
    private String singleChoiceQuestion;

    /** 选项 */
    private String singleChoiceOption;

    /** 答案 */
    private String singleChoiceAnswer;

    /** 出题人id */
    private Integer examinerId;

    /** 出题人类型：1admin 2教师 */
    private Integer examinerType;

    /** 习题练习是否正确，0：错误，1：正确 */
    private Integer trueOrFalse;

    private Pager pager;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSingleChoiceQuestion() {
        return singleChoiceQuestion;
    }

    public void setSingleChoiceQuestion(String singleChoiceQuestion) {
        this.singleChoiceQuestion = singleChoiceQuestion == null ? null : singleChoiceQuestion.trim();
    }

    public String getSingleChoiceOption() {
        return singleChoiceOption;
    }

    public void setSingleChoiceOption(String singleChoiceOption) {
        this.singleChoiceOption = singleChoiceOption;
    }

    public String getSingleChoiceAnswer() {
        return singleChoiceAnswer;
    }

    public void setSingleChoiceAnswer(String singleChoiceAnswer) {
        this.singleChoiceAnswer = singleChoiceAnswer == null ? null : singleChoiceAnswer.trim();
    }

    public Integer getExaminerId() {
        return examinerId;
    }

    public void setExaminerId(Integer examinerId) {
        this.examinerId = examinerId;
    }

    public Integer getExaminerType() {
        return examinerType;
    }

    public void setExaminerType(Integer examinerType) {
        this.examinerType = examinerType;
    }

    public Integer getTrueOrFalse() {
        return trueOrFalse;
    }

    public void setTrueOrFalse(Integer trueOrFalse) {
        this.trueOrFalse = trueOrFalse;
    }

    public Pager getPager() {
        return pager;
    }

    public void setPager(Pager pager) {
        this.pager = pager;
    }

    public static void main(String[] args){
        SingleChoiceQuestionDTO singleChoiceQuestionDTO = new SingleChoiceQuestionDTO();
        Pager pager = new Pager();
        singleChoiceQuestionDTO.setPager(pager);
        singleChoiceQuestionDTO.getPager().setRows(10);
        singleChoiceQuestionDTO.getPager().setPage(1);
        System.out.print(JSONObject.toJSONString(singleChoiceQuestionDTO));
    }
}