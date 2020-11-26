package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Sales;

public class SalesDao {
	public static int insert(String id) {
		String sql = "INSERT INTO sales VALUE(?,\"0\");";

		Object[] params = { id };
		return BaseDao.exectuIUD(sql, params);
	}

	public static int update(String id, int i) {
		String sql = "UPDATE  sales set nnn=? where id=?;";

		Object[] params = { i, id };
		return BaseDao.exectuIUD(sql, params);
	}

	public static int delete(String id) {
		String sql = "DELETE FROM sales WHERE id=?;";

		Object[] params = { id };
		return BaseDao.exectuIUD(sql, params);
	}

	public static Sales selectByid(String id) {
		Sales sales = null;

		ResultSet resultSet = null;

		Connection connection = BaseDao.getConnection();

		PreparedStatement preparedStatement = null;

		String sql = "SELECT * FROM sales WHERE id=?;";

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				sales = new Sales(resultSet.getString("id"), resultSet.getInt("nnn"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(resultSet, preparedStatement, connection);
		}

		return sales;
	}

	public static ArrayList<Sales> showAll() {
		ArrayList<Sales> list = new ArrayList<Sales>();

		ResultSet resultSet = null;

		Connection connection = BaseDao.getConnection();

		PreparedStatement preparedStatement = null;

		String sql = "SELECT * FROM sales;";

		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Sales sales = new Sales(resultSet.getString("id"), resultSet.getInt("nnn"));
				list.add(sales);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(resultSet, preparedStatement, connection);
		}

		return list;
	}
}
