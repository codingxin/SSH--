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
import com.zhang.service.ChangdeService;
import com.zhang.util.PageUtil;
import com.zhang.util.ResponseUtil;
import com.zhang.util.StringUtil;

import net.sf.json.JSONObject;

@Controller
//代表返回的jsp中目录的值
@RequestMapping(value = "/changde")
public class ChangdeAction {

	@Autowired
	private ChangdeService ChangdeService;

	private String msg;
	private boolean success;
	private JSONObject resultJson = new JSONObject();

	public ChangdeService getChangdeService() {
		return ChangdeService;
	}

	public void setChangdeService(ChangdeService ChangdeService) {
		this.ChangdeService = ChangdeService;
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
		Tianditu Changde=new Tianditu();
		Changde.setTitle(md.getTitle());
		Changde.setExtra(md.getExtra());
		Changde.setPlace(md.getPlace());
        Date   date   =   new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(md.getUpdatetime()));
		Changde.setUpdatetime(date);
		success = ChangdeService.save(Changde);
		
		// 构造方法注入  Changde Changde = new Changde(title, extra,timestamp);
		//success = ChangdeService.save(Changde);
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
		Tianditu Changde=new Tianditu();
		Changde.setId(md.getId());
		Changde.setTitle(md.getTitle());
		Changde.setExtra(md.getExtra());
		Changde.setPlace(md.getPlace());
        Date   date   =   new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(md.getUpdatetime()));
		Changde.setUpdatetime(date);
		success = ChangdeService.update(Changde);

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
		success = ChangdeService.delete(id);
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
		return new ModelAndView("/changde/add");
	}

	@RequestMapping(value = "/showList")
	public ModelAndView showList(Tianditu s_Changde, HttpServletRequest request) throws ParseException {
		System.out.println(s_Changde);
		ModelAndView mav = new ModelAndView("/changde/list");
		String page = request.getParameter("page");
		if (StringUtil.isEmpty(page)) {
			page = "1";
		} else {
			// s_Changde=(Changde) session.getAttribute("s_Changde");
		}
		PageBean pageBean = new PageBean(Integer.parseInt(page), 10);
		List<Tianditu> ChangdeList = ChangdeService.find(pageBean, s_Changde);
		System.out.println(ChangdeList);
		int total = ChangdeService.findAll().size();
		System.out.println(total);
		String pageCode = PageUtil.rootPageTion("/AdminTianditu/changde/showList", total, pageBean.getPage(),
				pageBean.getPageSize(), null, null);
		mav.addObject("pageCode", pageCode);
		mav.addObject("ChangdeList", ChangdeList);
	
		return mav;
	}
}
