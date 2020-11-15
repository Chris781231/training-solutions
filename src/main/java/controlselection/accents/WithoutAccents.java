package controlselection.accents;

public class WithoutAccents {


    public char convertToCharWithoutAccents(char character) {
        switch (character) {
            // Lowercase
            case 'á':
                return 'a';
            case 'é':
                return 'e';
            case 'í':
                return 'i';
            case 'ó':
            case 'ö':
            case 'ő':
                return 'o';
            case 'ú':
            case 'ü':
            case 'ű':
                return 'u';

            // Uppercase
            case 'Á':
                return 'A';
            case 'É':
                return 'E';
            case 'Í':
                return 'I';
            case 'Ó':
            case 'Ö':
            case 'Ő':
                return 'O';
            case 'Ú':
            case 'Ü':
            case 'Ű':
                return 'U';
            default:
                return character;
        }
    }
}
