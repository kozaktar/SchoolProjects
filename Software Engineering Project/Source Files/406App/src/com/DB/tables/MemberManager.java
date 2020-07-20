package com.DB.tables;

import com.DB.DButil;
import com.DB.beans.Member;

import java.sql.*;

public class MemberManager {

    public static final int MemberFee=10;

public static StringBuffer displayFinances() throws SQLException {

        String order = "desc";

        String sql = "SELECT * FROM members"; 

        StringBuffer bf = new StringBuffer();
        try (
                Connection conn = DButil.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
        ) {

            //System.out.println("Members Table:");
            while (rs.next()) {
                bf.append(rs.getString("Name") + "------ Balance: ");
                bf.append(rs.getString("MEMBERFEE"));
                bf.append("\n");
            }

        }
        // System.out.println(bf.toString());
        return bf;
    }

    public static StringBuffer displayAllRows(String orderedBy) throws SQLException {

        String order = "ASC";

        if (orderedBy.equals("consecutivemissedmayments") || orderedBy.equals("totalmissedpayments") || orderedBy.equals("cpontime") || orderedBy.equals("nopracticesatt"))
            order = "desc";

        String sql = "SELECT * FROM members ORDER BY " + orderedBy + " " + order;

        StringBuffer bf = new StringBuffer();
        try (
                Connection conn = DButil.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
        ) {

            //System.out.println("Members Table:");
            while (rs.next()) {

                bf.append((rs.getInt(1) + ","));
                bf.append(rs.getString("Name") + ",");
                bf.append(rs.getString("phoneNumber") + ",");
                bf.append(rs.getString("Address") + ",");
                bf.append(rs.getString("email") + ",");
                bf.append(rs.getString("CoachName") + ",");
                bf.append(rs.getString("classID") + ",");
                bf.append(rs.getString("PAIDTHISMONTH") + ",");
                bf.append(rs.getString("CONSECUTIVEMISSEDPAYMENTS") + ",");
                bf.append(rs.getString("TOTALMISSEDPAYMENTS") + ",");
                bf.append(rs.getString("CPONTIME") + ",");
                bf.append(rs.getString("NOPRACTICESATT") + ",");
                bf.append(rs.getString("MEMBERFEE"));
                bf.append("\n");


            }

        }
        // System.out.println(bf.toString());
        return bf;
    }

