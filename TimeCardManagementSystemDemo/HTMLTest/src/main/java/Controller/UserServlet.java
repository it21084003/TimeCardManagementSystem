package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.userDAO;
import dao.usertimeDAO;
import helper.DBHelper;
import models.userDTO;
import models.usertimeDTO;

@WebServlet("/")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private userDAO userdao;
	private usertimeDAO usertimedao;
	private Connection con;
	private String searchName;

//	public UserServlet() {
//		super();
//	}
	
	public void init() {
		userdao = new userDAO();
		usertimedao = new usertimeDAO();
		con = DBHelper.getInstance().getConn();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action = request.getServletPath();
	
		try {
			switch(action) {
			case "/insert":
				insertUser(request, response);
				break;
			case "/delete":
				deleteUser(request, response);
				break;
			case "/edit":
				editUser(request, response);
				break;
			case "/search":
				searchByName(request, response);
				break;
			case "/details":
				detailsTimeCard(request, response);
				break;
			default:
				main(request, response);
				break;
			}
		}catch (ServletException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	
	}

	
	
	private void main(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException, SQLException {
		
		List<userDTO> userList = userdao.allSearch(con) ;
		request.setAttribute("useList", userList);
	
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void searchByName(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
			
			List<userDTO> userList = userdao.allSearch(con) ;
			request.setAttribute("useList", userList);
			
			searchName = request.getParameter("inputname");
			List<userDTO> userListSearchById = userdao.searchByName(con,searchName) ;
			request.setAttribute("userListSearchById", userListSearchById);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
			dispatcher.forward(request, response);
			
		}
	
	
	
	
	private void insertUser(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, SQLException {
		String name = request.getParameter("name");
		int position = Integer.parseInt(request.getParameter("pid"));
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String remark = request.getParameter("remark");
		String hire_date = request.getParameter("hiredate");
		
		userDTO addUser = new userDTO(position,name,phone,address,remark,hire_date);
		boolean ok = userdao.insertRecord(con, addUser);
		response.sendRedirect("main");
	}
	
	private void editUser(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, SQLException {
		String name = request.getParameter("name");
		int position = Integer.parseInt(request.getParameter("pid"));
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String remark = request.getParameter("remark");
		String hire_date = request.getParameter("hiredate");
		
		userDTO addUser = new userDTO(position,name,phone,address,remark,hire_date);
		boolean ok = userdao.insertRecord(con, addUser);
		
		response.sendRedirect("main");
	}
	
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, SQLException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		userdao.deleteById(con, id);
		response.sendRedirect("main");
		
	}
	
	private void detailsTimeCard(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, SQLException {
		
		int userId = Integer.parseInt(request.getParameter("id"));
		System.out.println(userId);
		List<usertimeDTO> timeList = usertimedao.getTimeByUserId(con, userId);
		
		for(usertimeDTO ul : timeList) {
			System.out.println(ul.getId());
			System.out.println(ul.getDate());
		}
		request.setAttribute("timeList", timeList);
		request.getRequestDispatcher("details.jsp").forward(request, response);
		
	}
		
		
	
	
}
