import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.objects.Ability;
import org.telegram.abilitybots.api.objects.Privacy;
import org.telegram.abilitybots.api.toggle.BareboneToggle;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.api.objects.Update;

import static org.telegram.abilitybots.api.objects.Locality.ALL;

public class Bot extends AbilityBot {

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

    @Override
    public void onUpdateReceived(Update update) {
        if (update.getMessage().getText().equals("/start")) {
            responseHandler.replyToStart(update.getMessage().getChatId());
        } else if (update.hasMessage()) {
            responseHandler.replyToMessages(update.getMessage().getChatId(), update.getMessage().getText());
        }
    }
}
