package com.xllu0214.programmer.dao;

//import org.apache.commons.lang.StringUtils;

//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;

//import com.xllu0214.programmer.bean.Page;
import com.xllu0214.programmer.entity.Student;
//import com.xllu0214.programmer.util.StringUtil;

/**
 * 学生实体数据库操作
 * @author XLLU
 *
 */

public class StudentDao extends BaseDao<Student> {
	//简单添加操作
//	public boolean add(Student student){
//		String sql = "insert into student(id,sn,name,password,sex) values(null,?,?,?,?)";
//		try {
//			PreparedStatement prepareStatement = con.prepareStatement(sql);
//			prepareStatement.setString(1, student.getSn());
//			prepareStatement.setString(2, student.getName());
//			prepareStatement.setString(3, student.getPassword());
//			prepareStatement.setString(4, student.getSex());
//			prepareStatement.executeUpdate();
//			return prepareStatement.executeUpdate() > 0;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return false;
//	}
	
	//简单查询操作
//	public List<Student> findList(Student student,Page page){
//		List<Student> ret = new ArrayList<Student>();
//		String sql = "select * from student ";
//		if(!StringUtil.isEmpty(student.getName())){
//			sql += "where name like '%" + student.getName() + "%' ";
//		}
//		sql += "limit " + page.getOffset() + "," + page.getPageSize();
//		try {
//			PreparedStatement prepareStatement = con.prepareStatement(sql);
//			ResultSet executeQuery = prepareStatement.executeQuery();
//			while (executeQuery.next()) {
//				Student s = new Student();
//				s.setId(executeQuery.getInt("id"));
//				s.setName(executeQuery.getString("name"));
//				s.setPassword(executeQuery.getString("password"));
//				s.setSex(executeQuery.getString("sex"));
//				s.setSn(executeQuery.getString("sn"));
//				ret.add(s);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return ret;
//	}
//	
//	public int getTotal(Student student){
//		String sql = "select count(id) as total from student ";
//		if(!StringUtil.isEmpty(student.getName())){
//			sql += "where name like '%" + student.getName() + "%' ";
//		}
//		try {
//			PreparedStatement prepareStatement = con.prepareStatement(sql);
//			ResultSet executeQuery = prepareStatement.executeQuery();
//			if(executeQuery.next()) {
//				return executeQuery.getInt("total");
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return 0;
//	}
	
	//简单修改操作
//	public boolean update(Student student){
//		String sql = "update student set name = '" + student.getName() + "',";
//		sql += " sn = '" + student.getSn() + "',";
//		sql += " password = '" + student.getPassword() + "',";
//		sql += " sex = '" + student.getSex() + "' where id = " + student.getId();
//		try {
//			PreparedStatement prepareStatement = con.prepareStatement(sql);
//			return prepareStatement.executeUpdate() > 0;//> 0表示运行成功
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return false;
//	}
	
	//简单删除操作
//	public boolean delete(String[] ids){
//		String sql = "delete from student where id in(" + StringUtils.join(ids, ",") + ")";
//		try {
//			PreparedStatement prepareStatement = con.prepareStatement(sql);
//			return prepareStatement.executeUpdate() > 0;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return false;
//	}
}
