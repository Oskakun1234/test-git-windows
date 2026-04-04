package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Delete {

	public static int deleteId(String userId, String password) {
		
		String url= "jdbc:mysql://localhost:3306/task_app?useSSL=false&serverTimezone=Asia/Tokyo";
		String user = "root";
		String pass1 = "pass";
		String sql = "DELETE FROM user WHERE name = ? AND password = ?";

	try {Class.forName("com.mysql.cj.jdbc.Driver");
		
		try (Connection conn = DriverManager.getConnection(url, user, pass1)) {
			
			//確認処理		
			try(PreparedStatement ps = conn.prepareStatement(sql)){
	
					//削除処理
						ps.setString(1, userId);
						ps.setString(2, password);
						
						return ps.executeUpdate();
					}
				}					
	}catch (Exception e) {
		e.printStackTrace();
		
	}
	return 0;
}
}

