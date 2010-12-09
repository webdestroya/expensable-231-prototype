package expensable.client.view.expensereport;

import expensable.client.mvp.Presenter;
import expensable.client.mvp.View;
import expensable.client.view.expensereport.ExpenseReportView.ExpenseReportPresenter;

public interface ExpenseReportView extends View<ExpenseReportPresenter> {

  interface ExpenseReportPresenter extends Presenter {

  }

}
