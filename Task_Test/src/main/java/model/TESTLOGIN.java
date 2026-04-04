package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TESTLOGIN {

	
	public static void main(String[] args) {

		String url= "jdbc:mysql://localhost:3306/task_app?useSSL=false&serverTimezone=Asia/Tokyo";
		String user = "root";
		String pass1 = "pass";
		String sql = "SELECT password From user WHERE name=?";
		String userId = "Taro";
		String inputPass= "1234";
		
		try {Class.forName("com.mysql.cj.jdbc.Driver");
		
		try (Connection conn = DriverManager.getConnection(url, user, pass1);
				PreparedStatement ps = conn.prepareStatement(sql)){
			
			ps.setString(1, userId);
			
			try(ResultSet rs = ps.executeQuery()){
				
				if(!rs.next()) {
					System.out.println("存在しない");
				}else {
					System.out.println("確認まではOK");
					String dbPass = rs. getString("password");
					System.out.println("DBpass:" + dbPass);
					
					if(dbPass.equals(inputPass)) {
						System.out.println("ログイン成功");
					}else {
						System.out.println("ログイン失敗");
					}
				}
			}
		}
	
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
