public class course 
{
    private String cname;
    private student []arr=new student[5];
    private int num=0;
    public course(String cname)
    {
        setcname(cname);
    } 

    public void setcname(String c)
    {
        cname=c;
    }
    public String getcname()
    {
        return cname;
    }
    public void addstudent(student s)
    {
        if(num<5)
        {
            arr[num]=s;
            num++;
        }
        else
        {
            System.out.print("too much people.");
        }
    }

    public String getstudent()
    {
        String output="";
        for(int i=0;i<=4;i++)
        {
            if(arr[i]==null) break;
            output+=arr[i]+"\n";
        }
        return output;
    }

    public String toString()
    {
        return "½Òµ{¡G"+getcname()+"\n"+getstudent()+"\n";
    }
}