public class MAP_STYLE_INIT {

    //walls
    static String wall_path = "/turf/closed/wall,";
    static String r_wall_path = "/turf/closed/wall/r_wall,";
    static String titanium_wall_path = "/turf/closed/wall/mineral/titanium,";
    static String plastitanium_wall_path= "/turf/closed/wall/mineral/plastitanium,";
    static String spaceship_hull_wall_path = "/turf/closed/wall/mineral/titanium/survival,";

    //windows
    static String window_spawner = "/obj/effect/spawner/structure/window, /turf/open/floor/plating,";
    static String r_window_spawner = "/obj/effect/spawner/structure/window/reinforced, /turf/open/floor/plating,";
    static String plasma_r_window_spawner = "/obj/effect/spawner/structure/window/reinforced/plasma, /turf/open/floor/plating,";
    static String plastitanium_window_spawner = "/obj/effect/spawner/structure/window/reinforced/plasma/plastitanium, /turf/open/floor/plating,";
    static String shuttle_window_spawner = "/obj/effect/spawner/structure/window/reinforced/shuttle, /turf/open/floor/plating,";
    static String pod_window_spawner = "/obj/effect/spawner/structure/window/survival_pod, /turf/open/floor/plating,";
    static String lattice_insead_of_window = "/turf/open/space/basic, /obj/structure/lattice,";
    static String grille_instead_of_window = "/turf/open/floor/plating, /obj/structure/grille,";

    //



    static String[] engineering_MixedCorporations_floor_pool = new String[]{
            "/turf/open/floor/mineral/titanium/yellow,",
            "/turf/open/floor/mineral/titanium/tiled/yellow,/obj/effect/turf_decal/tile/brown/opposingcorners,"
    };

    static String[] basic_NT_crate_pool = new String[]{
            "/obj/structure/closet,",
            "/obj/structure/closet/crate,",
    };
    static String[] basic_NT_floor_pool = new String[]{
            "/turf/open/floor/plating,",
    };
    static String[] basic_NT_loot_pool = new String[]{
            "/obj/item/stack/rods",
            "/obj/item/shard",
            "/obj/item/storage/belt/utility",
    };
    static String[] basic_NT_object_pool = new String[]{
            "/obj/machinery/portable_atmospherics/scrubber,",
            "/obj/machinery/portable_atmospherics/pump,",
            "/obj/structure/closet/firecloset,",
            "/obj/structure/closet/emcloset,",
            "/obj/structure/hedge,",
            "/obj/machinery/recharge_station,",
            "/obj/machinery/portable_atmospherics/canister/oxygen,",
            "/obj/machinery/portable_atmospherics/canister/air,",

            "/obj/machinery/autolathe,",
            //"/obj/machinery/biogenerator/food_replicator,",
            "/obj/machinery/power/port_gen/pacman,",
            "/obj/effect/spawner/random/vending/colavend,",
            "/obj/effect/spawner/random/vending/snackvend,",
    };

    static String[] civilian_loot_pool = new String[]
            {
                    "/obj/item/reagent_containers/cup/glass/coffee",
                    "/obj/item/folder",
                    "/obj/item/paper_bin,/obj/item/pen",
                    "/obj/item/modular_computer/laptop/preset/civilian",
                    "/obj/item/flashlight/lamp/green",
                    "/obj/item/flashlight/lamp",
            };

    static String[] medical_CIN_floor_pool = new String[]
            {
                    "/turf/open/floor/iron/white/small,/obj/effect/turf_decal/tile/dark_blue/opposingcorners,",
                    "/turf/open/floor/iron/showroomfloor,/obj/effect/turf_decal/tile/dark_blue/opposingcorners,",
                    "/turf/open/floor/iron/white/small,"
            };

