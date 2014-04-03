package com.ihm.project.app.client.event;

import com.google.gwt.event.shared.EventHandler;

public interface ProfSaysEventHandler extends EventHandler {
	public void onUserSays(ProfSaysEvent event) throws Exception;
}