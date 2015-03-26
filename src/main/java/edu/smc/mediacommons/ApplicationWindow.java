package edu.smc.mediacommons;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class ApplicationWindow extends JFrame {

    private static final long serialVersionUID = 1L;

    public ApplicationWindow() {
        super("MediaCommons");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JTabbedPane tabs = new JTabbedPane();
        tabs.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        
        JPanel panel = new JPanel();
        panel.add(new JTextArea("Test \nHue \nDerp"));
        panel.setBackground(Color.WHITE);
        
        tabs.addTab("System", new ImageIcon("yourFile.gif"), panel, "System");
        
        JButton twitterButton = new JButton("Twitter");
        tabs.addTab("Twitter", new ImageIcon("yourFile.gif"), twitterButton, "Twitter");
        
        // JButton facebookButton = new JButton("Facebook");
        tabs.addTab("Facebook", new ImageIcon("yourFile.gif"), new JLabel("Huehuehue"), "Facebook");
        
        add(tabs, BorderLayout.CENTER);
        setSize(600, 300);
        setVisible(true);
    }
}