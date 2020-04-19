public class Pet
{
    private String name;
    private int belly;

    public Pet(String name, int belly)
    {
        this.name = name;
        this.belly = belly;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getBelly()
    {
        return belly;
    }

    public void setBelly(int belly)
    {
        this.belly += belly;
    }

    public String status()
    {
        if(belly >= 90)
        {
            return name + " is full";
        }
        else if(belly >= 50)
        {
            return name + " is still a bit hungry";
        }
        else if(belly >= 25)
        {
            return name + " is hungry";
        }
        else
        {
            return name + " is starving";
        }
    }
}
