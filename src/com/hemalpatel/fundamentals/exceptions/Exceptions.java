package com.hemalpatel.fundamentals.exceptions;

import java.io.*;

/**
 * Exception is generated when error occurs in the code.
 *
 * Exceptions provide a non-intrusive way to signal errors.
 *
 * Terms used while using exception is that when the exception occurs,
 * the exception is thrown. And an application can deal with that exception
 * by catching the exception.
 *
 * Exceptions allow structured error handling in the code.
 *
 * Try/catch blocks:
 * Try:
 * -    Try contains normal code to be execute (Potentially the code block where an error might occur)
 * -    If there is no exception occur, the code runs to the completion
 * -    If exception is thrown, the code within try block is immediately exited and control
 *      is transferred to "catch" block
 *
 * Catch:
 * -    Catch block contains our error handling code
 * -    Catch block only runs if matching exception is thrown
 * -    It also receives the information about the thrown exception
 *
 * Finally:
 * -    It runs in all cases following try or catch
 * -    Even if there is a return statement in try/catch, finally block is executed
 *
 * Manual cleanup:
 * -    It can can be cumbersome
 * -    Requires null value validation
 * -    Requires additional exception handling within finally block
 *
 * Automating Cleanup:
 * -   Any type that supports automated cleanup needs to implement the interface {@link AutoCloseable}
 *     it is also possible that type implements other interfaces which inherit from AutoCloseable(like {@link Closeable})
 * -   To leverage automated cleanup, we need to use try-with-resources statement
 * -   Try-with-resource type allow us to create a type and take care of closing it by calling close() method
 *
 * Exception Class Hierarchy
 * -    Exceptions are represented by classes and they all inherit from {@link Exception} class
 * -    Important class inherit from {@link Exception} is {@link RuntimeException} which represents the
 *      kind of exception that could be thrown directly by the runtime
 *
 * Exception can be handled by Type
 * -    A try block can have multiple catches associated with it
 * -    Catches are tested in order from top-to-bottom
 * -    First assignable catch is selected
 * -    Place more specific exceptions before less specific exceptions
 *
 * Exception categories
 * -    Checked exceptions
 * -    Unchecked exceptions
 *
 * Checked exceptions
 * -    Compiler raises an error if not handled
 *
 * Unchecked exceptions
 * -    Compiler does not enforce error handling
 * -    Inherited from {@link RuntimeException}
 *
 * Exception and methods
 * -    Exceptions can cross method boundaries
 * -    If method does not handle the exception, the exception will travel up the call stack
 * -    Method must deal with any checked exceptions
 *      -   Either catch the exception or document that exception might occur by using throws clause
 * -    Throws only works with checked exceptions
 *
 * Throw exception
 * -    Throw keyword is used to indicate that some issue has occurred
 * -    Create new instance of exception using constructor and throw it
 *
 * Custom Exception
 * -    When checked custom exception is thrown, the method must document that to let caller method know
 *
 * Centralized Exception Handling
 * -    Exception handling is grouped together in one place or few places at high up in the application
 * -    Benefit: Simplify exception handling since all exception handling is in one place or small number of spaces
 * -    Drawback: It makes exception recovery more difficult - since its not possible to go back to the code where exception occurred
 *
 * Localized Exception Handling
 * -    Placing exception handling closer to the point where the issue occurs
 * -    Benefit: It makes it easy to recover from an exception
 * -    Drawback: it makes exception handling cumbersome since error handling is spread throughout code
 *
 * Handle recoverable exception locally and handle broader and unrecoverable exception centrally
 */
public class Exceptions {

    public static void main(String[] args) {
        String file = new File("").getAbsolutePath().concat("\\data\\exceptionTestFile.txt");
        Exceptions exceptions = new Exceptions();

        exceptions.manualCleanup(file);
        exceptions.autoCleanup(file);
        exceptions.withMultipleCatches(file);
        exceptions.exceptionWithMultipleMethods(file);
        try {
            exceptions.throwAnException(0);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            exceptions.throwCustomException(0);
        } catch (CustomException e) {
            System.out.println("Custom Exception: " + e.getMessage());
        }

        try {
            exceptions.chainedException(0, 0);
        } catch (CustomException e) {
            System.out.println("Chained exception : " + e.getMessage());
            if(e.getCause() != null) {
                System.out.println("caused by : " + e.getCause());
            }
        }

        try {
            exceptions.chainedException(4, 0);
        } catch (CustomException e) {
            System.out.println("Chained exception : " + e.getMessage());
            if(e.getCause() != null) {
                System.out.println("caused by : " + e.getCause());
            }
        }
    }

    public void manualCleanup(String file) {
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            String line;
            System.out.println("Data from file:");
            while((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                System.out.println("Closing file : " + file);
                if(reader != null)
                    reader.close();
            } catch (Exception e) {
                System.out.println("Error closing file");
            }
        }
    }

    public void autoCleanup(String file) {

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            System.out.println("Data from file:");
            while((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void withMultipleCatches(String file) {

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            System.out.println("Data from file:");
            while((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found : " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading file : " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    public void exceptionWithMultipleMethods(String file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
           fileManagement(reader);
        } catch (FileNotFoundException e) {
            System.out.println("File not found : " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading file : " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    public void fileManagement(BufferedReader reader) throws IOException {
        String line;
        System.out.println("Data from file:");
        while((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }

    public void throwAnException(int value) {
        if(value == 0) {
            throw new IllegalArgumentException("Value can not be zero");
        }
    }

    public void throwCustomException(int value) throws CustomException {
        if(value == 0) {
            throw new CustomException("Value can not be zero");
        }
    }

    public void chainedException(int value1, int value2) throws CustomException {
        try {
            if (value1 == 0) {
                throw new CustomException("Value can not be zero");
            }
            System.out.println(value1/value2);
        } catch (CustomException e) { // Handle it here so that we do not create wrapper in next catch block
            throw e;
        } catch (Exception e) {
            throw new CustomException(e.getMessage(), e);
        }
    }
}
