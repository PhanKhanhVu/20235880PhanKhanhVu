package hust.soict.hedspi.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NumberGrid extends JFrame {
    private JButton[] btnNumbers = new JButton[10];
    private JButton btnDelete, btnReset;
    private JTextField tfDisplay;

    public NumberGrid() {
        tfDisplay = new JTextField();
        tfDisplay.setEditable(false);
        tfDisplay.setHorizontalAlignment(JTextField.RIGHT);
        tfDisplay.setFont(new Font("Arial", Font.BOLD, 20));

        JPanel panelButtons = new JPanel(new GridLayout(4, 3)); // 10 số + DEL + C

        addButtons(panelButtons);

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(tfDisplay, BorderLayout.NORTH);
        cp.add(panelButtons, BorderLayout.CENTER);

        setTitle("Number Grid");
        setSize(300, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    void addButtons(JPanel panel) {
        ButtonListener btnListener = new ButtonListener();

        for (int i = 1; i <= 9; i++) {
            btnNumbers[i] = new JButton(String.valueOf(i));
            panel.add(btnNumbers[i]);
            btnNumbers[i].addActionListener(btnListener);
        }

        btnDelete = new JButton("DEL");
        panel.add(btnDelete);
        btnDelete.addActionListener(btnListener);

        btnNumbers[0] = new JButton("0");
        panel.add(btnNumbers[0]);
        btnNumbers[0].addActionListener(btnListener);

        btnReset = new JButton("C");
        panel.add(btnReset);
        btnReset.addActionListener(btnListener);
    }
    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String button = e.getActionCommand();

            if (button.equals("DEL")) {
                // Xóa ký tự cuối cùng nếu có
                String current = tfDisplay.getText();
                if (!current.isEmpty()) {
                    tfDisplay.setText(current.substring(0, current.length() - 1));
                }
            } else if (button.equals("C")) {
                // Xóa toàn bộ
                tfDisplay.setText("");
            } else {
                // Thêm số
                tfDisplay.setText(tfDisplay.getText() + button);
            }
        }
    }
    public static void main(String[] args) {
        new NumberGrid();
    }
}
