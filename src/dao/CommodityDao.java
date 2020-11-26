package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Commodity;

public class CommodityDao {
	public static ArrayList<Commodity> showAll() {
		ArrayList<Commodity> list = new ArrayList<Commodity>();

		ResultSet resultSet = null;

		Connection connection = BaseDao.getConnection();

		PreparedStatement preparedStatement = null;

		String sql = "SELECT * FROM commodity;";

		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Commodity commodity = new Commodity(resultSet.getString("id"), resultSet.getString("price"),
						resultSet.getString("name"), resultSet.getString("type"), resultSet.getString("brand"),
						resultSet.getString("image"));
				list.add(commodity);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(resultSet, preparedStatement, connection);
		}

		return list;
	}

	public static Commodity selectByid(String id) {
		Commodity commodity = null;

		ResultSet resultSet = null;

		Connection connection = BaseDao.getConnection();

		PreparedStatement preparedStatement = null;

		String sql = "SELECT * FROM commodity WHERE id=?;";

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				commodity = new Commodity(resultSet.getString("id"), resultSet.getString("price"),
						resultSet.getString("name"), resultSet.getString("type"), resultSet.getString("brand"),
						resultSet.getString("image"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(resultSet, preparedStatement, connection);
		}

		return commodity;
	}

	public static int update(Commodity commodity) {
		String sql = "UPDATE commodity SET price=?,NAME=?,TYPE=?,brand=?,image=? WHERE id=?;";

		Object[] params = { commodity.getPrice(), commodity.getName(), commodity.getType(), commodity.getbrand(),
				commodity.getImage(), commodity.getId() };
		return BaseDao.exectuIUD(sql, params);
	}

	public static int insert(Commodity commodity) {
		String sql = "INSERT INTO commodity VALUE(?,?,?,?,?,?);";

		Object[] params = { commodity.getId(), commodity.getPrice(), commodity.getName(), commodity.getType(),
				commodity.getbrand(), commodity.getImage() };

		SalesDao.insert(commodity.getId());
		return BaseDao.exectuIUD(sql, params);
	}

	public static int delete(String id) {
		String sql = "DELETE FROM commodity WHERE id=?;";

		Object[] params = { id };

		SalesDao.delete(id);
		return BaseDao.exectuIUD(sql, params);
	}
}
