package com.ihm.project.app.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.ui.RootPanel;
import com.ihm.project.app.client.service.ListenProfService;
import com.ihm.project.app.client.service.ListenProfServiceAsync;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class NoteApp implements EntryPoint {

	private ListenProfServiceAsync listenProfService;

	private EventBus eventBus;

	/**
	 * This is the entry point method.
	 */
	@Override
	public void onModuleLoad() {
		this.listenProfService = GWT.create(ListenProfService.class);
		this.eventBus = GWT.create(SimpleEventBus.class);

		AppController appController = new AppController(this.eventBus,
				this.listenProfService);
		appController.go(RootPanel.get());
	}
}