    static String[] medbay_loot_pool = new String[]
            {
                    "/obj/item/storage/medkit/regular",
                    "/obj/item/storage/medkit/brute",
                    "/obj/item/storage/medkit/fire",
                    "/obj/item/storage/medkit/surgery",
                    "/obj/item/storage/medkit/toxin",
                    "/obj/item/storage/medkit/o2",
                    "/obj/item/storage/medkit/regular",
                    "/obj/item/storage/medkit/advanced",
                    //
                    "/obj/item/stack/medical/suture",
                    "/obj/item/stack/medical/mesh",
                    "/obj/item/stack/medical/gauze/twelve",
                    "/obj/item/stack/medical/bone_gel",
            };

    static String[] basic_Syndicate_crate_pool = new String[]{
            "/obj/structure/closet,",
            "/obj/structure/closet/crate,",
            "/obj/structure/closet/syndicate,"};
    static String[] basic_Syndicate_floor_pool = new String[]{
            "/turf/open/floor/iron/dark,",
            "/turf/open/floor/mineral/plastitanium,",
            "/turf/open/floor/mineral/titanium,",
            "/turf/open/floor/mineral/titanium/tiled,",
            "/turf/open/floor/mineral/titanium/tiled,/obj/effect/turf_decal/tile/bar/opposingcorners,",
    };


    static String[] basic_CIN_LOOT_pool = new String[]{
            "/obj/item/flashlight/lamp/green",
            "/obj/item/flashlight/lamp",

            "/obj/item/trench_tool",

            "/obj/item/wrench",
            "/obj/item/crowbar",
            "/obj/item/screwdriver",
            "/obj/item/wirecutters",
            "/obj/item/storage/toolbox/mechanical",
            "/obj/item/storage/toolbox/electrical",
            "/obj/item/storage/box/stockparts/basic",

            "/obj/item/crowbar/power",
            "/obj/item/tank/internals/oxygen/red",
            "/obj/item/tank/internals/oxygen/yellow",
            "/obj/item/tank/internals/oxygen",
    };
    static String[] basic_MixedCorporations_floor_pool = new String[]{
            "/turf/open/floor/mineral/plastitanium,",
            "/turf/open/floor/mineral/titanium/white,",
            "/turf/open/floor/iron/smooth,",
            "/turf/open/floor/mineral/titanium/tiled/white,",
            "/turf/open/floor/mineral/titanium/tiled/white,/obj/effect/turf_decal/tile/bar/opposingcorners,",
            "/turf/open/floor/mineral/titanium/tiled/white,/obj/effect/turf_decal/tile/yellow/opposingcorners,",
    };
    static String[] basic_Mixed_Corporations_crate_pool = new String[]{
            "/obj/structure/closet,",
            "/obj/structure/closet/crate,",
            "/obj/structure/closet/crate/eva,"
    };

    static String[] engineering_MixedCorps_loot_pool = new String[]{
            "/obj/item/crowbar/large",
            "/obj/item/pickaxe/drill",
            "/obj/item/screwdriver",
            "/obj/item/weldingtool",
            "/obj/item/storage/belt/utility",
            "/obj/item/clothing/head/utility/hardhat/orange",
            "/obj/item/stack/sheet/mineral/titanium/fifty",
            "/obj/item/stack/sheet/iron/fifty",
            "/obj/item/stack/sheet/plasteel/fifty",
            "/obj/item/stack/sheet/plasmarglass/fifty",
            "/obj/item/stack/sheet/glass/fifty",
            "/obj/item/stack/sheet/rglass/fifty",
            "/obj/item/stack/rods/fifty",
    };
    static String[] engineering_MixedCorps_object_pool = new String[]{
            "/obj/machinery/ore_silo,",
            "/obj/machinery/power/smes,",
            "/obj/machinery/power/port_gen/pacman,",
            "/obj/structure/closet/crate/solarpanel_small,",
            "/obj/structure/closet/crate/secure/plasma,",
            "/obj/machinery/portable_atmospherics/canister/oxygen,",
            "/obj/machinery/portable_atmospherics/canister/air,",
    };


