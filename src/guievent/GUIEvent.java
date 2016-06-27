/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guievent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author pspeters
 */
public class GUIEvent extends KFrame implements ActionListener {

    //First, I'm setting final variables on width and height.
    private static final int WIDTH = 300;
    private static final int HEIGHT = 300;
    
    //Now I'll set the different panel and button variables.
    
    /*------------------------------------------------------
    ---JPanels
    -------------------------------------------------------*/
    private JPanel titleP = new JPanel();
    private JPanel inputP = new JPanel();
        private JPanel input1P = new JPanel();
        private JPanel input2P = new JPanel();
    private JPanel buttonP = new JPanel();
        private JPanel copyP = new JPanel();
        private JPanel clearP = new JPanel();
    
    /*------------------------------------------------------
    ---components
    -------------------------------------------------------*/
    private JButton copyJB = new JButton("Copy"); 
    private JButton clearJB = new JButton("Clear");
    
    
    private JTextField input1TF = new JTextField(20);
    private JTextField input2TF = new JTextField(20);
    
    private JLabel titleJL = new JLabel("Copy and Clear");
    
    
    /*------------------------------------------------------
    ---Constructor (hold on for the ride!!)
    -------------------------------------------------------*/
    public GUIEvent() 
    {
        KFrame window = new KFrame();
        Container pane = window.getContentPane();
        pane.setLayout(new BorderLayout());
        
        //Now set up the initial panels for everything to fit into.
        pane.add("North",titleP);
        pane.add("Center",inputP);
        pane.add("South", buttonP);
        
        //First, to set the title (easy)
        titleP.setLayout(new FlowLayout());
        titleP.add(titleJL);
        
        //Next, I'll set the textfield layout and inputs.
        inputP.setLayout(new GridLayout(2,1));
        inputP.add(input1P);
            input1P.add(input1TF);
        inputP.add(input2P);
            input2P.add(input2TF);
        
        //With the textfield JPanel set, time for the buttons! 
        buttonP.setLayout(new FlowLayout());
        buttonP.add(copyP);
            buttonP.add(copyJB);
        buttonP.add(clearP);
            buttonP.add(clearJB);
        
        //Now that our GUI is set, time to make the buttons
        //actually do something!
        copyJB.addActionListener(new FieldListener(input1TF,input2TF));
        clearJB.addActionListener(new clearTextField(input1TF, input2TF));
        
        //MAKE SURE TO MAKE IT VISIBLE AND SET THE DIMENSIONS!!!
        window.setSize(WIDTH, HEIGHT);
        window.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent evt) 
    {
        String s = input1TF.getText();
    }
    
    
    
    
    public static void main(String[] args) {
        GUIEvent e = new GUIEvent();
    }
    
}
