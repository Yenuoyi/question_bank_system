package com.org.bank.domain;

import com.alibaba.fastjson.JSONObject;
import com.org.bank.common.Pager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AnswerSheetAnswerDTO implements Serializable {
    /**  */
    private Integer id;

    /** 源试卷id */
    private Integer answerSheetId;

    /** 源试卷问题id */
    private Integer examinationPaperQuestionId;

    /** 试题问题 */
    private String examinationPaperQuestion;

    /** 试题回答 */
    private String examinationPaperAnswer;

    private Pager pager;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAnswerSheetId() {
        return answerSheetId;
    }

    public void setAnswerSheetId(Integer answerSheetId) {
        this.answerSheetId = answerSheetId;
    }

    public Integer getExaminationPaperQuestionId() {
        return examinationPaperQuestionId;
    }

    public void setExaminationPaperQuestionId(Integer examinationPaperQuestionId) {
        this.examinationPaperQuestionId = examinationPaperQuestionId;
    }

    public String getExaminationPaperQuestion() {
        return examinationPaperQuestion;
    }

    public void setExaminationPaperQuestion(String examinationPaperQuestion) {
        this.examinationPaperQuestion = examinationPaperQuestion;
    }

    public String getExaminationPaperAnswer() {
        return examinationPaperAnswer;
    }

    public void setExaminationPaperAnswer(String examinationPaperAnswer) {
        this.examinationPaperAnswer = examinationPaperAnswer == null ? null : examinationPaperAnswer.trim();
    }

    public Pager getPager() {
        return pager;
    }

    public void setPager(Pager pager) {
        this.pager = pager;
    }

    public static void main(String[] args){
        List<AnswerSheetAnswerDTO> list = new ArrayList<>();
        AnswerSheetAnswerDTO o1 = new AnswerSheetAnswerDTO();
        o1.setExaminationPaperQuestionId(2);
        o1.setExaminationPaperQuestion("世界首例计算机病毒什么时候出现的？");
        o1.setExaminationPaperQuestionId(3);
        list.add(o1);
        System.out.print(JSONObject.toJSONString(list));
    }
}