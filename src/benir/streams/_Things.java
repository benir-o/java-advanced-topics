package benir.streams;

import java.util.*;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.IntStream;

public class _Things {
    public static void main(String[] args) {
        var movies = List.of(
                new Movie("a",10, Genre.THRILLER),
                new Movie("b",20, Genre.ACTION),
                new Movie("c",30, Genre.ACTION)

        );
//        movies
//                .stream()
//                .map(movie->movie.getName())
//                .forEach(name-> System.out.println(name));


//        _Things.primitiveStreams();
//        _Things.show();
//        _Things.filter();
//        _Things._listOf();
//        _Things.streamSlice();
//        _Things.streamSort();
//        _Things.peekElements();
//        _Things.uniqueElements();
//        _Things.groupGenres();
        _Things.partition();
//        _Things._Collectors();
//        _Things.reducers();
    }
    static class Movie implements Comparable<Movie>{
        private String name;
        private int likes;
        private Genre genre;

        public Movie(String name, int likes, Genre genre) {
            this.name = name;
            this.likes = likes;
            this.genre = genre;
        }
        public Movie(String name,int likes){
            this.name=name;
            this.likes=likes;
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
        @Override
        public String toString(){
            return name;
        }

        @Override
        public int compareTo(Movie o) {
            return likes-o.getLikes();
        }

        public Genre getGenre() {
            return genre;
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
                new Movie("a",10, Genre.THRILLER),
                new Movie("b",20, Genre.ACTION),
                new Movie("c",30, Genre.ACTION)

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
                new Movie("a",10, Genre.THRILLER),
                new Movie("b",20, Genre.ACTION),
                new Movie("c",30, Genre.ACTION)

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
                new Movie("a",10, Genre.THRILLER),
                new Movie("b",20, Genre.ACTION),
                new Movie("c",30, Genre.ACTION)

        );
        movies.stream()
                .sorted(Comparator.comparing(Movie::getName).reversed())
                .forEach(n-> System.out.println(n.getName()));
    }
    public static void uniqueElements(){
        var movies = List.of(
                new Movie("a",10, Genre.THRILLER),
                new Movie("b",20, Genre.ACTION),
                new Movie("c",30, Genre.ACTION)

        );

                //Display the price of the movie: likes are taken as the price
        movies
                .stream()
                .map(Movie::getLikes)
                .distinct()//removes duplicate values
                .forEach(System.out::println);
    }
    public static void peekElements(){
        var movies = List.of(
                new Movie("a",10, Genre.THRILLER),
                new Movie("b",20, Genre.ACTION),
                new Movie("c",30, Genre.ACTION)

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
                new Movie("a",10, Genre.THRILLER),
                new Movie("b",20, Genre.ACTION),
                new Movie("c",30, Genre.ACTION)

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
    public static void generalPurposeReduction(){
        var movies = List.of(
                new Movie("a",10, Genre.THRILLER),
                new Movie("b",20, Genre.ACTION),
                new Movie("c",30, Genre.ACTION)

        );
        //[10,20,30]
        //[30,30]
        //[60]
        //Accumulator accumulates values
        //Reduce returns an optional

        //The integer class has a static method called sum
        //Hence we can use it for method referencing
        //instead of (a,b)->(a+b) we initiate method referencing
        //After changing the identity of the reduce method, it then returns an integer object as seen
        var sum= movies
                .stream()
                .map(m->m.getLikes())
                .reduce(0,Integer::sum);

        //The get method may throw an exception in the case that we receive an empty stream
        //To avoid this, we use the orElse method.
        //We print it in case we change the identity of the reduce method
        System.out.println(sum);
    }

    public static void _Collectors(){
        var movies = List.of(
                new Movie("a",10, Genre.THRILLER),
                new Movie("b",20, Genre.ACTION),
                new Movie("c",30, Genre.ACTION)

        );
        //Here we would like to collect the movie likes into a data structure
        var myList=movies
                .stream()
                .filter(m->m.getLikes()>10)
                .map(Movie::getName)
                .collect(Collectors.toList());

        var mySet=movies.stream()
                .filter(m->m.getLikes()>10)
                .map(m->m.getName())
                .collect(Collectors.toSet());

        //How do we sort elements into a HashMap
        //m->m.getName, m->m.getTitle

        var myMap= movies
                .stream()
                .filter(m->m.getLikes()>10)
                .collect(Collectors.toMap(Movie::getName, Function.identity()));
        System.out.println(mySet);
        System.out.println(myMap);
        System.out.println(myList);
        //Functional Interfaces have identity
        //Function.identity() : Takes a value and returns the memory address of an object
        //What if we want to add a bunch of integer values?

        var intSum= movies
                .stream()
                .filter(m->m.getLikes()>10)
                .collect(Collectors.summingInt(Movie::getLikes));

        System.out.println(intSum);

        /*
        What is the summarize method used for?
        It gives statistics on class objects that we use
         */

        //We would like to obtain details of the stream we are working with
        var statistics=movies
                .stream()
                .filter(m->m.getLikes()>10)
                .collect(Collectors.summarizingInt(Movie::getLikes));

        System.out.println(statistics);
    }
    public static void groupGenres(){
        var movies = List.of(
                new Movie("a",10, Genre.THRILLER),
                new Movie("b",20, Genre.ACTION),
                new Movie("c",30, Genre.ACTION)

        );
        var result=movies
                .stream()
                .collect(Collectors.groupingBy(Movie::getGenre));

//                        Collectors.mapping(
//                                Movie::getName,
//                                Collectors.toList())));
        System.out.println(result);

        var collectToSet=movies
                .stream()
                .collect(Collectors.groupingBy(Movie::getGenre,Collectors.mapping(Movie::getName,Collectors.joining(","))));
        System.out.println(collectToSet);

    }
    public static void partition(){
        var movies = List.of(
                new Movie("a",10, Genre.THRILLER),
                new Movie("b",20, Genre.ACTION),
                new Movie("c",30, Genre.ACTION)

        );
        var result1=movies.stream()
                .collect(Collectors.groupingBy(Movie::getGenre,
                        Collectors.mapping(Movie::getName,
                                Collectors.joining(","))));
        System.out.println(result1);

        var mapOfBoolToListOfMovies=movies
                .stream()
                .collect(Collectors.partitioningBy(m->m.getLikes()>20,
                        Collectors.mapping(Movie::getName, Collectors.joining(","))));
        System.out.println(mapOfBoolToListOfMovies);

    }
    public static void primitiveStreams(){
        IntStream.rangeClosed(1,5).forEach(System.out::println);
    }


}
