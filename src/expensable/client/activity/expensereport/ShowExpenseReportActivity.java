package expensable.client.activity.expensereport;

import java.util.List;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.ProvidesKey;

import expensable.client.ClientFactory;
import expensable.client.place.ExpenseReportsPlace;
import expensable.client.view.expensereport.ExpenseReportView;
import expensable.client.view.expensereport.ExpenseReportView.ExpenseReportPresenter;
import expensable.shared.models.ExpenseItem;

public class ShowExpenseReportActivity extends AbstractActivity implements ExpenseReportPresenter {

  private ClientFactory clientFactory;

  /**
   * The key provider that provides the unique ID of a report.
   */
  public static final ProvidesKey<ExpenseItem> KEY_PROVIDER = new ProvidesKey<ExpenseItem>() {

    @Override
    public Object getKey(ExpenseItem report) {
      return (report == null) ? null : report.getId();
    }

  };




  /**
   * The provider that holds the list of reports in the database.
   */
  private final ListDataProvider<ExpenseItem> dataProvider;


  public ShowExpenseReportActivity(ExpenseReportsPlace place, ClientFactory clientFactory) {
    this.dataProvider = new ListDataProvider<ExpenseItem>();
    this.clientFactory = clientFactory;
    stubReports(dataProvider.getList());
  }

  @Override
  public void start(AcceptsOneWidget container, EventBus eventBus) {
    ExpenseReportView view = clientFactory.getExpenseReportView();
    view.setPresenter(this);
    //refreshDisplays();
    container.setWidget(view.asWidget());
  }

  @Override
  public void goTo(Place place) {
    clientFactory.getPlaceController().goTo(place);
  }

  @Override
  public ProvidesKey<ExpenseItem> getKeyProvider() {
    return KEY_PROVIDER;
  }

  @Override
  public void addReportsDisplay(CellTable<ExpenseItem> reports) {
    dataProvider.addDataDisplay(reports);
  }

  @Override
  public void refreshDisplays() {
    dataProvider.refresh();
  }

  @SuppressWarnings("deprecation") // Using deprecated date for quick stub
  public static void stubReports(List<? super ExpenseItem> reports) {
	int id=12398123;
    reports.add(new ExpenseItem(id++,1231,"Alaska","Chevron","Gas"));
    reports.add(new ExpenseItem(id++,9861,"Alaska","Dennys","Breakfast"));
    reports.add(new ExpenseItem(id++,123861,"Alaska","Hertz","Auto"));
  }


}