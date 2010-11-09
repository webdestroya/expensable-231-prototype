package expensable.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;


public class ExpenseReportsPlace extends Place {
  
  private String reportId;
  
  public ExpenseReportsPlace(String token) {
    this.reportId = token;
  }
  
  public String getReportId() {
    return reportId;
  }
  
  @Prefix("report")
  public static class Tokenizer implements PlaceTokenizer<ExpenseReportsPlace> {

    @Override
    public ExpenseReportsPlace getPlace(String token) {
      return new ExpenseReportsPlace(token);
    }

    @Override
    public String getToken(ExpenseReportsPlace place) {
      return place.getReportId();
    }
    
  }

}
