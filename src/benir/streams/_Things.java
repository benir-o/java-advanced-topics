package benir.streams;

import java.util.Comparator;
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


        _Things.reducers();
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
    public static void streamSlice(){
        var movies = List.of(
                new Movie("a",10),
                new Movie("b",20),
                new Movie("c",30)

        );
        //100 movies
        //10 movies per page
        //3rd page
        //skip 20 movies to get to the third page.
        // position-> (page-1)* pageSize=10;
        //position-> limit(10).... for (i in range(10))|->print (movie.getName())
        movies
                .stream()
                .limit(2)
                .forEach(m-> System.out.println(m.getName()));
    }
    public static void streamSort(){
        var movies = List.of(
                new Movie("b",10),
                new Movie("a",20),
                new Movie("c",30)

        );
        movies.stream()
                .sorted(Comparator.comparing(Movie::getName).reversed())
                .forEach(n-> System.out.println(n.getName()));
    }
    public static void uniqueElements(){
        var movies = List.of(
                new Movie("a",10),
                new Movie("a",10),
                new Movie("b",30),
                new Movie("c",10)

                //Display the price of the movie: likes are taken as the price

        );
        movies
                .stream()
                .map(Movie::getLikes)
                .distinct()//removes duplicate values
                .forEach(System.out::println);
    }
    public static void peekElements(){
        var movies = List.of(
                new Movie("a",10),
                new Movie("b",20),
                new Movie("c",30)

        );
        movies
                .stream()
                .filter(m->m.getLikes()>10)
                .peek(m-> System.out.println("filtered: "+m.getName()))
                .map(Movie::getName)
                .peek(t-> System.out.println("mapped: "+ t))
                .forEach(System.out::println);
    }
    public static void reducers(){
        var movies = List.of(
                new Movie("a",10),
                new Movie("b",20),
                new Movie("c",30)
        );
        var result=movies.stream().findFirst().get();
        System.out.println(result.getName());

        var max=movies
                .stream()
                .max(Comparator.comparing(Movie::getLikes))
                .get();
        System.out.println(max.getName());
        Predicate<Movie> greaterThan20= m->m.getLikes()>20;
        var min= movies
                .stream()
                .min(Comparator.comparing(Movie::getLikes))
                .get();
        System.out.println(min.getName());
        var anyMatch= movies
                .stream()
                .anyMatch(greaterThan20);

        var allMatch= movies
                .stream()
                .allMatch(greaterThan20);// Terminal operation

        var noneMatch= movies
                .stream()
                .noneMatch(greaterThan20);

        //You can test this out using the print method
    }


}
