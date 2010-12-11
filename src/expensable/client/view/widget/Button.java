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

  @UiField com.google.gwt.user.client.ui.Button container;

  public Button() {
    initWidget(uiBinder.createAndBindUi(this));
    container.setText("button");
  }

  public Button(String text) {
    this();
    container.setText(text);
  }

  @Override
  public int getTabIndex() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public void setAccessKey(char key) {
    // TODO Auto-generated method stub

  }

  @Override
  public void setFocus(boolean focused) {
    // TODO Auto-generated method stub
  }

  @Override
  public void setTabIndex(int index) {
    // TODO Auto-generated method stub
  }

  @Override
  public void fireEvent(GwtEvent<?> event) {
    container.fireEvent(event);

  }

  @Override
  public HandlerRegistration addClickHandler(ClickHandler handler) {
    return container.addClickHandler(handler);
  }

  @Override
  public String getText() {
    return container.getText();
  }

  @Override
  public void setText(String text) {
    container.setText(text);
  }

  @Override
  public String getHTML() {
    return container.getHTML();
  }

  @Override
  public void setHTML(String html) {
    container.setHTML(html);
  }

}
