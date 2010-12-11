package expensable.client;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;

import expensable.client.view.MainLayout;
import expensable.client.view.MainLayoutImpl;
import expensable.client.view.batch.BatchesView;
import expensable.client.view.batch.BatchesViewImpl;
import expensable.client.view.dashboard.DashboardView;
import expensable.client.view.dashboard.DashboardViewImpl;
import expensable.client.view.expensereport.CreateExpenseReportView;
import expensable.client.view.expensereport.CreateExpenseReportViewImpl;
import expensable.client.view.expensereport.ExpenseReportView;
import expensable.client.view.expensereport.ExpenseReportViewImpl;
import expensable.client.view.expensereport.ExpenseReportsView;
import expensable.client.view.expensereport.ExpenseReportsViewImpl;
import expensable.client.view.expensereport.item.ExpenseItemView;
import expensable.client.view.expensereport.item.ExpenseItemViewImpl;
import expensable.client.view.spotaudit.SpotAuditView;
import expensable.client.view.spotaudit.SpotAuditViewImpl;

/**
 * Client factory for a standard website (as opposed to a mobile version).
 *
 * @author dpurpura (David Purpura)
 */
public class ClientFactoryImpl implements ClientFactory {

  private static final EventBus eventBus = new SimpleEventBus();
  private static final PlaceController placeController = new PlaceController(eventBus);
  private static final MainLayout mainLayout = new MainLayoutImpl();
  private static final CreateExpenseItemViewFactory expenseItemViewFactory
    = new CreateExpenseItemViewFactoryImpl();
  private static final DashboardView dashboardView = new DashboardViewImpl();

  // Lazily initialize the non default views
  private static BatchesView batchesView;
  private static ExpenseReportView expenseReportView;
  private static ExpenseItemView expenseItemView;
  private static ExpenseReportsView expenseReportsView;
  private static SpotAuditView spotAuditView;
  private static CreateExpenseReportView createExpenseReportView;

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
  public BatchesView getBatchesView() {
    if (batchesView == null) {
      batchesView = new BatchesViewImpl();
    }
    return batchesView;
  }

  @Override
  public DashboardView getDashboardView() {
    return dashboardView;
  }

  @Override
  public CreateExpenseItemViewFactory getCreateExpenseItemViewFactory() {
    return expenseItemViewFactory;
  }

  @Override
  public ExpenseItemView getExpenseItemView() {
    if (expenseItemView == null) {
      expenseItemView = new ExpenseItemViewImpl();
    }
    return expenseItemView;
  }

  @Override
  public ExpenseReportView getExpenseReportView() {
    if (expenseReportView == null) {
      expenseReportView = new ExpenseReportViewImpl();
    }
    return expenseReportView;
  }

  @Override
  public ExpenseReportsView getExpenseReportsView() {
    if (expenseReportsView == null) {
      expenseReportsView = new ExpenseReportsViewImpl();
    }
    return expenseReportsView;
  }

  @Override
  public SpotAuditView getSpotAuditView() {
    if (spotAuditView == null) {
      spotAuditView = new SpotAuditViewImpl();
    }
    return spotAuditView;
  }
  
  @Override
  public CreateExpenseReportView getCreateExpenseReportView() {
    if (createExpenseReportView == null) {
    	createExpenseReportView = new CreateExpenseReportViewImpl();
    }
    return createExpenseReportView;
  }

}
