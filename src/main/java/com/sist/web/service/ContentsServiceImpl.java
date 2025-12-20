package com.sist.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sist.web.mapper.ContentsMapper;
import com.sist.web.vo.BoardVO;
import com.sist.web.vo.ContentsVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContentsServiceImpl implements ContentsService {
	private final ContentsMapper mapper;
	@Override
	public List<ContentsVO> contentsListData(int start) {
		// TODO Auto-generated method stub
		return mapper.contentsListData(start);
	}
	@Override
	public int contentsTotalPage() {
		// TODO Auto-generated method stub
		return mapper.contentsTotalPage();
	}
	@Override
	public List<ContentsVO> contentsRecent3() {
		// TODO Auto-generated method stub
		return mapper.contentsRecent3();
	}
	@Override
	public List<ContentsVO> contentsTop10() {
		// TODO Auto-generated method stub
		return mapper.contentsTop10();
	}
	@Override
	public ContentsVO contentsDetailData(String b_id) {
		// TODO Auto-generated method stub
		return mapper.contentsDetailData(b_id);
	}
	@Override
	public ContentsVO getSellerInfo(int u_s_id) {
		// TODO Auto-generated method stub
		return mapper.getSellerInfo(u_s_id);
	}
	@Override
	public List<ContentsVO> getDetailImg(String b_id) {
		// TODO Auto-generated method stub
		return mapper.getDetailImg(b_id);
	}

}
