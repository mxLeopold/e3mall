package cn.e3mall.service;

import cn.e3mall.common.pojo.DataGridResult;
import cn.e3mall.common.pojo.E3Result;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemDesc;

public interface ItemService {

	TbItem findById(Long id);
	
	DataGridResult findAll(int page, int rows);

	E3Result save(TbItem item, String desc);
}
