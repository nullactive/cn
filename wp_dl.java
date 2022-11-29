import java.io.*;  
import java.net.*;  
import java.util.*;  
public class HTTPClient  
{  
public static void main(String args[])  
{  
Scanner s=new Scanner(System.in);  
int portnumber=80;  
System.out.println("Enter the hostname:");  
String hostName=s.next();  
try  
{  
Socket socket=new Socket(hostName,portnumber);  
PrintWriter out=new PrintWriter(socket.getOutputStream(),true);  
BufferedReader in=new  
 BufferedReader(newInputStreamReader(socket.getInputStream()));  out.println("GET / HTTP/1.1\nHost:hostName\n\n");  
String inputLine;  
while((inputLine=in.readLine())!=null)  
{  
 System.out.println(inputLine);  
}  
}  
catch(UnknownHostException e)  
{  
 System.err.println("Don't know about host"+hostName);  
 System.exit(1);  
}  
catch(IOException e)  
{  
System.err.println("Couldn't get I/O for the connection to"+hostName);   System.exit(1); 

}  
}  
}
