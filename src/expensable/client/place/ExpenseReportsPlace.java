package expensable.client.place;

import java.util.HashMap;

import com.google.common.base.Strings;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

import expensable.client.util.Tokenizers;


public class ExpenseReportsPlace extends Place {

  public static String REPORT_ID_KEY = "rid";
  public static String ITEM_ID_KEY   = "iid";
  public static String ITEM_TYPE_KEY = "type";

  public enum ItemType {
    NULL_TYPE,
    AIRFAIRE,
    ENTERTAINMENT,
    GAS_MILEAGE,
    HOTEL;
  }

  private final String reportId;
  private final String itemId;
  private final ItemType itemType;

  public ExpenseReportsPlace() {
    this("", "");
  }

  public ExpenseReportsPlace(String reportId) {
    this(reportId, "");
  }

  public ExpenseReportsPlace(String reportId, String itemId) {
    this(reportId, itemId, ItemType.NULL_TYPE);
  }

  public ExpenseReportsPlace(String reportId, String itemId, ItemType itemType) {
    this.reportId = reportId;
    this.itemId = itemId;
    this.itemType = (itemType == null) ? ItemType.NULL_TYPE : itemType;
  }

  public String getReportId() {
    return reportId;
  }

  public String getItemId() {
    return itemId;
  }

  public ItemType getItemType() {
    return itemType;
  }

  @Prefix("reports")
  public static class Tokenizer implements PlaceTokenizer<ExpenseReportsPlace> {

    @Override
    public ExpenseReportsPlace getPlace(String token) {
      HashMap<String, String> map = Tokenizers.tokenizeQueryString(token);
      System.out.println("report id: " + map.get(REPORT_ID_KEY)
          + ", item_id: " + map.get(ITEM_ID_KEY)
          + ", type: " + deserializeItemType(map.get(ITEM_TYPE_KEY)).name());
      return new ExpenseReportsPlace(map.get(REPORT_ID_KEY), map.get(ITEM_ID_KEY),
          deserializeItemType(map.get(ITEM_TYPE_KEY)));
    }

    @Override
    public String getToken(ExpenseReportsPlace place) {
      StringBuilder b = new StringBuilder();
      if (!Strings.isNullOrEmpty(place.getReportId())) {
        b.append("?")
          .append(REPORT_ID_KEY).append("=").append(place.getReportId());

        if (!Strings.isNullOrEmpty(place.getItemId())) {
          b.append(ITEM_ID_KEY).append("=").append(place.getItemId());

          if (place.getItemType() != ItemType.NULL_TYPE) {
            b.append(ITEM_TYPE_KEY).append("=").append(serializeItemType(place.getItemType()));
          }
        }
      }
      return b.toString();
    }

    public String serializeItemType(ItemType type) {
      return type.name().toLowerCase();
    }

    public ItemType deserializeItemType(String stringType) {
      if (Strings.isNullOrEmpty(stringType)) {
        return ItemType.NULL_TYPE;
      }

      for (ItemType type : ItemType.values()) {
        if (type.name().equalsIgnoreCase(stringType)) {
          return type;
        }
      }
      return ItemType.NULL_TYPE;
    }

  }

}
