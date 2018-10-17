package app.learn;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {

  public static void main(String[] args) {
    try {
      Socket s = new Socket("localhost", 3333);
      DataInputStream din = new DataInputStream(s.getInputStream());
      DataOutputStream dout = new DataOutputStream(s.getOutputStream());
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      String nim = "", score = "";

      while (!nim.equals("stop")) {
        System.out.print("\nInput nim : ");
        nim = br.readLine();
        dout.writeUTF(nim);
        dout.flush();
        score = din.readUTF();
        System.out.println("Final score : " + (score.isEmpty() ? "data not found" : score));
        System.out.println("Grade score : " + gradeScore(score.isEmpty() ? null : Float.parseFloat(score)));
      }

      dout.close();
      s.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  private static String gradeScore(Float score) {
    String grade = "";

    if (score == null) {
      grade = "F";
    } else if (score > 85) {
      grade = "A";
    } else if (score > 70 && score <= 85){
      grade = "B";
    } else if (score > 55 && score <= 70) {
      grade = "C";
    } else if (score > 40 && score <= 55) {
      grade = "D";
    } else if (score >= 0 && score <= 40) {
      grade = "E";
    } else {
      grade = "F";
    }

    return grade;
  }
}
