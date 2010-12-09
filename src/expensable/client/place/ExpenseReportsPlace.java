package expensable.client.place;

import java.util.HashMap;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

import expensable.client.util.Tokenizers;


public class ExpenseReportsPlace extends Place {

  public static String REPORT_ID_KEY = "rid";
  public static String ITEM_ID_KEY   = "itemid";

  private String reportId;
  private String itemId;

  public ExpenseReportsPlace() {
    this("", "");
  }

  public ExpenseReportsPlace(String reportId) {
    this(reportId, "");
  }

  public ExpenseReportsPlace(String reportId, String itemId) {
    this.reportId = reportId;
    this.itemId = itemId;
  }

  public String getReportId() {
    return reportId;
  }

  public String getItemId() {
    return itemId;
  }

  @Prefix("reports")
  public static class Tokenizer implements PlaceTokenizer<ExpenseReportsPlace> {

    @Override
    public ExpenseReportsPlace getPlace(String token) {
      HashMap<String, String> map = Tokenizers.tokenizeQueryString(token);
      return new ExpenseReportsPlace(map.get(REPORT_ID_KEY), map.get(ITEM_ID_KEY));
    }

    @Override
    public String getToken(ExpenseReportsPlace place) {
      StringBuilder b = new StringBuilder();
      return b.append("?")
          .append(REPORT_ID_KEY).append("=").append(place.getReportId())
          .append(ITEM_ID_KEY).append("=").append(place.getItemId())
          .toString();
    }

  }

}
