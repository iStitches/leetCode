package Sunday;

public class Game1 {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int max_index=0;
        int max_time=releaseTimes[0];
        for(int i=1;i<releaseTimes.length;i++){
        	int temp=releaseTimes[i]-releaseTimes[i-1];
            if(max_time<temp) {
            	max_index=i;
            	max_time=temp;
            }
            else if(max_time==temp)
                max_index=keysPressed.charAt(max_index)>keysPressed.charAt(i)?max_index:i;
        }
      return keysPressed.charAt(max_index);
  }
    
    public static void main(String[] args) {
    	Game1 t=new Game1();
    	int []times= {9,29,49,50};
    	String keys="cbcd";
    	t.slowestKey(times, keys);
	}
}
