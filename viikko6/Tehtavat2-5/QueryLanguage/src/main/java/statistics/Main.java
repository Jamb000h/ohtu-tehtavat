package statistics;

import statistics.matcher.*;

public class Main {
    public static void main(String[] args) {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players.txt";

        Statistics stats = new Statistics(new PlayerReaderImpl(url));
        
        QueryBuilder query = new QueryBuilder();
          
//        Matcher m = new And( new HasAtLeast(5, "goals"),
//                             new HasAtLeast(5, "assists"),
//                             new PlaysIn("PHI")
//        );

//        Matcher m = query.build();
//        Matcher m = query.playsIn("NYR").build();

//        Matcher m = query.playsIn("NYR")
//                     .hasAtLeast(5, "goals")
//                     .hasFewerThan(10, "goals").build();

        //Matcher m1 = query.playsIn("PHI")
        //          .hasAtLeast(10, "assists")
        //          .hasFewerThan(5, "goals").build();
        //
        //Matcher m2 = query.playsIn("EDM")
        //          .hasAtLeast(40, "points").build();
        //
        //Matcher m = query.oneOf(m1, m2).build();

        Matcher m = query.oneOf(
            query.playsIn("PHI")
                .hasAtLeast(10, "assists")
                .hasFewerThan(5, "goals").build(),

            query.playsIn("EDM")
                .hasAtLeast(40, "points").build()
        ).build();

        
        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }
    }
}
