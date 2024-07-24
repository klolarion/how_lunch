package com.example.how_lunch.dao;

import com.example.how_lunch.dto.UserInfoDto;
import com.example.how_lunch.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 최초생성 2024.07.22 - 김재근
 *
 * */

public class AccountDAOImpl implements AccountDAO{

    /*내 계좌 조회 - 유저아이디(long)*/
    @Override
    public List<UserInfoDto> getAllAccounts(long userId) {
        List<UserInfoDto> accounts = new ArrayList<>();

        Connection conn = DBUtil.getConnection();
        String sql = "select * from accounts as a join users as u on u.userId = a.userId where u.userId = ?;";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                UserInfoDto info = new UserInfoDto();
                info.setAccountNumber(rs.getString("accountNumber"));
                info.setBalance(rs.getDouble("balance"));
                info.setUsername(rs.getString("username"));
                info.setUserId(rs.getLong("userId"));
                accounts.add(info);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        DBUtil.closeConnection();
        return accounts;
    }

    @Override
    public UserInfoDto getAccount(long userId, String accountNumber) {
        UserInfoDto info = new UserInfoDto();

        Connection conn = DBUtil.getConnection();
        String sql = "select * from accounts as a join users as u on u.userId = a.userId where u.userId = ? and a.accountNumber = ?;";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, userId);
            ps.setString(2, accountNumber);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                info.setAccountNumber(rs.getString("accountNumber"));
                info.setBalance(rs.getDouble("balance"));
                info.setUsername(rs.getString("username"));
                info.setUserId(rs.getLong("userId"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        DBUtil.closeConnection();
        return info;
    }

    /*계좌추가 - 유저아이디(long), 계좌번호(String)*/
    @Override
    public void newAccount(long userId, String accountNumber) {
        Connection conn = DBUtil.getConnection();
        String sql = "insert into accounts (accountNumber, userId) value (?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, accountNumber);
            ps.setLong(2, userId);
            ps.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
        DBUtil.closeConnection();
    }

}
