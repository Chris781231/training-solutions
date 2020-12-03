package abstractclass.gamecharacter;

public class BattleField {

    private int round;

    public int getRound() {
        return round;
    }

    private boolean oneHit(Character attacker, Character defender) {
        if (attacker.isAlive() && defender.isAlive()) {
            attacker.primaryAttack(defender);
            attacker.secondaryAttack(defender);
        }
        return defender.isAlive();
    }

    public Character fight(Character one, Character other) {
        while (one.isAlive() && other.isAlive()) {
            boolean defenderIsAlive = oneHit(one, other);
            if (defenderIsAlive) {
                oneHit(other, one);
            }
            round++;
        }
        return one.isAlive() ? one : other;
    }
}
