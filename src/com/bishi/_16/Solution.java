package com.bishi._16;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'countVotes' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING_ARRAY validCandidates
     *  2. STRING_ARRAY voteCasted
     */

    public static String countVotes(List<String> validCandidates, List<String> voteCasted) {
        HashMap<String, Long> map = new HashMap<>();
        long sum = 0;
        long max = -1;
        String winner = "";
        StringBuilder sb = new StringBuilder();
        String tmp = "";
        for (int i = 0; i < validCandidates.size(); i++) {
            String person = validCandidates.get(i);
            long count = voteCasted.stream()
                    .filter(a -> person.equals(a))
                    .count();
            if (count > max) {
                max = count;
                winner = person;
            }
            sum += count;
            tmp = person + "=" + count;
            sb.append(tmp);
            map.put(person, count);
        }

        if (sum == 0) winner = "N/A";
        tmp = "Winner=" + winner;
        sb.append(tmp);
        return sb.toString();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int validCandidatesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> validCandidates = IntStream.range(0, validCandidatesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        int voteCastedCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> voteCasted = IntStream.range(0, voteCastedCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        String result = Result.countVotes(validCandidates, voteCasted);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

