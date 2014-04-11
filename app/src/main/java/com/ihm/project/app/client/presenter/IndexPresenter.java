package com.ihm.project.app.client.presenter;

import java.util.Date;
import java.util.List;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.ihm.project.app.client.service.ListenProfServiceAsync;
import com.ihm.project.app.client.widgets.TagCloud;
import com.ihm.project.app.client.widgets.WordTag;

public class IndexPresenter implements Presenter {

	private final Date referenceDate;
	private final Display view;
	private final ListenProfServiceAsync listenProfService;
	private final EventBus eventBus;

	public static interface Display {
		public TagCloud getCloudTag();

		public Widget asWidget();
	}

	public IndexPresenter(final Display view,
			final ListenProfServiceAsync listenProfService,
			final EventBus eventBus) {
		this.view = view;
		this.listenProfService = listenProfService;
		this.eventBus = eventBus;
		this.referenceDate = new Date();
	}

	@Override
	public void bind() {
		listen();
	}

	private void listen() {
		this.listenProfService.listen(new AsyncCallback<List<String>>() {

			@Override
			public void onFailure(final Throwable arg0) {
				Window.alert(arg0.getMessage());
			}

			@Override
			public void onSuccess(final List<String> result) {
				listen();
				if (result.size() > 0 && result.get(0) != null) {
					// Get existing tags
					WordTag wordTag = new WordTag(String.valueOf(result.get(0)));
					IndexPresenter.this.view.getCloudTag().addWord(wordTag,
							getTimeForTooltip() + ": description");
				}
			}
		});
	}

	@Override
	public void go(final HasWidgets container) {
		bind();
		container.clear();
		container.add(this.view.asWidget());
	}

	private String getTimeForTooltip() {
		Date date = new Date();
		String hours = String.valueOf(referenceDate.getHours()
				- date.getHours());
		String minutes = String.valueOf(referenceDate.getMinutes()
				- date.getMinutes());
		String seconds = String.valueOf(referenceDate.getSeconds()
				- date.getSeconds());
		return hours + ":" + minutes + ":" + seconds;
	}

}
