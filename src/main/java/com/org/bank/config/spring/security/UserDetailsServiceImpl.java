package com.org.bank.config.spring.security;

import com.org.bank.common.Role;
import com.org.bank.dao.AdminInfoDTOMapper;
import com.org.bank.dao.StudentInfoDTOMapper;
import com.org.bank.dao.TeacherInfoDTOMapper;
import com.org.bank.domain.AdminInfoDTO;
import com.org.bank.domain.StudentInfoDTO;
import com.org.bank.domain.TeacherInfoDTO;
import org.apache.log4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 功能：动态获取用户账号密码认证
 * @Author Created by yebing
 * @Date 2018/8/12 22:05
 * @Version 1.0.0
 */
@Component("userDetailService")
public class UserDetailsServiceImpl implements UserDetailsService {
    @Resource
    private AdminInfoDTOMapper adminInfoDTOMapper;
    @Resource
    private TeacherInfoDTOMapper teacherInfoDTOMapper;
    @Resource
    private StudentInfoDTOMapper studentInfoDTOMapper;
    private static Logger logger = Logger.getLogger(UserDetailsServiceImpl.class);
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("开始处理用户信息！");
        //GrantedAuthority是security提供的权限类，
        List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
        String[] roleUserId = username.split("_");
        String role = roleUserId[0];
        String email =roleUserId[1];
        String password = null;
        Object user = null;
        if(role.equals(Role.ADMIN)){
            AdminInfoDTO record = new AdminInfoDTO();
            record.setAdminEmail(email);
            List<AdminInfoDTO> adminInfoDTOS = adminInfoDTOMapper.selectList(record, null);
            if(adminInfoDTOS.size()!=0){
                record = adminInfoDTOS.get(0);
                //获取角色，放到list里面
                this.getAdminRoles(record,auths);
                password = record.getAdminPassword();
                user = record;
                logger.info("数据库密码："+record.getAdminPassword());
            }
        }
        if(role.equals(Role.TEACHER)){
            TeacherInfoDTO record = new TeacherInfoDTO();
            record.setTeacherEmail(email);
            List<TeacherInfoDTO> teacherInfoDTOS = teacherInfoDTOMapper.selectList(record, null);
            /* 数据库有账号且账号状态是启用，status：1*/
            if(teacherInfoDTOS.size()!=0 && teacherInfoDTOS.get(0).getStatus() == 1){
                record = teacherInfoDTOS.get(0);
                this.getTeacherRoles(record,auths);
                password = record.getTeacherPassword();
                user = record;
                logger.info("数据库密码："+record.getTeacherPassword());
            }
        }
        if(role.equals(Role.STUDENT)){
            StudentInfoDTO record = new StudentInfoDTO();
            record.setStudentEmail(email);
            List<StudentInfoDTO> studentInfoDTOS = studentInfoDTOMapper.selectList(record, null);
            /* 数据库有账号且账号状态是启用，status：1*/
            if(studentInfoDTOS.size()!=0 && studentInfoDTOS.get(0).getStatus() == 1){
                record = studentInfoDTOS.get(0);
                this.getStudentRoles(record,auths);
                password = record.getStudentPassword();
                user = record;
                logger.info("数据库密码："+record.getStudentPassword());
            }
        }
        if (null == user) {
            throw new UsernameNotFoundException("用户" + username + "不存在");
        }
        //返回包括权限角色的User给security
        return new User(username, password, true, true, true, true, auths);
    }

    public void getAdminRoles(AdminInfoDTO adminInfoDTO,List<GrantedAuthority> list){
        list.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }
    public void getTeacherRoles(TeacherInfoDTO teacherInfoDTO,List<GrantedAuthority> list){
        list.add(new SimpleGrantedAuthority("ROLE_TEACHER"));
    }
    public void getStudentRoles(StudentInfoDTO studentInfoDTO,List<GrantedAuthority> list){
        list.add(new SimpleGrantedAuthority("ROLE_STUDENT"));
    }
    public static void main(String[] args){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        System.out.print("当前时间："+format.format(calendar.getTime()));


//        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.DAY_OF_MONTH,1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND,0);
        System.out.print("当前月开始时间："+format.format(calendar.getTime()));

        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND,0);

        Date m = calendar.getTime();
        String mon = format.format(m);
        System.out.println("下个月开始时间："+mon);
    }
}
