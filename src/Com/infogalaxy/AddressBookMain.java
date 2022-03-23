package Com.infogalaxy;



import java.util.Scanner;

public class AddressBookMain {
    Contact contact = new Contact();
    Scanner scanner = new Scanner(System.in);
    private void addContact(){
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
    }
          private void showContact() {
        try {
            System.out.println(contact.toString());
        }catch(NullPointerException npe){
            System.out.println("Contact is Blank");
        }
          }

          public void editContact() {
              System.out.println("Enter the First name");
              String Firstname = scanner.next();
              if (Firstname.equals(contact.getFirstName())) {
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
              } else {
                  System.out.println("Contact not fount");
              }
          }
          public void deleteContact(){
              System.out.println("Enter the First name");
              String fname = scanner.next();
              if(fname.equals(contact.getFirstName())){
                  System.out.println("Contact Found");
                  contact = null;
              }else{
                  System.out.println("Contact Not Found");
              }
          }

              public static void main (String[] args) {
        System.out.println("Welcome to Address book program");
        AddressBookMain addressBookMain = new AddressBookMain();
        addressBookMain.addContact();
        addressBookMain.showContact();
        addressBookMain.editContact();
        addressBookMain.showContact();
        addressBookMain.deleteContact();
        addressBookMain.showContact();
    }

}


