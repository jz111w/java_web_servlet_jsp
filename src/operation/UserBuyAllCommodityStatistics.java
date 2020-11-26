package operation;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HistoryDao;
import dao.SalesDao;
import dao.ShoppingDao;
import entity.History;
import entity.Sales;
import entity.Shoppingcart;

/**
 * Servlet implementation class UserBuyAllCommodityStatistics
 */
@WebServlet("/ubacs")
public class UserBuyAllCommodityStatistics extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserBuyAllCommodityStatistics() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		ServletContext servletContext = getServletContext();
		String username = (String) servletContext.getAttribute("uuu");

		ArrayList<Shoppingcart> list = ShoppingDao.selectByUsername(username);

		for (Shoppingcart i : list) {
			String id = i.getId();
			Sales sale = SalesDao.selectByid(id);
			int j = sale.getnnn();
			String time = i.getNum();

			History history = new History(time, username, id);
			history.setTime();
			HistoryDao.insert(history);
			SalesDao.update(id, j + 1);
		}
		response.sendRedirect("./udas");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
