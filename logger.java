import java.io.*;
import java.net.InetAddress;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.CodeSource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class logger {
    public static void main(String args[])throws IOException,URISyntaxException
    {
        String SystemName1 = null;
        try {
            
                    String SystemName
                            = InetAddress.getLocalHost().getHostName();

                    SystemName1 = SystemName;
                }
                catch (Exception E) {
                    System.err.println(E.getMessage());
                }

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        String log = SystemName1+"  "+dtf.format(now)+"\n \n";
        CodeSource codeSource = logger.class.getProtectionDomain().getCodeSource();
        File jarFile = new File(codeSource.getLocation().toURI().getPath()+"/log.txt");
        
	String jarDir = jarFile.getParentFile().getPath();
	String loc = jarDir.substring(0,jarDir.length()-10);
	String fin = loc.concat("/log.txt");

        FileWriter osw = new FileWriter(fin,true);
        osw.append(log);
        osw.close();


    }
    }


