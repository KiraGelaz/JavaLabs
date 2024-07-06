import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        Translator trans = new Translator();
        String file1 = "C:/Users/gelaz/OneDrive/Рабочий стол/file.txt";
        String file2 = "C:/Users/gelaz/OneDrive/Рабочий стол/text.txt";
        try {
            trans.ReadDict(file1);
        } catch (Exception ex){
            System.out.println(ex + " while reading dict");
        }
        try {
            trans.ReadText(file2);
        } catch (Exception ex){
            System.out.println(ex + " while reading text");
        }
        System.out.println(trans.TranslateText());
    }
}