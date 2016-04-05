package com.chujian.dao;

import java.util.List;

import com.chujian.model.Table;

public interface TableDao {
	public boolean addNewTable(Table newTable);
	public boolean updateTable(Table table);
	public boolean deleteTable(int tableId);
	public List<Table> queryTableList(int tableCapacity);
	public List<Table> queryAll();

}
