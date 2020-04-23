package com.jtudy.jee8.servlet4;

import java.io.IOException;
import java.util.concurrent.Executors;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/async"}, asyncSupported = true)
public class SimpleAsyncServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public SimpleAsyncServlet() {
		super();
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AsyncContext ac = request.startAsync();

		ac.addListener(new AsyncListener() {
			@Override
			public void onComplete(AsyncEvent event) throws IOException {
				event.getSuppliedResponse().getWriter().println("onComplete");
			}

			@Override
			public void onTimeout(AsyncEvent event) throws IOException {
				event.getSuppliedResponse().getWriter().println("onTimeout");
				event.getAsyncContext().complete();
			}

			@Override
			public void onError(AsyncEvent event) throws IOException {
				event.getSuppliedResponse().getWriter().println("onError");
			}

			@Override
			public void onStartAsync(AsyncEvent event) throws IOException {
				event.getSuppliedResponse().getWriter().println("onStartAsync");
			}
		});	
		Executors.newCachedThreadPool().submit(new LongRunningAsyncService(ac));
	}

	class LongRunningAsyncService implements Runnable {

		AsyncContext ac;

		public LongRunningAsyncService(AsyncContext ac) {
			this.ac = ac;
		}

		@Override
		public void run() {
			try {
				ac.getResponse().getWriter().println("Running inside LongRunningAsyncService");
				long res = 1;
				for(long l = 0; l < 900000000L; l++) {
					res = res * l * l;
				}
				ac.getResponse().getWriter().println("Running inside LongRunningAsyncService after long running");
			} catch (Exception e) {
				throw new IllegalStateException(e);
			}
			ac.complete();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
		System.out.println("Servlet returns.");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
		System.out.println("Servlet returns.");
	}

}
