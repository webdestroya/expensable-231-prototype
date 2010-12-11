package expensable.client.activity.expensereport;

import java.util.Date;
import java.util.List;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.ProvidesKey;

import expensable.client.ClientFactory;
import expensable.client.place.ExpenseReportsPlace;
import expensable.client.view.expensereport.ExpenseReportsView;
import expensable.client.view.expensereport.ExpenseReportsView.ExpenseReportsPresenter;
import expensable.shared.models.ExpenseReport;
import expensable.shared.models.ExpenseType;

public class ShowExpenseReportsActivity extends AbstractActivity
    implements ExpenseReportsPresenter {

  /**
   * The key provider that provides the unique ID of a report.
   */
  public static final ProvidesKey<ExpenseReport> KEY_PROVIDER = new ProvidesKey<ExpenseReport>() {

    @Override
    public Object getKey(ExpenseReport report) {
      return (report == null) ? null : report.getId();
    }

  };

  /**
   * The provider that holds the list of reports in the database.
   */
  private final ListDataProvider<ExpenseReport> dataProvider;
  private final ClientFactory clientFactory;

  public ShowExpenseReportsActivity(ExpenseReportsPlace place, ClientFactory clientFactory) {
    this.dataProvider = new ListDataProvider<ExpenseReport>();
    this.clientFactory = clientFactory;
    stubReports(dataProvider.getList());
  }

  @Override
  public void start(AcceptsOneWidget container, EventBus eventBus) {
    ExpenseReportsView view = clientFactory.getExpenseReportsView();
    view.setPresenter(this);
    //refreshDisplays();
    container.setWidget(view.asWidget());
  }

  @Override
  public void goTo(Place place) {
    clientFactory.getPlaceController().goTo(place);
  }

  @Override
  public void onButtonClick(ClickEvent e) {
    Window.alert("button clicked!");
  }

  @Override
  public ProvidesKey<ExpenseReport> getKeyProvider() {
    return KEY_PROVIDER;
  }

  @Override
  public void addReportsDisplay(CellTable<ExpenseReport> reports) {
    dataProvider.addDataDisplay(reports);
  }

  @Override
  public void refreshDisplays() {
    dataProvider.refresh();
  }

  @SuppressWarnings("deprecation") // Using deprecated date for quick stub
  public static void stubReports(List<? super ExpenseReport> reports) {
    ExpenseReport report = new ExpenseReport();
    report.setId("1");
    report.setName("Trip to Alaska");
    report.setAmount(5623);
    report.setCreatedDate(new Date(110, 4, 23));
    report.setType(new ExpenseType("Travel"));
    reports.add(report);

    report = new ExpenseReport();
    report.setId("2");
    report.setName("Kickoff Dinner");
    report.setAmount(375);
    report.setCreatedDate(new Date(110, 10, 1));
    report.setType(new ExpenseType("Dining"));
    reports.add(report);

    report = new ExpenseReport();
    report.setId("3");
    report.setName("Swingline");
    report.setAmount(15);
    report.setCreatedDate(new Date(110, 10, 15));
    report.setType(new ExpenseType("Office Supplies"));
    reports.add(report);
  }

}