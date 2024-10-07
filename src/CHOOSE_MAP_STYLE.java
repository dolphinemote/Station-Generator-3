import java.util.Map;
import java.util.Random;

public class CHOOSE_MAP_STYLE
{
    static Random random = new Random();

    public static Map_Style choose_randomly()
    {
        int random_index = random.nextInt(GLOBAL_VARS.list_of_styles.length);

        //System.out.println(random_index);

        TopRightLogPanel.add_a_message("STYLE: " + GLOBAL_VARS.list_of_styles[random_index].name);

        return GLOBAL_VARS.list_of_styles[random_index];
    }
}
