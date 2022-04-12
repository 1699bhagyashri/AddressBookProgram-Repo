package Com.infogalaxy;



import jdk.nashorn.internal.objects.NativeError;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookMain {
    static Scanner scanner = new Scanner(System.in);
    ArrayList<Contact> contactArrayList = new ArrayList<>();

    private void addContact() {
        Contact contact = new Contact();
        System.out.println("Enter the first name");
        contact.setFirstName(scanner.next());
        System.out.println("Enter last name");
        contact.setLastName(scanner.next());
        System.out.println("Enter city name");
        contact.setCity(scanner.next());
        System.out.println("Enter the state name");
        contact.setState(scanner.next());
        System.out.println("Enter zip code");
        contact.setZip(scanner.next());
        System.out.println("Enter the email Id");
        contact.setEmail(scanner.next());
        System.out.println("Enter mobile number");
        contact.setPhoneNumber(scanner.next());
        contactArrayList.add(contact);
        System.out.println("size of List:" + contactArrayList.size());

    }

    private void showContact() {
        try {
            for (int i = 0; i < contactArrayList.size(); i++) {
                Contact contact = contactArrayList.get(i);
                System.out.println(contact.toString());
            }

        } catch (NullPointerException npe) {
            System.out.println("Contact is Blank");
        }
    }

    public void editContact() {
        System.out.println("Enter the First name");
        String Firstname = scanner.next();
        int isAvailable = 0;
        for (int i = 0; i < contactArrayList.size(); i++) {
            Contact contact = contactArrayList.get(i);
            if (Firstname.equals(contact.getFirstName())) {
                isAvailable = 1;
                System.out.println("Contact is fount");
                System.out.println("Enter last name");
                contact.setLastName(scanner.next());
                System.out.println("Enter city name");
                contact.setCity(scanner.next());
                System.out.println("Enter the state name");
                contact.setState(scanner.next());
                System.out.println("Enter zip code");
                contact.setZip(scanner.next());
                System.out.println("Enter the email Id");
                contact.setEmail(scanner.next());
                System.out.println("Enter mobile number");
                contact.setPhoneNumber(scanner.next());
                break;
            }
            if (isAvailable == 0) {
                System.out.println("Contact not fount");
            }
        }
    }

    public void deleteContact() {
        System.out.println("Enter the First name");
        String fname = scanner.next();
        int isAvailable = 0;
        for (int i = 0; i < contactArrayList.size(); i++) {
            Contact contact = contactArrayList.get(i);
            if (fname.equalsIgnoreCase(contact.getFirstName())) {
                isAvailable = 1;
                System.out.println("Contact found");
                contactArrayList.remove(i);
                break;
            }
        }
        if (isAvailable == 0) {
            System.out.println("Contact not found");
        }
    }

        public void backupToFile() {
            try {
                String contactData = null;
                for (int i = 0; i < contactArrayList.size(); i++) {
                    Contact contact = contactArrayList.get(i);
                    contactData = contact.getFirstName() + "," + contact.getLastName() + "," + contact.getCity() + "," + contact.getState() + "," + contact.getZip() + "," + contact.getEmail() + "," + contact.getPhoneNumber() + "\n" + contactData;
                }
                Path file = Paths.get("AddressBookMain.txt");
                byte[] byteData = contactData.getBytes();
                Files.write(file, byteData);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
                public void restoreFromFile() {
                    contactArrayList.clear();
                    String data = null;
                    try{
                        BufferedReader br = new BufferedReader(new FileReader("AddressBookMain.txt"));
                        while((data= br.readLine()) != null && ! data.equals("null")) {
                            String[] sepratedData = data.split(",");
                            Contact contact = new Contact();
                            contact.setFirstName(sepratedData[0]);
                            contact.setLastName(sepratedData[1]);
                            contact.setCity(sepratedData[2]);
                            contact.setState(sepratedData[3]);
                            contact.setZip(sepratedData[4]);
                            contact.setEmail(sepratedData[5]);
                            contact.setPhoneNumber(sepratedData[6]);
                            contactArrayList.add(contact);
                            System.out.println("Contacts restored Succesfull");

                        }
                    } catch (FileNotFoundException e){
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }



          public static void main (String[] args) {
        System.out.println("Welcome to Address book program");
        AddressBookMain addressBookMain = new AddressBookMain();
        int ch;
        do{
              System.out.println("1.Add contact \n2 edit contact \n3delete contact \n 4 showcontact \n 5 backuptofiles \n 6 Restore contact from files");
              System.out.println("Enter your choice");
               ch=scanner.nextInt();
              switch (ch) {
                  case 1:
                      addressBookMain.addContact();
                      break;
                  case 2:
                      addressBookMain.editContact();
                      break;
                  case 3:
                      addressBookMain.deleteContact();
                      break;
                  case 4:
                      addressBookMain.showContact();
                      break;
                      case 5:
                          addressBookMain.backupToFile();
                          break;
                  case 6:
                       addressBookMain.restoreFromFile();
                       break;
              }

              }
        while ( ch != 7);
    }

}


