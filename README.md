# Assignment-2
Name: Jason McLoughlin

Class Descriptions:

Song: where all the data is read in

Playlist: where the user can access the data from the sorted queue (has an interface the user answers when prompted)


File 1: regional-global-daily-latest.csv

File 2: regional-global-weekly-2020-01-17--2020-01-24.csv

File 3: newFile.txt. will be created once program runs


Important Methods/Variables:

public static Song read(Scanner scanner): used to read in files' data

Queue<String> sorted: where the sorted data is
  
PrintWriter writer: file with merged data of the latest data and January's data




Sample Output (where user enters add a song then quits):

"Would you like to hear a song, delete a song, add a song, or quit? (song/add/del/quit)"

  >add
  
"What song to add?"

  >user enters song name, question repeats
  
"Would you like to hear a song, delete a song, add a song, or quit? (song/add/del/quit)"

  >quit
  
  >then program ends


Summary:

This project reads in multiple files of spotify's data. 
I used two in this case to test this out, with one being an old csv file from January, and one from this week (the latest).
If I wish, I could add in more files to the program in a few steps 
I could make each a File object, then pass them to the while loop where they are merged
The two spotify files I used will be in the "files" section of this project
I decided to merge the files, unsorted, into a single file that I created using PrintWriter.
After that, I passed my new file into the read method so that the rest of my program has access to the data
After this step, I add all the values of my new file to a queue using a while loop
Below all this, I sort my now-filled queue into a new queue, called "sorted", and pass that as my sorted array
The FindArtist class retrieves this queue's info, and allows the user to access its data
