package com.ihm.project.app.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;


public interface NoteAppResources extends ClientBundle {

	NoteAppResources INSTANCE = GWT.create(NoteAppResources.class);

	@Source("css/RichTextToolbar.css")
	RichTextToolbarCss css();

}
