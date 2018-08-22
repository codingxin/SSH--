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
import com.zhang.service.XiangtanService;
import com.zhang.util.PageUtil;
import com.zhang.util.ResponseUtil;
import com.zhang.util.StringUtil;

import net.sf.json.JSONObject;

@Controller
//代表返回的jsp中目录的值
@RequestMapping(value = "/xiangtan")
public class XiangtanAction {

	@Autowired
	private XiangtanService xiangtanService;

	private String msg;
	private boolean success;
	private JSONObject resultJson = new JSONObject();

	public XiangtanService getXiangtanService() {
		return xiangtanService;
	}

	public void setXiangtanService(XiangtanService XiangtanService) {
		this.xiangtanService = XiangtanService;
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
		Tianditu Xiangtan=new Tianditu();
		Xiangtan.setTitle(md.getTitle());
		Xiangtan.setExtra(md.getExtra());
		Xiangtan.setPlace(md.getPlace());
        Date   date   =   new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(md.getUpdatetime()));
		Xiangtan.setUpdatetime(date);
		success = xiangtanService.save(Xiangtan);
		
		// 构造方法注入  Xiangtan Xiangtan = new Xiangtan(title, extra,timestamp);
		//success = XiangtanService.save(Xiangtan);
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
		Tianditu Xiangtan=new Tianditu();
		Xiangtan.setId(md.getId());
		Xiangtan.setTitle(md.getTitle());
		Xiangtan.setExtra(md.getExtra());
		Xiangtan.setPlace(md.getPlace());
        Date   date   =   new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(md.getUpdatetime()));
		Xiangtan.setUpdatetime(date);
		success = xiangtanService.update(Xiangtan);

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
		success = xiangtanService.delete(id);
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
		return new ModelAndView("/xiangtan/add");
	}

	@RequestMapping(value = "/showList")
	public ModelAndView showList(Tianditu s_Xiangtan, HttpServletRequest request) throws ParseException {
		System.out.println(s_Xiangtan);
		ModelAndView mav = new ModelAndView("/xiangtan/list");
		String page = request.getParameter("page");
		if (StringUtil.isEmpty(page)) {
			page = "1";
		} else {
			// s_Xiangtan=(Xiangtan) session.getAttribute("s_Xiangtan");
		}
		PageBean pageBean = new PageBean(Integer.parseInt(page), 10);
		List<Tianditu> XiangtanList = xiangtanService.find(pageBean, s_Xiangtan);
		System.out.println(XiangtanList);
		int total = xiangtanService.findAll().size();
		System.out.println(total);
		String pageCode = PageUtil.rootPageTion("/AdminTianditu/xiangtan/showList", total, pageBean.getPage(),
				pageBean.getPageSize(), null, null);
		mav.addObject("pageCode", pageCode);
		mav.addObject("XiangtanList", XiangtanList);
	
		return mav;
	}
}
