import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {

    private static ServerSocket serverSocket;
    private static DataOutputStream dataOutputStream1;
    private static DataOutputStream dataOutputStream2;
    private static DataOutputStream dataOutputStream3;

    private static Socket socket1;
    private static Socket socket2;
    private static Socket socket3;

    public static void main(String[] args) {
        runOver();
    }




    public static void runOver(){

        try {
            System.out.println("============Server============");
            serverSocket = new ServerSocket(9000);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        new Thread(()->{

            try {

                socket1 = serverSocket.accept();

                System.out.println("Socket 1" + socket1.getPort());

                DataInputStream dataInputStream =
                        new DataInputStream(socket1.getInputStream());

                try {

                    dataOutputStream2 =
                            new DataOutputStream(socket2.getOutputStream());

                    dataOutputStream3 =
                            new DataOutputStream(socket3.getOutputStream());

                }catch (Exception e){
                    System.out.println(e.getMessage());
                }

                String message = "";
                String reply = "";

                while(!(message .equals("Finish") || reply.equals("Finish"))){
                    message = dataInputStream.readUTF();

                    if(dataOutputStream2 == null){
                        dataOutputStream2 = new DataOutputStream(socket2.getOutputStream());
                    }

                    if(dataOutputStream3 == null){
                        dataOutputStream3 = new DataOutputStream(socket3.getOutputStream());
                    }

                    dataOutputStream2.writeUTF(message);
                    dataOutputStream2.flush();

                    dataOutputStream3.writeUTF(message);
                    dataOutputStream3.flush();
                }


                dataOutputStream2.close();
                dataInputStream.close();

                dataOutputStream3.close();
                dataInputStream.close();

                socket1.close();


            } catch (IOException e) {

                System.out.println(e.getMessage());

            }


        }).start();



        //////////////////////////////////////



        new Thread(()->{

            try {

                socket2 = serverSocket.accept();

                System.out.println("Socket 2" + socket2.getPort());

                DataInputStream dataInputStream =
                        new DataInputStream(socket2.getInputStream());

                try{

                    dataOutputStream1 =
                            new DataOutputStream(socket1.getOutputStream());

                    dataOutputStream3 =
                            new DataOutputStream(socket3.getOutputStream());


                }catch (NullPointerException e){
                    System.out.println(e.getMessage());
                }


                String message = "";
                String reply = "";

                while(!(message .equals("Finish") || reply.equals("Finish"))){
                    message = dataInputStream.readUTF();


                    if(dataOutputStream1 == null){
                        dataOutputStream1 = new DataOutputStream(socket1.getOutputStream());
                    }

                    if(dataOutputStream3 == null){
                        dataOutputStream3 = new DataOutputStream(socket1.getOutputStream());
                    }

                    dataOutputStream1.writeUTF(message);
                    dataOutputStream1.flush();

                    dataOutputStream3.writeUTF(message);
                    dataOutputStream3.flush();

                }


                dataOutputStream1.close();
                dataInputStream.close();

                dataOutputStream3.close();
                dataInputStream.close();

                socket2.close();


            } catch (IOException e) {

                System.out.println(e.getMessage());

            }


        }).start();




        //////////////////////////////////////



        new Thread(()->{

            try {

                socket3 = serverSocket.accept();

                System.out.println("Socket 3" + socket3.getPort());

                DataInputStream dataInputStream =
                        new DataInputStream(socket3.getInputStream());

                try{

                    dataOutputStream1 =
                            new DataOutputStream(socket1.getOutputStream());

                    dataOutputStream2 =
                            new DataOutputStream(socket2.getOutputStream());


                }catch (NullPointerException e){
                    System.out.println(e.getMessage());
                }


                String message = "";
                String reply = "";

                while(!(message .equals("Finish") || reply.equals("Finish"))){
                    message = dataInputStream.readUTF();


                    if(dataOutputStream1 == null){
                        dataOutputStream1 = new DataOutputStream(socket1.getOutputStream());
                    }

                    if(dataOutputStream2 == null){
                        dataOutputStream2 = new DataOutputStream(socket1.getOutputStream());
                    }

                    dataOutputStream1.writeUTF(message);
                    dataOutputStream1.flush();

                    dataOutputStream2.writeUTF(message);
                    dataOutputStream2.flush();

                }


                dataOutputStream1.close();
                dataInputStream.close();

                dataOutputStream2.close();
                dataInputStream.close();

                socket3.close();


            } catch (IOException e) {

                System.out.println(e.getMessage());

            }


        }).start();



    }





    public static void run(){

        try {
            System.out.println("============Server============");
            serverSocket = new ServerSocket(9000);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        new Thread(()->{

            try {

                socket1 = serverSocket.accept();

                System.out.println("Socket 1" + socket1.getPort());

                DataInputStream dataInputStream =
                        new DataInputStream(socket1.getInputStream());

                try {

                    dataOutputStream2 =
                            new DataOutputStream(socket2.getOutputStream());

                }catch (Exception e){
                    System.out.println(e.getMessage());
                }

                String message = "";
                String reply = "";

                while(!(message .equals("Finish") || reply.equals("Finish"))){
                    message = dataInputStream.readUTF();

                    if(dataOutputStream2 == null){
                        dataOutputStream2 = new DataOutputStream(socket2.getOutputStream());
                    }

                    dataOutputStream2.writeUTF(message);
                    dataOutputStream2.flush();
                }


                dataOutputStream2.close();
                dataInputStream.close();
                socket1.close();


            } catch (IOException e) {

                System.out.println(e.getMessage());

            }


        }).start();


        new Thread(()->{

            try {

                socket2 = serverSocket.accept();

                System.out.println("Socket 2" + socket2.getPort());

                DataInputStream dataInputStream =
                        new DataInputStream(socket2.getInputStream());

                try{

                    dataOutputStream1 =
                            new DataOutputStream(socket1.getOutputStream());


                }catch (NullPointerException e){
                    System.out.println(e.getMessage());
                }


                String message = "";
                String reply = "";

                while(!(message .equals("Finish") || reply.equals("Finish"))){
                    message = dataInputStream.readUTF();


                    if(dataOutputStream1 == null){
                        dataOutputStream1 = new DataOutputStream(socket1.getOutputStream());
                    }

                    dataOutputStream1.writeUTF(message);
                    dataOutputStream1.flush();

                }


                dataOutputStream1.close();
                dataInputStream.close();
                socket2.close();


            } catch (IOException e) {

                System.out.println(e.getMessage());

            }


        }).start();

    }

}


