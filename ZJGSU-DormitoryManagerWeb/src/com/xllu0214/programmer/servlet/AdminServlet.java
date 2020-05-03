package com.xllu0214.programmer.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.xllu0214.programmer.bean.Operator;
import com.xllu0214.programmer.bean.Page;
import com.xllu0214.programmer.bean.SearchProperty;
import com.xllu0214.programmer.dao.AdminDao;
import com.xllu0214.programmer.entity.Admin;
import com.xllu0214.programmer.util.StringUtil;

public class AdminServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3570588813092713936L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String method = req.getParameter("method");
		if("toAdminListView".equals(method)){
			req.getRequestDispatcher("view/adminList.jsp").forward(req, resp);
		}
		if("AddAdmin".equals(method)){
			addAdmin(req,resp);
		}
		if("AdminList".equals(method)){
			getAdminList(req,resp);
		}
		if("EditAdmin".equals(method)){
			editAdmin(req,resp);
		}
		if("DeleteAdmin".equals(method)){
			deleteAdmin(req,resp);
		}
	}

	/**
	 * �޸Ĺ���Ա��Ϣ
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	private void editAdmin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String status = req.getParameter("status");
		String id = req.getParameter("id");
		resp.setCharacterEncoding("utf-8");
		if(StringUtil.isEmpty(id)){
			resp.getWriter().write("��ѡ��Ҫ�޸ĵĹ���Ա!");
			return;
		}
		if(StringUtil.isEmpty(name)){
			resp.getWriter().write("��������Ϊ��!");
			return;
		}
		if(StringUtil.isEmpty(password)){
			resp.getWriter().write("���벻��Ϊ��!");
			return;
		}
		if(StringUtil.isEmpty(status)){
			resp.getWriter().write("�Ա���Ϊ��!");
			return;
		}
		Admin admin = new Admin();
		admin.setId(Integer.parseInt(id));
		admin.setName(name);
		admin.setPassword(password);
		admin.setStatus(Integer.parseInt(status));
		AdminDao adminDao = new AdminDao();
		String msg = "�޸�ʧ��!";
		if(adminDao.update(admin)){
			msg = "success";
		}
		adminDao.closeConnection();
		resp.getWriter().write(msg);
	}

	/**
	 * ��ӹ���Ա
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	private void addAdmin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String status = req.getParameter("status");
		resp.setCharacterEncoding("utf-8");
		if(StringUtil.isEmpty(name)){
			resp.getWriter().write("��������Ϊ��!");
			return;
		}
		if(StringUtil.isEmpty(password)){
			resp.getWriter().write("���벻��Ϊ��!");
			return;
		}
		if(StringUtil.isEmpty(status)){
			resp.getWriter().write("�Ա���Ϊ��!");
			return;
		}
		Admin admin = new Admin();
		admin.setName(name);
		admin.setPassword(password);
		admin.setStatus(Integer.parseInt(status));
		AdminDao adminDao = new AdminDao();
		String msg = "���ʧ��!";
		if(adminDao.add(admin)){
			msg = "success";
		}
		adminDao.closeConnection();
		resp.getWriter().write(msg);
	}

	/**
	 * ɾ������Ա
	 * @param req
	 * @param resp
	 */
	private void deleteAdmin(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		String[] ids = req.getParameterValues("ids[]");
		AdminDao adminDao = new AdminDao();
		String msg = "";
		if(adminDao.delete(ids)){
			msg = "success";
		}
		adminDao.closeConnection();
		try {
			resp.getWriter().write(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * ��ȡ����Ա�б�
	 * @param req
	 * @param resp
	 */
	private void getAdminList(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		int pageNumber = Integer.parseInt(req.getParameter("page"));
		int pageSize = Integer.parseInt(req.getParameter("rows"));
		String name = req.getParameter("name");
		if(StringUtil.isEmpty(name)){
			name = "";
		}
		Map<String, Object> ret = new HashMap<String, Object>();
		AdminDao adminDao = new AdminDao();
		Page<Admin> page = new Page<Admin>(pageNumber, pageSize);
		page.getSearchProperties().add(new SearchProperty("name", "%"+name+"%", Operator.LIKE));
		Page<Admin> findList = adminDao.findList(page);
		ret.put("rows", findList.getConten());
		ret.put("total", findList.getTotal());
		adminDao.closeConnection();
		resp.setCharacterEncoding("utf-8");
		try {
			resp.getWriter().write(JSONObject.fromObject(ret).toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
