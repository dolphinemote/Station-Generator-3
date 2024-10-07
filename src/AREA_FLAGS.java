public enum AREA_FLAGS {
    HAS_LOW_IMPORTANCE_EXTERNAL_AIRLOCK,
    ARRIVALS_DOCK,
    DEPARTURES_DOCK,
    CARGO_DOCK,
    CARGO_MINING_DOCK,
    PUBLIC_MINING_DOCK,

    //

    PUBLIC_DESK,//adds a desk between different departments
    DEPARTMENTAL_DESK,//adds a desk between areas of the same department

    //

    MURDER_SCENE,//sec barriers, crayons, maybe blood and a weapon
    EXPLOSION_SITE,//hole in the floor, deactivated air alarm, engineering barriers
    //many other things in theory, like bio-hazards and welded airlocks
}
