package expensable.client.view.expensereport;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.view.client.ProvidesKey;

import expensable.client.mvp.Presenter;
import expensable.client.mvp.View;
import expensable.client.view.expensereport.ExpenseReportView.ExpenseReportPresenter;
import expensable.shared.models.ExpenseItem;

public interface ExpenseReportView extends View<ExpenseReportPresenter> {

  interface ExpenseReportPresenter extends Presenter {
	  ProvidesKey<ExpenseItem> getKeyProvider();
	    void addReportsDisplay(CellTable<ExpenseItem> reports);
	    void refreshDisplays();
	  }

	  CellTable<ExpenseItem> getReportsTable();

}
