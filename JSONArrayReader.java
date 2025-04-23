import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class JSONArrayReader {

    private ArrayList<Pet> petArrayList = new ArrayList<>();

    public void readJson() {
        try {
            Gson gson = new Gson();

            BufferedReader reader = new BufferedReader(
                    new FileReader("Pet.json")
            );

            Type petListType = new TypeToken<ArrayList<Pet>>() {}.getType();
            petArrayList = gson.fromJson(reader, petListType);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printPet() {
        for (Pet pet : petArrayList) {
            System.out.println(pet);
        }
    }

    public ArrayList<Pet> getPetArrayList() {
        return petArrayList;
    }
}