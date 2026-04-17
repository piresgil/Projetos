/*
 * @ Daniel Gil
 */

package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import entities.Comment;
import entities.Post;

public class App {
    /*
     * 
     */
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        // p1.setTitle("Traveling to New Zealand");
        // p1.setLikes(12);
        // p1.setMoment(sdf.parse("21/06/2018 13:05:44")); // usar exepsion throws
        // p1.setContent("I'm going to visit this wonderful country!");

        /* passando directamente no construtor */
        Post p1 = new Post(sdf.parse("21/06/2018 13:05:44"),
                "Traveling to New Zealand",
                "I'm going to visit this wonderful country!",
                12);

        Comment c1 = new Comment();
        c1.setText("Have a nice trip!");
        Comment c2 = new Comment();
        c2.setText("Wow that's awesome!");

        p1.addComment(c1);
        p1.addComment(c2);

        // p2.setTitle("Good night guys");
        // p2.setLikes(5);
        // p2.setMoment(sdf.parse("28/07/2018 23:14:19")); // usar exepsion throws
        // p2.setContent("See you tomorrow");

        /* passando directamente no construtor */
        Post p2 = new Post(sdf.parse("28/07/2018 23:14:19"),
                "Good night guys",
                "See you tomorrow",
                12);

        Comment c3 = new Comment();
        c3.setText("Good night!");
        Comment c4 = new Comment();
        c4.setText("May the Force be with you!");

        p2.addComment(c3);
        p2.addComment(c4);

        System.out.println("________________________StringBuilder Post1________________________");

        // com o metodo tostring com STRINGBUILDER
        System.out.println(p1);

        //// System.out.println(p1.getTitle());
        //// System.out.print(p1.getLikes() + " Likes ");
        //// System.out.println(p1.getMoment());
        //// System.out.println(p1.getContent());
        //// System.out.println("Comments:");
        //// for (Comment c : p1.getComments()) {
        //// System.out.println(c);
        //// }
        System.out.println("________________________StringBuilder Post2________________________");

        // com o metodo tostring com STRINGBUILDER
        System.out.println(p2);
        // System.out.println(p2.getTitle());
        // System.out.print(p2.getLikes() + " Likes ");
        // System.out.println(p2.getMoment());
        // System.out.println(p2.getContent());
        // System.out.println("Comments:");
        // for (Comment c : p2.getComments()) {
        // System.out.println(c);
        // }

    }
}
