package expensable.client;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;

import expensable.client.view.MainLayout;
import expensable.client.view.dashboard.DashboardView;
import expensable.client.view.expensereport.ExpenseReportView;

/**
 * @author dpurpura (David Purpura)
 */
public interface ClientFactory {
  EventBus getEventBus();
  PlaceController getPlaceController();
  MainLayout getMainLayout();
  DashboardView getDashboardView();
  ExpenseReportView getExpenseReportView();
}
