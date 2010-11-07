/**
 * 
 */
package expensable.client.view.dashboard;

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
import expensable.client.place.ExpenseReportPlace;

/**
 * @author dpurpura
 */
public class DashboardViewImpl extends Composite implements DashboardView, HasText {
  
  private static Binder binder = GWT.create(Binder.class);
  
  interface Binder extends UiBinder<Widget, DashboardViewImpl>{}
  
  private Presenter presenter;

  @UiField Button button;
  @UiField Button reportButton;
  
  public DashboardViewImpl() {
    initWidget(binder.createAndBindUi(this));
  }
  
  public DashboardViewImpl(String firstName) {
    initWidget(binder.createAndBindUi(this));

    // Can access @UiField after calling createAndBindUi
    button.setText(firstName);
  }
  
  @Override
  public Widget asWidget() {
    return this;
  }
  
  @Override
  public void setPresenter(Presenter presenter) {
    this.presenter = presenter;
  }

  @UiHandler("button")
  void onClick(ClickEvent e) {
    Window.alert("Hello!");
  }
  
  @UiHandler("reportButton")
  void goToReport(ClickEvent e) {
    presenter.goTo(new ExpenseReportPlace("id"));
  }

  @Override
  public void setText(String text) {
    button.setText(text);
  }

  /**
   * Gets invoked when the default constructor is called
   * and a string is provided in the ui.xml file.
   */
  @Override
  public String getText() {
    return button.getText();
  }

}
