package generiques;

/**
 * Created by nicolas on 17/02/15.
 */
public class MouvementInvalideException extends Exception {

    public MouvementInvalideException() {
        super();
    }

    public MouvementInvalideException(String message) {
        super(message);
    }
}
