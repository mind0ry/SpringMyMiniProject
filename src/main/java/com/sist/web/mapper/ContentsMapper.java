package com.sist.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.sist.web.vo.ContentsVO;

@Mapper
@Repository
public interface ContentsMapper {
	
	@Select("SELECT b_id, b_filter, b_thumbnail, b_type, b_title "
			+ "FROM board "
			+ "WHERE b_type = '기타' "
			+ "ORDER BY b_id ASC "
			+ "OFFSET #{start} ROWS FETCH NEXT 12 ROWS ONLY")
	public List<ContentsVO> contentsListData(int start);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM board "
			+ "WHERE b_type = '기타'")
	public int contentsTotalPage();
	
	@Select("SELECT b_id, b_filter, b_thumbnail, b_title "
			+ "FROM board "
			+ "WHERE b_type = '기타' "
			+ "ORDER BY b_createdat DESC "
			+ "OFFSET 0 ROWS FETCH NEXT 4 ROWS ONLY")
	public List<ContentsVO> contentsRecent3();
	
	@Select("SELECT b_id, b_filter, b_thumbnail, b_title "
			+ "FROM board "
			+ "WHERE b_type = '기타' "
			+ "ORDER BY b_view_count DESC "
			+ "OFFSET 0 ROWS FETCH NEXT 10 ROWS ONLY")
	public List<ContentsVO> contentsTop10();
}
