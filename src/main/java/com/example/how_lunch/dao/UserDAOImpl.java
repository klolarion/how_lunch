package com.example.how_lunch.dao;

import com.example.how_lunch.model.Users;
import com.example.how_lunch.util.DBUtil;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


/**
 * 최초생성 2024.07.22 - 김재근
 *
 * */

public class UserDAOImpl implements UserDAO {


    @Override
    public String getUserInfo(long id) {
        Connection conn = DBUtil.getConnection();
        String sql = "select username from users where userId = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            String username = "";
            while (rs.next()){
                username = rs.getString("username");
            }
            return username;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.closeConnection();
        return null;
    }

    /*가입 - 이름(String), 이메일(String), 비밀번호(String)*/
    @Override
    public void newUser(Users user) {
        Connection conn = DBUtil.getConnection();
        String sql = "insert into users (username, email, password) value (?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(8)));
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.closeConnection();
    }

    /*로그인 - 이메일(String), 비밀번호(String)*/
    @Override
    public Map<String, String> login(String email, String password) {

        Map<String, String> result = new HashMap<>();

        Connection conn = DBUtil.getConnection();
        String sql = "select password, userId from users where email = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            String p = "";
            String u = "";
            while (rs.next()) {
                p = rs.getString("password");
                u = rs.getString("userId");
            }
            if (BCrypt.checkpw(password, p)) {
                result.put("success", "true");
                result.put("userId", u);
                return result;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection();
        }
        return null;
    }

    /*비밀번호 변경 - 이메일(String), 기존비밀번호(String), 새비밀번호(String)*/
    @Override
    public int changePassword(String email, String cPassword, String nPassword) {
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
            if (BCrypt.checkpw(cPassword, sPassword)) {
                ps2.setString(1, nPassword);
                ps2.setString(2, email);
                result = ps2.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.closeConnection();

        return result;
    }
}
