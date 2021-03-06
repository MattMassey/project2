package com.company.week1;
import java.util.*;

//Matthew Massey, 2/13/2019
//Program allows user to create a mutable to-do list
//CSCI 1660, project 2

public class Main {
    static Scanner input = new Scanner(System.in);
    static Map<Integer, Task> list = new HashMap<>();
    static int counter = 1; //To be able to search for a task, a counter serves as a unique identifier

    public static void main(String[] args) {
        System.out.println("This programs allows you to keep a running to-do list.");
        System.out.println("(1) Add a task.\n(2) Change a task.\n(3) Remove a task.\n(4) List tasks.\n(0) Exit");
        int choice = Integer.parseInt(input.nextLine());
        while (choice != 0) {
            String tempName;
            String tempDesc; //These three variables store temporary data
            int tempInt = 0;
            boolean goodInput = false;

            switch (choice) {
                case 1:
                    System.out.println("Name of task?");
                    tempName = input.nextLine();
                    System.out.println("Description?");
                    tempDesc = input.nextLine();
                    while (!goodInput) {
                        try {
                            System.out.println("Priority? (0-5, 5 highest)");
                            tempInt = Integer.parseInt(input.nextLine());
                            if (tempInt < 0 || tempInt > 5) {
                                throw new Exception ();
                            } else {
                                goodInput = true;
                            }
                        } catch (Exception e) {
                            System.out.println("Oops!  That was not an integer, or was out of range.");
                        }
                    }
                    list.put(counter, addTask(tempName, tempDesc, tempInt));
                    counter++; //Increment counter to keep identifiers unique
                    System.out.println("Done.");
                    break;
                case 2:
                    while (!goodInput) {
                        try {
                            System.out.println("Task identifier? (integer before 'Task')");
                            tempInt = Integer.parseInt(input.nextLine());
                            goodInput = true;
                        } catch (Exception e) {
                            System.out.println("That was not an integer.");
                        }
                    }
                    changeTask(tempInt);
                    System.out.println("Done.");
                    break;
                case 3:
                    while (!goodInput) {
                        try {
                            System.out.println("Task identifier? (integer before 'Task')");
                            tempInt = Integer.parseInt(input.nextLine());
                            goodInput = true;
                        } catch (Exception e) {
                            System.out.println("That was not an integer.");
                        }
                    }
                    removeTask(tempInt);
                    System.out.println("Done.");
                    break;
                case 4:
                    System.out.println("Would you like to: (1) list all tasks, or (2) only those of a specific priority?");
                    while (!goodInput) {
                        try {
                            tempInt = Integer.parseInt(input.nextLine());
                            if (tempInt == 1 || tempInt == 2) {
                                goodInput = true;

                            } else {
                                throw new Exception();
                            }
                        } catch (Exception e) {
                            System.out.println("Oops!  That was not an integer, or was out of range.");
                        }
                    }
                    goodInput = false;
                    if (tempInt == 1) {
                        System.out.println(list);
                    } else {
                        while (!goodInput) {
                            try {
                                System.out.println("What priority?");
                                listTask(Integer.parseInt(input.nextLine()));
                                goodInput = true;
                            } catch (Exception e) {
                                System.out.println("That was not an integer.");
                            }
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid choice.  Please try again.");
                    break;
            }
            System.out.println("(1) Add a task.\n(2) Change a task.\n(3) Remove a task.\n(4) List tasks.\n(0) Exit");
            choice = Integer.parseInt(input.nextLine());
        }
        System.out.println("Goodbye!");
    }

    public static Task addTask(String name, String desc, int pri) {
        Task newTask = new Task();
        newTask.setTitle(name);
        newTask.setDescription(desc);
        newTask.setPriority(pri);
        return newTask;
    }

    public static void removeTask(int identifier) {
        if (list.containsKey(identifier)) {
            list.remove(identifier);
        } else {
            System.out.println("That task identifier doesn't exist");
        }
    }

    public static void changeTask(int identifier) {
        if (list.containsKey(identifier)) {
            System.out.println("New Description?");
            list.get(identifier).setDescription(input.nextLine());
        } else {
            System.out.println("That task identifier doesn't exist");
        }
    }

    public static void listTask(int priority) {
        try {
            for (int i = 1; i <= list.size(); i++) {
                if (list.get(i).getPriority() == priority) {
                    System.out.println(list.get(i));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
