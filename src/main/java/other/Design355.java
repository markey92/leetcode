package other;

import java.util.*;

/**
 * @ProjectName: leetcode
 * @Package: other
 * @ClassName: Design355
 * @Author: markey
 * @Description:
 * @Date: 2020/4/13 21:51
 * @Version: 1.0
 */
public class Design355 {
    class Twitter {

        class Tweet {
            private int id;
            private long timestamp;
            private Tweet next;
            public Tweet(int id, long timestamp, Tweet next) {
                this.id = id;
                this.timestamp = timestamp;
                this.next = next;
            }

            public long getTimestamp() {
                return timestamp;
            }

            public int getId() {
                return id;
            }

            public Tweet getNext() {
                return next;
            }
        }

        class Person {
            private int id;
            private Tweet tweet;
            private Set<Person> followers;
            public Person(int id) {
                this.id = id;
                this.followers = new HashSet<>();
            }

            public Tweet getTweet() {
                return tweet;
            }

            public void setTweet(Tweet tweet) {
                this.tweet = tweet;
            }

            public void follow(Person followee) {
                this.followers.add(followee);
            }

            public void unFollow(Person followee) {
                this.followers.remove(followee);
            }

            public Set<Person> getFollowers() {
                return followers;
            }
        }

        Map<Integer, Person> personMap;
        int timestamp;
        /** Initialize your data structure here. */
        public Twitter() {
            this.personMap = new HashMap<>();
            this.timestamp = 0;
        }

        /** Compose a new tweet. */
        public void postTweet(int userId, int tweetId) {
            if (!personMap.containsKey(userId)) {
                personMap.put(userId, new Person(userId));
            }
            Person person = personMap.get(userId);
            Tweet tweet = new Tweet(tweetId, this.timestamp++, person.getTweet());
            person.setTweet(tweet);
        }

        /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
        public List<Integer> getNewsFeed(int userId) {
            PriorityQueue<Tweet> tweets = new PriorityQueue<>((tweet1, tweet2) -> (int) (tweet2.getTimestamp() - tweet1.getTimestamp()));
            Person person = personMap.get(userId);
            if (person != null) {
                if (person.getTweet() != null) {
                    tweets.offer(person.getTweet());
                }
                for (Person p: person.getFollowers()) {
                    if (p != person && p.getTweet() != null) {
                        tweets.add(p.getTweet());
                    }
                }
            }

            List<Integer> res = new ArrayList<>();
            for (int i = 0; !tweets.isEmpty() && i < 10; i++) {
                Tweet tweet = tweets.poll();
                res.add(tweet.getId());
                if (tweet.getNext() != null) {
                    tweets.offer(tweet.getNext());
                }
            }
            return res;
        }

        /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
        public void follow(int followerId, int followeeId) {
            if (!personMap.containsKey(followerId)) {
                personMap.put(followerId, new Person(followerId));
            }
            if (!personMap.containsKey(followeeId)) {
                personMap.put(followeeId, new Person(followeeId));
            }
            personMap.get(followerId).follow(personMap.get(followeeId));
        }

        /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
        public void unfollow(int followerId, int followeeId) {
            if (!personMap.containsKey(followerId)) {
                personMap.put(followerId, new Person(followerId));
            }
            if (!personMap.containsKey(followeeId)) {
                personMap.put(followeeId, new Person(followeeId));
            }
            personMap.get(followerId).unFollow(personMap.get(followeeId));
        }
    }
}
