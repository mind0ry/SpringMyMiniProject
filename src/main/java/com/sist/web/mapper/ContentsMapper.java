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
}
