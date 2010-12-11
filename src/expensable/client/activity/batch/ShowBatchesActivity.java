package expensable.client.activity.batch;

import java.util.List;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.ProvidesKey;

import expensable.client.ClientFactory;
import expensable.client.place.BatchesPlace;
import expensable.client.view.batch.BatchesView;
import expensable.client.view.batch.BatchesView.BatchesPresenter;
import expensable.shared.models.Batch;

public class ShowBatchesActivity extends AbstractActivity implements BatchesPresenter {

  private ClientFactory clientFactory;

  private final ListDataProvider<Batch> dataProvider;

  /**
   * The key provider that provides the unique ID of a report.
   */
  public static final ProvidesKey<Batch> KEY_PROVIDER = new ProvidesKey<Batch>() {

    @Override
    public Object getKey(Batch report) {
      return (report == null) ? null : report.getId();
    }

  };

  public ShowBatchesActivity(BatchesPlace place, ClientFactory clientFactory) {
    this.clientFactory = clientFactory;
    this.dataProvider = new ListDataProvider<Batch>();
    stubBatches(dataProvider.getList());
  }

  @Override
  public void start(AcceptsOneWidget container, EventBus eventBus) {
    BatchesView view = clientFactory.getBatchesView();
    view.setPresenter(this);
    container.setWidget(view.asWidget());
  }

  @Override
  public void goTo(Place place) {
    clientFactory.getPlaceController().goTo(place);
  }

  @Override
  public void addReportsDisplay(CellTable<Batch> reports) {
    dataProvider.addDataDisplay(reports);
  }

  @Override
  public void refreshDisplays() {
    dataProvider.refresh();
  }

  public static void stubBatches(List<? super Batch> reports) {
    reports.add(new Batch(234232, "November Billing","Pending"));
    reports.add(new Batch(442244, "December Billing","Pending"));
    reports.add(new Batch(456445, "January Billing","Pending"));
    reports.add(new Batch(684368, "August Billing","Pending"));
    reports.add(new Batch(233461, "September Billing","Pending"));
    reports.add(new Batch(724572, "October Billing","Pending"));
  }

  @Override
  public ProvidesKey<Batch> getKeyProvider() {
    return KEY_PROVIDER;
  }

}
