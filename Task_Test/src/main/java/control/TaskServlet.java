package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Task;
import model.Task_List_Create;

/**
 * Servlet implementation class TaskServlet
 */
@WebServlet("/task-servlet")

public class TaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Task_List_Create dao = new Task_List_Create();


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		Integer Id = (Integer)session.getAttribute("Id");
        String action = request.getParameter("action");

        int taskId = 0;
        
		//Idが無ければログイン画面へ
        if(Id == null || Id < 1){
        	response.sendRedirect("login.jsp");
        	return;
        }

	        if("削除".equals(action)) {
	        	taskId = Integer.parseInt(request.getParameter("taskId"));
	        	//タスク削除
	        	dao.delete(taskId);
	        }else if("追加".equals(action)) {
	        	String taskadd = request.getParameter("taskadd");
	        	//タスク追加
				dao.createTask(Id, taskadd);
			}else if ("更新".equals(action)) {
				taskId = Integer.parseInt(request.getParameter("taskId"));
				String title = request.getParameter("title");
				
				Task task = new Task();
				task.setId(taskId);
 				task.setTitle(title);
 				
 				dao.update(task);
			}

	        response.sendRedirect("task-servlet");
	}


protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
	
	HttpSession session = request.getSession();
	request.setCharacterEncoding("UTF-8");
	
	Integer Id = (Integer)session.getAttribute("Id");
	
	if(Id == null || Id < 1) {
		response.sendRedirect("login.jsp");
		return;
	}
	
	String action = request.getParameter("action");
	
	if("編集".equals(action)) {
    	String taskId = request.getParameter("taskId");
    	
    	Task task = dao.findById(Integer.parseInt(taskId));
    	request.setAttribute("task", task);
    	
    	request.getRequestDispatcher("edit.jsp").forward(request,response);
    	return;
	}
	
	var taskList = dao.getTask(Id);
	request.setAttribute("taskList",  taskList);
	
	 request.getRequestDispatcher("first.jsp").forward(request, response);
	}
}
