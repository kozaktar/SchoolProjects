package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.io.*;
import java.lang.*;
import java.net.URI;
import java.net.URISyntaxException;

import com.DB.beans.*;
import com.DB.tables.MemberManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.DB.DButil;
import com.DB.tables.MemberManager;
import com.DB.tables.UserManager;

public class Title extends JFrame implements ActionListener{
	private String username;
    private JRadioButton removeMember;
    private JRadioButton discount;
    private JLabel money;
    private JPanel panel1;
    private JPanel panel2;
    private	JPanel panel3;
    private JButton selRecipient;
    private JButton doneTask;
    private JButton addAMember;
    private	JButton viewMembersList;
    private	JButton messageMembers;
    private	JLabel lName;
    private JLabel lAge;
    private JLabel lAddress;
    private JLabel lNumber;
    private JTextField tName;
    private JTextField tAge;
    private JTextField tAddress;
    private JTextField tNumber;
    private JTextArea infoBox;
    private JTextArea infoBox1;//moe
    private JTextArea infoBox2;//moe
    private JTextArea infoBox3;//moe
    private JTextArea infoBox4;//moe
    private JTextArea infoBox5;//moe
    private JTextArea infoBox6;//moe
    private JTextArea infoBox7;//moe
    private JTextArea infoBox8;//moe
    private JTextArea infoBox9;//moe
    private JTextArea infoBox10;//moe
    private JTextArea infoBox11;//m64h
    private JButton sortDiscount; //moe
    private JButton sortLast; //moe
    private JButton paypallink;//tony
    //MemberManager manager; //moe
    private JTextArea memberList;
    private JTextArea messageBox;
    private JTextArea sendTo; //tony
    private JTextArea pmsgs; //tony
    private String log="";
    //manage schedule variables //mait
    private JTextArea dayEvent;
    private JLabel eventType;
    private JLabel eventTime;
    private JLabel eventCoach;
    private JTextField eventTypeText;
    private JTextField eventTimeText;
    private JTextField eventCoachText;
    private JButton saveEventDetails;
    private JButton resetEventDetails;
    private JButton  removeEventButton;
    //member schedule variables mait
    private JTextArea viewMemberDaySchedule;
    private JButton memberEnroll;
    private JButton memberUnenroll;
    //manage members variables mait
    private JTextArea trMemberListBox;
    private JLabel trMemberIdLabel;
    private JLabel trMemberNameLabel;
    private JLabel trPhoneNumberLabel;
    private JLabel trAddressLabel;
    private JLabel trCoachNameLabel;
    private JLabel trPaidThisMonthLabel;
    private JLabel trConsecutiveMissedPaymentsLabel;
    private JLabel trTotalMissedPaymentsLabel;
    private JLabel trCpOnTimeLabel;
    private JLabel trNoPracticesAttLabel;
    private JLabel trMemberEmailLabel;
    private JLabel trMemberFeeLabel;
    private JTextField trMemberIdText;
    private JTextField trMemberNameText;
    private JTextField trPhoneNumberText;
    private JTextField trAddressText;
    private JTextField trCoachNameText;
    private JTextField trPaidThisMonthText;
    private JTextField trConsecutiveMissedPaymentsText;
    private JTextField trTotalMissedPaymentsText;
    private JTextField trCpOnTimeText;
    private JTextField trNoPracticesAttText;
    private JTextField trMemberEmailText;
    private JTextField trMemberFeeText;
    private JButton trSaveMemberDetails;
    private JButton trResetMemberDetails;

    JButton button1;
    JButton button2;
    String Paid="";
    JTextField un_field;
    JTextField ps_field;
    JButton missedPayments;
    JButton removeguy;
    JButton update;
    JTextField searchName;
    
    
    private JButton clearmsgs;//33333
	JTextArea memmsgs;//33333
	JTextField kill; //
	JTextField namepls;
	
	//addamem
	private JTextArea chMemberListBox;
    private	JButton chSaveMemberDetails;
    private	JButton chResetMemberDetails;
    private JLabel chMemberIdLabel;
    private JLabel chMemberNameLabel;
    private JLabel chPhoneNumberLabel;
    private JLabel chAddressLabel;
    private JLabel chCoachNameLabel;
    private JLabel chPaidThisMonthLabel;
    private JLabel chConsecutiveMissedPaymentsLabel;
    private JLabel chTotalMissedPaymentsLabel;
    private JLabel  chEmailLabel;
    private JLabel chNoPracticesAttLabel;
    private JLabel chMemberFeeLabel;
    private JTextField chMemberIdText;
    private JTextField chMemberNameText;
    private JTextField chPhoneNumberText;
    private JTextField chAddressText;
    private JTextField chCoachNameText;
    private JTextField chPaidThisMonthText;
    private JTextField chConsecutiveMissedPaymentsText;
    private JTextField chTotalMissedPaymentsText;
    private JTextField chEmailText;
    private JTextField chNoPracticesAttText;
    private JTextField chMemberFeeText;

    //manage Coach variables
    private JTextArea trCoachEventCalendar;
    private JTextArea 		trEventListBox;
    private JTextArea trCoachListBox;
    private JLabel 		trCoachsNameLabel;
    private JLabel trCoachSalaryLabel;
    private JLabel trCoachAssignedClassesLabel;
    private JTextField trCoachsNameText;
    private JTextField trCoachSalaryText;
    private JTextField trCoachAssignedClassesText;
    private JButton trCoachSaveChangesButton;
    private JButton trCoachResetChangesButton;
    private JButton trAddACoachButton;
    private JButton trRemoveCoachButton;


    JPanel tppane = new JPanel(new GridBagLayout());
    JPanel filler = new JPanel();

    JTabbedPane tabbedPane = new JTabbedPane();
    JButton exit;

    String header="USER_ID    Name    Phone_Number   Address  Email  Coach_Name  Class_ ID  Paid_This_Month  Consecutive_Missed_Payments  Total_Missed_Payments  Consecutive_Payments_On_time  Number_Of_Practicess_Attended    Balance \n \n";

