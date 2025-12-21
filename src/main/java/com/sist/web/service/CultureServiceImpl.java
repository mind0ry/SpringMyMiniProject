package com.sist.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sist.web.mapper.CultureMapper;
import com.sist.web.vo.CultureVO;
import com.sist.web.vo.FoodVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CultureServiceImpl implements CultureService {
	
	private final CultureMapper mapper;
	
	@Override
	public List<CultureVO> culture1ListData(int start) {
		// TODO Auto-generated method stub
		return mapper.culture1ListData(start);
	}

	@Override
	public int culture1TotalPage() {
		// TODO Auto-generated method stub
		return mapper.culture1TotalPage();
	}
	
	@Override
	public List<CultureVO> culture2ListData(int start) {
		// TODO Auto-generated method stub
		return mapper.culture2ListData(start);
	}

	@Override
	public int culture2TotalPage() {
		// TODO Auto-generated method stub
		return mapper.culture2TotalPage();
	}
	
	@Override
	public List<CultureVO> culture3ListData(int start) {
		// TODO Auto-generated method stub
		return mapper.culture3ListData(start);
	}

	@Override
	public int culture3TotalPage() {
		// TODO Auto-generated method stub
		return mapper.culture3TotalPage();
	}

	@Override
	public CultureVO cultureDetailData(int no) {
		// TODO Auto-generated method stub
		return mapper.cultureDetailData(no);
	}

	@Override
	public List<FoodVO> seoulNearFoodHouse(String address) {
		// TODO Auto-generated method stub
		return mapper.seoulNearFoodHouse(address);
	}

	@Override
	public List<CultureVO> cultureMain() {
		// TODO Auto-generated method stub
		return mapper.cultureMain();
	}

}
