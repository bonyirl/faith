package Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.util.List;

public class Clear extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");

        if (args[0].equals("f!clear")) {
            if (args.length != 2) {
                EmbedBuilder usage = new EmbedBuilder();
                usage.setTitle("Specify amount to delete")
                        .setDescription("f!clear [# of messages]");
                event.getChannel().sendMessage(usage.build()).queue();
            }
            else if (Integer.parseInt(args[1]) < 2 || Integer.parseInt(args[1]) > 100) {
                EmbedBuilder error = new EmbedBuilder();
                error.setColor(Color.red)
                        .setDescription("Between 2-100 messages can be deleted at one time");
                event.getChannel().sendMessage(error.build()).queue();
            }
            else {
                List<Message> messages = event.getChannel().getHistory().retrievePast(Integer.parseInt(args[1])).complete();
                event.getChannel().deleteMessages(messages).queue();
                EmbedBuilder success = new EmbedBuilder();
                success.setColor(Color.green)
                        .setTitle(args[1] + " messages successfully deleted!");
                event.getChannel().sendMessage(success.build()).queue();
            }
        }
    }

}
