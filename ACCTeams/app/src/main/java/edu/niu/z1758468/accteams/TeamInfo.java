//////////////////////////////////////////////////////////////////////////////////////////
// CSCI 322         Program: 2     Spring 2016
// Name: Abe Rodriguez
// Date Due: 3/4/2016
// Purpose: This application demonstrates the Intent and widget features. The app contains
//          a few Intent functions and widgets.
//          Class TeamInfo stores the Team info (description and id picture.)
/////////////////////////////////////////////////////////////////////////////////////////

package edu.niu.z1758468.accteams;

/**
 * Created by aberodriguez on 2/20/16.
 */
public class TeamInfo
{
    // String description Array with a list of pictures
    public static String description[] =
            {
                    "Go Tar Heels!",
                    "Go Blue Devils!",
                    "Go Tigers!",
                    "Go Hurricanes!",
                    "The Fighting Irish!"
            };
    // Int id Array with a list of pictures
    public static int id[] =
            {
                    R.drawable.unc, R.drawable.duke,
                    R.drawable.clemson, R.drawable.miami,
                    R.drawable.nortedame
            };
    // String teamHistory Array with history of team.
    public static String teamHistory[] =
            {
                    "The North Carolina Tar Heels men's basketball program is the intercollegiate men's basketball team of the University of North Carolina at Chapel Hill. "+
                    "The Tar Heels have won five NCAA Tournament Championships (1957, 1982, 1993, 2005 and 2009) and were retroactively named the national champions by "+
                    "the Helms Athletic Foundation and the Premo-Porretta Power Poll for their undefeated season in 1924. North Carolina's five NCAA Tournament Championships"+
                    "are tied for third-most all-time.[citation needed] They have also won 17 Atlantic Coast Conference tournament titles and 29 Atlantic Coast Conference "+
                    "regular season titles (including an Atlantic Coast Conference record 19 outright Regular Season Championships). The program has produced many notable "+
                    "players who went on to play professionally, including three of the 50 Greatest Players in NBA History, Billy Cunningham, Michael Jordan and James Worthy. "+
                    "Many Tar Heel assistant coaches have gone on to become head coaches elsewhere.\n\n"+
                    "The Tar Heels are currently #3 on the Division I all-time wins list. From the Tar Heels' first season in 1910–11 through the 2012–13 season, the Tar Heels "+
                    "have amassed a .737 all-time winning percentage (second highest all-time), winning 2,090 games and losing 745 games in 103 seasons. The Tar Heels also "+
                    "have the most consecutive 20-win seasons, with 31 seasons from the 1970–71 season through the 2000–2001 season. On March 2, 2010, North Carolina became "+
                    "the second college basketball program to reach 2,000 wins in its history. The Tar Heels are currently ranked 3rd all time in wins trailing Kentucky by a "+
                    "total of 21 games and Kansas by a total of 10 games. The Tar Heels are one of only four Division I Men's Basketball programs to have ever achieved 2,000 "+
                    "victories. Kentucky, Kansas, and Duke are the other three.\n\n"+
                            "https://www.wikipedia.org",
                    "The Duke Blue Devils men's basketball team is the college basketball program representing Duke University. The team is fourth all-time in wins of any " +
                    "NCAA men's basketball program, and is coached by Mike Krzyzewski.\n" +
                    "Duke has won 5 NCAA Championships (tied with North Carolina and Indiana for third all-time behind UCLA and Kentucky) and appeared in 11 Championship Games" +
                    "(third all-time) and 16 Final Fours (fourth all-time behind North Carolina, UCLA, and Kentucky), and has an NCAA-best .755 NCAA tournament winning " +
                    "percentage. Eleven Duke players have been named the National Player of the Year, and 71 players have been selected in the NBA Draft. Additionally, Duke " +
                    "has 36 players named All-Americans (chosen 60 times) and 14 Academic All-Americans. Duke has been the Atlantic Coast Conference Champions a record 19 "+
                    "times, and also lays claim to 19 ACC regular season titles. Prior to joining the ACC, Duke won the Southern Conference championships five times. Duke has "+
                    "also finished the season ranked No. 1 in the AP poll seven times and is second, behind only UCLA, in total weeks ranked as the number one team in the " +
                    "nation by the AP with 121 weeks. Additionally, the Blue Devils have the second longest streak in the AP Top 25 in history with 200 consecutive "+
                    "appearances from 1996 to 2007, trailing only UCLA's 221 consecutive polls from 1966–1980. As a result of such success, ESPN, in 2008, named Duke " +
                    "the most prestigious college basketball program since the 1985-86 season, noting that \"by any measure of success, Duke is king of the hill in college "+
                    "basketball in the 64-team era of the NCAA tournament.\" Since that designation, Duke has won two additional national titles in 2010 and 2015.\n\n"+
                            "https://www.wikipedia.org",
                    "The Clemson Tigers men's basketball team is a college basketball program that represents Clemson University and competes in the National Collegiate "+
                    "Athletic Association Division I. Clemson is a founding member of the Atlantic Coast Conference.\n" + "\n" +
                    "Clemson sponsored its first men's basketball team in the 1911–12 season, winning its first conference championship in 1939, and in the Atlantic Coast "+
                    "Conference in 1990. The Tigers have reached the NCAA Tournament 11 times in the modern era (1980, 1987, 1989, 1990, 1996, 1997, 1998, 2008, 2009, 2010, 2011) "+
                    "since the tournament expansion in 1980, advancing to the NCAA Sweet 16 three times (1980, 1990, 1997), with their best performance reaching the Elite Eight "+
                    "that very same year.\n" + "\n" +
                    "Clemson's home court is Littlejohn Coliseum and has been the scene of 55 Clemson wins over ranked teams (23 in the Top 10) since 1968, including a victory "+
                    "over #1 Duke in 1980, a 75-65 victory over #1 North Carolina in 2001, and a 74-47 victory over #3 Duke in 2009. The Clemson basketball programs have won "+
                    "roughly 75% of their games played in Littlejohn, making it one of the ACC's toughest road venues.\n\n"+
                            "https://www.wikipedia.org",
                    "The Miami Hurricanes men's basketball team represents the University of Miami in the Atlantic Coast Conference (ACC).\n" + "\n" +
                    "The team began play in 1926, but was dropped by the University of Miami from 1971-1985. In 1985, the Hurricanes resumed play and joined the Big East "+
                    "Conference in 1991, winning the Big East regular season title in 2000. In 2004, in conjunction with the rest of the Miami athletic program, the team "+
                    "moved to the ACC. In 2012-2013, the team won its first regular season ACC championship as well as its first ACC tournament championship. The team has "+
                    "twice reached the NCAA Championship's \"Sweet 16\" (1999–2000 and 2012–2013). This past 2014-2015 season the Hurricanes finished with an overall record "+
                    "of 25-13 and an ACC record of 10-8. They did not reach the NCAA Tournament; however, they reached the final in the National Invitation Tournament (NIT)."+
                            "https://www.wikipedia.org",
                    "The men's basketball team, coached by Mike Brey since 2000, has made 28 NCAA Tournament appearances and made it to the Final Four in 1978 under coach Digger"+
                    "Phelps. They are also known for ending UCLA's 88-game winning streak in 1974, a streak which had begun after Notre Dame had previously ended UCLA's 45-game "+
                    "winning streak in 1971. Notre Dame won the 2015 ACC Tournament and advanced to the Elite Eight only to fall to top-ranked Kentucky 68-66.\n\n"+
                            "https://www.wikipedia.org"
            };
}
