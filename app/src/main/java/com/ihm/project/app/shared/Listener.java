package com.ihm.project.app.shared;

import com.google.gwt.event.shared.EventBus;
import com.ihm.project.app.client.event.ProfSaysEvent;

public class Listener implements Runnable {

	private EventBus eventBus;

	public Listener(EventBus eventBus) {
		this.eventBus = eventBus;
	}

	@Override
	public void run() {
		while (true) {
			try {
				eventBus.fireEvent(new ProfSaysEvent("Hey !"));
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				eventBus.fireEvent(new ProfSaysEvent(e.getMessage()));
			}
		}
	}

}
