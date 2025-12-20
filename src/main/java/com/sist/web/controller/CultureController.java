package com.sist.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sist.web.service.CultureService;
import com.sist.web.vo.CultureVO;
import com.sist.web.vo.FoodVO;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/culture/")
public class CultureController {
	private final CultureService cService;
	
	@GetMapping("theater") 
	public String theater_list(@RequestParam(name = "page", required = false) String page, Model model) {
		if(page==null)
			page="1";
		
		int curpage=Integer.parseInt(page);
		int rowSize=8;
		int start=(curpage*rowSize)-rowSize;

		List<CultureVO> list=new ArrayList<>();
		list=cService.culture1ListData(start);
		int totalpage=cService.culture1TotalPage();
		
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage>totalpage)
			endPage=totalpage;
		
		model.addAttribute("list", list);
	   	model.addAttribute("curpage", curpage);
	   	model.addAttribute("totalpage", totalpage);
	   	model.addAttribute("startPage", startPage);
	   	model.addAttribute("endPage", endPage);
		
		model.addAttribute("main_html", "culture/theater");
		return "main/main";
	}
	
	@GetMapping("exhibition") 
	public String exhibition_list(@RequestParam(name = "page", required = false) String page, Model model) {
		if(page==null)
			page="1";
		
		int curpage=Integer.parseInt(page);
		int rowSize=8;
		int start=(curpage*rowSize)-rowSize;

		List<CultureVO> list=new ArrayList<>();
		list=cService.culture2ListData(start);
		int totalpage=cService.culture2TotalPage();
		
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage>totalpage)
			endPage=totalpage;
		
		model.addAttribute("list", list);
	   	model.addAttribute("curpage", curpage);
	   	model.addAttribute("totalpage", totalpage);
	   	model.addAttribute("startPage", startPage);
	   	model.addAttribute("endPage", endPage);
		
		model.addAttribute("main_html", "culture/exhibition");
		return "main/main";
	}
	
	@GetMapping("activity") 
	public String activity_list(@RequestParam(name = "page", required = false) String page, Model model) {
		if(page==null)
			page="1";
		
		int curpage=Integer.parseInt(page);
		int rowSize=8;
		int start=(curpage*rowSize)-rowSize;

		List<CultureVO> list=new ArrayList<>();
		list=cService.culture3ListData(start);
		int totalpage=cService.culture3TotalPage();
		
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage>totalpage)
			endPage=totalpage;
		
		model.addAttribute("list", list);
	   	model.addAttribute("curpage", curpage);
	   	model.addAttribute("totalpage", totalpage);
	   	model.addAttribute("startPage", startPage);
	   	model.addAttribute("endPage", endPage);
		
		model.addAttribute("main_html", "culture/activity");
		return "main/main";
	}
	
	@GetMapping("detail")
	public String culture_detail(@RequestParam("no") int no, Model model, HttpSession session) {
		
		String id=(String)session.getAttribute("id");
		
		CultureVO vo=cService.cultureDetailData(no);
		
		String[] addr=vo.getAddress().split(" ");
		String address=addr[1];
		List<FoodVO> fList=cService.seoulNearFoodHouse(address);
		
		if(id==null) {
    		model.addAttribute("sessionId", "");
    	} else {
    		model.addAttribute("sessionId", id);
    	}
		
		model.addAttribute("vo", vo);
		model.addAttribute("fList", fList);
		
		model.addAttribute("main_html", "culture/detail");
		return "main/main";
	}
}
