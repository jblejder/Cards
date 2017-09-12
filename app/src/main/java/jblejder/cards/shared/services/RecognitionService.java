package jblejder.cards.shared.services;

import com.annimon.stream.Collectors;
import com.annimon.stream.Stream;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import jblejder.cards.shared.cardHandRecognition.Hand;
import jblejder.cards.shared.cardHandRecognition.HandRecognitor;
import jblejder.cards.shared.cardHandRecognition.RecognitionResult;
import jblejder.cards.shared.models.Card;

public class RecognitionService {

    private final List<HandRecognitor> recognitors;


    public RecognitionService(List<HandRecognitor> recognitors) {
        this.recognitors = recognitors;
    }

    public Single<List<Hand>> recognise(List<Card> cards) {
        Single<List<Hand>> single = Single.create(e -> {
            List<Hand> result = Stream.of(recognitors)
                    .map(handRecognitor -> handRecognitor.recognise(cards))
                    .filter(RecognitionResult::isFound)
                    .map(RecognitionResult::getHand)
                    .collect(Collectors.toList());
            e.onSuccess(result);
        });
        return single
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
