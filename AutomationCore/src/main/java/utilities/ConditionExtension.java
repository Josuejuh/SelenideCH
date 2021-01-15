package utilities;

import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Condition.*;

public class ConditionExtension {

    public static Condition clickable(){
        Condition available = and("can be clicked", visible, enabled);
        return available;
    }

}
