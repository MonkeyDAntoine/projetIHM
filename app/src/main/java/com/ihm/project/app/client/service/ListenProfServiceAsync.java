package com.ihm.project.app.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ListenProfServiceAsync {

	void listen(AsyncCallback<String> callback);

}
