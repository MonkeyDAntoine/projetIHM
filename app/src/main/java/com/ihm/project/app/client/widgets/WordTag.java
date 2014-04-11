package com.ihm.project.app.client.widgets;

import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseMoveHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.ui.Label;

public class WordTag extends Tag{
	private Label word;
    private String color;
	final PopupInfos popupInfos;
    
	public WordTag(final String word) {
		this.word = new Label(word);
		popupInfos = new PopupInfos("");
		initTooltip();
        numberOfOccurences = 1;
        color=null;
    }

	private void initTooltip() {
		this.word.addMouseOverHandler(new MouseOverHandler() {

			@Override
			public void onMouseOver(final MouseOverEvent arg0) {
				if (!popupInfos.isShowing()) {
					popupInfos.show();
				}
			}
		});

		this.word.addMouseOutHandler(new MouseOutHandler() {

			@Override
			public void onMouseOut(final MouseOutEvent arg0) {
				popupInfos.hide();
			}
		});

		this.word.addMouseMoveHandler(new MouseMoveHandler() {

			@Override
			public void onMouseMove(final MouseMoveEvent arg0) {
				popupInfos.setPopupPosition(arg0.getClientX(),
						arg0.getClientY());
			}
		});
	}

	public Label getWord() {
        return word;
    }

	public void setWord(final Label word) {
        this.word = word;
    }
    
    public String getColor() {
		return color;
	}

	public void setColor(final String color) {
		this.color = color;
	}

	@Override
    public int hashCode() {
        return word.hashCode();
    }
    
    @Override
    public boolean equals(final Object obj) {
        if (!( obj instanceof Tag)){
            return false;
        }
        return word.equals(((WordTag)obj).getWord());
    }

	public void refreshTooltip(final String tooltipDescription) {
		this.popupInfos.addTooltipInfos(tooltipDescription);
	}

}
