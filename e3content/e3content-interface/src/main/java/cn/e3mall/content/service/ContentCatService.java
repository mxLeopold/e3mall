package cn.e3mall.content.service;

import java.util.List;

import cn.e3mall.common.pojo.E3Result;
import cn.e3mall.common.pojo.TreeNode;
import cn.e3mall.pojo.TbContentCategory;

public interface ContentCatService {

	List<TreeNode> getContentCatList(Long parentId);

	E3Result createContentCat(Long parentId, String name);

	void updateContentCat(TbContentCategory contentCategory);
}
