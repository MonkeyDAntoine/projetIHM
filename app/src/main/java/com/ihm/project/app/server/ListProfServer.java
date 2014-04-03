package com.ihm.project.app.server;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.ihm.project.app.client.service.ListenProfService;
import com.ihm.project.app.shared.Listener;

@SuppressWarnings("serial")
public class ListProfServer extends RemoteServiceServlet implements ListenProfService {

	@Override
	public void start(EventBus eventBus) {
		new Thread(new Listener(eventBus)).start();
	}

}
