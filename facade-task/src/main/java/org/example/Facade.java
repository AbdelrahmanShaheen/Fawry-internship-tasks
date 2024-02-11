package org.example;

public class Facade {
    private SubSystemA subSystemA;
    private SubSystemB subSystemB;
    private SubSystemC subSystemC;

    public Facade() {
        this.subSystemA = new SubSystemA();
        this.subSystemB = new SubSystemB();
        this.subSystemC = new SubSystemC();
    }

    public void operationFacade() {
        System.out.println("Facade operation");
        subSystemA.operationA();
        subSystemB.operationB();
        subSystemC.operationC();
    }
}
