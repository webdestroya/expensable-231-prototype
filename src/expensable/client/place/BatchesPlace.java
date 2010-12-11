package expensable.client.place;

import java.util.HashMap;

import com.google.common.base.Strings;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

import expensable.client.util.Tokenizers;

public class BatchesPlace extends Place {

  public static String BATCH_ID_KEY = "id";

  private String batchId;

  public BatchesPlace(String batchId) {
    this.batchId = batchId;
  }

  public String getBatchId() {
    return batchId;
  }

  @Prefix("batches")
  public static class Tokenizer implements PlaceTokenizer<BatchesPlace> {

    @Override
    public BatchesPlace getPlace(String token) {
      HashMap<String, String> map = Tokenizers.tokenizeQueryString(token);
      return new BatchesPlace(map.get(BATCH_ID_KEY));
    }

    @Override
    public String getToken(BatchesPlace place) {
      StringBuilder sb = new StringBuilder();
      if (!Strings.isNullOrEmpty(place.getBatchId())) {
        sb.append(BATCH_ID_KEY).append("=").append(place.getBatchId());
      }
      return sb.toString();
    }

  }
}
