package jblejder.cards.shared.dagger;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;
import jblejder.cards.shared.Constants;
import jblejder.cards.shared.cardHandRecognition.HandRecognitor;
import jblejder.cards.shared.cardHandRecognition.recognitors.ColorRecognitor;
import jblejder.cards.shared.cardHandRecognition.recognitors.FigureRecognitor;
import jblejder.cards.shared.cardHandRecognition.recognitors.StairsRecognitor;
import jblejder.cards.shared.cardHandRecognition.recognitors.TwinsRecognitor;
import jblejder.cards.shared.services.RecognitionService;

@Module
public class RecognitionModule {

    @Provides
    public RecognitionService getRecognitionService() {
        List<HandRecognitor> recognitors = new ArrayList<>();
        recognitors.add(new ColorRecognitor(Constants.COLOR_ITEMS));
        recognitors.add(new FigureRecognitor(Constants.FIGURE_ITEMS));
        recognitors.add(new StairsRecognitor(Constants.STAIRS_ITEMS));
        recognitors.add(new TwinsRecognitor(Constants.TWINS_ITEMS));

        return new RecognitionService(recognitors);
    }
}
