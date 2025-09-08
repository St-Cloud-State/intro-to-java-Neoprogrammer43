import java.io.*;

public class MyMain {
    public static void main(String[] args) {
        PersonList personList = new PersonList();

        try {
           
            FileInputStream fis = new FileInputStream("people.txt");
            personList.store(fis);
            fis.close();

           
            System.out.println("All persons in list:");
            personList.display(System.out);

            
            System.out.println("\nSearching for IDs:");
            String[] testIds = {"101", "999", "103"};
            for (String id : testIds) {
                int index = personList.find(id);
                if (index != -1) {
                    System.out.println("ID " + id + " found at index " + index + ": " + personList.get(index));
                } else {
                    System.out.println("ID " + id + " not found.");
                }
            }

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
