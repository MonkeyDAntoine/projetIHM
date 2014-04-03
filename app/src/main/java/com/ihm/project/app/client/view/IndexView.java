package com.ihm.project.app.client.view;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHTML;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.Widget;
import com.ihm.project.app.client.presenter.IndexPresenter;

public class IndexView extends Composite implements IndexPresenter.Display {

//	private static IndexViewUiBinder uiBinder = GWT
//			.create(IndexViewUiBinder.class);
//
//	interface IndexViewUiBinder extends UiBinder<Widget, IndexView> {
//	}

	public IndexView() {
		// initWidget(uiBinder.createAndBindUi(this));
		this.whatDoesTheProfSay = new RichTextArea();
		super.initWidget(this.whatDoesTheProfSay);
	}
	
	// @UiField
	private final RichTextArea whatDoesTheProfSay;

	@Override
	public Widget getProfSpeechWidget() {
		return this.whatDoesTheProfSay;
	}

	@Override
	public HasHTML getProfSpeechText() {
		return this.whatDoesTheProfSay;
	}

	

}
