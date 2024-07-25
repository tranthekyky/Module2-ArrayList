package design;

import java.util.ArrayList;

public interface ProductDesign <E>{
    void add(E e);
    void remove(int code);
    void edit(int code, E e);
    ArrayList<E> getAll();
    int findIndexByCode(int code);
    int findIndexByName(String name);
    ArrayList<E> findProductByPrice(double startPrice, double endPrice);
    ArrayList<E> findProductByCharacter(String cha);
    int totalByType (String type) ;
    double totalByPrice();

}
