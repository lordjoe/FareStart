package com.lordjoe.farestart;

import com.lordjoe.utilities.PseudoEnum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * com.lordjoe.spreadsheet.RestaurantLocation
 * This is a PseudoEnum so that future code cam expand the set without changing code
 * User: Steve
 * Date: 1/11/19
 */
public class  RestaurantLocation extends PseudoEnum<RestaurantLocation> {
    protected static final RestaurantLocation EXEMPLAR = new RestaurantLocation(EXAMPLAR_NAME,-1);

     private static Map<String,RestaurantLocation> gValuesByName = new HashMap<String,RestaurantLocation>();
    private static Map<Integer, RestaurantLocation> byId = new HashMap<>();
    private static Map<String, RestaurantLocation> byName = new HashMap<>();


    public static    RestaurantLocation[] values() {
        RestaurantLocation[] ret = new RestaurantLocation[gValuesByName.size()];
        int index = 0;
        for(RestaurantLocation r : gValuesByName.values())  {
           ret[index++] = r;
        }
        Arrays.sort(ret);
        return ret;
    }


    public RestaurantLocation getExemplar() {
        return EXEMPLAR;
    }

    public RestaurantLocation getValueOf(String name) {
        RestaurantLocation aClass = gValuesByName.get(name);
        if(aClass == null)
            throw new IllegalArgumentException("no value named " + name);
        return aClass;
    }

    public RestaurantLocation[] getValues() {
           return values();
    }

    protected void populateValues(String s) {
        throw new UnsupportedOperationException("Fix This"); // ToDo

    }

    public static RestaurantLocation MASLOWS = new  RestaurantLocation("Maslows",211) ;
    public static RestaurantLocation RISE_COFFEE = new  RestaurantLocation("Rise Coffee",212) ;
    public static RestaurantLocation COMMUNITY_SALAD = new  RestaurantLocation("Community Salad",213) ;
    public static RestaurantLocation COMMUNITY_SANTA_FE = new  RestaurantLocation("Maslows",214) ;
    public static RestaurantLocation COMMUNITY_BOWLS = new  RestaurantLocation("Maslows",215) ;
    public static RestaurantLocation FARESTART_CATERING = new  RestaurantLocation("Farestart Catering",221) ;
    public static RestaurantLocation PT_CAFE = new  RestaurantLocation("PT Café",235) ;
    public static RestaurantLocation CAFE_2100 = new  RestaurantLocation("2100 Café",232) ;
    public static RestaurantLocation GUEST_CHEF_NIGHT = new  RestaurantLocation("Guest Chef Night",261) ;
    public static RestaurantLocation SCHOOL_MEALS = new  RestaurantLocation("School Meals",271) ;
    public static RestaurantLocation COMMUNITY_MEALS = new  RestaurantLocation("Community Meals",232) ;
    public static RestaurantLocation COMMUNITY_TABLE = new  RestaurantLocation("Community Table",-1) ;

    public static final RestaurantLocation[] CommunityTables = {COMMUNITY_SALAD, COMMUNITY_SANTA_FE, COMMUNITY_BOWLS};


    public static RestaurantLocation byId(int id) {
        return byId.get(id);
    }

    public static RestaurantLocation get(String name) {
        RestaurantLocation ret = byName.get(name);
        return ret;
    }


    public final int id;

    RestaurantLocation(String name,int id) {
        super(name);
        this.id = id;
        if(!isExemplar())  {
            gValuesByName.put(name,this);
            if(name.contains("é")) {
                name = name.replace("é","e");
                gValuesByName.put(name,this);
            }
            gValuesByName.put(name.toLowerCase(),this);
            gValuesByName.put(name.toUpperCase(),this);
            gValuesByName.put(name.replace(" ","_").toUpperCase(),this);
            byId.put(id,this);
        }
    }






}
