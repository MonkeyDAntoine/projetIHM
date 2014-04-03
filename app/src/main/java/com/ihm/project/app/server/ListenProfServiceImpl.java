package com.ihm.project.app.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.ihm.project.app.client.service.ListenProfService;

@SuppressWarnings("serial")
public class ListenProfServiceImpl extends RemoteServiceServlet implements
		ListenProfService {

	@Override
	public String listen() {
		try {
			Thread.sleep(2000);
			return "hey";
		} catch (InterruptedException e) {
			return e.getMessage();
		}
	}

}
