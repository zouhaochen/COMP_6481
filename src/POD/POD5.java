package POD;

import java.util.*;

public class POD5
{
    static Scanner sc = new Scanner(System.in);
    static HashMap<String, HashMap<String, String>> dictionaries = new HashMap<>();
    static List<List<String>> textLines = new ArrayList<>();

    public static void checkLanguage()
    {
        for (List<String> line : textLines)
        {
            for (String word : line)
            {
                if (findLanguage(word))
                    break;
            }
        }
    }

    public static boolean findLanguage(String word)
    {
        for (String language : dictionaries.keySet())
        {
            if (dictionaries.get(language).containsKey(word))
            {
                System.out.println(language);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args)
    {
        int num = sc.nextInt();
        sc.nextLine();

        // Create dictionaries for all languages
        for (int i = 0; i < num; i++)
        {
            String line = sc.nextLine();
            String[] words = line.split(" ");
            HashMap<String, String> dict = new HashMap<>();
            for (int j = 1; j < words.length; j++)
            {
                dict.put(words[j], words[j]);
            }
            dictionaries.put(words[0], dict);
        }
        sc.nextLine();
        String line = null;
        while (!(line = sc.nextLine()).isEmpty())
        {
            List<String> words = new ArrayList<String>(Arrays.asList(line.split("[ ,!.!;?()]+")));
            textLines.add(words);
        }
        checkLanguage();
    }
}
