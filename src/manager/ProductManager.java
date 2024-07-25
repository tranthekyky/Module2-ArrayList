package manager;
import samples.Product;

import design.ProductDesign;

import java.util.ArrayList;

public class ProductManager implements ProductDesign <Product> {
    ArrayList<Product> products;
    public ProductManager() {
        products = new ArrayList<>();
    }
    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public void remove(int code) {
        int index = findIndexByCode(code);
        if (index != -1) {
            products.remove(index);
        }else {
            System.out.println("Mã sản phẩm không tồn tại !");
        }

    }

    @Override
    public void edit(int code, Product product) {
        int index = findIndexByCode(code) ;
            products.set(index, product);
    }

    @Override
    public ArrayList<Product> getAll() {
        return this.products;
    }

    @Override
    public int findIndexByCode(int code) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getCode() == code) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int findIndexByName(String name) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public ArrayList<Product> findProductByPrice(double startPrice, double endPrice) {
        ArrayList<Product> newProducts = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getPrice() >= startPrice && products.get(i).getPrice() <= endPrice) {
                newProducts.add(products.get(i));
            }
        }
        return newProducts;
    }

    @Override
    public ArrayList<Product> findProductByCharacter(String cha) {
        ArrayList<Product> newProducts = new ArrayList<>();
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getName().toLowerCase().contains(cha.toLowerCase())) {
                    newProducts.add(products.get(i));
                }
            }
        return newProducts;
    }

    @Override
    public int totalByType(String type) {
        int total = 0;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getType().equals(type)) {
                total += products.get(i).getQuantity();
            }
        }
        return total;
    }

    @Override
    public double totalByPrice() {
        double total = 0;
        for (int i = 0; i < products.size(); i++) {
            total += (products.get(i).getPrice()) * products.get(i).getQuantity();
        }
        return total;
    }


}