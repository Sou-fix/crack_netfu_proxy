package org.theanarch.openproxy;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.theanarch.openproxy.Proxy.Proxy;

public class Main {
//v1
    public static void main(String[] args){
        new Proxy();

        UPnP uPnP = new UPnP();
        if(!uPnP.isMappedTCP(8080)){
           uPnP.openPortTCP(8080);
           System.out.println("Port 8080 mapped using UPnP");
        }
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable(){
            @Override
            public void run(){
                uPnP.closePortTCP(8080);
                
            }
        }));

    }
    
}
