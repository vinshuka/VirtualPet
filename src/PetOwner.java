public class PetOwner
{
    //PetOwner class has methods for interacting with pet, taking care of pet
    private String name;
    private Pet pet;

    //enum for food items, may move to another class at a later time
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

    //feed method allows petowner to increase the belly of the pet
    //future implementation, feed should reduce clean, pet should reduce belly, and wash should reduce happiness
    public String feed(Food food)
    {
        pet.setBelly(food.calories);
        return pet.getName() + " eats " + food.name;
    }

    public String pet()
    {
        pet.setHappiness(25);
        return name + " pets " + pet.getName();
    }

    public String wash()
    {
        pet.setClean(25);
        return name + " washes " + pet.getName();
    }
}
