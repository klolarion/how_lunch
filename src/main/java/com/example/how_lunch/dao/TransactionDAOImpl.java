package com.example.how_lunch.dao;

import com.example.how_lunch.model.Transaction;
import com.example.how_lunch.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 최초생성 2024.07.22 - 김재근
 * 페이징 추가 2024.07.23 - 김재근
 */

public class TransactionDAOImpl implements TransactionDAO {

    /*이체 - 금액(double), 내계좌번호(String), 상대계좌번호(String)*/
    @Override
    public int transfer(long userId, double amount, String myAccountNum, String targetAccountNum) {

        Connection conn = DBUtil.getConnection();

        int result1 = 0;
        int result2 = 0;
        boolean result3 = false;


        String type = "transfer";


        // 트랜잭션처리 필요
        String sql1 = "update accounts set balance = balance - ? where accountNumber = ?";
        String sql2 = "update accounts set balance = balance + ? where accountNumber = ?";
        try {
            PreparedStatement ps1 = conn.prepareStatement(sql1);
            PreparedStatement ps2 = conn.prepareStatement(sql2);

            ps1.setDouble(1, amount);
            ps1.setString(2, myAccountNum);
            result1 = ps1.executeUpdate();

            if (result1 == 1) {
                ps2.setDouble(1, amount);
                ps2.setString(2, targetAccountNum);
                result2 = ps2.executeUpdate();
                if (result2 == 1) {
                    result3 = regTransaction(userId, type, amount, myAccountNum, targetAccountNum, conn);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.closeConnection();

        return result3 ? 0 : 1;
    }

    /*출금 - 금액(double), 내계좌번호(String)*/
    @Override
    public int withdraw(long userId, String accountNumber, double amount) {

        int result1 = 0;
        boolean result2 = false;

        String type = "withdraw";


        Connection conn = DBUtil.getConnection();

        String sql = "update accounts set balance = balance - ? where accountNumber = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, amount);
            ps.setString(2, accountNumber);
            result1 = ps.executeUpdate();
            if (result1 == 1) {
                result2 = regTransaction(userId, type, amount, accountNumber, null, conn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.closeConnection();
        return result2 ? 0 : 1;
    }

    /*입금 - 금액(double), 내계좌번호(String)*/
    @Override
    public int deposit(long userId, String accountNumber, double amount) {

        int result1 = 0;
        boolean result2 = false;

        String type = "deposit";

        Connection conn = DBUtil.getConnection();
        String sql = "update accounts set balance = balance + ? where accountNumber = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, amount);
            ps.setString(2, accountNumber);
            result1 = ps.executeUpdate();
            if (result1 == 1) {
                result2 = regTransaction(userId, type, amount, accountNumber, null, conn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.closeConnection();
        return result2 ? 0 : 1;
    }


    /*계좌 거래목록 조회 - 내계좌번호(String)*/
    @Override
    public List<Transaction> getAccountTransactions(long userId, String accountNumber, int page, int pageSize, String order) {
        List<Transaction> result = new ArrayList<>();
        String sql = "SELECT * FROM transactions WHERE userId = ? AND mainAccount = ? or targetAccount = ? ORDER BY regDate desc LIMIT ? OFFSET ?;";
        if(order.equals("asc")){
            sql = "SELECT * FROM transactions WHERE userId = ? AND mainAccount = ? or targetAccount = ? ORDER BY regDate asc LIMIT ? OFFSET ?;";
        }

        Connection conn = DBUtil.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, userId);
            ps.setString(2, accountNumber);
            ps.setString(3, accountNumber);
            ps.setInt(4, pageSize);
            ps.setInt(5, (page - 1) * pageSize);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Transaction transaction = new Transaction();
                transaction.setTransactionId(rs.getLong("transactionId"));
                transaction.setType(rs.getString("type"));
                transaction.setAmount(rs.getDouble("amount"));
                transaction.setMainAccount(rs.getString("mainAccount"));
                transaction.setTargetAccount(rs.getString("targetAccount"));
                transaction.setRegDate(rs.getTimestamp("regDate").toLocalDateTime());

                result.add(transaction);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.closeConnection();

        return result;
    }


    /*내 거래목록 전체 조회 - 유저아이디(long)*/
    @Override
    public List<Transaction> getMyAllTransactions(long userId, int page, int pageSize, String order) {
//        List<Transaction> result = new ArrayList<>();
//
//        Connection conn = DBUtil.getConnection();
//        String sql = "select * from transactions where userId = ? order by regDate desc";
//        try {
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setLong(1, userId);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                Transaction transaction = new Transaction();
//                transaction.setTransactionId(rs.getLong("transactionId"));
//                transaction.setType(rs.getString("type"));
//                transaction.setAmount(rs.getDouble("amount"));
//                transaction.setMainAccount(rs.getString("mainAccount"));
//                transaction.setTargetAccount(rs.getString("targetAccount"));
//                transaction.setRegDate(rs.getTimestamp("regDate").toLocalDateTime());
//
//                result.add(transaction);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        DBUtil.closeConnection();
//
//        return result;

        List<Transaction> transactions = new ArrayList<>();
        Connection conn = DBUtil.getConnection();

        String query = "SELECT * FROM transactions WHERE userId = ? ORDER BY regDate DESC LIMIT ? OFFSET ?;";
        if(order.equals("asc")){
            query = "SELECT * FROM transactions WHERE userId = ? ORDER BY regDate ASC LIMIT ? OFFSET ?";
        }

        try {
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setLong(1, userId);
            ps.setInt(2, pageSize);
            ps.setInt(3, (page - 1) * pageSize);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Transaction transaction = new Transaction();
                transaction.setTransactionId(rs.getLong("transactionId"));
                transaction.setUserId(rs.getLong("userId"));
                transaction.setType(rs.getString("type"));
                transaction.setAmount(rs.getDouble("amount"));
                transaction.setMainAccount(rs.getString("mainAccount"));
                transaction.setTargetAccount(rs.getString("targetAccount"));
                transaction.setRegDate(rs.getTimestamp("regDate").toLocalDateTime());
                transactions.add(transaction);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactions;
    }


    @Override
    public int getMyTransactionCount(long userId) {
        int count = 0;
        String query = "SELECT COUNT(*) FROM transactions WHERE userId = ?";

        Connection conn = DBUtil.getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setLong(1, userId);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    count = rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }

    @Override
    public int getAccountTransactionCount(long userId, String accountNumber) {
        int count = 0;
        String query = "SELECT COUNT(*) FROM transactions WHERE userId = ? AND mainAccount = ? or targetAccount = ?";

        Connection conn = DBUtil.getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setLong(1, userId);
            ps.setString(2, accountNumber);
            ps.setString(3, accountNumber);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    count = rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }


    /*거래등록 - 거래타입(String), 금액(double), 내계좌번호(String), 상대계좌번호(String), DB연결객체(Conenction)*/
    public boolean regTransaction(long userId, String type, double amount, String mainAccountNum, String targetAccountNum, Connection conn) throws SQLException {


        boolean result = false;

        String sql3 = "insert into transactions (type, amount, mainAccount, targetAccount, userId) values (?,?,?,?,?) ";

        PreparedStatement ps3 = conn.prepareStatement(sql3);


        try {
            ps3.setString(1, type);
            ps3.setDouble(2, amount);
            ps3.setString(3, mainAccountNum);
            ps3.setString(4, targetAccountNum);
            ps3.setLong(5, userId);
            result = ps3.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
