package com.sist.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.sist.web.vo.BoardVO;
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
	
	@Select("SELECT * FROM board "
			+ "WHERE b_id=#{b_id}")
	public ContentsVO contentsDetailData(String b_id);
	
	@Select("SELECT u_s_com, u_s_zone, u_s_carrer ,u_s_profileimg_url "
			+ "FROM users_seller "
			+ "WHERE u_s_id=#{u_s_id}")
	public ContentsVO getSellerInfo(int u_s_id);
	
	@Select("SELECT b_img_url, rownum FROM board_image "
			+ "WHERE b_id=#{b_id} AND rownum <= 4 "
			+ "ORDER BY b_img_id ASC")
	public List<ContentsVO>  getDetailImg(String b_id);
}
