package com.vtence.mario;

import org.junit.Test;

import static org.hamcrest.Matchers.containsString;
import static org.openqa.selenium.By.id;

public class InteractionsTest extends WebTest {

    @Test public void
    initiatingDynamicBehaviourWithUserAction() {
        open("button-click.html");

        browser.element(id("button")).click();
        browser.element(id("display")).hasText(containsString("Success!"));
    }

    @Test public void
    interactingWithDynamicContent() {
        open("dynamic-button.html");

        browser.element(id("display")).hasText("Waiting to start");
        browser.element(id("start")).click();
        browser.element(id("display")).hasText("In progress...");
        browser.element(id("stop")).click();
        browser.element(id("display")).hasText("Stopped.");
    }

    @Test public void
    typingText() {
        open("text-entry.html");

        browser.element(id("input")).type("hello world\n");
        browser.element(id("reversed")).hasText("dlrow olleh");
    }

    @Test public void
    revealingThenInteractingWithAnHiddenElement() {
        open("hover-menu.html");

        browser.element(id("menu")).moveMouseToCenter();
        browser.element(id("button")).click();
        browser.element(id("display")).hasText("Success!");
    }
}
