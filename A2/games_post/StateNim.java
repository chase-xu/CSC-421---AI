
public class StateNim extends State {
    
    public char coins[] = new char[13];
    public int coinsLeft;
    public StateNim() {
        for (int i=0; i<13; i++) 
            coins[i] = '0';
        
        player = 1;
        coinsLeft = 13;
    }
    
    public StateNim(StateNim state) {
        player = state.player;
        coinsLeft = state.coinsLeft;
        for(int i=0; i<coinsLeft; i++)
            this.coins[i] = state.coins[i]; 
        
    }
    
    public String toString() {
    	
    	String ret = "";
    	
    	for(int i=0; i<coinsLeft; i++) {
            ret += coins[i];
    		// ret += "\n";
    	}
    	return ret;
    }
}
