package expensable.shared.models;

import java.util.Date;

import com.google.gwt.user.client.Random;

public class Batch {

  /** The cost of the item in cents */
  private int id;
  private Date date;
  private String name;
  private String status;
  public Batch() {
	  
  }
  public Batch(String name, String status) {
	  this.name = name;
	  this.status = status;
	  this.id = (Integer.MAX_VALUE/2)+Random.nextInt(Integer.MAX_VALUE/2);
  }
  
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
