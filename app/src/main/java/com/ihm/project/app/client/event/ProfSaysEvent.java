package com.ihm.project.app.client.event;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.user.client.Window;

public class ProfSaysEvent extends GwtEvent<ProfSaysEventHandler> {

	private String sentence;

	public static Type<ProfSaysEventHandler> TYPE = new Type<ProfSaysEventHandler>();

	public ProfSaysEvent(String sentence) {
		this.sentence = sentence;
	}
	
	@Override
	public Type<ProfSaysEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(final ProfSaysEventHandler handler) {
		try {
			handler.onUserSays(this);
		} catch (final Exception e) {
			Window.alert(e.getMessage());
		}
	}

	public String getSentence() {
		return sentence;
	}

	public void setSentence(String sentence) {
		this.sentence = sentence;
	}

}