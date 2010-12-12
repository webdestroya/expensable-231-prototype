package expensable.client.view.spotaudit;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.view.client.ProvidesKey;

import expensable.client.mvp.Presenter;
import expensable.client.mvp.View;
import expensable.client.view.spotaudit.SpotAuditView.SpotAuditPresenter;
import expensable.shared.models.ExpenseReport;

public interface SpotAuditView extends View<SpotAuditPresenter> {

  interface SpotAuditPresenter extends Presenter {

	  /** Example code for a button click */
	    void onButtonClick(ClickEvent e);

	    ProvidesKey<ExpenseReport> getKeyProvider();
	    void addReportsDisplay(CellTable<ExpenseReport> reports);
	    void refreshDisplays();
  }
}
