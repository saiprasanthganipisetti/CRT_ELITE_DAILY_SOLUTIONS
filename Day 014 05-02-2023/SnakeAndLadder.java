import java.net.SocketPermission;
import java.util.*;


public class SnakeAndLadder{
    public static void main(String[] args) {

        System.out.println("Enter number of Dice :");
        
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        Dice dice = new Dice(n);        
        
        System.out.println("Enter number of players(>1) :");
        
        int noOfPlayers = sc.nextInt();
        
        ArrayList<Player>initPlayers = new ArrayList<>();    //PLAYERS LIST
        
        //READING PLAYER NAMES
        for(int i = 0; i < noOfPlayers; i++){
            System.out.println("Enter the name of Player - "+(i+1)+" name : ");
            String name = sc.next();
            initPlayers.add(new Player(name, i + 1));
        }

        System.out.println("Players and their ids are:");
        for(int i = 0; i < noOfPlayers; i++)
            System.out.println(initPlayers.get(i).playerName+" "+initPlayers.get(i).id);
        
        Queue<Player> allPlayers = new LinkedList<>();
        for(int i = 0; i < noOfPlayers; i++)
            allPlayers.offer(initPlayers.get(i));
        System.out.println("Enter the boardsize : ");
        int boardSize = sc.nextInt();

        //SETTING UP SNAKES
        Jumper snake1 = new Jumper(boardSize - 1, boardSize-10);
        Jumper snake2 = new Jumper(boardSize/2,(int)boardSize/4);
        Jumper snake3 = new Jumper(boardSize/5, 3);
        List<Jumper> snakes = new ArrayList<>();
        snakes.add(snake1);
        snakes.add(snake2);
        snakes.add(snake3);
     
        //SETTING UP LADDERS
        Jumper ladder1 = new Jumper(2,boardSize/3);
        Jumper ladder2 = new Jumper(boardSize/6,boardSize/5);
        Jumper ladder3 = new Jumper(41,boardSize-3);
        List<Jumper> ladders = new ArrayList<>();
        ladders.add(ladder1);
        ladders.add(ladder2);
        ladders.add(ladder3);
        System.out.println("ladders and snakes");
        System.out.println(ladder1.startPoint+" "+ladder1.endPoint);
        System.out.println(ladder2.startPoint+" "+ladder2.endPoint);
        System.out.println(ladder3.startPoint+" "+ladder3.endPoint);
        System.out.println(snake1.startPoint+" "+snake1.endPoint);
        System.out.println(snake2.startPoint+" "+snake2.endPoint);
        System.out.println(snake3.startPoint+" "+snake3.endPoint);
        //PLAYERS AND THEIR POSITIONS ARE STORED IN THIS HASHMAP
        Map<String, Integer> playerCurrentPosition = new HashMap<>();
        for(int i = 0; i < noOfPlayers; i++){
            playerCurrentPosition.put(initPlayers.get(i).playerName,0);
        }
        
        

        Board gb = new Board(dice, allPlayers, snakes, ladders, playerCurrentPosition, boardSize);
        gb.startGame();
        //FOR FINAL RESULTS
        gb.showResults();
    }
}