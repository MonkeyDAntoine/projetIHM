package com.ihm.project.app.client.presenter;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;
import com.ihm.project.app.client.service.ListenProfServiceAsync;

public class IndexPresenter {

	private Display view;
	private ListenProfServiceAsync listenProfService;
	private EventBus eventBus;

	public static interface Display {
		public Widget getProfSpeechWidget();

		public HasText getProfSpeechText();
	}

	public IndexPresenter(Display view, ListenProfServiceAsync listenProfService, EventBus eventBus) {
		this.view = view;
		this.listenProfService = listenProfService;
		this.eventBus = eventBus;
	}

	public void bind() {
		
	}

}
