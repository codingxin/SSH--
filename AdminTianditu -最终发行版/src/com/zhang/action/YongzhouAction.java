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
import com.zhang.service.YongzhouService;
import com.zhang.util.PageUtil;
import com.zhang.util.ResponseUtil;
import com.zhang.util.StringUtil;

import net.sf.json.JSONObject;

@Controller
//代表返回的jsp中目录的值
@RequestMapping(value = "/yongzhou")
public class YongzhouAction {

	@Autowired
	private YongzhouService yongzhouService;

	private String msg;
	private boolean success;
	private JSONObject resultJson = new JSONObject();

	public YongzhouService getYongzhouService() {
		return yongzhouService;
	}

	public void setYongzhouService(YongzhouService yongzhouService) {
		this.yongzhouService = yongzhouService;
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
		Tianditu yongzhou=new Tianditu();
		yongzhou.setTitle(md.getTitle());
		yongzhou.setExtra(md.getExtra());
		yongzhou.setPlace(md.getPlace());
        Date   date   =   new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(md.getUpdatetime()));
        yongzhou.setUpdatetime(date);
		success = yongzhouService.save(yongzhou);
		
		// 构造方法注入  Yongzhou Yongzhou = new Yongzhou(title, extra,timestamp);
		//success = YongzhouService.save(Yongzhou);
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
		Tianditu yongzhou=new Tianditu();
		yongzhou.setId(md.getId());
		yongzhou.setTitle(md.getTitle());
		yongzhou.setExtra(md.getExtra());
		yongzhou.setPlace(md.getPlace());
        Date   date   =   new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(md.getUpdatetime()));
        yongzhou.setUpdatetime(date);
		success = yongzhouService.update(yongzhou);

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
		success = yongzhouService.delete(id);
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
		return new ModelAndView("/yongzhou/add");
	}

	@RequestMapping(value = "/showList")
	public ModelAndView showList(Tianditu s_Yongzhou, HttpServletRequest request) throws ParseException {
		ModelAndView mav = new ModelAndView("/yongzhou/list");
		String page = request.getParameter("page");
		if (StringUtil.isEmpty(page)) {
			page = "1";
		} else {
			// s_Yongzhou=(Yongzhou) session.getAttribute("s_Yongzhou");
		}
		PageBean pageBean = new PageBean(Integer.parseInt(page), 10);
		List<Tianditu> YongzhouList = yongzhouService.find(pageBean, s_Yongzhou);
		int total = yongzhouService.findAll().size();
		String pageCode = PageUtil.rootPageTion("/AdminTianditu/yongzhou/showList", total, pageBean.getPage(),
				pageBean.getPageSize(), null, null);
		mav.addObject("pageCode", pageCode);
		//返回前端modelAndview
		mav.addObject("YongzhouList", YongzhouList);
	    return mav;
	}
}
