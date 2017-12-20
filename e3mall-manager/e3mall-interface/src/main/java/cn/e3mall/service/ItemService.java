package cn.e3mall.service;

import cn.e3mall.page.DataGridResult;
import cn.e3mall.pojo.TbItem;

public interface ItemService {

	TbItem findById(Long id);
	
	DataGridResult findAll(int page, int rows);
}
