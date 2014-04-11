package com.ihm.project.app.client.widgets;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;

public class TagCloud extends Composite {

	private final FlowPanel cloud;
	private List<Tag> tags;
	private int maxNumberOfTags;// the number of tags shown in the cloud.
	private double minOccurences, maxOccurences, step;
	private boolean isColored;

	private static final int STEP_NUMBER = 10;

	public TagCloud() {
		cloud = new FlowPanel();
		tags = new ArrayList<Tag>();
		maxNumberOfTags = 20;
		minOccurences = 1;
		maxOccurences = 1;
		step = 1;// 'average' difference between each occurence
		DecoratorPanel dec = new DecoratorPanel();
		dec.setWidget(cloud);
		initWidget(dec);
	}

	/**
	 * Set the whole list of tags given in parameter to be the current tags
	 * list.
	 * 
	 * @param tags
	 */
	public void setTags(final List<Tag> tags) {
		if (this.tags == null)
			this.tags = new ArrayList<Tag>();
		this.tags.clear();
		if (tags != null)
			this.tags.addAll(tags);
	}

	/**
	 * Retrieve the list of tags in the cloud.
	 * 
	 * @return
	 */
	public List<Tag> getTags() {
		return tags;
	}

	/**
	 * Add a word to the tagcloud list.
	 * 
	 * @param word
	 */
	public void addWord(final WordTag word) {
		boolean exist = false;
		for (Tag t : tags) {
			if (((WordTag) t).getWord().getText()
					.equalsIgnoreCase(word.getWord().getText())) {
				t.increaseNumberOfOccurences();
				exist = true;
			}
		}
		if (!exist)
			tags.add(word);
		refresh();
	}

	/**
	 * Refresh the display of the tagcloud. Usually used after an adding or
	 * deletion of word.
	 */
	public void refresh() {
		cloud.clear();
		if (tags != null && !tags.isEmpty()) {
			// recalculate max and min of all occurences
			for (Tag w : tags) {
				if (w.getNumberOfOccurences() > maxOccurences)
					maxOccurences = w.getNumberOfOccurences();
				if (w.getNumberOfOccurences() < minOccurences)
					minOccurences = w.getNumberOfOccurences();
			}

			// a step correspond to a css style.
			step = (maxOccurences - minOccurences) / STEP_NUMBER;

			for (Tag w : tags) {
				Label label = null;
				if (w instanceof WordTag)
					label = getCustomisedLabel((WordTag) w);
				cloud.add(label);
			}
		}
	}

	/**
	 * Create the 'CSS' aspect of the given word thanks the whole minimum,
	 * maximum, and average number of occurences of all words. It create a link
	 * in a span with the appropriate font style/size
	 * 
	 * @param w The Word object to display
	 * @return The InlinHTML object that fits in the cloud
	 */
	private Label getCustomisedLabel(final WordTag w) {
		int nboc = w.getNumberOfOccurences();

		Label label = w.getWord();

		label.setStyleName("gwt-Label");

		label.addStyleName("tag");
		
		if(w.getOrientation() == Tag.VERTICAL_LEFT)
		    label.addStyleName("verticalL");
		else if(w.getOrientation() == Tag.VERTICAL_RIGHT)
		    label.addStyleName("verticalR");

		// Apply the good style corersponding to the number of occurences
		if (nboc >= (maxOccurences - step)) {
			label.addStyleName("tag10");
		} else if (nboc >= (maxOccurences - (step * 2))) {
			label.addStyleName("tag9");
		} else if (nboc >= (maxOccurences - (step * 3))) {
			label.addStyleName("tag8");
		} else if (nboc >= (maxOccurences - (step * 4))) {
			label.addStyleName("tag7");
		} else if (nboc >= (maxOccurences - (step * 5))) {
			label.addStyleName("tag6");
		} else if (nboc >= (maxOccurences - (step * 6))) {
			label.addStyleName("tag5");
		} else if (nboc >= (maxOccurences - (step * 7))) {
			label.addStyleName("tag4");
		} else if (nboc >= (maxOccurences - (step * 8))) {
			label.addStyleName("tag3");
		} else if (nboc >= (maxOccurences - (step * 9))) {
			label.addStyleName("tag2");
		} else if (nboc >= (maxOccurences - (step * 10))) {
			label.addStyleName("tag1");
		}

		// applying color if needed
		if (isColored) {
			if (w.getColor() != null) {
				label.addStyleName(w.getColor());
				return label;
			}
			
			//if no default color is set on the word, apply a random one
			double r = Math.random() * 10;
			int seed = (int) Math.floor(r) + 1;
			switch (seed) {
			case 1:
				label.addStyleName("red");
				break;
			case 2:
				label.addStyleName("orange");
				break;
			case 3:
				label.addStyleName("green");
				break;
			case 4:
				label.addStyleName("lightblue");
				break;
			case 5:
				label.addStyleName("purple");
				break;
			case 6:
				label.addStyleName("blue");
				break;
			case 7:
				label.addStyleName("pink");
				break;
			case 8:
				label.addStyleName("brown");
				break;
			case 9:
				label.addStyleName("lightgrey");
				break;
			case 10:
				label.addStyleName("grey");
				break;
			default:
				label.addStyleName("darkgrey");
				break;
			}
		}

		return label;
	}

	public int getMaxNumberOfWords() {
		return maxNumberOfTags;
	}

	public void setMaxNumberOfWords(final int numberOfWords) {
		this.maxNumberOfTags = numberOfWords;
	}

	public boolean isColored() {
		return isColored;
	}

	/**
	 * Set whither you wan the tags to be colored randomly.
	 * 
	 * @param isColored
	 */
	public void setColored(final boolean isColored) {
		this.isColored = isColored;
		if (this.isColored)
			refresh();
	}
}
