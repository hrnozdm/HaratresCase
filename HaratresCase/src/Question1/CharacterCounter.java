package Question1;

public class CharacterCounter {

    private String clause;

    private boolean caseSensitive;

    private char characterToAnalyze;

    CharacterCounter(String clause,boolean caseSensitive,char characterToAnalyze){
        this.clause=clause;
        this.caseSensitive=caseSensitive;
        this.characterToAnalyze=characterToAnalyze;
    }

    public int countCharacter() {
        int count = 0;
        String enteredSentence = caseSensitive ? clause : clause.toLowerCase();
        char enteredChar = caseSensitive ? characterToAnalyze : Character.toLowerCase(characterToAnalyze);

        for (char c : enteredSentence.toCharArray()) {
            char charToCheck = caseSensitive ? c : Character.toLowerCase(c);
            if (charToCheck == enteredChar) {
                count++;
            }
        }

        return count;
    }

    public char getCharacterToAnalyze(){
        return  characterToAnalyze;
    }


}
