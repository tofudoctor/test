public class registration 
{
    public static void main(String[] args) {
        
        student s1=new student("王大明","資管");
        student s2=new student("林小華");
        student s3=new student("吳忠明","大氣");
        student s4=new student("李小龍","企管");
        course c1=new course("java programming");
        course c2=new course("mis");

        c1.addstudent(s1);
        c1.addstudent(s3);
        c1.addstudent(s4);
        c2.addstudent(s1);
        c2.addstudent(s2);
        System.out.println(c1);
        System.out.println(c2);
        System.out.println("系統內共有"+s1.getcount()+"位學生");
    }    
}