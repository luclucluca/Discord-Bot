import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.io.*;

public class Listener extends ListenerAdapter {
    @Override
    public void onMessageReceived(@Nonnull MessageReceivedEvent event) {
        String message = event.getMessage().getTimeCreated() + " " + event.getAuthor().getName() + ": "
                + event.getMessage().getContentDisplay();

        System.out.println(event.getMessage().getTimeCreated() + " " + event.getAuthor().getName() + ": "
                + event.getMessage().getContentDisplay());
    }
}
