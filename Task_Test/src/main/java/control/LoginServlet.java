package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Login;
import model.Task_List_Create;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login-servlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Task_List_Create dao = new Task_List_Create();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		boolean result = Login.loginProc(userId, password);

		String url = "login.jsp";

		if(!result) {
			request.setAttribute("errorMsg", "ユーザIDまたはパスワードが間違っています。");		
			request.setAttribute("userId" , userId);
			request.setAttribute("password" , password);
		}else {
			url = "first.jsp";
			//IDとユーザ名の取得
			int Id = Login.getId(userId, password);
			session.setAttribute("userId" , userId);
			session.setAttribute("Id" ,Id );

			//タスクの格納
			var taskList = dao.getTask(Id);
			request.setAttribute("taskList", taskList);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
		
	}

}
