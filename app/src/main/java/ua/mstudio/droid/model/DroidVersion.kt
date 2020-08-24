package ua.mstudio.droid.model

import ua.mstudio.droid.R

fun initDroid() : ArrayList<DroidVersion> {
    val droid : ArrayList<DroidVersion> = ArrayList()

    for (a in names.indices) {
        droid.add(
            DroidVersion(prefix[a], hostName + names[a], apiLevels[a], screens[a], dates[a])
        )
    }
    return droid
}

var prefix = arrayOf(
    "Apple Pie" ,"Banana Cake"          ,"Cupcake"      ,"Donut"        ,"Eclair"    ,
    "Eclair"    ,"Froyo"                ,"Gingerbread"  ,"Honeycomb"    ,"Honeycomb" ,
    "Honeycomb" ,"Ice Cream Sandwich"   ,"Jelly Bean"   ,"Jelly Bean"   ,"Jelly Bean",
    "KitKat"    ,"Lollipop"             ,"Lollipop"     ,"Marshmallow"  ,"Nougat"    ,
    "Nougat"    ,"Oreo"                 ,"Oreo"         ,"Pie"          ,"Q"         ,
    "R"
)

var hostName = "Android "

var names = arrayOf(
        "1.0","1.1","1.5","1.6","2.0",
        "2.1","2.2","2.3","3.0","3.1",
        "3.2","4.0","4.1","4.2","4.3",
        "4.4","5.0","5.1","6.0","7.0",
        "7.1","8.0","8.1","9  ","10 ",
        "11(R)"
    )

var apiLevels = arrayOf(
        1 ,2 ,3 ,4 ,5,
        6 ,8 ,9 ,11,12,
        13,14,15,16,17,
        19,21,22,23,24,
        25,26,27,28,29,
        30
)

var screens = arrayOf(
        0                   ,0                  ,R.drawable.droid15 ,R.drawable.droid16 ,R.drawable.droid20 ,
        R.drawable.droid21  ,R.drawable.droid22 ,R.drawable.droid23 ,R.drawable.droid30 ,0                  ,
        0                   ,R.drawable.droid40 ,R.drawable.droid41 ,0                  ,0                  ,
        R.drawable.droid44  ,R.drawable.droid50 ,0                  ,R.drawable.droid60 ,R.drawable.droid70 ,
        R.drawable.droid71  ,R.drawable.droid80 ,R.drawable.droid81 ,R.drawable.droid90 ,R.drawable.droid100,
        R.drawable.droid110
)

var dates = arrayOf(
    "September 23, 2008",   "February 9, 2009", "April 27, 2009",   "September 15, 2009",   "October 26, 2009",
    "October 26, 2009",     "May 20, 2010",     "December 6, 2010", "February 22, 2011",    "February 22, 2011",
    "February 22, 2011",    "October 18, 2011", "July 9, 2012",     "July 9, 2012",         "July 9, 2012",
    "October 31, 2013",     "November 12, 2014","November 12, 2014","October 5, 2015",      "August 22, 2016",
    "August 22, 2016",      "August 21, 2017",  "August 21, 2017",  "August 6, 2018",       "September 3, 2019",
    "September, 2020"
)

data class DroidVersion(
    var prefix : String,
    var name : String ,
    var apiLevel : Int,
    var screenshot : Int,
    var stableDate : String
)
