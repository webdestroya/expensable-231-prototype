/**
 * 
 */
package expensable.client.mvp;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

import expensable.client.place.DashboardPlace;
import expensable.client.place.ExpenseReportPlace;

/**
 * @author dpurpura (David Purpura)
 */
@WithTokenizers({
    DashboardPlace.Tokenizer.class,
    ExpenseReportPlace.Tokenizer.class,
  })
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {

}
