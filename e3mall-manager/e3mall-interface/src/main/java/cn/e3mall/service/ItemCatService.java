package cn.e3mall.service;

import java.util.List;

import cn.e3mall.page.TreeNode;

public interface ItemCatService {

	List<TreeNode> getTreeNodeList(Long parentId);

}