    Font font = new Font("Times New Roman",Font.BOLD,16);

    public static String formatBuffer(StringBuffer buffer) {
        Scanner scanner;
        Scanner scanner2;
        String output="";
        String temp= buffer.toString();
        scanner=new Scanner(temp);
        while(scanner.hasNextLine())
        {
            scanner2=new Scanner(scanner.nextLine()).useDelimiter(",");
            while(scanner2.hasNext()) {
                output = output + String.format("|%-22s", scanner2.next());
            }
            output=output+"\n";
        }
        System.out.println(output);
        return output;
    }



    public Title() {
        setSize(800,600);
        tppane();
        //tabbedPane(addAMember(), memberList(), messageMembers());
    }
    public void tppane() {
        this.setTitle("Membership Management");
        JPanel pane2 = new JPanel(new GridLayout(1,0,10,1));
        tppane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTHWEST;
        Border border = BorderFactory.createLineBorder(Color.GRAY, 2);
        c.insets = new Insets(75,250,0,250);

        un_field= new JTextField("Username");
        c.fill = GridBagConstraints.HORIZONTAL;

        c.ipady=25;
        c.gridx = 2;
        c.gridy = 0;
        un_field.setBorder(border);
        tppane.add(un_field, c);
        c.insets = new Insets(15,250,0,250);
        ps_field= new JTextField("Password");
        c.weightx=0;

        c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 1;
        ps_field.setBorder(border);
        tppane.add(ps_field, c);

        c.insets = new Insets(30,250,0,250);
        c.gridy = 3;

        button1=new JButton("Login");
        button1.setBackground(Color.lightGray);
        button1.setFont(new Font("Monospace", Font.BOLD, 15));
        button1.setOpaque(true);
        button1.setBorder(border);

        button1.addActionListener(this);

        button2=new JButton("Cancel");
        button2.addActionListener(this);
        button2.setBackground(Color.WHITE);
        button2.setOpaque(true);
        button2.setBorder(border);


        pane2.add(button1);
        pane2.add(button2);
        tppane.add(pane2, c);
        c.weighty=1;
        tppane.add(filler, c);
        add(tppane);
    }
    /*
    class loginButton implements ActionListener {
        public void actionPerformed(ActionEvent x) {
            try {
                loginClicked(un_field.getText(), ps_field.getText());
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    */



    class ShowButton implements ActionListener {//m64h
        public void actionPerformed(ActionEvent x) {
        	try {
        	infoBox11.setText(MemberManager.displayFinances().toString());
        	infoBox7.setText("Expenses:   Coach   Hall\nJanuary: 1340 3000\nFebruary:   1020   3000\nMarch:   900   2900\nApril:   890   3500\nMay:   1300   3200\nJune:   700   2789\nJuly:   849   3827\nAugust:   613   3678\nSeptember:   571   3800\nOctober:   1800   5892\nNovember:   1389   2020\nDecember:   1890   4899");
        	}catch (Exception e) {
        		e.printStackTrace();
        	}
        }
    }
    class ClearButton implements ActionListener {//m64h
        public void actionPerformed(ActionEvent x) {//m64h
             infoBox7.setText("");
             infoBox11.setText("");
    	}
    }

    public void loginClicked(String username, String password) throws Exception
    {
    	this.username = username;
       String login_output=UserManager.login(username, password);
        System.out.println(login_output);
        if(login_output.equals("treasurer"))
        { treasurerTabbedPane(manageMembers(),manageCoach(), manageClubFinances(),logout());}
        if(login_output.equals("coach"))
        { coachTabbedPane(addAMember(),memberList(),messageMembers(),logout());}
        if(login_output.equals("member")) {
        	if(!username.equals("ajug")) {
         memberTabbedPane(memberSchedule(), memberMessages(),memberPayment(),logout());
         memmsgs.setText(MemberManager.getMessages(MemberManager.getRow(username)).toString());
         namepls.setText("$" + MemberManager.getRow(username).getMembersFee());
        }}
       //System.out.println("Hello!");
    }





    public void treasurerTabbedPane( JPanel pan2, JPanel pan3, JPanel pan4,JPanel pan5){
        //JTabbedPane tabbedPane = new JTabbedPane();
        remove(tppane);
        invalidate();
        //tabbedPane.addTab(" Manage Schedule ", pan1);
        tabbedPane.addTab(" Manage Members ", pan2);
        tabbedPane.addTab(" Manage Coach ", pan3);
        tabbedPane.addTab(" Club Finances ", pan4);
        tabbedPane.addTab("Log Out", pan5);
        add(tabbedPane, BorderLayout.CENTER);
        repaint();
        revalidate();
    }

    public void coachTabbedPane(JPanel pan1, JPanel pan2, JPanel pan3, JPanel pan4) throws Exception{
        //JTabbedPane tabbedPane = new JTabbedPane();
        remove(tppane);
        invalidate();
        autoMessage();
        tabbedPane.addTab("Add a Member", pan1);
        tabbedPane.addTab("View Member List", pan2);
        tabbedPane.addTab("Message Members", pan3);
        tabbedPane.addTab("Log Out", pan4);
        add(tabbedPane, BorderLayout.CENTER);
        repaint();
        revalidate();
    }



    public void memberTabbedPane(JPanel pan1, JPanel pan2, JPanel pan3,JPanel pan4){
        //JTabbedPane tabbedPane1 = new JTabbedPane();
        remove(tppane);
        invalidate();
        tabbedPane.addTab("  Schedule  ", pan1);
        tabbedPane.addTab("Messages",pan2);
        tabbedPane.addTab("  Payment  ", pan3);
        tabbedPane.addTab("Log Out", pan4);
        add(tabbedPane, BorderLayout.CENTER);
        repaint();
        revalidate();
    }


