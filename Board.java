

import java.util.List;
import java.util.Map;
import java.util.Queue;


public class Board {
    Dice dice;
    Queue<Player> nextTurn;
    private List<Jumper> snakes;
    private List<Jumper> ladders;
    private Map<String,Integer> playerCurrentPosition;
    int boardSize;

    Board(Dice dice, Queue<Player> nextTurn, List<Jumper> snakes, List<Jumper> ladders, Map<String,Integer> playerCurrentPosition, int boardSize){
        System.out.println("Reached Board Class");
        this.dice = dice;
        this.nextTurn = nextTurn;
        this.snakes = snakes;
        this.ladders = ladders;
        this.playerCurrentPosition = playerCurrentPosition;
        this.boardSize = boardSize;
        System.out.println("Parameters received at Board Class:");
        System.out.println("dice: "+dice);
        System.out.println("allPlayers: "+nextTurn);
        System.out.println("snakes: "+snakes);
        System.out.println("ladders: "+ladders);
        System.out.println("playerCurrentPosition: "+playerCurrentPosition);
        System.out.println("boardSize: "+boardSize);
    }

    void startGame(){
        System.out.println("Entered startGame()");
        System.out.println("Size of nextTurn(no of players in queue): "+nextTurn.size());
        while(nextTurn.size() > 1){
            Player player = nextTurn.poll();
            String name = player.getPlayerName();
            System.out.println("current player name "+name);
            int currentPosition = playerCurrentPosition.get(name);
            System.out.println("current player position "+playerCurrentPosition.get(name));
            int diceValue = dice.rollDice();
            System.out.println("Dice value for "+name+" is "+diceValue);
            int nextCell = currentPosition + diceValue;
            System.out.println("nextcell : "+nextCell);


            if(nextCell < boardSize){
                int[] nextPosition = new int[1];
                boolean[] b = new boolean[1];
                nextPosition[0] = nextCell;
                b[0] = false;
                snakes.forEach(v->{
                    if(v.startPoint == nextCell){
                        nextPosition[0] = v.endPoint;
                    }
                });

                if(nextPosition[0] != nextCell){
                    System.out.println("!!!!!!!!!!!!!! "+player.getPlayerName()  + " is bitten by a snake at position "+ nextCell+" !!!!!!!!!!!!!! ");
                }

                ladders.forEach(v->{
                    if(v.startPoint == nextCell){
                        nextPosition[0] = v.endPoint;
                        b[0] = true;
                    }
                });

                if(nextPosition[0] != nextCell && b[0]){
                    System.out.println("!!!!!!!!!!!!!! "+player.getPlayerName() + " got a ladder at position "+ nextCell+" !!!!!!!!!!!!!! ");
                }
                playerCurrentPosition.put(player.getPlayerName(),nextPosition[0]);
                System.out.println(player.getPlayerName() + " is at position "+ nextPosition[0]);
                nextTurn.offer(player);
            }

            else if(nextCell == boardSize){
                System.out.println(player.getPlayerName() + " finished the game");
            }

            else{
                nextTurn.offer(player);
            }
        }    
    }
}
