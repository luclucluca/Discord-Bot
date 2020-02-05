import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class Main {
    public static void main(String[] args) throws LoginException {
        JDABuilder builder = new JDABuilder();
        String token = "NjM5MzYyNDQzMjY0MzkzMjE2.Xjp2rg.ZdeRjfrWsRNY230hxIMZx5IjpWU";
        builder.setToken(token);
        builder.addEventListeners(new Listener());
        builder.build();
    }
}
