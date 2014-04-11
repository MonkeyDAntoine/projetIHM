package com.ihm.project.app.client.widgets;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;

public class PopupInfos extends PopupPanel {

	private final List<Label> infos;
	private final FlowPanel container;

	public PopupInfos() {
		this.infos = new ArrayList<Label>();
		this.container = new FlowPanel();
		initPopup();
	}

	public PopupInfos(final String tooltipInfos) {
		this();
		addTooltipInfos(tooltipInfos);
	}

	private void initPopup() {
		this.setAnimationEnabled(true);
		this.setAutoHideEnabled(true);
		this.setHeight("100px");
		this.setWidth("200px");
		this.add(this.container);
	}

	public void addTooltipInfos(final String text) {
		Label toAdd = new Label(text);
		this.infos.add(toAdd);
		this.container.add(toAdd);
	}

}
