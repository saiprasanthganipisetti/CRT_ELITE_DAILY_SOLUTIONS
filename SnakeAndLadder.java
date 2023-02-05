import java.util.*;

// import javax.print.attribute.standard.NumberOfDocuments;



public class SnakeAndLadder{
    public static void main(String[] args) {
        Dice dice = new Dice(1);
        Player p1 = new Player("Ramesh",1);
        Player p2 = new Player("Suresh",2);
        Player p3 = new Player("Hero",3);
        Queue<Player> allPlayers = new LinkedList<>();
        allPlayers.offer(p1);
        allPlayers.offer(p2);
        allPlayers.offer(p3);
        System.out.println(p1.getPlayerName()+" "+p2.getPlayerName());
        Jumper snake1 = new Jumper(10,2);
        Jumper snake2 = new Jumper(99,12);
        System.out.println(snake1.startPoint+" "+snake2.endPoint);
        List<Jumper> snakes = new ArrayList<>();
        snakes.add(snake1);
        snakes.add(snake2);
        System.out.println(snakes);
        Jumper ladder1 = new Jumper(0,25);
        Jumper ladder2 = new Jumper(40,89);
        System.out.println(ladder1.startPoint+" "+ladder2.endPoint);
        List<Jumper> ladders = new ArrayList<>();
        ladders.add(ladder1);
        ladders.add(ladder2);
        System.out.println(ladders);
        Map<String, Integer> playerCurrentPosition = new HashMap<>();
        playerCurrentPosition.put("Ramesh",0);
        playerCurrentPosition.put("Suresh",0);
        playerCurrentPosition.put("Hero",0);
        int boardSize = 100;
        System.out.println(playerCurrentPosition);
        System.out.println("Parameters passing for Board class:");
        System.out.println("dice: "+dice);
        System.out.println("allPlayers: "+allPlayers);
        System.out.println("snakes: "+snakes);
        System.out.println("ladders: "+ladders);
        System.out.println("playerCurrentPosition: "+playerCurrentPosition);
        System.out.println("boardSize: "+boardSize);
        System.out.println("Going to Board class");
        Board gb = new Board(dice, allPlayers, snakes, ladders, playerCurrentPosition, boardSize);
        gb.startGame();

    }
}