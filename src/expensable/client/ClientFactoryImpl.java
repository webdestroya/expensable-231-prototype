package expensable.client;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;

import expensable.client.view.MainLayout;
import expensable.client.view.MainLayoutImpl;
import expensable.client.view.dashboard.DashboardView;
import expensable.client.view.dashboard.DashboardViewImpl;
import expensable.client.view.expensereport.ExpenseReportView;
import expensable.client.view.expensereport.ExpenseReportViewImpl;

/**
 * Client factory for a standard website (as opposed to a mobile version).
 *
 * @author dpurpura (David Purpura)
 */
public class ClientFactoryImpl implements ClientFactory {

  private static final EventBus eventBus = new SimpleEventBus();
  private static final PlaceController placeController = new PlaceController(eventBus);
  private static final MainLayout mainLayout = new MainLayoutImpl();
  private static final DashboardView dashboardView = new DashboardViewImpl();

  // Lazily initialize the non default views
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
  public MainLayout getMainLayout() {
    return mainLayout;
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
