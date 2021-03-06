package expensable.shared.models;

import java.util.Date;

public class ExpenseItem implements NewsItem {

  /** The cost of the item in cents */
  private int amount;

  private int id;


private Date purchaseDate;
  private Date lastModified;
  
  private String location;
  private String merchant;
  private String description;

  public ExpenseItem() {

  }
  
  public ExpenseItem(int id, int amount, String location, String merchant, String description) {
	  this.id = id;
	  this.amount = amount;
	  this.location = location;
	  this.merchant = merchant;
	  this.description = description;
	  this.purchaseDate = new Date();
  }

  public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
  
  /**
   * @return the amount
   */
  public int getAmount() {
    return amount;
  }

  /**
   * @param amount the amount to set
   */
  public void setAmount(int amount) {
    this.amount = amount;
  }

  /**
   * @return the purchaseDate
   */
  public Date getPurchaseDate() {
    return purchaseDate;
  }

  /**
   * @param purchaseDate the purchaseDate to set
   */
  public void setPurchaseDate(Date purchaseDate) {
    this.purchaseDate = purchaseDate;
  }

  @Override
  public Date getLastModified() {
    return getPurchaseDate();
  }

  @Override
  public String getName() {
    return getDescription();
  }

  /**
   * @return the location
   */
  public String getLocation() {
    return location;
  }

  /**
   * @param location the location to set
   */
  public void setLocation(String location) {
    this.location = location;
  }

  /**
   * @return the merchant
   */
  public String getMerchant() {
    return merchant;
  }

  /**
   * @param merchant the merchant to set
   */
  public void setMerchant(String merchant) {
    this.merchant = merchant;
  }

  /**
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * @param description the description to set
   */
  public void setDescription(String description) {
    this.description = description;
  }

}
