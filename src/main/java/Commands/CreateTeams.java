package Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.util.ArrayList;

public class CreateTeams extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");

        if (args[0].equals("f!createteams")) {
            if (args.length != 11) {
                EmbedBuilder error = new EmbedBuilder();
                error.setColor(Color.red)
                        .setDescription("Please input the names of 10 players.");
                event.getChannel().sendMessage(error.build()).queue();
            }
            else {
                String team1 = "";
                int team1c = 0;
                String team2 = "";
                int team2c = 0;
                ArrayList<Integer> num = new ArrayList<>();
                while(team1c < 5) {
                    int ran = (int)(Math.random() * 10 + 1);
                    while (num.contains(ran)) {
                        ran = (int)(Math.random() * 10 + 1);
                    }
                    team1 += args[ran] + " ";
                    team1c++;
                    num.add(ran);
                }
                while(team2c < 5) {
                    int ran = (int) (Math.random() * 10 + 1);
                    while (num.contains(ran)) {
                        ran = (int) (Math.random() * 10 + 1);
                    }
                    team2 += args[ran] + " ";
                    team2c++;
                    num.add(ran);
                }
                EmbedBuilder msg = new EmbedBuilder();
                msg.setColor(Color.green)
                        .addField("Team 1", team1, false)
                        .addField("Team 2", team2, false);
                event.getChannel().sendMessage(msg.build()).queue();
            }
        }
    }

}
