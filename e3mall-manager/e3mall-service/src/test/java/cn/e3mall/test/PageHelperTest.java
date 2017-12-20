package cn.e3mall.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;

public class PageHelperTest {

	@Test
	public void testPageHelper() {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext*.xml");
		TbItemMapper tbItemMapper = context.getBean(TbItemMapper.class);
		PageHelper.startPage(1, 10);
		List<TbItem> rows = tbItemMapper.selectByExample(null);
		PageInfo<TbItem> pageInfo = new PageInfo<>(rows);
		System.out.println(pageInfo.getTotal());
		System.out.println(pageInfo.getPages());
		System.out.println(rows.size());
	}
}
