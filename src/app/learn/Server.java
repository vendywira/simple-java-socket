package app.learn;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class Server {

    private final List<Data> DATA_LIST;

    public Server() {
        DATA_LIST = Arrays.asList(
            new Data("23514009", 85f, 79f, 87f),
            new Data("0907103003", 95f, 73f, 78f)
        );
    }

    public Data search(String nim) {
        for (Data data : DATA_LIST) {
            if (data.getNim().equalsIgnoreCase(nim)) {
                return data;
            }
        }
        return null;
    }

    public Float calculateScore(Data data) {
        if (data != null) {
            return data.getTugas()*40/100 + data.getUts()*30/100 + data.getUas()*30/100;
        }
        return null;
    }

    public Data getDataFromDb(String nim) throws SQLException, ClassNotFoundException {
      Float tugas, uts, uas;
      String sql = "SELECT * FROM nilai WHERE nim = ?";
      PreparedStatement preparedStatement = ConnectDB.connect().prepareStatement(sql);
      preparedStatement.setString(1, nim);
      ResultSet result = preparedStatement.executeQuery();

      if (result.next()) {
        nim = result.getString("nim");
        tugas = result.getFloat("tugas");
        uts = result.getFloat("uts");
        uas = result.getFloat("uas");
        return new Data(nim, tugas, uts, uas);
      }

      return null;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ServerSocket ss = null;
        Server server = new Server();

        try {
            ss = new ServerSocket(3333);
            Socket s = ss.accept();
            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String nim = "";
            while (!nim.equalsIgnoreCase("stop")) {
                nim = din.readUTF();
                System.out.println("client says nim: " + nim);

//                Data data = server.search(nim);
                Data data = server.getDataFromDb(nim);
                Float score = server.calculateScore(data);

                if (score != null) {
                    dout.writeUTF(score.toString());
                } else {
                    dout.writeUTF("");
                }
                dout.flush();
            }
            din.close();
            s.close();
            ss.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
