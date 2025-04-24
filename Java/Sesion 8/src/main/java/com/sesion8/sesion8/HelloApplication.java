package com.sesion8.sesion8;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        // Uncomment the exercise you want to run
        // exercise1();
        // exercise2();
        // exercise3();
        // exercise4();
        // exercise5();
        // launch();
    }

    public static void exercise1() {
        int a = 10;
        int b = 0;
        System.out.println("Result: " + (a / b)); // This will throw ArithmeticException
    }
    // This method will throw an ArithmeticException
    // when dividing by zero, which is not handled.
    // The console output is:
    /*
    * /home/inmemorialake/.jdks/corretto-17.0.14/bin/java -javaagent:/opt/intellij-idea-ultimate-edition/lib/idea_rt.jar=36035 -Dfile.encoding=UTF-8 -classpath /home/inmemorialake/.m2/repository/org/openjfx/javafx-controls/17.0.6/javafx-controls-17.0.6.jar:/home/inmemorialake/.m2/repository/org/openjfx/javafx-graphics/17.0.6/javafx-graphics-17.0.6.jar:/home/inmemorialake/.m2/repository/org/openjfx/javafx-base/17.0.6/javafx-base-17.0.6.jar:/home/inmemorialake/.m2/repository/org/openjfx/javafx-fxml/17.0.6/javafx-fxml-17.0.6.jar -p /home/inmemorialake/.m2/repository/org/openjfx/javafx-base/17.0.6/javafx-base-17.0.6-linux.jar:/home/inmemorialake/.m2/repository/org/openjfx/javafx-graphics/17.0.6/javafx-graphics-17.0.6-linux.jar:/home/inmemorialake/.m2/repository/org/openjfx/javafx-controls/17.0.6/javafx-controls-17.0.6-linux.jar:/home/inmemorialake/Proyectos_Programacion/Java/Sesion 8/target/classes:/home/inmemorialake/.m2/repository/org/openjfx/javafx-fxml/17.0.6/javafx-fxml-17.0.6-linux.jar -m com.sesion8.sesion8/com.sesion8.sesion8.HelloApplication
java.lang.reflect.InvocationTargetException
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:569)
	at javafx.graphics/com.sun.javafx.application.LauncherImpl.launchApplicationWithArgs(LauncherImpl.java:465)
	at javafx.graphics/com.sun.javafx.application.LauncherImpl.launchApplication(LauncherImpl.java:364)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:569)
	at java.base/sun.launcher.LauncherHelper$FXHelper.main(LauncherHelper.java:1099)
Caused by: java.lang.ArithmeticException: / by zero
	at com.sesion8.sesion8/com.sesion8.sesion8.HelloApplication.exercise1(HelloApplication.java:35)
	at com.sesion8.sesion8/com.sesion8.sesion8.HelloApplication.main(HelloApplication.java:24)
	... 11 more
Exception running application com.sesion8.sesion8.HelloApplication
    * */

    public static void exercise2() {
        try {
            int a = 10;
            int b = 0;
            System.out.println("Result: " + (a / b));
        } catch (ArithmeticException e) {
            System.out.println("Error! Division by zero is not allowed.");
        }
    }
    // This method handles the ArithmeticException
    // that occurs when dividing by zero.
    // The console output is:
    /*
        /home/inmemorialake/.jdks/corretto-17.0.14/bin/java -javaagent:/opt/intellij-idea-ultimate-edition/lib/idea_rt.jar=35525 -Dfile.encoding=UTF-8 -classpath /home/inmemorialake/.m2/repository/org/openjfx/javafx-controls/17.0.6/javafx-controls-17.0.6.jar:/home/inmemorialake/.m2/repository/org/openjfx/javafx-graphics/17.0.6/javafx-graphics-17.0.6.jar:/home/inmemorialake/.m2/repository/org/openjfx/javafx-base/17.0.6/javafx-base-17.0.6.jar:/home/inmemorialake/.m2/repository/org/openjfx/javafx-fxml/17.0.6/javafx-fxml-17.0.6.jar -p /home/inmemorialake/.m2/repository/org/openjfx/javafx-base/17.0.6/javafx-base-17.0.6-linux.jar:/home/inmemorialake/.m2/repository/org/openjfx/javafx-graphics/17.0.6/javafx-graphics-17.0.6-linux.jar:/home/inmemorialake/.m2/repository/org/openjfx/javafx-controls/17.0.6/javafx-controls-17.0.6-linux.jar:/home/inmemorialake/Proyectos_Programacion/Java/Sesion 8/target/classes:/home/inmemorialake/.m2/repository/org/openjfx/javafx-fxml/17.0.6/javafx-fxml-17.0.6-linux.jar -m com.sesion8.sesion8/com.sesion8.sesion8.HelloApplication
        Error! Division by zero is not allowed.

        Process finished with exit code 0
     */

    public static void exercise3() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter the first number: ");
            int a = scanner.nextInt();

            System.out.print("Enter the second number: ");
            int b = scanner.nextInt();

            System.out.println("Result: " + (a / b));
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero.");
        } catch (InputMismatchException e) {
            System.out.println("Please enter only numbers.");
        }
    }

    // This method handles both ArithmeticException and InputMismatchException
    // The console output is:
    /*
    /home/inmemorialake/.jdks/corretto-17.0.14/bin/java -javaagent:/opt/intellij-idea-ultimate-edition/lib/idea_rt.jar=46527 -Dfile.encoding=UTF-8 -classpath /home/inmemorialake/.m2/repository/org/openjfx/javafx-controls/17.0.6/javafx-controls-17.0.6.jar:/home/inmemorialake/.m2/repository/org/openjfx/javafx-graphics/17.0.6/javafx-graphics-17.0.6.jar:/home/inmemorialake/.m2/repository/org/openjfx/javafx-base/17.0.6/javafx-base-17.0.6.jar:/home/inmemorialake/.m2/repository/org/openjfx/javafx-fxml/17.0.6/javafx-fxml-17.0.6.jar -p /home/inmemorialake/.m2/repository/org/openjfx/javafx-base/17.0.6/javafx-base-17.0.6-linux.jar:/home/inmemorialake/.m2/repository/org/openjfx/javafx-graphics/17.0.6/javafx-graphics-17.0.6-linux.jar:/home/inmemorialake/.m2/repository/org/openjfx/javafx-controls/17.0.6/javafx-controls-17.0.6-linux.jar:/home/inmemorialake/Proyectos_Programacion/Java/Sesion 8/target/classes:/home/inmemorialake/.m2/repository/org/openjfx/javafx-fxml/17.0.6/javafx-fxml-17.0.6-linux.jar -m com.sesion8.sesion8/com.sesion8.sesion8.HelloApplication
    Enter the first number: a
    Please enter only numbers.

    Process finished with exit code 0
     */
    // This is the method when the user enters a non-numeric value
    //<---------------------------------------------------------------------------------------------------------------->

    /*
    /home/inmemorialake/.jdks/corretto-17.0.14/bin/java -javaagent:/opt/intellij-idea-ultimate-edition/lib/idea_rt.jar=37713 -Dfile.encoding=UTF-8 -classpath /home/inmemorialake/.m2/repository/org/openjfx/javafx-controls/17.0.6/javafx-controls-17.0.6.jar:/home/inmemorialake/.m2/repository/org/openjfx/javafx-graphics/17.0.6/javafx-graphics-17.0.6.jar:/home/inmemorialake/.m2/repository/org/openjfx/javafx-base/17.0.6/javafx-base-17.0.6.jar:/home/inmemorialake/.m2/repository/org/openjfx/javafx-fxml/17.0.6/javafx-fxml-17.0.6.jar -p /home/inmemorialake/.m2/repository/org/openjfx/javafx-base/17.0.6/javafx-base-17.0.6-linux.jar:/home/inmemorialake/.m2/repository/org/openjfx/javafx-graphics/17.0.6/javafx-graphics-17.0.6-linux.jar:/home/inmemorialake/.m2/repository/org/openjfx/javafx-controls/17.0.6/javafx-controls-17.0.6-linux.jar:/home/inmemorialake/Proyectos_Programacion/Java/Sesion 8/target/classes:/home/inmemorialake/.m2/repository/org/openjfx/javafx-fxml/17.0.6/javafx-fxml-17.0.6-linux.jar -m com.sesion8.sesion8/com.sesion8.sesion8.HelloApplication
    Enter the first number: 12
    Enter the second number: 0
    Cannot divide by zero.

    Process finished with exit code 0
     */
    // This is the method when the user divides by zero
    //<---------------------------------------------------------------------------------------------------------------->

    /*
    /home/inmemorialake/.jdks/corretto-17.0.14/bin/java -javaagent:/opt/intellij-idea-ultimate-edition/lib/idea_rt.jar=43367 -Dfile.encoding=UTF-8 -classpath /home/inmemorialake/.m2/repository/org/openjfx/javafx-controls/17.0.6/javafx-controls-17.0.6.jar:/home/inmemorialake/.m2/repository/org/openjfx/javafx-graphics/17.0.6/javafx-graphics-17.0.6.jar:/home/inmemorialake/.m2/repository/org/openjfx/javafx-base/17.0.6/javafx-base-17.0.6.jar:/home/inmemorialake/.m2/repository/org/openjfx/javafx-fxml/17.0.6/javafx-fxml-17.0.6.jar -p /home/inmemorialake/.m2/repository/org/openjfx/javafx-base/17.0.6/javafx-base-17.0.6-linux.jar:/home/inmemorialake/.m2/repository/org/openjfx/javafx-graphics/17.0.6/javafx-graphics-17.0.6-linux.jar:/home/inmemorialake/.m2/repository/org/openjfx/javafx-controls/17.0.6/javafx-controls-17.0.6-linux.jar:/home/inmemorialake/Proyectos_Programacion/Java/Sesion 8/target/classes:/home/inmemorialake/.m2/repository/org/openjfx/javafx-fxml/17.0.6/javafx-fxml-17.0.6-linux.jar -m com.sesion8.sesion8/com.sesion8.sesion8.HelloApplication
    Enter the first number: 12
    Enter the second number: 6
    Result: 2

    Process finished with exit code 0
     */
    // This is the method when the user enters both numbers correctly
    //<---------------------------------------------------------------------------------------------------------------->

    public static void exercise4() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter the first number: ");
            int a = scanner.nextInt();

            System.out.print("Enter the second number: ");
            int b = scanner.nextInt();

            System.out.println("Result: " + (a / b));
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero.");
        } catch (InputMismatchException e) {
            System.out.println("Please enter only numbers.");
        } finally {
            System.out.println("Operation completed.");
        }
    }

    // This method handles both ArithmeticException, InputMismatchException and includes a finally block
    // The console output is:
    /*
    /home/inmemorialake/.jdks/corretto-17.0.14/bin/java -javaagent:/opt/intellij-idea-ultimate-edition/lib/idea_rt.jar=37627 -Dfile.encoding=UTF-8 -classpath /home/inmemorialake/.m2/repository/org/openjfx/javafx-controls/17.0.6/javafx-controls-17.0.6.jar:/home/inmemorialake/.m2/repository/org/openjfx/javafx-graphics/17.0.6/javafx-graphics-17.0.6.jar:/home/inmemorialake/.m2/repository/org/openjfx/javafx-base/17.0.6/javafx-base-17.0.6.jar:/home/inmemorialake/.m2/repository/org/openjfx/javafx-fxml/17.0.6/javafx-fxml-17.0.6.jar -p /home/inmemorialake/.m2/repository/org/openjfx/javafx-base/17.0.6/javafx-base-17.0.6-linux.jar:/home/inmemorialake/.m2/repository/org/openjfx/javafx-graphics/17.0.6/javafx-graphics-17.0.6-linux.jar:/home/inmemorialake/.m2/repository/org/openjfx/javafx-controls/17.0.6/javafx-controls-17.0.6-linux.jar:/home/inmemorialake/Proyectos_Programacion/Java/Sesion 8/target/classes:/home/inmemorialake/.m2/repository/org/openjfx/javafx-fxml/17.0.6/javafx-fxml-17.0.6-linux.jar -m com.sesion8.sesion8/com.sesion8.sesion8.HelloApplication
    Enter the first number: a
    Please enter only numbers.
    Operation completed.

    Process finished with exit code 0
     */
    // This is the method when the user enters a non-numeric value
    //<---------------------------------------------------------------------------------------------------------------->
    /*
    /home/inmemorialake/.jdks/corretto-17.0.14/bin/java -javaagent:/opt/intellij-idea-ultimate-edition/lib/idea_rt.jar=41525 -Dfile.encoding=UTF-8 -classpath /home/inmemorialake/.m2/repository/org/openjfx/javafx-controls/17.0.6/javafx-controls-17.0.6.jar:/home/inmemorialake/.m2/repository/org/openjfx/javafx-graphics/17.0.6/javafx-graphics-17.0.6.jar:/home/inmemorialake/.m2/repository/org/openjfx/javafx-base/17.0.6/javafx-base-17.0.6.jar:/home/inmemorialake/.m2/repository/org/openjfx/javafx-fxml/17.0.6/javafx-fxml-17.0.6.jar -p /home/inmemorialake/.m2/repository/org/openjfx/javafx-base/17.0.6/javafx-base-17.0.6-linux.jar:/home/inmemorialake/.m2/repository/org/openjfx/javafx-graphics/17.0.6/javafx-graphics-17.0.6-linux.jar:/home/inmemorialake/.m2/repository/org/openjfx/javafx-controls/17.0.6/javafx-controls-17.0.6-linux.jar:/home/inmemorialake/Proyectos_Programacion/Java/Sesion 8/target/classes:/home/inmemorialake/.m2/repository/org/openjfx/javafx-fxml/17.0.6/javafx-fxml-17.0.6-linux.jar -m com.sesion8.sesion8/com.sesion8.sesion8.HelloApplication
    Enter the first number: 12
    Enter the second number: 0
    Cannot divide by zero.
    Operation completed.

    Process finished with exit code 0
     */
    // This is the method when the user divides by zero
    //<---------------------------------------------------------------------------------------------------------------->
    /*
    /home/inmemorialake/.jdks/corretto-17.0.14/bin/java -javaagent:/opt/intellij-idea-ultimate-edition/lib/idea_rt.jar=43679 -Dfile.encoding=UTF-8 -classpath /home/inmemorialake/.m2/repository/org/openjfx/javafx-controls/17.0.6/javafx-controls-17.0.6.jar:/home/inmemorialake/.m2/repository/org/openjfx/javafx-graphics/17.0.6/javafx-graphics-17.0.6.jar:/home/inmemorialake/.m2/repository/org/openjfx/javafx-base/17.0.6/javafx-base-17.0.6.jar:/home/inmemorialake/.m2/repository/org/openjfx/javafx-fxml/17.0.6/javafx-fxml-17.0.6.jar -p /home/inmemorialake/.m2/repository/org/openjfx/javafx-base/17.0.6/javafx-base-17.0.6-linux.jar:/home/inmemorialake/.m2/repository/org/openjfx/javafx-graphics/17.0.6/javafx-graphics-17.0.6-linux.jar:/home/inmemorialake/.m2/repository/org/openjfx/javafx-controls/17.0.6/javafx-controls-17.0.6-linux.jar:/home/inmemorialake/Proyectos_Programacion/Java/Sesion 8/target/classes:/home/inmemorialake/.m2/repository/org/openjfx/javafx-fxml/17.0.6/javafx-fxml-17.0.6-linux.jar -m com.sesion8.sesion8/com.sesion8.sesion8.HelloApplication
    Enter the first number: 12
    Enter the second number: 6
    Result: 2
    Operation completed.

    Process finished with exit code 0
     */
    // This is the method when the user enters both numbers correctly
    //<---------------------------------------------------------------------------------------------------------------->

    // Custom exception class
    // This class is used to handle the case when an FXML file is not found.
    // It extends the Exception class and provides a constructor to set the error message.
    public static class FXMLNotFoundException extends Exception {
        public FXMLNotFoundException(String message) {
            super(message);
        }
    }

    // This method simulates loading an FXML file and throws a custom exception if the file is not found.
    public static void exercise5() {
        try {
            loadFXML("nonexistent.fxml");
        } catch (FXMLNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // This method simulates loading an FXML file.
    // If the file is not found, it throws a custom exception FXMLNotFoundException.
    // In this case, it checks if the filename is "interface.fxml".
    // If it is not, it throws the custom exception.
    public static void loadFXML(String filename) throws FXMLNotFoundException {
        if (!filename.equals("interface.fxml")) {
            throw new FXMLNotFoundException("FXML file not found: " + filename);
        }
        System.out.println("FXML file loaded successfully.");
    }

    // This method handles the custom exception FXMLNotFoundException
    // The console output is:
    /*
    /home/inmemorialake/.jdks/corretto-17.0.14/bin/java -javaagent:/opt/intellij-idea-ultimate-edition/lib/idea_rt.jar=35211 -Dfile.encoding=UTF-8 -classpath /home/inmemorialake/.m2/repository/org/openjfx/javafx-controls/17.0.6/javafx-controls-17.0.6.jar:/home/inmemorialake/.m2/repository/org/openjfx/javafx-graphics/17.0.6/javafx-graphics-17.0.6.jar:/home/inmemorialake/.m2/repository/org/openjfx/javafx-base/17.0.6/javafx-base-17.0.6.jar:/home/inmemorialake/.m2/repository/org/openjfx/javafx-fxml/17.0.6/javafx-fxml-17.0.6.jar -p /home/inmemorialake/.m2/repository/org/openjfx/javafx-base/17.0.6/javafx-base-17.0.6-linux.jar:/home/inmemorialake/.m2/repository/org/openjfx/javafx-graphics/17.0.6/javafx-graphics-17.0.6-linux.jar:/home/inmemorialake/.m2/repository/org/openjfx/javafx-controls/17.0.6/javafx-controls-17.0.6-linux.jar:/home/inmemorialake/Proyectos_Programacion/Java/Sesion 8/target/classes:/home/inmemorialake/.m2/repository/org/openjfx/javafx-fxml/17.0.6/javafx-fxml-17.0.6-linux.jar -m com.sesion8.sesion8/com.sesion8.sesion8.HelloApplication
    Error: FXML file not found: nonexistent.fxml

    Process finished with exit code 0
     */
    // This is the method when the user tries to load a non-existent FXML file


}