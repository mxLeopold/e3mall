package cn.e3mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.page.DataGridResult;
import cn.e3mall.service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemService itemService;

	/**
	 * 查询所有商品
	 * 	返回值：json格式的
	 * 			{total:"",rows:[{},{}]}
	 * 需要关联依赖common中的pojo
	 */
	@RequestMapping("/list")
	@ResponseBody
	public DataGridResult list(int page, int rows) {
		System.out.println(123);
		DataGridResult result = itemService.findAll(page, rows);
		return result;
	}

}
