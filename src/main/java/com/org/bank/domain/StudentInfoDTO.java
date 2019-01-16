package com.org.bank.domain;

import com.alibaba.fastjson.JSONObject;
import com.org.bank.common.Pager;

import java.io.Serializable;

public class StudentInfoDTO implements Serializable {
    /** id */
    private Integer id;

    /** 学生姓名 */
    private String studentName;

    /** 学生邮箱 */
    private String studentEmail;

    /** 学生手机 */
    private String studentIphone;

    /** 密码 */
    private String studentPassword;

    /** 新密码 */
    private String newStudentPassword;

    /** 班级id */
    private Integer classId;

    /** 班级名 */
    private String className;

    private Pager pager;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName == null ? null : studentName.trim();
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail == null ? null : studentEmail.trim();
    }

    public String getStudentIphone() {
        return studentIphone;
    }

    public void setStudentIphone(String studentIphone) {
        this.studentIphone = studentIphone == null ? null : studentIphone.trim();
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword == null ? null : studentPassword.trim();
    }

    public String getNewStudentPassword() {
        return newStudentPassword;
    }

    public void setNewStudentPassword(String newStudentPassword) {
        this.newStudentPassword = newStudentPassword;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Pager getPager() {
        return pager;
    }

    public void setPager(Pager pager) {
        this.pager = pager;
    }

}