package view;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientFormController {
    public TextField txtFld;
    public TextArea txtArea;
    public Text txtClientName;
    public VBox vBox;

    Socket socket;
    DataInputStream dataInputStream;
    DataOutputStream dataOutputStream;
    String message = "";
    String clientName = "Client";


    public void initialize(){

        clientName = ClientRegFormController.name;

        txtClientName.setText(clientName);

        new Thread(()->{

            try {

                socket = new Socket("localhost", 9000);
                txtArea.appendText("\n\nClient Connected !");

                dataInputStream = new DataInputStream(socket.getInputStream());
                dataOutputStream = new DataOutputStream(socket.getOutputStream());

                while(!message .equals("finish")){
                    message = dataInputStream.readUTF();
                    txtArea.appendText("\n\n Client : " + message);

                    Platform.runLater(()->{
                        Label text = new Label();
                        text.setText("   " + message + "   ");
                        text.setMinWidth(200);
                        final Group root = new Group();

                        final GridPane gridpane = new GridPane();
                        gridpane.setPadding(new Insets(5));
                        gridpane.setHgap(10);
                        gridpane.setVgap(10);
                        gridpane.minHeight(30);
                        text.maxHeight(200);
                        gridpane.maxHeight(200);


                        GridPane.setHalignment(text, HPos.CENTER);
                        gridpane.add(text, 0, 0);
                        gridpane.setAlignment(Pos.CENTER_LEFT);

                        root.getChildren().add(gridpane);

                        vBox.getChildren().add(gridpane);

                        txtFld.clear();
                    });


                }

                System.exit(0);

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        }).start();

    }

    public void btnSendOnAction(ActionEvent actionEvent) {

        try {


            Platform.runLater(()->{
                Label text = new Label();
                text.setText("   " + txtFld.getText() + "   ");
                System.out.println(txtFld.getText());
                //text.setMinWidth(200);
                final Group root = new Group();

                final GridPane gridpane = new GridPane();
                gridpane.setPadding(new Insets(5));
                gridpane.setHgap(10);
                gridpane.setVgap(10);
                gridpane.minHeight(30);
                text.maxHeight(200);
                gridpane.maxHeight(200);


                GridPane.setHalignment(text, HPos.CENTER);
                gridpane.add(text, 0, 0);
                gridpane.setAlignment(Pos.CENTER_RIGHT);

                root.getChildren().add(gridpane);

                vBox.getChildren().add(gridpane);
            });




            dataOutputStream.writeUTF(txtFld.getText().trim());
            dataOutputStream.flush();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
