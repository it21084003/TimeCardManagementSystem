package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.userDTO;

public class userDAO {
	
	private static final String SELECT_ALL = "SELECT * FROM shop_user AS us INNER JOIN shop_department AS dep ON "
			+ "us.department_id = dep.department_id ";
	private static final String SELECT_BY_NAME = "SELECT * FROM shop_user AS us INNER JOIN shop_department AS dep ON "
			+ "us.department_id = dep.department_id "
			+ "WHERE user_name = ? ";
	private static final String SELECT_USER_BY_ID = "SELECT user_name,user_tel,department_id,user_address,remark,hire_date FROM shop_user WHERE id = ? ";
	private static final String DELETE_BY_ID =  "DELETE FROM shop_user WHERE user_id = ?";
	private static final String INSERT_USER =  "INSERT INTO "
			+ "shop_user(user_name,user_tel,department_id,user_address,remark,hire_date) "
			+ "VALUES (?,?,?,?,?,?);";
	
	
	
	public List<userDTO> allSearch(Connection con) throws SQLException {
		List<userDTO> users = new ArrayList<>();

		
		//statmentの生成
		PreparedStatement pStmt = con.prepareStatement(SELECT_ALL);

		//SQLの実行
		ResultSet rs = pStmt.executeQuery();

		//解析
		while (rs.next()) {
			//1レコード分をまとめる
			userDTO e = new userDTO();
			//★DTOにセット★（コメント解除）
			
			e.setUser_id(rs.getInt("user_id"));
			e.setUser_name(rs.getString("user_name"));
			e.setUser_tel(rs.getString("user_tel"));
			e.setUser_address(rs.getString("user_address"));
			e.setRemark(rs.getString("remark"));
			e.setHire_date(rs.getString("hire_date"));
			e.setDepartment_name(rs.getString("department_name"));
			
			users.add(e);

		}
		pStmt.close();
		return users;
	}
	
	public boolean insertRecord(Connection con, userDTO user)
			throws SQLException {
		
		try {
			PreparedStatement pStmt = con.prepareStatement(INSERT_USER);
			
			pStmt.setString(1, user.getUser_name());
			pStmt.setString(2, user.getUser_tel());
			pStmt.setInt(3, user.getDepartment_id());
			pStmt.setString(4, user.getUser_address());
			pStmt.setString(5, user.getRemark());
			pStmt.setString(6, user.getHire_date());

			int inserted = pStmt.executeUpdate();
			return inserted > 0;
		}catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
	}
	return false;
		
	}
	

	public boolean deleteById(Connection con, int id) throws SQLException {
		
		try {

			PreparedStatement pStmt = con.prepareStatement(DELETE_BY_ID);
			pStmt.setInt(1, id);

			int deleted = pStmt.executeUpdate();
			
			return deleted > 0;
		}catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				//e.printStackTrace();
		}
		return false;
	}
	
	public List<userDTO> selectUser(Connection con, int id) {
		List<userDTO> user = new ArrayList<>();
		//userDTO user = null;
		
		try {
			PreparedStatement pStmt = con.prepareStatement(SELECT_USER_BY_ID);
			pStmt.setInt(1, id);
			ResultSet rs = pStmt.executeQuery();
			
			while (rs.next()) {
//				//★DTOにセット★（コメント解除）
//				int userId = rs.getInt("user_id");
//				String name = rs.getString("user_name");
//				String tel = rs.getString("user_tel");
//				String add = rs.getString("user_address");
//				String remark = rs.getString("remark");
//				String hiredate = rs.getString("hire_date");
//				int dpId  = rs.getInt("department_id");
//				String dpName = rs.getString("department_name");
//				user = new userDTO(userId,dpId,name,tel,add,remark,hiredate,dpName);
				userDTO e = new userDTO();
				//★DTOにセット★（コメント解除）
				
				e.setUser_id(rs.getInt("user_id"));
				e.setUser_name(rs.getString("user_name"));
				e.setUser_tel(rs.getString("user_tel"));
				e.setUser_address(rs.getString("user_address"));
				e.setRemark(rs.getString("remark"));
				e.setHire_date(rs.getString("hire_date"));
				e.setDepartment_name(rs.getString("department_name"));
				
				user.add(e);
			}
		}catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			//e.printStackTrace();
	}
	return user;
	}
	
	public List<userDTO> searchByName(Connection con, String name) throws SQLException{
		List<userDTO> searchedList = new ArrayList<>();
		
		String sql = "SELECT * FROM shop_user AS us INNER JOIN shop_department AS dep ON "
				+ "us.department_id = dep.department_id "
				+ "WHERE user_name = ? ";
		
		PreparedStatement pStmt = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE, 
                ResultSet.CONCUR_UPDATABLE);
		pStmt.setString(1, name);
		ResultSet rs = pStmt.executeQuery();
		
		if(name.isEmpty()) {
			while (rs.next()) {
				String name1 = rs.getString("nm_employee");
				System.out.println( name1 );
			}
		}else {
			if(rs.next()) {
				rs.beforeFirst();
				while (rs.next()) {
					userDTO e = new userDTO();
					//★DTOにセット★（コメント解除）
					e.setUser_id(rs.getInt("user_id"));
					e.setUser_name(rs.getString("user_name"));
					e.setUser_tel(rs.getString("user_tel"));
					e.setUser_address(rs.getString("user_address"));
					e.setRemark(rs.getString("remark"));
					e.setHire_date(rs.getString("hire_date"));
					e.setDepartment_name(rs.getString("department_name"));
					searchedList.add(e);
				}
			}else {
				System.out.println("データはありませんでした。");
			}
		}
		
		return searchedList;
		
		
	}
	
}
