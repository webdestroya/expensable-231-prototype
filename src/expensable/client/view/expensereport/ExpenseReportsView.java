package expensable.client.view.expensereport;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.view.client.ProvidesKey;

import expensable.client.mvp.Presenter;
import expensable.client.mvp.View;
import expensable.client.view.expensereport.ExpenseReportsView.ExpenseReportsPresenter;
import expensable.shared.models.ExpenseReport;

/**
 * @author dpurpura (David Purpura)
 */
public interface ExpenseReportsView extends View<ExpenseReportsPresenter> {

  interface ExpenseReportsPresenter extends Presenter {

    /** Example code for a button click */
    void onButtonClick(ClickEvent e);

    ProvidesKey<ExpenseReport> getKeyProvider();
    void addReportsDisplay(CellTable<ExpenseReport> reports);
    void refreshDisplays();
  }

  CellTable<ExpenseReport> getReportsTable();

}
