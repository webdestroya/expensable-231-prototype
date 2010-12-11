package expensable.client;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;

import expensable.client.view.MainLayout;
import expensable.client.view.batch.BatchesView;
import expensable.client.view.dashboard.DashboardView;
import expensable.client.view.expensereport.CreateExpenseReportView;
import expensable.client.view.expensereport.ExpenseReportView;
import expensable.client.view.expensereport.ExpenseReportsView;
import expensable.client.view.expensereport.item.ExpenseItemView;
import expensable.client.view.spotaudit.SpotAuditView;

/**
 * @author dpurpura (David Purpura)
 */
public interface ClientFactory {
  EventBus getEventBus();
  PlaceController getPlaceController();
  MainLayout getMainLayout();
  CreateExpenseItemViewFactory getCreateExpenseItemViewFactory();
  BatchesView getBatchesView();
  DashboardView getDashboardView();
  ExpenseItemView getExpenseItemView();
  ExpenseReportView getExpenseReportView();
  ExpenseReportsView getExpenseReportsView();
  SpotAuditView getSpotAuditView();
  CreateExpenseReportView getCreateExpenseReportView();
}
