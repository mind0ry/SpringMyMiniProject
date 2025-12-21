package com.sist.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.web.service.ContentsService;
import com.sist.web.service.CultureService;
import com.sist.web.service.FoodService;
import com.sist.web.vo.ContentsVO;
import com.sist.web.vo.CultureVO;
import com.sist.web.vo.FoodVO;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {
	private final ContentsService cService;
	private final FoodService fService;
	private final CultureService cuService;

	@GetMapping("/")
	public String main_page(Model model, HttpSession session) {
		
		String address=(String)session.getAttribute("address");
		
		List<ContentsVO> rList=cService.contentsRecent3();
		List<ContentsVO> tList=cService.contentsTop10();
		List<CultureVO> cList=cuService.cultureMain();
		
		if(address==null) {
			List<FoodVO> mfList=fService.myNearFoodHouse("서울");
			model.addAttribute("sessionAddr", "");
			model.addAttribute("mfList", mfList);
    	} else {
    		List<FoodVO> mfList=fService.myNearFoodHouse(address);
    		model.addAttribute("sessionAddr", address);
    		model.addAttribute("mfList", mfList);
    	}
		
		model.addAttribute("rList", rList);
		model.addAttribute("tList", tList);
		model.addAttribute("cList", cList);
		
		model.addAttribute("main_html", "main/home");
		return "main/main";
	}
}
