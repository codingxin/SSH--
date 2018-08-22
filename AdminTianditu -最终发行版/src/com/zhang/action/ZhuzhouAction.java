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
import com.zhang.service.ZhuzhouService;
import com.zhang.util.PageUtil;
import com.zhang.util.ResponseUtil;
import com.zhang.util.StringUtil;

import net.sf.json.JSONObject;

@Controller
//代表返回的jsp中目录的值
@RequestMapping(value = "/zhuzhou")
public class ZhuzhouAction {

	@Autowired
	private ZhuzhouService ZhuzhouService;

	private String msg;
	private boolean success;
	private JSONObject resultJson = new JSONObject();

	public ZhuzhouService getZhuzhouService() {
		return ZhuzhouService;
	}

	public void setZhuzhouService(ZhuzhouService ZhuzhouService) {
		this.ZhuzhouService = ZhuzhouService;
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
		Tianditu zhuzhou=new Tianditu();
		zhuzhou.setTitle(md.getTitle());
		zhuzhou.setExtra(md.getExtra());
		zhuzhou.setPlace(md.getPlace());
        Date   date   =   new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(md.getUpdatetime()));
        zhuzhou.setUpdatetime(date);
		success = ZhuzhouService.save(zhuzhou);
		
		// 构造方法注入  Zhuzhou Zhuzhou = new Zhuzhou(title, extra,timestamp);
		//success = ZhuzhouService.save(Zhuzhou);
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
		Tianditu Zhuzhou=new Tianditu();
		Zhuzhou.setId(md.getId());
		Zhuzhou.setTitle(md.getTitle());
		Zhuzhou.setExtra(md.getExtra());
		Zhuzhou.setPlace(md.getPlace());
        Date   date   =   new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(md.getUpdatetime()));
		Zhuzhou.setUpdatetime(date);
		success = ZhuzhouService.update(Zhuzhou);

		if (success)
			msg = "更新成功";
		else
			msg = "更新失败";
	
		resultJson.put("msg", msg);
		resultJson.put("success", success);
		ResponseUtil.writeJson(response, resultJson);
	}

	@RequestMapping(value = "/del")
	public void delete(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		success = ZhuzhouService.delete(id);
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
		return new ModelAndView("/zhuzhou/add");
	}

	@RequestMapping(value = "/showList")
	public ModelAndView showList(Tianditu s_Zhuzhou, HttpServletRequest request) throws ParseException {
		ModelAndView mav = new ModelAndView("/zhuzhou/list");
		String page = request.getParameter("page");
		if (StringUtil.isEmpty(page)) {
			page = "1";
		} else {
			// s_Zhuzhou=(Zhuzhou) session.getAttribute("s_Zhuzhou");
		}
		PageBean pageBean = new PageBean(Integer.parseInt(page), 10);
		List<Tianditu> ZhuzhouList = ZhuzhouService.find(pageBean, s_Zhuzhou);
		int total = ZhuzhouService.findAll().size();
		String pageCode = PageUtil.rootPageTion("/AdminTianditu/zhuzhou/showList", total, pageBean.getPage(),
				pageBean.getPageSize(), null, null);
		mav.addObject("pageCode", pageCode);
		mav.addObject("ZhuzhouList", ZhuzhouList);
	    return mav;
	}
}