    static String[] medical_NT_object_pool = new String[]{
            "/obj/machinery/stasis,",
            "/obj/machinery/iv_drip,",
            "/obj/structure/bed/medical,",
            "/obj/structure/table/optable,",
            "/obj/item/surgery_tray/deployed,",
    };
    static String[] medical_CIN_object_pool = new String[]{
            "/obj/machinery/iv_drip,",
            "/obj/structure/bed,",
            "/obj/structure/bed/medical/emergency,",
            "/obj/structure/table/optable,",
    };
    static String[] medical_SYNDICATE_object_pool = new String[]{
            "/obj/machinery/stasis,",
            "/obj/machinery/iv_drip,",
            "/obj/machinery/sleeper/syndie,",
            "/obj/structure/table/optable,",
    };
    static String[] medical_SpaceRuin_object_pool = new String[]{
            "/obj/machinery/stasis,",
            "/obj/machinery/iv_drip,",
            "/obj/structure/bed,",
            "/obj/structure/table/optable,",
            "/obj/machinery/sleeper,",
    };
    static String[] medical_MixedCorps_object_pool = new String[]{
            "/obj/machinery/stasis,",
            "/obj/machinery/iv_drip,",
            "/obj/structure/bed/medical/emergency,",
            "/obj/structure/table/optable,",
    };

    // CIN ARMOURY LOOT
    static String[] armoury_CIN_loot_pool = new String[]{

            "/obj/item/melee/baton",
            "/obj/item/gun/energy/disabler",
            "/obj/item/gun/ballistic/revolver/nagant",
            "/obj/item/gun/ballistic/rifle/boltaction",

            "/obj/item/storage/backpack/duffelbag/syndie/c4",
            //
            "/obj/item/clothing/head/helmet",
            "/obj/item/clothing/suit/armor/vest",
    };

    static String[] armoury_SYNDICATE_loot_pool = new String[]{
            //
            "/obj/item/melee/baton/telescopic",
            "/obj/item/gun/energy/disabler",
            //
            "/obj/item/gun/ballistic/shotgun/bulldog/unrestricted",
            "/obj/item/gun/ballistic/automatic/smartgun",
            "/obj/item/gun/ballistic/automatic/pistol/clandestine",
            "/obj/item/gun/ballistic/rocketlauncher/unrestricted",
            "/obj/item/storage/backpack/duffelbag/syndie/c4",
            //
            "/obj/item/clothing/head/helmet",
            "/obj/item/clothing/suit/armor/vest",
    };

    //BASIC NT
    static Area basic_NT = new Area(
            "/area/station",
            "/obj/machinery/door/airlock,",
            r_window_spawner,
            wall_path,
            basic_NT_floor_pool,
            basic_NT_crate_pool,
            civilian_loot_pool,
            basic_NT_object_pool,
            new String[]{"/obj/structure/table,","/obj/structure/table/reinforced,"});

    //BASIC SYNDICATE
    static Area basic_Syndicate = new Area(
            "/area/station",
            "/obj/machinery/door/airlock/grunge,",
            plastitanium_window_spawner,
            plastitanium_wall_path,
            basic_Syndicate_floor_pool,
            basic_Syndicate_crate_pool,
            civilian_loot_pool,
            basic_NT_object_pool,
            new String[]{"/obj/structure/table,","/obj/structure/table/reinforced/plastitaniumglass,"});

    static Area basic_SpaceRuin = new Area(
            "/area/station",
            "/obj/machinery/door/airlock/public,/obj/effect/mapping_helpers/airlock/autoname,",
            r_wall_path,
            wall_path,
            new String[]{"/turf/open/floor/plating,"},
            basic_Mixed_Corporations_crate_pool,
            basic_NT_loot_pool,
            basic_NT_object_pool,
            new String[]{"/obj/structure/table,","/obj/structure/table/reinforced,"});

