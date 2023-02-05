
  
// import lombok.EqualsAndHashCode;
// import lombok.Getter;
// import lombok.Setter;

// @Setter
// @Getter
// @EqualsAndHashCode


public class Player {
    String playerName;
    int id;

    Player(String playerName, int id){
        this.playerName = playerName;
        this.id = id;
    }
    String getPlayerName(){
        return playerName;
    }
}
