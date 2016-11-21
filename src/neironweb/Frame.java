/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neironweb;

import java.awt.Color;
import java.awt.Container;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Artyom
 */
public class Frame extends JFrame{
    



    
    
    
    public Frame()
    {
        super("neural network");
        //JPanel pane = new JPanel();
        
        setLayout(null);
        
        JPanel mailPanel = new JPanel();
        mailPanel.setLayout(null);
        mailPanel.setLocation(50, 30);
        mailPanel.setSize(300, 170);
        mailPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        
        JLabel mailLabel = new JLabel("e-mail:");
        mailLabel.setLocation(10, 10);
        mailLabel.setSize(50, 30);        
        mailPanel.add(mailLabel);
        
        JLabel dirMailLabel = new JLabel("direct:");
        dirMailLabel.setLocation(10, 50);
        dirMailLabel.setSize(50, 30);
        mailPanel.add(dirMailLabel);
        
        
        JTextField mailField = new JTextField("mail@mail.ru");
        mailField.setSize(150, 30);
        mailField.setLocation(80, 10);
        mailPanel.add(mailField);
        
        JTextField textField = new JTextField("INBOX");
        textField.setLocation(80, 50);
        textField.setSize(150, 30);        
        mailPanel.add(textField);
        
        
        JButton mailButton = new JButton("Analyze");
        mailButton.setLocation(80, 90);
        mailButton.setSize(150, 30);
        mailPanel.add(mailButton);
        
        
        
        
//        JButton eduButton = new JButton("Start education");
//        eduButton.setLocation(0, 50);
//        eduButton.setSize(150, 30);
//        buttonPanel.add(eduButton);
        
 
        XYSeries xyser = new XYSeries("");
        XYDataset xy = new XYSeriesCollection(xyser);
        JFreeChart jf = ChartFactory.createXYLineChart("Education", "X", "Y", xy);
        
        for(int i = 0; i < 100; i++)
           xyser.add(i, Math.cos(i));
        
        
        ChartPanel chartPanel = new ChartPanel(jf);
        chartPanel.setSize(700, 300);
        chartPanel.setLocation(50, 230);
        chartPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        
//        JPanel myChartPanel = new JPanel();        
//        myChartPanel.setLayout(null);
//        myChartPanel.setLocation(50, 230);
//        myChartPanel.setSize(700, 300);
//        myChartPanel
  //      myChartPanel.add(chartPanel);        
        
        
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container con = this.getContentPane(); // inherit main frame
        //con.add(pane); 
        con.add(mailPanel);
        //con.add(myChartPanel);
        con.add(chartPanel);
        setVisible(true); 
        
    }
    
    
    
}
