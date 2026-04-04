package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Create;


/**
 * Servlet implementation class CreateUser
 */
@WebServlet("/create-servlet")
public class Create_user_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String mail = request.getParameter("mail");
		String url = "Create.jsp";
		
		int result = Create.createuser(userId, password, mail);
		
		
		if(result > 0) {
			session.setAttribute("userId", userId);
			session.setAttribute("mail", mail);
			
			url = "create-fin.jsp";
		}else {
			request.setAttribute("errorMsg", "登録に失敗しました");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
	
}
