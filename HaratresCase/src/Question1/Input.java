package Question1;
import java.util.Scanner;
public class Input {

    private  Scanner scanner;

     Input(){
         this.scanner= new Scanner(System.in);
     }

     public int getMaxCharCount(){
         System.out.println("Maksimum karakter sayısını giriniz:");
         return  scanner.nextInt();
     }

     public String getSentence(int maxCharCount){
         scanner.nextLine();
         String sentence;
         do {
             System.out.print("Lütfen bir cümle girin: ");
             sentence = scanner.nextLine();
             if (sentence.length() > maxCharCount) {
                 System.out.println("Girilen cümle karakter limitini aşıyor. Lütfen yeniden girin.");
             }
         } while (sentence.length() > maxCharCount);
         return sentence;

     }

     public boolean getCaseSensitivity(){
         while(true){
             System.out.println("Büyük,Küçük harf duyarlılığı aktif olsun mu ?");
             String caseSensitivity=scanner.nextLine();
             if (caseSensitivity.equalsIgnoreCase("Evet")){
                 return  true;
             }
             else if(caseSensitivity.equalsIgnoreCase("Hayır")){
                 return false;
             }
             else {
                 System.out.println("Lütfen geçerli bir cevap girin");
             }
         }
     }

    public char getCharacterToAnalyze() {
        while (true) {
            System.out.print("Analiz etmek için bir harf girin: ");
            String input = scanner.nextLine();
            if (input.length() == 1) {
                return input.charAt(0);
            } else {
                System.out.println("Geçerli bir karakter giriniz.");
            }
        }
    }



}
