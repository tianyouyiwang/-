import java.io.*;
import java.util.Scanner;
public class BaseData {
	public static void main(String[] args)
	{
		String a;
		File f=new File("baseData.txt");
		try
		{
			f.createNewFile();
		}
		catch(IOException e) {}
		try 
	{
			RandomAccessFile file=new RandomAccessFile(f,"rw");
		Scanner reader=new Scanner(System.in);
		System.out.print("请输入一行字符串：");
			a=reader.nextLine();
			file.writeUTF(a);
		file.close();
	}
		catch(IOException e)
		{}
		try 
	{
			RandomAccessFile file=new RandomAccessFile(f,"rw");
		System.out.print("输入的字符串为：");
		
		   System.out.print(file.readLine());
		   System.out.print(" ");
		
		file.close();
	}
		catch(IOException e)
		{}
 }
}

