public class registration 
{
    public static void main(String[] args) {
        
        student s1=new student("���j��","���");
        student s2=new student("�L�p��");
        student s3=new student("�d����","�j��");
        student s4=new student("���p�s","����");
        course c1=new course("java programming");
        course c2=new course("mis");

        c1.addstudent(s1);
        c1.addstudent(s3);
        c1.addstudent(s4);
        c2.addstudent(s1);
        c2.addstudent(s2);
        System.out.println(c1);
        System.out.println(c2);
        System.out.println("�t�Τ��@��"+s1.getcount()+"��ǥ�");
    }    
}