package com.ihm.project.app.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("listenProf")
public interface ListenProfService extends RemoteService {

	public String listen();

}