    static Area basic_CIN = new Area(
            "/area/station",
            "/obj/machinery/door/airlock/survival_pod,",
            pod_window_spawner,
            spaceship_hull_wall_path,
            basic_NT_floor_pool,
            basic_NT_crate_pool,
            civilian_loot_pool,
            basic_NT_object_pool,
            new String[]{"/obj/structure/table,","/obj/structure/table/reinforced,"});

    static String[] armoury_MixedCorps_loot_pool = new String[]{
            "/obj/item/gun/energy/e_gun/mini",
            "/obj/item/gun/energy/disabler",
            "/obj/item/gun/energy/e_gun",
            "/obj/item/melee/baton/telescopic",
            //
            "/obj/item/gun/ballistic/rifle/boltaction/prime",
    };

    static Area basic_MixedCorporations = new Area(
            "/area/station",
            "/obj/machinery/door/airlock/public,",
            shuttle_window_spawner,
            titanium_wall_path,
            basic_MixedCorporations_floor_pool,
            basic_Mixed_Corporations_crate_pool,
            civilian_loot_pool,
            basic_NT_object_pool,
            new String[]{"/obj/structure/table,","/obj/structure/table/reinforced,"});


    static String[] security_MixedCorps_floor_pool = new String[]{
            "/turf/open/floor/mineral/plastitanium/red,",
    };
    static String[] security_CIN_floor_pool = new String[]{
            "/turf/open/floor/mineral/plastitanium,",
    };

