import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    private static ArrayList<String> myArrList = new ArrayList<>();
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        boolean quit = false;
        do {
            showMyArrList();
            showMenu();
            String option = SafeInput.getRegExString(in, "Please choose an option (A/D/P/Q) ", "[AaDdPpQq]");
            switch (option.toUpperCase()) {
                case "A":
                    addItem();
                    break;
                case "D":
                    deleteItem();
                    break;
                case "P":
                    printList();
                    break;
                case "Q":
                    quit = quitProgram();
                    break;
                default:
                    System.out.println("The option you chose was invalid, please try selecting one of the shown letters");
            }
        } while (!quit);
        in.close();
    }

    private static void showMenu() {
        SafeInput.prettyHeader("Menu Options");
        System.out.println("A – Add an item to the list");
        System.out.println("D – Delete an item from the list");
        System.out.println("P – Print (Display) the list");
        System.out.println("Q – Quit the program");
    }
    private static void showMyArrList() {
        if (myArrList.isEmpty()) {
            System.out.println("The list is empty.\n");
            return;
        }

        System.out.println("Current items:");
        printMyArrList(myArrList);
        System.out.println();
    }
    private static void addItem() {
        String item = SafeInput.getNonZeroLenString(in, "Please enter the item you would like to add");
        myArrList.add(item);
        System.out.println("This item has been added successfully!");
    }
    private static void deleteItem() {
        if (myArrList.isEmpty()) {
            System.out.println("The list is currently empty.");
            return;
        }
        System.out.println("Current items:");
        printMyArrList(myArrList);

        int itemNumber = SafeInput.getRangedInt(in, "Please enter the number of the item you wish to delete from the list", 1, myArrList.size());
        String removedItem = myArrList.remove(itemNumber - 1);
        System.out.println("The item '" + removedItem + "' has been deleted successfully!");
    }
    private static void printList() {
        if (myArrList.isEmpty()) {
            System.out.println("The list is currently empty.");
            return;
        }
        System.out.println("Current items:");
        for (String item : myArrList) {
            System.out.println("- " + item);
        }
    }
    private static void printMyArrList(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }
    private static boolean quitProgram() {
        return SafeInput.getYNConfirm(in, "Are you sure you want to quit the program? (Y/N)");
    }
}
