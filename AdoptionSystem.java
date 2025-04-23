import java.util.ArrayList;
import java.util.Scanner;

public class AdoptionSystem {

    private ArrayList<Pet> pets;
    private ArrayList<User> users;
    private Scanner scanner;

    public AdoptionSystem(ArrayList<Pet> pets) {
        this.pets = pets;
        this.users = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void adoptionProcess() {
        boolean running = true;

        User currentUser = User.login(users);
        if (currentUser == null) {
            System.out.println("User creation cancelled.");
            return;
        }

        System.out.println("Welcome, " + currentUser.getName() + "!");
        while (running) {
            System.out.println("\n--- Pet Store Adoption ---");
            System.out.println("1. View all pets");
            System.out.println("2. Filter pets");
            System.out.println("3. Adopt");
            System.out.println("4. View profile and adoption history");
            System.out.println("5. Exit");

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    viewAllPets();
                    break;
                case "2":
                    filterPets();
                    break;
                case "3":
                    adoptPet(currentUser);
                    break;
                case "4":
                    currentUser.showUserProfile();
                    break;
                case "5":
                    running = false;
                    break;
                default:
                    System.out.println("Please try again.");
            }
        }
    }

    private void viewAllPets() {
        for (Pet pet : pets) {
            System.out.println(pet);
        }
    }

    private void filterPets() {
        System.out.print("Enter species: ");
        String search = scanner.nextLine();

        boolean found = false;
        for (Pet pet : pets) {
            if (pet.getSpecies().equalsIgnoreCase(search)) {
                System.out.println(pet);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No species found." + search);
        }
    }

    private void adoptPet(User user) {
        System.out.print("Enter the name of your future forever friend: ");
        String name = scanner.nextLine();

        for (Pet pet : pets) {
            if (pet.getName().equalsIgnoreCase(name)) {
                if (pet.getStatus().equalsIgnoreCase("Adopt Me")) {
                    pet.adopt();
                    user.addAdoptedPet(pet);
                    System.out.println("Yay! You adopted " + pet.getName() + "!");
                } else {
                    System.out.println("Sorry, " + pet.getName() + " has already been adopted.");
                }
                return;
            }
        }
        System.out.println("This pet has been adopted or is not in our inventory.");
    }
}