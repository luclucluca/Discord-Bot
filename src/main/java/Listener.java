import com.vdurmont.emoji.EmojiManager;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceLeaveEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import javax.annotation.Nonnull;
import java.io.*;
import java.time.LocalDateTime;


public class Listener extends ListenerAdapter {

    String startDate = "";
    String startTime = "";
    String endDate = "";
    String endTime = "";
    boolean flag = false;

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

    @Override
    public void onGuildVoiceJoin(@Nonnull GuildVoiceJoinEvent event) {
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        int hour = now.getHour();
        int minute = now.getMinute();

        startDate = day + "/" + month + "/" + year;
        startTime = hour + ":" + minute;

    }

    @Override
    public void onGuildVoiceLeave(@Nonnull GuildVoiceLeaveEvent event) {
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        int hour = now.getHour();
        int minute = now.getMinute();

        endDate = day + "/" + month + "/" + year;
        endTime = hour + ":" + minute;

        flag = true;
    }

    public void Timer() {
        if (flag) {
            Timer timer = new Timer(startTime, startDate, endDate, endTime);
            MessageChannel general =  ;
        }
    }

    public String getStartDate() {
        return startDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getEndTime() {
        return endTime;
    }
}
