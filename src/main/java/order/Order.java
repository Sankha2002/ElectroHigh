package order;

public class Order {
	String order_id,product_name,city,postal_code;
	int nop,price;
	
	
	
	public Order(String order_id, String product_name, String city, String postal_code, int nop, int price) {
		super();
		this.order_id = order_id;
		this.product_name = product_name;
		this.city = city;
		this.postal_code = postal_code;
		this.nop = nop;
		this.price = price;
	}
	
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostal_code() {
		return postal_code;
	}
	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}
	public int getNop() {
		return nop;
	}
	public void setNop(int nop) {
		this.nop = nop;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	

}
