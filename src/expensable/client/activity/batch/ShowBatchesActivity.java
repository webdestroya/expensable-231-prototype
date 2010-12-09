package expensable.client.activity.batch;

import java.util.Date;
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
import expensable.shared.models.ExpenseReport;
import expensable.shared.models.ExpenseType;

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
    stubReports();
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
  

  @SuppressWarnings("deprecation") // Using deprecated date for quick stub
  List<Batch> stubReports() {
    List<Batch> reports = dataProvider.getList();

    reports.add(new Batch("November Billing","Pending"));
    reports.add(new Batch("December Billing","Pending"));
    reports.add(new Batch("January Billing","Pending"));
    reports.add(new Batch("August Billing","Pending"));
    reports.add(new Batch("September Billing","Pending"));
    reports.add(new Batch("October Billing","Pending"));

    return reports;
  }

  @Override
  public ProvidesKey<Batch> getKeyProvider() {
    return KEY_PROVIDER;
  }
  
}
