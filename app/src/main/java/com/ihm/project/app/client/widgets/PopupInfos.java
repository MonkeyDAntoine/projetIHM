package com.ihm.project.app.client.widgets;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;

public class PopupInfos extends PopupPanel {

	private String infos;

	public PopupInfos(final String infos) {
		initPopup();
		this.setInfo(infos);
	}

	private void initPopup() {
		this.setAnimationEnabled(true);
		this.setAutoHideEnabled(true);
		this.setHeight("100px");
		this.setWidth("200px");
	}

	private void setInfo(final String infos){
		this.infos = infos;
		this.add(new Label(infos));
	}

}
