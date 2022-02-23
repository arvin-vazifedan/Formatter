import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.bot.BaseAbilityBot;
import org.telegram.abilitybots.api.objects.Flag;
import org.telegram.abilitybots.api.objects.Reply;
import org.telegram.abilitybots.api.toggle.BareboneToggle;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.function.BiConsumer;

public class Bot extends AbilityBot {

    //This toggle can be used to turn off ALL the default abilities supplied by the library.
    private static final BareboneToggle toggle = new BareboneToggle();
    private final ResponseHandler responseHandler;

    protected Bot(DefaultBotOptions botOptions) {
        super(Constants.TOKEN, Constants.USERNAME, toggle, botOptions);
        responseHandler = new ResponseHandler(sender);
    }

    @Override
    public long creatorId() {
        return Constants.CREATOR_ID;
    }

    public Reply replyToMessage() {
        BiConsumer<BaseAbilityBot, Update> action = (bot, update) ->
            responseHandler.replyToMessages(update.getMessage().getChatId(), update.getMessage().getText());
        return Reply.of(action, Flag.TEXT);
    }

    public Reply replyToInlineQuery() {
        BiConsumer<BaseAbilityBot, Update> action = (bot, update) ->
            responseHandler.answerToInline(update.getInlineQuery().getId(), update.getInlineQuery().getQuery());
        return Reply.of(action, Flag.INLINE_QUERY);
    }

}
