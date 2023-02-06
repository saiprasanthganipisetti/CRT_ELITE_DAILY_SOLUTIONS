import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.LinkedList;
import java.util.*;

public class Board {
    private Dice dice;
    private Queue<Player> nextTurn;
    private List<Jumper> snakes;
    private List<Jumper> ladders;
    private Map<String,Integer> playerCurrentPosition;
    int boardSize;
    Queue<String> report = new LinkedList<>(); //TO STORE THE WINNER IN ORDER OF COMPLETION
    Scanner sc = new Scanner(System.in);
    Board(Dice dice, Queue<Player> nextTurn, List<Jumper> snakes, List<Jumper> ladders, Map<String,Integer> playerCurrentPosition, int boardSize){
        this.dice = dice;
        this.nextTurn = nextTurn;
        this.snakes = snakes;
        this.ladders = ladders;
        this.playerCurrentPosition = playerCurrentPosition;
        this.boardSize = boardSize;
    }

    void startGame(){
        //GAME CONTINUES TILL THERE REMAINS ONLY ONE PLAYER IN THE GAME
        while(nextTurn.size() > 1){

            Player player = nextTurn.poll();
            
            String name = player.getPlayerName();
            
            System.out.println("current player name : "+name);
            
            int currentPosition = playerCurrentPosition.get(name);
            
            System.out.println("current player position "+playerCurrentPosition.get(name));
            
            System.out.println("Ready to roll ?");

            sc.nextLine(); 

            int diceValue = dice.rollDice();
            
            System.out.println();
            System.out.println("Dice value for "+name+" is "+diceValue);
            
            int nextCell = currentPosition + diceValue;

            int[] nextPosition = new int[1];

            if(nextCell < boardSize){
                
                boolean[] b = new boolean[1];
                nextPosition[0] = nextCell;
                b[0] = false;
                //CHECKING  IF THERE IS A SNAKE AT THE CURRENT POSITION
                snakes.forEach(v->{
                    if(v.startPoint == nextCell){
                        nextPosition[0] = v.endPoint;
                    }
                });
                
                if(nextPosition[0] != nextCell){
                    System.out.println();
                    System.out.println("!!!!!!!!!!!!!! "+ name  +" moved to "+nextCell+ " and bitten by a snake"+ " !!!!!!!!!!!!!! ");
                    System.out.println();
                }
                //CHECKING  IF THERE IS A LADDER AT THE CURRENT POSITION
                ladders.forEach(v->{
                    if(v.startPoint == nextCell){
                        nextPosition[0] = v.endPoint;
                        b[0] = true;
                    }
                });

                if(nextPosition[0] != nextCell && b[0]){
                    System.out.println();
                    System.out.println("!!!!!!!!!!!!!! "+name +" moved to "+nextCell +" and climbed a ladder at position "+ nextCell+" !!!!!!!!!!!!!! ");
                    System.out.println();
                }

                //UPDATING THE POSITION OF THE PLAYER
                playerCurrentPosition.put(name,nextPosition[0]);
                System.out.println();
                System.out.println("=== "+name + " moved to "+ nextPosition[0]+" ===");
                System.out.println();
                nextTurn.offer(player);
            }

            else if(nextCell == boardSize){
                System.out.println(name+" reached "+boardSize);
                System.out.println("@@@@@@@@@ "+ name + " finished the game @@@@@@@@@");
                System.out.println();
                report.offer(name);
            }
            //IF THE PLAYER'S POSITION PLUS DICE VALUE EXCEEDS BOARDSIZE, NO UPDATION OF THE POSITION
            else{
                System.out.println(name+" couldn't move forward");
                System.out.println();
                System.out.println("=== "+name + " is at "+currentPosition+" ===");
                System.out.println();
                nextTurn.offer(player);

            }
        }    
        report.offer(nextTurn.poll().getPlayerName());
    }


    void showResults(){
        int i = 1;
        System.out.println("Player Name       Rank");
        while( !report.isEmpty()){
            System.out.println("    "+report.poll()+"              "+ i);
            i++;
        }
    }
}