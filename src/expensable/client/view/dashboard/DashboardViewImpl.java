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
import com.google.gwt.user.client.ui.Widget;

import expensable.client.place.ExpenseReportsPlace;

/**
 * @author dpurpura
 */
public class DashboardViewImpl extends Composite implements DashboardView {

  private static Binder binder = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, DashboardViewImpl>{}

  private DashboardPresenter presenter;

  @UiField Button reportButton;

  public DashboardViewImpl() {
    initWidget(binder.createAndBindUi(this));
  }

  @Override
  public Widget asWidget() {
    return this;
  }

  @Override
  public void setPresenter(DashboardPresenter presenter) {
    this.presenter = presenter;
  }

  @UiHandler("reportButton")
  void goToReport(ClickEvent e) {
    Window.alert("Going to Expense Report!");
    presenter.goTo(new ExpenseReportsPlace("id"));
  }

}
