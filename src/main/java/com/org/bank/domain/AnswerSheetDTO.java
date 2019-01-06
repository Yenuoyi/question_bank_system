package com.org.bank.domain;

import com.alibaba.fastjson.JSONObject;
import com.org.bank.common.Pager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AnswerSheetDTO implements Serializable {
    /**  */
    private Integer id;

    /** 试卷id */
    private Integer examinationPaperId;

    /** 试卷名 */
    private String examinationPaperName;

    /** 答题者id */
    private Integer answerId;

    /** 答题者姓名 */
    private String answererName;

    /** 答卷人类型：3学生 */
    private Integer answererType;

    /** 成绩 */
    private Double grade;

    /* 答卷内容 */
    private List<AnswerSheetAnswerDTO> answerSheetAnswerDTOS;
    private Pager pager;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getExaminationPaperId() {
        return examinationPaperId;
    }

    public void setExaminationPaperId(Integer examinationPaperId) {
        this.examinationPaperId = examinationPaperId;
    }

    public String getExaminationPaperName() {
        return examinationPaperName;
    }

    public void setExaminationPaperName(String examinationPaperName) {
        this.examinationPaperName = examinationPaperName;
    }

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    public String getAnswererName() {
        return answererName;
    }

    public void setAnswererName(String answererName) {
        this.answererName = answererName == null ? null : answererName.trim();
    }

    public Integer getAnswererType() {
        return answererType;
    }

    public void setAnswererType(Integer answererType) {
        this.answererType = answererType;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public List<AnswerSheetAnswerDTO> getAnswerSheetAnswerDTOS() {
        return answerSheetAnswerDTOS;
    }

    public void setAnswerSheetAnswerDTOS(List<AnswerSheetAnswerDTO> answerSheetAnswerDTOS) {
        this.answerSheetAnswerDTOS = answerSheetAnswerDTOS;
    }

    public Pager getPager() {
        return pager;
    }

    public void setPager(Pager pager) {
        this.pager = pager;
    }

    public static void main(String[] args){
        AnswerSheetDTO answerSheetDTO = new AnswerSheetDTO();
        answerSheetDTO.setExaminationPaperId(3);
        List<AnswerSheetAnswerDTO> list = new ArrayList<>();
        AnswerSheetAnswerDTO o1 = new AnswerSheetAnswerDTO();
        o1.setExaminationPaperQuestionId(3);
        o1.setExaminationPaperQuestion("世界首例计算机病毒什么时候出现的？");
        o1.setExaminationPaperAnswer("不知道");
        list.add(o1);
        answerSheetDTO.setAnswerSheetAnswerDTOS(list);
        System.out.print(JSONObject.toJSONString(answerSheetDTO));
    }
}