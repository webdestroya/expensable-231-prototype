package expensable.client.view.expensereport;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class CreateExpenseReportViewImpl extends Composite implements CreateExpenseReportView {

  private static Binder binder = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, CreateExpenseReportViewImpl>{}

  private CreateExpenseReportPresenter presenter;

  public CreateExpenseReportViewImpl() {
    initWidget(binder.createAndBindUi(this));
  }

  @Override
  public void setPresenter(CreateExpenseReportPresenter presenter) {
    this.presenter = presenter;
  }

}
