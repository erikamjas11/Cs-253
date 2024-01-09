import java.util.Scanner;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.imageio.ImageIO;

public class Main {

    public static void main(String[] args) {
        System.out.println("***Maze runner mini game***");
        System.out.println("Game Rules: select a path that you think is the shortest to the exit ");
        System.out.println("Select a path and input its coresponding number (0-5)");
        System.out.println("Red path enter 0");
        System.out.println("Black path enter 1");
        System.out.println("Green path enter 2");
        System.out.println("Black path 1 to 2 enter 3");
        System.out.println("Black path 16 to 12 enter 4");
        System.out.println("Yellow path enter 5");
        
        
        JFrame frame = new JFrame();
        ImageIcon icon = new ImageIcon("maze-graph.png");
        JLabel label = new JLabel(icon);
        frame.add(label);
        frame.setDefaultCloseOperation
        (JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter the path you think is the shortest");

        int userPath = myObj.nextInt();  // Read user input
        System.out.println("User Path: " + userPath);  // Out

        Graph Maze = new Graph(18);
        
        

        Maze.makeEdge(0, 1, 1);
        Maze.makeEdge(0, 11, 1);
        Maze.makeEdge(1, 2, 1);
        Maze.makeEdge(1, 3, 1);
        Maze.makeEdge(3, 4, 1);
        Maze.makeEdge(3, 10, 1);
        Maze.makeEdge(4, 5, 1);
        Maze.makeEdge(4, 6, 1);
        Maze.makeEdge(6, 7, 1);
        Maze.makeEdge(6, 8, 1);
        Maze.makeEdge(8, 9, 1);
        Maze.makeEdge(8, 10, 1);
        Maze.makeEdge(10, 11, 1);
        Maze.makeEdge(11, 12, 1);
        Maze.makeEdge(12, 13, 1);
        Maze.makeEdge(13, 14, 1);
        Maze.makeEdge(13, 15, 1);
        Maze.makeEdge(15, 17, 1);
        Maze.makeEdge(15, 16, 1);
        
        

        System.out.println("Best path:");
        for (Integer vertice : Maze.path(0, 12)) {
            System.out.print((vertice) + " -> ");        }
        
        int correct_path = 2;
        if (userPath == correct_path){
        System.out.println("You win");
        }else{
        System.out.println("You lose" );
        
        }
    }
}
