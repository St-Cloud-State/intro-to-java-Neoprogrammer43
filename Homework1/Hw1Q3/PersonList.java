import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class PersonList {
    private LinkedList<Person> people;

    public PersonList() {
        people = new LinkedList<>();
    }

    public void store(InputStream inputStream) throws IOException {
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(",");
            if (parts.length == 3) {
                Person person = new Person(parts[0].trim(), parts[1].trim(), parts[2].trim());
                people.add(person);
            }
        }
        scanner.close();
    }

    
    public void display(OutputStream outputStream) throws IOException {
        PrintWriter writer = new PrintWriter(outputStream);
        for (Person person : people) {
            writer.println(person.toString());
        }
        writer.flush();
    }

   
    public int find(String sid) {
        for (int i = 0; i < people.size(); i++) {
            if (people.get(i).getId().equals(sid)) {
                return i;
            }
        }
        return -1;
    }

    
    public Person get(int index) {
        return people.get(index);
    }
}
