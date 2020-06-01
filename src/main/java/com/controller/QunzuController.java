package com.controller;

import java.io.File;
import java.io.IOException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.entity.Qunzu;
import com.server.QunzuServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class QunzuController {
	@Resource
	private QunzuServer qunzuService;


   
	@RequestMapping("addQunzu.do")
	public String addQunzu(HttpServletRequest request,Qunzu qunzu,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		qunzu.setAddtime(time.toString().substring(0, 19));
		qunzuService.add(qunzu);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "qunzuList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:qunzuList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateQunzu.do")
	public String doUpdateQunzu(int id,ModelMap map,Qunzu qunzu){
		qunzu=qunzuService.getById(id);
		map.put("qunzu", qunzu);
		return "qunzu_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("qunzuDetail.do")
	public String qunzuDetail(int id,ModelMap map,Qunzu qunzu){
		qunzu=qunzuService.getById(id);
		map.put("qunzu", qunzu);
		return "qunzu_detail";
	}
//	前台详细
	@RequestMapping("qzDetail.do")
	public String qzDetail(int id,ModelMap map,Qunzu qunzu){
		qunzu=qunzuService.getById(id);
		map.put("qunzu", qunzu);
		return "qunzudetail";
	}
//	
	@RequestMapping("updateQunzu.do")
	public String updateQunzu(int id,ModelMap map,Qunzu qunzu,HttpServletRequest request,HttpSession session){
		qunzuService.update(qunzu);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:qunzuList.do";
	}

//	分页查询
	@RequestMapping("qunzuList.do")
	public String qunzuList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Qunzu qunzu, String bianhao, String chuangshiren, String mingcheng, String leixing, String fengmian, String chuangjianriqi1,String chuangjianriqi2, String renshu, String jianjie, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
		if(chuangshiren==null||chuangshiren.equals("")){pmap.put("chuangshiren", null);}else{pmap.put("chuangshiren", chuangshiren);}
		if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
		if(leixing==null||leixing.equals("")){pmap.put("leixing", null);}else{pmap.put("leixing", leixing);}
		if(fengmian==null||fengmian.equals("")){pmap.put("fengmian", null);}else{pmap.put("fengmian", fengmian);}
		if(chuangjianriqi1==null||chuangjianriqi1.equals("")){pmap.put("chuangjianriqi1", null);}else{pmap.put("chuangjianriqi1", chuangjianriqi1);}
		if(chuangjianriqi2==null||chuangjianriqi2.equals("")){pmap.put("chuangjianriqi2", null);}else{pmap.put("chuangjianriqi2", chuangjianriqi2);}
		if(renshu==null||renshu.equals("")){pmap.put("renshu", null);}else{pmap.put("renshu", renshu);}
		if(jianjie==null||jianjie.equals("")){pmap.put("jianjie", null);}else{pmap.put("jianjie", jianjie);}
		
		int total=qunzuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Qunzu> list=qunzuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "qunzu_list";
	}
	
	@RequestMapping("qunzu_yanben1.do")
	public String qunzu_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Qunzu qunzu, String bianhao, String chuangshiren, String mingcheng, String leixing, String fengmian, String chuangjianriqi1,String chuangjianriqi2, String renshu, String jianjie, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
		if(chuangshiren==null||chuangshiren.equals("")){pmap.put("chuangshiren", null);}else{pmap.put("chuangshiren", chuangshiren);}
		if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
		if(leixing==null||leixing.equals("")){pmap.put("leixing", null);}else{pmap.put("leixing", leixing);}
		if(fengmian==null||fengmian.equals("")){pmap.put("fengmian", null);}else{pmap.put("fengmian", fengmian);}
		if(chuangjianriqi1==null||chuangjianriqi1.equals("")){pmap.put("chuangjianriqi1", null);}else{pmap.put("chuangjianriqi1", chuangjianriqi1);}
		if(chuangjianriqi2==null||chuangjianriqi2.equals("")){pmap.put("chuangjianriqi2", null);}else{pmap.put("chuangjianriqi2", chuangjianriqi2);}
		if(renshu==null||renshu.equals("")){pmap.put("renshu", null);}else{pmap.put("renshu", renshu);}
		if(jianjie==null||jianjie.equals("")){pmap.put("jianjie", null);}else{pmap.put("jianjie", jianjie);}
		
		int total=qunzuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Qunzu> list=qunzuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "qunzu_yanben1";
	}
	@RequestMapping("qunzu_yanben2.do")
	public String qunzu_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Qunzu qunzu, String bianhao, String chuangshiren, String mingcheng, String leixing, String fengmian, String chuangjianriqi1,String chuangjianriqi2, String renshu, String jianjie, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
		if(chuangshiren==null||chuangshiren.equals("")){pmap.put("chuangshiren", null);}else{pmap.put("chuangshiren", chuangshiren);}
		if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
		if(leixing==null||leixing.equals("")){pmap.put("leixing", null);}else{pmap.put("leixing", leixing);}
		if(fengmian==null||fengmian.equals("")){pmap.put("fengmian", null);}else{pmap.put("fengmian", fengmian);}
		if(chuangjianriqi1==null||chuangjianriqi1.equals("")){pmap.put("chuangjianriqi1", null);}else{pmap.put("chuangjianriqi1", chuangjianriqi1);}
		if(chuangjianriqi2==null||chuangjianriqi2.equals("")){pmap.put("chuangjianriqi2", null);}else{pmap.put("chuangjianriqi2", chuangjianriqi2);}
		if(renshu==null||renshu.equals("")){pmap.put("renshu", null);}else{pmap.put("renshu", renshu);}
		if(jianjie==null||jianjie.equals("")){pmap.put("jianjie", null);}else{pmap.put("jianjie", jianjie);}
		
		int total=qunzuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Qunzu> list=qunzuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "qunzu_yanben2";
	}
	@RequestMapping("qunzu_yanben3.do")
	public String qunzu_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Qunzu qunzu, String bianhao, String chuangshiren, String mingcheng, String leixing, String fengmian, String chuangjianriqi1,String chuangjianriqi2, String renshu, String jianjie, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
		if(chuangshiren==null||chuangshiren.equals("")){pmap.put("chuangshiren", null);}else{pmap.put("chuangshiren", chuangshiren);}
		if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
		if(leixing==null||leixing.equals("")){pmap.put("leixing", null);}else{pmap.put("leixing", leixing);}
		if(fengmian==null||fengmian.equals("")){pmap.put("fengmian", null);}else{pmap.put("fengmian", fengmian);}
		if(chuangjianriqi1==null||chuangjianriqi1.equals("")){pmap.put("chuangjianriqi1", null);}else{pmap.put("chuangjianriqi1", chuangjianriqi1);}
		if(chuangjianriqi2==null||chuangjianriqi2.equals("")){pmap.put("chuangjianriqi2", null);}else{pmap.put("chuangjianriqi2", chuangjianriqi2);}
		if(renshu==null||renshu.equals("")){pmap.put("renshu", null);}else{pmap.put("renshu", renshu);}
		if(jianjie==null||jianjie.equals("")){pmap.put("jianjie", null);}else{pmap.put("jianjie", jianjie);}
		
		int total=qunzuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Qunzu> list=qunzuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "qunzu_yanben3";
	}
	@RequestMapping("qunzu_yanben4.do")
	public String qunzu_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Qunzu qunzu, String bianhao, String chuangshiren, String mingcheng, String leixing, String fengmian, String chuangjianriqi1,String chuangjianriqi2, String renshu, String jianjie, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
		if(chuangshiren==null||chuangshiren.equals("")){pmap.put("chuangshiren", null);}else{pmap.put("chuangshiren", chuangshiren);}
		if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
		if(leixing==null||leixing.equals("")){pmap.put("leixing", null);}else{pmap.put("leixing", leixing);}
		if(fengmian==null||fengmian.equals("")){pmap.put("fengmian", null);}else{pmap.put("fengmian", fengmian);}
		if(chuangjianriqi1==null||chuangjianriqi1.equals("")){pmap.put("chuangjianriqi1", null);}else{pmap.put("chuangjianriqi1", chuangjianriqi1);}
		if(chuangjianriqi2==null||chuangjianriqi2.equals("")){pmap.put("chuangjianriqi2", null);}else{pmap.put("chuangjianriqi2", chuangjianriqi2);}
		if(renshu==null||renshu.equals("")){pmap.put("renshu", null);}else{pmap.put("renshu", renshu);}
		if(jianjie==null||jianjie.equals("")){pmap.put("jianjie", null);}else{pmap.put("jianjie", jianjie);}
		
		int total=qunzuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Qunzu> list=qunzuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "qunzu_yanben4";
	}
	@RequestMapping("qunzu_yanben5.do")
	public String qunzu_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Qunzu qunzu, String bianhao, String chuangshiren, String mingcheng, String leixing, String fengmian, String chuangjianriqi1,String chuangjianriqi2, String renshu, String jianjie, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
		if(chuangshiren==null||chuangshiren.equals("")){pmap.put("chuangshiren", null);}else{pmap.put("chuangshiren", chuangshiren);}
		if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
		if(leixing==null||leixing.equals("")){pmap.put("leixing", null);}else{pmap.put("leixing", leixing);}
		if(fengmian==null||fengmian.equals("")){pmap.put("fengmian", null);}else{pmap.put("fengmian", fengmian);}
		if(chuangjianriqi1==null||chuangjianriqi1.equals("")){pmap.put("chuangjianriqi1", null);}else{pmap.put("chuangjianriqi1", chuangjianriqi1);}
		if(chuangjianriqi2==null||chuangjianriqi2.equals("")){pmap.put("chuangjianriqi2", null);}else{pmap.put("chuangjianriqi2", chuangjianriqi2);}
		if(renshu==null||renshu.equals("")){pmap.put("renshu", null);}else{pmap.put("renshu", renshu);}
		if(jianjie==null||jianjie.equals("")){pmap.put("jianjie", null);}else{pmap.put("jianjie", jianjie);}
		
		int total=qunzuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Qunzu> list=qunzuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "qunzu_yanben5";
	}
	
	@RequestMapping("qunzuList2.do")
	public String qunzuList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Qunzu qunzu, String bianhao, String chuangshiren, String mingcheng, String leixing, String fengmian, String chuangjianriqi1,String chuangjianriqi2, String renshu, String jianjie, String issh,HttpServletRequest request){
		/*if(session.getAttribute("user")==null){
			return "login";
		}*/
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		pmap.put("chuangshiren", (String)request.getSession().getAttribute("username"));
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
		if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
		if(leixing==null||leixing.equals("")){pmap.put("leixing", null);}else{pmap.put("leixing", leixing);}
		if(fengmian==null||fengmian.equals("")){pmap.put("fengmian", null);}else{pmap.put("fengmian", fengmian);}
		if(chuangjianriqi1==null||chuangjianriqi1.equals("")){pmap.put("chuangjianriqi1", null);}else{pmap.put("chuangjianriqi1", chuangjianriqi1);}
		if(chuangjianriqi2==null||chuangjianriqi2.equals("")){pmap.put("chuangjianriqi2", null);}else{pmap.put("chuangjianriqi2", chuangjianriqi2);}
		if(renshu==null||renshu.equals("")){pmap.put("renshu", null);}else{pmap.put("renshu", renshu);}
		if(jianjie==null||jianjie.equals("")){pmap.put("jianjie", null);}else{pmap.put("jianjie", jianjie);}
		
		
		int total=qunzuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Qunzu> list=qunzuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "qunzu_list2";
	}
	
	
	@RequestMapping("qzList.do")
	public String qzList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Qunzu qunzu, String bianhao, String chuangshiren, String mingcheng, String leixing, String fengmian, String chuangjianriqi1,String chuangjianriqi2, String renshu, String jianjie, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		pmap.put("issh", "已通过");
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
		if(chuangshiren==null||chuangshiren.equals("")){pmap.put("chuangshiren", null);}else{pmap.put("chuangshiren", chuangshiren);}
		if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
		if(leixing==null||leixing.equals("")){pmap.put("leixing", null);}else{pmap.put("leixing", leixing);}
		if(fengmian==null||fengmian.equals("")){pmap.put("fengmian", null);}else{pmap.put("fengmian", fengmian);}
		if(chuangjianriqi1==null||chuangjianriqi1.equals("")){pmap.put("chuangjianriqi1", null);}else{pmap.put("chuangjianriqi1", chuangjianriqi1);}
		if(chuangjianriqi2==null||chuangjianriqi2.equals("")){pmap.put("chuangjianriqi2", null);}else{pmap.put("chuangjianriqi2", chuangjianriqi2);}
		if(renshu==null||renshu.equals("")){pmap.put("renshu", null);}else{pmap.put("renshu", renshu);}
		if(jianjie==null||jianjie.equals("")){pmap.put("jianjie", null);}else{pmap.put("jianjie", jianjie);}
		
		int total=qunzuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Qunzu> list=qunzuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "qunzulist";
	}
	//点击群组跳转到controller
	@RequestMapping("qzListtp.do")
	public String qzListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Qunzu qunzu, String bianhao, String chuangshiren, String mingcheng, String leixing, String fengmian, String chuangjianriqi1,String chuangjianriqi2, String renshu, String jianjie, String issh){
		//分页操作
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);//一页显示5个
		//存入map集合的信息，是数据库中issh字段为通过的
		pmap.put("issh", "已通过");
		if(bianhao==null||bianhao.equals("")){
			pmap.put("bianhao", null);
		}else{
			pmap.put("bianhao", bianhao);
		}
		if(chuangshiren==null||chuangshiren.equals("")){
			pmap.put("chuangshiren", null);
		}else{
			pmap.put("chuangshiren", chuangshiren);
		}
		if(mingcheng==null||mingcheng.equals("")){
			pmap.put("mingcheng", null);
		}else{
			pmap.put("mingcheng", mingcheng);
		}
		if(leixing==null||leixing.equals("")){
			pmap.put("leixing", null);}else{
			pmap.put("leixing", leixing);
		}
		if(fengmian==null||fengmian.equals("")){
			pmap.put("fengmian", null);}else{
			pmap.put("fengmian", fengmian);
		}
		if(chuangjianriqi1==null||chuangjianriqi1.equals("")) {
			pmap.put("chuangjianriqi1", null);
		}else{
			pmap.put("chuangjianriqi1", chuangjianriqi1);
		}
		if(chuangjianriqi2==null||chuangjianriqi2.equals("")){
			pmap.put("chuangjianriqi2", null);
		}else{
			pmap.put("chuangjianriqi2", chuangjianriqi2);
		}
		if(renshu==null||renshu.equals("")){
			pmap.put("renshu", null);
		}else{
			pmap.put("renshu", renshu);
		}
		if(jianjie==null||jianjie.equals("")){
			pmap.put("jianjie", null);
		}else{
			pmap.put("jianjie", jianjie);
		}
		
		int total=qunzuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Qunzu> list=qunzuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "qunzulisttp";
	}
	
	@RequestMapping("deleteQunzu.do")
	public String deleteQunzu(int id,HttpServletRequest request){
		qunzuService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:qunzuList.do";
	}
	
	
}
