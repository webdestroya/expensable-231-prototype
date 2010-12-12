package expensable.shared.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gwt.view.client.ProvidesKey;

public class ExpenseReport implements NewsItem {

  private final List<ExpenseItem> expenseItems;

  private String id;
  private String name;
  private Integer amount;
  private ExpenseType type;
  private Date createdDate;
  private Date lastModified;
  private String attachment;

  public ExpenseReport() {
    expenseItems = new ArrayList<ExpenseItem>();
    lastModified = new Date();
  }

  /**
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * @return the name
   */
  @Override
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the amount
   */
  public Integer getAmount() {
    return amount;
  }

  /**
   * @param amount the amount to set
   */
  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  /**
   * @return the type
   */
  public ExpenseType getType() {
    return type;
  }

  /**
   * @param type the type to set
   */
  public void setType(ExpenseType type) {
    this.type = type;
  }

  /**
   * @return the createdDate
   */
  public Date getCreatedDate() {
    return createdDate;
  }

  /**
   * @param createdDate the createdDate to set
   */
  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

  @Override
  public Date getLastModified() {
    return lastModified;
  }

  /**
   * @return the expenseItems
   */
  public List<ExpenseItem> getExpenseItems() {
    return expenseItems;
  }
  
  /**
   * 
   * @param the attachment
   */
  public void setAttachment(String attachment){
	  this.attachment = attachment;
  }
  
  /**
   * 
   * @return the attachment
   */
  public String getAttachment(){
	  return attachment;
  }

  /**
   * The key provider that provides the unique ID of a report.
   */
  public static final ProvidesKey<ExpenseReport> KEY_PROVIDER = new ProvidesKey<ExpenseReport>() {

    @Override
    public Object getKey(ExpenseReport report) {
      return (report == null) ? null : report.getId();
    }

  };

}
