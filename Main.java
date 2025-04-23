public class Main {

    public static void main(String[] args) {

        JSONArrayReader reader = new JSONArrayReader();
        reader.readJson();

        AdoptionSystem system = new AdoptionSystem(reader.getPetArrayList());
        system.adoptionProcess();
    }
}