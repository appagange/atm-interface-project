package com.atmmachineTest.ATMmachine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ATMInterface extends ATMmachine implements ActionListener {
	protected static JLabel cardlabel,pinlabel,success;
	protected static JTextField cardno;
	protected static JPasswordField pinno;
	protected static JButton login;

	public static void main(String[] args) throws SQLException, NumberFormatException, IOException 
	{
		
		JPanel panel=new JPanel();
		JFrame frame=new JFrame();
		frame.setSize(400,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(panel);
		frame.setTitle("Automated Teller Machine");
		panel.setLayout(null);
		
		
		 cardlabel=new JLabel("Card Number");
		cardlabel.setBounds(10, 20, 80, 25);
		panel.add(cardlabel);
		
		cardno=new JTextField(25);
		cardno.setBounds(100, 20, 165,25);
		
		panel.add(cardno);
		
		pinlabel=new JLabel("PIN Number");
		pinlabel.setBounds(10, 50, 80, 25);
		panel.add(pinlabel);
		
		pinno=new JPasswordField(25);
		pinno.setBounds(100, 50, 165,25);
		
		panel.add(pinno);
		
		login=new JButton("Login");
		login.setBounds(10, 80, 80, 25);
		login.addActionListener(new ATMInterface());
		panel.add(login);
		
		success=new JLabel("");
		success.setBounds(10, 100, 165, 25);
		panel.add(success);	
		
		frame.setVisible(true);
		
		
	}

	public void actionPerformed(ActionEvent e) 
	{
		try {
			atmCardNo=Integer.parseInt(cardno.getText());
			atmPinNo=Integer.parseInt(pinno.getText());
			if(insertCard()==true && enterPin()==true)
			{
				success.setText("Login Successfully..");
				afterLoginWindow();
			}
			else
			{
				success.setText("You entered Wrong data");
			}
		} catch (NumberFormatException e1) {
			
			e1.printStackTrace();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		
	}
	public void afterLoginWindow()
	{
		JPanel panel=new JPanel();
		JFrame frame=new JFrame();
		frame.setSize(400,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(panel);
		frame.setTitle("Automated Teller Machine");
		panel.setLayout(null);
		
		JLabel loginwindolabel=new JLabel();
		loginwindolabel.setText("Dear Customer,Welcome to SBI Bank.");
		loginwindolabel.setBounds(50, 10, 400, 25);
		panel.add(loginwindolabel);
		
		JButton withdrawButton=new JButton("Withdraw");
		withdrawButton.setBounds(10, 80, 110, 25);
		panel.add(withdrawButton);
		
		JButton balanceInquiryButton=new JButton("Balance Inquiry");
		balanceInquiryButton.setBounds(200, 80, 130, 25);
		panel.add(balanceInquiryButton);
		
		JButton paymentButton=new JButton("Payment");
		paymentButton.setBounds(10, 140, 90, 25);
		panel.add(paymentButton);
		
		JButton transferButton=new JButton("Transfer");
		transferButton.setBounds(200, 140, 100, 25);
		panel.add(transferButton);
		
		JButton depositButton=new JButton("Deposit");
		depositButton.setBounds(10, 200, 110, 25);
		panel.add(depositButton);
		
		JButton changePinButton=new JButton("Change PIN");
		changePinButton.setBounds(200, 200, 110, 25);
		panel.add(changePinButton);
		frame.setVisible(true);
	}

}
