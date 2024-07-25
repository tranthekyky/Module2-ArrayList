package samples;
public class Product {
    private String name;
    private double price;
    private String type;
    private int quantity;
    private int code ;
    public Product(String name, double price, String type, int quantity, int code) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.quantity = quantity;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "[ Name : " + this.name + ", Code : "+ this.code + " , Price : "
                + this.price + " , Type : " + this.type + " , Quantity : " + this.quantity + " ]";
    }


}