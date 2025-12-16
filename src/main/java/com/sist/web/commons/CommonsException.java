package com.sist.web.commons;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

// @Controller에서 발생 예외를 처리 = 공통 기반
@ControllerAdvice
public class CommonsException {
	
	@ExceptionHandler(NoResourceFoundException.class)
    public void noResource(NoResourceFoundException ex) {
        // 404 정적리소스 누락은 보통 무시 (로그 안 찍음)
    }
	// 예외만 가능 => 수정이 가능한 에러
	@ExceptionHandler(Exception.class)
	public void exception(Exception ex) {
		System.out.println("=========== Exception 발생 ===========");
		ex.printStackTrace();
	}
	
	// 예외 + 에러 (수정이 불가능한 에러)
	@ExceptionHandler(Throwable.class)
	public void throwable(Throwable ex) {
		System.out.println("=========== Throwable 발생 ===========");
		ex.printStackTrace();
	}
}
