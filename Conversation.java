import java.util.Scanner;
import java.util.Random;


//Seychelle, Mattea

class Conversation {

  public static void main(String[] arguments) {
    // You will start the conversation here.

    int numRounds;
    Scanner input = new Scanner(System.in);
    System.out.print("How many rounds? ");
    numRounds = input.nextInt(); //nextInt is a Scanner method; reads input from the keyboard and converts it to an integer
    input.nextLine(); //clears out enter key

    
    String[] transcript = new String[numRounds * 2 + 2]; //stores transcript of conversation in array
    String[] cannedResponses = {"Mmm-hm.", "Cool.", "Okay."}; //array of canned responses
    int numCannedResponses = cannedResponses.length;

    transcript[0] = "Hi there! What's on your mind?";
    System.out.println(transcript[0]);


    //slice inputted string into individual words - want to split on spaces
    String[] stop_words = {"I", "me", "am", "you", "my", "your"};
    String[] replacement_words = {"you", "you", "are", "I", "your", "my"};

    for(int i = 0; i < numRounds; i++) {  //generates a response for each input/round
                                          //starts at index 0 of transcript
      String userResponse = input.nextLine(); //Advances the "input" scanner past the current line and returns the line that was skipped
      transcript[(2 * i + 1)] = userResponse; //the inputted response is put in every 2 indeces after index 0

      String[] userWords = userResponse.split(" "); //takes the inputted string and splits the words into an array
      
      String new_sentence = "";
      boolean hasReplacedWord = false;

      //for(String user_word : oneResponseAsArray)
      for(int j = 0; j < userWords.length; j++) { //goes along the inputed array word by word
        String replacement = "";
        for(int k = 0; k < stop_words.length; k++) {
          if(userWords[j].equals(stop_words[k])){
            replacement = replacement_words[k];
            hasReplacedWord = true;
          }
        }
        if(replacement.equals("")) {
          new_sentence += userWords[j] + " ";
        } else {
          new_sentence += replacement + " ";
        }

        //if word is mirror-able:
          //find replacement for word
          //new_sentence += replacement + " ";
          //haveReplacedAWord = true;

      }

      if(!hasReplacedWord) {
        new_sentence = cannedResponses[(int) Math.floor(numCannedResponses * Math.random())];
      }

      //take care of the trancscript:

      transcript[2 * i + 2] = new_sentence; //what the computer prints in response to the human input
      System.out.println(new_sentence);
    }

    input.close();
    System.out.println("See ya!");
    System.out.println(" ");
    System.out.println("TRANSCRIPT: ");
    for(String sentence : transcript) {
      System.out.println(sentence);
    }

    System.out.println("See ya!");
    System.exit(0);

    // Program queries user for number of conversation rounds

    // Program carries out requested number of conversation rounds

    // Allocates static array of canned responses

    // Uses a canned response when no mirror words detected

    // Detects the requested set of mirror words (at minimum)

    // Replaces simple mirror words appropriately (unpunctuated, lowercase)

    // Makes all appropriate mirror replacements

    // Stores transcript of the conversation in an array

    // Prints transcript when terminating

    // Classes & class members all have Javadoc header comments
  }
}
