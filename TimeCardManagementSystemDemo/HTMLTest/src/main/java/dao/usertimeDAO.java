package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import models.usertimeDTO;

public class usertimeDAO {

	public static List<usertimeDTO> getTimeByUserId(Connection con, int id) throws SQLException {
		List<usertimeDTO> timeList = new ArrayList<>();

		String sql = "SELECT * FROM shop_user_time WHERE user_id=?";

		// statmentの生成
		PreparedStatement pStmt = con.prepareStatement(sql);

		// SQLの実行
		pStmt.setInt(1, id);
		ResultSet rs = pStmt.executeQuery();

		while (rs.next()) {

			usertimeDTO e = new usertimeDTO();


			Time startTimeFromDb = rs.getTime("start_time");
			Time endTimeFromDb = rs.getTime("end_time");
			
			LocalTime startTime = startTimeFromDb.toLocalTime();
			LocalTime endTime = endTimeFromDb.toLocalTime();

			Duration workingTime = Duration.between(startTime, endTime);
			
			long hours = workingTime.toHours();
			long minutes = workingTime.toMinutes() % 60;
			
			
			e.setUser_id(rs.getInt("id"));
			e.setDate(rs.getString("date"));
			e.setStart_time(startTime);
			e.setEnd_time(endTime);
			e.getUser_name();
			e.setWorking_timeH(hours);
			e.setWorking_timeS(minutes);
			
			int totalHours = retrieveMonthlyWorkingTimes(con,rs.getInt("id"),5);
			e.setTotalHours(totalHours);

			timeList.add(e);

		}
		pStmt.close();
		return timeList;

	}

	public static int retrieveMonthlyWorkingTimes(Connection con, int userId, int month) throws SQLException {
		String sql = "SELECT date,SUM(TIMESTAMPDIFF(minute, start_time, end_time)) AS total_minutes"
				+ " FROM shop_user_time WHERE user_id = ? AND MONTH(date) = ? GROUP BY date";

		try (PreparedStatement pStmt = con.prepareStatement(sql)) {
			pStmt.setInt(1, userId);
			pStmt.setInt(2, month);

			ResultSet rs = pStmt.executeQuery();

			int totalMinutes = 0;

			while (rs.next()) {

				Date date = rs.getDate("date");
				int totalMinute = rs.getInt("total_minutes");

				totalMinutes += rs.getInt("total_minutes");

			}
			int totalHours = totalMinutes / 60;
			int remainingMinutes = totalMinutes % 60;

			
			return totalHours;
		}
		
	}


	public List<usertimeDTO> allSearch(Connection con) throws SQLException {
		List<usertimeDTO> users = new ArrayList<>();

		// SQL文を作成
		String sql = "SELECT * FROM shop_user_time AS sut INNER JOIN shop_user AS su " + "ON sut.user_id = su.user_id";

		// statmentの生成
		PreparedStatement pStmt = con.prepareStatement(sql);

		// SQLの実行
		ResultSet rs = pStmt.executeQuery();

		// 解析
		while (rs.next()) {
			// 1レコード分をまとめる
			usertimeDTO e = new usertimeDTO();
			// ★DTOにセット★（コメント解除）
			LocalTime startTime = rs.getTime("start_time").toLocalTime();
			LocalTime endTime = rs.getTime("end_time").toLocalTime();

			e.setId(rs.getInt("id"));
			e.setUser_id(rs.getInt("user_id"));
			e.setDate(rs.getString("date"));
			e.setStart_time(startTime);
			e.setEnd_time(endTime);

			users.add(e);

		}
		pStmt.close();
		return users;
	}

//	public boolean insertRecord(Connection con,int uid, String d, String s, String en)
//			throws SQLException {
//		String sql = "INSERT INTO "
//				+ "shop_user_time(user_id,day,start_time,end_time) "
//				+ "VALUES (?,?,?,?)";
//
//		try {
//			PreparedStatement pStmt = con.prepareStatement(sql);
//			pStmt.setInt(1, uid);
//			pStmt.setString(2, d);
//			pStmt.setString(3, s);
//			pStmt.setString(4, en);
//
//			int inserted = pStmt.executeUpdate();
//			return inserted > 0;
//		}catch (SQLException e) {
//			// TODO 自動生成された catch ブロック
//			//e.printStackTrace();
//	}
//	return false;
//	
//	}

//	public static void retrieveMonthlyWorkingTimes(Connection con, int userId, int month) throws SQLException {
//		String sql = "SELECT date,SUM(TIMESTAMPDIFF(minute, start_time, end_time)) AS total_minutes"
//				+ " FROM shop_user_time WHERE user_id = ? AND MONTH(date) = ? GROUP BY date";
//
//		try (PreparedStatement pStmt = con.prepareStatement(sql)) {
//			pStmt.setInt(1, userId);
//			pStmt.setInt(2, month);
//
//			ResultSet rs = pStmt.executeQuery();
//
//			int totalMinutes = 0;
//
//			while (rs.next()) {
//
//				Date date = rs.getDate("date");
//				int totalMinute = rs.getInt("total_minutes");
//
//				totalMinutes += rs.getInt("total_minutes");
//
//			}
//			int totalHours = totalMinutes / 60;
//			int remainingMinutes = totalMinutes % 60;
//
//			System.out.println(
//					"Totalworking hours for the month: " + totalHours + "hours and " + remainingMinutes + " minutes");
//
//		}
//	}

	//	
//	public static void rMWT(Connection con, int userId, int month) {
//		int totalMinutes = 0;
//		
//		ResultSet rs = pStmt.executeQuery();
//		
//		while(rs.next()) {
//			
//		}
//	}
//	

}
