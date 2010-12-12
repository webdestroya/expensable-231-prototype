/**
 *
 */
package expensable.client.mvp;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

import expensable.client.place.BatchesPlace;
import expensable.client.place.CreateExpenseItemPlace;
import expensable.client.place.CreateExpenseReportPlace;
import expensable.client.place.DashboardPlace;
import expensable.client.place.ExpenseReportsPlace;
import expensable.client.place.SpotAuditPlace;

/**
 * @author dpurpura (David Purpura)
 */
@WithTokenizers({
    BatchesPlace.Tokenizer.class,
    CreateExpenseReportPlace.Tokenizer.class,
    CreateExpenseItemPlace.Tokenizer.class,
    DashboardPlace.Tokenizer.class,
    ExpenseReportsPlace.Tokenizer.class,
    SpotAuditPlace.Tokenizer.class
  })
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {

}
