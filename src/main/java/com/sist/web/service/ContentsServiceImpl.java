package com.sist.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sist.web.mapper.ContentsMapper;
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

}
