/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package restaurantordersystem;

/**
 *
 * @author mfakr
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestaurantOrderSystem {
    private JFrame frame;
    private JTextField orderTextField;
    private JTextArea orderList;
    private OrderQueue orderQueue;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RestaurantOrderSystem window = new RestaurantOrderSystem();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public RestaurantOrderSystem() {
        initialize();
    }

    private void initialize() {
        orderQueue = new OrderQueue();

        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        orderTextField = new JTextField();
        orderTextField.setBounds(10, 11, 414, 20);
        frame.getContentPane().add(orderTextField);
        orderTextField.setColumns(10);

        JButton addButton = new JButton("Add Order");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String orderDescription = orderTextField.getText();
                if (!orderDescription.isEmpty()) {
                    orderQueue.enqueue(new Order(orderDescription));
                    orderTextField.setText("");
                    updateOrderList();
                }
            }
        });
        addButton.setBounds(10, 42, 107, 23);
        frame.getContentPane().add(addButton);

        JButton peekButton = new JButton("Peek Order");
        peekButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!orderQueue.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Front Order: " + orderQueue.peek().getDescription());
                } else {
                    JOptionPane.showMessageDialog(frame, "No orders in the queue.");
                }
            }
        });
        peekButton.setBounds(127, 42, 107, 23);
        frame.getContentPane().add(peekButton);

        JButton removeButton = new JButton("Remove Order");
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!orderQueue.isEmpty()) {
                    orderQueue.dequeue();
                    updateOrderList();
                } else {
                    JOptionPane.showMessageDialog(frame, "No orders in the queue.");
                }
            }
        });
        removeButton.setBounds(244, 42, 124, 23);
        frame.getContentPane().add(removeButton);

        JButton viewAllButton = new JButton("View All Orders");
        viewAllButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!orderQueue.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "All Orders:\n" + orderQueue.getOrderList());
                } else {
                    JOptionPane.showMessageDialog(frame, "No orders in the queue.");
                }
            }
        });
        viewAllButton.setBounds(10, 72, 150, 23);
        frame.getContentPane().add(viewAllButton);

        orderList = new JTextArea();
        orderList.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(orderList);
        scrollPane.setBounds(10, 106, 414, 144);
        frame.getContentPane().add(scrollPane);
    }

    private void updateOrderList() {
        orderList.setText(orderQueue.getOrderList());
    }
}

