import javax.naming.Name;
import javax.security.auth.Subject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class signupthree extends JFrame implements ActionListener {

    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton sumbit,cancel;

    String formno;
        signupthree(String formno){
            this.formno=formno;
            setVisible(true);
            setLayout(null);
            setTitle("Page 3: Account details");
            setSize(850,820);
            setLocation(350,0);
            getContentPane().setBackground(Color.WHITE);


            JLabel l1=new JLabel("Page 3: Account details");
            l1.setFont(new Font("Raleway",Font.BOLD,22));
            l1.setBounds(280,40,400,40);
            add(l1);

            JLabel type=new JLabel(" Account type");
            type.setFont(new Font("Raleway",Font.BOLD,22));
            type.setBounds(100,140,200,30);
            add(type);

            r1=new JRadioButton("Saving Account");
            r1.setFont(new Font("Raleway",Font.BOLD,16));
            r1.setBounds(100,180,150,20);
            r1.setBackground(Color.WHITE);
            add(r1);

            r2=new JRadioButton("Fixed Deposit  Account");
            r2.setFont(new Font("Raleway",Font.BOLD,16));
            r2.setBounds(350,180,250,20);
            r2.setBackground(Color.WHITE);
            add(r2);

            r3=new JRadioButton("Current Account");
            r3.setFont(new Font("Raleway",Font.BOLD,16));
            r3.setBounds(100,220,250,20);
            r3.setBackground(Color.WHITE);
            add(r3);

            r4=new JRadioButton("Reccuring Deposit Account");
            r4.setFont(new Font("Raleway",Font.BOLD,16));
            r4.setBounds(350,220,250,20);
            r4.setBackground(Color.WHITE);
            add(r4);

            ButtonGroup groupaccount=new ButtonGroup();
            groupaccount.add(r1);
            groupaccount.add(r2);
            groupaccount.add(r3);
            groupaccount.add(r4);

            JLabel card=new JLabel("Card Number");
            card.setFont(new Font("Raleway",Font.BOLD,22));
            card.setBounds(100,300,200,30);
            add(card);

            JLabel number=new JLabel("XXXX-XXXX-XXXX-4184");
            number.setFont(new Font("Raleway",Font.BOLD,22));
            number.setBounds(330,300,300,30);
            add(number);

            JLabel carddetail=new JLabel("This is your 16 digit card number");
            carddetail.setFont(new Font("Raleway",Font.BOLD,12));
            carddetail.setBounds(100,330,300,30);
            add(carddetail);


            JLabel pin=new JLabel("PIN: ");
            pin.setFont(new Font("Raleway",Font.BOLD,22));
            pin.setBounds(100,370,200,30);
            add(pin);

            JLabel pnumber=new JLabel("XXXX");
            pnumber.setFont(new Font("Raleway",Font.BOLD,22));
            pnumber.setBounds(330,370,300,30);
            add(pnumber);

            JLabel pindetail=new JLabel("You Four digit pin number");
            pindetail.setFont(new Font("Raleway",Font.BOLD,12));
            pindetail.setBounds(100,400,300,30);
            add(pindetail);


            JLabel services=new JLabel("Services Required: ");
            services.setFont(new Font("Raleway",Font.BOLD,22));
            services.setBounds(100,450,400,30);
            add(services);

            c1=new JCheckBox("ATM Card");
            c1.setBackground(Color.WHITE);
            c1.setFont(new Font("Raleway",Font.BOLD,16));
            c1.setBounds(100,500,200,30);
            add(c1);

            c2=new JCheckBox("Internet Banking");
            c2.setBackground(Color.WHITE);
            c2.setFont(new Font("Raleway",Font.BOLD,16));
            c2.setBounds(350,500,200,30);
            add(c2);

            c3=new JCheckBox("Mobile Banking");
            c3.setBackground(Color.WHITE);
            c3.setFont(new Font("Raleway",Font.BOLD,16));
            c3.setBounds(100,550,230,30);
            add(c3);

            c4=new JCheckBox("Email Alerts and SMS Alerts");
            c4.setBackground(Color.WHITE);
            c4.setFont(new Font("Raleway",Font.BOLD,16));
            c4.setBounds(350,550,200,30);
            add(c4);

            c5=new JCheckBox("Cheque Book");
            c5.setBackground(Color.WHITE);
            c5.setFont(new Font("Raleway",Font.BOLD,16));
            c5.setBounds(100,600,200,30);
            add(c5);

            c6=new JCheckBox("EStatement");
            c6.setBackground(Color.WHITE);
            c6.setFont(new Font("Raleway",Font.BOLD,16));
            c6.setBounds(350,600,200,30);
            add(c6);

            c7=new JCheckBox("I here By Declare That Above Entered Details are Correct to the Best of my Knowledge");
            c7.setBackground(Color.WHITE);
            c7.setFont(new Font("Raleway",Font.BOLD,12));
            c7.setBounds(100,680,900,30);
            add(c7);

            sumbit=new JButton("Sumbit");
            sumbit.setBackground(Color.WHITE);
            sumbit.setForeground(Color.BLACK);
            sumbit.setFont(new Font("Raleway",Font.BOLD,12));
            sumbit.setBounds(250,720,100,30);
            sumbit.addActionListener(this);
            add(sumbit);

            cancel=new JButton("Cancel");
            cancel.setBackground(Color.WHITE);
            cancel.setForeground(Color.BLACK);
            cancel.setFont(new Font("Raleway",Font.BOLD,12));
            cancel.setBounds(420,720,100,30);
            cancel.addActionListener(this);
            add(cancel);


        }

    @Override
    public void actionPerformed(ActionEvent a) {
        if (a.getSource()==sumbit) {
            String accounttype=null;
            if (r1.isSelected()) {
                accounttype="Saving account";
            } else if (r2.isSelected()) {
                accounttype="Fixed Deposit";
            } else if (r3.isSelected()) {
                accounttype="Current Account";
            } else if (r4.isSelected()) {
                accounttype="Reoccurring Deposit Account";
            }
            Random random=new Random();
            String cardnumber=""+Math.abs((random.nextLong()%90000000L)+5040936000000000L);
            String pinnumber=""+Math.abs((random.nextLong()%9000L)+1000);
            String facility="";
            if (c1.isSelected()){
                facility=facility+"Atm Card";
            } else if (c2.isSelected()) {
                facility=facility+"Internet Banking";
            } else if (c3.isSelected()) {
                facility=facility+"Mobile Banking";
            } else if (c4.isSelected()) {
                facility=facility+"Email & Sms Alert";
            } else if (c5.isSelected()) {
                facility=facility+"Cheque Book";
            } else if (c6.isSelected()) {
                facility=facility+"E=Statement";
            }

            try{
                if (accounttype.equals("")) {
                    JOptionPane.showMessageDialog(null,"Account Type is Required");
                } else  {
                    CON conn=new CON();
                    String querry1="insert into signupthree values('"+formno+"','"+accounttype+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                    String querry2="insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                    conn.s.executeUpdate(querry1);
                    conn.s.executeUpdate(querry2);

                    JOptionPane.showMessageDialog(null,"Card number"+cardnumber+"\n Pin: "+pinnumber);

                    setVisible(false);
                    new deposit(pinnumber).setVisible(true);

                }
            }catch (Exception e){
                e.printStackTrace();
            }

        } else if (a.getSource()==cancel) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }
            


        public static void main(String[] args) {
            new signupthree("");
        }
}


