package week08.d04.midlevel;

public class TrainerMain {

    public static void main(String[] args) {

        Trainer trainerInGoodMood = new Trainer(new GoodMood());
        Trainer trainerInBadMood = new Trainer(new BadMood());

        System.out.printf("Trainer gives %s mark in GOOD mood%n", trainerInGoodMood.giveMark());
        System.out.printf("Trainer gives %s mark in BAD mood%n", trainerInBadMood.giveMark());
    }
}
