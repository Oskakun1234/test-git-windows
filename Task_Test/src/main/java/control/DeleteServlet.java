package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Delete;



@WebServlet("/delete-servlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		int result = Delete.deleteId(userId, password);
		
		String url = "delete.jsp";			

		if(result > 0) {
			url = "login.jsp";
			request.setAttribute("del_Id", userId);
			request.setAttribute("deleteMsg", "正常に削除が実行されました");
		}else {
			request.setAttribute("errorMsg", "ユーザーIDを削除出来ませんでした");
		}
		
	
	RequestDispatcher rd = request.getRequestDispatcher(url);
	rd.forward(request, response);
		
	}

}
