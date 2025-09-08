import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class MyMain {

    
    public static void store(InputStream inputStream, LinkedList<Person> list) throws IOException {
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(",");
            if (parts.length == 3) {
                Person person = new Person(parts[0].trim(), parts[1].trim(), parts[2].trim());
                list.add(person);
            }
        }
        scanner.close();
    }


    public static void display(OutputStream outputStream, LinkedList<Person> list) throws IOException {
        PrintWriter writer = new PrintWriter(outputStream);
        for (Person person : list) {
            writer.println(person.toString());
        }
        writer.flush();
    }

    
    public static int find(String sid, LinkedList<Person> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(sid)) {
                return i;
            }
        }
        return -1;
    }

   
    public static void main(String[] args) {
        LinkedList<Person> personList = new LinkedList<>();

       
        try {
            FileInputStream fis = new FileInputStream("people.txt");
            store(fis, personList);
            fis.close();

            
            System.out.println("All persons in list:");
            display(System.out, personList);

            
            System.out.println("\nSearching for IDs:");
            String[] testIds = {"101", "999", "103"};
            for (String id : testIds) {
                int index = find(id, personList);
                if (index != -1) {
                    System.out.println("ID " + id + " found at index " + index + ": " + personList.get(index));
                } else {
                    System.out.println("ID " + id + " not found.");
                }
            }

        } catch (IOException e) {
            System.err.println("Error reading or writing: " + e.getMessage());
        }
    }
}
