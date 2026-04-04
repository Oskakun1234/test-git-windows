package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login {
	
	public static boolean loginProc(String userId, String password) {
		
		String url= "jdbc:mysql://localhost:3306/task_app?useSSL=false&serverTimezone=Asia/Tokyo";
		String user = "root";
		String pass1 = "pass";
		String sql = "SELECT password From user WHERE name=?";
		
		
	try {Class.forName("com.mysql.cj.jdbc.Driver");
		
		try (Connection conn = DriverManager.getConnection(url, user, pass1);
				PreparedStatement ps = conn.prepareStatement(sql)){
			
			ps.setString(1, userId);
			
			try(ResultSet rs = ps.executeQuery()){
				
				if(!rs.next()) {
					System.out.println("存在しない");
					return false;
				}else {
					System.out.println("確認まではOK");
					String dbPass = rs. getString("password");
					return dbPass.equals(password);
				}
			}
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static int getId(String name, String password) {
		String url= "jdbc:mysql://localhost:3306/task_app?useSSL=false&serverTimezone=Asia/Tokyo";
		String user = "root";
		String pass1 = "pass";
		String sql = "SELECT id From user WHERE name=? AND password = ?";
		
		
	try {Class.forName("com.mysql.cj.jdbc.Driver");
		
		try (Connection conn = DriverManager.getConnection(url, user, pass1);
				PreparedStatement ps = conn.prepareStatement(sql)){
			
			ps.setString(1, name);
			ps.setString(2,  password);
			
			try(ResultSet rs = ps.executeQuery()){
				if(rs.next()) {
                    return rs.getInt("id");
				}
			}
		}
		}catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}
}
	



	