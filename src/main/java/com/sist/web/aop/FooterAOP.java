package com.sist.web.aop;

import java.util.List;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.sist.web.service.ContentsService;
import com.sist.web.vo.ContentsVO;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Aspect
@Component
@RequiredArgsConstructor
public class FooterAOP {
	private final ContentsService cService;
	
	@After("execution(* com.sist.web.controller.*Controller.*(..))")
	public void after() {
		
		HttpServletRequest request=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		List<ContentsVO> tList=cService.contentsTop10();
		
		request.setAttribute("tList", tList);
	}
}
