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
import com.zhang.service.ChenzhouService;
import com.zhang.util.PageUtil;
import com.zhang.util.ResponseUtil;
import com.zhang.util.StringUtil;

import net.sf.json.JSONObject;

@Controller
//代表返回的jsp中目录的值
@RequestMapping(value = "/chenzhou")
public class ChenzhouAction {

	@Autowired
	private ChenzhouService chenzhouService;

	private String msg;
	private boolean success;
	private JSONObject resultJson = new JSONObject();

	public ChenzhouService getChenzhouService() {
		return chenzhouService;
	}

	public void setChenzhouService(ChenzhouService ChenzhouService) {
		this.chenzhouService = ChenzhouService;
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
		Tianditu Chenzhou=new Tianditu();
		Chenzhou.setTitle(md.getTitle());
		Chenzhou.setExtra(md.getExtra());
		Chenzhou.setPlace(md.getPlace());
        Date   date   =   new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(md.getUpdatetime()));
		Chenzhou.setUpdatetime(date);
		success = chenzhouService.save(Chenzhou);
		
		// 构造方法注入  Chenzhou Chenzhou = new Chenzhou(title, extra,timestamp);
		//success = ChenzhouService.save(Chenzhou);
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
		Tianditu Chenzhou=new Tianditu();
		Chenzhou.setId(md.getId());
		Chenzhou.setTitle(md.getTitle());
		Chenzhou.setExtra(md.getExtra());
		Chenzhou.setPlace(md.getPlace());
        Date   date   =   new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(md.getUpdatetime()));
		Chenzhou.setUpdatetime(date);
		success = chenzhouService.update(Chenzhou);

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
		success = chenzhouService.delete(id);
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
		return new ModelAndView("/chenzhou/add");
	}

	@RequestMapping(value = "/showList")
	public ModelAndView showList(Tianditu s_Chenzhou, HttpServletRequest request) throws ParseException {
		System.out.println(s_Chenzhou);
		ModelAndView mav = new ModelAndView("/chenzhou/list");
		String page = request.getParameter("page");
		if (StringUtil.isEmpty(page)) {
			page = "1";
		} else {
			// s_Chenzhou=(Chenzhou) session.getAttribute("s_Chenzhou");
		}
		PageBean pageBean = new PageBean(Integer.parseInt(page), 10);
		List<Tianditu> ChenzhouList = chenzhouService.find(pageBean, s_Chenzhou);
		System.out.println(ChenzhouList);
		int total = chenzhouService.findAll().size();
		System.out.println(total);
		String pageCode = PageUtil.rootPageTion("/AdminTianditu/chenzhou/showList", total, pageBean.getPage(),
				pageBean.getPageSize(), null, null);
		mav.addObject("pageCode", pageCode);
		mav.addObject("ChenzhouList", ChenzhouList);
	
		return mav;
	}
}
