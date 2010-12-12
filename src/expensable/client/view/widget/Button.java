package expensable.client.view.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Focusable;
import com.google.gwt.user.client.ui.HasHTML;
import com.google.gwt.user.client.ui.Widget;

public class Button extends Composite implements Focusable, HasClickHandlers, HasHTML {

  private static Binder uiBinder = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, Button> {
  }

  @UiField com.google.gwt.user.client.ui.Button button;

  public Button() {
    initWidget(uiBinder.createAndBindUi(this));
  }

  public Button(String text) {
    this();
    button.setText(text);
  }

  @Override
  public int getTabIndex() {
    return button.getTabIndex();
  }

  @Override
  public void setAccessKey(char key) {
    button.setAccessKey(key);
  }

  @Override
  public void setFocus(boolean focused) {
    button.setFocus(focused);
  }

  @Override
  public void setTabIndex(int index) {
    button.setTabIndex(index);
  }

  @Override
  public void fireEvent(GwtEvent<?> event) {
    button.fireEvent(event);
  }

  @Override
  public HandlerRegistration addClickHandler(ClickHandler handler) {
    return button.addClickHandler(handler);
  }

  @Override
  public String getText() {
    return button.getText();
  }

  @Override
  public void setText(String text) {
    button.setText(text);
  }

  @Override
  public String getHTML() {
    return button.getHTML();
  }

  @Override
  public void setHTML(String html) {
    button.setHTML(html);
  }

}
