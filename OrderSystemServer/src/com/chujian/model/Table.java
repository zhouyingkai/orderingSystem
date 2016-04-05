package com.chujian.model;
/**
 * 
 * @author 周映凯
 *餐桌实体类
 */
public class Table {
	private int tableId;
	private String tableName;
	private int tableCapacity;
	private int tableStatus;
	
	public Table() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Table(String tableName, int tableCapacity, int tableStatus) {
		super();
		this.tableName = tableName;
		this.tableCapacity = tableCapacity;
		this.tableStatus = tableStatus;
	}

	public Table(int tableId, String tableName, int tableCapacity,
			int tableStatus) {
		super();
		this.tableId = tableId;
		this.tableName = tableName;
		this.tableCapacity = tableCapacity;
		this.tableStatus = tableStatus;
	}

	public int getTableId() {
		return tableId;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public int getTableCapacity() {
		return tableCapacity;
	}

	public void setTableCapacity(int tableCapacity) {
		this.tableCapacity = tableCapacity;
	}

	public int getTableStatus() {
		return tableStatus;
	}

	public void setTableStatus(int tableStatus) {
		this.tableStatus = tableStatus;
	}
	
	
}
