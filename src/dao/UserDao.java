package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.User;

public class UserDao {
	public static int insert(User user) {
		String sql = "INSERT INTO USER VALUE(?,?,?);";

		Object[] params = { user.getUsername(), user.getPassword(), user.getEmail() };
		return BaseDao.exectuIUD(sql, params);
	}

	public static ArrayList<User> showAll() {
		ArrayList<User> list = new ArrayList<User>();

		ResultSet resultSet = null;

		Connection connection = BaseDao.getConnection();

		PreparedStatement preparedStatement = null;

		String sql = "SELECT * FROM USER;";

		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				User user = new User(resultSet.getString("username"), resultSet.getString("password"),
						resultSet.getString("email"));
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(resultSet, preparedStatement, connection);
		}

		return list;
	}

	public static User selectByUsername(String name) {
		User user = null;

		ResultSet resultSet = null;

		Connection connection = BaseDao.getConnection();

		PreparedStatement preparedStatement = null;

		String sql = "SELECT * FROM USER WHERE username=?;";

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				user = new User(resultSet.getString("username"), resultSet.getString("password"),
						resultSet.getString("email"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(resultSet, preparedStatement, connection);
		}

		return user;
	}

	public static int update(User user) {
		String sql = "UPDATE USER SET PASSWORD=? ,email=? WHERE username=?;";

		Object[] params = { user.getPassword(), user.getEmail(), user.getUsername() };
		return BaseDao.exectuIUD(sql, params);
	}

	public static int delete(String username) {
		ShoppingDao.deleteAll(username);
		String sql = "DELETE FROM USER WHERE username=?;";

		Object[] params = { username };
		return BaseDao.exectuIUD(sql, params);
	}

}
