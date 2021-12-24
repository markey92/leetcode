package com.markey.leetcode.nine;

import java.util.*;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.nine
 * @ClassName: Leetcode911
 * @Author: markey
 * @Description:
 * @Date: 2021/12/11 10:50
 * @Version: 1.0
 */
public class Leetcode911 {
    class TopVotedCandidate {
        // key是time， value是person
        TreeMap<Integer, Integer> winnerOfTime = new TreeMap<>();
        public TopVotedCandidate(int[] persons, int[] times) {
            int winner = -1;
            int voteOfWinner = Integer.MIN_VALUE;
            // key是person， value是vote
            Map<Integer, Integer> voteOfPerson = new HashMap<>();
            for (int i = 0; i < persons.length; i++) {
                int person = persons[i];
                int time = times[i];
                voteOfPerson.put(person, voteOfPerson.getOrDefault(person, 0) + 1);
                if (voteOfPerson.get(person) >= voteOfWinner) {
                    winner = person;
                    voteOfWinner = voteOfPerson.get(person);
                }
                winnerOfTime.put(time, winner);
            }
        }

        public int q(int t) {
            return this.winnerOfTime.get(winnerOfTime.floorKey(t));
        }
    }
}
