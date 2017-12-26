package cn.e3mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.common.pojo.DataGridResult;
import cn.e3mall.common.pojo.E3Result;
import cn.e3mall.content.service.ContentService;
import cn.e3mall.pojo.TbContent;

@Controller
@RequestMapping("/content")
public class ContentController {

	@Autowired
	private ContentService contentService;

	@RequestMapping("/query/list")
	@ResponseBody
	public DataGridResult getContentByCategoryId(Long categoryId, int page, int rows) {
		return contentService.getContentByCategoryId(categoryId, page, rows);
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public E3Result saveContent(TbContent content) {
		return contentService.saveContent(content);
	}
}
