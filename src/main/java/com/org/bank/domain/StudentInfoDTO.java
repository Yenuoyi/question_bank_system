package com.org.bank.domain;

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

    /** 班级id */
    private Integer classId;

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

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }
}