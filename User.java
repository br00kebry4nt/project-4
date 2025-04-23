import java.util.ArrayList;
import java.util.Scanner;

public class User {

    private String name;
    private String email;
    private ArrayList<Pet> adoptionHistory;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.adoptionHistory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void addAdoptedPet(Pet pet) {
        adoptionHistory.add(pet);
    }

    public void showAdoptionHistory() {
        if (adoptionHistory.isEmpty()) {
            System.out.println("You have not adopted pets.");
        } else {
            System.out.println("Your adoption history:");
            for (Pet pet : adoptionHistory) {
                System.out.println(pet);
            }
        }
    }

    public void showUserProfile() {
        System.out.println("User Profile: ");
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        showAdoptionHistory();
    }

    public static User login(ArrayList<User> users) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your email to log in: ");
        String email = scanner.nextLine();

        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }

        System.out.println("No user found. Would you like to create an account?");
        String response = scanner.nextLine();

        if(response.equalsIgnoreCase("yes")) {
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();

            User newUser = new User(name, email);
            users.add(newUser);
            return newUser;
        }

        return null;
    }
}