package com.ihm.project.app.client.service;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;


public interface ListenProfServiceAsync {

	void start(EventBus eventBus, AsyncCallback<Void> callback);

}
