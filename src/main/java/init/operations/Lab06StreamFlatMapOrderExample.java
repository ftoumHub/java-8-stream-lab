package init.operations;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Order{
    private String orderId;
    private List<String> items;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public Order(String orderId, List<String> items) {
        this.orderId = orderId;
        this.items = items;
    }
}

public class Lab06StreamFlatMapOrderExample {

    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
                new Order("1001", Arrays.asList("Item1", "Item2", "Item3")),
                new Order("1002", Arrays.asList("Item4", "Item5", "Item6")),
                new Order("1003", Arrays.asList("Item7", "Item8" ))
        );

        List<String> allItems = orders.stream()
                .flatMap(order -> order.getItems().stream())
                .collect(Collectors.toList());

        System.out.println(allItems);
        for (String item : allItems){
            System.out.println(item);
        }
    }
}
