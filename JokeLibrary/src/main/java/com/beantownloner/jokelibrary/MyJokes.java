package com.beantownloner.jokelibrary;

import java.util.Random;

public class MyJokes {

   // public static String tellAWizardJoke(){
      //  return "A hand-crafted joke";
 //   }
    public static String getJoke() {

        String jokes[]={"Q: What did one wall say to the other wall?\n" +
                "A: I'll meet you at the corner.","Q: What did the paper say to the pencil?\n" +
                "A: Write on!","Q: What do you call a boy named Lee that no one talks to?\n" +
               " A: Lonely",
        "Q: What goes up and down but does not move?\n" +
                "A: Stairs",
        "Q: Where should a 500 pound alien go?\n" +
                "A: On a diet",
        "Q: What did one toilet say to the other?\n" +
                "A: You look a bit flushed."+
        "Q: What gets wetter the more it dries?\n" +
                "A: A towel.",
        "Q: Why do bicycles fall over?\n" +
                "A: Because they are two-tired!",
        "Q: Why do dragons sleep during the day?\n" +
                "A: So they can fight knights!" };
/*

*/
        int joke_id = new Random().nextInt(jokes.length);
        return jokes[joke_id];
    }
}
