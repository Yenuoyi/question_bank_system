package com.org.bank.config.spring.security;

import com.org.bank.dao.AdminInfoDTOMapper;
import com.org.bank.dao.StudentInfoDTOMapper;
import com.org.bank.dao.TeacherInfoDTOMapper;
import com.org.bank.domain.AdminInfoDTO;
import com.org.bank.domain.StudentInfoDTO;
import com.org.bank.domain.TeacherInfoDTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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
        Integer userId =Integer.parseInt(username.split("_")[0]);
        String password = null;
        Object user = null;
        if(username.contains("ADMIN_")){
            AdminInfoDTO record = adminInfoDTOMapper.selectByPrimaryKey(userId);
            //获取角色，放到list里面
            this.getAdminRoles(record,auths);
            password = record.getAdminPassword();
            user = record;
            logger.info("数据库密码："+record.getAdminPassword());
        }
        if(username.contains("TEACHER_")){
            TeacherInfoDTO record = teacherInfoDTOMapper.selectByPrimaryKey(userId);
            this.getTeacherRoles(record,auths);
            password = record.getTeacherPassword();
            user = record;
            logger.info("数据库密码："+record.getTeacherPassword());
        }
        if(username.contains("STUDENT_")){
            StudentInfoDTO record = studentInfoDTOMapper.selectByPrimaryKey(userId);
            this.getStudentRoles(record,auths);
            password = record.getStudentPassword();
            user = record;
            logger.info("数据库密码："+record.getStudentPassword());
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

}
