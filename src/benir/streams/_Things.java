package benir.streams;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class _Things {
    public static void main(String[] args) {
        var movies = List.of(
                new Movie("a",10),
                new Movie("b",20),
                new Movie("c",30)

        );
//        movies
//                .stream()
//                .map(movie->movie.getName())
//                .forEach(name-> System.out.println(name));


        _Things.filter();
    }
    static class Movie{
        private String name;
        private int likes;

        public Movie(String name, int likes) {
            this.name = name;
            this.likes = likes;
        }

        public int getLikes() {
            return likes;
        }

        public void setLikes(int likes) {
            this.likes = likes;
        }
        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name=name;
        }
    }
    public static void show(){
        //This is a stream of list of integers
        var stream3=Stream.of(List.of(1,2,3), List.of(4,5,6));
        stream3
                .flatMap(list->list.stream())
                .forEach(n-> System.out.println(n));
    }
    public static void filter(){
        var movies = List.of(
                new Movie("a",10),
                new Movie("b",20),
                new Movie("c",30)

        );

        Predicate<Movie> isPopular= m->m.getLikes()>10;
        //Maps and filters return a new stream
        //filter method takes a predicate function
        var movieStream = movies.stream()
                .filter(isPopular);
        movieStream.forEach(m-> System.out.println(m.getName()));
    }
    public static void _listOf(){
        var myStream=Stream.of(List.of(3,4,5),List.of(2,3,4));
        myStream
                .flatMap(list->list.stream())
                .map(n->n*2)
                .forEach(System.out::println);
    }
}
