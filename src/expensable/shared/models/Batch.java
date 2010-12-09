package expensable.shared.models;

import java.util.Date;

public class Batch {

  /** The cost of the item in cents */
  private int id;
  private Date date;
  private String name;
  private String status;
  
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}


}
