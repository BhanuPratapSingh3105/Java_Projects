import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.Random;
public class Main extends JFrame {
  static JLabel l0,l1,l2,l3;
  static JTextField t1,t2,t3;
  static JButton b1;
  static JPanel p1,p2,p3,p4;
      static public String passwordGenerator(int len){
      String  UpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
      String LowerCase = "abcdefghijklmnopqrstuvwxyz";
      String Number = "0123456789";
      String SpecialCharacter = "!@#$%^&*()+_?><,./,}{][?";
      String Combination = UpperCase + LowerCase + Number + SpecialCharacter;
      int LenghthOfPassword = len;
      StringBuilder Password = new StringBuilder();
      Random r = new Random();
      for(int i=0; i<LenghthOfPassword; i++){
        int index = r.nextInt(Combination.length());
        Password.append(Combination.charAt(index));
      }
      return Password.toString();
    }
  public static void main(String[] args) {
    JFrame f = new JFrame("Password Generator");
    f.setLayout(new GridLayout(5,1));
    l0 = new JLabel();
    l0.setText("Password Generator");
    l0.setHorizontalAlignment(JLabel.CENTER);
    l0.setVerticalAlignment(JLabel.CENTER);
    f.add(l0);
    l0.setLayout(new FlowLayout());
    l1 = new JLabel("UserName:");
    l2 = new JLabel("Password Length:");
    l3 = new JLabel("Generated Password:");
    t1 = new JTextField(18);
    t2 = new JTextField(18);
    t3 = new JTextField(18);
    b1 = new JButton("Generate Password");
    p1= new JPanel();
    p2= new JPanel();
    p3= new JPanel();
    p4= new JPanel();
    p1.add(l1);
    p1.add(t1);
    p2.add(l2);
    p2.add(t2);
    p3.add(l3);
    p3.add(t3);
    p4.add(b1);
    f.add(p1);
    f.add(p2);
    f.add(p3);
    f.add(p4);
    p1.setLayout(new FlowLayout());
    p2.setLayout(new FlowLayout());
    p3.setLayout(new FlowLayout());
    p4.setLayout(new FlowLayout());
    b1.addActionListener(new GeneratePassword());
    f.setSize(400,400);
    f.setVisible(true);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Cursor c1 = new Cursor(Cursor.HAND_CURSOR);
    b1.setCursor(c1);
  }
  static class GeneratePassword implements ActionListener{
    public void actionPerformed(ActionEvent e1) {
      String s1 = t1.getText();
      int n1 = Integer.parseInt(t2.getText());
      String s2 = Main.passwordGenerator(n1);
      t3.setText(s2);
    }
  }
}
