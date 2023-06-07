package view;

import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientFormController {
    public TextField txtFld;
    public TextArea txtArea;
    public Text txtClientName;

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
                }

                System.exit(0);

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        }).start();

    }

    public void btnSendOnAction(ActionEvent actionEvent) {

        try {

            dataOutputStream.writeUTF(txtFld.getText().trim());
            dataOutputStream.flush();

            txtFld.clear();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
