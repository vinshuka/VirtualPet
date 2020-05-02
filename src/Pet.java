public class Pet
{
    //basic pet class, has a name, belly, happiness, and clean values
    private String name;
    private int belly;
    private int happiness;
    private int clean;
    private char[][] graphic;


    public Pet(String name, int belly, int happiness, int clean)
    {
        this.name = name;
        this.belly = belly;
        this.happiness = happiness;
        this.clean = clean;
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

    public int getHappiness()
    {
        return happiness;
    }

    public void setHappiness(int happiness)
    {
        this.happiness += happiness;
    }

    public int getClean()
    {
        return clean;
    }

    public void setClean(int clean)
    {
        this.clean += clean;
    }

    //status returns a string about how the pet feels
    public String status()
    {
        String status = name;
        if(belly >= 90)
        {
            status += " is full";
        }
        else if(belly >= 50)
        {
            status += " is still a bit hungry";
        }
        else if(belly >= 25)
        {
            status += " is hungry";
        }
        else
        {
            status += " is starving";
        }

        if(happiness >= 90)
        {
            status += ", happy";
        }
        else if(happiness >= 50)
        {
            status += ", content";
        }
        else if(happiness >= 25)
        {
            status += ", sad";
        }
        else
        {
            status += ", crying";
        }

        if(clean >= 90)
        {
            status += ", and clean.";
        }
        else if(clean >= 50)
        {
            status += ", and mostly clean.";
        }
        else if(clean >= 25)
        {
            status += ", and dirty.";
        }
        else
        {
            status += ", and filthy.";
        }

        return status;
    }


}
