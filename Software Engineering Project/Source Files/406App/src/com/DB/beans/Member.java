package com.DB.beans;

public class Member {

    private int memberId;
    private String name;
    private String phoneNumber;
    private String address;
    private String coachName;
    private String paidThisMonths;
    private String consecutiveMissedPayments;
    private String totalMissedPayments;
    private String consecutivePaymentsOnTime;
    private String noOfPracticesAttended;
    private String membersFee;
    private String email;
    private int classID;
    private String unreadMessages;
    private String practiceMessages;


    public Member()
    {

    }


    public Member(String memberName, String phone, String memberAddress, String coach, String paidThisMons, String consecMissedPayment, String totalMissedPayment, String consecutivPaymentOntime, String numPracticesAttended, String fee, String e_mail)
    {
        name=memberName;
        phoneNumber=phone;
        address=memberAddress;
        coachName=coach;
        paidThisMonths=paidThisMons;
        consecutiveMissedPayments=consecMissedPayment;
        totalMissedPayments=totalMissedPayment;
        consecutivePaymentsOnTime=consecutivPaymentOntime;
        noOfPracticesAttended=numPracticesAttended;
        membersFee=fee;
        email=e_mail;
        classID=0;
        unreadMessages="";
        practiceMessages="";
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public String getPaidThisMonths() {
        return paidThisMonths;
    }

    public void setPaidThisMonths(String paidThisMonths) {
        this.paidThisMonths = paidThisMonths;
    }

    public String getConsecutiveMissedPayments() {
        return consecutiveMissedPayments;
    }

    public void setConsecutiveMissedPayments(String consecutiveMissedPayments) {
        this.consecutiveMissedPayments = consecutiveMissedPayments;
    }

    public String getTotalMissedPayments() {
        return totalMissedPayments;
    }

    public void setTotalMissedPayments(String totalMissedPayments) {
        this.totalMissedPayments = totalMissedPayments;
    }

    public String getConsecutivePaymentsOnTime() {
        return consecutivePaymentsOnTime;
    }

    public void setConsecutivePaymentsOnTime(String consecutivePaymentsOnTime) {
        this.consecutivePaymentsOnTime = consecutivePaymentsOnTime;
    }

    public String getNoOfPracticesAttended() {
        return noOfPracticesAttended;
    }

    public void setNoOfPracticesAttended(String noOfPracticesAttended) {
        this.noOfPracticesAttended = noOfPracticesAttended;
    }

    public String getMembersFee() {
        return membersFee;
    }

    public void setMembersFee(String membersFee) {
        this.membersFee = membersFee;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public String getUnreadMessages() {
        return unreadMessages;
    }

    public void setUnreadMessages(String unreadMessages) {
        this.unreadMessages = unreadMessages;
    }

    public String getPracticeMessages() {
        return practiceMessages;
    }

    public void setPracticeMessages(String practiceMessages) {
        this.practiceMessages = practiceMessages;
    }

}
