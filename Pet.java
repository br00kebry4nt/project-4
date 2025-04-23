public class Pet {

    private String name;
    private String species;
    private String breed;
    private int age;
    private String status;

    public Pet(String name, String species, String breed, int age, String status) {
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.age = age;
        this.status = status;
    }

    public String getName() { return name; };
    public String getSpecies() { return species; };
    public String getBreed() { return breed; };
    public int getAge() { return age; };
    public String getStatus() { return status; };

    public void adopt() {
        status = "Adopted";
    }

    public String getSummary() {
        return "Name: " + name + " | Species: " + species
                + " | Breed: " + breed + " | Age: " + age
                + " | Status: " + status;
    }

    @Override
    public String toString() {
        return getSummary();
    }
}