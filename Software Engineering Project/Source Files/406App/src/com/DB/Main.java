package com.DB;

import com.DB.beans.Member;
import com.DB.beans.User;
import com.DB.tables.MemberManager;
import com.DB.tables.UserManager;
import ui.Title;
import javax.swing.JFrame;


public class Main {

    public static void main(String[] args) throws Exception {

        System.out.println("Program running!");
        MemberManager.delete("Enter a valid Name.");
        Member bean= new Member();
        bean.setName("Zebra Anderson");
        bean.setPhoneNumber("4168290813");
        bean.setAddress("Toronto Street");
        bean.setCoachName("C");
        bean.setConsecutiveMissedPayments("7");
        bean.setTotalMissedPayments("65");
        bean.setPaidThisMonths("yes");
        bean.setConsecutivePaymentsOnTime("1");
        bean.setNoOfPracticesAttended("5");
        bean.setMembersFee("500");
        bean.setEmail("tkozak@ryerson.ca");
        bean.setPracticeMessages("welcome to your first practice");
        bean.setUnreadMessages("none");


        MemberManager.insert(bean);

        Member bean1= new Member();
        bean1.setName("John Kip");
        bean1.setPhoneNumber("4167583802");
        bean1.setAddress("Toronto Street");
        bean1.setCoachName("C");
        bean1.setConsecutiveMissedPayments("1");
        bean1.setTotalMissedPayments("65");
        bean1.setPaidThisMonths("yes");
        bean1.setConsecutivePaymentsOnTime("1");
        bean1.setNoOfPracticesAttended("5");
        bean1.setMembersFee("500");
        bean1.setEmail("johnkip@ryerson.ca");
        bean1.setPracticeMessages("welcome to your first practice");
        bean1.setUnreadMessages("none");
        MemberManager.update(bean1);


        MemberManager.insert(bean1);


        Member bean2 = new Member();
        bean2.setName("Jacob Diego");
        bean2.setPhoneNumber("4169576874");
        bean2.setAddress("1 Toronto Street");
        bean2.setCoachName("C");
        bean2.setConsecutiveMissedPayments("0");
        bean2.setTotalMissedPayments("0");
        bean2.setPaidThisMonths("yes");
        bean2.setConsecutivePaymentsOnTime("3");
        bean2.setNoOfPracticesAttended("8");
        bean2.setMembersFee("0");
        bean2.setEmail("jacobdiego@ryerson.ca");
        bean2.setPracticeMessages("welcome to your first practice");
        bean2.setUnreadMessages("none");

        MemberManager.insert(bean2);

        Member bean3= new Member();
        bean3.setName("Aaron Gabriel");
        bean3.setPhoneNumber("4166763469");
        bean3.setAddress("2 Toronto Street");
        bean3.setCoachName("C");
        bean3.setConsecutiveMissedPayments("2");
        bean3.setTotalMissedPayments("5");
        bean3.setPaidThisMonths("yes");
        bean3.setConsecutivePaymentsOnTime("2");
        bean3.setNoOfPracticesAttended("20");
        bean3.setMembersFee("50");
        bean3.setEmail("aarongabriel@ryerson.ca");
        bean3.setPracticeMessages("welcome to your first practice");
        bean3.setUnreadMessages("none");

        MemberManager.insert(bean3);

        Member bean4= new Member();
        bean4.setName("David Gavin");
        bean4.setPhoneNumber("4164151800");
        bean4.setAddress("3 Toronto Street");
        bean4.setCoachName("C");
        bean4.setConsecutiveMissedPayments("1");
        bean4.setTotalMissedPayments("1");
        bean4.setPaidThisMonths("no");
        bean4.setConsecutivePaymentsOnTime("0");
        bean4.setNoOfPracticesAttended("10");
        bean4.setMembersFee("10");
        bean4.setEmail("davidgavin@ryerson.ca");
        bean4.setPracticeMessages("welcome to your first practice");
        bean4.setUnreadMessages("none");

        MemberManager.insert(bean4);

        Member bean5= new Member();
        bean5.setName("James Danny");
        bean5.setPhoneNumber("4162874981");
        bean5.setAddress("5 Toronto Street");
        bean5.setCoachName("C");
        bean5.setConsecutiveMissedPayments("200");
        bean5.setTotalMissedPayments("400");
        bean5.setPaidThisMonths("no");
        bean5.setConsecutivePaymentsOnTime("1");
        bean5.setNoOfPracticesAttended("600");
        bean5.setMembersFee("4000");
        bean5.setEmail("jamesdanny@ryerson.ca");
        bean5.setPracticeMessages("welcome to your first practice");
        bean5.setUnreadMessages("none");


        MemberManager.insert(bean5);

        Member bean6= new Member();
        bean6.setName("Ryan Joel");
        bean6.setPhoneNumber("4168077267");
        bean6.setAddress("6 Toronto Street");
        bean6.setCoachName("C");
        bean6.setConsecutiveMissedPayments("3");
        bean6.setTotalMissedPayments("3");
        bean6.setPaidThisMonths("yes");
        bean6.setConsecutivePaymentsOnTime("0");
        bean6.setNoOfPracticesAttended("69");
        bean6.setMembersFee("30");
        bean6.setEmail("ryanjoel@ryerson.ca");
        bean6.setPracticeMessages("welcome to your first practice");
        bean6.setUnreadMessages("none");

        MemberManager.insert(bean6);

        Member bean7= new Member();
        bean7.setName("Alex Nathan");
        bean7.setPhoneNumber("4167403002");
        bean7.setAddress("7 Toronto Street");
        bean7.setCoachName("C");
        bean7.setConsecutiveMissedPayments("0");
        bean7.setTotalMissedPayments("0");
        bean7.setPaidThisMonths("yes");
        bean7.setConsecutivePaymentsOnTime("30");
        bean7.setNoOfPracticesAttended("30");
        bean7.setMembersFee("0");
        bean7.setEmail("alexnathan@ryerson.ca");
        bean7.setPracticeMessages("welcome to your first practice");
        bean7.setUnreadMessages("none");

        MemberManager.insert(bean7);

        Member bean8= new Member();
        bean8.setName("Daniel Jayden");
        bean8.setPhoneNumber("4163482198");
        bean8.setAddress("8 Toronto Street");
        bean8.setCoachName("C");
        bean8.setConsecutiveMissedPayments("4");
        bean8.setTotalMissedPayments("6");
        bean8.setPaidThisMonths("no");
        bean8.setConsecutivePaymentsOnTime("2");
        bean8.setNoOfPracticesAttended("6");
        bean8.setMembersFee("60");
        bean8.setEmail("danieljayden@ryerson.ca");
        bean8.setPracticeMessages("welcome to your first practice");
        bean8.setUnreadMessages("none");


        MemberManager.insert(bean8);

        Member bean9= new Member();
        bean9.setName("Shawn Chris");
        bean9.setPhoneNumber("4169057585");
        bean9.setAddress("9 Toronto Street");
        bean9.setCoachName("C");
        bean9.setConsecutiveMissedPayments("1");
        bean9.setTotalMissedPayments("1");
        bean9.setPaidThisMonths("yes");
        bean9.setConsecutivePaymentsOnTime("2");
        bean9.setNoOfPracticesAttended("100");
        bean9.setMembersFee("10");
        bean9.setEmail("shawnchris@ryerson.ca");
        bean9.setPracticeMessages("welcome to your first practice");
        bean9.setUnreadMessages("none");


        MemberManager.insert(bean9);

        Member bean10= new Member();
        bean10.setName("Michael Xavier");
        bean10.setPhoneNumber("4164896370");
        bean10.setAddress("10 Toronto Street");
        bean10.setCoachName("C");
        bean10.setConsecutiveMissedPayments("15");
        bean10.setTotalMissedPayments("20");
        bean10.setPaidThisMonths("no");
        bean10.setConsecutivePaymentsOnTime("1");
        bean10.setNoOfPracticesAttended("30");
        bean10.setMembersFee("200");
        bean10.setEmail("michaelxavier@ryerson.ca");
        bean10.setPracticeMessages("welcome to your first practice");
        bean10.setUnreadMessages("none");


        MemberManager.insert(bean10);

        Member bean11= new Member();
        bean11.setName("Chloe Margaret");
        bean11.setPhoneNumber("4169764757");
        bean11.setAddress("11 Toronto Street");
        bean11.setCoachName("C");
        bean11.setConsecutiveMissedPayments("1");
        bean11.setTotalMissedPayments("2");
        bean11.setPaidThisMonths("yes");
        bean11.setConsecutivePaymentsOnTime("1");
        bean11.setNoOfPracticesAttended("10");
        bean11.setMembersFee("20");
        bean11.setEmail("chloemargaret@ryerson.ca");
        bean11.setPracticeMessages("welcome to your first practice");
        bean11.setUnreadMessages("none");

        Member bean12= new Member();
        bean12.setName("Emily Angelina");
        bean12.setPhoneNumber("4168886392");
        bean12.setAddress("12 Toronto Street");
        bean12.setCoachName("C");
        bean12.setConsecutiveMissedPayments("3");
        bean12.setTotalMissedPayments("5");
        bean12.setPaidThisMonths("no");
        bean12.setConsecutivePaymentsOnTime("1");
        bean12.setNoOfPracticesAttended("5");
        bean12.setMembersFee("50");
        bean12.setEmail("tkozak@ryerson.ca");
        bean12.setPracticeMessages("welcome to your first practice");
        bean12.setUnreadMessages("none");

        MemberManager.insert(bean12);

        Member bean13= new Member();
        bean13.setName("Sophie Madison");
        bean13.setPhoneNumber("4163713818");
        bean13.setAddress(" 13 Toronto Street");
        bean13.setCoachName("C");
        bean13.setConsecutiveMissedPayments("0");
        bean13.setTotalMissedPayments("0");
        bean13.setPaidThisMonths("yes");
        bean13.setConsecutivePaymentsOnTime("3");
        bean13.setNoOfPracticesAttended("30");
        bean13.setMembersFee("0");
        bean13.setEmail("sophiemadison@ryerson.ca");
        bean13.setPracticeMessages("welcome to your first practice");
        bean13.setUnreadMessages("none");

        MemberManager.insert(bean13);

        Member bean14= new Member();
        bean14.setName("Hannah Olivia");
        bean14.setPhoneNumber("4167163029");
        bean14.setAddress("14 Toronto Street");
        bean14.setCoachName("C");
        bean14.setConsecutiveMissedPayments("3");
        bean14.setTotalMissedPayments("1");
        bean14.setPaidThisMonths("no");
        bean14.setConsecutivePaymentsOnTime("1");
        bean14.setNoOfPracticesAttended("5");
        bean14.setMembersFee("10");
        bean14.setEmail("tkozak@ryerson.ca");
        bean14.setPracticeMessages("welcome to your first practice");
        bean14.setUnreadMessages("none");

        MemberManager.insert(bean14);

        Member bean15= new Member();
        bean15.setName("Brianna Ella");
        bean15.setPhoneNumber("4162323115");
        bean15.setAddress("15 Toronto Street");
        bean15.setCoachName("C");
        bean15.setConsecutiveMissedPayments("9");
        bean15.setTotalMissedPayments("15");
        bean15.setPaidThisMonths("no");
        bean15.setConsecutivePaymentsOnTime("1");
        bean15.setNoOfPracticesAttended("70");
        bean15.setMembersFee("150");
        bean15.setEmail("briannaella@ryerson.ca");
        bean15.setPracticeMessages("welcome to your first practice");
        bean15.setUnreadMessages("none");

        MemberManager.insert(bean15);

        //StringBuffer buffer= MemberManager.displayAllRows("name");

        //System.out.println(buffer.toString());

     JFrame frame = new Title();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

     User cBean=new User("jpeterson", "password", "coach");
     User tBean=new User("smorning","password1","treasurer");
     User mBean =new User("ajug", "password2","member");

    UserManager.insert(cBean);
    UserManager.insert(tBean);
        UserManager.insert(mBean);

        System.out.println(MemberManager.displayAllRows("name").toString());


    }

}