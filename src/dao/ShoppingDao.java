package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Shoppingcart;

public class ShoppingDao {
	public static ArrayList<Shoppingcart> selectByUsername(String username) {
		ArrayList<Shoppingcart> list = new ArrayList<Shoppingcart>();

		ResultSet resultSet = null;

		Connection connection = BaseDao.getConnection();

		PreparedStatement preparedStatement = null;

		String sql = "SELECT * FROM shoppingcart WHERE username=?;";

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Shoppingcart shoppingcart = new Shoppingcart(resultSet.getString("username"), resultSet.getString("id"),
						resultSet.getString("price"), resultSet.getString("num"));
				list.add(shoppingcart);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(resultSet, preparedStatement, connection);
		}

		return list;
	}

	public static int insert(Shoppingcart shoppingcart) {
		String sql = "INSERT INTO shoppingcart VALUE(?,?,?,?);";
		System.out.println(shoppingcart.getNum());

		Object[] params = { shoppingcart.getNum(), shoppingcart.getUsername(), shoppingcart.getId(),
				shoppingcart.getPrice() };
		return BaseDao.exectuIUD(sql, params);
	}

	public static int deleteAll(String username) {

		String sql = "DELETE FROM shoppingcart WHERE username=?;";

		Object[] params = { username };
		return BaseDao.exectuIUD(sql, params);
	}

	public static int delete(String num) {
		String sql = "DELETE FROM shoppingcart WHERE num=?;";

		Object[] params = { num };
		return BaseDao.exectuIUD(sql, params);
	}

	public static Shoppingcart select(String num) {
		Shoppingcart shoppingcart = null;

		ResultSet resultSet = null;

		Connection connection = BaseDao.getConnection();

		PreparedStatement preparedStatement = null;

		String sql = "SELECT * FROM shoppingcart WHERE num=?;";

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, num);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				shoppingcart = new Shoppingcart(resultSet.getString("username"), resultSet.getString("id"),
						resultSet.getString("price"), resultSet.getString("num"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(resultSet, preparedStatement, connection);
		}

		return shoppingcart;
	}
}
