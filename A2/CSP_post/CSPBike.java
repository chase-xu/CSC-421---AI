import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CSPBike extends CSP {
    static Set<Object> varCol = new HashSet<Object>(Arrays.asList(new String[] {"black", "blue", "green", "red", "white"}));
	static Set<Object> varSand = new HashSet<Object>(Arrays.asList(new String[] {"bacon", "chicken", "cheese", "pepperoni", "tuna"}));
	static Set<Object> varName = new HashSet<Object>(Arrays.asList(new String[] {"Adrian", "Charles", "Henry", "Joel", "Richard"}));
	static Set<Object> varJuice = new HashSet<Object>(Arrays.asList(new String[] {"apple", "cranberry", "grapefruit", "orange", "pineapple"}));
    static Set<Object> varAge = new HashSet<Object>(Arrays.asList(new String[] {"12", "13", "14", "15", "16"}));
    static Set<Object> varSport = new HashSet<Object>(Arrays.asList(new String[] {"baseball", "basketball", "hockey", "soccer", "swimming"}));

	
	public boolean isGood(Object X, Object Y, Object x, Object y) {
		//if X is not even mentioned in by the constraints, just return true
		//as nothing can be violated
		if(!C.containsKey(X))
			return true;
		
		//check to see if there is an arc between X and Y
		//if there isn't an arc, then no constraint, i.e. it is good
		if(!C.get(X).contains(Y))
			return true;
        
        //Henry is exactly to the left of the Soccer fan.
        if(X.equals("Henry") && Y.equals("soccer") && (Integer)y - (Integer)x != 1)
            return false;
        //The boy who is going to drink Grapefruit juice is somewhere between who brought Tuna sandwich and who brought Pineapple juice, in that order.
        if(X.equals("grapefruit") && Y.equals("tuna") && (Integer)x < (Integer)y)
            return false;
        if(X.equals("grapefruit") && Y.equals("pineapple") && (Integer)x > (Integer)y)
            return false;
        if(X.equals("tuna") && Y.equals("pinapple") && (Integer)x > (Integer)y)
            return false;
        
        //The owner of the White bike is somewhere between the 15-year-old boy and the youngest boy, in that order.
		if(X.equals("white") && Y.equals("15") && (Integer)x < (Integer)y)
            return false;
        if(X.equals("white") && Y.equals("12") && (Integer)x > (Integer)y)
            return false;
        if(X.equals("15") && Y.equals("12") && (Integer)x > (Integer)y)
            return false;
        //The one who likes Swimming is next to the friend who likes Baseball.
        if(X.equals("swimming") && Y.equals("baseball") && Math.abs((Integer)x - (Integer)y) != 1)
            return false;
        
		//The cyclist that brought Pineapple juice is somewhere between the 14-year-old and the boy that brought Orange juice, in that order.
        if(X.equals("pineapple") && Y.equals("14") && (Integer)x < (Integer)y)
            return false;
        if(X.equals("pineapple") && Y.equals("orange") && (Integer)x > (Integer)y)
            return false;
        if(X.equals("14") && Y.equals("orange") && (Integer)x > (Integer)y)
            return false;

        //The boy who likes the sport played on ice is going to eat Pepperoni sandwich.
        if(X.equals("hockey") && Y.equals("pepperoni") && !x.equals(y))
            return false;

        //The boy riding the White bike is somewhere between the boys riding the blue and the black bicycles, in that order.
        if(X.equals("white") && Y.equals("blue") && (Integer)x < (Integer)y)
            return false;
        if(X.equals("white") && Y.equals("black") && (Integer)x > (Integer)y)
            return false;
        if(X.equals("blue") && Y.equals("black") && (Integer)x > (Integer)y)
            return false;
        //Joel is next to the 16-year-old cyclist.
        if(X.equals("Joel") && Y.equals("16") && Math.abs((Integer)x - (Integer)y)!= 1)
            return false;

        //Adrian is exactly to the left of the boy who is going to eat Pepperoni sandwich.
        if(X.equals("Adrian") && Y.equals("pepperoni") && (Integer)y - (Integer)x != 1)
            return false;


        //The 12-year-old is somewhere between the 14-year-old and the oldest boy, in that order.
        if(X.equals("12") && Y.equals("14") && (Integer)x < (Integer)y)
            return false;
        if(X.equals("12") && Y.equals("16") && (Integer)x > (Integer)y)
            return false;
        if(X.equals("14") && Y.equals("16") && (Integer)x > (Integer)y)
            return false;
        //The boy who is going to eat Bacon sandwich is somewhere to the right of the owner of the White bicycle.
        if(X.equals("bacon") && Y.equals("white") && (Integer)x - (Integer)y != 1)
            return false;

        //The 16-year-old brought Cheese sandwich.
        if(X.equals("16") && Y.equals("cheese") && !x.equals(y))
            return false;


        //The cyclist riding the White bike is somewhere between Richard and the boy riding the Red bike, in that order.
        if(X.equals("white") && Y.equals("Richard") && (Integer)x < (Integer)y)
            return false;
        if(X.equals("white") && Y.equals("red") && (Integer)x > (Integer)y)
            return false;
        if(X.equals("Richard") && Y.equals("red") && (Integer)x > (Integer)y)
            return false;


        //The Baseball fan is next to the boy who is going to drink Apple juice.
        if(X.equals("baseball") && Y.equals("apple") && Math.abs((Integer)x - (Integer)y )!= 1)
            return false;

        //Charles is somewhere between Richard and Adrian, in that order.
        if(X.equals("Charles") && Y.equals("Richard") && (Integer)x < (Integer)y)
            return false;
        if(X.equals("Charles") && Y.equals("Adrian") && (Integer)x > (Integer)y)
            return false;
        if(X.equals("Richard") && Y.equals("Adrian") && (Integer)x > (Integer)y)
            return false;

		//Uniqueness constraints
		if(varCol.contains(X) && varCol.contains(Y) && !X.equals(Y) && x.equals(y))
			return false;
		
		if(varName.contains(X) && varName.contains(Y) && !X.equals(Y) && x.equals(y))
			return false;
		
		if(varSand.contains(X) && varSand.contains(Y) && !X.equals(Y) && x.equals(y))
			return false;
		
		if(varSport.contains(X) && varSport.contains(Y) && !X.equals(Y) && x.equals(y))
			return false;
		
		if(varAge.contains(X) && varAge.contains(Y) && !X.equals(Y) && x.equals(y))
            return false;
        if(varJuice.contains(X) && varJuice.contains(Y) && !X.equals(Y) && x.equals(y))
			return false;

		
		return true;
	}
		
	public static void main(String[] args) throws Exception {
		CSPBike csp = new CSPBike();
		
		Integer[] boy = {1,2,3,4,5};
		
		for(Object X : varCol) 
			csp.addDomain(X, boy);
		
		for(Object X : varName) 
			csp.addDomain(X, boy);
		
		for(Object X : varSand) 
			csp.addDomain(X, boy);
		
		for(Object X : varJuice) 
			csp.addDomain(X, boy);
		
		for(Object X : varAge) 
			csp.addDomain(X, boy);
        
        for(Object X : varSport) 
			csp.addDomain(X, boy);
		
		//unary constraints: just remove values from domains
        //In the middle is the boy that likes Baseball.
        for(int i = 1; i<=5; i++){
            if(i != 3)
                csp.D.get("baseball").remove(i);
        }
        //The cyclist who is going to eat Tuna sandwich is at one of the ends.
        for(int i = 1; i<=5; i++){
            if(i != 5 && i != 1)
                csp.D.get("tuna").remove(i);
        }

        //The boy that is going to drink Pineapple juice is at the fourth position.
        for(int i = 1; i<=5; i++){
            if(i != 4)
                csp.D.get("pineapple").remove(i);
        }

        //The boy riding the Black bike is at the third position.
        for(int i = 1; i<=5; i++){
            if(i != 3)
                csp.D.get("black").remove(i);
        }

        //In one of the ends is the boy riding the Green bicycle.
        for(int i = 1; i<=5; i++){
            if(i != 1 && i !=5)
                csp.D.get("green").remove(i);
        }
        //In the fifth position is the 13-year-old boy.
        for(int i = 1; i<=5; i++){
            if(i !=5)
                csp.D.get("13").remove(i);
        }

        //The boy who likes Hockey is at the fifth position.
        for(int i = 1; i<=5; i++){
            if(i !=5)
                csp.D.get("hockey").remove(i);
        }

		//binary constraints: add constraint arcs
        //Henry is exactly to the left of the Soccer fan.
        csp.addBidirectionalArc("Henry", "soccer");		
        //The owner of the White bike is somewhere between the 15-year-old boy and the youngest boy, in that order.
        csp.addBidirectionalArc("white", "15");		
        csp.addBidirectionalArc("white", "12");	
        csp.addBidirectionalArc("15", "12");	

        //The boy who is going to drink Grapefruit juice is somewhere between who brought Tuna sandwich and who brought Pineapple juice, in that order.
        csp.addBidirectionalArc("grapefruit", "tuna");		
        csp.addBidirectionalArc("grapefruit", "pineapple");	
        csp.addBidirectionalArc("tuna", "pineapple");		
        //The one who likes Swimming is next to the friend who likes Baseball.
		csp.addBidirectionalArc("swimming", "baseball");		
        //The boy who likes the sport played on ice is going to eat Pepperoni sandwich.
        csp.addBidirectionalArc("hockey", "pepperoni");		

        //The boy riding the White bike is somewhere between the boys riding the blue and the black bicycles, in that order.
        csp.addBidirectionalArc("white", "blue");		
        csp.addBidirectionalArc("white", "black");
        csp.addBidirectionalArc("blue", "black");	
        //Joel is next to the 16-year-old cyclist.
        csp.addBidirectionalArc("Joel", "16");
        //Adrian is exactly to the left of the boy who is going to eat Pepperoni sandwich.
        csp.addBidirectionalArc("Adrian", "pepperoni");

        //The boy who is going to eat Bacon sandwich is somewhere to the right of the owner of the White bicycle.
        csp.addBidirectionalArc("bacon", "white");
        //The 12-year-old is somewhere between the 14-year-old and the oldest boy, in that order.

        //The 16-year-old brought Cheese sandwich.
        csp.addBidirectionalArc("16", "cheese");

        //The cyclist riding the White bike is somewhere between Richard and the boy riding the Red bike, in that order.
        csp.addBidirectionalArc("white", "Richard");
        csp.addBidirectionalArc("white", "red");
        csp.addBidirectionalArc("Richard", "red");	

        //The Baseball fan is next to the boy who is going to drink Apple juice.
        csp.addBidirectionalArc("baseball", "apple");

        //Charles is somewhere between Richard and Adrian, in that order.
        csp.addBidirectionalArc("Charles", "Adrian");
        csp.addBidirectionalArc("Charles", "Richard");
        csp.addBidirectionalArc("Adrian", "Richard");	

		//Uniqueness constraints
		for(Object X : varCol)
			for(Object Y : varCol)
				csp.addBidirectionalArc(X,Y);
		
		for(Object X : varName)
			for(Object Y : varName)
				csp.addBidirectionalArc(X,Y);

		for(Object X : varSand)
			for(Object Y : varSand)
				csp.addBidirectionalArc(X,Y);

		for(Object X : varJuice)
			for(Object Y : varJuice)
				csp.addBidirectionalArc(X,Y);

		for(Object X : varAge)
			for(Object Y : varAge)
                csp.addBidirectionalArc(X,Y);
                
        for(Object X : varSport)
            for(Object Y : varSport)
                csp.addBidirectionalArc(X,Y);

		//Now let's search for solution 
		Search search = new Search(csp);
		System.out.println(search.BacktrackingSearch());
	}
}
