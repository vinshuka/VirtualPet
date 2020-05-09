/**
 * PetOwner class contains methods for interacting with the pet.
 */
public class PetOwner
{
    private String name;
    private Pet pet;

    /**
     * PetOwner constructor. In the future we will add a method to allow the player to set their name.
     * @param name
     * @param pet
     */
    public PetOwner(String name, Pet pet)
    {
        this.name = name;
        this.pet = pet;
    }

    /**
     * Currently unused setters and getters, I'll be leaving them here for now, as we may need them later.
     */

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Pet getPet()
    {
        return pet;
    }

    public void setPet(Pet pet)
    {
        this.pet = pet;
    }

    /**
     * feed method allows our PetOwner to set the belly value of their pet.
     * @param food
     */
    public void feed(int food)
    {
        pet.setBelly(food);
    }

    /**
     * pat method allows our PetOwner to set the happiness value of their pet.
     * @param patValue
     */
    public void pat(int patValue)
    {
        pet.setHappiness(patValue);
    }

    /**
     * wash method allows our PetOwner to set the clean value of their pet.
     * @param washValue
     */
    public void wash(int washValue)
    {
        pet.setClean(washValue);
    }
}
