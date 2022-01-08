package com.andios.tourism.common;

import com.andios.tourism.enu.ResponseEnum;
import com.baomidou.mybatisplus.plugins.Page;
import lombok.Data;

import java.io.Serializable;

@Data

// @NoArgsConstructor
public class PageResponse<T>  implements Serializable {

	private static final long serialVersionUID = 5263929449909418122L;

	private T data;


	private int total;

	private int pages;


	private int pageNum;

	private int pageSize;

	private String code;
	private String msg;

	public static <T> PageResponse<T> successOfPage(T t, Page page){
		PageResponse<T> PageResponse = new PageResponse<>();
		PageResponse.setData(t);
		PageResponse.setTotal(page.getTotal());//总条数
		PageResponse.setPages(page.getPages());//总页数
		PageResponse.setPageNum(page.getCurrent());//当前页数
		PageResponse.setPageSize(page.getSize());//每页条数
		return PageResponse;
	}


    public static<T> PageResponse<T> message(ResponseEnum zwsj) {
		PageResponse<T> PageResponse = new PageResponse<>();
		PageResponse.setCode(zwsj.getCode());
		PageResponse.setMsg(zwsj.getMsg());
		return PageResponse;
    }
}
