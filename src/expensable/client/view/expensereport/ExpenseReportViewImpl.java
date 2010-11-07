package expensable.client.view.expensereport;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

import expensable.client.mvp.Presenter;

public class ExpenseReportViewImpl extends Composite implements ExpenseReportView, HasText {

  private static Binder uiBinder = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, ExpenseReportViewImpl> {
  }

  public ExpenseReportViewImpl() {
    initWidget(uiBinder.createAndBindUi(this));
  }

  @UiField
  Button button;

  private Presenter presenter;
  
  public ExpenseReportViewImpl(String firstName) {
    initWidget(uiBinder.createAndBindUi(this));
    button.setText(firstName);
  }
  
  @Override
  public void setPresenter(Presenter presenter) {
    this.presenter = presenter;
  }

  @UiHandler("button")
  void onClick(ClickEvent e) {
    Window.alert("Hello!");
  }

  @Override
  public void setText(String text) {
    button.setText(text);
  }

  @Override
  public String getText() {
    return button.getText();
  }

}
