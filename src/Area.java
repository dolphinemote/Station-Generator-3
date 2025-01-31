import java.util.Random;

public class Area
{
    Random random = new Random();

    String path;
    String airlock_path;
    String window_spawner_path;
    String wall_path;
    String floor_path;
    String table_path;

    String floor2_path;

    String[] floor_pool;
    String[] crate_pool;
    String[] loot_pool;
    String[] object_pool;
    String[] table_pool;

    Area
    (
            String path,
            String airlock_path,
            String window_spawner_path,
            String wall_path,
            String[] floor_pool,
            String[] crate_pool,
            String[] loot_pool,
            String[] object_pool,
            String[] table_pool
    )
    {
        this.path = path;
        this.airlock_path = airlock_path;
        this.window_spawner_path = window_spawner_path;
        this.wall_path = wall_path;
        this.floor_pool = floor_pool;
        this.crate_pool = crate_pool;
        this.loot_pool = loot_pool;
        this.object_pool = object_pool;
        this.table_pool = table_pool;

        this.floor_path = floor_pool[random.nextInt(floor_pool.length)];
        this.table_path = table_pool[random.nextInt(table_pool.length)];


        this.floor2_path = floor_pool[random.nextInt(floor_pool.length)];


    }
}
