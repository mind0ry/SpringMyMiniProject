package com.sist.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.sist.web.vo.CultureVO;
import com.sist.web.vo.FoodVO;

@Repository
@Mapper
public interface CultureMapper {

	@Select("SELECT no, name, m_cate, main_img, address "
			+ "FROM time_ticket "
			+ "WHERE m_cate = '연극/뮤지컬 - 대학로' or m_cate = '연극/뮤지컬 - 서울' "
			+ "ORDER BY no ASC "
			+ "OFFSET #{start} ROWS FETCH NEXT 8 ROWS ONLY")
	public List<CultureVO> culture1ListData(int start);
	
	@Select("SELECT CEIL(COUNT(*)/8.0) from time_ticket "
			+ "WHERE m_cate = '연극/뮤지컬 - 대학로' or m_cate = '연극/뮤지컬 - 서울'")
	public int culture1TotalPage();
	
	@Select("SELECT no, name, m_cate, main_img, address "
			+ "FROM time_ticket "
			+ "WHERE m_cate = '전시 - 서울' "
			+ "ORDER BY no ASC "
			+ "OFFSET #{start} ROWS FETCH NEXT 8 ROWS ONLY")
	public List<CultureVO> culture2ListData(int start);
	
	@Select("SELECT CEIL(COUNT(*)/8.0) from time_ticket "
			+ "WHERE m_cate = '전시 - 서울'")
	public int culture2TotalPage();
	
	@Select("SELECT no, name, m_cate, main_img, address "
			+ "FROM time_ticket "
			+ "WHERE m_cate = '액티비티 - 서울' "
			+ "ORDER BY no ASC "
			+ "OFFSET #{start} ROWS FETCH NEXT 8 ROWS ONLY")
	public List<CultureVO> culture3ListData(int start);
	
	@Select("SELECT CEIL(COUNT(*)/8.0) from time_ticket "
			+ "WHERE m_cate = '액티비티 - 서울'")
	public int culture3TotalPage();
	
	@Select("SELECT * from time_ticket "
			+ "WHERE no=#{no}")
	public CultureVO cultureDetailData(int no);
	
	@Select("SELECT fno,name,poster,address,rownum "
			  +"FROM food "
			  +"WHERE REGEXP_LIKE(address,#{address}) "
			  +"AND rownum<=6")
	public List<FoodVO> seoulNearFoodHouse(String address);
}