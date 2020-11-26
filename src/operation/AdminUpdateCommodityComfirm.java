package operation;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommodityDao;
import entity.Commodity;

/**
 * Servlet implementation class AdminUpdateCommodityComfirm
 */
@WebServlet("/auccm")
public class AdminUpdateCommodityComfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminUpdateCommodityComfirm() {
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

		ServletContext servletContext = request.getServletContext();
		Commodity commodity1 = (Commodity) servletContext.getAttribute("commodity1");

		String id = commodity1.getId();
		String price = request.getParameter("price");
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		String brand = request.getParameter("brand");
		String image = request.getParameter("image");

		Commodity commodity = new Commodity(id, price, name, type, brand, image);
		int c = CommodityDao.update(commodity);

		if (c > 0) {
			response.sendRedirect("./ac");
		} else {
			response.sendRedirect("./AdminUpdateCommodityFailed.html");
		}
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
