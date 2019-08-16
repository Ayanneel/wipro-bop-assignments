package com.wipro.frs.dao;


	import com.wipro.frs.util.*;
	import com.wipro.frs.bean.*;
	import java.sql.ResultSet;
	import java.sql.Statement;
	import java.sql.Connection;
	import java.sql.PreparedStatement;

	public class DaoPassenger 
	{
		public int insertPassengerDetails(PassengerBean p) throws Exception
		{
			try 
			{
				Connection conn= new DBUtil().connectDatabase();
				String sql= "insert into passenger_details values(?,?,?,?,?,?)";
				PreparedStatement pstmnt= conn.prepareStatement(sql);
				pstmnt.setString(1, p.getPassword());
				pstmnt.setString(2, p.getFirstname());
				pstmnt.setString(3, p.getLastname());
				pstmnt.setInt(4, p.getPhonenumber());
				pstmnt.setString(5, p.getEmail_id());
				pstmnt.setInt(6, p.getPassenger_id());
				int execute=pstmnt.executeUpdate();
				conn.close();
				return execute;
				
			}
			catch (Exception e)
			{
				System.out.println(e);
				return 0;
			}
			
		}
		public void diplayPassengerDetailsAll() throws Exception
		{
			try
			{
				System.out.println("accessed");
				Connection conn= new DBUtil().connectDatabase();
				String sql="select * from passenger_details";
				PreparedStatement ptsmnt= conn.prepareStatement(sql);
				ResultSet rs= ptsmnt.executeQuery();
				while(rs.next())
				{
					System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+ rs.getString(3));
				}
				conn.close();
			
			}
			catch (Exception e)
				{
					System.out.println(e);
				}
		}
		public int returnLastId() throws Exception
		{
			try
			{
				int lastId=0;
				int temp=0;
				Connection conn= new DBUtil().connectDatabase();
				String sql="select * from passenger_details";
				PreparedStatement ptsmnt= conn.prepareStatement(sql);
				ResultSet rs= ptsmnt.executeQuery();
				while(rs.next())
				{
					temp=rs.getInt(6);
					lastId=temp;
				}
			
				return lastId;
			}
			catch(Exception e)
			{
				System.out.println("mistake @ lastId func");
				return 0;
			}
		}
	}


