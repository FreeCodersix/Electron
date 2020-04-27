package com.ischoolbar.programmer.model;
/**
 * 请假表实体类
 * @author llq
 *
 */
public class Leave {
	
	public static int LEAVE_STATUS_WAIT = 0;
	public static int LEAVE_STATUS_AGREE = 1;
	public static int LEAVE_STATUS_DISAGREE = -1;
	private int id;
	private int studentId;
	private String info;
	private int status = LEAVE_STATUS_WAIT;
	private String remark;
	private String sn;
	private String className;
	private int classId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}


	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}
}
