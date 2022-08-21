/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Jisoo
 */
public class IptablesGenerate {
    public static String convertPorts(String ports){
        String rs = "";
        rs = ports.replace('|', ',');
        rs = rs.replace(" ", "");
        rs.trim();
        return rs;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        String line = "";
        String splitBy = ",";
        String fi = "-A INPUT -s ";
        String se = " -p tcp -m multiport --dports ";
        String thir = " -m comment --comment ";
        String fou = " -j ACCEPT";

        try{
            BufferedReader br = new BufferedReader(new FileReader("D:\\Tools For Jobs\\iptables.csv"));
            while((line = br.readLine()) != null){
                String [] iptables = line.split(splitBy);
                String ports = convertPorts(iptables[1]);
                System.out.println(fi + iptables[0]+se+ports+thir+"\"" + iptables[2] + "\""+fou);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

}
