package utilities;

import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Condition.*;

public class ConditionExtension {


    public static Condition clickable =
            Condition.and("is ready", exist, visible, enabled);

}
