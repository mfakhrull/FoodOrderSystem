/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurantordersystem;

/**
 *
 * @author mfakr
 */
import java.util.LinkedList;
import java.util.Queue;

public class OrderQueue {
    private Queue<Order> orderQueue;

    public OrderQueue() {
        orderQueue = new LinkedList<>();
    }

    public void addOrder(Order order) {
        orderQueue.add(order);
    }

    public Order peekOrder() {
        return orderQueue.peek();
    }

    public Order removeOrder() {
        return orderQueue.remove();
    }

    public boolean isEmpty() {
        return orderQueue.isEmpty();
    }

    public String getOrderList() {
        StringBuilder sb = new StringBuilder();
        for (Order order : orderQueue) {
            sb.append(order.getDescription()).append("\n");
        }
        return sb.toString();
    }
}
