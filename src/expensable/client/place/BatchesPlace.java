package expensable.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class BatchesPlace extends Place {

  private String token;

  public BatchesPlace(String token) {
    this.token = token;
  }

  public String getToken() {
    return token;
  }

  @Prefix("batches")
  public static class Tokenizer implements PlaceTokenizer<BatchesPlace> {

    @Override
    public BatchesPlace getPlace(String token) {
      return new BatchesPlace(token);
    }

    @Override
    public String getToken(BatchesPlace place) {
      return place.getToken();
    }

  }
}
