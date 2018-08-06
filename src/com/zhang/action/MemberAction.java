package com.zhang.action;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zhang.dto.MemberDto;
import com.zhang.entity.Member;
import com.zhang.entity.PageBean;
import com.zhang.service.MemberService;
import com.zhang.util.PageUtil;
import com.zhang.util.ResponseUtil;
import com.zhang.util.StringUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping(value = "/member")
public class MemberAction {

	@Autowired
	private MemberService memberService;

	private String msg;
	private boolean success;
	private JSONObject resultJson = new JSONObject();

	public MemberService getMemberService() {
		return memberService;
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	@RequestMapping(value = "/insert")
	public void insert(HttpServletRequest request, HttpServletResponse response) throws ParseException {
		String number = request.getParameter("number");
		// if(checkNumber(number)){
		String title = request.getParameter("title");
		String extra = request.getParameter("extra");
		String updatetime = request.getParameter("date");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    	java.util.Date date = df.parse(updatetime);
    	Calendar cal = Calendar.getInstance();
    	cal.setTime(date);
    	long timestamp = cal.getTimeInMillis()/1000;
        System.out.println("timestamp "+timestamp);
		Member member = new Member(title, extra,timestamp);
		success = memberService.save(member);
		if (success)
			msg = "添加成功";
		else
			msg = "添加失败";

		resultJson.put("msg", msg);
		resultJson.put("success", success);
		ResponseUtil.writeJson(response, resultJson);
	}

	@RequestMapping(value = "/update")
	public void update(HttpServletRequest request, HttpServletResponse response) throws ParseException {
		int id = Integer.parseInt(request.getParameter("id"));
		// if(checkNumber(number)){
		String title = request.getParameter("title");
		String extra = request.getParameter("extra");
		
		String updatetime = request.getParameter("date");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    	Date date = df.parse(updatetime);
    	Calendar cal = Calendar.getInstance();
    	cal.setTime(date);
    	long timestamp = cal.getTimeInMillis()/1000;
        System.out.println("timestamp "+timestamp);
        
		Member member = new Member(id, title, extra,timestamp);
		success = memberService.update(member);

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
		success = memberService.delete(id);
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
		return new ModelAndView("/member/add");
	}

	@RequestMapping(value = "/showList")
	public ModelAndView showList(Member s_member, HttpServletRequest request) throws ParseException {
		ModelAndView mav = new ModelAndView("/member/list");
		String page = request.getParameter("page");
		//String updatetime = request.getParameter("timestamp");
		//1
		/*SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
		Long time = new Long(updatetime)*1000; 
		String d = format.format(time); 
		Date date = format.parse(d); 
		System.out.println("Format To String(Date):" + d); 
		System.out.println("Format To Date:" +date); */
		//---1
		if (StringUtil.isEmpty(page)) {
			page = "1";
		} else {
			// s_member=(Member) session.getAttribute("s_member");
		}
		PageBean pageBean = new PageBean(Integer.parseInt(page), 10);
		List<Member> memberList = memberService.find(pageBean, s_member);
		int total = memberService.findAll().size();
		String pageCode = PageUtil.rootPageTion("/AdminChangde/member/showList", total, pageBean.getPage(),
				pageBean.getPageSize(), null, null);
		mav.addObject("pageCode", pageCode);
		
		//通过dto工具类改写memberList
		List<MemberDto> memberDtoList=new ArrayList<MemberDto>();
		for (Member member : memberList) {
			MemberDto mDto=new MemberDto();
			System.out.println(member.getId());
			mDto.setExtra(member.getExtra());
			mDto.setId(member.getId());
			//时间戳转成日期 
			mDto.setTimestamp(new Date(member.getTimestamp()*1000));
			mDto.setTitle(member.getTitle());
			System.out.println("md:"+mDto.getId());
			memberDtoList.add(mDto);
		}
		//改写结束
		mav.addObject("memberList", memberDtoList);
	
		return mav;
	}
}
