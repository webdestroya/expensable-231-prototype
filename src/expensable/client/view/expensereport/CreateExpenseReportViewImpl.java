package expensable.client.view.expensereport;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import expensable.client.place.CreateExpenseItemPlace;
import expensable.client.view.widget.Button;

public class CreateExpenseReportViewImpl extends Composite implements CreateExpenseReportView {

  private static Binder binder = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, CreateExpenseReportViewImpl>{}

  private CreateExpenseReportPresenter presenter;

  @UiField Button createItem;

  public CreateExpenseReportViewImpl() {
    initWidget(binder.createAndBindUi(this));
  }

  @Override
  public void setPresenter(CreateExpenseReportPresenter presenter) {
    this.presenter = presenter;
  }

  @UiHandler("createItem")
  public void onCreateItemButtonClick(ClickEvent e) {
    presenter.goTo(new CreateExpenseItemPlace(""));
  }

}
