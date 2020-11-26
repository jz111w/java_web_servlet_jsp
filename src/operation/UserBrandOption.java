package operation;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Commodity;

/**
 * Servlet implementation class UserBrandOption
 */
@WebServlet("/ubo")
public class UserBrandOption extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserBrandOption() {
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

		String aString = request.getParameter("brandsort");

		ServletContext servletContext = request.getServletContext();
		ArrayList<Commodity> list = (ArrayList<Commodity>) servletContext.getAttribute("alllist");

		ArrayList<Commodity> li = list;
		list = new ArrayList<Commodity>();

		switch (aString) {
		case "0": {
			servletContext.setAttribute("brand", "");
			for (Commodity c : li) {
				list.add(c);
			}
			break;
		}
		case "1": {
			servletContext.setAttribute("brand", "ÂÞ¼¼");
			for (Commodity c : li) {
				if (c.getbrand().equals("ÂÞ¼¼")) {
					list.add(c);
				}
			}
			break;
		}
		case "2": {
			servletContext.setAttribute("brand", "cherry");
			for (Commodity c : li) {
				if (c.getbrand().equals("cherry")) {
					list.add(c);
				}
			}
			break;
		}
		case "3": {
			servletContext.setAttribute("brand", "ikbc");
			for (Commodity c : li) {
				if (c.getbrand().equals("ikbc")) {
					list.add(c);
				}
			}
			break;
		}
		case "4": {
			servletContext.setAttribute("brand", "Varmilo");
			for (Commodity c : li) {
				if (c.getbrand().equals("Varmilo")) {
					list.add(c);
				}
			}
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + aString);
		}

		servletContext.setAttribute("list", list);

		request.getRequestDispatcher("./UserShowCommodity.jsp").forward(request, response);
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
