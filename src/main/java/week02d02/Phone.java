package week02d02;

import java.util.Scanner;

public class Phone {

    private String type;
    private int mem;

    public Phone(String type, int mem) {
        this.type = type;
        this.mem = mem;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMem() {
        return mem;
    }

    public void setMem(int mem) {
        this.mem = mem;
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Phone type: ");
        String type = scanner.nextLine();
        System.out.print("Phone memory size: ");
        int mem = Integer.parseInt(scanner.nextLine());

        Phone phone = new Phone(type, mem);

        System.out.printf("Type: %s\nMem: %dGB", phone.getType(), phone.getMem());
    }
}
