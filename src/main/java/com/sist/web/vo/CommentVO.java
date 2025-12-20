package com.sist.web.vo;
import java.util.*;

import lombok.Data;

@Data
public class CommentVO {
	private int no,cno,type;
	private String id,name,msg,dbday;
	private Date regdate;
}