    public void autoMessage() throws Exception { //tony
    	  if (!Paid.equals("")) {
        	  JOptionPane frame=new JOptionPane();
              JOptionPane.showMessageDialog(frame,Paid+" paid outstanding balances");
              Paid="";}
        StringBuffer buffer= MemberManager.displayAllRows("totalMissedPayments");
        String[] arr = buffer.toString().split("\n");
        String[] db;
        String[][] arrays=new String[arr.length][];

        for (int i=0;i<arr.length;i++) {
            db=arr[i].toString().split(",|:");
            arrays[i]=db;
        }

        for (int i=0;i<arr.length;i++) {
            for (int a=0;a<arrays[i].length;a++) {
                if(a!=1) {
                    arrays[i][a]=arrays[i][a].replace(" ","");
                }
              

            }
        }
        int count=0;
        String[] outstandingNames=new String[arrays.length];
        for(int i=0;i<arrays.length;i++) {
            if (arrays[i][5].toString().equals("C")) { //change with coach name.
            	 
            	 if (Integer.parseInt(arrays[i][9])>0) {
                       outstandingNames[count]=arrays[i][1];
                       count++;
                   }
                   

            }}



        for (int i=0; i<count;i++) {
            MemberManager.setMessages(outstandingNames[i], "\n Warnings: \n This is an automated message sent to remind you that you have outstanding payments. Please pay now.", "unreadMessage");

        }
        MemberManager.autoUpdateFees();

    }

    public JPanel manageSchedule() 	 {
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel(); //mait

        panel1.setLayout(new GridLayout(1,1));
        panel2.setLayout(new GridLayout(5,2));

        infoBox = new JTextArea("This is left for calendar");
        infoBox.setEditable(true);
        infoBox.setLineWrap(true);
        dayEvent = new JTextArea("This is left for details for the current day");
        dayEvent.setEditable(true);
        dayEvent.setLineWrap(true);

        JScrollPane scroll = new JScrollPane(infoBox);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        JScrollPane scroll2 = new JScrollPane(dayEvent);
        scroll2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        eventType = new JLabel("Event");
        eventTime = new JLabel("Time");
        eventCoach = new JLabel("Coach");
        eventTypeText = new JTextField("");
        eventTimeText = new JTextField("");
        eventCoachText = new JTextField("");
        saveEventDetails = new JButton("Save Changes");
        resetEventDetails = new JButton("Reset");
        removeEventButton = new JButton("Remove");

        panel1.add(scroll);

        panel2.add(eventType);
        panel2.add(eventTypeText);
        panel2.add(eventTime);
        panel2.add(eventTimeText);
        panel2.add(eventCoach);
        panel2.add(eventCoachText);
        panel2.add(saveEventDetails);
        panel2.add(resetEventDetails);
        panel2.add(removeEventButton);

        panel3.add(panel1);
        panel3.add(scroll2);
        panel3.add(panel2);
        panel3.setLayout(new GridLayout(1,3));
        panel3.setBorder(new TitledBorder(new EtchedBorder(), "Manage Schedule"));

        return panel3;
    }  //done
    public JPanel manageMembers() throws Exception { //101
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();

        panel3.setLayout(new GridLayout(1,2));
        panel1.setLayout(new GridLayout(1,1));
        trMemberListBox = new JTextArea("This is left for memberlist");
        trMemberListBox.setText("");

        trMemberListBox.setEditable(true);
        trMemberListBox.setLineWrap(true);
        JScrollPane scroll = new JScrollPane(trMemberListBox);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panel1.add(scroll);

        panel2.setLayout(new GridLayout(12,2));

        trSaveMemberDetails = new JButton("Save");
        trSaveMemberDetails.addActionListener(this);
        trResetMemberDetails = new JButton("Get Member Info");
        trResetMemberDetails.addActionListener(this);


        trMemberIdLabel = new JLabel("Member ID Number");
        trMemberNameLabel  = new JLabel("Name");
        trPhoneNumberLabel	 = new JLabel("Phone Number");
        trAddressLabel	 = new JLabel("Address");
        trCoachNameLabel  = new JLabel("Coach(s) name");
        trPaidThisMonthLabel  = new JLabel("Paid this month");
        trConsecutiveMissedPaymentsLabel  = new JLabel("Consecutive Missed Payments");
        trTotalMissedPaymentsLabel  = new JLabel("Email");
        trCpOnTimeLabel  = new JLabel("cp On Time");
        trNoPracticesAttLabel  = new JLabel("Total Practices attended");
        trMemberFeeLabel = new JLabel("Member Fee");
        trMemberIdText = new JTextField("");
        trMemberNameText = new JTextField("");
        trPhoneNumberText = new JTextField("");
        trAddressText = new JTextField("");
        trCoachNameText = new JTextField("");
        trPaidThisMonthText = new JTextField("");
        trConsecutiveMissedPaymentsText = new JTextField("");
        trTotalMissedPaymentsText = new JTextField("");
        trCpOnTimeText = new JTextField("");
        trNoPracticesAttText = new JTextField("");
        trMemberFeeText = new JTextField("");
        panel2.add(trMemberIdLabel);
        panel2.add(trMemberIdText);

        panel2.add(trMemberNameLabel);
        panel2.add(trMemberNameText);
        panel2.add(trPhoneNumberLabel);
        panel2.add(trPhoneNumberText);
        panel2.add(trAddressLabel);
        panel2.add(trAddressText);
        panel2.add(trCoachNameLabel);
        panel2.add(trCoachNameText);
        panel2.add(trPaidThisMonthLabel);
        panel2.add(trPaidThisMonthText);
        panel2.add(trConsecutiveMissedPaymentsLabel);
        panel2.add(trConsecutiveMissedPaymentsText);
        panel2.add(trTotalMissedPaymentsLabel);
        panel2.add(trTotalMissedPaymentsText);
        panel2.add(trCpOnTimeLabel);
        panel2.add(trCpOnTimeText);
        panel2.add(trNoPracticesAttLabel);
        panel2.add(trNoPracticesAttText);
        panel2.add(trMemberFeeLabel);
        panel2.add(trMemberFeeText);
        panel2.add(trResetMemberDetails);
        panel2.add(trSaveMemberDetails);


        panel3.add(panel1);
        panel3.add(panel2);
        panel3.setBorder(new TitledBorder(new EtchedBorder(), "Manage Members"));

        return panel3;
    }  //done
    public JPanel manageCoach() {
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();


        trCoachEventCalendar = new JTextArea("This is left for calendar displaying events");
        trCoachEventCalendar.setEditable(true);
        trCoachEventCalendar.setLineWrap(true);
        JScrollPane scroll = new JScrollPane(trCoachEventCalendar);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panel1.add(scroll);
        panel1.setBorder(new TitledBorder(new EtchedBorder(), "Calendar"));

        trEventListBox = new JTextArea("Event info on selected day will be here");
        trEventListBox.setEditable(true);
        trEventListBox.setLineWrap(true);
        JScrollPane scroll1 = new JScrollPane(trEventListBox);
        scroll1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panel2.add(scroll1);
        panel2.setBorder(new TitledBorder(new EtchedBorder(), "Events"));

        trCoachListBox = new JTextArea("List of Coaches will be here");
        trCoachListBox.setEditable(true);
        trCoachListBox.setLineWrap(true);
        JScrollPane scroll2 = new JScrollPane(trCoachListBox);
        scroll2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panel3.add(scroll2);
        panel3.setBorder(new TitledBorder(new EtchedBorder(), "Coach List"));

        trCoachsNameLabel = new JLabel("Name");
        trCoachSalaryLabel = new JLabel("Salary");
        trCoachAssignedClassesLabel = new JLabel("Classes");
        trCoachsNameText = new JTextField("");
        trCoachSalaryText = new JTextField("");
        trCoachAssignedClassesText = new JTextField("");
        trCoachSaveChangesButton = new JButton("Save Changes");
        trCoachResetChangesButton = new JButton("Reset Changes");
        trAddACoachButton = new JButton("Add New Coach");
        trAddACoachButton.addActionListener(this); //998
        trRemoveCoachButton = new JButton("Remove Coach");
        panel4.setLayout(new GridLayout(5,2));
        panel4.add(trCoachsNameLabel);
        panel4.add(trCoachsNameText);
        panel4.add(trCoachSalaryLabel);
        panel4.add(trCoachSalaryText);
        panel4.add(trCoachAssignedClassesLabel);
        panel4.add(trCoachAssignedClassesText);
        panel4.add(trCoachSaveChangesButton);
        panel4.add(trCoachResetChangesButton);
        panel4.add(trAddACoachButton);
        panel4.add(trRemoveCoachButton);
        panel4.setBorder(new TitledBorder(new EtchedBorder(), "Coach Details"));

        panel1.setLayout(new GridLayout(1,1));
        panel2.setLayout(new GridLayout(1,1));
        panel3.setLayout(new GridLayout(1,1));

        panel5.add(panel1);
        panel5.add(panel2);
        panel5.add(panel3);
        panel5.add(panel4);
        panel5.setLayout(new GridLayout(2,2));
        panel5.setBorder(new TitledBorder(new EtchedBorder(), "Manage Coach"));

        return panel5;
    }  //undone
    public JPanel manageClubFinances() {
                JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();

        infoBox7 = new JTextArea();//moe
        infoBox7.setEditable(false);//moe
        infoBox7.setLineWrap(true);//moe
        
        infoBox11 = new JTextArea();//m64h
        infoBox11.setEditable(false);//m64h
        infoBox11.setLineWrap(true);//m64h

        JScrollPane scroll = new JScrollPane(infoBox7);//moe
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);//m64h
        scroll.setBorder(new TitledBorder(new EtchedBorder(), "Income Statement under Expenses"));//m64h
        
