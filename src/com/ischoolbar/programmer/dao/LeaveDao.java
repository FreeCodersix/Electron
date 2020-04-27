package com.ischoolbar.programmer.dao;

import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ischoolbar.programmer.model.Course;
import com.ischoolbar.programmer.model.Leave;
import com.ischoolbar.programmer.model.Page;
import com.ischoolbar.programmer.util.StringUtil;

/**
 * 请假表数据库操作
 * @author llq
 *
 */
public class LeaveDao extends BaseDao {
	/**
	 * 添加请假信息
	 * @param leave
	 * @return
	 */
	public boolean addLeave(Leave leave){
		String sql = "insert into s_leave values(null,"+leave.getStudentId()+",'"+leave.getInfo()+"',"+Leave.LEAVE_STATUS_WAIT+",'"+leave.getRemark()+"')";
		return update(sql);
	}

	/**
	 * 编辑请假单
	 * @param leave
	 * @return
	 */
	public boolean editLeave(Leave leave){
		String sql = "update s_leave set student_id = "+leave.getStudentId()+", info = '"+leave.getInfo()+"',status = "+leave.getStatus()+",remark = '"+leave.getRemark()+"' where id = " + leave.getId();
		return update(sql);
	}

	/**
	 * 删除请假信息
	 * @param id
	 * @return
	 */
	public boolean deleteLeave(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from s_leave where id = " + id ;
		return update(sql);
	}

	/**
	 * 获取分页请假单信息列表
	 * @param leave
	 * @param page
	 * @return
	 */
	public List<Leave> getLeaveList(Leave leave,Page page){
		List<Leave> ret = new ArrayList<Leave>();

		String sql = "SELECT sl.*,ss.sn,ss.clazz_id classId,sc.`name` className FROM s_leave sl LEFT JOIN s_student ss ON sl.student_id=ss.id LEFT JOIN s_clazz sc ON ss.clazz_id = sc.id where 1=1 ";
		if(leave.getStudentId() != 0){
			sql += "and sl.student_id = " + leave.getStudentId() + "";
		}
		if(leave.getClassId() != 0){
			sql += "and ss.clazz_id = " + leave.getClassId() + "";

		}
		sql += " limit " + page.getStart() + "," + page.getPageSize();
		ResultSet resultSet = query(sql);

		try {
			while(resultSet.next()){
				Leave l = new Leave();
				l.setId(resultSet.getInt("id"));
				l.setStudentId(resultSet.getInt("student_id"));
				l.setInfo(resultSet.getString("info"));
				l.setStatus(resultSet.getInt("status"));
				l.setRemark(resultSet.getString("remark"));
				l.setSn(resultSet.getString("sn"));
				l.setClassName(resultSet.getString("className"));

				ret.add(l);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}

	/**
	 * 获取总记录数
	 * @param leave
	 * @return
	 */
	public int getLeaveListTotal(Leave leave){
		int total = 0;
		String sql = "SELECT COUNT(*) as total FROM s_leave sl LEFT JOIN s_student ss ON sl.student_id=ss.id LEFT JOIN s_clazz sc ON ss.clazz_id = sc.id where 1=1 ";
		if(leave.getStudentId() != 0){
			sql += "and sl.student_id = " + leave.getStudentId() + "";
		}
		if(leave.getClassId() != 0){
			sql += "and ss.clazz_id = " + leave.getClassId() + "";
		}
		ResultSet resultSet = query(sql);
		try {
			while(resultSet.next()){
				total = resultSet.getInt("total");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return total;
	}
}
