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
import com.zhang.service.YueyangService;
import com.zhang.util.PageUtil;
import com.zhang.util.ResponseUtil;
import com.zhang.util.StringUtil;

import net.sf.json.JSONObject;

@Controller
//代表返回的jsp中目录的值
@RequestMapping(value = "/yueyang")
public class YueyangAction {

	@Autowired
	private YueyangService yueyangService;

	private String msg;
	private boolean success;
	private JSONObject resultJson = new JSONObject();

	public YueyangService getyueyangService() {
		return yueyangService;
	}

	public void setyueyangService(YueyangService yueyangService) {
		this.yueyangService = yueyangService;
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
		Tianditu yueyang=new Tianditu();
		yueyang.setTitle(md.getTitle());
		yueyang.setExtra(md.getExtra());
		yueyang.setPlace(md.getPlace());
		//将String类转换成日期
        Date   date   =   new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(md.getUpdatetime()));
        yueyang.setUpdatetime(date);
		success = yueyangService.save(yueyang);
		
		// 构造方法注入  Yueyang Yueyang = new Yueyang(title, extra,timestamp);
		//success = yueyangService.save(Yueyang);
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
		Tianditu yueyang=new Tianditu();
		yueyang.setId(md.getId());
		yueyang.setTitle(md.getTitle());
		yueyang.setExtra(md.getExtra());
		yueyang.setPlace(md.getPlace());
        Date   date   =   new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(md.getUpdatetime()));
        yueyang.setUpdatetime(date);
		success = yueyangService.update(yueyang);

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
		success = yueyangService.delete(id);
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
		return new ModelAndView("/yueyang/add");
	}

	@RequestMapping(value = "/showList")
	public ModelAndView showList(Tianditu s_Yueyang, HttpServletRequest request) throws ParseException {
		ModelAndView mav = new ModelAndView("/yueyang/list");
		String page = request.getParameter("page");
		if (StringUtil.isEmpty(page)) {
			page = "1";
		} else {
			// s_Yueyang=(Yueyang) session.getAttribute("s_Yueyang");
		}
		PageBean pageBean = new PageBean(Integer.parseInt(page), 10);
		List<Tianditu> YueyangList = yueyangService.find(pageBean, s_Yueyang);
		int total = yueyangService.findAll().size();
		String pageCode = PageUtil.rootPageTion("/AdminTianditu/yueyang/showList", total, pageBean.getPage(),
				pageBean.getPageSize(), null, null);
		mav.addObject("pageCode", pageCode);
		
		mav.addObject("YueyangList", YueyangList);
	
		return mav;
	}
}
