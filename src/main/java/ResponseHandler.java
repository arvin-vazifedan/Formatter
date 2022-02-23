import org.telegram.abilitybots.api.sender.MessageSender;
import org.telegram.telegrambots.meta.api.methods.AnswerInlineQuery;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.inlinequery.inputmessagecontent.InputTextMessageContent;
import org.telegram.telegrambots.meta.api.objects.inlinequery.result.InlineQueryResult;
import org.telegram.telegrambots.meta.api.objects.inlinequery.result.InlineQueryResultArticle;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class ResponseHandler {

    private final MessageSender sender;

    public ResponseHandler(MessageSender sender) {
        this.sender = sender;
    }

    public void replyToMessages(long chatId, String str) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(chatId));
        sendMessage.setText(Formatter.format(str));
        try {
            sender.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void answerToInline(String inlineId, String query) {
        InputTextMessageContent inputTextMessageContent = new InputTextMessageContent();
        inputTextMessageContent.setMessageText(Formatter.format(query));

        InlineQueryResultArticle inlineQueryResultArticle = new InlineQueryResultArticle();
        inlineQueryResultArticle.setTitle("Send Message");
        inlineQueryResultArticle.setDescription("Send text with correct formation");
        inlineQueryResultArticle.setId(inlineId);
        inlineQueryResultArticle.setInputMessageContent(inputTextMessageContent);

        List<InlineQueryResult> list = new ArrayList<>();
        list.add(inlineQueryResultArticle);

        AnswerInlineQuery answerInlineQuery = new AnswerInlineQuery();
        answerInlineQuery.setInlineQueryId(inlineId);
        answerInlineQuery.setResults(list);
        try {
            sender.execute(answerInlineQuery);
        } catch (TelegramApiException e) {
            System.out.println(e.getMessage());
        }
    }

}
