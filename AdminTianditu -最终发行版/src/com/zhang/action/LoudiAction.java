package com.zhang.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhang.dto.MemberDto;
import com.zhang.entity.PageBean;
import com.zhang.entity.Tianditu;
import com.zhang.service.LoudiService;
import com.zhang.util.PageUtil;
import com.zhang.util.ResponseUtil;
import com.zhang.util.StringUtil;

import net.sf.json.JSONObject;

@Controller
//代表返回的jsp中目录的值
@RequestMapping(value = "/loudi")
public class LoudiAction {

	@Autowired
	private LoudiService loudiService;

	private String msg;
	private boolean success;
	private JSONObject resultJson = new JSONObject();

	public LoudiService getLoudiService() {
		return loudiService;
	}

	public void setLoudiService(LoudiService LoudiService) {
		this.loudiService = LoudiService;
	}

	@RequestMapping(value = "/insert")
	@ResponseBody
	public void insert(MemberDto md,HttpServletRequest request, HttpServletResponse response) throws ParseException {
		System.out.println(md);
	/*	String title = request.getParameter("title");
		String extra = request.getParameter("extra");
		System.out.println("title " + title);
		System.out.println("extra "+ title);
		String updatetime = request.getParameter("updatetime");
		System.out.println("updatetime" +updatetime);*/
		System.out.println(md.getPlace());
		Tianditu Loudi=new Tianditu();
		Loudi.setTitle(md.getTitle());
		Loudi.setExtra(md.getExtra());
		Loudi.setPlace(md.getPlace());
        Date   date   =   new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(md.getUpdatetime()));
		Loudi.setUpdatetime(date);
		success = loudiService.save(Loudi);
		
		// 构造方法注入  Loudi Loudi = new Loudi(title, extra,timestamp);
		//success = LoudiService.save(Loudi);
		if (success)
			msg = "添加成功";
		else
			msg = "添加失败";

		resultJson.put("msg", msg);
		resultJson.put("success", success);
		ResponseUtil.writeJson(response, resultJson);
	}

	@RequestMapping(value = "/update")
	public void update(MemberDto md, HttpServletRequest request, HttpServletResponse response) throws ParseException {
		System.out.println(md.toString());
		Tianditu Loudi=new Tianditu();
		Loudi.setId(md.getId());
		Loudi.setTitle(md.getTitle());
		Loudi.setExtra(md.getExtra());
		Loudi.setPlace(md.getPlace());
        Date   date   =   new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(md.getUpdatetime()));
		Loudi.setUpdatetime(date);
		success = loudiService.update(Loudi);

		if (success)
			msg = "更新成功";
		else
			msg = "更新失败";
		System.out.println("执行到这里了3");
		resultJson.put("msg", msg);
		resultJson.put("success", success);
		ResponseUtil.writeJson(response, resultJson);
	}

	@RequestMapping(value = "/del")
	public void delete(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		success = loudiService.delete(id);
		if (success)
			msg = "删除成功";
		else
			msg = "删除失败";
		resultJson.put("msg", msg);
		resultJson.put("success", success);
		ResponseUtil.writeJson(response, resultJson);
	}

	@RequestMapping(value = "/showAdd")
	public ModelAndView showAdd(HttpServletRequest request) {
		return new ModelAndView("/loudi/add");
	}

	@RequestMapping(value = "/showList")
	public ModelAndView showList(Tianditu s_Loudi, HttpServletRequest request) throws ParseException {
		System.out.println(s_Loudi);
		ModelAndView mav = new ModelAndView("/loudi/list");
		String page = request.getParameter("page");
		if (StringUtil.isEmpty(page)) {
			page = "1";
		} else {
			// s_Loudi=(Loudi) session.getAttribute("s_Loudi");
		}
		PageBean pageBean = new PageBean(Integer.parseInt(page), 10);
		List<Tianditu> LoudiList = loudiService.find(pageBean, s_Loudi);
		System.out.println(LoudiList);
		int total = loudiService.findAll().size();
		System.out.println(total);
		String pageCode = PageUtil.rootPageTion("/AdminTianditu/loudi/showList", total, pageBean.getPage(),
				pageBean.getPageSize(), null, null);
		mav.addObject("pageCode", pageCode);
		mav.addObject("LoudiList", LoudiList);
	
		return mav;
	}
}
