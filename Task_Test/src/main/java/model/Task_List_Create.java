package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Task_List_Create {
	
	String url= "jdbc:mysql://localhost:3306/task_app?useSSL=false&serverTimezone=Asia/Tokyo";
	String user = "root";
	String pass1 = "pass";
	
	public  List<Task> getTask(int id) {

		String sql = "SELECT id, title FROM tasks WHERE user_id = ?";
		List<Task> taskList = new ArrayList<>();

	try {Class.forName("com.mysql.cj.jdbc.Driver");
		
		try (Connection conn = DriverManager.getConnection(url, user, pass1)) {
			
			//確認処理		
			try(PreparedStatement ps = conn.prepareStatement(sql)){

				ps.setInt(1, id);
				
				ResultSet rs = ps.executeQuery();

				while(rs.next()) {
					Task task = new Task();
					task.setId(rs.getInt("id"));
					task.setTitle(rs.getString("title"));
					taskList.add(task);
					}
				}
			}					
		}catch (Exception e) {
		e.printStackTrace();
	}
	return taskList;
}

	public int createTask(int id, String task) {

		String sql = "INSERT into tasks (user_id, title) VALUES(?, ?)";

	try {Class.forName("com.mysql.cj.jdbc.Driver");
		
		try (Connection conn = DriverManager.getConnection(url, user, pass1)) {
			
			//確認処理		
			try(PreparedStatement ps = conn.prepareStatement(sql)){

				ps.setInt(1, id);
				ps.setString(2, task);
				int result= ps.executeUpdate();
				return result;
			}
			}
		}catch (Exception e) {
			e.printStackTrace();
		return 0 ;
		}
	}

	public int delete(int taskId) {

		String sql = "DELETE FROM tasks WHERE id = ?";

	try {Class.forName("com.mysql.cj.jdbc.Driver");
		
		try (Connection conn = DriverManager.getConnection(url, user, pass1)) {
			
			//確認処理		
			try(PreparedStatement ps = conn.prepareStatement(sql)){

				ps.setInt(1, taskId);
				int result= ps.executeUpdate();
				return result ;
			}
			}
		}catch (Exception e) {
			e.printStackTrace();
		return 0 ;
		}
		
	}

	public Task findById(int taskId) {
		
		String sql = "SELECT * FROM tasks WHERE id = ?";

		try(Connection conn = DriverManager.getConnection(url, user, pass1);
				PreparedStatement ps = conn.prepareStatement(sql)){
			
			ps.setInt(1, taskId);
			ResultSet rs = ps.executeQuery();
		
			if(rs.next()) {
				Task task = new Task();
				task.setId(rs.getInt("id"));
				task.setTitle(rs.getString("title"));
				return task;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}			
		return null;
	}

	public void update(Task task) {
		
		String sql = "UPDATE tasks SET title = ? WHERE id = ?";
		
		try(Connection conn = DriverManager.getConnection(url, user, pass1);
			PreparedStatement ps = conn.prepareStatement(sql)){

			ps.setString(1, task.getTitle());
			ps.setInt(2, task.getId());
	
			ps.executeUpdate();	
			
			} catch (Exception e) {
		        e.printStackTrace();
		    }
		}

}
