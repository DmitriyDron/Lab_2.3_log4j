
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import org.apache.log4j.Logger;


public class Main {

        final static Logger logger = Logger.getLogger(Main.class);


        public static void main(String[] args) {

            logger.info("Main method is started.");
            // write your code here
            ArrayList<Person> list = new ArrayList<Person>();

            Scanner in = new Scanner(System.in);


            int num;
            do {

                init(list);
                System.out.println("\nChoose the operation\n" +
                        "1. Check persons which name starts with letter.\n" +
                        "2. Check persons which have telephones.\n" +
                        "3. Exit");
                logger.warn("Input must be a 1number.");
                num = in.nextInt();
                switch (num) {
                    case 1:

                        try {
                            System.out.print("Input the letter:\n");

                            logger.warn("Input must be a letter.");
                            char letter = in.next().charAt(0);
                            System.out.print("Persons which name starts at  letter [" + letter + "]:\n");
                            checkPerson(list, letter);
                            print(list);
                        } catch (InvalidInputTypeFormatException ex) {
                            logger.error("Invalid type format.");
                            System.out.println(ex.getMessage());

                        } catch (NullPointerException ex) {
                            logger.error("Transfer null-collection into the method.");
                            System.out.println(ex.getMessage() + " array value");
                        }
                        break;
                    case 2:

                        try {
                            System.out.print("\nPersons which have telephones:\n");
                            checkTelephone(list);
                            print(null);
                        } catch (NullPointerException ex) {
                            logger.error("Transfer null-collection into the method.");
                            System.out.println(ex.getMessage() + " array value");
                        }
                    case 3:
                        logger.info("Main method is finished.3");
                        break;
                    default:
                        break;
                }
            } while (num != 3);
        }


        public static void checkPerson(ArrayList<Person> list, char letter)
                throws InvalidInputTypeFormatException, NullPointerException {
            logger.debug("List: "+list);
            logger.debug("Letter: "+letter);
            if (list == null)
                throw new NullPointerException();
            if (Character.isDigit(letter))
                throw new InvalidInputTypeFormatException("Invalid input type.");
            String sLetter = String.valueOf(letter);
            // System.out.printf("%-12s%-12s%-12s%-12s%-12s%-12s","Name","Surname","Lastname","Adress","TNumber","AInfo");
//        System.out.printf("%-8s%-8s%-12s%-16s%-20s%-5s\n", "Name", "Surname", "Lastname", "Adress", "TNumber", "AInfo");
            Iterator<Person> i = list.iterator();
            while (i.hasNext()) {
                Person s = i.next();

                if (!s.getName().startsWith(sLetter.toUpperCase()))
                    i.remove();

            }
        }


        public static void checkTelephone(ArrayList<Person> list) {
            if (list == null)
                throw new NullPointerException();
            Iterator<Person> i = list.iterator();
            while (i.hasNext()) {
                Person s = i.next();
                if (s.gettNumber().isEmpty()) {
                    i.remove();
                }
            }
        }

        public static void print(ArrayList<Person> list) {
            if (list == null) throw new NullPointerException();
            System.out.printf("%-8s%-8s%-12s%-16s%-20s%-5s\n", "Name", "Surname", "Lastname", "Adress", "TNumber", "AInfo");
            for (Person item : list) {
                System.out.printf("%16s\n", item.toString());
            }
        }

        public static void init(ArrayList<Person> list) {
            list.add(new Person("Dmytro", "Dron", "Vitalyevich", "Lomonosova st. ", "+38(067)-84-74-555",
                    "Unlim internet access"));
            list.add(new Person("Bogdan", "Dron", "Vitalyevich", "Rybnaya st. 1/2", "",
                    "He was born in Mykolaiv."));
            list.add(new Person("Vitaliy", "Dron", "Nikolaevich", "Rybnaya st. 1/2", "+38(067)-51-25-553",
                    "Unlim internet access"));
            list.add(new Person("Zhanna", "Dron", "Andreevna", "Rybnaya st. 1/2", "+38(097)-29-14-910",
                    "Unlim internet access"));

        }
    }
