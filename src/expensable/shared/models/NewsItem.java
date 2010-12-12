package expensable.shared.models;

import java.util.Date;

public interface NewsItem {
  String getName();
  int getAmount();
  Date getLastModified();
}
