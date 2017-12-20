package cn.e3mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.page.DataGridResult;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemExample;
import cn.e3mall.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper tbItemMapper;

	@Override
	public TbItem findById(Long id) {
		return tbItemMapper.selectByPrimaryKey(536563l);
	}

	/**
	 * 使用分页插件查询
	 */
	@Override
	public DataGridResult findAll(int page, int rows) {
		DataGridResult result = new DataGridResult();
		/**
		 * 设置分页信息
		 * 	参数1：页码pageNum
		 *	参数2：页面记录数pageSize
		 */
		PageHelper.startPage(page, rows);
		/**
		 * 第一条查询语句，带有分页
		 * 	查询所有时，条件可以为空的example对象，但不能为null
		 */
		TbItemExample example = new TbItemExample();
		List<TbItem> resultRows = tbItemMapper.selectByExample(example);
		/**
		 * 包装查询结果resultRows
		 */
		PageInfo<TbItem> pageInfo = new PageInfo<>(resultRows);
		long total = pageInfo.getTotal();
		
		result.setTotal(total);
		result.setRows(resultRows);
		
		return result;
	}

}
