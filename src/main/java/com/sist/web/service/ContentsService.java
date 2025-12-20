package com.sist.web.service;

import java.util.List;

import com.sist.web.vo.ContentsVO;

public interface ContentsService {
	
	public List<ContentsVO> contentsListData(int start);
	public int contentsTotalPage();
	public List<ContentsVO> contentsRecent3();
	public List<ContentsVO> contentsTop10();
	public ContentsVO contentsDetailData(String b_id);
	public ContentsVO getSellerInfo(int u_s_id);
	public List<ContentsVO> getDetailImg(String b_id);
}
