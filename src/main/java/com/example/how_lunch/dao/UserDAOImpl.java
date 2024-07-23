package com.example.how_lunch.dao;

import com.example.how_lunch.util.DBUtil;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * 최초생성 2024.07.22 - 김재근
 *
 * */

public class UserDAOImpl implements UserDAO {


    /*가입 - 이름(String), 이메일(String), 비밀번호(String)*/
    @Override
    public void newUser(String username, String email, String password) {
        System.out.println("New user");
        Connection conn = DBUtil.getConnection();
        String sql = "insert into users (username, email, password) value (?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, email);
            ps.setString(3, BCrypt.hashpw(password, BCrypt.gensalt(8)));
            ps.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
        DBUtil.closeConnection();
    }

    /*로그인 - 이메일(String), 비밀번호(String)*/
    @Override
    public void login(String email, String password) {
        System.out.println("Login");

        Connection conn = DBUtil.getConnection();
        String sql = "select password from users where email = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            String p = rs.getString("password");

            if(BCrypt.checkpw(password, p)){
                System.out.println("Login success");
                //세션 및 쿠키관리 추가필요
            }


        }catch (SQLException e){
            System.out.println("Login failed");
            e.printStackTrace();
        }
        DBUtil.closeConnection();
    }

    /*비밀번호 변경 - 이메일(String), 기존비밀번호(String), 새비밀번호(String)*/
    @Override
    public int changePassword(String email, String cPassword, String nPassword) {
        System.out.println("Change Password");
        int result = 0;

        Connection conn = DBUtil.getConnection();
        String sql1 = "select password from users where email = ?";
        String sql2 = "update users set password = ? where email = ?";
        try {
            PreparedStatement ps1 = conn.prepareStatement(sql1);
            PreparedStatement ps2 = conn.prepareStatement(sql2);

            ps1.setString(1, email);
            ResultSet rs1 = ps1.executeQuery();
            String sPassword = rs1.getString("password");
            if(BCrypt.checkpw(cPassword, sPassword)){
                ps2.setString(1, nPassword);
                ps2.setString(2, email);
                result = ps2.executeUpdate();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        DBUtil.closeConnection();

        return result;
    }
}
