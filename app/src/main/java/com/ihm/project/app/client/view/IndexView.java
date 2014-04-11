package com.ihm.project.app.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.Widget;
import com.ihm.project.app.client.presenter.IndexPresenter;
import com.ihm.project.app.client.widgets.RichTextToolbar;
import com.ihm.project.app.client.widgets.TagCloud;

public class IndexView extends Composite implements IndexPresenter.Display {

	private static IndexViewUiBinder uiBinder = GWT
			.create(IndexViewUiBinder.class);

	interface IndexViewUiBinder extends UiBinder<Widget, IndexView> {
	}

	private RichTextToolbar richTextToolbar;

	private RichTextArea richTextArea;

	private TagCloud tagCloud;


	public IndexView() {
		initWidget(uiBinder.createAndBindUi(this));
		addRichTextArea();
		addTagCloud();

	}

	@UiField
	FlowPanel container;

	private void addRichTextArea() {
		richTextArea = new RichTextArea();
		richTextArea.setSize("100%", "14em");
		richTextToolbar = new RichTextToolbar(richTextArea);
		richTextToolbar.setWidth("100%");
		 Grid grid = new Grid(2, 1);
	    grid.setStyleName("cw-RichText");
	    grid.setWidget(0, 0, richTextToolbar);
	    grid.setWidget(1, 0, richTextArea);
		this.container.add(grid);
	}

	private void addTagCloud() {
		tagCloud = new TagCloud();
		this.container.add(tagCloud);
	}

	@Override
	public TagCloud getCloudTag() {
		return this.tagCloud;
	}
}
