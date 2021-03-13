import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


class DBServer
{
    private SqlFactory sqlFactory = new SqlFactory();

    public DBServer(int portNumber)
    {
        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            System.out.println("Server Listening");
            while(true) processNextConnection(serverSocket);
        } catch(IOException ioe) {
            System.err.println(ioe);
        }
    }

    private void processNextConnection(ServerSocket serverSocket)
    {
        try {
            Socket socket = serverSocket.accept();
            BufferedReader socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter socketWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            System.out.println("Connection Established");
            while(true) processNextCommand(socketReader, socketWriter);
        } catch(IOException ioe) {
            System.err.println(ioe);
        } catch(NullPointerException npe) {
            npe.printStackTrace();
            System.out.println("Connection Lost");
        }
    }

    private void processNextCommand(BufferedReader socketReader, BufferedWriter socketWriter) throws IOException, NullPointerException
    {
        String incomingCommand = socketReader.readLine();
        System.out.println("Received message: " + incomingCommand);
        /*
        * only thing we change in the server is adding a factory instance.
        * factory does 3 things:
        *   1.parse the command,
        *   2.generate a sql instance,
        *   3.run it
        * */
        String message = sqlFactory.parseAndRun(incomingCommand);
        socketWriter.write(message + "\n");
        System.out.println(message);
        System.out.println("-----------------------------");
        socketWriter.write("\n" + ((char)4) + "\n");
        socketWriter.flush();
    }

    public static void main(String args[])
    {
        DBServer server = new DBServer(8888);
    }

}
