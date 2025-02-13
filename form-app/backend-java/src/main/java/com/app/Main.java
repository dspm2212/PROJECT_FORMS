/**
 * This file contains the main application class for interacting with the system via console.
 * 
 * Author: Daniel Santiago Pérez <dsperezm@udistrital.edu.co>
 * Author: Jaider Santiago Avila Robles <jsquimbaya@udistrotal.edu.co>
 */
package com.app;

import com.app.controllers.UserController;
import com.app.controllers.FormController;
import com.app.controllers.ResponseController;
import com.app.models.User;
import com.app.models.Form;
import com.app.models.questions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

/**
 * This class provides a command-line interface for creating users, forms, and responses.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserController userController = new UserController();
        FormController formController = new FormController();
        ResponseController responseController = new ResponseController();

        User currentUser = null; // The currently logged-in user
        boolean running = true; // Controls the main loop

        while (running) {
            System.out.println("Welcome! Choose an option: ");
            System.out.println("1. Create User");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter first name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter last name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    currentUser = userController.createUser(firstName, lastName, email);
                    break;
                case 2:
                    System.out.print("Enter email: ");
                    email = scanner.nextLine();
                    currentUser = userController.getUserByEmail(email);
                    if (currentUser == null) {
                        System.out.println("User not found!");
                        continue;
                    }
                    break;
                case 3:
                    running = false;
                    continue;
                default:
                    System.out.println("Invalid option, try again.");
                    continue;
            }

            boolean userMenu = true;
            while (userMenu) {
                System.out.println("Welcome, " + currentUser.getFirstName() + "!");
                System.out.println("1. Create Form");
                System.out.println("2. View Forms");
                System.out.println("3. Respond to Form");
                System.out.println("4. Logout");

                int action = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (action) {
                    case 1:
                        System.out.print("Enter form title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter description: ");
                        String description = scanner.nextLine();
                        List<Question> questions = new ArrayList<>();
                        boolean addingQuestions = true;

                        while (addingQuestions) {
                            System.out.print("Enter question: ");
                            String questionText = scanner.nextLine();
                            System.out.println("Choose type: 1. Text  2. Date  3. Time  4. Multiple Choice");
                            int questionType = scanner.nextInt();
                            scanner.nextLine();

                            boolean isMandatory;
                            System.out.print("Is this question mandatory? (yes/no): ");
                            isMandatory = scanner.nextLine().equalsIgnoreCase("yes");

                            Question question = null;
                            switch (questionType) {
                                case 1 -> question = new TextQuestion(UUID.randomUUID().hashCode(), questionText, isMandatory);
                                case 2 -> question = new DateQuestion(UUID.randomUUID().hashCode(), questionText, isMandatory);
                                case 3 -> question = new TimeQuestion(UUID.randomUUID().hashCode(), questionText, isMandatory);
                                case 4 -> {
                                    System.out.print("Enter options (comma separated): ");
                                    String options = scanner.nextLine();
                                    question = new MultipleChoiceQuestion(UUID.randomUUID().hashCode(), questionText, isMandatory, List.of(options.split(",")));
                                }
                            }
                            questions.add(question);

                            System.out.println("Add another question? (yes/no)");
                            addingQuestions = scanner.nextLine().equalsIgnoreCase("yes");
                        }
                        formController.createForm(title, description, questions);
                        break;
                    case 2:
                        List<Form> forms = formController.getAllForms();
                        if (forms.isEmpty()) {
                            System.out.println("No forms available.");
                        } else {
                            for (Form form : forms) {
                                form.displayForm();
                            }
                        }
                        break;
                    case 3:
                        List<Form> availableForms = formController.getAllForms();
                        if (availableForms.isEmpty()) {
                            System.out.println("No forms available to respond. Please create a form first.");
                            break;
                        }
                        System.out.println("Select a form to respond:");
                        for (int i = 0; i < availableForms.size(); i++) {
                            System.out.println((i + 1) + ". " + availableForms.get(i).getTitle());
                        }
                        int formChoice = scanner.nextInt() - 1;
                        scanner.nextLine();

                        if (formChoice < 0 || formChoice >= availableForms.size()) {
                            System.out.println("Invalid choice.");
                            break;
                        }

                        Form selectedForm = availableForms.get(formChoice);
                        List<String> answers = new ArrayList<>();

                        for (Question q : selectedForm.getQuestions()) {
                            System.out.println(q.getText());
                            System.out.print("Answer: ");
                            answers.add(scanner.nextLine());
                        }
                        responseController.submitResponse(selectedForm.getId(), currentUser.getId(), answers);
                        System.out.println("Response submitted successfully!");
                        break;
                    case 4:
                        userMenu = false;
                        break;
                    default:
                        System.out.println("Invalid option, try again.");
                }
            }
        }
        scanner.close();
    }
}
