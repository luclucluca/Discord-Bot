import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class Main {
    public static void main(String[] args) throws LoginException {
        JDABuilder builder = new JDABuilder();
        String token = "insert token here";
        builder.setToken(token);
        builder.addEventListeners(new Listener());
        builder.build();
    }
}
