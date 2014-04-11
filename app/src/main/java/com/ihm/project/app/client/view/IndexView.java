package com.ihm.project.app.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseMoveHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasHTML;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.Widget;
import com.ihm.project.app.client.presenter.IndexPresenter;
import com.ihm.project.app.client.widgets.PopupInfos;
import com.ihm.project.app.client.widgets.TagCloud;
import com.ihm.project.app.client.widgets.WordTag;

public class IndexView extends Composite implements IndexPresenter.Display {

	private static IndexViewUiBinder uiBinder = GWT
			.create(IndexViewUiBinder.class);

	interface IndexViewUiBinder extends UiBinder<Widget, IndexView> {
	}

	public IndexView() {
		initWidget(uiBinder.createAndBindUi(this));
		addTagCloudTest();

	}
	
	@UiField
	RichTextArea whatDoesTheProfSay;

	@UiField
	FlowPanel container;

	@Override
	public Widget getProfSpeechWidget() {
		return this.whatDoesTheProfSay;
	}

	@Override
	public HasHTML getProfSpeechText() {
		return this.whatDoesTheProfSay;
	}

	public void addTagCloudTest() {

		final TagCloud tagCloud = new TagCloud();
		tagCloud.setColored(true);

		{
			WordTag one = new WordTag("one");
			one.setNumberOfOccurences(1);
			tagCloud.addWord(one);
		}

		{
			WordTag two = new WordTag("two");
			final PopupInfos popupInfos = new PopupInfos("FUCK OFF");
			two.getWord().addMouseOverHandler(new MouseOverHandler() {

				@Override
				public void onMouseOver(final MouseOverEvent arg0) {
					if (!popupInfos.isShowing()) {
						popupInfos.show();
					}
				}
			});
			
			two.getWord().addMouseOutHandler(new MouseOutHandler() {
				
				@Override
				public void onMouseOut(final MouseOutEvent arg0) {
					popupInfos.hide();					
				}
			});
			
			two.getWord().addMouseMoveHandler(new MouseMoveHandler() {

				@Override
				public void onMouseMove(final MouseMoveEvent arg0) {
					popupInfos.setPopupPosition(arg0.getClientX(),
							arg0.getClientY());
				}
			});

			two.setNumberOfOccurences(2);
			tagCloud.addWord(two);
		}

		{
			WordTag three = new WordTag("three");
			three.setNumberOfOccurences(3);
			tagCloud.addWord(three);
		}

		container.add(tagCloud);

	}
}
