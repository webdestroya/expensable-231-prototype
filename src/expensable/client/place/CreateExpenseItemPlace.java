package expensable.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class CreateExpenseItemPlace extends Place {

  private String reportId;

  public CreateExpenseItemPlace() {
    this.reportId = "";
  }

  public CreateExpenseItemPlace(String reportId) {
    this.reportId = reportId;
  }

  public String getReportId() {
    return reportId;
  }

  @Prefix("create-expense-item")
  public static class Tokenizer implements PlaceTokenizer<CreateExpenseItemPlace> {

    @Override
    public CreateExpenseItemPlace getPlace(String token) {
      return new CreateExpenseItemPlace(token);
    }

    @Override
    public String getToken(CreateExpenseItemPlace place) {
      return place.getReportId();
    }

  }

}
