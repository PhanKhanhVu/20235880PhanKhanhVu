package hust.soict.hedspi.aims.screen.customer.controller;

import javax.naming.LimitExceededException;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ItemController {
    private Media media;
    private Cart cart;
    private Store store;

    public void setData(Media media) {
        this.media = media;
        lblTitle.setText(media.getTitle());
        lblCost.setText(media.getCost() + " $");

        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
            HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 60));
        }
    }

    public ItemController(Cart cart) {
        this.cart = cart;
    }

    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    private Label lblTitle;

    @FXML
    private Label lblCost;

    @FXML
    void btnAddToCartClicked(ActionEvent event) throws LimitExceededException {
        cart.addMedia(media);
        System.out.println("Added to cart: " + media.getTitle());
    }

    @FXML
    void btnPlayClicked(ActionEvent event) {
        try {
            if (media instanceof Playable) {
                ((Playable) media).play();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Play Media");
                alert.setHeaderText(null);
                alert.setContentText("Đang phát: " + media.getTitle());
                alert.showAndWait();
            }
        } catch (PlayerException e) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Lỗi phát media");
            errorAlert.setHeaderText("Không thể phát media");
            errorAlert.setContentText(e.getMessage());
            errorAlert.showAndWait();

            System.err.println("Lỗi khi phát media: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Lỗi không xác định");
            errorAlert.setHeaderText("Đã xảy ra lỗi");
            errorAlert.setContentText("Có lỗi xảy ra khi phát media: " + e.getMessage());
            errorAlert.showAndWait();

            System.err.println("Lỗi không xác định: " + e.getMessage());
            e.printStackTrace();
        }
    }

}