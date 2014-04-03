package com.ihm.project.app.client.service;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("listenProf")
public interface ListenProfService extends RemoteService {

	public List<String> listen() throws Exception;

}
