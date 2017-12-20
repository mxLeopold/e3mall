package cn.e3mall.page;

import java.io.Serializable;
import java.util.List;

/**
 * DataGrid表格数据封装pojo 格式一致，且所有的DataGrid都会用到这种数据类型，所以封装到common工程下
 * 且这个类在两个工程中传递，需要实现Serializable序列化接口
 * @author MAXIAO
 *
 */
public class DataGridResult implements Serializable {

	private Long total;
	private List<?> rows;

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

}
