package com.practicas.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.practicas.servlet.controller.MainController;

@WebServlet(name = "MainServlet", urlPatterns = {
		"/cars" }, initParams = @WebInitParam(name = "location", value = "Hola"), loadOnStartup = 1)
public class MainServlet extends AbstractServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//String location = getInitParameter("location");

		String action = request.getParameter("action");
		String filterMake = request.getParameter("filterMake");
		String filterYear = request.getParameter("filterYear");
		String filterHybrid = request.getParameter("filterHybrid");
		String filterClassification = request.getParameter("filterClassification");
		String sortYear = request.getParameter("sortYear");
		String sortMake = request.getParameter("sortMake");
		String carId = request.getParameter("id");
		String ajax = request.getParameter("ajax");
		
		request.setAttribute("years", carService.getCarsYears());
		request.setAttribute("makes", carService.getCarsMakes());
		request.setAttribute("classifications", carService.getCarsClassifications());
		if(ajax!=null && ajax.equals("onlineusers")) {
			request.getRequestDispatcher("./ajax.jsp").forward(request, response);
		}else if(request.getParameter("parse") != null && request.getParameter("parse").equals("json")) {
			request.getRequestDispatcher("./json.jsp").forward(request, response);
		}else if(request.getParameter("display") != null && request.getParameter("display").equals("datatable")) {
			request.getRequestDispatcher("./datatable.jsp").forward(request, response);
		}else if(carId != null) {
			mainController.carView(request, response);
			request.getRequestDispatcher("./view.jsp").forward(request, response);
		} else if ((action == null || action.equals("")) && (filterMake == null && filterYear == null
				&& filterHybrid == null && filterClassification == null && sortYear == null && sortMake == null)) {
			mainController.mainAction(request, response);
			request.getRequestDispatcher("./index.jsp").forward(request, response);
		} else if ("pagination".contentEquals(action) && (filterMake == null && filterYear == null
				&& filterHybrid == null && filterClassification == null && sortYear == null && sortMake == null)) {
			mainController.pagination(request, response);
			request.getRequestDispatcher("./index.jsp").forward(request, response);
		} else if (filterMake != null || filterYear != null || filterHybrid != null
				|| filterClassification != null && sortYear != null && sortMake != null) {
			mainController.filters(request, response);
			request.getRequestDispatcher("./index.jsp").forward(request, response);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		super.doPost(request, response);

	}

}
