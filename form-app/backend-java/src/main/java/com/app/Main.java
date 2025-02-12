// Main.java
package com.app;

import com.app.controllers.UserController;
import com.app.controllers.FormController;
import com.app.models.User;
import com.app.models.Form;
import com.app.models.questions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Main application to interact with the system via console.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserController userController = new UserController();
        FormController formController = new FormController();
        
        System.out.println("Welcome! Choose an option: ");
        System.out.println("1. Create User");
        System.out.println("2. Login");
        int choice = scanner.nextInt();
        scanner.nextLine(); 
        
        User currentUser = null;
        if (choice == 1) {
            System.out.print("Enter first name: ");
            String firstName = scanner.nextLine();
            System.out.print("Enter last name: ");
            String lastName = scanner.nextLine();
            System.out.print("Enter email: ");
            String email = scanner.nextLine();
            currentUser = userController.createUser(firstName, lastName, email);
        } else if (choice == 2) {
            System.out.print("Enter email: ");
            String email = scanner.nextLine();
            currentUser = userController.getUserByEmail(email);
            if (currentUser == null) {
                System.out.println("User not found!");
                return;
            }
        }

        System.out.println("Welcome, " + currentUser.getFirstName() + "!");
        System.out.println("1. Create Form");
        System.out.println("2. View Forms");
        int action = scanner.nextInt();
        scanner.nextLine();

        if (action == 1) {
            System.out.print("Enter form title: ");
            String title = scanner.nextLine();
            System.out.print("Enter description: ");
            String description = scanner.nextLine();

            List<Question> questions = new ArrayList<>();
            boolean addingQuestions = true;
            int questionId = 1; // Counter for question IDs

            while (addingQuestions) {
                System.out.print("Enter question: ");
                String questionText = scanner.nextLine();
                
                System.out.println("Choose type: 1. Text  2. Date  3. Time  4. Multiple Choice");
                int questionType = scanner.nextInt();
                scanner.nextLine(); 

                System.out.print("Is this question mandatory? (yes/no): ");
                boolean isMandatory = scanner.nextLine().equalsIgnoreCase("yes");

                Question question = null;
                switch (questionType) {
                    case 1 -> question = new TextQuestion(questionId++, questionText, isMandatory);
                    case 2 -> question = new DateQuestion(questionId++, questionText, isMandatory);
                    case 3 -> question = new TimeQuestion(questionId++, questionText, isMandatory);
                    case 4 -> {
                        System.out.print("Enter options (comma separated): ");
                        String options = scanner.nextLine();
                        List<String> optionList = new ArrayList<>(Arrays.asList(options.split(",")));
                        question = new MultipleChoiceQuestion(questionId++, questionText, isMandatory, optionList);
                    }
                }
                questions.add(question);

                System.out.println("Add another question? (yes/no)");
                addingQuestions = scanner.nextLine().equalsIgnoreCase("yes");
            }
            int formId = formController.generateFormId(); // Generar un ID único para el formulario
            formController.createForm(formId, title, description, questions);
        } else if (action == 2) {
            List<Form> forms = formController.getAllForms();
            for (Form form : forms) {
                form.displayForm();
            }
        }
        scanner.close();
    }
}

