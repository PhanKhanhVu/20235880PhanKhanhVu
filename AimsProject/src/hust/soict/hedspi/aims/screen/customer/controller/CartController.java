package hust.soict.hedspi.aims.screen.customer.controller;

import java.io.IOException;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CartController {
    Cart cart;
    Store store;
    private FilteredList<Media> filteredMedia;

    public CartController(Store store, Cart cart) {
        this.cart = cart;
        this.store = store;
    }

    @FXML
    private Label lblTotalCost;

    @FXML
    private TextField tfFilter;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media != null && media instanceof Playable) {
            try {
                ((Playable) media).play();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Play Media");
                alert.setHeaderText(null);
                alert.setContentText("Đang phát: " + media.getTitle());
                alert.showAndWait();

                System.out.println("Playing media: " + media.getTitle());
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

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media != null) {
            cart.removeMedia(media);
            showFilteredMedia(tfFilter.getText());
        }
    }

    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        if (cart.getItemsOrdered().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Giỏ hàng trống");
            alert.setHeaderText(null);
            alert.setContentText("Hãy thêm sản phẩm vào giỏ hàng trước khi đặt hàng!");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Đặt hàng thành công");
            alert.setHeaderText(null);
            alert.setContentText("Đơn hàng của bạn đã được đặt thành công!");
            alert.showAndWait();

            // Xóa tất cả sản phẩm trong giỏ hàng sau khi đặt hàng thành công
            cart.getItemsOrdered().clear();
            updateTotalCost();
        }
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
        try {
            final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
            ViewStoreController viewStoreController = new ViewStoreController(store, cart);
            fxmlLoader.setController(viewStoreController);
            Parent root = fxmlLoader.load();

            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Store");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initialize() {
        colMediaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        filteredMedia = new FilteredList<>(cart.getItemsOrdered(), p -> true);
        tblMedia.setItems(filteredMedia);

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                (ObservableValue<? extends Media> observable, Media oldValue, Media newValue) -> {
                    updateButtonBar(newValue);
                });

        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                                String oldValue, String newValue) {
                showFilteredMedia(newValue);
            }
        });

        radioBtnFilterId.selectedProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal) showFilteredMedia(tfFilter.getText());
        });

        radioBtnFilterTitle.selectedProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal) showFilteredMedia(tfFilter.getText());
        });

        radioBtnFilterId.setSelected(true);

        updateTotalCost();

        cart.getItemsOrdered().addListener((ListChangeListener<Media>) change -> {
            while (change.next()) {
                if (change.wasAdded() || change.wasRemoved()) {
                    updateTotalCost();
                }
            }
        });
    }

    void updateButtonBar(Media media) {
        if (media == null) {
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
        } else {
            btnRemove.setVisible(true);
            if (media instanceof Playable) {
                btnPlay.setVisible(true);
            } else {
                btnPlay.setVisible(false);
            }
        }
    }


    private void showFilteredMedia(String filterText) {
        System.out.println("Filtering with text: " + filterText + ", ID filter: " + radioBtnFilterId.isSelected());
        if (filterText == null || filterText.trim().isEmpty()) {
            filteredMedia.setPredicate(media -> true);
            System.out.println("Showing all media");
            return;
        }

        String lowerCaseFilter = filterText.trim().toLowerCase();

        if (radioBtnFilterId.isSelected()) {
            filteredMedia.setPredicate(media -> {
                if (media == null) return false;
                try {
                    boolean matches = String.valueOf(media.getId()).toLowerCase().contains(lowerCaseFilter);
                    System.out.println("Checking ID: " + media.getId() + ", Matches: " + matches);
                    return matches;
                } catch (NullPointerException e) {
                    return false;
                }
            });
        } else if (radioBtnFilterTitle.isSelected()) {
            filteredMedia.setPredicate(media -> {
                if (media == null || media.getTitle() == null) return false;
                boolean matches = media.getTitle().toLowerCase().contains(lowerCaseFilter);
                System.out.println("Checking Title: " + media.getTitle() + ", Matches: " + matches);
                return matches;
            });
        }
    }


    public void updateTotalCost() {
        float totalCost = cart.totalCost();
        lblTotalCost.setText(String.format("%.2f $", totalCost));
    }
}