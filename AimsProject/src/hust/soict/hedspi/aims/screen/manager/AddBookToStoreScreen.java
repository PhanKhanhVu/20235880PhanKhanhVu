package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfCost;
    private JTextArea tfAuthors;

    public AddBookToStoreScreen(Store store) {
        super(store);
        buildForm();
        setTitle("Add Book to Store");
    }

    @Override
    protected void buildForm() {
        JPanel formPanel = createFormPanel();

        tfTitle = new JTextField();
        tfCategory = new JTextField();
        tfCost = new JTextField();
        tfAuthors = new JTextArea(5, 20);
        tfAuthors.setLineWrap(true);
        JScrollPane authorsScrollPane = new JScrollPane(tfAuthors);

        addFormField(formPanel, "Title", tfTitle);
        addFormField(formPanel, "Category", tfCategory);
        addFormField(formPanel, "Cost", tfCost);
        JLabel authorsLabel = new JLabel("Authors (one per line): ");
        formPanel.add(authorsLabel);
        formPanel.add(authorsScrollPane);

        JButton btnAdd = new JButton("Add Book");
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
            float cost = Float.parseFloat(tfCost.getText());

            Book book = new Book(store.getItemsInStore().size() + 1, title, category, cost);

            String[] authorList = tfAuthors.getText().split("\n");
            for (String author : authorList) {
                if (!author.trim().isEmpty()) {
                    book.addAuthor(author.trim());
                }
            }

            store.addMedia(book);
            JOptionPane.showMessageDialog(this, "Book added successfully!");

            // Clear form fields
            tfTitle.setText("");
            tfCategory.setText("");
            tfCost.setText("");
            tfAuthors.setText("");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid cost value.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}