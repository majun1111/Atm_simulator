import javax.swing.*;
import java.awt.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;


public class SignupOne extends JFrame  implements ActionListener{
long random;
JTextField nametextfield,fnametextfield,emailtextfield,addresstextfield,citytextfield,pintextfield,statetextfield;
JButton next;
JRadioButton male,female,other,married,single;
JDateChooser dateChooser;

    SignupOne (){
        setLayout(null);
        Random ran=new Random();
        long random=(Math.abs(ran.nextLong()%9000L)+1000L);
        JLabel formno=new JLabel("APPLICATION FROM No. "+random);
       formno.setFont(new Font("Raleway",Font.BOLD,38));
       formno.setBounds(140,20,600,40);
       add(formno);

        JLabel personalDetails=new JLabel("Page 1: Personal Details. ");
        personalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personalDetails.setBounds(290,80,400,30);
        add(personalDetails);

        JLabel name=new JLabel("Name : ");
        name.setFont(new Font("Raleway",Font.BOLD,22));
        name.setBounds(100,140,100,30);
        add(name);

         nametextfield =new JTextField();
        nametextfield.setFont(new Font("Raleway",Font.BOLD,14));
        nametextfield.setBounds(300,140,400,30);
        add(nametextfield);

        JLabel fname=new JLabel("Father's Name :");
        fname.setFont(new Font("Raleway",Font.BOLD,22));
        fname.setBounds(100,190,200,30);
        add(fname);

        fnametextfield =new JTextField();
        fnametextfield.setFont(new Font("Raleway",Font.BOLD,14));
        fnametextfield.setBounds(300,190,400,30);
        add(fnametextfield);

        JLabel dob=new JLabel("Date Of Birth :");
        dob.setFont(new Font("Raleway",Font.BOLD,22));
        dob.setBounds(100,240,200,30);
        add(dob);

         dateChooser=new JDateChooser();
        dateChooser.setBounds(300,240,400,30);
        dateChooser.setForeground(new Color(105,105,105));
        add(dateChooser);

        JLabel gender=new JLabel("Gender :");
        gender.setFont(new Font("Raleway",Font.BOLD,22));
        gender.setBounds(100,290,200,30);
        add(gender);

        male =new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.WHITE);
        add(male);


         female=new JRadioButton("Female");
        female.setBounds(450,290,120,30);
        female.setBackground(Color.WHITE);
        add(female);

     ButtonGroup gendergroup= new ButtonGroup();
     gendergroup.add(male);
     gendergroup.add(female);


        JLabel email=new JLabel("Email :");
        email.setFont(new Font("Raleway",Font.BOLD,22));
        email.setBounds(100,340,200,30);
        add(email);

         emailtextfield =new JTextField();
        emailtextfield.setFont(new Font("Raleway",Font.BOLD,14));
        emailtextfield.setBounds(300,340,400,30);
        add(emailtextfield);

        JLabel mstatus=new JLabel("Marital Status :");
        mstatus.setFont(new Font("Raleway",Font.BOLD,22));
        mstatus.setBounds(100,390,200,30);
        add(mstatus);

         single =new JRadioButton("Single");
        single.setBounds(300,390,120,30);
        single.setBackground(Color.WHITE);
        add(single);

         married =new JRadioButton("Married");
        married.setBounds(450,390,120,30);
        married.setBackground(Color.WHITE);
        add(married);

         other =new JRadioButton("Other");
        other.setBounds(630,390,120,30);
        other.setBackground(Color.WHITE);
        add(other);

        ButtonGroup maritalgroup=new ButtonGroup();
        maritalgroup.add(single);
        maritalgroup.add(married);
        maritalgroup.add(other);


        JLabel addr=new JLabel("Address :");
        addr.setFont(new Font("Raleway",Font.BOLD,22));
        addr.setBounds(100,440,200,30);
        add(addr);

         addresstextfield =new JTextField();
        addresstextfield.setFont(new Font("Raleway",Font.BOLD,14));
        addresstextfield.setBounds(300,440,400,30);
        add(addresstextfield);

        JLabel city =new JLabel("City :");
        city.setFont(new Font("Raleway",Font.BOLD,22));
        city.setBounds(100,490,200,30);
        add(city);

        citytextfield =new JTextField();
        citytextfield.setFont(new Font("Raleway",Font.BOLD,14));
        citytextfield.setBounds(300,490,400,30);
        add(citytextfield);


        JLabel state =new JLabel("State :");
        state.setFont(new Font("Raleway",Font.BOLD,22));
        state.setBounds(100,540,200,30);
        add(state);

        statetextfield =new JTextField();
        statetextfield.setFont(new Font("Raleway",Font.BOLD,14));
        statetextfield.setBounds(300,540,400,30);
        add(statetextfield);

        JLabel pin =new JLabel("Pin Code :");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,590,200,30);
        add(pin);

        pintextfield=new JTextField();
        pintextfield.setFont(new Font("Raleway",Font.BOLD,14));
        pintextfield.setBounds(300,590,400,030);
        add(pintextfield);

         next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,662,80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String formo = "" + random;//long
        String name = nametextfield.getText();
        String fname = fnametextfield.getName();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()) {
            gender = "Male";
        } else {
            gender = "Female";
        }
        String email = emailtextfield.getText();
        String marital = null;
        if (married.isSelected()) {
            marital = "married";
        } else if (single.isSelected()) {
            marital = "Single";
        } else if (other.isSelected()) {
            marital = "Others";
        }
        String address = addresstextfield.getText();
        String city = citytextfield.getText();
        String state = statetextfield.getText();
        String pin = pintextfield.getText();

        try {
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is Required");
            }else{
                CON c=new CON();
                String query="insert into signup values ('"+formo+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
                c.s.executeUpdate(query);


                setVisible(false);
                new Signuptwo(formo).setVisible(true);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new SignupOne();
    }
}
