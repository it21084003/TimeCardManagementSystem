package models;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class usertimeDTO {

	private int id, user_id;
	private String user_name;
	private String date;
	private LocalTime start_time;
	private LocalTime end_time;
	private long working_timeH;
	private long working_timeS;
	private int totalHours = 0;

	
	
	public usertimeDTO() {

	}

	int getTotalHours() {
		return totalHours;
	}

	public long getWorking_timeH() {
		return working_timeH;
	}

	public void setWorking_timeH(long working_timeH) {
		this.working_timeH = working_timeH;
	}

	public long getWorking_timeS() {
		return working_timeS;
	}

	public void setWorking_timeS(long working_timeS) {
		this.working_timeS = working_timeS;
	}

	public void setTotalHours(int totalHours) {
		this.totalHours = totalHours;
	}

	public usertimeDTO(int id, int user_id, String date, LocalTime start_time, LocalTime end_time) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.date = date;
		this.start_time = start_time;
		this.end_time = end_time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public LocalTime getStart_time() {
		return start_time;
	}

	public void setStart_time(LocalTime start_time) {
		this.start_time = start_time;
	}

	public LocalTime getEnd_time() {
		return end_time;
	}

	public void setEnd_time(LocalTime end_time) {
		this.end_time = end_time;
	}

}
