public class student 
{
    private String name;
    private String major;
    private static int count;
    public student(String name,String major)
    {
        setname(name);
        setmajor(major);
        count++;
    }
    public student(String name)
    {
        setname(name);
        count++;
    }

    public void setname(String n)
    {
        name=n;
    }
    public void setmajor(String m)
    {
        major=m;
    }
    public String getname()
    {
        return name;
    }
    public String getmajor()
    {
        return major;
    }
    public int getcount()
    {
        return count;
    }

    public String toString()
    {
        return "學生姓名："+ getname() +(getmajor()!=null?("系級："+getmajor()):"");
    }
}