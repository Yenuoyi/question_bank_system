package com.org.bank.domain;

import java.util.List;

/**
 * 习题数量DTO
 */
public class ExerciseNumberDTO {
    /** 填空题数量 */
    private Integer fillVainNumber;

    /** 填空题比例 */
    private double fillVainProportion;

    /** 多选题数量 */
    private Integer MultipleChoiceNumber;

    /** 多选题比例 */
    private double MultipleChoiceProportion;

    /** 简答题数量 */
    private Integer shortAnswerNumber;

    /** 简答题比例 */
    private double shortAnswerProportion;

    /** 单选题数量 */
    private Integer singleChoiceNumber;

    /** 单选题比例 */
    private double singleChoiceProportion;

    /** 判断题数量 */
    private Integer trueFalseNumber;

    /** 判断题比例 */
    private double trueFalseProportion;

    /** 程序语言分类id */
    private Integer languageClassificationId;

    /** 程序语言分类名 */
    private String languageClassificationName;

    /** 程序语言分类状态 1：启用 2：禁用 */
    private String languageClassificationStatus;

    List<FillVainQuestionDTO> fillVainQuestionDTOS;
    List<MultipleChoiceQuestionDTO> multipleChoiceQuestionDTOS;
    List<ShortAnswerQuestionDTO> shortAnswerQuestionDTOS;
    List<SingleChoiceQuestionDTO> singleChoiceQuestionDTOS;
    List<TrueFalseQuestionDTO> trueFalseQuestionDTOS;

    public Integer getFillVainNumber() {
        return fillVainNumber;
    }

    public void setFillVainNumber(Integer fillVainNumber) {
        this.fillVainNumber = fillVainNumber;
    }

    public double getFillVainProportion() {
        return fillVainProportion;
    }

    public void setFillVainProportion(double fillVainProportion) {
        this.fillVainProportion = fillVainProportion;
    }

    public Integer getMultipleChoiceNumber() {
        return MultipleChoiceNumber;
    }

    public void setMultipleChoiceNumber(Integer multipleChoiceNumber) {
        MultipleChoiceNumber = multipleChoiceNumber;
    }

    public double getMultipleChoiceProportion() {
        return MultipleChoiceProportion;
    }

    public void setMultipleChoiceProportion(double multipleChoiceProportion) {
        MultipleChoiceProportion = multipleChoiceProportion;
    }

    public Integer getShortAnswerNumber() {
        return shortAnswerNumber;
    }

    public void setShortAnswerNumber(Integer shortAnswerNumber) {
        this.shortAnswerNumber = shortAnswerNumber;
    }

    public double getShortAnswerProportion() {
        return shortAnswerProportion;
    }

    public void setShortAnswerProportion(double shortAnswerProportion) {
        this.shortAnswerProportion = shortAnswerProportion;
    }

    public Integer getSingleChoiceNumber() {
        return singleChoiceNumber;
    }

    public void setSingleChoiceNumber(Integer singleChoiceNumber) {
        this.singleChoiceNumber = singleChoiceNumber;
    }

    public double getSingleChoiceProportion() {
        return singleChoiceProportion;
    }

    public void setSingleChoiceProportion(double singleChoiceProportion) {
        this.singleChoiceProportion = singleChoiceProportion;
    }

    public Integer getTrueFalseNumber() {
        return trueFalseNumber;
    }

    public void setTrueFalseNumber(Integer trueFalseNumber) {
        this.trueFalseNumber = trueFalseNumber;
    }

    public double getTrueFalseProportion() {
        return trueFalseProportion;
    }

    public void setTrueFalseProportion(double trueFalseProportion) {
        this.trueFalseProportion = trueFalseProportion;
    }

    public String getLanguageClassificationStatus() {
        return languageClassificationStatus;
    }

    public void setLanguageClassificationStatus(String languageClassificationStatus) {
        this.languageClassificationStatus = languageClassificationStatus;
    }

    public List<FillVainQuestionDTO> getFillVainQuestionDTOS() {
        return fillVainQuestionDTOS;
    }

    public void setFillVainQuestionDTOS(List<FillVainQuestionDTO> fillVainQuestionDTOS) {
        this.fillVainQuestionDTOS = fillVainQuestionDTOS;
    }

    public List<MultipleChoiceQuestionDTO> getMultipleChoiceQuestionDTOS() {
        return multipleChoiceQuestionDTOS;
    }

    public void setMultipleChoiceQuestionDTOS(List<MultipleChoiceQuestionDTO> multipleChoiceQuestionDTOS) {
        this.multipleChoiceQuestionDTOS = multipleChoiceQuestionDTOS;
    }

    public List<ShortAnswerQuestionDTO> getShortAnswerQuestionDTOS() {
        return shortAnswerQuestionDTOS;
    }

    public void setShortAnswerQuestionDTOS(List<ShortAnswerQuestionDTO> shortAnswerQuestionDTOS) {
        this.shortAnswerQuestionDTOS = shortAnswerQuestionDTOS;
    }

    public List<SingleChoiceQuestionDTO> getSingleChoiceQuestionDTOS() {
        return singleChoiceQuestionDTOS;
    }

    public void setSingleChoiceQuestionDTOS(List<SingleChoiceQuestionDTO> singleChoiceQuestionDTOS) {
        this.singleChoiceQuestionDTOS = singleChoiceQuestionDTOS;
    }

    public List<TrueFalseQuestionDTO> getTrueFalseQuestionDTOS() {
        return trueFalseQuestionDTOS;
    }

    public void setTrueFalseQuestionDTOS(List<TrueFalseQuestionDTO> trueFalseQuestionDTOS) {
        this.trueFalseQuestionDTOS = trueFalseQuestionDTOS;
    }

    public Integer getLanguageClassificationId() {
        return languageClassificationId;
    }

    public void setLanguageClassificationId(Integer languageClassificationId) {
        this.languageClassificationId = languageClassificationId;
    }

    public String getLanguageClassificationName() {
        return languageClassificationName;
    }

    public void setLanguageClassificationName(String languageClassificationName) {
        this.languageClassificationName = languageClassificationName;
    }
}
