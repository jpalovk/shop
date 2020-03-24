package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TableView<ModelTable> tableView;
    @FXML
    private TableColumn<ModelTable, String> col_id;
    @FXML
    private TableColumn<ModelTable, String> col_name;
    @FXML
    private TableColumn<ModelTable, String> col_price;
    @FXML
    private TableColumn<ModelTable, String> col_available;

    ObservableList<ModelTable> observableList = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Connection con = null;
        try {
            con = DBConnector.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            ResultSet rs = con.createStatement().executeQuery("select * from products");
            while (rs.next()){
                observableList.add(new ModelTable(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("price"),
                        rs.getString("available")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        col_available.setCellValueFactory(new PropertyValueFactory<>("available"));

        tableView.setItems(observableList);

    }
}
