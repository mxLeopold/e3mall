package cn.e3mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.common.pojo.E3Result;
import cn.e3mall.common.pojo.TreeNode;
import cn.e3mall.content.service.ContentCatService;
import cn.e3mall.pojo.TbContent;
import cn.e3mall.pojo.TbContentCategory;

@Controller
@RequestMapping("/content/category")
public class ContentCatController {

	@Autowired
	private ContentCatService contentCatService;

	@RequestMapping("/list")
	@ResponseBody
	public List<TreeNode> getContentCatList(@RequestParam(value = "id", defaultValue = "0") Long parentId) {
		return contentCatService.getContentCatList(parentId);
	}

	@RequestMapping("/create")
	@ResponseBody
	public E3Result createContentCat(Long parentId, String name) {
		return contentCatService.createContentCat(parentId, name);
	}
	
	/**
	 * TODO 待完善
	 * @param contentCategory
	 */
	@RequestMapping("/update")
	@ResponseBody
	public E3Result updateContentCat(TbContentCategory contentCategory) {
		return contentCatService.updateContentCat(contentCategory);
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public E3Result deleteContentCat(Long id) {
		return contentCatService.deleteContentCat(id);
	}
}
