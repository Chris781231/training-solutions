package localvariables;

public class LocalVariablesMain {

    public static void main(String[] args) {

        boolean b;
        b = false;

        System.out.println("If 'b' variable is not initialized, it hasn't initial value therefore it cause a compiling error. It must be an initial value.");
        System.out.println("b (boolean) = " + b);

        int a = 2;
        int i = 3;
        int j = 4;
        int k;
        k = i;

        System.out.println("If a variable is not declared, we can't work with it. All variables must be declared and initialized before we want to use them.");

        String s = "Hello World";
        String t;
        t = s;

        {
            int x;
            x = 0;

            System.out.println(a);
        }

        System.out.println("The variables lives within that block where they were created. They are not visible and cannot be used outside the block");
        System.out.println("However the variables that are created outside the block they are visible and can be used inside the blocks");



    }

}
