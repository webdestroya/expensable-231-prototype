package expensable.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class SpotAuditPlace extends Place {

  private String token;

  public SpotAuditPlace(String token) {
    this.token = token;
  }

  public String getToken() {
    return token;
  }

  @Prefix("spotaudit")
  public static class Tokenizer implements PlaceTokenizer<SpotAuditPlace> {

    @Override
    public SpotAuditPlace getPlace(String token) {
      return new SpotAuditPlace(token);
    }

    @Override
    public String getToken(SpotAuditPlace place) {
      return place.getToken();
    }

  }
}
