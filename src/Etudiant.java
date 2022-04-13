import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Etudiant extends JFrame {
    public Etudiant(){
        setTitle("Getion");
        // setUndecorated(true);
        setBounds(5,5,1000,600);


        JPanel paneltitre = new JPanel();
        paneltitre.setLayout(new FlowLayout(FlowLayout.CENTER,10,30));
        paneltitre.setBounds(5,5,980,80);
        paneltitre.setBorder(new LineBorder(Color.PINK,2));
        JLabel lab = new JLabel("Getion Etudiants");
        paneltitre.add(lab);
        add(paneltitre);


        JLabel lab1 = new JLabel("Nom");
        JTextField nom = new JTextField(10);

        JLabel lab2 = new JLabel("Prenom");
        JTextField prenom = new JTextField(10);

        JLabel lab3 = new JLabel("Date de Naissance");
        JTextField date = new JTextField(10);

        JLabel lab4 = new JLabel("Lieu de Naissance");
        JTextField lieu =new JTextField(10);

        JLabel lab5 = new JLabel("NNI");
        JTextField NNI = new JTextField(7);

        JLabel lab6 = new JLabel("Tel");
        JTextField tel = new JTextField(10);

        JLabel lab7 = new JLabel("Annee");
        String annees[] = {"L1","L2","L3"};

        JComboBox cb1 = new JComboBox(annees);
        JLabel lab8 = new JLabel("Semester");

        String semestres[] = {"S1","S2","S3","S4","S5","S6"};
        JComboBox cb2 = new JComboBox(semestres);

        JPanel panelSaisie = new JPanel();
        panelSaisie.setBounds(5,90,370,420);
        panelSaisie.setBorder(new LineBorder(Color.PINK,2));
        panelSaisie.setLayout(new GridLayout(8,2, 10, 20));

        panelSaisie.add(lab1);
        panelSaisie.add(nom);
        nom.setBorder(new LineBorder(Color.LIGHT_GRAY));

        panelSaisie.add(lab2);
        panelSaisie.add(prenom);
        prenom.setBorder(new LineBorder(Color.LIGHT_GRAY));

        panelSaisie.add(lab4);
        panelSaisie.add(date);
        date.setBorder(new LineBorder(Color.LIGHT_GRAY));

        panelSaisie.add(lab3);
        panelSaisie.add(lieu);
        lieu.setBorder(new LineBorder(Color.LIGHT_GRAY));

        panelSaisie.add(lab5);
        panelSaisie.add(NNI);
        NNI.setBorder(new LineBorder(Color.LIGHT_GRAY));

        panelSaisie.add(lab6);
        panelSaisie.add(tel);
        tel.setBorder(new LineBorder(Color.LIGHT_GRAY));

        panelSaisie.add(lab7);
        panelSaisie.add(cb1);
        cb1.setBorder(new LineBorder(Color.LIGHT_GRAY));

        panelSaisie.add(lab8);
        panelSaisie.add(cb2);
        cb2.setBorder(new LineBorder(Color.LIGHT_GRAY));
        add(panelSaisie);

        JPanel paneltab = new JPanel();
        paneltab.setBounds(380, 90, 605, 420);
        paneltab.setBorder(new LineBorder(Color.PINK, 2));


        String[] columnNames = {"Nom", "Prenom", "LieuNaiss", "dateNaiss", "NNI", "Tel","Annee","Semester"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable  table = new JTable(model);
        

        paneltab.setLayout(new FlowLayout(FlowLayout.LEFT,1,1));
        paneltab.add(table.getTableHeader(), BorderLayout.NORTH);
        paneltab.add(table);
        add(paneltab);

        JButton b1 = new JButton("Ajouter");
        b1.setPreferredSize(new Dimension(165,63));
        b1.setBackground(Color.WHITE);
        b1.setBorder(new LineBorder(Color.WHITE));
        JButton b2=new JButton("Modifier");
        b2.setPreferredSize(new Dimension(165,63));
        b2.setBackground(Color.WHITE);
        b2.setBorder(new LineBorder(Color.WHITE));
        JButton b3=new JButton("Suprimer");
        b3.setPreferredSize(new Dimension(165,63));
        b3.setBackground(Color.WHITE);
        b3.setBorder(new LineBorder(Color.WHITE));
        JButton b4=new JButton("Vider");
        b4.setPreferredSize(new Dimension(180,63));
        b4.setBackground(Color.WHITE);
        b4.setBorder(new LineBorder(Color.WHITE));
        JButton b5=new JButton("Fermer");
        b5.setPreferredSize(new Dimension(225,63));
        b5.setBackground(Color.WHITE);
        b5.setBorder(new LineBorder(Color.WHITE));
        JPanel panelbtn=new JPanel();
        panelbtn.setLayout(new FlowLayout(FlowLayout.LEFT,10,7));

        panelbtn.setBounds(5,515,980,80);
        panelbtn.setBorder(new LineBorder(Color.PINK,2));
        panelbtn.add(b1);
        panelbtn.add(b2);
        panelbtn.add(b3);
        panelbtn.add(b4);
        panelbtn.add(b5);
        add(panelbtn);



        // button => ajouter
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.addRow(
                        new Object[]{
                                nom.getText(),
                                prenom.getText(),
                                date.getText(),
                                lieu.getText(),
                                NNI.getText(),
                                tel.getText(),
                                cb1.getSelectedItem(),
                                cb2.getSelectedItem()
                        }
                );
            }
        });
        // button => modifier
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selected = table.getSelectedRow();
                nom.setText(table.getModel().getValueAt(selected, 0).toString());
                prenom.setText(table.getModel().getValueAt(selected, 1).toString());
                date.setText(table.getModel().getValueAt(selected, 2).toString());
                lieu.setText(table.getModel().getValueAt(selected, 3).toString());
                NNI.setText(table.getModel().getValueAt(selected, 4).toString());
                tel.setText(table.getModel().getValueAt(selected, 5).toString());
                cb1.setSelectedItem(table.getModel().getValueAt(selected, 6).toString());
                cb2.setSelectedItem(table.getModel().getValueAt(selected, 7).toString());

                JTextField[] fields = new JTextField[] {nom, prenom, date, lieu, NNI, tel};
                for(int i = 0; i < fields.length; i++) {
                    int I = i;
                    fields[i].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            model.setValueAt(fields[I].getText(), selected, I);
                            fields[I].removeActionListener(this);
                        }
                    });
                }
                cb1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        model.setValueAt(cb1.getSelectedItem(), selected, 6);
                        cb1.removeActionListener(this);
                    }
                });
                cb2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        model.setValueAt(cb2.getSelectedItem(), selected, 7);
                        cb2.removeActionListener(this);
                    }
                });
            }
        });
        // button => supprimer
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    model.removeRow(table.getSelectedRow());
                } catch(ArrayIndexOutOfBoundsException event) {
                    e.toString();
                }
            }
        });
        // button => vider
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nom.setText("");
                prenom.setText("");
                date.setText("");
                lieu.setText("");
                NNI.setText("");
                tel.setText("");
                cb1.setSelectedIndex(0);
                cb2.setSelectedIndex(0);
            }
        });
        // button fermer
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setSize(1020, 640);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
    public static void main(String[] args){
        new Etudiant();
    }
}
