package com.vtence.mario;

import org.hamcrest.Description;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;

public class ElementLocationProbe extends ElementProbe {
    private Coordinates center;

    public ElementLocationProbe(ElementSelector selector) {
        super(selector);
    }

    protected void probe(WebElement found) {
        if (found instanceof Locatable) {
            center = ((Locatable) found).getCoordinates();
        }
    }

    public Coordinates center() {
        return center;
    }

    public boolean isSatisfied() {
        return center != null;
    }

    public void describeTo(Description description) {
        description.appendText("locate center of ");
        super.describeTo(description);
    }

    public void describeFailureTo(Description description) {
        if (!super.isSatisfied()) {
            super.describeFailureTo(description);
        } else {
            description.appendText("element was not locatable");
        }
    }
}
