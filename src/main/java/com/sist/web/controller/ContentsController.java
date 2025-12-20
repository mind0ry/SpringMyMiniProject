package com.sist.web.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sist.web.service.ContentsService;
import com.sist.web.vo.ContentsVO;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ContentsController {
	private final ContentsService cService;
	
	@GetMapping("/contents/list")
	public String contents_list(@RequestParam(name = "page", required = false) String page, Model model) {
		
		if(page==null) 
			page="1";
		int curpage=Integer.parseInt(page);
		
		int start=(curpage-1)*12;
		List<ContentsVO> list=cService.contentsListData(start);
		int totalpage=cService.contentsTotalPage();
		
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
		
		model.addAttribute("main_html", "contents/list");
		
		return "main/main";
	}
	
	@GetMapping("/contents/detail")
	public String contents_detail(@RequestParam("b_id") String b_id, Model model) {
		
		ContentsVO vo=cService.contentsDetailData(b_id);
		int u_s_id=Integer.parseInt(vo.getU_s_id());
		ContentsVO svo=cService.getSellerInfo(u_s_id);
		List<ContentsVO> list=cService.getDetailImg(b_id);
		
		
		model.addAttribute("vo", vo);
		model.addAttribute("svo", svo);
		model.addAttribute("list", list);
		model.addAttribute("main_html", "contents/detail");
		return "main/main";
	}
}
