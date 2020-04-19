public class PetOwner
{
    private String name;
    private Pet pet;
    public enum Food
    {
        MEAT (25, "MEAT"),
        VEG (15, "VEG"),
        CAKE (20, "CAKE");

        private final int calories;
        private final String name;

        Food(int calories, String name)
        {
            this.calories = calories;
            this.name = name;
        }
    }

    public PetOwner(String name, Pet pet)
    {
        this.name = name;
        this.pet = pet;
    }

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

    public String feed(Food food)
    {
        pet.setBelly(food.calories);
        return pet.getName() + " eats " + food.name + " " + pet.status();
    }
}
