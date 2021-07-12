package my.sample.app;

import java.util.*;

/**
 * This class, to count the number of duplicated words,
 * connects all the necessary classes and runs their methods for execution.
 */
public class WordCounterApp {
    public static String fileName = "C://WorkTasks//WordCounter//1.txt";

    public static void main(String[] args) {
        FromFileReader fromFileReader = new FromFileReader();
        LineConverter lineConverter = new LineConverter();
        DuplicateCounter duplicateCounter = new DuplicateCounter();
        HashMap<String, Integer> wordCountMap1 = new HashMap<>();

        List<String> linesFromFile = fromFileReader.loadFromFile(fileName);

        for (String line : linesFromFile) {
            if (!line.isEmpty()) {
                List<String> words = lineConverter.extractWords(line);
                duplicateCounter.countWords(words, wordCountMap1);
                words.clear();
            }
        }

        System.out.println();
        System.out.println("List of duplicates and their number: " + wordCountMap1);
        System.out.println();
        System.out.println("There are " + wordCountMap1.size() + " words in the text.");

        System.out.println();
        System.out.println("------------------------ Sorted option ------------------------");

        Set<Map.Entry<String, Integer>> setWords = wordCountMap1.entrySet();
        List<Map.Entry<String, Integer>> listWords = new ArrayList<>(setWords);
        listWords.sort(Map.Entry.comparingByValue());

        System.out.println();
        System.out.println("List of duplicates and their number: " + listWords);
        System.out.println();
        System.out.println("There are  " + listWords.size() + " words in the text.");
    }
}
