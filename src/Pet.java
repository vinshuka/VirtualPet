/**
 * Pet class controls all values associated with a Pet
 */
public class Pet
{
    private String name;
    private int belly;
    private int happiness;
    private int clean;

    /**
     * Pet constructor, initializes the pet with its given values, may add a method in the future for the player to name
     * their pet.
     * @param name
     * @param belly
     * @param happiness
     * @param clean
     */
    public Pet(String name, int belly, int happiness, int clean)
    {
        this.name = name;
        this.belly = belly;
        this.happiness = happiness;
        this.clean = clean;
    }

    /**
     * Setters and getters for the pet class, some of these are currently unused, I will leave them for now incase they
     * are needed later.
     */

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

    /**
     * Setters for belly, happiness, and clean have a conditional that locks the maximum value to 100.
     */

    public void setBelly(int belly)
    {
        if(this.belly + belly > 100)
        {
            this.belly = 100;
        }
        else
        {
            this.belly += belly;
        }
    }

    public int getHappiness()
    {
        return happiness;
    }

    public void setHappiness(int happiness)
    {
        if(this.happiness + happiness > 100)
        {
            this.happiness = 100;
        }
        else
        {
            this.happiness += happiness;
        }
    }

    public int getClean()
    {
        return clean;
    }

    public void setClean(int clean)
    {
        if(this.clean + clean > 100)
        {
            this.clean = 100;
        }
        else
        {
            this.clean += clean;
        }

    }

    /**
     * getMood returns a string based on the pet's overall condition, this is used to display the correct graphic for
     * the pet.
     * @return
     */
    public String getMood()
    {
        int mood = belly + happiness + clean;
        if(mood >= 150)
        {
            return "happy";
        }
        else if(mood >= 100)
        {
            return "content";
        }
        else
        {
            return "sad";
        }
    }

    /**
     * status method returns a string that summarizes the pet's current condition based on all of its variables.
     * @return
     */
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
        status += belly + " " + happiness + " " + clean;
        return status;
    }
}
