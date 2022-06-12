import javax.print.DocFlavor.STRING;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.*;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;




public class Test_login  implements ActionListener, MouseMotionListener{

    


        public static void main(String args[]){
            
            prepareGUI();
        }



        public static void prepareGUI(){
            JFrame frame = new JFrame();
            JPanel panel_right = new JPanel();      
            JPanel panel_left = new JPanel();   
            Color r = new Color(230,255,143);
           
            
            frame.setSize( 700, 400);
            frame.setLocationRelativeTo(null);
            // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setUndecorated(true);



            panel_left.setSize(350,400);
            panel_left.setLayout(null);
            panel_left.setBackground(Color.lightGray);            
            frame.add(panel_left);




            panel_right.setSize(350, 400);
            panel_right.setLayout(null);
            panel_right.setBackground(r);            
            frame.add(panel_right);
            

            JLabel account = new JLabel("account");
            account.setBounds(360,160,80,25);
            panel_right.add(account);
            
            JTextField acc = new JTextField();
            acc.setBounds(450,160,165,25);
            acc.setBorder(BorderFactory.createEmptyBorder());
            acc.setBackground(Color.GRAY);
            panel_right.add(acc);
            
            JLabel password = new JLabel("password");
            password.setBounds(360,190,80,25);
            panel_right.add(password);

            JPasswordField pw = new JPasswordField();
            pw.setBounds(450,190,165,25);
            pw.setBorder(BorderFactory.createEmptyBorder());
            pw.setBackground(Color.GRAY);
            panel_right.add(pw);
            

            JButton login = new JButton("Login");
            login.setBounds(10, 80, 80, 25);
            login.addActionListener(new Test_login(){
                public void actionPerformed(ActionEvent e) {
                    System.out.println("click ");  
                    String ps = new String(pw.getPassword());
                    System.out.println(ps);  
                }
            });            
            panel_left.add(login);
            
            JLabel exit = new JLabel("X");
            exit.setBounds(682,0,18,25);
            exit.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK, 1),
            BorderFactory.createEmptyBorder(0, 3, 0, 3)));
            exit.addMouseMotionListener(new MouseMotionAdapter() {
                public void mouseDragged(MouseEvent e) {
                    System.exit(0);
                }
            });
            panel_right.add(exit);

            frame.setVisible(true);
            
        }



        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            
        }



        @Override
        public void mouseDragged(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }



        @Override
        public void mouseMoved(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }



        
        

        
        

}