package view;

import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client2FormController {
    public TextField txtFld;
    public TextArea txtArea;

    Socket socket;
    DataInputStream dataInputStream;
    DataOutputStream dataOutputStream;
    String message = "";

    public void initialize(){

        new Thread(()->{

            try {

                socket = new Socket("localhost", 9000);
                txtArea.appendText("\n\nClient Connected !");

                dataInputStream = new DataInputStream(socket.getInputStream());
                dataOutputStream = new DataOutputStream(socket.getOutputStream());

                while(!message .equals("finish")){
                    message = dataInputStream.readUTF();
                    txtArea.appendText("\n\nServer : " + message);
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
