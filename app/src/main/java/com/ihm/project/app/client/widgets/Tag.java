package com.ihm.project.app.client.widgets;

import java.io.Serializable;

public abstract class Tag implements Serializable {

    private static final long serialVersionUID = 2153391657389702774L;
    private String id;
    private int orientation;
    
    protected int numberOfOccurences;
    
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL_LEFT = 1;
    public static final int VERTICAL_RIGHT = 2;
    
    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public int getNumberOfOccurences() {
        return numberOfOccurences;
    }
    
    public void setNumberOfOccurences(final int occurency){
        numberOfOccurences = occurency;
    }

    /**
     * Increase the <code>numberOfOccurences</code> variable
     */
    public void increaseNumberOfOccurences() {
        numberOfOccurences++;
    }
    
    @Override
    public abstract int hashCode();
    
    @Override
    public abstract boolean equals(Object obj);

    public void setOrientation(final int orientation) {
        this.orientation = orientation;
    }

    public int getOrientation() {
        return orientation;
    }

}
