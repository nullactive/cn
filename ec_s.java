Eserver.java:
import java.net.*;
import java.io.*;
public class Eserver
{
public static void main(String args[])
{
ServerSocket S=null;
String line;
DataInputStream is;
PrintStream ps;
Socket c=null;
try
{
S=new ServerSocket(9000);
}
catch(IOException e)
{
System.out.println(e);

}
try
{
c=S.accept();
is=new DataInputStream(c.getInputStream());
ps=new PrintStream(c.getOutputStream());
while(true)
{
line=is.readLine();
ps.println(line);
System.out.println(line);
}
}
catch(IOException e)
{
System.out.println(e);
}
}
}
Eclient.java:
import java.net.*;
import java.io.*;
public class Eclient
{
public static void main(String args[])
{
Socket c=null;
String line;
DataInputStream is,is1;
PrintStream os;
try
{
InetAddress ia=InetAddress.getLocalHost();
c=new Socket(ia,9000);
}
catch(IOException e)
{
System.out.println(e);
}
try
{
os=new PrintStream(c.getOutputStream());
is=new DataInputStream(System.in);
is1=new DataInputStream(c.getInputStream());
while(true)
{
System.out.println("Client");
line=is.readLine();
os.println(line);
System.out.println("Server:"+is1.readLine());

}
}
catch(IOException e)
{
System.out.println("Socket closed!");
}
}
}
