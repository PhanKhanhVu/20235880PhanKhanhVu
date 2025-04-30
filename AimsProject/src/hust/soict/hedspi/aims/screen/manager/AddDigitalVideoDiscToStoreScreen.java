package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfDirector;
    private JTextField tfLength;
    private JTextField tfCost;

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store);
        buildForm();
        setTitle("Add DVD to Store");
    }

    @Override
    protected void buildForm() {
        JPanel formPanel = createFormPanel();

        tfTitle = new JTextField();
        tfCategory = new JTextField();
        tfDirector = new JTextField();
        tfLength = new JTextField();
        tfCost = new JTextField();

        addFormField(formPanel, "Title", tfTitle);
        addFormField(formPanel, "Category", tfCategory);
        addFormField(formPanel, "Director", tfDirector);
        addFormField(formPanel, "Length (minutes)", tfLength);
        addFormField(formPanel, "Cost", tfCost);

        JButton btnAdd = new JButton("Add DVD");
        btnAdd.addActionListener(e -> submitForm());

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(formPanel, BorderLayout.CENTER);
        centerPanel.add(btnAdd, BorderLayout.SOUTH);

        center.setLayout(new BorderLayout());
        center.add(centerPanel, BorderLayout.CENTER);
    }

    @Override
    protected void submitForm() {
        try {
            String title = tfTitle.getText();
            String category = tfCategory.getText();
            String director = tfDirector.getText();
            int length = Integer.parseInt(tfLength.getText());
            float cost = Float.parseFloat(tfCost.getText());

            DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
            store.addMedia(dvd);
            JOptionPane.showMessageDialog(this, "DVD added successfully!");

            // Clear form fields
            tfTitle.setText("");
            tfCategory.setText("");
            tfDirector.setText("");
            tfLength.setText("");
            tfCost.setText("");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values for length and cost.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}