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
import com.zhang.service.ChangshaService;
import com.zhang.util.PageUtil;
import com.zhang.util.ResponseUtil;
import com.zhang.util.StringUtil;

import net.sf.json.JSONObject;

@Controller
// 代表返回的jsp中目录的值
@RequestMapping(value = "/changsha")
public class ChangshaAction {

	@Autowired
	private ChangshaService changshaService;

	private String msg;
	private boolean success;
	private JSONObject resultJson = new JSONObject();

	public ChangshaService getChangshaService() {
		return changshaService;
	}

	public void setChangshaService(ChangshaService changshaService) {
		this.changshaService = changshaService;
	}

	@RequestMapping(value = "/insert")
	@ResponseBody
	public void insert(MemberDto md, HttpServletRequest request, HttpServletResponse response) throws ParseException {
		System.out.println(md);
		System.out.println(md.getPlace());
		Tianditu changsha = new Tianditu();
		changsha.setTitle(md.getTitle());
		changsha.setExtra(md.getExtra());
		changsha.setPlace(md.getPlace());
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(md.getUpdatetime()));
		changsha.setUpdatetime(date);
		success = changshaService.save(changsha);
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
		Tianditu changsha = new Tianditu();
		changsha.setId(md.getId());
		changsha.setTitle(md.getTitle());
		changsha.setExtra(md.getExtra());
		changsha.setPlace(md.getPlace());
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(md.getUpdatetime()));
		changsha.setUpdatetime(date);
		success = changshaService.update(changsha);

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
		success = changshaService.delete(id);
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
		return new ModelAndView("/changsha/add");
	}

	@RequestMapping(value = "/showList")
	public ModelAndView showList(Tianditu s_changsha, HttpServletRequest request) throws ParseException {
		ModelAndView mav = new ModelAndView("/changsha/list");
		String page = request.getParameter("page");
		if (StringUtil.isEmpty(page)) {
			page = "1";
		} else {
			// s_changsha=(Changsha) session.getAttribute("s_changsha");
		}
		PageBean pageBean = new PageBean(Integer.parseInt(page), 10);
		List<Tianditu> changshaList = changshaService.find(pageBean, s_changsha);
		int total = changshaService.findAll().size();
		String pageCode = PageUtil.rootPageTion("/AdminTianditu/changsha/showList", total, pageBean.getPage(),
				pageBean.getPageSize(), null, null);
		mav.addObject("pageCode", pageCode);

		mav.addObject("changshaList", changshaList);

		return mav;
	}
}
