package Question1;

public class Main {
    public static void main(String[] args) {
        Input inputHandler = new Input();

        int maxCharCount = inputHandler.getMaxCharCount();
        String sentence = inputHandler.getSentence(maxCharCount);
        boolean caseSensitive = inputHandler.getCaseSensitivity();
        char characterToAnalyze = inputHandler.getCharacterToAnalyze();

        CharacterCounter characterCounter = new CharacterCounter(sentence, caseSensitive, characterToAnalyze);
        int count = characterCounter.countCharacter();

        System.out.println("Girilen cümlede '" + characterCounter.getCharacterToAnalyze() + "' harfi toplamda " + count + " defa geçmektedir.");
    }
}
