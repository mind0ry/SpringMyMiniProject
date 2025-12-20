package com.sist.web.service;

import java.util.List;

import com.sist.web.vo.CultureVO;
import com.sist.web.vo.FoodVO;

public interface CultureService {
	
	public List<CultureVO> culture1ListData(int start);
	public int culture1TotalPage();
	public List<CultureVO> culture2ListData(int start);
	public int culture2TotalPage();
	public List<CultureVO> culture3ListData(int start);
	public int culture3TotalPage();
	public CultureVO cultureDetailData(int no);
	public List<FoodVO> seoulNearFoodHouse(String address);
}
