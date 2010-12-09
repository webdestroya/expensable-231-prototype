package expensable.client.view.expensereport.item;

import expensable.client.mvp.Presenter;
import expensable.client.mvp.View;
import expensable.client.view.expensereport.item.CreateExpenseItemView.CreateExpenseItemPresenter;

public interface CreateExpenseItemView extends View<CreateExpenseItemPresenter> {

  interface CreateExpenseItemPresenter extends Presenter {}

}