        JScrollPane scroll1 = new JScrollPane(infoBox11);//m64h
        scroll1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);//m64h
        scroll1.setBorder(new TitledBorder(new EtchedBorder(), "Income Statement under Revenues"));//m64h
        
        selRecipient = new JButton("Show");//m64h
        ActionListener selShow = new ShowButton();//m64h
        selRecipient.addActionListener(selShow);//m64h
        		
        doneTask = new JButton("Clear");//m64h
        ActionListener doneClear = new ClearButton();//m64h
        doneTask.addActionListener(doneClear);//m64h
        		
        
        
        panel1.add(scroll);//m64h
        panel1.add(scroll1);//m64h
        panel1.setLayout(new GridLayout(1,2));//m64h
        panel2.add(selRecipient);
        panel2.add(doneTask);

        panel3.add(panel1);
        panel3.add(panel2);
        panel3.setLayout(new GridLayout(2,1));
        //panel3.setBorder(new TitledBorder(new EtchedBorder(), "")); //m64h

        return panel3;
    }  //undone


    public JPanel memberSchedule() {
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel(); //mait
        JPanel panel4 = new JPanel();

        panel3.setLayout(new GridLayout(1,2)); //full
        panel2.setLayout(new GridBagLayout()); //right bottom
        panel4.setLayout(new GridBagLayout()); //right

        GridBagConstraints gbc = new GridBagConstraints();

        infoBox = new JTextArea("This is left for the calender");
        infoBox.setEditable(true);
        infoBox.setLineWrap(true);
        JScrollPane scroll = new JScrollPane(infoBox);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panel1.add(scroll);

        viewMemberDaySchedule = new JTextArea("This is left for events on that day");
        viewMemberDaySchedule.setEditable(true);
        viewMemberDaySchedule.setLineWrap(true);
        JScrollPane scroll1 = new JScrollPane(viewMemberDaySchedule);
        scroll1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        gbc.insets = new Insets(1,1,10,1);
        gbc.weightx = 0.5;
        gbc.weighty = 50;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.ipadx = 50;
        //gbc.ipady = 50;
        panel4.add(scroll1, gbc);

        panel1.add(scroll);
        panel1.setLayout(new GridLayout(1,1));

        panel4.add(scroll1);
        memberEnroll = new JButton("Enroll");
        memberUnenroll = new JButton("Unenroll");
        panel2.add(memberEnroll);
        panel2.add(memberUnenroll);
        gbc.insets = new Insets(1,1,10,30);
        gbc.anchor = GridBagConstraints.LAST_LINE_START;
        gbc.weightx = 5;
        panel4.add(panel2, gbc);

        panel3.add(panel1);
        panel3.add(panel4);
        panel3.setBorder(new TitledBorder(new EtchedBorder(), "Schedule for Session"));

        return panel3;
    }//done

    public JPanel memberPayment() {//tony 55555
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        
        
        
        infoBox4 = new JTextArea();
        infoBox4.setEditable(false);
        infoBox4.setLineWrap(true);
        infoBox4.setText("Membership Payment Instructions: \n\nEnter your Name into the field. \nClick on the Button below. \nYou will be redirected to Paypal's website, opening in your default browser, if able. \nFollow Paypal's instructions. \nMake all payments to Toronto Gym. \n\nYou are only allowed to pay the entire Outstanding Payment.");
        
        namepls = new JTextField("");
        money = new JLabel("Balance Owed: ");
        paypallink = new JButton("Redirect to Paypal's website");
        paypallink.addActionListener(this);
        
        panel1.add(infoBox4);
        panel1.setLayout(new GridLayout(1,1));
        panel2.add(money);
        panel2.add(namepls);
        panel2.add(paypallink);
        

        panel3.add(panel1);
        panel3.add(panel2);
        panel3.setLayout(new GridLayout(2,1));
        panel3.setBorder(new TitledBorder(new EtchedBorder(), "Pay by Paypal"));

        return panel3;
    } //done

    public JPanel addAMember() {

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();

        
        panel1.setLayout(new GridLayout(1,1));
        chMemberListBox = new JTextArea("This is left for member list");
        chMemberListBox.setEditable(true);
        chMemberListBox.setLineWrap(true);
        JScrollPane scroll = new JScrollPane(chMemberListBox);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        

        panel2.setLayout(new GridLayout(12,2));
        chSaveMemberDetails = new JButton("Save");
        chSaveMemberDetails.addActionListener(this);
        chResetMemberDetails = new JButton("Refresh");
        
        chMemberNameLabel  = new JLabel("Name");
        chPhoneNumberLabel	 = new JLabel("Phone Number");
        chAddressLabel	 = new JLabel("Address");
        chCoachNameLabel  = new JLabel("Coach(s) name");
        chPaidThisMonthLabel  = new JLabel("Paid this month");
        chConsecutiveMissedPaymentsLabel  = new JLabel("Consecutive Missed Payments");
        chTotalMissedPaymentsLabel  = new JLabel("Total Missed Payments");
        chEmailLabel  = new JLabel("Email");
        chNoPracticesAttLabel  = new JLabel("Total Practices attended");
        chMemberFeeLabel = new JLabel("Member Fee");
        chMemberNameText = new JTextField("-");
        chPhoneNumberText = new JTextField("-");
        chAddressText = new JTextField("-");
        chCoachNameText = new JTextField("-");
        chPaidThisMonthText = new JTextField("no");
        chConsecutiveMissedPaymentsText = new JTextField("0");
        chTotalMissedPaymentsText = new JTextField("0");
        chEmailText = new JTextField("-");
        chNoPracticesAttText = new JTextField("0");
        chMemberFeeText = new JTextField("-");
        panel2.add(chMemberNameLabel);
        panel2.add(chMemberNameText);
        panel2.add(chMemberFeeLabel);
        panel2.add(chMemberFeeText);
        panel2.add(chPhoneNumberLabel);
        panel2.add(chPhoneNumberText);
        panel2.add(chAddressLabel);
        panel2.add(chAddressText);
        panel2.add(chCoachNameLabel);
        panel2.add(chCoachNameText);
        panel2.add(chPaidThisMonthLabel);
        panel2.add(chPaidThisMonthText);
        panel2.add(chConsecutiveMissedPaymentsLabel);
        panel2.add(chConsecutiveMissedPaymentsText);
        panel2.add(chTotalMissedPaymentsLabel);
        panel2.add(chTotalMissedPaymentsText);
        panel2.add(chEmailLabel);
        panel2.add(chEmailText);
        panel2.add(chNoPracticesAttLabel);
        panel2.add(chNoPracticesAttText);
        panel2.add(chMemberFeeLabel);
        panel2.add(chMemberFeeText);
        panel2.add(chSaveMemberDetails);
       //panel2.add(chResetMemberDetails);
        panel3.add(panel2);
        panel3.add(panel1);
        panel3.setBorder(new TitledBorder(new EtchedBorder(), "Add a Member"));

        return panel3;
    } //done
    public JPanel messageMembers() throws SQLException { // tony

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();
        JPanel panel6 = new JPanel();

        messageBox = new JTextArea();
        messageBox.setEditable(true);
        messageBox.setLineWrap(true);
        messageBox.setText("Enter your Message Here");

        pmsgs= new JTextArea();
        pmsgs.setEditable(false);
        pmsgs.setLineWrap(true);

        if (!log.equals("")) {
            pmsgs.setText(log);
        }

        sendTo= new JTextArea();
        JLabel instructions = new JLabel("Enter names, seperated by a ';' ");

        JScrollPane scroll = new JScrollPane(messageBox);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JScrollPane scroll2 = new JScrollPane(pmsgs);
        scroll2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JScrollPane scroll3 = new JScrollPane(sendTo);
        scroll3.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        selRecipient = new JButton("Select all of your members");
        selRecipient.addActionListener(this);

        doneTask = new JButton("Send");
        doneTask.addActionListener(this);


        panel4.add(scroll);
        panel1.add(pmsgs);
        panel5.add(instructions);
        panel5.add(scroll3);
        panel1.setLayout(new GridLayout(1,1));
        panel4.setLayout(new GridLayout(1,1));
        panel5.setLayout(new GridLayout(2,1));
        panel6.setLayout(new GridLayout(1,2));
        panel2.add(selRecipient);
        panel2.add(doneTask);

        panel3.add(panel1);
        panel6.add(panel5);
        panel6.add(panel4);
        panel3.add(panel6);
        panel3.add(panel2);
        panel3.setLayout(new GridLayout(3,1));
        panel1.setBorder(new TitledBorder(new EtchedBorder(), "Previous Messages"));
        panel4.setBorder(new TitledBorder(new EtchedBorder(), "Message"));
        panel5.setBorder(new TitledBorder(new EtchedBorder(), "Send To"));
        return panel3;
    } //done

    public JPanel memberList() { //77777
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel(); //moeh

        infoBox1 = new JTextArea();//moe
        infoBox1.setEditable(true);//moe
        infoBox1.setLineWrap(true);//moe

        JScrollPane scroll = new JScrollPane(infoBox1);//moe
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        sortLast = new JButton("Sort By First Name");// moeh
        sortDiscount = new JButton("Sort By Attendance"); // moeh

        missedPayments=new JButton("Sort by Missed Payments"); //tony
        missedPayments.addActionListener(this); //tony

        ActionListener sortLastListener = new sortFirstButton(); //moeh
        sortLast.addActionListener(sortLastListener);//moeh

        ActionListener sortLastDiscount = new sortDiscountButton();//moeh
        sortDiscount.addActionListener(sortLastDiscount);//moeh

        kill = new JTextField("Enter Name to be Removed"); //tony
        
        removeguy = new JButton("Remove Member"); //tony
        removeguy.addActionListener(this);
        


        
        //removeMember = new JRadioButton("Remove member");
       // discount = new JRadioButton("Apply 10% Discount");
        //ButtonGroup buttonGroup = new ButtonGroup();
        //buttonGroup.add(removeMember);
        //buttonGroup.add(discount);
        //removeMember.setSelected(true);
        
        
        
        panel4.add(kill);
        panel4.add(removeguy);
       // panel4.add(discount);
        panel1.add(scroll);
        panel1.setLayout(new GridLayout(1,1));
   
        panel5.add(sortLast); //moeh
        panel5.add(sortDiscount);//moeh
        panel5.add(missedPayments); //tony

        panel3.add(panel1);
        panel3.add(panel4);
        panel3.add(panel5);//moeh
        panel3.add(panel2);
        panel3.setLayout(new GridLayout(4,1)); //moeh
        panel3.setBorder(new TitledBorder(new EtchedBorder(), "Member List"));

        return panel3;
    }
    
    public JPanel memberMessages() throws SQLException { //tony //33333
		JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();

        memmsgs = new JTextArea();
        memmsgs.setEditable(false);
        memmsgs.setLineWrap(true);
        
        
        searchName=new JTextField("Enter your name here");
   
        update=new JButton("Get Message/Update");
        update.addActionListener(this);
        
        clearmsgs=new JButton("Clear Messages");
        clearmsgs.addActionListener(this);
        
        JScrollPane scroll = new JScrollPane(memmsgs);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
      
        panel1.add(scroll);
		panel1.setLayout(new GridLayout(1,1));
	    //panel2.add(searchName);
		//panel2.add(update);
        panel2.add(clearmsgs);
        panel3.setLayout(new GridLayout(2,1));
        panel3.add(scroll);
        panel3.add(panel2);
      
        panel3.setBorder(new TitledBorder(new EtchedBorder(), "Message Inbox"));

        return panel3;
	} 

    public JPanel logout() {

        JPanel panel3 = new JPanel();

        panel3.setLayout(new GridBagLayout());
        GridBagConstraints con = new GridBagConstraints();
        con.fill = GridBagConstraints.HORIZONTAL;
        JLabel label = new JLabel("Test");
        label.setText("Save your work and return to Title Screen?");
        exit= new JButton("Log out");


        panel3.add(label,con);
        con.insets=new Insets(10,0,100,0);
        con.gridy=1;
        panel3.add(exit,con);


        exit.addActionListener(this);
        panel3.setBorder(new TitledBorder(new EtchedBorder(), "Log Out"));

        return panel3;
    }

    public String getAllNames() throws Exception {  //tony


        StringBuffer buffer= MemberManager.displayAllRows("name");


        String[] arr = buffer.toString().split("\n");
        String[] db;
        String[][] arrays=new String[arr.length][];
        String f="";
        String e="";

        for (int i=0;i<arr.length;i++) {
            db=arr[i].toString().split(",|:");
            arrays[i]=db;
        }

        for (int i=0;i<arr.length;i++) {
            for (int a=0;a<arrays[i].length;a++) {
                if(a!=1) {
                    arrays[i][a]=arrays[i][a].replace(" ","");
                }
              

            }
        }
        String a="";
        for(int i=0;i<arrays.length;i++) {
            if (arrays[i][5].toString().equals("C")) {
                a=a+arrays[i][1]+";";
            }

        }

        return a;

    }

    public String getAnything(String id) throws Exception {  //tony 102


        StringBuffer buffer= MemberManager.displayAllRows("name");


        String[] arr = buffer.toString().split("\n");
        String[] db;
        String[][] arrays=new String[arr.length][];
        String f="";
        String e="";

        for (int i=0;i<arr.length;i++) {
            db=arr[i].toString().split(",|:");
            arrays[i]=db;
        }

        for (int i=0;i<arr.length;i++) {
            for (int a=0;a<arrays[i].length;a++) {
                if(a!=1) {
                    arrays[i][a]=arrays[i][a].replace(" ","");
                }


            }
        }
        String a="";
        for(int i=0;i<arrays.length;i++) {
            if (arrays[i][0].toString().equals(id)) {
                return arr[i];
            }

        }

        return "Doesnt exist";

    }

    public String getAnythingName(String name) throws Exception {  //tony 102


        StringBuffer buffer= MemberManager.displayAllRows("name");


        String[] arr = buffer.toString().split("\n");
        String[] db;
        String[][] arrays=new String[arr.length][];
        String f="";
        String e="";

        for (int i=0;i<arr.length;i++) {
            db=arr[i].toString().split(",|:");
            arrays[i]=db;
        }

        for (int i=0;i<arr.length;i++) {
            for (int a=0;a<arrays[i].length;a++) {
                if(a!=1) {
                    arrays[i][a]=arrays[i][a].replace("","");
                }


            }
        }
        String a="";
        for(int i=0;i<arrays.length;i++) {
            if (arrays[i][1].toString().equals(name)) {
                return arr[i];
            }

        }

        return "Doesnt exist";

    }









    public void actionPerformed(ActionEvent e){
        JButton button = (JButton) e.getSource();
        if (button.equals(exit)) {
            remove (tabbedPane);
            tabbedPane.removeAll();
            invalidate();
            add(tppane);
            revalidate();
            repaint();
        }
        else if (button.equals(button1)) {
            try {
                loginClicked(un_field.getText(), ps_field.getText());
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
        else if (button.equals(selRecipient)) { //tony
            try {
                sendTo.setText(getAllNames());
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
        else if (button.equals(doneTask)) { //tony
            String text=messageBox.getText();
            String rec=sendTo.getText();
            String[]recArray=rec.split(";");
            for (int i=0;i<recArray.length;i++) {
                try {
                    MemberManager.setMessages(recArray[i], "Coach Messages: \n"+text, "practiceMessage");
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

            }
            messageBox.setText("Enter your Message Here");
            log=log+text+"\n";
            pmsgs.setText(log);


        }
        else if (button.equals(paypallink)) { //tony
        	
//        		 try {
//                     namepls.setText(MemberManager.getRow(username).getMembersFee());
//                     System.out.println("111111111111: " + MemberManager.getRow(username).getMembersFee());
//                     } catch (Exception e1) {
//                  	   e1.printStackTrace();
//                     }
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.paypal.com/ca/home"));
                    Paid=Paid+username;
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (URISyntaxException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        }
        else if(button.equals(missedPayments)){ //tony
            try {
                infoBox1.setText(header+MemberManager.displayAllRows("totalmissedpayments").toString());
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
        else if(button.equals(missedPayments)){ //tony
            try {
                infoBox1.setText(MemberManager.displayAllRows("totalmissedpayments").toString());
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
        else if (button.equals(trAddACoachButton)) { //998
         if(!trCoachsNameText.getText().equals("")) {
       	 User cBean=new User(trCoachsNameText.getText(), "coach", "coach");
       	JOptionPane frame=new JOptionPane();
        JOptionPane.showMessageDialog(frame,"Coach Added");
       	 try {
				UserManager.insert(cBean);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				System.out.println("oh no");
				e1.printStackTrace();
			}
         }
       }
        else if(button.equals(clearmsgs)){ //tony
            
                memmsgs.setText("");
                try {
					MemberManager.clearMessages(MemberManager.getRow(username));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
         
        }
        else if (button.equals(removeguy)) { //tony
        	try {
        		System.out.println("Removed");
				MemberManager.delete(kill.getText());
				infoBox1.setText(MemberManager.displayAllRows("Name").toString());
			} catch (Exception e1) {
				System.out.println("Invalid Name");
				e1.printStackTrace();
			}
        }
        else if (button.equals(button2)) {
        	 System.exit(0);
        }
        else if (button.equals(update)) { //tony
        	if (searchName.getText().equals("Enter your name here")) {
        		memmsgs.setText("Enter a valid name please");
        	}
        	else
        	try {
        		 memmsgs.setText("Coach Messages: \n"+MemberManager.getMessages(MemberManager.getRow(searchName.getText())).toString());
			} catch (Exception e1) {
				System.out.println("Invalid Name");
				memmsgs.setText("Not a Valid Name.");
				e1.printStackTrace();
			}
        }
        else if (button.equals(trResetMemberDetails)) {//101
            try {
            	
                trMemberListBox.setText(getAnything(trMemberIdText.getText()));
            
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
        else if (button.equals(trSaveMemberDetails)) {//tony
            try {
                MemberManager.delete(trMemberNameText.getText());
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            if (trMemberNameText.getText().equals("")||trPhoneNumberText.getText().equals("")||trAddressText.getText().equals("")||trCoachNameText.getText().equals("")||trConsecutiveMissedPaymentsText.getText().equals("")||trPaidThisMonthText.getText().equals("")||trCpOnTimeText.getText().equals("")||trNoPracticesAttText.getText().equals("")||trMemberFeeText.getText().equals("")||trTotalMissedPaymentsText.getText().equals("")) {
                JOptionPane frame=new JOptionPane();
                JOptionPane.showMessageDialog(frame,"Enter Everything");
            }
            else {
            	int op;
            			try {
            			    op = Integer.parseInt(trPhoneNumberText.getText());
            			} catch (NumberFormatException ew) {
            			    System.out.println("Not a Number");
            			    trPhoneNumberText.setText("4160000000");
            			}
            			try {
            			    op = Integer.parseInt(trConsecutiveMissedPaymentsText.getText());
            			} catch (NumberFormatException ew) {
            			    System.out.println("Not a Number");
            			    trConsecutiveMissedPaymentsText.setText("0");
            			}
            			try {
            			    op = Integer.parseInt(trTotalMissedPaymentsText.getText());
            			} catch (NumberFormatException ew) {
            			    System.out.println("Not a Number");
            			    trTotalMissedPaymentsText.setText("Example@email.ca");
            			}
            			try {
            			    op = Integer.parseInt(trMemberFeeText.getText());
            			} catch (NumberFormatException ew) {
            			    System.out.println("Not a Number");
            			    trMemberFeeText.setText("10");
            			}
            			try {
            			    op = Integer.parseInt(trNoPracticesAttText.getText());
            			} catch (NumberFormatException ew) {
            			    System.out.println("Not a Number");
            			    trNoPracticesAttText.setText("0");
            			}
            			try {
            			    op = Integer.parseInt(trCpOnTimeText.getText());
            			} catch (NumberFormatException ew) {
            			    System.out.println("Not a Number");
            			    trCpOnTimeText.setText("0");
            			}
            			if (!trPaidThisMonthText.getText().equals("no")||!trPaidThisMonthText.getText().equals("yes")) {
            				trPaidThisMonthText.setText("no");
            			}
            			
            			
                Member bean8=new Member();
                bean8.setName(trMemberNameText.getText());
                bean8.setPhoneNumber( trPhoneNumberText.getText());
                bean8.setAddress(trAddressText.getText());
                bean8.setCoachName(trCoachNameText.getText());
                bean8.setConsecutiveMissedPayments(trConsecutiveMissedPaymentsText.getText());
                bean8.setTotalMissedPayments("0");
                bean8.setPaidThisMonths( trPaidThisMonthText.getText());
                bean8.setConsecutivePaymentsOnTime(trCpOnTimeText.getText());
                bean8.setNoOfPracticesAttended(trNoPracticesAttText.getText());
                bean8.setMembersFee(trMemberFeeText.getText());
                bean8.setEmail(trTotalMissedPaymentsText.getText());
                bean8.setPracticeMessages("");
                bean8.setUnreadMessages("");
                try {
                    MemberManager.insert(bean8);
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                JOptionPane frame=new JOptionPane();
                JOptionPane.showMessageDialog(frame,"Member Modified!");
            
            }

        }
        else if (button.equals(chSaveMemberDetails)) {
       	 Member bean= new Member();
       	 if (chMemberNameText.getText().equals("-")) {
       		 chMemberNameText.setText("Enter a valid Name.");
       	 }
       	 else if (chPhoneNumberText.getText().equals("-")) {
       		 chPhoneNumberText.setText("Enter a valid Name.");
       	 }
       	 else if (chAddressText.getText().equals("-")) {
       		 chAddressText.setText("Enter a valid Address.");
       	 }
       	 else if (chEmailText.getText().equals("-")) {
       		 chEmailText.setText("Enter a valid Email.");
       	 }
       	 else if (chMemberFeeText.getText().equals("-")) {
       		 chMemberFeeText.setText("Enter a fee");
       	 }
       	 else {
       		 int op;
    			try {
    			    op = Integer.parseInt(chPhoneNumberText.getText());
    			} catch (NumberFormatException ew) {
    			    System.out.println("Not a Number");
    			    chPhoneNumberText.setText("4160000000");
    			}
    			try {
    			    op = Integer.parseInt(chConsecutiveMissedPaymentsText.getText());
    			} catch (NumberFormatException ew) {
    			    System.out.println("Not a Number");
    			    chConsecutiveMissedPaymentsText.setText("0");
    			}
    			try {
    			    op = Integer.parseInt(chTotalMissedPaymentsText.getText());
    			} catch (NumberFormatException ew) {
    			    System.out.println("Not a Number");
    			    chTotalMissedPaymentsText.setText("Example@email.ca");
    			}
    			try {
    			    op = Integer.parseInt(chMemberFeeText.getText());
    			} catch (NumberFormatException ew) {
    			    System.out.println("Not a Number");
    			    chMemberFeeText.setText("10");
    			}
    			try {
    			    op = Integer.parseInt(chNoPracticesAttText.getText());
    			} catch (NumberFormatException ew) {
    			    System.out.println("Not a Number");
    			    chNoPracticesAttText.setText("0");
    			}
    		
    			if (!chPaidThisMonthText.getText().equals("no")||!chPaidThisMonthText.getText().equals("yes")) {
    				chPaidThisMonthText.setText("no");
    			}
       	    bean.setName(chMemberNameText.getText());
            bean.setPhoneNumber(chPhoneNumberText.getText());
            bean.setAddress(chAddressText.getText());
            bean.setCoachName(chCoachNameText.getText());
            bean.setConsecutiveMissedPayments(chConsecutiveMissedPaymentsText.getText());
            bean.setTotalMissedPayments(chTotalMissedPaymentsText.getText());
            bean.setPaidThisMonths(chPaidThisMonthText.getText());
            bean.setConsecutivePaymentsOnTime("0");
            bean.setNoOfPracticesAttended(chNoPracticesAttText.getText());
            bean.setMembersFee(chMemberFeeText.getText());
            bean.setEmail(chEmailText.getText());
            bean.setPracticeMessages("none");
            bean.setUnreadMessages("none");
            JOptionPane frame=new JOptionPane();
            JOptionPane.showMessageDialog(frame,"Successfully added.");
            try {
				MemberManager.insert(bean);
			} catch (Exception e1) {
				System.out.println("idk smth doesnt work");
				e1.printStackTrace();
			}
            System.out.println("works");
            try {
 				MemberManager.insert(bean);
 			} catch (Exception e1) {
 				System.out.println("idk smth doesnt work");
 				e1.printStackTrace();
 			}
              User cBean=new User(chMemberNameText.getText(), "member", "member");
              try {
 				UserManager.insert(cBean);
 			} catch (Exception e1) {
 				// TODO Auto-generated catch block
 				e1.printStackTrace();
 			}
         }}
        	 


    }


    class sortFirstButton implements ActionListener { //moe
        public void actionPerformed(ActionEvent x) {
            try {
                infoBox1.setText(header + MemberManager.displayAllRows("Name").toString());
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    class sortDiscountButton implements ActionListener {//moe
        public void actionPerformed(ActionEvent x) {

            try {
                infoBox1.setText(header+ MemberManager.displayAllRows("PAIDTHISMONTH").toString());
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }


}




