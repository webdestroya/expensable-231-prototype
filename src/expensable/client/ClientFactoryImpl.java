package expensable.client;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;

import expensable.client.view.dashboard.DashboardView;
import expensable.client.view.dashboard.DashboardViewImpl;
import expensable.client.view.expensereport.ExpenseReportView;
import expensable.client.view.expensereport.ExpenseReportViewImpl;

/**
 * @author dpurpura (David Purpura)
 */
public class ClientFactoryImpl implements ClientFactory {

  private static final EventBus eventBus = new SimpleEventBus();
  private static final PlaceController placeController = new PlaceController(eventBus);
  private static final DashboardView dashboardView = new DashboardViewImpl();
  private static ExpenseReportView expenseReportView;
  
  @Override
  public EventBus getEventBus() {
    return eventBus;
  }

  @Override
  public PlaceController getPlaceController() {
    return placeController;
  }
  
  @Override
  public DashboardView getDashboardView() {
    return dashboardView;
  }
  
  @Override
  public ExpenseReportView getExpenseReportView() {
    if (expenseReportView == null) {
      expenseReportView = new ExpenseReportViewImpl();
    }
    return expenseReportView;
  }

}
