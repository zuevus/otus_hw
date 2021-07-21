package homework;


import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class CustomerService {

    private final Map<Customer, String> customers = new HashMap<>();

    public void add(Customer key, String value) {
        customers.put(key, value);
    }

    public Map.Entry<Customer, String> getSmallest() {
        for (Iterator<String> i = someIterable.iterator(); i.hasNext();) {
        customers.forEach();
        return null; // это "заглушка, чтобы скомилировать"
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {

        return null; // это "заглушка, чтобы скомилировать"
    }


}
