package expensable.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;


public class ExpenseReportPlace extends Place {
  
  private String reportId;
  
  public ExpenseReportPlace(String token) {
    this.reportId = token;
  }
  
  public String getReportId() {
    return reportId;
  }
  
  @Prefix("report")
  public static class Tokenizer implements PlaceTokenizer<ExpenseReportPlace> {

    @Override
    public ExpenseReportPlace getPlace(String token) {
      return new ExpenseReportPlace(token);
    }

    @Override
    public String getToken(ExpenseReportPlace place) {
      return place.getReportId();
    }
    
  }

}
