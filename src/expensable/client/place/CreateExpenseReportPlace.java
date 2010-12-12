package expensable.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class CreateExpenseReportPlace extends Place {

  private String token;

  public CreateExpenseReportPlace(String token) {
    this.token = token;
  }

  public String getToken() {
    return token;
  }

  @Prefix("create-expense-report")
  public static class Tokenizer implements PlaceTokenizer<CreateExpenseReportPlace> {

    @Override
    public CreateExpenseReportPlace getPlace(String token) {
      return new CreateExpenseReportPlace(token);
    }

    @Override
    public String getToken(CreateExpenseReportPlace place) {
      return place.getToken();
    }

  }
}
