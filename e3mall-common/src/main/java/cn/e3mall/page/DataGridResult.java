package cn.e3mall.page;

import java.util.List;

/**
 * DataGrid表格数据封装pojo 格式一致，且所有的DataGrid都会用到这种数据类型，所以封装到common工程下
 * 
 * @author MAXIAO
 *
 */
public class DataGridResult {

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
