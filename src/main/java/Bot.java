import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.toggle.BareboneToggle;
import org.telegram.telegrambots.bots.DefaultBotOptions;

public class Bot extends AbilityBot {

    private static final BareboneToggle toggle = new BareboneToggle();

    protected Bot(DefaultBotOptions botOptions) {
        super(Constants.TOKEN, Constants.USERNAME, toggle, botOptions);
    }


    @Override
    public long creatorId() {
        return Constants.CREATOR_ID;
    }
}
