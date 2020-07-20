package com.DB.tables;

import com.DB.DButil;
import com.DB.beans.Member;
import com.DB.beans.User;

import java.sql.*;

public class UserManager {


        public static void displayAllRows() throws SQLException {


            String sql = "SELECT * FROM users";

            StringBuffer bf = new StringBuffer();
            try (
                    Connection conn = DButil.getConnection();
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(sql);
            ) {

                System.out.println("Users Table:");
                while (rs.next()) {

                    bf.append(rs.getInt(1) + ": ");
                    bf.append(rs.getString("userName") + ", ");
                    bf.append(rs.getString("password") + ", ");
                    bf.append(rs.getString("usertype"));
                    bf.append("\n");
                }

            }
            System.out.println(bf.toString());

        }

    public static User getRow(String userName) throws SQLException {

        String sql = "SELECT * FROM Users WHERE userName = ?";
        ResultSet rs = null;

        try (
                Connection conn = DButil.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.setString(1, userName);
            rs = stmt.executeQuery();

            if (rs.next()) {
                User bean = new User();
                bean.setUserId((rs.getInt(1)));
                bean.setUserName(userName);
                bean.setPassword((rs.getString("password")));
                bean.setUserType((rs.getString("userType")));
                return bean;

            } else {
                System.err.println("No rows found!");
                return null;
            }

        } catch (SQLException e) {
            System.err.println(e);
            return null;
        } finally {
            if (rs != null) {
                rs.close();
            }
        }

    }

    public static boolean insert(User bean) throws Exception {

        User tempBean;

        tempBean=getRow(bean.getUserName());
        if(tempBean!=null)
            return false;

        String sql = "INSERT into Users (userName, password, userType) " +
                "VALUES (?, ?, ?)";
        ResultSet keys = null;
        try (
                Connection conn = DButil.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {

            stmt.setString(1, bean.getUserName());
            stmt.setString(2, bean.getPassword());
            stmt.setString(3, bean.getUserType());

            int affected = stmt.executeUpdate();

            if (affected == 1) {
                keys = stmt.getGeneratedKeys();
                keys.next();
                int newKey = keys.getInt(1);
                bean.setUserId(newKey);
            } else {
                System.err.println("No rows affected");
                return false;
            }

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            if (keys != null) keys.close();
        }
        return true;
    }

    public static boolean update(User bean) throws Exception {

        String sql = "UPDATE Users SET " +
                "userName = ?, password = ?, userType = ?" +
                "WHERE id = ?";
        try (
                Connection conn = DButil.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
        ) {

            stmt.setString(1, bean.getUserName());
            stmt.setString(2, bean.getPassword());
            stmt.setString(3, bean.getUserType());

            stmt.setInt(4, bean.getUserId());

            int affected = stmt.executeUpdate();
            if (affected == 1) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }

    }

    public static boolean delete(String userName) throws Exception {

        String sql = "DELETE FROM Users WHERE UserName = ?";
        try (
                Connection conn = DButil.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.setString(1, userName);
            int affected = stmt.executeUpdate();

            if (affected == 1)
                return true;
            else
                return false;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }

    }

    public static String login(String username, String password) throws Exception {

        String sql = "SELECT * FROM Users WHERE userName = ?";
        ResultSet rs = null;
        String returnString="";

        try (
                Connection conn = DButil.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.setString(1, username);
            rs = stmt.executeQuery();

            if (rs.next()) {
                if((rs.getString("password")).equals(password))
                {
                    returnString=rs.getString("userType");
                }
                else {
                    returnString = "Wrong password";
                 }
                }
                else {
                returnString= "Wrong Username!";
            }

        } catch (SQLException e) {
            System.err.println(e);
            return null;
        } finally {
            if (rs != null) {
                rs.close();
            }
        }
     return returnString;
    }
}
