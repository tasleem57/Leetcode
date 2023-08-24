import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();

        int i = 0;
        int width = 0;
        List<String> curLine = new ArrayList<>();

        while (i < words.length) {
            String curWord = words[i];

            if (width + curWord.length() <= maxWidth) {
                curLine.add(curWord);
                width += curWord.length() + 1;
                i++;
            } else {
                int spaces = maxWidth - width + curLine.size();

                int added = 0;
                int j = 0;

                while (added < spaces) {
                    if (j >= curLine.size() - 1) {
                        j = 0;
                    }

                    curLine.set(j, curLine.get(j) + " ");
                    added++;
                    j++;
                }

                res.add(String.join("", curLine));

                curLine.clear();
                width = 0;
            }
        }

        for (int word = 0; word < curLine.size() - 1; word++) {
            curLine.set(word, curLine.get(word) + " ");
        }
        curLine.set(curLine.size() - 1, curLine.get(curLine.size() - 1) + " ".repeat(maxWidth - width + 1));

        res.add(String.join("", curLine));

        return res;
    }
}