package proxy;

import java.awt.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Scanner;
import javax.swing.filechooser.*;

import static proxy.PatternRecognizer.isProxy;
import static proxy.PatternRecognizer.isSingleton;

class filechooser extends JFrame implements ActionListener {

    // Jlabel to show the files user selects
    static JLabel l;
    public File file;
    static JLabel proxyLabel;
    static JLabel singletonLabel;

    // a default constructor
    filechooser()
    {
    }

    public static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("");
        frame.setSize(400,400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setForeground(Color.darkGray);

        JButton button1 = new JButton("Abrir");
        filechooser f1 = new filechooser();
        button1.addActionListener(f1);

        JPanel p = new JPanel();
        p.setLayout(null);

        // set the label to its initial value
        l = new JLabel("No se ha seleccionado un archivo");
        proxyLabel = new JLabel("<html><p>Selecciona un archivo para comprobar si tiene un patron Proxy, Singleton o </p></html>");
        singletonLabel = new JLabel("");

        // add panel to the frame
        p.add(button1);
        p.add(l);
        p.add(proxyLabel);
        p.add(singletonLabel);

        button1.setLocation(30, 10);
        button1.setSize(80,30);

        l.setLocation(120, 10);
        l.setSize(300,30);

        proxyLabel.setLocation(10, 60);
        proxyLabel.setSize(350,30);

        singletonLabel.setLocation(10, 90);
        singletonLabel.setSize(400,30);

        frame.getContentPane().add(p);
    }

    public void actionPerformed(ActionEvent evt)
    {
        // if the user presses the save button show the save dialog
        String com = evt.getActionCommand();
        // create an object of JFileChooser class
        JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        // invoke the showsOpenDialog function to show the save dialog
        int r = j.showOpenDialog(null);

        // if the user selects a file
        if (r == JFileChooser.APPROVE_OPTION)
        {
            file = j.getSelectedFile();
            // set the label to the path of the selected file
            l.setText(file.getName());

            String className = getClassName(file.getName());
            System.out.println(className);
            className = "proxy." + className;

            try {
                Class testClass = Class.forName(className);
                String msg = "";

                if(isProxy(testClass)){
                    msg = className + " tiene un patron Proxy";
                    proxyLabel.setForeground(Color.green);
                }
                else {
                    msg = className + " no tiene un patron Proxy";
                    proxyLabel.setForeground(Color.red);
                }

                proxyLabel.setText(msg);

                if(isSingleton(testClass)){
                    msg = className + " tiene un patron Singleton";
                    singletonLabel.setForeground(Color.green);
                }
                else {
                    msg = className + " no tiene un patron Singleton";
                    singletonLabel.setForeground(Color.red);
                }

                singletonLabel.setText(msg);

            } catch (ClassNotFoundException e) {
                proxyLabel.setText("No se encontro la clase");
                throw new RuntimeException(e);

            }
        }
    }

    public String getClassName(String filename){
        int iend = filename.indexOf(".");

        String subString = "";

        if (iend != -1)
            subString= filename.substring(0 , iend);

        return subString;
    }

}
