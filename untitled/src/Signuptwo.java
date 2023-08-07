import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Signuptwo extends JFrame  implements ActionListener{

    JTextField nametextfield,fnametextfield,emailtextfield,pan,adhar,pintextfield,statetextfield;
    JButton next;
    JRadioButton sno,syes,eyes,eno;
    JComboBox religion,category,occpuation,education,income;
    String formo;


    Signuptwo (String formo){
        this.formo=formo;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FROM -- PAGE 2");


        JLabel additionalDetails=new JLabel("Page 2: Additional Details. ");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);

        JLabel name=new JLabel("Religion : ");
        name.setFont(new Font("Raleway",Font.BOLD,22));
        name.setBounds(100,140,100,30);
        add(name);


        String valReli[]= {"Hindu", "Muslim", "Sikh", "Christan", "Others"};
         religion=new JComboBox(valReli);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);

        JLabel fname=new JLabel("Category :");
        fname.setFont(new Font("Raleway",Font.BOLD,22));
        fname.setBounds(100,190,200,30);
        add(fname);

        String valcategory[]={"General","OBC","SC","ST","Others"};
         category=new JComboBox<>(valcategory);
        category.setFont(new Font("Raleway",Font.BOLD,14));
        category.setBounds(300,190,400,30);
        category.setBackground(Color.WHITE);
        add(category);

        JLabel dob=new JLabel("Income :");
        dob.setFont(new Font("Raleway",Font.BOLD,22));
        dob.setBounds(100,240,200,30);
        add(dob);


        String incval[]={"Null","<1,50,000","<2,50,000","<5,00,000","upto 10,00,000","above 10,00,000"};
         income=new JComboBox<>(incval);
        income.setFont(new Font("Raleway",Font.BOLD,14));
        income.setBounds(300,240,400,30);
        income.setBackground(Color.WHITE);
        add(income);

        String educationaldet[]={"Non Graduate","Graduate","Post Graduate","Doctorate","Others"};
        education=new JComboBox<>(educationaldet);
        education.setBounds(300,305,400,30);
        education.setBackground(Color.WHITE);
        add(education);

        JLabel gender=new JLabel("Educational");
        gender.setFont(new Font("Raleway",Font.BOLD,22));
        gender.setBounds(100,290,200,30);
        add(gender);

        JLabel email=new JLabel("Qualification :");
        email.setFont(new Font("Raleway",Font.BOLD,22));
        email.setBounds(100,315,200,30);
        add(email);

        String occpuationvalues[]={"Salaried","Self Employed","Business","Student","Retried","Others"};
         occpuation=new JComboBox<>(occpuationvalues);
        occpuation.setBounds(300,390,400,30);
        occpuation.setBackground(Color.WHITE);
        add(occpuation);

        JLabel mstatus=new JLabel("Occupation :");
        mstatus.setFont(new Font("Raleway",Font.BOLD,22));
        mstatus.setBounds(100,390,200,30);
        add(mstatus);

        JLabel addr=new JLabel("PAN Number :");
        addr.setFont(new Font("Raleway",Font.BOLD,22));
        addr.setBounds(100,440,200,30);
        add(addr);

        pan =new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,14));
        pan.setBounds(300,440,400,30);
        add(pan);

        JLabel city =new JLabel("Adhar Number :");
        city.setFont(new Font("Raleway",Font.BOLD,22));
        city.setBounds(100,490,200,30);
        add(city);

        adhar =new JTextField();
        adhar.setFont(new Font("Raleway",Font.BOLD,14));
        adhar.setBounds(300,490,400,30);
        add(adhar);


        JLabel state =new JLabel("Senior Citizen :");
        state.setFont(new Font("Raleway",Font.BOLD,22));
        state.setBounds(100,540,200,30);
        add(state);

        syes =new JRadioButton("Yes");
        syes.setBounds(300,540,120,30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno =new JRadioButton("No");
       sno.setBounds(450,540,120,30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup yesnogroup=new ButtonGroup();
        yesnogroup.add(sno);
        yesnogroup.add(syes);



        JLabel pin =new JLabel("Existing Account :");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,590,200,30);
        add(pin);

        eyes =new JRadioButton("Yes");
        eyes.setBounds(300,590,120,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno =new JRadioButton("No");
        eno.setBounds(450,590,120,30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup egroup=new ButtonGroup();
        egroup.add(eno);
        egroup.add(eyes);

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
        String formo = "" ;
        String srelgion = (String)religion.getSelectedItem();
        String scategory =(String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation=(String) education.getSelectedItem();
        String soccpuation = (String) occpuation.getSelectedItem();
        String seniorcitizen=null;
        if (syes.isSelected()) {
             seniorcitizen= "Yes";
        } else if (sno.isSelected()) {
            seniorcitizen = "no";
        }
        String existingacc = null;
        if (eyes.isSelected()) {
            existingacc = "married";
        } else if (eno.isSelected()) {
            existingacc = "Single";
        }
        String span = pan.getText();
        String sadhar = adhar.getText();

        try {
                CON c1=new CON();
                String query="insert into signuptwo values ('"+formo+"','"+srelgion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccpuation+"','"+span+"','"+sadhar+"','"+seniorcitizen+"','"+existingacc+"')";
                c1.s.executeUpdate(query);


                // Signup 3
            setVisible(false);
            new signupthree(formo).setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Signuptwo("");
    }
}
