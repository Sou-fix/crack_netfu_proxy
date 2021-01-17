package org.theanarch.openproxy.Proxy;

import java.awt.FlowLayout;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.theanarch.openproxy.Main;

public class Proxy {
	//v1
    public Proxy(){
        new Thread(new Runnable(){
            private Socket socket;

            @Override
            public void run(){
                try{
                    ServerSocket serverSocket = new ServerSocket(8080);
                    
                    System.out.println("Proxy started on port 8080");

                    while((socket = serverSocket.accept()) != null){
                        (new Tunnel(socket)).start();
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
        javax.swing.SwingUtilities.invokeLater(new Runnable() {  
  		  
            public void run() {  
                createAndShowGUI();  
            }  
        }); 
    }
    static JTextArea textArea = new JTextArea(30, 42);
    public static void createAndShowGUI() {  
    	  
        // Create and set up the window.  
        final JFrame frame = new JFrame("craker");  
  
        // Display the window.  
        frame.setSize(500, 200);  
        frame.setVisible(true);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set flow layout for the frame  
        frame.getContentPane().setLayout(new FlowLayout());  
  
          
        JScrollPane scrollableTextArea = new JScrollPane(textArea);  
  
        scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
  
        frame.getContentPane().add(scrollableTextArea); 
    
    }
}
