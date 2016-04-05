package com.chujian.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chujian.DBUtil.DBUtil;
import com.chujian.dao.TableDao;
import com.chujian.model.Table;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class TableDaoImpl implements TableDao{

	@Override
	public boolean addNewTable(Table newTable) {
		String sql="insert into table(table_name,table_capacity,table_status)"+"values(?,?,?)";
		Connection conn=DBUtil.getConnection();
		try {
			PreparedStatement ptmt=(PreparedStatement) conn.prepareStatement(sql);
			ptmt.setString(1, newTable.getTableName());
			ptmt.setInt(2, newTable.getTableCapacity());
			ptmt.setInt(3, newTable.getTableStatus());
			
			int count =ptmt.executeUpdate();
			if(count==1){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn);
		}
		return false;
	}

	@Override
	public boolean updateTable(Table table) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteTable(int tableId) {
		// TODO Auto-generated method stub
		String sql="delete from table where table_id=? ";
		Connection conn=DBUtil.getConnection();
		try {
			PreparedStatement ptmt=(PreparedStatement) conn.prepareStatement(sql);
			ptmt.setInt(1, tableId);
			int count=ptmt.executeUpdate();
			if(count==1){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn);
		}
		return false;
	}

	@Override
	public List<Table> queryTableList(int tableCapacity) {
		// TODO Auto-generated method stub
		List<Table> list=new ArrayList<Table>();
		String sql="select * from table where table_capacity=? ";
		Connection conn=DBUtil.getConnection();
		try {
			PreparedStatement ptmt=(PreparedStatement) conn.prepareStatement(sql);
			ptmt.setInt(1, tableCapacity);
			ResultSet rs=ptmt.executeQuery();
			if(rs.next()){
				int tableId=rs.getInt("table_id");
				String tableName=rs.getString("table_name");
//				int tableCapacity=rs.getInt("table_capacity");
				int tableStatus=rs.getInt("table_status");
				
				Table table=new Table(tableId, tableName, tableCapacity, tableStatus);
				list.add(table);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn);
		}
		return list;
	}

	@Override
	public List<Table> queryAll() {
		// TODO Auto-generated method stub
		List<Table> list=new ArrayList<Table>();
		String sql="select * from table ";
		Connection conn=DBUtil.getConnection();
		try {
			PreparedStatement ptmt=(PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs=ptmt.executeQuery();
			if(rs.next()){
				int tableId=rs.getInt("table_id");
				String tableName=rs.getString("table_name");
				int tableCapacity=rs.getInt("table_capacity");
				int tableStatus=rs.getInt("table_status");
				
				Table table=new Table(tableId, tableName, tableCapacity, tableStatus);
				list.add(table);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn);
		}
		return list;
	}

}
