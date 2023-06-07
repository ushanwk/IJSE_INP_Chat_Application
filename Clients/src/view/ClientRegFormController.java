package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ClientRegFormController {
    public TextField txtFldName;

    public static String name;

    public void btnAddOnAction(ActionEvent actionEvent) throws IOException {

        name = txtFldName.getText();

        Parent root = FXMLLoader.load(getClass().getResource("/view/ClientForm.fxml"));
        Stage stage = new Stage();
        Scene scene =new Scene(root);
        stage.setScene(scene);
        stage.show();

        txtFldName.clear();

    }
}
