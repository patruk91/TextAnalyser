package com.codecool;

import com.codecool.Controller.Controller;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller(args);
        controller.start();
    }
}
