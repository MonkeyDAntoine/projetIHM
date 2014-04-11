package com.ihm.project.app.client.widgets;

import com.google.gwt.user.client.ui.Label;

public class WordTag extends Tag{
	private Label word;
    private String color;
    
    public WordTag() {
        super();
    }

    public WordTag(final String word) {
		this.word = new Label(word);
        numberOfOccurences = 1;
        color=null;
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

}
