package com.sist.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.web.service.ContentsService;
import com.sist.web.vo.ContentsVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {
	private final ContentsService cService;

	@GetMapping("/")
	public String main_page(Model model) {
		
		List<ContentsVO> rList=cService.contentsRecent3();
		List<ContentsVO> tList=cService.contentsTop10();
		
		model.addAttribute("rList", rList);
		model.addAttribute("tList", tList);
		
		model.addAttribute("main_html", "main/home");
		return "main/main";
	}
}
