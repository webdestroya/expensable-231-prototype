package expensable.shared.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExpenseReport {

  private final List<ExpenseItem> expenseItems;

  private String id;
  private String name;
  private Integer amount;
  private ExpenseType type;
  private Date createdDate;

  public ExpenseReport() {
    expenseItems = new ArrayList<ExpenseItem>();
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

  /**
   * @return the expenseItems
   */
  public List<ExpenseItem> getExpenseItems() {
    return expenseItems;
  }

}
