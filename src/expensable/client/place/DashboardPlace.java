/**
 * 
 */
package expensable.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

/**
 * @author dpurpura (David Purpura)
 */
public class DashboardPlace extends Place {
  
  private final String token;
  
  public DashboardPlace(String token) {
    this.token = token;
  }
  
  public String getToken() {
    return token;
  }
  
  @Prefix("dashboard")
  public static class Tokenizer implements PlaceTokenizer<DashboardPlace> {
    
    @Override
    public String getToken(DashboardPlace place) {
      return place.getToken();
    }
    
    @Override
    public DashboardPlace getPlace(String token) {
      return new DashboardPlace(token);
    }
  }

}
