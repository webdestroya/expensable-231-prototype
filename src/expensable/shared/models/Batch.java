package expensable.shared.models;

import java.util.Date;

import com.google.gwt.user.client.Random;

public class Batch implements NewsItem {

  /** The cost of the item in cents */
  private int id;
  private Date date;
  private int amount;
  private Date lastModified;
  private String name;
  private String status;

  public Batch() {
    this(0, "", "");
  }

  public Batch(int id, String name, String status) {
    this.id = id;
    this.name = name;
    this.status = status;
    this.date = new Date();
    this.lastModified = new Date();
    this.amount = Random.nextInt(5000);
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  @Override
  public int getAmount() {
    return amount;
  }

  @Override
  public Date getLastModified() {
    return lastModified;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
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
