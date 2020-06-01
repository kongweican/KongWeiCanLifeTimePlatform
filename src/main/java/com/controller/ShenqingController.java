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

import com.entity.Shenqing;
import com.server.ShenqingServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class ShenqingController {
	@Resource
	private ShenqingServer shenqingService;


   
	@RequestMapping("addShenqing.do")
	public String addShenqing(HttpServletRequest request,Shenqing shenqing,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		shenqing.setAddtime(time.toString().substring(0, 19));
		shenqingService.add(shenqing);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));

		return "redirect:postback.jsp";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateShenqing.do")
	public String doUpdateShenqing(int id,ModelMap map,Shenqing shenqing){
		shenqing=shenqingService.getById(id);
		map.put("shenqing", shenqing);
		return "shenqing_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("shenqingDetail.do")
	public String shenqingDetail(int id,ModelMap map,Shenqing shenqing){
		shenqing=shenqingService.getById(id);
		map.put("shenqing", shenqing);
		return "shenqing_detail";
	}
//	前台详细
	@RequestMapping("sqDetail.do")
	public String sqDetail(int id,ModelMap map,Shenqing shenqing){
		shenqing=shenqingService.getById(id);
		map.put("shenqing", shenqing);
		return "shenqingdetail";
	}
//	
	@RequestMapping("updateShenqing.do")
	public String updateShenqing(int id,ModelMap map,Shenqing shenqing,HttpServletRequest request,HttpSession session){
		shenqingService.update(shenqing);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:shenqingList.do";
	}

//	分页查询
	@RequestMapping("shenqingList.do")
	public String shenqingList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shenqing shenqing, String bianhao, String chuangshiren, String mingcheng, String leibie, String shenqingren, String beizhu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
		if(chuangshiren==null||chuangshiren.equals("")){pmap.put("chuangshiren", null);}else{pmap.put("chuangshiren", chuangshiren);}
		if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}
		if(shenqingren==null||shenqingren.equals("")){pmap.put("shenqingren", null);}else{pmap.put("shenqingren", shenqingren);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=shenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shenqing> list=shenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shenqing_list";
	}
	
	@RequestMapping("shenqingList2.do")
	public String shenqingList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shenqing shenqing, String bianhao, String chuangshiren, String mingcheng, String leibie, String shenqingren, String beizhu, String issh,HttpServletRequest request){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		pmap.put("shenqingren",(String)request.getSession().getAttribute("username"));
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
		if(chuangshiren==null||chuangshiren.equals("")){pmap.put("chuangshiren", null);}else{pmap.put("chuangshiren", chuangshiren);}
		if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}
		//if(shenqingren==null||shenqingren.equals("")){pmap.put("shenqingren", null);}else{pmap.put("shenqingren", shenqingren);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=shenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shenqing> list=shenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shenqing_list2";
	}
	
	@RequestMapping("shenqingList3.do")
	public String shenqingList3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shenqing shenqing, String bianhao, String chuangshiren, String mingcheng, String leibie, String shenqingren, String beizhu, String issh,HttpServletRequest request){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		pmap.put("issh", "待审核");
		pmap.put("chuangshiren",(String)request.getSession().getAttribute("username"));
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
		//if(chuangshiren==null||chuangshiren.equals("")){pmap.put("chuangshiren", null);}else{pmap.put("chuangshiren", chuangshiren);}
		if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}
		if(shenqingren==null||shenqingren.equals("")){pmap.put("shenqingren", null);}else{pmap.put("shenqingren", shenqingren);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=shenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shenqing> list=shenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shenqing_list3";
	}
	
	
	@RequestMapping("shenqing_yanben1.do")
	public String shenqing_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shenqing shenqing, String bianhao, String chuangshiren, String mingcheng, String leibie, String shenqingren, String beizhu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
		if(chuangshiren==null||chuangshiren.equals("")){pmap.put("chuangshiren", null);}else{pmap.put("chuangshiren", chuangshiren);}
		if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}
		if(shenqingren==null||shenqingren.equals("")){pmap.put("shenqingren", null);}else{pmap.put("shenqingren", shenqingren);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=shenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shenqing> list=shenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shenqing_yanben1";
	}
	@RequestMapping("shenqing_yanben2.do")
	public String shenqing_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shenqing shenqing, String bianhao, String chuangshiren, String mingcheng, String leibie, String shenqingren, String beizhu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
		if(chuangshiren==null||chuangshiren.equals("")){pmap.put("chuangshiren", null);}else{pmap.put("chuangshiren", chuangshiren);}
		if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}
		if(shenqingren==null||shenqingren.equals("")){pmap.put("shenqingren", null);}else{pmap.put("shenqingren", shenqingren);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=shenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shenqing> list=shenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shenqing_yanben2";
	}
	@RequestMapping("shenqing_yanben3.do")
	public String shenqing_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shenqing shenqing, String bianhao, String chuangshiren, String mingcheng, String leibie, String shenqingren, String beizhu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
		if(chuangshiren==null||chuangshiren.equals("")){pmap.put("chuangshiren", null);}else{pmap.put("chuangshiren", chuangshiren);}
		if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}
		if(shenqingren==null||shenqingren.equals("")){pmap.put("shenqingren", null);}else{pmap.put("shenqingren", shenqingren);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=shenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shenqing> list=shenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shenqing_yanben3";
	}
	@RequestMapping("shenqing_yanben4.do")
	public String shenqing_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shenqing shenqing, String bianhao, String chuangshiren, String mingcheng, String leibie, String shenqingren, String beizhu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
		if(chuangshiren==null||chuangshiren.equals("")){pmap.put("chuangshiren", null);}else{pmap.put("chuangshiren", chuangshiren);}
		if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}
		if(shenqingren==null||shenqingren.equals("")){pmap.put("shenqingren", null);}else{pmap.put("shenqingren", shenqingren);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=shenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shenqing> list=shenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shenqing_yanben4";
	}
	@RequestMapping("shenqing_yanben5.do")
	public String shenqing_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shenqing shenqing, String bianhao, String chuangshiren, String mingcheng, String leibie, String shenqingren, String beizhu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
		if(chuangshiren==null||chuangshiren.equals("")){pmap.put("chuangshiren", null);}else{pmap.put("chuangshiren", chuangshiren);}
		if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}
		if(shenqingren==null||shenqingren.equals("")){pmap.put("shenqingren", null);}else{pmap.put("shenqingren", shenqingren);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=shenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shenqing> list=shenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shenqing_yanben5";
	}
	
	
	
	@RequestMapping("sqList.do")
	public String sqList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shenqing shenqing, String bianhao, String chuangshiren, String mingcheng, String leibie, String shenqingren, String beizhu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
		if(chuangshiren==null||chuangshiren.equals("")){pmap.put("chuangshiren", null);}else{pmap.put("chuangshiren", chuangshiren);}
		if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}
		if(shenqingren==null||shenqingren.equals("")){pmap.put("shenqingren", null);}else{pmap.put("shenqingren", shenqingren);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=shenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shenqing> list=shenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shenqinglist";
	}
	@RequestMapping("sqListtp.do")
	public String sqListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shenqing shenqing, String bianhao, String chuangshiren, String mingcheng, String leibie, String shenqingren, String beizhu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
		if(chuangshiren==null||chuangshiren.equals("")){pmap.put("chuangshiren", null);}else{pmap.put("chuangshiren", chuangshiren);}
		if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}
		if(shenqingren==null||shenqingren.equals("")){pmap.put("shenqingren", null);}else{pmap.put("shenqingren", shenqingren);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=shenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shenqing> list=shenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shenqinglisttp";
	}
	
	@RequestMapping("deleteShenqing.do")
	public String deleteShenqing(int id,HttpServletRequest request){
		shenqingService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:shenqingList.do";
	}
	
	
}
