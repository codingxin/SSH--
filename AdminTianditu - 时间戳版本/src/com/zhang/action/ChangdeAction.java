package com.zhang.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhang.dto.DateToString;
import com.zhang.dto.MemberDto;
import com.zhang.entity.Changde;
import com.zhang.entity.PageBean;
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
	private ChangdeService changdeService;

	private String msg;
	private boolean success;
	private JSONObject resultJson = new JSONObject();

	public ChangdeService getChangdeService() {
		return changdeService;
	}

	public void setChangdeService(ChangdeService changdeService) {
		this.changdeService = changdeService;
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
		Changde changde=new Changde();
		changde.setTitle(md.getTitle());
		changde.setExtra(md.getExtra());
        Date   date   =   new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(md.getUpdatetime()));
		changde.setUpdatetime(date);
		success = changdeService.save(changde);
		
		// 构造方法注入  Changde changde = new Changde(title, extra,timestamp);
		//success = changdeService.save(changde);
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
		Changde changde=new Changde();
		changde.setId(md.getId());
		changde.setTitle(md.getTitle());
		changde.setExtra(md.getExtra());
        Date   date   =   new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(md.getUpdatetime()));
		changde.setUpdatetime(date);
		success = changdeService.update(changde);

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
		success = changdeService.delete(id);
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
	public ModelAndView showList(Changde s_changde, HttpServletRequest request) throws ParseException {
		ModelAndView mav = new ModelAndView("/changde/list");
		String page = request.getParameter("page");
		if (StringUtil.isEmpty(page)) {
			page = "1";
		} else {
			// s_changde=(Changde) session.getAttribute("s_changde");
		}
		PageBean pageBean = new PageBean(Integer.parseInt(page), 10);
		List<Changde> changdeList = changdeService.find(pageBean, s_changde);
		int total = changdeService.findAll().size();
		String pageCode = PageUtil.rootPageTion("/AdminTianditu/changde/showList", total, pageBean.getPage(),
				pageBean.getPageSize(), null, null);
		mav.addObject("pageCode", pageCode);
		//通过dto工具类改写changdeList
		//List<MemberDto> changdeDtoList=new ArrayList<MemberDto>();
		/*List<DateToString> changdeDtoList=new ArrayList<DateToString>();
		for (Changde changde : changdeList) {
			MemberDto mDto=new MemberDto();
			System.out.println(changde.getId());
			mDto.setExtra(changde.getExtra());
			mDto.setId(changde.getId());
			//时间戳转成日期 
			//mDto.setTimestamp(new Date(changde.getTimestamp()*1000));
			mDto.setUpdatetime(changde.getUpdatetime());
			mDto.setTitle(changde.getTitle());
			System.out.println("md:"+mDto.getId());
			changdeDtoList.add(mDto);
		}*/
		//改写结束
		mav.addObject("changdeList", changdeList);
	
		return mav;
	}
}
