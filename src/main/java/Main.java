import Commands.Clear;
import Commands.CreateTeams;
import Commands.Ping;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

public class Main {

    public static void main(String[] args) throws Exception {
        JDA jda = new JDABuilder("Njc4ODM5ODEwMjkwMzUyMTQ4.XpO4aA.1lPR11_K1sU2DoRXr-3lFALqOrE").build();
        jda.getPresence().setStatus(OnlineStatus.ONLINE);
        jda.getPresence().setActivity(Activity.watching("you from the edge of paradise"));

        jda.addEventListener(new Clear());
        jda.addEventListener(new CreateTeams());
        jda.addEventListener(new Ping());
    }

}
