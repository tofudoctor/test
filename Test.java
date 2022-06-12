import java.io.*;
import java.util.Random;
public class Test {


	public static void main(String[] args)throws IOException {
		FileWriter filewriter = new FileWriter("books.txt");
        Random ran = new Random();
        for(int i=1;i<100;i++){
            int x = ran.nextInt(10000) + 150;
            int y = ran.nextInt(3);
            if(y==0) filewriter.write(i+" "+"火影忍者"+i+" "+"岸本齊史"+" "+"集英社"+" "+x+" "+false+" "+0+" "+0+" "+null+"\r\n");
            if(y==1) filewriter.write(i+" "+"哈利波特"+i+" "+"J·K·羅琳"+" "+"布盧姆茨伯里出版社"+" "+x+" "+false+" "+0+" "+0+" "+null+"\r\n");
            if(y==2) filewriter.write(i+" "+"獵人"+i+" "+"富堅義博"+" "+"集英社"+" "+x+" "+false+" "+0+" "+0+" "+null+"\r\n");
        }
        filewriter.close();
	}
}
