package com.ihm.project.app.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.Widget;
import com.ihm.project.app.client.presenter.IndexPresenter;

public class IndexView extends Composite implements IndexPresenter.Display {

	private static IndexViewUiBinder uiBinder = GWT
			.create(IndexViewUiBinder.class);

	interface IndexViewUiBinder extends UiBinder<Widget, IndexView> {
	}

	public IndexView() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	private RichTextArea whatDoesTheProfSay;

	@Override
	public Widget getProfSpeechWidget() {
		return whatDoesTheProfSay;
	}

	@Override
	public HasText getProfSpeechText() {
		return whatDoesTheProfSay;
	}

	

}
