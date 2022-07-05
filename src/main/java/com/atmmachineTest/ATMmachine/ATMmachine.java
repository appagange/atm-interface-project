package com.atmmachineTest.ATMmachine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;



public class ATMmachine
{
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	protected static long atmCardNo,atmPinNo;
	protected double withdrawAmount;
	public static Connection letConnect() throws SQLException
	{
		Connection conn=null;
		String url,username,password;
		url="jdbc:mysql://:3306/atmDatabase";
		username="root";
		password="root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		
		return conn;
	}
	synchronized static boolean insertCard() throws SQLException, NumberFormatException, IOException
	{
		Connection conn=letConnect();
		String getCardnumber="select atmCardNo from cardDatabase";
		
		try {
			PreparedStatement ps=conn.prepareStatement(getCardnumber);
			//Statement st = conn.createStatement();
			ResultSet rs=ps.executeQuery();
			rs.next();
			long acno=rs.getLong("atmCardNo");
			if(atmCardNo==acno)
			{
				return true;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	synchronized static boolean enterPin() throws SQLException, NumberFormatException, IOException
	{
		Connection conn=letConnect();
		String getPinNo="select atmPinNo from cardDatabase";
		
		try {
			
			Statement st = conn.createStatement();
			ResultSet rs=st.executeQuery(getPinNo);
			rs.next();
			long pinno=rs.getLong("atmPinNo");
		
			if(atmPinNo==pinno)
			{
				return true;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return false;
	}
	
	synchronized public void withdrawal() throws NumberFormatException, IOException, SQLException
	{
		Connection conn=letConnect();
		String getBalance="select balance from cardDatabase";
		String setBalance="update table cardDatabase set balance=avalaibleBalance where pin"
		PreparedStatement ps=conn.prepareStatement(getBalance)	;
		Statement st = conn.createStatement();
		ResultSet rs=st.executeQuery(getBalance);
		rs.next();
		double balance=rs.getLong("balance");
		
		if(withdrawAmount<=balance)
		{
			double avalaibleBalance=balance-withdrawAmount;
			rs.se
			System.out.println("Withdrawal successful!!");
		}
		else
		{
			System.out.println("Insufficient Balance!!");
		}
	}


	public static void main(String[] args) throws SQLException, NumberFormatException, IOException 
	{
		ATMInterface atmi=new ATMInterface();
		ATMmachine.letConnect();
		
		

	}

}
