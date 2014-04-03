package com.ihm.project.app.client.service;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ListenProfServiceAsync {

	void listen(AsyncCallback<List<String>> callback);

}
