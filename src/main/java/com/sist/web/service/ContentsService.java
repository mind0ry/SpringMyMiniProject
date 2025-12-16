package com.sist.web.service;

import java.util.List;

import com.sist.web.vo.ContentsVO;

public interface ContentsService {
	
	public List<ContentsVO> contentsListData(int start);
	public int contentsTotalPage();
}
