package cn.e3mall.content.service;

import cn.e3mall.common.pojo.DataGridResult;

public interface ContentService {

	DataGridResult getContentByCategoryId(Long categoryId, int page, int rows);

}
