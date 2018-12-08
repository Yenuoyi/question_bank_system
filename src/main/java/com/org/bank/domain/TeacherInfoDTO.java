package com.org.bank.domain;

import com.org.bank.common.Pager;

import java.io.Serializable;

public class TeacherInfoDTO implements Serializable {
    /**  */
    private Integer id;

    /** 教师姓名 */
    private String teacherName;

    /** 教师email */
    private String teacherEmail;

    /** 教师手机 */
    private String teacherIphone;

    /** 教师密码 */
    private String teacherPassword;

    /** 新密码 */
    private String newTeacherPassword;

    private Pager pager;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName == null ? null : teacherName.trim();
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail == null ? null : teacherEmail.trim();
    }

    public String getTeacherIphone() {
        return teacherIphone;
    }

    public void setTeacherIphone(String teacherIphone) {
        this.teacherIphone = teacherIphone == null ? null : teacherIphone.trim();
    }

    public String getTeacherPassword() {
        return teacherPassword;
    }

    public void setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword == null ? null : teacherPassword.trim();
    }

    public String getNewTeacherPassword() {
        return newTeacherPassword;
    }

    public void setNewTeacherPassword(String newTeacherPassword) {
        this.newTeacherPassword = newTeacherPassword;
    }

    public Pager getPager() {
        return pager;
    }

    public void setPager(Pager pager) {
        this.pager = pager;
    }
}