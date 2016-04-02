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

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String phoneNumb = request.getParameter("phoneNumb");
		String password = request.getParameter("password");

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		UserDao userDao = new UserDaoImpl();
		// 检查账号是否已经被注册
		boolean alreadyExist = userDao.userCheck(phoneNumb);
		// 进行注册
		if (alreadyExist) {
			// 已经注册过
			out.println("alreadyRegistered");
		} else {
			// 未被注册

			boolean flag = userDao.userRegister(phoneNumb, password);
			// 结果写回
			if (flag) {
				out.println("success");
			} else {
				out.println("failed");
			}
		}
	}

}
