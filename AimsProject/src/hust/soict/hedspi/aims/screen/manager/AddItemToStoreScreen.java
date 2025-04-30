package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;
    protected JPanel center;

    public AddItemToStoreScreen(Store store) {
        this.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        center = new JPanel();
        cp.add(center, BorderLayout.CENTER);

        setTitle("Add Item to Store");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    private JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        // Submenu Update Store
        JMenu smUpdateStore = new JMenu("Update Store");

        // Add Book
        JMenuItem addBookItem = new JMenuItem("Add Book");
        addBookItem.addActionListener(e -> {
            new AddBookToStoreScreen(store);
            // this.dispose(); // Có thể giữ hoặc bỏ tùy bạn muốn đóng màn hình hiện tại hay không
        });

        // Add CD
        JMenuItem addCDItem = new JMenuItem("Add CD");
        addCDItem.addActionListener(e -> {
            new AddCompactDiscToStoreScreen(store);
            // this.dispose();
        });

        // Add DVD
        JMenuItem addDVDItem = new JMenuItem("Add DVD");
        addDVDItem.addActionListener(e -> {
            new AddDigitalVideoDiscToStoreScreen(store);
            // this.dispose();
        });

        // Thêm các item vào submenu Update Store
        smUpdateStore.add(addBookItem);
        smUpdateStore.add(addCDItem);
        smUpdateStore.add(addDVDItem);

        // View Store
        JMenuItem viewStoreItem = new JMenuItem("View Store");
        viewStoreItem.addActionListener(e -> {
            new StoreManagerScreen(store);
            // this.dispose();
        });

        // Thêm các menu chính
        menu.add(smUpdateStore);
        menu.add(viewStoreItem);

        // Tạo menu bar
        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }


    private JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("ADD ITEM");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    protected JPanel createFormPanel() {
        JPanel formPanel = new JPanel(new GridLayout(0, 2, 5, 5));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        return formPanel;
    }

    protected void addFormField(JPanel panel, String label, JComponent field) {
        panel.add(new JLabel(label + ": "));
        panel.add(field);
    }

    protected abstract void buildForm();
    protected abstract void submitForm();
}