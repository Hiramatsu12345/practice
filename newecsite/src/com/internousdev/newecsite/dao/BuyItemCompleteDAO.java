package com.internousdev.newecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.newecsite.util.DBConnector;
import com.internousdev.newecsite.util.DateUtil;

public class BuyItemCompleteDAO {

	private DBConnector dbConnector=new DBConnector();
	private Connection con=dbConnector.getConnection();
	private DateUtil dateUtil=new DateUtil();
	private String sql="INSERT INTO user_buy_item_transaction (item_transaction_id, total_price, total_count, user_master_id, pay, insert_date)"
			+ " VALUES(?, ?, ?, ?, ?, ?)";

	public void buyItemeInfo(String item_transaction_id, String user_master_id,
			String total_price, String total_count, String pay)throws SQLException{
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, item_transaction_id);
			ps.setString(2, total_price);
			ps.setString(3, total_count);
			ps.setString(4, user_master_id);
			ps.setString(5, pay);
			ps.setString(6, dateUtil.getDate());
			ps.execute();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			con.close();
		}
	}
}
