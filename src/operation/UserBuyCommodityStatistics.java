package operation;

import java.io.IOException;

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
 * Servlet implementation class UserBuyCommodityStatistics
 */
@WebServlet("/ubcs")
public class UserBuyCommodityStatistics extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserBuyCommodityStatistics() {
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
		String num = request.getParameter("deletenum");
		servletContext.setAttribute("buynum", num);

		Shoppingcart shoppingcart = ShoppingDao.select(num);
		System.out.print(shoppingcart.toString());
		String id = shoppingcart.getId();
		String time = shoppingcart.getNum();
		String username = shoppingcart.getUsername();

		History history = new History(time, username, id);
		history.setTime();
		HistoryDao.insert(history);
		Sales sale = SalesDao.selectByid(id);
		int i = sale.getnnn();
		SalesDao.update(id, i + 1);
		response.sendRedirect("./uds");

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
