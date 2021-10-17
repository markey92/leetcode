package competition.year2021.day20210626;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210626
 * @ClassName: Leetcode5783
 * @Author: markey
 * @Description:
 * @Date: 2021/6/26 23:07
 * @Version: 1.0
 */
public class Leetcode5783 {
    class MovieRentingSystem {
        TreeSet<Movie> renting = new TreeSet<>((o1, o2) -> {
            if (o1.price != o2.price) {
                return o1.price - o2.price;
            }
            if (o1.shop != o2.shop) {
                return o1.shop - o2.shop;
            }
            return o1.movie - o2.movie;
        });
        Map<Integer, TreeSet<Movie>> movieMap =new HashMap<>();
        Map<Integer, Movie> prices =new HashMap<>();
        public MovieRentingSystem(int n, int[][] entries) {
            for (int[] entrie : entries) {
                if (!movieMap.containsKey(entrie[1])) {
                    movieMap.put(entrie[1], new TreeSet<>((o1, o2) -> {
                        if (o1.price != o2.price) {
                            return o1.price - o2.price;
                        }
                        if (o1.shop != o2.shop) {
                            return o1.shop - o2.shop;
                        }
                        return o1.movie - o2.movie;
                    }));
                }
                Movie movie = new Movie(entrie[0], entrie[1], entrie[2]);
                movieMap.get(entrie[1]).add(movie);
                prices.put(entrie[0] * 100000 + entrie[1], movie);
            }
            System.out.println(movieMap);
        }


        public List<Integer> search(int movie) {
            List<Movie> res = new ArrayList<>();
            for (int i = 0; movieMap.get(movie) != null && !movieMap.get(movie).isEmpty() && i < 5; i++) {
                res.add(movieMap.get(movie).pollFirst());
            }
            for (int i = 0; i < res.size(); i++) {
                movieMap.get(movie).add(res.get(i));
            }
            return res.stream().map(movie1 -> movie1.shop).collect(Collectors.toList());
        }

        public void rent(int shop, int movie) {
            Movie temp = prices.get(shop * 100000 + movie);
            movieMap.get(movie).remove(temp);
            renting.add(temp);
        }

        public void drop(int shop, int movie) {
            Movie temp = prices.get(shop * 100000 + movie);
            movieMap.get(movie).add(temp);
            renting.remove(temp);
        }

        public List<List<Integer>> report() {
            System.out.println(renting);
            List<Movie> res = new ArrayList<>();
            for (int i = 0; !renting.isEmpty() && i < 5; i++) {
                res.add(renting.pollFirst());
            }
            for (int i = 0; i < res.size(); i++) {
                renting.add(res.get(i));
            }
            return res.stream().map(movie -> {
                List<Integer> temp = new ArrayList<>();
                temp.add(movie.shop);
                temp.add(movie.movie);
                return temp;
            }).collect(Collectors.toList());
        }

        class Movie {
            int shop;
            int movie;
            int price;

            public Movie(int shop, int movie, int price) {
                this.shop = shop;
                this.movie = movie;
                this.price = price;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Movie movie1 = (Movie) o;
                return shop == movie1.shop &&
                        movie == movie1.movie &&
                        price == movie1.price;
            }

            @Override
            public int hashCode() {
                return Objects.hash(shop, movie, price);
            }

            @Override
            public String toString() {
                return "Movie{" +
                        "shop=" + shop +
                        ", movie=" + movie +
                        ", price=" + price +
                        '}';
            }
        }
    }
}
