package P3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.function.Predicate;

/**
 * Created by Jack on 10/18/2016.
 */
public class CollectionTest {
    private static List<String> dictionary = new ArrayList<String>();
    private static final String FILE_NAME = "dictionary.txt";

    public static void main(String[] args) {
        loadFile();

        // Collection 1
        Predicate kaPred = new StringPrefix("ka");
        Collection<String> collectionOne = new FilteredCollection<String>(kaPred, dictionary);
        Predicate lengthPred = new StringLength(5);
        collectionOne = new FilteredCollection<String>(lengthPred, collectionOne);
        Comparator<String> reverseAlphabetical = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareToIgnoreCase(o1);
            }
        };
        collectionOne = new SortedCollection<String>(reverseAlphabetical, collectionOne);

        System.out.println("Collection 1:\n" + collectionOne.toString());

        // Collection 2
        Predicate viviPred = new StringPrefix("vivi");
        Predicate psePred = new StringPrefix("pse");
        Collection<String> collectionTwo = new FilteredCollection<String>(viviPred, dictionary);
        Collection<String> dictionaryPseTemp = new FilteredCollection<String>(psePred, dictionary);
        collectionTwo = new MergedCollection<String>(collectionTwo, dictionaryPseTemp);
        Comparator<String> wordLengthAscending = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int len1 = o1.length();
                int len2 = o2.length();
                if (len1 > len2) {
                    return 1;
                } else if (len1 < len2) {
                    return -1;
                } else {
                    return 0;
                }
            }
        };
        collectionTwo = new SortedCollection<String>(wordLengthAscending, collectionTwo);

        System.out.println("Collection 2:\n" + collectionTwo.toString());
    }

    private static void loadFile() {
        File dFile = new File(FILE_NAME);
        try {
            Scanner sc = new Scanner(dFile);
            while (sc.hasNextLine()) {
                dictionary.add(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
