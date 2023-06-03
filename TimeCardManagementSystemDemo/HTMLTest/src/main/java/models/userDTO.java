package models;

public class userDTO {
	private int user_id, department_id;
	private String user_name, user_tel, user_address, remark, hire_date, department_name;

	public userDTO() {
		
	}
	
	public userDTO(int user_id, int department_id, String user_name, String user_tel, String user_address,
			String remark, String hire_date, String department_name) {
		super();
		this.user_id = user_id;
		this.department_id = department_id;
		this.user_name = user_name;
		this.user_tel = user_tel;
		this.user_address = user_address;
		this.remark = remark;
		this.hire_date = hire_date;
		this.department_name = department_name;
	}

	public userDTO(int department_id, String user_name, String user_tel, String user_address, String remark,
			String hire_date) {
		super();
		this.department_id = department_id;
		this.user_name = user_name;
		this.user_tel = user_tel;
		this.user_address = user_address;
		this.remark = remark;
		this.hire_date = hire_date;
	}



	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_tel() {
		return user_tel;
	}

	public void setUser_tel(String user_tel) {
		this.user_tel = user_tel;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getHire_date() {
		return hire_date;
	}

	public void setHire_date(String hire_date) {
		this.hire_date = hire_date;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

}
