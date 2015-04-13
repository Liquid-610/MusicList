import java.util.*;

public class MusicRunner
{
  // Strip off the first and last double quote and trim the rest
  public static String clean (String input)
  {
    String Output = input.substring(1,input.length() - 1);
    return Output;
  }
  
  public static void main (String[] args)
  {
    int count = 0;
    MusicReader read = new MusicReader();
    
    read.open("musiclist.csv");
    
    String[] data = read.getSongData();
    
    //Song song = new Song () {s0, s1,s2,s3,s4,s5,s6,s7,s8,s9};
    //ArrayList<MusicRunner> myArrayList = new ArrayList<MusicRunner>(10);
    ArrayList <Song> songs = new ArrayList <Song> ();
    
    // First line contains all the fields - We don't want to save this anywhere but we can
    // print it for now to see what information we have.
    System.out.println(Arrays.toString(data));
    
    data = read.getSongData();  // Get next line of song data
    
    // if data is null then we were unable to read a line of song data, so
    // this loop will continue to read lines of song data as long as there
    // IS song data available
    while (data != null)
    {
      // You probably will comment this out but for now print out the line so you can see what is there
      System.out.println(Arrays.toString(data));
      
      // Let's try to create a Song object
      Song song = new Song(clean(data[0]), clean(data[1]), 1997, 0.3, "Notes here");  // data[0] is the artist and data[1] is the name

      System.out.println(song.artist);
      
      //songs.add(song);
      
      count++;
      
      if (count == 1)  // For now only read ONE song
        break;
      
      data = read.getSongData();  // Get next line of song data
    }
    
    read.close();
  }
}