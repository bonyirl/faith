package Commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Ping extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        if (event.getMessage().getContentRaw().equals("f!ping")) {
            long time = System.currentTimeMillis();
            event.getChannel().sendMessage("Pong!")
                    .queue(response -> response.editMessageFormat("Ping: %d ms", System.currentTimeMillis() - time).queue());
        }
    }

}
