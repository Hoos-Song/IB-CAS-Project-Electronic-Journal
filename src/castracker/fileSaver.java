/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package castracker;

import java.io.*;
/**
 *
 * @author dedwards1788
 */
public class fileSaver {
    
    
    
    
    
    BufferedReader br;
    FileReader fr;
    FileWriter fw;
    String fileName;
    static String IDname;
    
    public static void main(String[] args) {
        IDname = args[0];
         
    }
    String name = IDname;
    File f = new File(System.getProperty("user.dir")+ "/CASreports/casreport" + name + ".txt");
   
    public void setFileName(String fn) {
        fileName = fn;
    }
     public String getStringFromFile() throws IOException {
        return (br.readLine());
    }
    public void close4FileForRead() throws IOException {
        fr.close();
    }
    public void closeFileForWrite() throws IOException {
        fw.close();
    }
    
    public void openFileForWriteAppend(String s) throws IOException {
        
        fw = new FileWriter(f, true);
        setStringToFile(s);
        closeFileForWrite();
        
    }
    public void openFileForWrite() throws IOException {
        fw = new FileWriter(f, false);
        
    }
    public void setStringToFile(String str) throws IOException {
        fw.write(str);
    }
    
}
