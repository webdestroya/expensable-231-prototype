package expensable.client.view.expensereport.item;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class ExpenseItemViewImpl extends Composite implements ExpenseItemView {

  private static Binder binder = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, ExpenseItemViewImpl>{}

  private ExpenseItemPresenter presenter;

  public ExpenseItemViewImpl() {
    initWidget(binder.createAndBindUi(this));
  }

  @Override
  public void setPresenter(ExpenseItemPresenter presenter) {
    this.presenter = presenter;
  }

}
