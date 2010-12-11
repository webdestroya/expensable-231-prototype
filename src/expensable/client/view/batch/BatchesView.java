package expensable.client.view.batch;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.view.client.ProvidesKey;

import expensable.client.mvp.Presenter;
import expensable.client.mvp.View;
import expensable.client.view.batch.BatchesView.BatchesPresenter;
import expensable.shared.models.Batch;

public interface BatchesView extends View<BatchesPresenter> {

  interface BatchesPresenter extends Presenter {

	    ProvidesKey<Batch> getKeyProvider();
	    void addReportsDisplay(CellTable<Batch> reports);
	    void refreshDisplays();
  }

  CellTable<Batch> getReportsTable();
}
