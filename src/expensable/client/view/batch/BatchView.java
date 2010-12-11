package expensable.client.view.batch;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.view.client.ProvidesKey;

import expensable.client.mvp.Presenter;
import expensable.client.mvp.View;
import expensable.client.view.batch.BatchView.BatchPresenter;
import expensable.shared.models.ExpenseReport;

public interface BatchView extends View<BatchPresenter> {

  interface BatchPresenter extends Presenter {
    String getBatchName();
    ProvidesKey<ExpenseReport> getKeyProvider();
    void addReportsDisplay(CellTable<ExpenseReport> reports);
    void refreshDisplays();
  }

}
