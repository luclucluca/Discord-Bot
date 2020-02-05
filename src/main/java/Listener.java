import com.vdurmont.emoji.EmojiManager;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import javax.annotation.Nonnull;
import java.io.*;



public class Listener extends ListenerAdapter {
    @Override
    public void onMessageReceived(@Nonnull MessageReceivedEvent event) {
        String message = event.getMessage().getTimeCreated() + " " + event.getAuthor().getName() + ": "
                + event.getMessage().getContentDisplay();

        try {
            chatLogs(message);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (EmojiManager.containsEmoji(event.getMessage().getContentDisplay())) {
            event.getMessage().delete().complete();
            MessageChannel channel = event.getChannel();
            channel.sendMessage("STOP! YOU VIOLATED THE LAW! " +
                    "PAY THE COURT A FINE OR SERVE YOUR SENTENCE, YOUR STOLEN EMOJIS ARE NOW FORFEIT.")
            .queue();

        }

        System.out.println(event.getMessage().getContentDisplay());

    }



    public void chatLogs(String message) throws IOException {
        BufferedWriter logs = new BufferedWriter(new FileWriter("logs.txt", true));
        logs.write(message);
        logs.newLine();
        logs.close();

    }
}
