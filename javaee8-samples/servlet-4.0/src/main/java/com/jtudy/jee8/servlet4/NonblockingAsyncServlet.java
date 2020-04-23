package com.jtudy.jee8.servlet4;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.concurrent.Executors;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * for read listener example you can examine:
 * https://github.com/javaee-samples/javaee7-samples/tree/master/servlet/nonblocking 
 */
@WebServlet(urlPatterns = { "/nonblocking" }, asyncSupported = true)
public class NonblockingAsyncServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public NonblockingAsyncServlet() {
		super();
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {				
		
		AsyncContext ac = request.startAsync();
		StringWriter sw = new StringWriter();
		final PrintWriter pw = new PrintWriter(sw);
		ac.addListener(new AsyncListener() {
			@Override
			public void onComplete(AsyncEvent event) throws IOException {
				pw.println("onComplete");
				writeResponseNonBlocking(response, sw.toString(), ac);
				event.getAsyncContext().complete();
			}

			@Override
			public void onTimeout(AsyncEvent event) throws IOException {
				pw.println("onTimeout");
				event.getAsyncContext().complete();
			}

			@Override
			public void onError(AsyncEvent event) throws IOException {
				writeResponseNonBlocking(response, "onError", ac);
			}

			@Override
			public void onStartAsync(AsyncEvent event) throws IOException {
				//
			}
		});	
		Executors.newCachedThreadPool().submit(new LongRunningAsyncService(pw));
	}

	private void writeResponseNonBlocking(HttpServletResponse response, String responseString, AsyncContext ac) throws IOException {
		ServletOutputStream out = response.getOutputStream();
		out.setWriteListener(new WriteListener() {
			
			@Override
			public void onWritePossible() throws IOException {
				if(out.isReady()) {
					out.println(responseString);
					ac.complete();
				}
			}
			
			@Override
			public void onError(Throwable throwable) {
				System.err.println(throwable);
				ac.complete();
			}
		});
	}

	class LongRunningAsyncService implements Runnable {

		PrintWriter pw;

		public LongRunningAsyncService(PrintWriter pw) {
			this.pw = pw;
		}

		@Override
		public void run() {
			try {
				pw.println("Running inside LongRunningAsyncService");
				long res = 1;
				for (long l = 0; l < 900000000L; l++) {
					res = res * l * l;
				}
				pw.println("Running inside LongRunningAsyncService after long running");
			} catch (Exception e) {
				throw new IllegalStateException(e);
			}			
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
