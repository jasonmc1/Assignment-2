  import java.util.Scanner;
  import java.util.LinkedList;
  import java.io.PrintWriter;
  import java.io.File;
  import java.util.Collections;
  import java.util.Queue;

 class Song {
    //instantiates limited array, with 10 elements being up to change
    public Song(String name, String[] line){
        this.name = name;
        line = new String[]{"", "", "", "", "", "", "", "", "", ""};
        
    }
    
    public Song(){
        name = "";
        line = new String[]{"", "", "", "", "", "", "", "", "", ""};
    }
    
    public boolean isEqual(Song other){
        return name.equals(other.name);
    }
    
    //returns name of a line if needed by itself
    public String getName(){
        return name;
    }
    
    //returns list with names
    public Queue<String> getList(){
        return sorted;
    }
   
    //reads each line of csv file, then puts it in a string with spaces instead of commas
    //for use if execs want data besides names in the future
    public static Song read(Scanner scanner) {
        if (!scanner.hasNext()) return null;
        String[] arr = scanner.next().split(",");
        String temp = "";
        int count = 0;
        int r = 0;
        for(String a: arr){
            //if statement collects name, assuming it comes after the first word and comma
            if(count == 1){name.equals(a);}
            else{
                temp += (a+ " ");
            }
            count++;
        }
        line[r] = temp;
        r++;
        return new Song(name, line);
    }
    
    private static String name;   
    private static String[] line = new String[10];
    String[] names = new String[10];
    static Queue<String> obj = new LinkedList<String>();
    
    public static void main(String[] args) throws Exception{
       PrintWriter artistSort = new PrintWriter("placeholderFile.txt");
       //two files are used from separate dates to test if this works
       File f = new File("regional-global-daily-latest.csv");
       File f2 = new File("regional-global-weekly-2020-01-17--2020-01-24.csv");
       PrintWriter writer = new PrintWriter("newFile.txt");
       String l1 = f.readLine(); 
        String l2 = f2.readLine(); 
       //merges two files into the new writer file
       while (l1 != null || l2 !=null) 
        { 
            if(l1 != null) 
            { 
                writer.println(l1); 
                l1 = f.readLine(); 
            }               
            if(l2 != null) 
            { 
                writer.println(l2); 
                l2 = f2.readLine(); 
            } 
        } 
       writer.flush();
       f.close();
       f2.close();
       writer.close();
       Scanner scanner = new Scanner(writer);
       Song artist = read(scanner);
       //this reads in lines through read method, then gets name from getName which goes in the queue
       while(artist != null){
           obj.add(artist.getName());
           artist = read(scanner);
       }
       //used two queues to sort the alrady existing queue we have
       Queue<String> unsorted = new LinkedList<String>();
       Queue<String> sorted = new LinkedList<String>();
       while(!obj.isEmpty()){
           unsorted.add(obj.remove());
           while(!unsorted.isEmpty()){
               String temp = unsorted.remove();
               while(!sorted.isEmpty() && !temp.equals(sorted.peek())){
                   if( temp.equals(sorted.peek()){
                       unsorted.add(sorted.remove());
                    }
                    sorted.add(next);
                }
            
            }
        //sorted gets returned in the return method
       }
       
       //removes any duplicate elements in linkedlist
       for(int i = 0; i < obj.size(); i++){
           if(i>0 && i <obj.size()){
               if(obj.get(i).equals(obj.get(i-1))){
                   obj.remove(obj.get(i));
                }
            }
       }
       }
 }

//this class prompts the user to interact with the names of artists if needed
 
 class Playlist {
    public static void main(String [ ] args) {
        //copies over linkedlist from previous class
        Song artistNames = new Song();
        //creates a queue from linkedlist
        Queue<String> obj2 = new LinkedList<String>();
        obj2 = (LinkedList)(artistNames.getList()).clone();
        Scanner x = new Scanner(System.in);
        String resp = x.next();
                
        //while loop allows user to add names, display list, or quit
        while(!resp.equals("quit")){
        System.out.println("Would you like to hear a song, delete a song, add a song, or quit? (song/add/del/quit)");
            if(resp.equals("song")){
                System.out.println("type in the artist's name");
                String temp = x.next();
                artistNames.insert(temp);
            }
            else if(resp.equals("add")){
                System.out.println("what song?");
                String temp = x.next();
                artistNames.add(temp);
            }
            else if(resp.equals("del")){
                System.out.println("which song to delete?");
                String temp = x.next();
                artistNames.remove(temp);
            }
        System.out.println("Would you like to hear a song, delete a song, add a song, or quit? (song/add/del/quit)");
        resp = x.next();
    }
    }
}
