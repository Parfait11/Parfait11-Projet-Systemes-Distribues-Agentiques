package enset.dimba.ebankbot.discord;


import com.zgamelogic.discord.annotations.DiscordController;
import com.zgamelogic.discord.annotations.*;
import enset.dimba.ebankbot.agents.EbankAIAgent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.springframework.ai.chat.prompt.Prompt;

@com.zgamelogic.discord.annotations.DiscordController
public class DiscordBot {
    private EbankAIAgent ebankAIAgent;

    public DiscordBot(EbankAIAgent ebankAIAgent) {
        this.ebankAIAgent = ebankAIAgent;
    }

    @DiscordMapping()
    private void perform(MessageReceivedEvent event){
        if (event.getAuthor().isBot()) return;
        String query = event.getMessage().getContentRaw();
        String response = ebankAIAgent.chat(new Prompt(query), event.getChannel().getId());
        event.getChannel().sendMessage(response).queue();
    }
}