    public static Member getRow(String memberName) throws SQLException {

        String sql = "SELECT * FROM Members WHERE name = ?";
        ResultSet rs = null;

        try (
                Connection conn = DButil.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.setString(1, memberName);
            rs = stmt.executeQuery();

            if (rs.next()) {
                Member bean = new Member();
                bean.setMemberId(rs.getInt(1));
                bean.setName(rs.getString("Name"));
                bean.setPhoneNumber(rs.getString("phoneNumber"));
                bean.setAddress(rs.getString("Address"));
                bean.setCoachName(rs.getString("CoachName"));
                bean.setPaidThisMonths(rs.getString("PAIDTHISMONTH"));
                bean.setConsecutiveMissedPayments(rs.getString("CONSECUTIVEMISSEDPAYMENTS"));
                bean.setTotalMissedPayments(rs.getString("TOTALMISSEDPAYMENTS"));
                bean.setConsecutivePaymentsOnTime(rs.getString("CPONTIME"));
                bean.setNoOfPracticesAttended(rs.getString("NOPRACTICESATT"));
                bean.setMembersFee(rs.getString("MEMBERFEE"));
                bean.setEmail(rs.getString("email"));
                bean.setClassID(rs.getInt("classid"));
                bean.setUnreadMessages(rs.getString("unreadmessages"));
                bean.setPracticeMessages(rs.getString("practicemessages"));
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

    public static boolean insert(Member bean) throws Exception {

        Member tempBean;

        tempBean=getRow(bean.getName());
        if(tempBean!=null)
            return false;

        String sql = "INSERT into Members (Name, PhoneNumber, Address, CoachName, PaidThisMonth, ConsecutiveMissedPayments, TotalMissedPayments, CpOnTime, NoPracticesAtt, MemberFee, email, classID, unreadMessages, practiceMessages) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        ResultSet keys = null;
        try (
                Connection conn = DButil.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {

            stmt.setString(1, bean.getName());
            stmt.setString(2, bean.getPhoneNumber());
            stmt.setString(3, bean.getAddress());
            stmt.setString(4, bean.getCoachName());
            stmt.setString(5, bean.getPaidThisMonths());
            stmt.setString(6, bean.getConsecutiveMissedPayments());
            stmt.setString(7, bean.getTotalMissedPayments());
            stmt.setString(8, bean.getConsecutivePaymentsOnTime());
            stmt.setString(9, bean.getNoOfPracticesAttended());
            stmt.setString(10, bean.getMembersFee());
            stmt.setString(11, bean.getEmail());
            stmt.setInt(12, bean.getClassID());
            stmt.setString(13, bean.getUnreadMessages());
            stmt.setString(14, bean.getPracticeMessages());

            int affected = stmt.executeUpdate();

            if (affected == 1) {
                keys = stmt.getGeneratedKeys();
                keys.next();
                int newKey = keys.getInt(1);
                bean.setMemberId(newKey);
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

    public static boolean update(Member bean) throws Exception {

        String sql = "UPDATE Members SET " +
                "Name = ?, PhoneNumber = ?, Address = ?, CoachName = ?, PaidThisMonth = ?, ConsecutiveMissedPayments =?, TotalMissedPayments =?, CpOnTime = ?, NoPracticesAtt = ?, MemberFee =?, email =?, classid =?, unreadMessages =?, practiceMessages =?" +
                "WHERE id = ?";
        try (
                Connection conn = DButil.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
        ) {

            stmt.setString(1, bean.getName());
            stmt.setString(2, bean.getPhoneNumber());
            stmt.setString(3, bean.getAddress());
            stmt.setString(4, bean.getCoachName());
            stmt.setString(5, bean.getPaidThisMonths());
            stmt.setString(6, bean.getConsecutiveMissedPayments());
            stmt.setString(7, bean.getTotalMissedPayments());
            stmt.setString(8, bean.getConsecutivePaymentsOnTime());
            stmt.setString(9, bean.getNoOfPracticesAttended());
            stmt.setString(10, bean.getMembersFee());
            stmt.setString(11, bean.getEmail());
            stmt.setInt(12, bean.getClassID());
            stmt.setString(13, bean.getUnreadMessages());
            stmt.setString(14, bean.getPracticeMessages());

            stmt.setInt(15, bean.getMemberId());

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

    public static boolean delete(String memberName) throws Exception {

        String sql = "DELETE FROM Members WHERE name = ?";
        try (
                Connection conn = DButil.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.setString(1, memberName);
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

    public static StringBuffer getMessages(Member bean) throws SQLException {
        StringBuffer buffer = new StringBuffer();
        Member currentMember;
        currentMember = bean;

        buffer.append(currentMember.getPracticeMessages());
        buffer.append("\n");
        buffer.append(currentMember.getUnreadMessages());

        return buffer;
    }

    public static void setMessages(String memberName, String message, String messageType) throws Exception {
        Member currentMember;
        currentMember = getRow(memberName);

        switch (messageType) {
            case "practiceMessage":
                currentMember.setPracticeMessages(message);
                break;
            case "unreadMessage":
                currentMember.setUnreadMessages(message);
            default:
                ;
        }
        update(currentMember);
    }

    public static void clearMessages(Member bean) throws Exception {

        bean.setUnreadMessages(" ");
        bean.setPracticeMessages(" ");
        update(bean);
    }

    private static void autoApplyPenalty() throws Exception {

        String sql = "SELECT * FROM members";
        Member tempBean;
        String tempMemberName;
        String fee;
        double feeNum;


        try (
                Connection conn = DButil.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
        ) {

            while (rs.next()) {
            tempMemberName=rs.getString("name");
            tempBean=getRow(tempMemberName);
            if(Integer.parseInt(tempBean.getConsecutiveMissedPayments())>1)
            {
                fee=tempBean.getMembersFee();
                feeNum=Double.parseDouble(fee)*1.1;
                fee=Double.toString(feeNum);
                tempBean.setMembersFee(fee);
                update(tempBean);
            }
            }
        }
    }

    //Applies bonus based on preactice attendance
    private static void autoApplyBonus1() throws Exception {

        String sql = "SELECT TOP 10 * FROM members ORDER BY noPracticesAtt DESC";
        Member tempBean;
        String tempMemberName;
        String fee;
        double feeNum;


        try (
                Connection conn = DButil.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
        ) {

            while (rs.next()) {
                tempMemberName=rs.getString("name");
                tempBean=getRow(tempMemberName);

                    fee=tempBean.getMembersFee();
                    feeNum=Double.parseDouble(fee) - MemberFee*0.1;
                    fee=Double.toString(feeNum);
                    tempBean.setMembersFee(fee);
                    update(tempBean);
            }
        }
    }

    //Applies bonus based on  cont missing payments
    private static void autoApplyBonus2() throws Exception {

        String sql = "SELECT * FROM members where cpOnTime>2";
        Member tempBean;
        String tempMemberName;
        String fee;
        double feeNum;


        try (
                Connection conn = DButil.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
        ) {

            while (rs.next()) {
                tempMemberName=rs.getString("name");
                tempBean=getRow(tempMemberName);

                fee=tempBean.getMembersFee();
                feeNum=Double.parseDouble(fee) - MemberFee*0.1;
                fee=Double.toString(feeNum);
                tempBean.setMembersFee(fee);
                //tempBean.setConsecutivePaymentsOnTime("0");
                update(tempBean);
            }
        }
    }
    public static void autoUpdateFees() throws Exception{

        autoApplyBonus1();
        autoApplyBonus2();
        autoApplyPenalty();
    }

}

