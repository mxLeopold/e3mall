package cn.e3mall.content.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.e3mall.common.pojo.E3Result;
import cn.e3mall.common.pojo.TreeNode;
import cn.e3mall.content.service.ContentCatService;
import cn.e3mall.mapper.TbContentCategoryMapper;
import cn.e3mall.pojo.TbContentCategory;
import cn.e3mall.pojo.TbContentCategoryExample;
import cn.e3mall.pojo.TbContentCategoryExample.Criteria;

@Service
public class ContentCatServiceImpl implements ContentCatService {

	@Autowired
	private TbContentCategoryMapper contentCatMapper;

	@Override
	public List<TreeNode> getContentCatList(Long parentId) {
		TbContentCategoryExample example = new TbContentCategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbContentCategory> contentCatList = contentCatMapper.selectByExample(example);
		List<TreeNode> list = new ArrayList<>();
		for (TbContentCategory contentCat : contentCatList) {
			TreeNode node = new TreeNode();
			node.setId(contentCat.getId());
			node.setText(contentCat.getName());
			node.setState(contentCat.getIsParent() ? "closed" : "open");
			list.add(node);
		}
		return list;
	}

	@Override
	public E3Result createContentCat(Long parentId, String name) {
		TbContentCategory contentCategory = new TbContentCategory();
		// 保存的contentCategory对象需要持有id
		// 修改mapper映射文件，insert后返回id
		contentCategory.setParentId(parentId);
		contentCategory.setName(name);
		// 1(正常),2(删除)		
		contentCategory.setStatus(1);
		// 默认1
		contentCategory.setSortOrder(1);
		contentCategory.setIsParent(false);
		Date date = new Date();
		contentCategory.setCreated(date);
		contentCategory.setUpdated(date);
		// 保存内容分类对象
		contentCatMapper.insert(contentCategory);
		// 修改id为parentId记录的isParent为1
		TbContentCategory parentCategory = contentCatMapper.selectByPrimaryKey(parentId);
		if(!parentCategory.getIsParent()) {
			parentCategory.setIsParent(true);
			contentCatMapper.updateByPrimaryKey(parentCategory);
		}
		return E3Result.ok(contentCategory);
	}

	@Override
	public void updateContentCat(TbContentCategory contentCategory) {
		contentCatMapper.updateByPrimaryKeySelective(contentCategory);
	}

}