    MAP_STYLE_INIT(){
        Map_Style NT = new Map_Style(MAP_STYLE_INIT.basic_NT, "NT");
        Map_Style Syndicate = new Map_Style(MAP_STYLE_INIT.basic_Syndicate, "Syndicate");
        Map_Style SpaceRuin = new Map_Style(MAP_STYLE_INIT.basic_SpaceRuin, "SpaceRuin");
        Map_Style MixedCorps = new Map_Style(MAP_STYLE_INIT.basic_MixedCorporations, "MixedCorps");
        Map_Style CIN = new Map_Style(MAP_STYLE_INIT.basic_CIN, "CIN");
        //
        GLOBAL_VARS.list_of_styles[0] = NT;
        //
        GLOBAL_VARS.list_of_styles[1] = Syndicate;
        //
        GLOBAL_VARS.list_of_styles[2] = CIN;
        //
        GLOBAL_VARS.list_of_styles[3] = SpaceRuin;
        //
        GLOBAL_VARS.list_of_styles[4] = MixedCorps;
        //

        for(int i = 0;i<20;i++)
        {
            Area generic_MixedCorps = new Area(
                    "/area/station",
                    "/obj/machinery/door/airlock/public,/obj/effect/mapping_helpers/airlock/autoname,",
                    shuttle_window_spawner,
                    titanium_wall_path,
                    basic_MixedCorporations_floor_pool,
                    basic_Mixed_Corporations_crate_pool,
                    civilian_loot_pool,
                    basic_NT_object_pool,
                    new String[]{"/obj/structure/table,","/obj/structure/table/reinforced,"});
            Area engineering_MixedCorps = new Area(
                    "/area/station/engineering",
                    "/obj/machinery/door/airlock/engineering,/obj/effect/mapping_helpers/airlock/autoname,",
                    shuttle_window_spawner,
                    titanium_wall_path,
                    engineering_MixedCorporations_floor_pool,
                    basic_Mixed_Corporations_crate_pool,
                    engineering_MixedCorps_loot_pool,
                    engineering_MixedCorps_object_pool,
                    new String[]{"/obj/structure/table,","/obj/structure/table/reinforced,"});
            Area bridge_MixedCorps = new Area(
                    "/area/station/command/bridge",
                    "/obj/machinery/door/airlock/command,/obj/effect/mapping_helpers/airlock/autoname,",
                    shuttle_window_spawner,
                    titanium_wall_path,
                    new String[] {"/turf/open/floor/mineral/titanium/tiled/blue,",
                            "/turf/open/floor/mineral/titanium/blue,"},
                    basic_Mixed_Corporations_crate_pool,
                    civilian_loot_pool,
                    basic_NT_object_pool,
                    new String[]{"/obj/structure/table,","/obj/structure/table/reinforced,"});
            Area security_MixedCorps = new Area(
                    "/area/station/security",
                    "/obj/machinery/door/airlock/security,/obj/effect/mapping_helpers/airlock/autoname,",
                    shuttle_window_spawner,
                    titanium_wall_path,
                    security_MixedCorps_floor_pool,
                    basic_Mixed_Corporations_crate_pool,
                    armoury_MixedCorps_loot_pool,
                    basic_NT_object_pool,
                    new String[]{"/obj/structure/table,","/obj/structure/table/reinforced,"});
            Area generic_CIN = new Area(
                    "/area/station",
                    "/obj/machinery/door/airlock/survival_pod/glass,/obj/effect/mapping_helpers/airlock/autoname,",
                    pod_window_spawner,
                    spaceship_hull_wall_path,
                    basic_MixedCorporations_floor_pool,
                    basic_Mixed_Corporations_crate_pool,
                    civilian_loot_pool,
                    basic_NT_object_pool,
                    new String[]{"/obj/structure/table,","/obj/structure/table/reinforced,"});
            Area engineering_CIN = new Area(
                    "/area/station/engineering",
                    "/obj/machinery/door/airlock/survival_pod,/obj/effect/mapping_helpers/airlock/autoname,",
                    pod_window_spawner,
                    spaceship_hull_wall_path,
                    engineering_MixedCorporations_floor_pool,
                    basic_Mixed_Corporations_crate_pool,
                    basic_CIN_LOOT_pool,
                    basic_NT_object_pool,
                    new String[]{"/obj/structure/table,","/obj/structure/table/reinforced,"});
            Area bridge_CIN = new Area(
                    "/area/station/command/bridge",
                    "/obj/machinery/door/airlock/survival_pod,/obj/effect/mapping_helpers/airlock/autoname,",
                    pod_window_spawner,
                    spaceship_hull_wall_path,
                    new String[]
                            {
                                "/turf/open/floor/carpet/green,",
                                "/turf/open/floor/wood,"
                            },
                    basic_Mixed_Corporations_crate_pool,
                    civilian_loot_pool,
                    basic_NT_object_pool,
                    new String[]{"/obj/structure/table,","/obj/structure/table/reinforced,"});
            Area security_CIN = new Area(
                    "/area/station/security",
                    "/obj/machinery/door/airlock/survival_pod,/obj/effect/mapping_helpers/airlock/autoname,",
                    pod_window_spawner,
                    spaceship_hull_wall_path,
                    security_CIN_floor_pool,
                    basic_Mixed_Corporations_crate_pool,
                    armoury_CIN_loot_pool,
                    basic_NT_object_pool,
                    new String[]{"/obj/structure/table,","/obj/structure/table/reinforced,"});
            Area generic_NT = new Area(
                    "/area/station",
                    "/obj/machinery/door/airlock/public,/obj/effect/mapping_helpers/airlock/autoname,",
                    "/obj/effect/spawner/structure/window,/turf/open/floor/plating,",
                    wall_path,
                    new String[]
                            {
                                    "/turf/open/floor/iron,",
                                    "/turf/open/floor/iron/small,",
                            },
                    basic_Mixed_Corporations_crate_pool,
                    civilian_loot_pool,
                    basic_NT_object_pool,
                    new String[]{"/obj/structure/table,","/obj/structure/table/reinforced,"});
            Area engineering_NT = new Area(
                    "/area/station/engineering",
                    "/obj/machinery/door/airlock/engineering,/obj/effect/mapping_helpers/airlock/autoname,",
                    "/obj/effect/spawner/structure/window/reinforced,/turf/open/floor/plating,",
                    wall_path,
                    new String[]
                            {
                                    "/turf/open/floor/iron,/obj/effect/turf_decal/tile/yellow/opposingcorners,",
                                    "/turf/open/floor/iron/small,/obj/effect/turf_decal/tile/yellow/opposingcorners,",
                            },
                    basic_Mixed_Corporations_crate_pool,
                    engineering_MixedCorps_loot_pool,
                    engineering_MixedCorps_object_pool,
                    new String[]{"/obj/structure/table,","/obj/structure/table/reinforced,"});
            Area bridge_NT = new Area(
                    "/area/station/command/bridge",
                    "/obj/machinery/door/airlock/command,/obj/effect/mapping_helpers/airlock/autoname,",
                    "/obj/effect/spawner/structure/window/reinforced,/turf/open/floor/plating,",
                    r_wall_path,
                    new String[]
                            {
                                    "/turf/open/floor/iron/dark,/obj/effect/turf_decal/tile/blue/opposingcorners,",
                            "/turf/open/floor/iron/dark/small,/obj/effect/turf_decal/tile/blue/opposingcorners,",
                    },
                    basic_Mixed_Corporations_crate_pool,
                    civilian_loot_pool,
                    basic_NT_object_pool,
                    new String[]{"/obj/structure/table,","/obj/structure/table/reinforced,"});
            Area security_NT = new Area(
                    "/area/station/security",
                    "/obj/machinery/door/airlock/security,/obj/effect/mapping_helpers/airlock/autoname,",
                    "/obj/effect/spawner/structure/window/reinforced,/turf/open/floor/plating,",
                    r_wall_path,
                    new String[]{"/turf/open/floor/iron/dark,"},
                    basic_Mixed_Corporations_crate_pool,
                    armoury_MixedCorps_loot_pool,
                    basic_NT_object_pool,
                    new String[]{"/obj/structure/table,","/obj/structure/table/reinforced,"});
            Area generic_SYNDICATE = new Area(
                    "/area/station",
                    "/obj/machinery/door/airlock/public,/obj/effect/mapping_helpers/airlock/autoname,",
                    plastitanium_window_spawner,
                    plastitanium_wall_path,
                    basic_Syndicate_floor_pool,
                    basic_Mixed_Corporations_crate_pool,
                    civilian_loot_pool,
                    basic_NT_object_pool,
                    new String[]{"/obj/structure/table,","/obj/structure/table/reinforced,"});

            Area engineering_SYNDICATE = new Area(
                    "/area/station/engineering",
                    "/obj/machinery/door/airlock/engineering,/obj/effect/mapping_helpers/airlock/autoname,",
                    plastitanium_window_spawner,
                    plastitanium_wall_path,
                    basic_Syndicate_floor_pool,
                    basic_Mixed_Corporations_crate_pool,
                    engineering_MixedCorps_loot_pool,
                    engineering_MixedCorps_object_pool,
                    new String[]{"/obj/structure/table,","/obj/structure/table/reinforced,"});
            Area bridge_SYNDICATE = new Area(
                    "/area/station/command/bridge",
                    "/obj/machinery/door/airlock/command,/obj/effect/mapping_helpers/airlock/autoname,",
                    plastitanium_window_spawner,
                    plastitanium_wall_path,
                    basic_Syndicate_floor_pool,
                    basic_Mixed_Corporations_crate_pool,
                    armoury_MixedCorps_loot_pool,
                    basic_NT_object_pool,
                    new String[]{"/obj/structure/table,","/obj/structure/table/reinforced,"});
            Area security_SYNDICATE = new Area(
                    "/area/station/security",
                    "/obj/machinery/door/airlock/security,/obj/effect/mapping_helpers/airlock/autoname,",
                    plastitanium_window_spawner,
                    plastitanium_wall_path,
                    basic_Syndicate_floor_pool,
                    basic_Mixed_Corporations_crate_pool,
                    armoury_SYNDICATE_loot_pool,
                    basic_NT_object_pool,
                    new String[]{"/obj/structure/table,","/obj/structure/table/reinforced,"});
            Area generic_SpaceRuin = new Area(
                    "/area/station",
                    "/obj/machinery/door/airlock/public,/obj/effect/mapping_helpers/airlock/autoname,",
                    lattice_insead_of_window,
                    wall_path,
                    new String[]{"/turf/open/floor/plating,"},
                    basic_Mixed_Corporations_crate_pool,
                    armoury_MixedCorps_loot_pool,
                    basic_NT_object_pool,
                    new String[]{"/obj/structure/table,","/obj/structure/table/reinforced,"});
            Area engineering_SpaceRuin = new Area(
                    "/area/station/engineering",
                    "/obj/machinery/door/airlock/engineering,/obj/effect/mapping_helpers/airlock/autoname,",
                    grille_instead_of_window,
                    r_wall_path,
                    new String[]{"/turf/open/floor/plating,"},
                    basic_Mixed_Corporations_crate_pool,
                    engineering_MixedCorps_loot_pool,
                    engineering_MixedCorps_object_pool,
                    new String[]{"/obj/structure/table,","/obj/structure/table/reinforced,"});
            Area bridge_SpaceRuin = new Area(
                    "/area/station/command/bridge",
                    "/obj/machinery/door/airlock/command,/obj/effect/mapping_helpers/airlock/autoname,",
                    grille_instead_of_window,
                    r_wall_path,
                    new String[]{"/turf/open/floor/iron,"},
                    basic_Mixed_Corporations_crate_pool,
                    armoury_MixedCorps_loot_pool,
                    basic_NT_object_pool,
                    new String[]{"/obj/structure/table,","/obj/structure/table/reinforced,"});
            Area security_SpaceRuin = new Area(
                    "/area/station/medical",
                    "/obj/machinery/door/airlock/securit,/obj/effect/mapping_helpers/airlock/autoname,",
                    lattice_insead_of_window,
                    r_wall_path,
                    new String[]{"/turf/open/floor/plating,"},
                    basic_Mixed_Corporations_crate_pool,
                    medbay_loot_pool,
                    basic_NT_object_pool,
                    new String[]{"/obj/structure/table,","/obj/structure/table/reinforced,"});
            Area medical_NT = new Area(
                    "/area/station/medical",
                    "/obj/machinery/door/airlock/medical,/obj/effect/mapping_helpers/airlock/autoname,",
                    window_spawner,
                    wall_path,
                    new String[]{"/turf/open/floor/iron/white,/obj/effect/turf_decal/tile/blue/opposingcorners,"},
                    basic_Mixed_Corporations_crate_pool,
                    medbay_loot_pool,
                    medical_NT_object_pool,
                    new String[]{"/obj/structure/table,","/obj/structure/table/reinforced,"});
            Area medical_SYNDICATE = new Area(
                    "/area/station/medical",
                    "/obj/machinery/door/airlock/virology,/obj/effect/mapping_helpers/airlock/autoname,",
                    plastitanium_window_spawner,
                    plastitanium_wall_path,
                    new String[]{"/turf/open/floor/mineral/titanium/tiled/white,/obj/effect/turf_decal/tile/dark_green/opposingcorners,"},
                    basic_Mixed_Corporations_crate_pool,
                    medbay_loot_pool,
                    medical_SYNDICATE_object_pool,
                    new String[]{"/obj/structure/table,","/obj/structure/table/reinforced,"});
            Area medical_CIN = new Area(
                    "/area/station/medical",
                    "/obj/machinery/door/airlock/survival_pod/glass,/obj/effect/mapping_helpers/airlock/autoname,",
                    pod_window_spawner,
                    spaceship_hull_wall_path,
                    medical_CIN_floor_pool,
                    basic_Mixed_Corporations_crate_pool,
                    medbay_loot_pool,
                    medical_CIN_object_pool,
                    new String[]{"/obj/structure/table,","/obj/structure/table/reinforced,"});
            Area medical_SpaceRuin = new Area(
                    "/area/station/medical",
                    "/obj/machinery/door/airlock/medical,/obj/effect/mapping_helpers/airlock/autoname,",
                    window_spawner,
                    wall_path,
                    new String[]{"/turf/open/floor/iron/white/small,"},
                    basic_Mixed_Corporations_crate_pool,
                    medbay_loot_pool,
                    medical_SpaceRuin_object_pool,
                    new String[]{"/obj/structure/table,","/obj/structure/table/reinforced,"});
            Area medical_MixedCorps = new Area(
                    "/area/station/medical",
                    "/obj/machinery/door/airlock/medical,/obj/effect/mapping_helpers/airlock/autoname,",
                    shuttle_window_spawner,
                    titanium_wall_path,
                    new String[]{"/turf/open/floor/mineral/titanium/tiled/white,/obj/effect/turf_decal/tile/blue/opposingcorners,",},
                    basic_Mixed_Corporations_crate_pool,
                    medbay_loot_pool,
                    medical_MixedCorps_object_pool,
                    new String[]{"/obj/structure/table,","/obj/structure/table/reinforced,"});
            //NT
            GLOBAL_VARS.list_of_styles[0].list_of_areas.add(generic_NT);
            GLOBAL_VARS.list_of_styles[0].list_of_areas.add(medical_NT);
            GLOBAL_VARS.list_of_styles[0].list_of_areas.add(engineering_NT);
            GLOBAL_VARS.list_of_styles[0].list_of_areas.add(security_NT);
            GLOBAL_VARS.list_of_styles[0].list_of_areas.add(bridge_NT);
            //SYNDICATE
            GLOBAL_VARS.list_of_styles[1].list_of_areas.add(generic_SYNDICATE);
            GLOBAL_VARS.list_of_styles[1].list_of_areas.add(medical_SYNDICATE);
            GLOBAL_VARS.list_of_styles[1].list_of_areas.add(engineering_SYNDICATE);
            GLOBAL_VARS.list_of_styles[1].list_of_areas.add(security_SYNDICATE);
            GLOBAL_VARS.list_of_styles[1].list_of_areas.add(bridge_SYNDICATE);
            //CIN/NRI(Nova/Skyrat)
            GLOBAL_VARS.list_of_styles[2].list_of_areas.add(generic_CIN);
            GLOBAL_VARS.list_of_styles[2].list_of_areas.add(medical_CIN);
            GLOBAL_VARS.list_of_styles[2].list_of_areas.add(engineering_CIN);
            GLOBAL_VARS.list_of_styles[2].list_of_areas.add(security_CIN);
            GLOBAL_VARS.list_of_styles[2].list_of_areas.add(bridge_CIN);
            //SpaceRuin
            GLOBAL_VARS.list_of_styles[3].list_of_areas.add(generic_SpaceRuin);
            GLOBAL_VARS.list_of_styles[3].list_of_areas.add(medical_SpaceRuin);
            GLOBAL_VARS.list_of_styles[3].list_of_areas.add(engineering_SpaceRuin);
            GLOBAL_VARS.list_of_styles[3].list_of_areas.add(security_SpaceRuin);
            GLOBAL_VARS.list_of_styles[3].list_of_areas.add(bridge_SpaceRuin);
            //MixedCorps(Nova/Skyrat)
            GLOBAL_VARS.list_of_styles[4].list_of_areas.add(generic_MixedCorps);
            GLOBAL_VARS.list_of_styles[4].list_of_areas.add(medical_MixedCorps);
            GLOBAL_VARS.list_of_styles[4].list_of_areas.add(engineering_MixedCorps);
            GLOBAL_VARS.list_of_styles[4].list_of_areas.add(security_MixedCorps);
            GLOBAL_VARS.list_of_styles[4].list_of_areas.add(bridge_MixedCorps);



        }

    }

}
