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

    public Pager getPager() {
        return pager;
    }

    public void setPager(Pager pager) {
        this.pager = pager;
    }

    public static void main(String[] args){
        Pager pager = new Pager();
        pager.setPage(1);
        pager.setRows(10);
        StudentInfoDTO studentInfoDTO = new StudentInfoDTO();
        studentInfoDTO.setId(1);
        studentInfoDTO.setStudentPassword("123456");
        studentInfoDTO.setStudentEmail("19689405@qq.com");
        studentInfoDTO.setStudentIphone("15917934393");
        studentInfoDTO.setStudentName("yebing");
        studentInfoDTO.setClassId(1);
//        studentInfoDTO.setPager(pager);
        System.out.println(JSONObject.toJSONString(studentInfoDTO));

        TeacherInfoDTO teacherInfoDTO = new TeacherInfoDTO();
        teacherInfoDTO.setId(1);
        teacherInfoDTO.setTeacherPassword("123456");
        teacherInfoDTO.setTeacherEmail("19689405@qq.com");
        teacherInfoDTO.setTeacherIphone("15917934393");
        teacherInfoDTO.setTeacherName("yebing");
//        teacherInfoDTO.setPager(pager);
        System.out.println(JSONObject.toJSONString(teacherInfoDTO));

        AdminInfoDTO adminInfoDTO = new AdminInfoDTO();
        adminInfoDTO.setId(1);
        adminInfoDTO.setAdminPassword("123456");
        adminInfoDTO.setAdminEmail("19689405@qq.com");
        adminInfoDTO.setAdminIphone("15917934393");
        adminInfoDTO.setAdminName("yebing");
//        adminInfoDTO.setPager(pager);
        System.out.println(JSONObject.toJSONString(adminInfoDTO));
    }
}