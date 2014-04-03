package com.ihm.project.app.client;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;
import com.ihm.project.app.client.presenter.IndexPresenter;
import com.ihm.project.app.client.presenter.Presenter;
import com.ihm.project.app.client.service.ListenProfServiceAsync;
import com.ihm.project.app.client.view.IndexView;

public class AppController implements Presenter, ValueChangeHandler<String> {

	private final EventBus eventBus;
	private final ListenProfServiceAsync listenProfService;
	private HasWidgets container;

	public AppController(final EventBus eventBus,
			final ListenProfServiceAsync listenProfService) {
		this.eventBus = eventBus;
		this.listenProfService = listenProfService;
	}

	@Override
	public void go(final HasWidgets container) {
		this.container = container;

		new IndexPresenter(new IndexView(), this.listenProfService,
				this.eventBus).go(container);
	}

	@Override
	public void bind() {
		History.addValueChangeHandler(this);
		if ("".equals(History.getToken())) {
			History.newItem("index");
		} else {
			History.fireCurrentHistoryState();
		}
	}

	@Override
	public void onValueChange(final ValueChangeEvent<String> event) {
		String token = event.getValue();
		if (token != null) {
			Presenter presenter = null;

			if (token.equals("index")) {
				presenter = new IndexPresenter(new IndexView(),
						this.listenProfService, this.eventBus);
			}

			if (presenter != null) {
				presenter.go(this.container);
			}
		}

	}

}
