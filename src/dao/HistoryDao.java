package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.History;

public class HistoryDao {
	public static int insert(History history) {
		String sql = "INSERT INTO history VALUE(?,?,?,?);";

		Object[] params = { history.getTime(), history.getUsername(), history.getId(), history.getNo() };
		return BaseDao.exectuIUD(sql, params);
	}

	public static ArrayList<History> showAll() {
		ArrayList<History> list = new ArrayList<History>();

		ResultSet resultSet = null;

		Connection connection = BaseDao.getConnection();

		PreparedStatement preparedStatement = null;

		String sql = "SELECT * FROM history;";

		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				History history = new History(resultSet.getString("time"), resultSet.getString("username"),
						resultSet.getString("id"), resultSet.getString("no"));
				list.add(history);
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
