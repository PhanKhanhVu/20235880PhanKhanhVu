package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;
import java.awt.*;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.*;

public class StoreManagerScreen extends JFrame {
    private Store store;

    public StoreManagerScreen(Store store) {
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("Store Manager");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));

        JMenuBar menuBar = createMenuBar();
        JPanel header = createHeader();

        north.add(menuBar);
        north.add(header);

        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");

        JMenuItem addBook = new JMenuItem("Add Book");
        addBook.addActionListener(e -> {
            new AddBookToStoreScreen(store);
            dispose(); // Đóng màn hình hiện tại nếu muốn
        });

        JMenuItem addCD = new JMenuItem("Add CD");
        addCD.addActionListener(e -> {
            new AddCompactDiscToStoreScreen(store);
            dispose();
        });

        JMenuItem addDVD = new JMenuItem("Add DVD");
        addDVD.addActionListener(e -> {
            new AddDigitalVideoDiscToStoreScreen(store);
            dispose();
        });

        smUpdateStore.add(addBook);
        smUpdateStore.add(addCD);
        smUpdateStore.add(addDVD);

        JMenuItem viewStore = new JMenuItem("View Store");
        viewStore.addActionListener(e -> {
            new StoreManagerScreen(store); // mở lại màn hình chính
            dispose();
        });

        menu.add(smUpdateStore);
        menu.add(viewStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }


    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS", JLabel.CENTER);
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }
    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        for (Media m : store.getItemsInStore()) {
            MediaStore cell = new MediaStore(m);
            center.add(cell);
        }

        return center;
    }

    public static void main(String[] args) {
        Store store = new Store();
        // Thêm sản phẩm thử
        store.addMedia(new DigitalVideoDisc("DVD Title", "Category", "Director", 120, 15.5f));
        // Thêm sách mẫu
        store.addMedia(new Book(1,"The Lord of the Rings", "Fantasy", 12.99f));
        store.addMedia(new Book(2,"Effective Java", "Programming", 35.50f));
        // Thêm DVD mẫu
        store.addMedia(new DigitalVideoDisc("Inception", "Sci-Fi", "Christopher Nolan", 148, 19.99f));
        store.addMedia(new DigitalVideoDisc("Interstellar", "Sci-Fi", "Christopher Nolan", 169, 21.50f));
        new StoreManagerScreen(store);
    }
}