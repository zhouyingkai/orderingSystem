package com.chujian.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chujian.dao.UserDao;
import com.chujian.daoImpl.UserDaoImpl;
import com.chujian.model.User;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phoneNumb=request.getParameter("phoneNumb");
		String password=request.getParameter("password");
//		String str=new String(phoneNumb.getBytes("iso-8859-1"),"UTF-8");//зЊТы
		User user;
		UserDao userdao=new UserDaoImpl();
		user=userdao.userLogin(phoneNumb, password);
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		out.println(user.getUserPhone()+";"+user.getUserPassword());
		System.out.println("phoneNumb="+user.getUserPhone()+"\npassword="+user.getUserPassword());
	}

}
