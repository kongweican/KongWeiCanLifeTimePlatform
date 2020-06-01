package com.controller;


import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Yonghuzhuce;
import com.entity.Qunzu;
import com.server.YonghuzhuceServer;
import com.server.QunzuServer;


@Controller
public class IndexController {
	@Resource
	private YonghuzhuceServer yonghuzhuceServer;
	@Resource
    private QunzuServer qunzuServer;

	
	
	
//	首页显示内容
	@RequestMapping("index.do")
	public String showIndex(ModelMap map){

		List<Yonghuzhuce> syyonghuzhuce1=yonghuzhuceServer.getsyyonghuzhuce1(null);
		List<Qunzu> syqunzu=qunzuServer.getsyqunzu1(null);
	    map.put("syyonghuzhuce1", syyonghuzhuce1);
	    map.put("syqunzu", syqunzu);


		return "default";
	}

	

	
}
