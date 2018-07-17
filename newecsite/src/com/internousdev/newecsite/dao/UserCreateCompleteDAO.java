package com.internousdev.newecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.newecsite.util.DBConnector;
import com.internousdev.newecsite.util.DateUtil;

public class UserCreateCompleteDAO {

	private DBConnector dbConnector=new DBConnector();
	private Connection con=dbConnector.getConnection();
	private DateUtil dateUtil=new DateUtil();
	private String sql="INSERT INTO login_user_transaction (login_id, login_pass, user_name,"
			+ " insert_date) VALUES(?, ? ,?, ?)";

	public void createUser(String loginUserId,String loginUserPassword,String userName)throws SQLException{

		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, loginUserId);
			ps.setString(2, loginUserPassword);
			ps.setString(3, userName);
			ps.setString(4, dateUtil.getDate());
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
