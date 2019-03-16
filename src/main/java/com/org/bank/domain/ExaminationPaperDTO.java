package com.org.bank.domain;

import com.alibaba.fastjson.JSONObject;
import com.org.bank.common.Pager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ExaminationPaperDTO implements Serializable {
    /** 试卷id */
    private Integer id;

    /** 出卷人id */
    private Integer examinerId;

    /** 出卷人类型 */
    private Integer examinerType;

    /** 试卷名 */
    private String examinationPaperName;

    /** 试卷内容 */
    private List<ExaminationPaperQuestionDTO> examinationPaperQuestionDTOList;

    /** 程序语言分类id */
    private Integer languageClassificationId;

    /** 程序语言分类名 */
    private Integer languageClassificationName;

    private Pager pager;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getExaminationPaperName() {
        return examinationPaperName;
    }

    public void setExaminationPaperName(String examinationPaperName) {
        this.examinationPaperName = examinationPaperName == null ? null : examinationPaperName.trim();
    }

    public List<ExaminationPaperQuestionDTO> getExaminationPaperQuestionDTOList() {
        return examinationPaperQuestionDTOList;
    }

    public void setExaminationPaperQuestionDTOList(List<ExaminationPaperQuestionDTO> examinationPaperQuestionDTOList) {
        this.examinationPaperQuestionDTOList = examinationPaperQuestionDTOList;
    }

    public Pager getPager() {
        return pager;
    }

    public void setPager(Pager pager) {
        this.pager = pager;
    }

    public Integer getLanguageClassificationId() {
        return languageClassificationId;
    }

    public void setLanguageClassificationId(Integer languageClassificationId) {
        this.languageClassificationId = languageClassificationId;
    }

    public Integer getLanguageClassificationName() {
        return languageClassificationName;
    }

    public void setLanguageClassificationName(Integer languageClassificationName) {
        this.languageClassificationName = languageClassificationName;
    }

    public static void main(String[] args){
        ExaminationPaperDTO examinationPaperDTO = new ExaminationPaperDTO();
        examinationPaperDTO.setExaminationPaperName("计算机期末试卷");
        List<ExaminationPaperQuestionDTO> list = new ArrayList<>();
        ExaminationPaperQuestionDTO question1 = new ExaminationPaperQuestionDTO();
        question1.setExaminationPaperQuestion("世界首例计算机病毒什么时候出现的？");
        question1.setExaminationPaperAnswer("不知道!");
        list.add(question1);
        examinationPaperDTO.setExaminationPaperQuestionDTOList(list);
        System.out.print(JSONObject.toJSONString(examinationPaperDTO));
     }
}