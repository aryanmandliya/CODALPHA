import java.util.*;

public class ChatBot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, String> responses = new HashMap<>();

        responses.put("hi", "Hello! How can I help you?");
        responses.put("how are you", "I'm just a bot, but I'm doing great!");
        responses.put("bye", "Goodbye! Have a nice day!");
        responses.put("what is your name", "I'm CodeAlpha ChatBot.");

        System.out.println("ChatBot: Hello! Ask me something (type 'exit' to quit).");

        while (true) {
            System.out.print("You: ");
            String input = sc.nextLine().toLowerCase();

            if (input.equals("exit"))
                break;

            String response = responses.getOrDefault(input, "Sorry, I don't understand that.");
            System.out.println("ChatBot: " + response);
        }

        sc.close();
    }
}
