import java.io.*;
import java.util.Random;
public class Test {


	public static void main(String[] args)throws IOException {
		FileWriter filewriter = new FileWriter("books.txt");
        Random ran = new Random();
        for(int i=1;i<100;i++){
            int x = ran.nextInt(10000) + 150;
            int y = ran.nextInt(3);
            if(y==0) filewriter.write(i+" "+"���v�Ԫ�"+i+" "+"�������v"+" "+"���^��"+" "+x+" "+false+" "+0+" "+0+" "+null+"\r\n");
            if(y==1) filewriter.write(i+" "+"���Q�i�S"+i+" "+"J�PK�Pù�Y"+" "+"���c�i���B���X����"+" "+x+" "+false+" "+0+" "+0+" "+null+"\r\n");
            if(y==2) filewriter.write(i+" "+"�y�H"+i+" "+"�I���q��"+" "+"���^��"+" "+x+" "+false+" "+0+" "+0+" "+null+"\r\n");
        }
        filewriter.close();
	}
}