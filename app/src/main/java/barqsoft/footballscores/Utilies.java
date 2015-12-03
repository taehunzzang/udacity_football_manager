package barqsoft.footballscores;

import android.content.Context;
import android.util.Log;

/**
 * Created by yehya khaled on 3/3/2015.
 */
public class Utilies
{
    public static final int SERIE_A = 357;
    public static final int PREMIER_LEGAUE = 354;
    public static final int CHAMPIONS_LEAGUE = 362;
    public static final int PRIMERA_DIVISION = 358;
    public static final int BUNDESLIGA = 351;

    public static String getLeague(Context context, int league_num) {
        switch (league_num)
        {
            case SERIE_A : return context.getResources().getString(R.string.Seria_A);
            case PREMIER_LEGAUE : return context.getResources().getString(R.string.Premier_League);
            case CHAMPIONS_LEAGUE : return context.getResources().getString(R.string.UEFA_Champions_League);
            case PRIMERA_DIVISION : return context.getResources().getString(R.string.Primera_Division);
            case BUNDESLIGA : return context.getResources().getString(R.string.Bundesliga);
            default: return context.getResources().getString(R.string.Not_known_League_Please_report);
        }
    }
    public static String getMatchDay(Context context,int match_day,int league_num)
    {
        if(league_num == CHAMPIONS_LEAGUE)
        {
            if (match_day <= 6)
            {
                return context.getResources().getString(R.string.less6);
            }
            else if(match_day == 7 || match_day == 8)
            {
                return context.getResources().getString(R.string.from7to8);
            }
            else if(match_day == 9 || match_day == 10)
            {
                return context.getResources().getString(R.string.from9to10);
            }
            else if(match_day == 11 || match_day == 12)
            {
                return context.getResources().getString(R.string.from11to12);
            }
            else
            {
                return context.getResources().getString(R.string.Final);
            }
        }
        else
        {
            return context.getResources().getString(R.string.Matchday)+ String.valueOf(match_day);
        }
    }

    public static String getScores(int home_goals,int awaygoals)
    {
        if(home_goals < 0 || awaygoals < 0)
        {
            return " - ";
        }
        else
        {
            return String.valueOf(home_goals) + " - " + String.valueOf(awaygoals);
        }
    }

    public static int getTeamCrestByTeamName (Context context, String teamname)
    {
        if (teamname==null){return R.drawable.no_icon;}
        Log.e("","teamname : "+teamname+", "+context.getResources().getString(R.string.Arsenal_London_FC));
        if (teamname==context.getResources().getString(R.string.Arsenal_London_FC)){
            return R.drawable.arsenal;
        }else if(teamname==context.getResources().getString(R.string.Manchester_United_FC)){
            return R.drawable.manchester_united;
        }else if(teamname==context.getResources().getString(R.string.Swansea_City)){
            return R.drawable.swansea_city_afc;
        }else if(teamname==context.getResources().getString(R.string.Leicester_City)){
            return R.drawable.leicester_city_fc_hd_logo;
        }else if(teamname==context.getResources().getString(R.string.Everton_FC)){
            return R.drawable.everton_fc_logo1;
        }else if(teamname==context.getResources().getString(R.string.West_Ham_United_FC)){
            return R.drawable.west_ham;
        }else if(teamname==context.getResources().getString(R.string.Tottenham_Hotspur_FC)){
            return R.drawable.tottenham_hotspur;
        }else if(teamname==context.getResources().getString(R.string.West_Bromwich_Albion)){
            return R.drawable.west_bromwich_albion_hd_logo;
        }else if(teamname==context.getResources().getString(R.string.Sunderland_AFC)){
            return R.drawable.sunderland;
        }else if(teamname==context.getResources().getString(R.string.Stoke_City_FC)){
            return R.drawable.stoke_city;
        }else{
            return R.drawable.no_icon;
        }
    }
}
