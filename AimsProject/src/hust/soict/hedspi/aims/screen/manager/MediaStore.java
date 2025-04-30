package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;
import java.awt.*;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;

public class MediaStore extends JPanel {
    private Media media;

    public MediaStore(Media media) {
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        if (media instanceof Playable) {
            JButton playButton = new JButton("Play");
            playButton.addActionListener(e -> {
                Playable playable = (Playable) media;
                JDialog playDialog = new JDialog();
                playDialog.setTitle("Playing " + media.getTitle());
                playDialog.setSize(400, 200);
                playDialog.setLayout(new BorderLayout());

                JTextArea playContent = new JTextArea();
                playContent.setEditable(false);
                playContent.setLineWrap(true);
                playContent.setWrapStyleWord(true);

                // Capture the play output
                java.io.ByteArrayOutputStream outputStream = new java.io.ByteArrayOutputStream();
                java.io.PrintStream originalOut = System.out;
                System.setOut(new java.io.PrintStream(outputStream));

                playable.play();

                // Restore original System.out and get the captured output
                System.setOut(originalOut);
                playContent.setText(outputStream.toString());

                playDialog.add(new JScrollPane(playContent), BorderLayout.CENTER);

                JButton closeButton = new JButton("Close");
                closeButton.addActionListener(closeEvent -> playDialog.dispose());

                JPanel buttonPanel = new JPanel();
                buttonPanel.add(closeButton);
                playDialog.add(buttonPanel, BorderLayout.SOUTH);

                playDialog.setLocationRelativeTo(null);
                playDialog.setVisible(true);
            });
            container.add(playButton);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}