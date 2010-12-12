package expensable.client.view.expensereport;

import expensable.client.mvp.Presenter;
import expensable.client.mvp.View;
import expensable.client.view.expensereport.CreateExpenseReportView.CreateExpenseReportPresenter;

public interface CreateExpenseReportView extends View<CreateExpenseReportPresenter> {
	interface CreateExpenseReportPresenter extends Presenter {}

}