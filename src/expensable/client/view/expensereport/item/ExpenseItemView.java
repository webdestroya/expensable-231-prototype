package expensable.client.view.expensereport.item;

import expensable.client.mvp.Presenter;
import expensable.client.mvp.View;
import expensable.client.view.expensereport.item.ExpenseItemView.ExpenseItemPresenter;

public interface ExpenseItemView extends View<ExpenseItemPresenter> {

  interface ExpenseItemPresenter extends Presenter {

  }
}
