package com.jachs.commons.telnet;

import java.io.IOException;

import org.apache.commons.net.telnet.TelnetClient;

public class TelnetDemo {
    public static void main(String[] args) throws IOException {
        TelnetClient telnet = new TelnetClient();
        String remoteip = "10.1.1.159";
        int remoteport = 9999;
        telnet.connect(remoteip, remoteport);
        System.out.println(telnet.isAvailable());
        System.out.println(telnet.isConnected());
 
       
        telnet.disconnect();
        System.exit(0);
    }
}
