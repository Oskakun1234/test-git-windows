package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Create {

	public static int createuser(String userId, String password, String mail) {
			
			String url= "jdbc:mysql://localhost:3306/task_app?useSSL=false&serverTimezone=Asia/Tokyo";
			String user = "root";
			String pass1 = "pass";
			String sql1 = "SELECT name FROM user WHERE name = ?";
			String sql2 = "INSERT into user (name, email, password)  VALUES(?, ?, ?)";
	
		try {Class.forName("com.mysql.cj.jdbc.Driver");
			
			try (Connection conn = DriverManager.getConnection(url, user, pass1)) {
				
				//確認処理		
				try(PreparedStatement ps1 = conn.prepareStatement(sql1)){

					ps1.setString(1, userId);
					var rs = ps1.executeQuery();					
					if(rs.next() && rs.getInt(1)>0) {
						return 0;
						
					}else {
						
						//登録処理
						try(PreparedStatement ps2 = conn.prepareStatement(sql2)){

							ps2.setString(1, userId);
							ps2.setString(2, mail);
							ps2.setString(3, password);
							
							return ps2.executeUpdate();
						}
					}					
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		return 0;
	}
}




	
