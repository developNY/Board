package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Command.Command;
import Command.ContentCommand;
import Command.DeleteCommand;
import Command.ListCommand;
import Command.ModifyCommand;
import Command.WriteCommand;

/**
 * Servlet implementation class Controller
 */
@WebServlet("*.do")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		actionDo(request, response);
	}
	
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("actionDo");
		
		request.setCharacterEncoding("EUC-KR");
		
		String viewPage = null;
		Command command = null;
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
	
		if(com.equals("/write_view.do")){
			viewPage = "write_view.jsp";
		}else if(com.equals("/write.do")){
			command = new WriteCommand();
			command.execute(request, response);
			viewPage = "list.do";
		}else if(com.equals("/modify.do")){
			command = new ModifyCommand();
			command.execute(request, response);
			viewPage = "list.do";
		}else if(com.equals("/content_view.do")){
			command = new ContentCommand();
			command.execute(request, response);
			viewPage = "content_view.jsp";
		}else if(com.equals("/list.do")){
			command = new ListCommand();
			command.execute(request, response);
			viewPage = "list.jsp";
		}else if(com.equals("/delete.do")){
			command = new DeleteCommand();
			command.execute(request, response);
			viewPage = "list.do";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
