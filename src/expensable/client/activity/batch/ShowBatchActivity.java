package expensable.client.activity.batch;

import java.util.List;

import com.google.common.collect.Lists;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.ProvidesKey;

import expensable.client.ClientFactory;
import expensable.client.activity.expensereport.ShowExpenseReportsActivity;
import expensable.client.place.BatchesPlace;
import expensable.client.view.batch.BatchView;
import expensable.client.view.batch.BatchView.BatchPresenter;
import expensable.shared.models.Batch;
import expensable.shared.models.ExpenseReport;

public class ShowBatchActivity extends AbstractActivity implements BatchPresenter {

  private ClientFactory clientFactory;

  private final BatchesPlace place;
  private final ListDataProvider<ExpenseReport> dataProvider;

  public ShowBatchActivity(BatchesPlace place, ClientFactory clientFactory) {
    this.place = place;
    this.clientFactory = clientFactory;
    this.dataProvider = new ListDataProvider<ExpenseReport>();
    ShowExpenseReportsActivity.stubReports(dataProvider.getList());
  }

  @Override
  public void start(AcceptsOneWidget container, EventBus eventBus) {
    BatchView view = clientFactory.getBatchView();
    view.setPresenter(this);
    container.setWidget(view.asWidget());
  }

  @Override
  public void goTo(Place place) {
    clientFactory.getPlaceController().goTo(place);
  }


  @Override
  public void addReportsDisplay(CellTable<ExpenseReport> reports) {
    dataProvider.addDataDisplay(reports);
  }

  @Override
  public void refreshDisplays() {
    dataProvider.refresh();
  }

  @Override
  public String getBatchName() {
    List<Batch> batches = Lists.newArrayList();
    ShowBatchesActivity.stubBatches(batches);
    for (Batch b : batches) {
      if (b.getId() == Integer.parseInt(place.getBatchId())) {
        return b.getName();
      }
    }
    return null;
  }

  @Override
  public ProvidesKey<ExpenseReport> getKeyProvider() {
    return ExpenseReport.KEY_PROVIDER;
  }

}

